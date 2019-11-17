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
        <li class="nav-item active">
          <router-link to="/ManagerHomePage" class="nav-link">
            Manager Home
            <span class="sr-only">(current)</span>
          </router-link>
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

    <h1 id="greeting">Hi you have Secsessfully logged in</h1>
    <img src="../assets/quality.jpg" alt="logo" id="logo" />

    </body>
</html>
</template>

<style>
/* #greeting{
text-align: center;
}
#logo{
 margin-left: 30%;
}

#tutors{
 
  //--to be implemented
  }


.nav-link{
  font-size: 20px;
margin-left: 20px;


  
 
} */
</style>

<script>
// import jsPDF from "jspdf";
// import axios from "axios";
</script>