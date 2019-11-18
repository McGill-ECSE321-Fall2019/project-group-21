<!DOCTYPE html>
<template>
<html lang="en">
  <head>
    <title>Manage Sessions</title>
  </head>
  <body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light static-top">
      <!-- <div class="container"> -->
      <router-link
        to="/HomePage"
        class="navbar-brand mr-0"
        style="max-width:calc((1em + 1vw) * 7 + .5rem + 1vw + 30px);font-size:calc(1em + 1vw);"
      >
        <img
          alt="Brand"
          src="../assets/quality.png"
          class="image-responsive mr-2"
          style="max-width:calc(30px + 1vw);overflow: visible;"
        />Quality Academy
      </router-link>
      <button
        class="navbar-toggler"
        type="button"
        data-toggle="collapse"
        data-target="#navbarResponsive"
        aria-controls="navbarResponsive"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarResponsive">
        <!-- <div class="float-right"> -->
        <ul class="navbar-nav ml-auto">
          <li class="nav-item">
            <router-link to="/ManagerHomePage" class="nav-link">Manager Home</router-link>
          </li>
          <li class="nav-item">
            <router-link to="/TutorsM" class="nav-link">Tutors</router-link>
          </li>
          <li class="nav-item">
            <router-link to="/StudentsM" class="nav-link">Students</router-link>
          </li>
          <li class="nav-item">
            <router-link to="/CoursesM" class="nav-link">Courses</router-link>
          </li>
          <li class="nav-item">
            <router-link to="/RoomsM" class="nav-link">Rooms</router-link>
          </li>
          <li class="nav-item active">
            <router-link to="/SessionsM" class="nav-link">
              Sessions
              <span class="sr-only">(current)</span>
            </router-link>
          </li>
        </ul>
        <!-- </div> uncomment for main links left justified-->
        <ul class="navbar-nav ml-auto">
          <li class="nav-item dropdown">
            <a
              class="nav-link"
              href="#"
              id="navbarDropdown"
              data-toggle="dropdown"
              aria-haspopup="true"
              aria-expanded="false"
            >
              <i class="fa fa-user"></i>
              <i class="fa fa-caret-down"></i>
            </a>
            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
              <a class="dropdown-item" href="#">Profile</a>
              <a @click="ManagerLogout()" class="dropdown-item">Logout</a>
            </div>
          </li>
        </ul>
      </div>
      <!-- </div> uncomment to make the nav bar more narrow -->
    </nav>
    <div class="jumbotron jumbotron-fluid">
      <div class="container">
        <h1 class="display-4">Sessions</h1>
        <p
          class="lead"
        >Gallery of all sessions, view all sessions or pending sessions, and assign a room to any session by choosing from the dropdown.</p>
      </div>
    </div>
    <div class="container-fluid">
      <div class="row">
        <div v-for="session in sessions" class="col-12 col-md-6 col-lg-4 col-xl-3 mb-4">
          <div class="card mx-auto text-center">
            <div class="card-body">
              <h4 class="card-subtitle mb-2 text-muted">Session with {{session.students_Number}} students</h4>
              <p class="card-text"></p>
            </div>
            <ul class="list-group list-group-flush">
              <li class="list-group-item">{{session.start_time.slice(0,5)}} to {{session.end_time.slice(0,5)}} on {{session.date}}</li>
              <li class="list-group-item">
                Tutor:
                <router-link
                  v-bind:to="'/TutorPage/' + session.offeringDto.tutor.email"
                >{{ session.offeringDto.tutor.first_name }} {{session.offeringDto.tutor.last_name}}</router-link>
              </li>
              <li class="list-group-item">Course subject: {{session.offeringDto.course.subject}}</li>
              <li class="list-group-item">Course ID: {{session.offeringDto.course.course_id}}</li>
              <li class="list-group-item"># of students: {{session.students_Number}}</li>
              <li
                v-if="session.students_Number>1"
                class="list-group-item"
              >Cost: {{session.offeringDto.price_group}}$</li>
              <li v-else class="list-group-item">Cost: {{session.offeringDto.price_individual}}$</li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>
</template>
<script src="./pendingSession.js">
</script>
 
<style>
.card {
  max-height: 100rem;
}
</style>

