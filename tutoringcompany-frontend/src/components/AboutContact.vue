<!DOCTYPE html>
<template>
<html lang="en">
  <head>
    <title>Manage Rooms</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
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
            <router-link to="/HomePage" class="nav-link">Home</router-link>
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
          <li class="nav-ite">
            <router-link to="/Rooms" class="nav-link">Rooms</router-link>
          </li>
          <li class="nav-item">
            <router-link to="/Sessions" class="nav-link">Sessions</router-link>
          </li>
          <li class="nav-ite active">
            <router-link to="/AboutContact" class="nav-link">
              About &amp; Contact
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
              Get started
              <i class="fa fa-caret-down"></i>
            </a>
            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
              <a class="dropdown-item" href="#">Book a session</a>
              <a class="dropdown-item" href="#">Work with us</a>
            </div>
          </li>
        </ul>
      </div>
      <!-- </div> uncomment to make the nav bar more narrow -->
    </nav>
    <div class="jumbotron jumbotron-fluid">
      <div class="container">
        <h1 class="display-4">Welcome to Quality Academy</h1>
        <p class="lead">
          The Quality Academy Tutoring Company aims to provide students with the opportunity to connect with expert tutors in their field.
          As a new startup company (founded in 2019), our simple but efficient website and mobile interfaces allow easy access to our services.
          Students can find tutors at all levels of education (elementary school, high school, cegep and university) covering all subjects and courses.
          We strive to give students the education they deserve, and offer exciting opportunities for tutors to help their peers.
        </p>
      </div>
    </div>
    <div class="container">
      <div class="card text-center mx-auto mb-4 col-12">
        <div class="card-body">
          <h2 class="card-title">Contact Us</h2>
          <p
            class="card-text"
          >Please let us know about any questions or suggestions you may have about our services or website.</p>
          <p><i class="fa fa-phone mr-2"></i>+1 (438) 828 2332</p>
          <p><i class="fa fa-envelope mr-2"></i>support@qualityacademy.com</p>
          <p><i class="fa fa-map-marker mr-2"></i>3630 Rue University, Montréal, QC H3A 2B3</p>
          <button class="btn btn-primary mx-1" type="button">
            <a
              href="https://www.facebook.com/QualityAcademy/"
              style="color:inherit;text-decoration:inherit;"
              target="_blank"
            >
              Facebook
              <i class="fa fa-facebook ml-3"></i>
            </a>
          </button>
          <button class="btn btn-info mx-1" type="button">
            <a
              href="https://twitter.com/QualityAcademy/"
              style="color:inherit;text-decoration:inherit;"
              target="_blank"
            >
              Twitter
              <i class="fa fa-twitter ml-3"></i>
            </a>
          </button>
          <button class="btn btn-danger mx-1" type="button">
            <a
              href="mailto:customersupport@qualityacademy.com"
              style="color:inherit;text-decoration:inherit;"
              target="_blank"
            >
              Email
              <i class="fa fa-envelope ml-3"></i>
            </a>
          </button>
          <button class="btn btn-primary mx-1" type="button">
            <a
              href="https://www.google.com/maps/place/Trottier+Bldg,+3630+Rue+University,+Montreal,+QC+H3A+0C6/@45.5074121,-73.5800895,18z/data=!3m1!4b1!4m5!3m4!1s0x4cc91a3829eadafd:0x304925aa0c44027d!8m2!3d45.5074102!4d-73.5789952"
              style="color:inherit;text-decoration:inherit;"
              target="_blank"
            >
              Headquarters
              <i class="fa fa-map ml-3"></i>
            </a>
          </button>
          <img class="mt-4" src="../assets/map.png" alt="map" style="max-width:100%;">
        </div>
      </div>
    </div>
    <div class="container-fluid">
      <div class="row">
        <div v-for="room in rooms" class="col-12 col-md-6 col-lg-4 col-xl-3 mb-4">
          <div class="card mx-auto text-center">
            <div class="card-body">
              <h5 class="card-title">
                <router-link
                  v-bind:to="'/' + tutor.email"
                >{{ tutor.first_name }} {{tutor.last_name}}</router-link>
              </h5>
              <h6 class="card-subtitle mb-2 text-muted">Tutor</h6>
              <p
                class="card-text"
              >Some quick example text to build on the card title and make up the bulk of the card's content.</p>
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



<style>
.card {
  max-height: 100rem;
}
#btn {
  margin-left: 80%;
  margin-bottom: 10px;
}
</style>