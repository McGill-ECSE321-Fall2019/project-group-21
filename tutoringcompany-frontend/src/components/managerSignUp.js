import axios from 'axios'
var config = require('../../config')

var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
var backendUrl = 'http://' + config.dev.backendHost + ':' + config.dev.backendPort

var AXIOS = axios.create({
    baseURL: backendUrl,
    headers: { 'Access-Control-Allow-Origin': frontendUrl }
  })
  
  export default {
    name: 'createManager',
    data() {
        return {
            firstName: '',
            lastName: '',
            email: '',
            phonenumber: '',
            password: '',
            errorSignUp: '',
            response: ''
        }
    },
    created: function () {
    },    
    methods: {
        createManager: function(firstName,lastName,email,phonenumber, password) {
            if (firstName == '') {
                var errorMsg = "first name is empty"
                console.log(errorMsg)
                this.errorSignUp = errorMsg
                return
            }
            if (lastName == '') {
                var errorMsg = "last name is empty"
                console.log(errorMsg)
                this.errorSignUp = errorMsg
                return
            }
            if (email == '') {
                var errorMsg = "email is empty"
                console.log(errorMsg)
                this.errorSignUp = errorMsg
                return
            }
            if (phonenumber == '') {
                var errorMsg = "phonenumber is empty"
                console.log(errorMsg)
                this.errorSignUp = errorMsg
                return
            }
            if (password == '') {
                var errorMsg = "password is empty"
                console.log(errorMsg)
                this.errorSignUp = errorMsg
                return
            }
            this.errorSignUp =''
                    AXIOS.post(`/Manager/Create` + "?firstName=" + firstName +"&lastName=" + lastName + "&email=" + email + "&phonenumber=" + phonenumber + "&password=" + password , {}, {})
            .then(response=>{
                this.response = response.data
                    console.log(this.response)
                    this.response = "New Manager is Created!"
                    this.firstName= ''
                    this.lastName= ''
                    this.email= ''
                    this.phonenumber= ''
                    this.password= ''
                    
            })
            .catch(e => {
                errorMsg = e.message
                console.log(errorMsg)
                this.errorSignUp = errorMsg
                this.response = ''
            });
        }
    }
  }
