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
    <div class="bd-example">
      <div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
          <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
          <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
          <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
          <div class="carousel-item active" data-interval="5000">
            <img src="../assets/tutor.png" class="d-block w-100 slide-image" alt="..." />
            <div class="carousel-caption">
              <div class="jumbotron" id="slide-caption">
                <h2 class="display-4 label-title">Start moving that report card up the alphabet</h2>
                <p
                  class="lead label-body"
                >No matter your student's level, our tutors help them become a stronger learner at their pace, with the grades to prove it.</p>
                <hr class="my-4 bg-light" />
                <!-- <p>It uses utility classes for typography and spacing to space content out within the larger container.</p>
                <a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a> -->
              </div>
            </div>
          </div>
          <div class="carousel-item" data-interval="5000">
            <img src="../assets/distractedtutoring.png" class="d-block w-100 slide-image" alt="..." />
            <div class="carousel-caption">
              <div class="jumbotron" id="slide-caption">
                <h2 class="display-4 label-title">Certified Tutors to best suit your child's needs</h2>
                <p
                  class="lead label-body"
                >All of our tutors exceed rigorous application standards, and their experience equips your student with all the tools to succeed.</p>
                <hr class="my-4 bg-light" />
                <!-- <p>It uses utility classes for typography and spacing to space content out within the larger container.</p>
                <a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a> -->
              </div>
            </div>
          </div>
          <div class="carousel-item" data-interval="5000">
            <img src="../assets/room.png" class="d-block w-100 slide-image" alt="..." />
            <div class="carousel-caption">
              <div class="jumbotron" id="slide-caption">
                 <!-- d-none d-md-block -->
                <h2 class="display-4 label-title">Group sessions offered in rooms on site</h2>
                <p
                  class="lead label-body"
                >We offer group review sessions for upcoming exams where you child can collaborate with peers, guided by an expert tutor.</p>
                <hr class="my-4 bg-light" />
              </div>
            </div>
          </div>
        </div>
        <a
          class="carousel-control-prev"
          href="#carouselExampleCaptions"
          role="button"
          data-slide="prev"
        >
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a
          class="carousel-control-next"
          href="#carouselExampleCaptions"
          role="button"
          data-slide="next"
        >
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a>
      </div>
    </div>

    <!-- <div class="jumbotron jumbotron-fluid" id="hero">
      <div class="container">
        <h1 class="display-4">Welcome to Quality Academy</h1>
      </div>
    </div>-->
    <div class="container">
      <div class="jumbotron announcement">
        <h1 class="display-4">Our expert Tutors</h1>
        <p class="lead">Our vast selection of expert tutors are here to help students.</p>
        <p
          class="lead"
        >Our tutors are formers students themselves, so they understand the difficulties of education the best approaches to help their pupils learn quickly and effectively.</p>
        <hr class="my-4" />
        <p>Click here to browse our gallery of tutors!</p>
        <router-link class="btn btn-primary btn-lg float-right" to="/Tutors" role="button">Browse</router-link>
      </div>
      <div class="jumbotron announcement">
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
        <router-link class="btn btn-primary btn-lg float-right" to="/signup" role="button">Sign up</router-link>
      </div>
      <div class="jumbotron announcement">
        <h1 class="display-4">We are hiring</h1>
        <p
          class="lead"
        >Are you a current or former student who is passionate about helping their peers, has found their academic strenghts, and want to gain real-life experience in the workfield of a company?</p>
        <p
          class="lead"
        >Apply now to become one of our tutors! One of our managers will review your application and then you will be ready to start tutoring.</p>
        <hr class="my-4" />
        <p>Simply fill out your contact information and sign up to get in touch with one of our managers</p>
        <router-link class="btn btn-primary btn-lg float-right" to="/signup" role="button">Apply now</router-link>
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
#slide-caption {
  padding: 2rem 2rem;
  background-color:rgba(0, 0, 0, 0.40);
}

.slide-image {
  height: 85vh;
  object-fit: cover;
}

.announcement {
  padding: 4rem 2rem 5rem 2rem;
}

@media (max-width: 1199.98px) {
  .label-title {
    font-size: 2.5rem;
  }
}

@media (max-width: 991.98px) {
  .label-title {
    font-size: 2rem;
  }
  .label-body {
    font-size: 1rem;
  }
}

@media (max-width: 767.98px) {
  .label-body {
    display: none;
  }
}

.small-label {
    font-size: 2rem;
}
</style>

<script>
export default {
  data() {
    return {};
  }
};
</script>
