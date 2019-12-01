import axios from 'axios'
var config = require('../../config')

var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
var backendUrl = 'http://' + config.dev.backendHost + ':' + config.dev.backendPort

var AXIOS = axios.create({
    baseURL: backendUrl,
    headers: { 'Access-Control-Allow-Origin': frontendUrl }
})

export default {
    name: 'getStudents',
    data() {
        return {
            students: [],
            errorstudent: '',
            email: '',
            student: '',
        }
    },
    created: function () {
        // Initializing tutors from backend
        AXIOS.get(`/Manager/get/allStudents`)
            .then(response => {
                // JSON responses are automatically parsed.
                this.students = response.data
            })
            .catch(e => {
                this.errorPerson = e;
            });
    },
    methods: {
        getStudent: function (email) {
            AXIOS.get(`/Manager/get/allStudents`)
                .then(response => {
                    // JSON responses are automatically parsed.
                    this.student = response.data
                    window.location.href = "/#/studentPage/" + email

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


