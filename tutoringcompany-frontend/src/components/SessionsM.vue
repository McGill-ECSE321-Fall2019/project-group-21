<!DOCTYPE html>
<template>
<html lang="en">
  <head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link
      rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css"
    />
  </head>

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
        <li class="nav-item active">
          <router-link to="/HomePage" class="nav-link">
            Home
            <span class="sr-only">(current)</span>
          </router-link>
        </li>
        <li class="nav-item">
          <router-link to="/Tutors" class="nav-link">Tutors</router-link>
        </li>
        <li class="nav-item">
          <router-link to="/Course" class="nav-link">Courses</router-link>
        </li>
        <li class="nav-item">
          <router-link to="/About" class="nav-link">About</router-link>
        </li>
        <li class="nav-item">
          <router-link to="/Contact" class="nav-link">Contact</router-link>
        </li>
      </ul>
      <ul class="navbar-nav ml-auto">
        <li class="nav-item">
          <router-link to="/StudentSignUp" class="nav-link">Book a Session</router-link>
        </li>
        <li class="nav-item">
          <router-link to="/TutorSignUp" class="nav-link">Work with us</router-link>
        </li>
      </ul>
    </div>
    <!-- </div> uncomment to make the nav bar more narrow -->
  </nav>

  <h1 id="greeting">Hi you have Secsessfully logged in</h1>

  <div class="container-fluid">
    <div class="row">
      <div v-for="session in sessions" class="col-6 col-md-4 col-lg-3 mb-4">
        <div class="card mx-auto text-center">
          <a href="#url">
            <img class="card-img-top" src="http://placehold.it/350x350" alt="Sample Title" />
          </a>
          <div class="card-body">
            <h2 class="card-title">
              <span class="fa fa-external-link mr-1"></span>
              <a href="#url">Sample Title</a>
            </h2>
          </div>
        </div>
      </div>
    </div>
  </div>
</html>
</template>

<script src="./tut.js">
</script>

<style>
.card-text {
  font-size: 20px;
}
.card {
  margin-left: 50px;
  margin-bottom: 10px;
}
.nav-link {
  font-size: 20px;

  margin-left: 20px;
}
.card-title {
  font-size: 25px;
  font-weight: bold;
}
</style>