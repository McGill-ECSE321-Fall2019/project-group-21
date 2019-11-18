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
            //if(isGroup=="option2"){
            AXIOS.post(`/Manager/Create/Room` + "?roomNumber=" + number + "&RoomTypeIsGroup=true", {}, {})
                .then(response => {
                    // JSON responses are automatically parsed.
                    this.room = response.data
                })
           // }
            if(isGroup="Individual Room"){
                AXIOS.post(`/Manager/Create/Room` + "?roomNumber=" + number + "&RoomTypeIsGroup=false", {}, {})
                .then(response => {
                    // JSON responses are automatically parsed.
                    this.room = response.data
                })
            }
        },
        getRoomsByType: function (isGroup) {
            AXIOS.post(`/Manager/get/RoomByType` + "?isGroupRoom=" + isGroup, {}, {})
                .then(response => {
                    // JSON responses are automatically parsed.
                    this.rooms = response.data
                })
        }
    }
}


