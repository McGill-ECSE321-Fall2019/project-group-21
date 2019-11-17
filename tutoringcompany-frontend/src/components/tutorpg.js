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
        tutor: '',
      }
    },
created: function () {
   var email = window.location.href.substring(34)
      AXIOS.post(`/Manager/get/Tutor/`+ "?email=" + email , {}, {})
      .then(response => {
        // JSON responses are automatically parsed.
        this.tutor = response.data
      });
    },
    methods: {
        verifyTutor: function(email){
            AXIOS.post(`/Manager/VerifyTutor`+ "?email=" + email , {}, {})
            .then(response => {
                // JSON responses are automatically parsed.
                this.tutor = response.data
              })
        }

    }

    }
  
