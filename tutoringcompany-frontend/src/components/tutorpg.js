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
        errorPerson: '',
        tutor: '',
        firstName: '',
        lastName: '',
        phoneNumber: '',

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
    },
  methods: {
    updateTutor: function(email,firstName){
        AXIOS.post(`/Manager/update/Tutor/FirstName` + "?firstName=" + firstName + "&email=" + email, {}, {})
            .then(response=>{
                this.response = response.data
    }
            )
 }
}
  }
  
