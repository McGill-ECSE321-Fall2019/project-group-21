<template>
  <div id="MainPage">
    <h1>Welcome to Quality over Quantity Tutoring Company</h1>
    <div id="Options"> 
      <tr>
      <td>
      <a href="http://127.0.0.1:8087/#/" class="button">Our Tutors</a>
      </td>
      <td> &nbsp;&nbsp;&nbsp;&nbsp;
        </td>
      <td>
      <a href="http://127.0.0.1:8087/#/" class="button">Our Course</a>
      </td>
      </tr>
    </div>    
    <table>
        <h2>Login</h2>
      <tr>
          <td>Email:</td>
          <td><input type="text" v-model="email" placeholder="email"></td>
      </tr>
      <tr>
          <td>Password:
          </td>
          <td>
              <input type="password" v-model="password" placeholder="password">
          </td>
      </tr>
          <td>
              <a href="http://127.0.0.1:8087/#/login" class="button">Log in as a manager</a>
          </td>
      
    </table>
    <p>
      <span style="color:red">Error: Message text comes here</span>
    </p>
  </div>
  
</template>
<script>
</script>
<style>

  #MainPage {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    color: #172431;
    font-size: 25px;
    background: #a7c5e0;
    text-align: inherit
  }

  #Options{
    display: grid;
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    color: #1a7ee2;
    font-size: 40px;
    background: #a7c5e0;
    text-align: inherit
  }
</style>