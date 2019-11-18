 <template>
   <div id="Signup">
    <h1>Welcome to Quality over Quantity Tutoring Company</h1>
    
    <table>
        <h2>Sign Up </h2>
        <tr>
         <td>First Name:</td>
         <td><input type="text" v-model="number" placeholder="number "></td>
      </tr>
      <tr>
         <td>Last Name:</td>
         <td><input type="text" v-model="isGroup" placeholder="isGroup"></td>
      </tr>
          <td>
              <button @click="CreatRoom(number,isGroup)">Sign Up</button>
              <a href="http://127.0.0.1:8087/#/" class="button">Go to Google</a>
          </td>
    </table><div v-for="room in rooms" class="col-6 col-md-4 col-lg-3 mb-4">
    <p>
        {{room.number}}
        {{room.roomType}}
    </p>
    </div>
    
   </div> 
 </template>
<script src="./room.js">
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