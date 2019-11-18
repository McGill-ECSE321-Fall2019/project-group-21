import axios from 'axios'
var config = require('../../config')

var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
var backendUrl = 'http://' + config.dev.backendHost + ':' + config.dev.backendPort

var AXIOS = axios.create({
    baseURL: backendUrl,
    headers: { 'Access-Control-Allow-Origin': frontendUrl }
  })

  export default {
    name: 'getCourse',
    data () {
      return {
        courses: [],
        subject: '',
        errorCourse: '',
        selected: '',
        course: '',
        coursename: '',
        courseid: '',
      }
    },
created: function () {
    // Initializing tutors from backend
AXIOS.get(`/Manager/get/allCourses`)
.then(response => {
  // JSON responses are automatically parsed.
  this.courses = response.data
})
.catch(e => {
  this.errorCourse = e;
});
},
methods: {
    createCourse: function (coursename,courseid,selected) {
        if(this.selected=='Math'){
      AXIOS.post(`/Manager/Create/Course/Math`+ "?coursename=" + coursename + "&courseid=" + courseid , {}, {})
      .then(response => {
        // JSON responses are automatically parsed.
        this.course = response.data
      })
    }
       if(this.selected=='Physics'){
      AXIOS.post(`/Manager/Create/Course/Physics`+ "?coursename=" + coursename + "&courseid=" + courseid , {}, {})
      .then(response => {
        // JSON responses are automatically parsed.
        this.course = response.data
      })
     }
    if(this.selected=='Chemistry'){
        AXIOS.post(`/Manager/Create/Course/Chemistry`+ "?coursename=" + coursename + "&courseid=" + courseid , {}, {})
        .then(response => {
          // JSON responses are automatically parsed.
          this.course = response.data
        })
      }
      if(this.selected=="Biology"){
        AXIOS.post(`/Manager/Create/Course/Biology`+ "?coursename=" + coursename + "&courseid=" + courseid , {}, {})
        .then(response => {
          // JSON responses are automatically parsed.
          this.course = response.data
        })
    }
    if(this.selected=="Languages"){
        AXIOS.post(`/Manager/Create/Course/Languages`+ "?coursename=" + coursename + "&courseid=" + courseid , {}, {})
        .then(response => {
          // JSON responses are automatically parsed.
          this.course = response.data
        })
      }
      location.reload();
  }
}
}



  