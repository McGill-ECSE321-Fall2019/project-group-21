<!DOCTYPE html>
<template>
<html lang="en">
  <head>
    <title>Home</title>
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
          <li class="nav-item active">
            <router-link to="/HomePage" class="nav-link">Home</router-link>
            <span class="sr-only">(current)</span>
          </li>
          <li class="nav-item">
            <router-link to="/Tutors" class="nav-link">Tutors</router-link>
          </li>
          <li class="nav-item">
            <router-link to="/Students" class="nav-link">Students</router-link>
          </li>
          <li class="nav-item">
            <router-link to="/Courses" class="nav-link">Courses</router-link>
          </li>

          <li class="nav-item">
            <router-link to="/AboutContact" class="nav-link">About &amp; Contact</router-link>
          </li>
        </ul>
        <!-- </div> uncomment for main links left justified-->
        <ul class="navbar-nav ml-auto">
          <li class="nav-item">
            <router-link to="/login" class="nav-link">Log in</router-link>
          </li>
          <li class="nav-item dropdown">
            <a
              class="nav-link"
              href="#"
              id="navbarDropdown"
              data-toggle="dropdown"
              aria-haspopup="true"
              aria-expanded="false"
            >
              Get started
              <i class="fa fa-caret-down"></i>
            </a>
            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
              <router-link to="/signup" class="dropdown-item">Book a session</router-link>
              <router-link to="/signup" class="dropdown-item">Work with us</router-link>
            </div>
          </li>
          <li></li>
        </ul>
      </div>
      <!-- </div> uncomment to make the nav bar more narrow -->
    </nav>

    <!-- Page Content -->

    <div class="jumbotron jumbotron-fluid" id="hero">
      <div class="container">
        <h1 class="display-4">Welcome to Quality Academy</h1>
      </div>
    </div>
    <div class="container">
      <div class="jumbotron">
        <h1 class="display-4">Our expert Tutors</h1>
        <p class="lead">Our vast selection of expert tutors are here to help students.</p>
        <p
          class="lead"
        >Our tutors are formers students themselves, so they understand the difficulties of education the best approaches to help their pupils learn quickly and effectively.</p>
        <hr class="my-4" />
        <p>Click here to browse our gallery of tutors!</p>
        <router-link class="btn btn-primary btn-lg" to="/Tutors" role="button">Browse</router-link>
      </div>
      <div class="jumbotron">
        <h1 class="display-4">You will see nothing but A+</h1>
        <p class="lead">
          Here at Quality Academy
          <i class="fa fa-copyright ml-1"></i>, we guarantee that our tutored students will see their grade increase by one letter grade in one month or your money-back!
        </p>
        <p
          class="lead"
        >Your or your child's success is our priority, and our staff members work around the clock to ensure that our students have access to the tutors they need, when they need them.</p>
        <hr class="my-4" />
        <p>Many of our students excel and finish their courses with 90% +, find out the difference that Quality tutoring can make in the academic life of our students</p>
        <router-link class="btn btn-primary btn-lg" to="/signup" role="button">Sign up</router-link>
      </div>
      <div class="jumbotron">
        <h1 class="display-4">We are hiring</h1>
        <p
          class="lead"
        >Are you a current or former student who is passionate about helping their peers, has found their academic strenghts, and want to gain real-life experience in the workfield of a company?</p>
        <p
          class="lead"
        >Apply now to become one of our tutors! One of our managers will review your application and then you will be ready to start tutoring.</p>
        <hr class="my-4" />
        <p>Simply fill out your contact information and sign up to get in touch with one of our managers</p>
        <router-link class="btn btn-primary btn-lg" to="/signup" role="button">Apply now</router-link>
      </div>
    </div>
  </body>
</html>
</template>

<style>
#hero {
  color: white;
  background-image: url("../assets/tutor.png");
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  height: 100vh;
}
</style>

<script>
export default {
  data() {
    return {};
  }
};
</script>
