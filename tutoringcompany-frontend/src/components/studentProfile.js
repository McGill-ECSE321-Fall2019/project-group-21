import axios from 'axios'
var config = require('../../config')

var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
var backendUrl = 'http://' + config.dev.backendHost + ':' + config.dev.backendPort

var AXIOS = axios.create({
    baseURL: backendUrl,
    headers: { 'Access-Control-Allow-Origin': frontendUrl }
})

export default {
    name: 'getStudent',
    data() {
        return {
            errorStudent: '',
            student: '',
            FirstName: '',
            LastName: '',
            phoneNumber: '',

        }
    },
    created: function () {
        var email = window.location.href.substring(36)
        AXIOS.post(`/Manager/get/Student` + "?email=" + email, {}, {})
            .then(response => {
                // JSON responses are automatically parsed.
                this.student = response.data
            });
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