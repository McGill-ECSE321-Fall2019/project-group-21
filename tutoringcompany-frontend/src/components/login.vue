<template>
  <div id="login">
    <h1>Welcome to Quality over Quantity Tutoring Company</h1>
    
    <table>
        <h2>Login</h2>
      <tr>
          <td>Email:</td>
          <td><input type="text" v-model="ManagerEmail" placeholder="email"></td>
      </tr>
      <tr>
          <td>Password:

          </td>
          <td>
              <input type="password" v-model="ManagerPassword" placeholder="password">
          </td>
          <td>
              <button @click="ManagerLogin(ManagerEmail,ManagerPassword)">Log in</button>
              <a href="http://127.0.0.1:8087/#/" class="button">Go to Google</a>
          </td>
      </tr>
    </table>
    <p>
      <span v-if="errorLogin" style="color:red">Error: {{errorLogin}} </span>
       <span v-if="response" style="color:green">Success: {{response}} </span>
    </p>
  </div>
</template>
<script src= "./managerLogin.js">
</script>
<style>
  #login {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    color: #172431;
    font-size: 25px;
    background: #a7c5e0;
  }
</style>