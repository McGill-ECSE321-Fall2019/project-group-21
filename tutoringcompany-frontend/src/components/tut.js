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
}
}