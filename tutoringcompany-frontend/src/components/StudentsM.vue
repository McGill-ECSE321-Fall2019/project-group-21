<!DOCTYPE html>
<template>
<html lang="en">
  <head>
    <title>Manage Students</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
  </head>
  <body>
  <nav class="navbar navbar-expand-lg navbar-light bg-light static-top">
    <!-- <div class="container"> -->
    <a class="navbar-brand" href="#">
      <img
        alt="Brand"
        src="../assets/logo.png"
        class="image-responsive"
        style="max-width: 10%;overflow: visible;"
      />Quality over Quantity
    </a>
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
      <ul class="navbar-nav ml-auto">
        <li class="nav-item">
          <router-link to="/ManagerHomePage" class="nav-link">Manager Home</router-link>
        </li>
        <li class="nav-item">
          <router-link to="/TutorsM" class="nav-link">Tutors</router-link>
        </li>
        <li class="nav-item active">
          <router-link to="/StudentsM" class="nav-link">
            Students
            <span class="sr-only">(current)</span>
          </router-link>
        </li>
        <li class="nav-item">
          <router-link to="/CoursesM" class="nav-link">Courses</router-link>
        </li>
        <li class="nav-item">
          <router-link to="/RoomsM" class="nav-link">Rooms</router-link>
        </li>
        <li class="nav-item">
          <router-link to="/SessionsM" class="nav-link">Sessions</router-link>
        </li>
      </ul>
      <ul class="navbar-nav ml-auto">
        <li class="nav-item">
          <router-link to="/Manager" class="nav-link">Profile</router-link>
        </li>
        <li class="nav-item">
          <router-link to="/Logout" class="nav-link">Logout</router-link>
        </li>
      </ul>
    </div>
    <!-- </div> uncomment to make the nav bar more narrow -->
  </nav>
  <div class="jumbotron jumbotron-fluid">
    <div class="container">
      <h1 class="display-4">Students</h1>
      <p
        class="lead"
      >Gallery of all students, click on the name of any student to access and manage their profile.</p>
    </div>
  </div>
  <div class="container-fluid">
    <div class="row">
      <div v-for="student in students" class="col-12 col-md-6 col-lg-4 col-xl-3 mb-4">
        <div class="card mx-auto text-center">
          <div class="card-body">
            <h5 class="card-title">
              <router-link v-bind:to="'/' + student.email">{{ student.first_name }} {{student.last_name}}</router-link>
            </h5>
            <h6 class="card-subtitle mb-2 text-muted">Student</h6>
            <p
              class="card-text"
            >content.</p>
          </div>
          <ul class="list-group list-group-flush">
            <li class="list-group-item">Email: {{student.email}}</li>
            <li class="list-group-item">Phone: {{student.phone_number}}</li>
          </ul>
        </div>
      </div>
    </div>
  </div>
  </body>
</html>
</template>


<style>
.card {
  max-height: 100rem;
}
</style>