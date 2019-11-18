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
            ManagerEmail: '',
            ManagerPassword: '',
            errorLogin: '',
            response: ''
        }
    },
    created: function () {
    },    
    methods: {
        ManagerLogin: function(ManagerEmail,ManagerPassword) {
            if (ManagerEmail == '') {
                var errorMsg = "Email is empty"
                console.log(errorMsg)
                this.errorLogin = errorMsg
                return
            }
            if (ManagerPassword == '') {
                var errorMsg = "Password is empty"
                console.log(errorMsg)
                this.errorLogin = errorMsg
                return
            }
            this.errorLogin =''
                    AXIOS.post(`/Manager/Login` + "?ManagerEmail=" + ManagerEmail +"&ManagerPassword=" + ManagerPassword , {}, {})
            .then(response=>{
                this.response = response.data
                    console.log(this.response)
                    this.response = "You're Loged in!"
                    this.ManagerEmail= ''
                    this.ManagerPassword= ''
                    window.location.href = "/#/managerhomepage"
                    
                    
            })
            .catch(e => {
                errorMsg = e.message
                console.log(errorMsg)
                this.errorLogin = errorMsg
                this.response = ''
            });
           
        }
    }
  }
