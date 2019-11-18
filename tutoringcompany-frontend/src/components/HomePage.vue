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
            <router-link to="/ManagerHomePage" class="nav-link">Home</router-link>
            <span class="sr-only">(current)</span>
          </li>
          <li class="nav-item">
            <router-link to="/TutorsM" class="nav-link">Tutors</router-link>
          </li>
          <li class="nav-item">
            <router-link to="/StudentsM" class="nav-link">Students</router-link>
          </li>
          <li class="nav-item">
            <router-link to="/CoursesM" class="nav-link">
              Courses
            </router-link>
          </li>
          <li class="nav-ite">
            <router-link to="/RoomsM" class="nav-link">Rooms</router-link>
          </li>
          <li class="nav-item">
            <router-link to="/SessionsM" class="nav-link">Sessions</router-link>
          </li>
          <li class="nav-item">
            <router-link to="/AboutContact" class="nav-link">About &amp; Contact</router-link>
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
              Get started
              <i class="fa fa-caret-down"></i>
            </a>
            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
              <a class="dropdown-item" href="#">Book a session</a>
              <a class="dropdown-item" href="#">Work with us</a>
            </div>
          </li>
          <li>
          </li>
        </ul>
      </div>
      <!-- </div> uncomment to make the nav bar more narrow -->
    </nav>

    <!-- Page Content -->
    <div class="container">
      
      <h1 class="mt-4">Logo Nav by Start Bootstrap</h1>
      <p>The logo in the navbar is now a default Bootstrap feature in Bootstrap 4! Make sure to set the width and height of the logo within the HTML or with CSS. For best results, use an SVG image as your logo.</p>
    </div>
  </body>
</html>
</template>

<style>
</style>

<script>
export default {
  data() {
    return {};
  }
};
</script>
