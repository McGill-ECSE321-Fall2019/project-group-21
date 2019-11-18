import Vue from 'vue'
import Router from 'vue-router'
import Hello from '@/components/Hello'
import TutoringCompany from '@/components/TutoringCompany'
import Login from '@/components/Login'
import Signup from '@/components/Signup'
import HomePage from '@/components/HomePage'
import ManagerHomePage from '@/components/ManagerHomePage'
import TutorsM from '@/components/TutorsM'
import StudentsM from '@/components/StudentsM'
import TutorPage from '@/components/TutorPage'
import StudentPage from '@/components/StudentPage'
import studentTest from '@/components/studentTest'
import RoomsM from '@/components/RoomsM'
import RoomTest from '@/components/RoomTest'


Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Hello',
      component: Hello
    },
    {
      path: '/tutoringcompany',
      name: 'TutoringCompany',
      component: TutoringCompany
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/RoomsM',
      name: 'RoomsM',
      component: RoomsM
    },
    {

      path: '/HomePage',
      name: 'HomePage',
      component: HomePage
    },
    {

      path: '/ManagerHomePage',
      name: 'ManagerHomePage',
      component: ManagerHomePage
    },
    {
      path: '/TutorsM',
      name: 'TutorsM',
      component: TutorsM
    },
    {
      path: '/StudentsM',
      name: 'StudentsM',
      component: StudentsM
    },
    {
      path: '/signup',
      name: 'Signup',
      component: Signup
    },
    {
      path: '/tutorPage/:id',
      name: 'TutorPage',
      component: TutorPage
    },
    {
      path: '/studentPage/:id',
      name: 'StudentPage',
      component: StudentPage
    },
    {
      path: '/studentTest',
      name: 'studentTest',
      component: studentTest
    },
    {
      path: '/roomTest',
      name: 'RoomTest',
      component: RoomTest
    }
  ]
})
