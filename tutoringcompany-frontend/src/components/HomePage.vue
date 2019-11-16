<!DOCTYPE html>
<template>
<html lang="en">
  <head>
    <title>Home</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <!-- <link
      rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css"
    />-->
  </head>
  <body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light static-top">
      <!-- <div class="container"> -->
        <a class="navbar-brand" href="#">
          <img alt="Brand" src="../assets/logo.png" class="image-responsive" />Quality over Quantity
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
              <a class="nav-link" href="#">
                Home
                <span class="sr-only">(current)</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Tutors</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Courses</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">About</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Contact</a>
            </li>
          </ul>
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link" href="#">Book a Session</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Work with us</a>
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
/* Fixes dropdown menus placed on the right side */
.ml-auto .dropdown-menu {
  left: auto !important;
  right: 0px;
}
.navbar-brand img {
  max-width: 30%;
  overflow: visible;
}
</style>

<script>
export default {
  data() {
    return {};
  }
};
</script>
