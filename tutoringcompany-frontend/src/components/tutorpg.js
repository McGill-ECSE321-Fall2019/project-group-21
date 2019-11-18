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
    data() {
        return {
            errorTutor: '',
            tutor: '',
            FirstName: '',
            LastName: '',
            phoneNumber: '',

        }
    },
    created: function () {
        var email = window.location.href.substring(34)
        AXIOS.post(`/Manager/get/Tutor/` + "?email=" + email, {}, {})
            .then(response => {
                // JSON responses are automatically parsed.
                this.tutor = response.data
            });
    },
    methods: {
        verifyTutor: function (email) {
            AXIOS.post(`/Manager/VerifyTutor` + "?email=" + email, {}, {})
                .then(response => {
                    // JSON responses are automatically parsed.
                    this.tutor = response.data
                })
        },
        updateTutorFirstName: function (email, FirstName) {
            if (FirstName == '') {
                var errorMsg = "firstname is empty"
                console.log(errorMsg)
                this.errorTutor = errorMsg
                return
            }
            this.errorTutor =''
            AXIOS.post(`/Manager/update/Tutor/FirstName` + "?FirstName=" + FirstName + "&email=" + email, {}, {})
                .then(response => {
                    this.response = response.data
                    location.reload();

                })
        },
        updateTutorLastName: function (email, LastName) {
            if (LastName == '') {
                var errorMsg = "lastname is empty"
                console.log(errorMsg)
                this.errorTutor = errorMsg
                return
            }
            this.errorTutor =''
            AXIOS.post(`/Manager/update/Tutor/LastName` + "?LastName=" + LastName + "&email=" + email, {}, {})
                .then(response => {
                    this.response = response.data
                    location.reload();
                })
        },
         deleteTutor: function (email) {
         AXIOS.post(`/Manager/Delete/Tutor`+ "?email=" + email)
         .then(response => {
            // JSON responses are automatically parsed.
            this.response = response.data
        })
    }
    }
}

