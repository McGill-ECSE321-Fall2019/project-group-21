import Vue from 'vue'
import Router from 'vue-router'
import Hello from '@/components/Hello'
import TutoringCompany from '@/components/TutoringCompany'
import Login from '@/components/Login'
import ManagerSignUp from '@/components/ManagerSignUp'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Hello',
      component: Hello
    },
    {
      path: '/app',
      name: 'TutoringCompany',
      component: TutoringCompany
    },
  {
    
    path: '/login',
    name: 'Login',
    component: Login
  },
  {
    path: '/managersignup',
    name: 'ManagerSignUp',
    component: ManagerSignUp
  }
]
})
