import axios from 'axios'
var config = require('../../config')

var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
var backendUrl = 'http://' + config.dev.backendHost + ':' + config.dev.backendPort

var AXIOS = axios.create({
    baseURL: backendUrl,
    headers: { 'Access-Control-Allow-Origin': frontendUrl }
  })
  
  export default {
    name: 'ManagerLogin',
    data() {
        return {
            response: ''
        }
    },
    created: function () {
    },    
    methods: {
        ManagerLogout: function() {
                    AXIOS.post(`/Manager/Logout` , {}, {})
            .then(response=>{
                this.response = response.data
                    console.log(this.response)
                    this.response = "You're logged out!"
                    window.location.href = "/#/login"
                                      
            })       
        }
    }
  }
 