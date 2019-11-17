<!DOCTYPE html>
<template>
<html lang="en">
  <head>
    <title>Bootstrap Example</title>
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
        <li class="nav-item active">
          <router-link to="/TutorsM" class="nav-link">
            Tutors
            <span class="sr-only">(current)</span>
          </router-link>
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
      <h1 class="display-4">Tutors</h1>
      <p
        class="lead"
      >View the gallery of all tutors, click on the name of any tutor to access their profile.</p>
    </div>
  </div>
  <div class="container-fluid">
    <div class="row">
      <div v-for="tutor in tutors" class="col-6 col-md-4 col-lg-3 mb-4">
        <div class="card mx-auto text-center">
          <div class="card-body">
            <h5 class="card-title">
              <router-link v-bind:to="'/' + tutor.email">{{ tutor.first_name }} {{tutor.last_name}}</router-link>
            </h5>
            <h6 class="card-subtitle mb-2 text-muted">Tutor</h6>
            <p
              class="card-text"
            >Some quick example text to build on the card title and make up the bulk of the card's content.</p>
            <a href="#" class="card-link">Verify</a>
          </div>
          <ul class="list-group list-group-flush">
            <li class="list-group-item">Email: {{tutor.email}}</li>
            <li class="list-group-item">Phone: {{tutor.phone_number}}</li>
            <li class="list-group-item">Verified: {{tutor.verified}}</li>
          </ul>
        </div>
      </div>
    </div>
  </div>
  </body>
</html>
</template>

<script src="./tut.js">
</script>

<style>
.card {
  max-height: 100rem;
}
</style>