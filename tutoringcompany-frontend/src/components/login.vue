<!DOCTYPE html>
<template>
<html>
  <head>
    <title>Login</title>

    <!--Custom styles-->
    <link rel="stylesheet" type="text/css" href="styles.css" />
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
          <li class="nav-item">
            <router-link to="/Rooms" class="nav-link">Rooms</router-link>
          </li>
          <li class="nav-item">
            <router-link to="/Sessions" class="nav-link">Sessions</router-link>
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

            </a>
            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
              <a class="dropdown-item" href="#"></a>
              <a @click="ManagerLogout()" class="dropdown-item"></a>
            </div>
          </li>
        </ul>
      </div>
      <!-- </div> uncomment to make the nav bar more narrow -->
    </nav>
    <div class="container">
      <div class="card my-4" style="width:70%; margin:0 auto;">
        <div class="card-header">
          <h3>Sign in</h3>
        </div>
        <div class="card-body">
          <form>
            <div class="form-group">
              <label for="exampleInputEmail1">Email address</label>
              <input
                v-model="ManagerEmail"
                type="email"
                class="form-control"
                id="exampleInputEmail1"
                aria-describedby="emailHelp"
                placeholder="Enter email"
              />
              <small
                id="emailHelp"
                class="form-text text-muted"
              >We'll never share your email with anyone else.</small>
            </div>
            <div class="form-group">
              <label for="exampleInputPassword1">Password</label>
              <input
                v-model="ManagerPassword"
                type="password"
                class="form-control"
                id="exampleInputPassword1"
                placeholder="Password"
              />
            </div>
            <div class="form-group form-check">
              <input type="checkbox" class="form-check-input" id="exampleCheck1" />
              <label class="form-check-label" for="exampleCheck1">Remember me</label>
            </div>
            <button  @click="ManagerLogin(ManagerEmail,ManagerPassword)" type="submit" class="btn btn-primary float-right">Sign in</button>
          </form>
        </div>
      </div>
    </div>
  </body>
</html>
</template>
<script src= "./managerLogin.js">
</script>
<style>
</style>