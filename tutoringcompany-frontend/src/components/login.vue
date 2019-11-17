<!DOCTYPE html>
<template>
<html>
  <head>
    <title>Login Page</title>
    <!--Made with love by Mutiullah Samim -->

    <!--Bootsrap 4 CDN-->
    <link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
      integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
      crossorigin="anonymous"
    />

    <!--Fontawesome CDN-->
    <link
      rel="stylesheet"
      href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
      integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
      crossorigin="anonymous"
    />

    <!--Custom styles-->
    <link rel="stylesheet" type="text/css" href="styles.css" />
  </head>
  <body>
    <div class="container">
      <div class="d-flex justify-content-center h-100">
        <div class="card">
          <div class="card-header">
            <h3>Sign In</h3>
            <div class="d-flex justify-content-end social_icon">
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
                <input type="text" v-model="ManagerEmail" class="form-control" placeholder="Email" />
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

              <div class="form-group">
                <input
                  type="submit"
                  @click="managerLogin(ManagerEmail,ManagerPassword)"
                  value="Login"
                  class="btn float-right login_btn"
                />
              </div>
            </form>
          </div>
          <button @click="ManagerLogin(ManagerEmail,ManagerPassword)">Log in</button>
          <span v-if="errorLogin" style="color:red">Error: {{errorLogin}}</span>
		  <span v-if="response" style="color:green" href="/ManagerHomePage">Success: {{response}} 
			   </span>
          <div class="card-footer">
            <div class="d-flex justify-content-center links">
              Don't have an account?
              <a href="#">Sign Up</a>
            </div>
            <div class="d-flex justify-content-center">
              <a href="#">Forgot your password?</a>
            </div>
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
#login {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  color: #172431;
  font-size: 25px;
  background: #a7c5e0;
}
/* Made with love by Mutiullah Samim*/

@import url("https://fonts.googleapis.com/css?family=Numans");

html,
body {
  background-image: url("../assets/quality.jpg");
  background-size: auto;
  background-repeat: no-repeat;
  background-position-x: 20%;
  background-position-y: 0%;
  height: 100%;
  font-family: "Numans", sans-serif;
}

.container {
  height: 100%;
  align-content: center;
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
}
</style>