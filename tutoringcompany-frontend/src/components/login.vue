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
            <router-link to="/ManagerHomePage" class="nav-link">Manager Home</router-link>
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
              <i class="fa fa-user"></i>
              <i class="fa fa-caret-down"></i>
            </a>
            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
              <a class="dropdown-item" href="#">Profile</a>
              <a @click="ManagerLogout()" class="dropdown-item">Logout</a>
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
            <button type="submit" class="btn btn-primary float-right">Sign in</button>
          </form>
        </div>
      </div>
    </div>

    <div class="container">
      <div class="d-flex justify-content-center h-100">
        <div class="card">
          <div class="card-header">
            <h3>Sign In</h3>
            <div class="d-flex justify-content-end social_icon">
              <a href></a>
              <span>
                <i class="fab fa-facebook-square"></i>
              </span>
              <span>
                <i class="fab fa-google-plus-square"></i>
              </span>
              <span>
                <i class="fab fa-twitter-square"></i>
              </span>
            </div>
          </div>
          <div class="card-body">
            <form>
              <div class="input-group form-group">
                <div class="input-group-prepend">
                  <span class="input-group-text">
                    <i class="fas fa-user"></i>
                  </span>
                </div>
                <input type="email" v-model="ManagerEmail" class="form-control" placeholder="Email" />
              </div>
              <div class="input-group form-group">
                <div class="input-group-prepend">
                  <span class="input-group-text">
                    <i class="fas fa-key"></i>
                  </span>
                </div>
                <input
                  type="password"
                  v-model="ManagerPassword"
                  class="form-control"
                  placeholder="password"
                />
              </div>
              <div class="row align-items-center remember">
                <input type="checkbox" />Remember Me
              </div>
            </form>
          </div>
          <button
            @click="ManagerLogin(ManagerEmail,ManagerPassword)"
            class="btn float-right login_btn"
            id="btn"
          >Log in</button>
          <span v-if="errorLogin" style="color:red" id="errormsg">Error: {{errorLogin}}</span>
          <div class="card-footer">
            <!-- <div class="d-flex justify-content-center links">
					Don't have an account?<a href="#">Sign Up</a>
            </div>-->
            <!-- <div class="d-flex justify-content-center">
					<a href="#">Forgot your password?</a>
            </div>-->
            <p id="msg">if you forget your password contact our website developper on 4389883384</p>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>
</template>
<script src= "./managerLogin.js">
</script>
<style>
/* #login {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  color: #172431;
  font-size: 25px;
  background: #a7c5e0;
}

@import url("https://fonts.googleapis.com/css?family=Numans");

html,
body {
  background-image: url("../assets/quality.png");
  background-size: auto;
  background-repeat: no-repeat;
  background-position-x: 20%;
  background-position-y: 5%;
  height: 100%;
  font-family: "Numans", sans-serif;
}
#errormsg {
  text-align: center;
  margin-top: 20px;
}
#btn {
  margin-left: 60%;
}
.container {
  height: 100%;
  align-content: center;
}
#msg {
  text-align: center;
  font-size: 15px;
}
.card {
  height: 400px;
  margin-top: 10%;
  margin-left: 50%;
  margin-bottom: auto;
  width: 400px;
  background-color: rgba(0, 0, 0, 0.5) !important;
}

.card {
  height: 450px;
  margin-top: 10%;
  margin-left: 50%;
  margin-bottom: auto;
  width: 400px;
  background-color: rgba(0, 0, 0, 0.5) !important;
}

.social_icon span {
  font-size: 60px;
  margin-left: 10px;
  color: #ffc312;
}

.social_icon span:hover {
  color: white;
  cursor: pointer;
}

.card-header h3 {
  color: white;
}

.social_icon {
  position: absolute;
  right: 20px;
  top: -45px;
}

.input-group-prepend span {
  width: 50px;
  background-color: #ffc312;
  color: black;
  border: 0 !important;
}

input:focus {
  outline: 0 0 0 0 !important;
  box-shadow: 0 0 0 0 !important;
}

.remember {
  color: white;
}

.remember input {
  width: 20px;
  height: 20px;
  margin-left: 15px;
  margin-right: 5px;
}

.login_btn {
  color: black;
  background-color: #ffc312;
  width: 100px;
}

.login_btn:hover {
  color: black;
  background-color: white;
}

.links {
  color: white;
}

.links a {
  margin-left: 4px;
} */
</style>