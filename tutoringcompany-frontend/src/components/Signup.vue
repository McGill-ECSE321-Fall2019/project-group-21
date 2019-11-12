 <template>
   <div id="Signup">
    <h1>Welcome to Quality over Quantity Tutoring Company</h1>
    
    <table>
        <h2>Sign Up </h2>
        <tr>
         <td>First Name:</td>
         <td><input type="text" v-model="firstName" placeholder="first name"></td>
      </tr>
      <tr>
         <td>Last Name:</td>
         <td><input type="text" v-model="lastName" placeholder="last name"></td>
      </tr>
      <tr>
         <td>Phone Number:</td>
         <td><input type="text" v-model="phonenumber" placeholder="phone number"></td>
      </tr>
        <tr>
          <td>Email:</td>
          <td><input type="text" v-model="email" placeholder="email"></td>
        </tr>
      <tr>
          <td>Password:</td>
          <td>
              <input type="password" v-model="password" placeholder="password">
          </td>
          <td>
              <button @click="createManager(firstName,lastName,email,phonenumber,password)">Sign Up</button>
              <a href="http://127.0.0.1:8087/#/" class="button">Go to Google</a>
          </td>
      </tr>
    </table>
    <p>
       <span v-if="errorSignUp" style="color:red">Error: {{errorSignUp}} </span>
       <span v-if="response" style="color:green">Success: {{response}} </span>
    </p>
   </div> 
 </template>
<script src="./managerSignUp.js">
</script>
<style>

  #Signup {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    color: #172431;
    font-size: 25px;
    background: #a7c5e0;
    text-align: inherit
  }
</style>