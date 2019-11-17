<!DOCTYPE html>
<template>
  <html lang="en">

  <head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  </head>


<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <router-link to = '/ManagerHomePage' class="navbar-brand" href="#">Quality Academy</router-link>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
      <li class="nav-item">
        <router-link to="/TutorsM" class="nav-link" id="tutors">Tutors  </router-link>
      </li>

      <li class="nav-item">
        <router-link to = '/' class="nav-link"> Rooms </router-link>
      </li>
      <li class="nav-item">
        <router-link to = '/' class="nav-link" >Courses</router-link>
        
      </li>
      <li class="nav-item">
        <router-link to = '/' class="nav-link" >Students</router-link>
        
      </li>
      <li class="nav-item">
        <router-link to = '/' class="nav-link" >Sessions</router-link>
        
      </li>
      <li class="nav-item">
        <router-link to = '/' class="nav-link" >Managemet Settings</router-link>
        
      </li>
       <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Account
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="#">Logout</a>
          <a class="dropdown-item" href="#">Edit Profile</a>
        
        </div>
      </li>
    </ul>
    
  </div>
</nav>

<h1 id="greeting">Hi you have Secsessfully logged in</h1>
    
<div class="row">
  <div class="column">
    
       <div v-for="(tutor) in tutors">
              <div class="card" style="width: 30rem; color: #00000; ">
                <div class="card-body">
                    <h5 class="card-title">
                        <td >{{ tutor.first_name }} {{tutor.last_name}}</td>
                      </h5>
                    <p class="card-text">
                      {{ tutor.email }}
                </p>
                    <a href="#" class="btn btn-primary">checkout {{tutor.first_name}}</a>
                    <a href="#" class="btn btn-primary">Edit {{tutor.first_name}}</a>
                    <a href="#" class="btn btn-primary">Fire {{tutor.first_name}}</a>
                    
                  </div>
              </div>
          </div>


  </div>
</div>
    
    </html>
</template>



<style>
.card-text{
  font-size: 20px;
}
.card{
 margin-left: 50px;
 margin-bottom: 10px;
}
.nav-link{
  font-size: 20px;
 
margin-left: 20px;
}
.card-title{
    font-size: 25px;
font-weight: bold;
}
</style>