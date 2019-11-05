import Vue from 'vue'
import Router from 'vue-router'
import Hello from '@/components/Hello'
import TutoringCompany from '@/components/TutoringCompany'

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
    }
  ]
})
