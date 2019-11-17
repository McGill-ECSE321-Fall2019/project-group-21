<template> 
<div id="id">

    <div class="site-section site-hero inner">
            <div class="container" align="center">
                <h2 align="center" class="page-title" >{{tutor.first_name}} {{tutor.last_name}}</h2>
                        <div id="table">
                          <div>Email: {{tutor.email}}</div> 
                          <div>Phone Number: {{tutor.phone_number}}</div> 
                          <div v-if ="tutor.verified"> VERIFIEDD YESS BITCHH </div>
                          <h1 v-else>Oh no 😢
                          <button @click="verifyTutor(tutor.email)"> verify Tutor  </button>
                                 </h1>
                          <input type="text" v-model="FirstName" placeholder="last Name"></td>
                          <button @click="updateTutorFirstName(tutor.email, FirstName)">update first name in</button>
                          <input type="text" v-model="LastName" placeholder="last Name"></td>
                          <button @click="updateTutorLastName(tutor.email, LastName)">update last name in</button>
                   
                        </div>
                        <span v-if="errorTutor" style="color:red">Error: {{errorTutor}} </span>
            </div>
        </div>

</div>
</template>
<script src="./tutorpg.js">
</script>