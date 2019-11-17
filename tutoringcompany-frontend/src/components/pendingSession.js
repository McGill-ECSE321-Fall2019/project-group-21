import axios from 'axios'
var config = require('../../config')

var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
var backendUrl = 'http://' + config.dev.backendHost + ':' + config.dev.backendPort

var AXIOS = axios.create({
    baseURL: backendUrl,
    headers: { 'Access-Control-Allow-Origin': frontendUrl }
})

export default {
    name: 'getPendingSession',
    data() {
        return {
            sessions: [],
            session: '',
            errorSession: '',
            tutorEmail: '',
            roomNumber: '',
            sartingTime: '',
        }
    },
    created: function () {
        // Initializing Sessions from backend
        AXIOS.get(`/Manager/get/PendingSessions`)
            .then(response => {
                // JSON responses are automatically parsed.
                this.sessions = response.data
            })
            .catch(e => {
                this.errorSession = e;
            });
    },
    methods: {
        confirmSession: function (tutorEmail, roomNumber, sartingTime) {
            AXIOS.post(`/Manager/confirm/session` + "?sartingTime=" + sartingTime + "&roomNumber=" + roomNumber + "&tutorEmail=" + tutorEmail)
                .then(response => {
                    // JSON responses are automatically parsed.
                    this.response = response.data

                })
        },
        deleteSession: function (tutorEmail, sartingTime) {
            AXIOS.post(`/Manager/confirm/session` + "?sartingTime=" + sartingTime + "&tutorEmail=" + tutorEmail)
                .then(response => {
                    // JSON responses are automatically parsed.
                    this.response = response.data

                })
        },
        getAllSession: function (tutorEmail, sartingTime) {
            AXIOS.post(`/Manager/get/allSessions`)
                .then(response => {
                    // JSON responses are automatically parsed.
                    this.sessions = response.data

                })

        }
    }
}
