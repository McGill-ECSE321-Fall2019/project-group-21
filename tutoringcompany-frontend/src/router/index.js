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
import CoursesM from '@/components/CoursesM'
import SessionsM from '@/components/SessionsM'
import RoomTest from '@/components/RoomTest'
import AboutContact from '@/components/AboutContact'

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
      path: '/SessionsM',
      name: 'SessionsM',
      component: SessionsM
    },
    {
      path: '/RoomsM',
      name: 'RoomsM',
      component: RoomsM
    },
    {
      path: '/CoursesM',
      name: 'CoursesM',
      component: CoursesM
    },
    {

      path: '/HomePage',
      name: 'HomePage',
      component: HomePage
    },
    {

      path: '/AboutContact',
      name: 'AboutContact',
      component: AboutContact
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
