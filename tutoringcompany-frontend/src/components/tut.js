import axios from 'axios'
var config = require('../../config')

var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
var backendUrl = 'http://' + config.dev.backendHost + ':' + config.dev.backendPort

var AXIOS = axios.create({
    baseURL: backendUrl,
    headers: { 'Access-Control-Allow-Origin': frontendUrl }
  })

  export default {
    name: 'getTutors',
    data () {
      return {
        tutors: [],
        newPerson: '',
        errorPerson: '',
        email: '',
        tutor: '',
      }
    },
created: function () {
    // Initializing tutors from backend
AXIOS.get(`/Manager/get/allTutors`)
.then(response => {
  // JSON responses are automatically parsed.
  this.tutors = response.data
})
.catch(e => {
  this.errorPerson = e;
});
},
methods: {
  getTutor: function (email) {
      AXIOS.post(`/Manager/get/Tutor/`+ "?email=" + email , {}, {})
      .then(response => {
        // JSON responses are automatically parsed.
        this.tutor = response.data
        window.location.href = "/#/tutorPage/"+ email
      })
    },
    ManagerLogout: function () {
      AXIOS.post(`/Manager/Logout`, {}, {})
          .then(response => {
              this.response = response.data
              console.log(this.response)
              this.response = "You're logged out!"
              window.location.href = "/#/login"

          })
  }
  }
}


  