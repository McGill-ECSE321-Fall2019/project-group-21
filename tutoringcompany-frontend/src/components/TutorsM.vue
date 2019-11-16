<!DOCTYPE html>
<template>
  <html lang="en">

  <head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  </head>

  <body>
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

<h1 id="greeting">Hi you have nonon logged in</h1>
<button type="button" class="btn btn-secondary" data-toggle="tooltip" data-placement="top" title="Tooltip on top">
  Tooltip on top
</button>
<button type="button" class="btn btn-secondary" data-toggle="tooltip" data-placement="right" title="Tooltip on right">
  Tooltip on right
</button>
<button type="button" class="btn btn-secondary" data-toggle="tooltip" data-placement="bottom" title="Tooltip on bottom">
  Tooltip on bottom
</button>
<button type="button" class="btn btn-secondary" data-toggle="tooltip" data-placement="left" title="Tooltip on left">
  Tooltip on left
</button>

</body>

</html>
</template>

<style>
.btn btn-secondary{
font-size: 90px;
}
#greeting{
text-align: center;
}
#logo{
 margin-left: 30%;
}

#tutors{
/* 
  --to be implemented */
  }


.nav-link{
  font-size: 20px;
margin-left: 20px;


  
 
}

</style>

<script>
  import jsPDF from 'jspdf';
  import axios from 'axios'
  
</script>