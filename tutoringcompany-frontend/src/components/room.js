import axios from 'axios'
var config = require('../../config')

var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
var backendUrl = 'http://' + config.dev.backendHost + ':' + config.dev.backendPort

var AXIOS = axios.create({
    baseURL: backendUrl,
    headers: { 'Access-Control-Allow-Origin': frontendUrl }
})

export default {
    name: 'getRooms',
    data() {
        return {
            rooms: [],
            number: '',
            type: '',
            errorRoom: '',
            room: '',
            isGroup: '',
        }
    },
    created: function () {
        // Initializing tutors from backend
        AXIOS.get(`/Manager/get/allRooms`)
            .then(response => {
                // JSON responses are automatically parsed.
                this.rooms = response.data
            })
            .catch(e => {
                this.errorRoom = e;
            });
    },
    methods: {
        CreatRoom: function (number) {
            if(this.isGroup=="option2"){
            AXIOS.post(`/Manager/Create/Room` + "?roomNumber=" + number + "&RoomTypeIsGroup=true", {}, {})
                .then(response => {
                    // JSON responses are automatically parsed.
                    this.room = response.data
                })
                location.reload();
            }
            if(this.isGroup=="option1"){
                AXIOS.post(`/Manager/Create/Room` + "?roomNumber=" + number + "&RoomTypeIsGroup=false", {}, {})
                .then(response => {
                    // JSON responses are automatically parsed.
                    this.room = response.data
                })
                location.reload();
            }
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


