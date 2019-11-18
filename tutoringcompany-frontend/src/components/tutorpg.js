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
            tutorReviews: [],
            reviewId: '',
            body: '',
            id: '',


        }
    },
    created: function () {
        var email = window.location.href.substring(34)
        AXIOS.post(`/Manager/get/Tutor/` + "?email=" + email, {}, {})
            .then(response => {
                // JSON responses are automatically parsed.
                this.tutor = response.data
            });
    AXIOS.get(`get/Tutor/Reviews` + "?tutorEmail=" + window.location.href.substring(34))
            .then(response => {
                // JSON responses are automatically parsed.
                this.tutorReviews = response.data
            })
        },
    methods: {
        verifyTutor: function (email) {
            AXIOS.post(`/Manager/VerifyTutor` + "?email=" + email, {}, {})
                .then(response => {
                    // JSON responses are automatically parsed.
                    this.tutor = response.data
                })
        },
        getId: function (id){
        this.reviewId = id
        },
        updateTutorReviews: function (body) {
            if (body == '') {
                var errorMsg = "body is empty"
                console.log(errorMsg)
                this.errorTutor = errorMsg
                return
            }
            this.errorTutor = ''
            AXIOS.post(`Manager/update/Tutor/Reviews` + "?id=" + this.reviewId + "&body=" + body, {}, {})
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
            this.errorTutor = ''
            AXIOS.post(`/Manager/update/Tutor/LastName` + "?LastName=" + LastName + "&email=" + email, {}, {})
                .then(response => {
                    this.response = response.data
                    location.reload();
                })
        },
        deleteTutor: function (email) {
            AXIOS.post(`/Manager/Delete/Tutor` + "?email=" + email)
                .then(response => {
                    // JSON responses are automatically parsed.
                    this.response = response.data
                    window.location.href = "/#/TutorsM/"
                    location.reload();
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

