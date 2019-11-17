<template> 
<div id="id">

    <div class="site-section site-hero inner">
            <div class="container" align="center">
                <h2 align="center" class="page-title" >{{tutor.first_name}} {{tutor.last_name}}</h2>
                        <div id="table">
                          <div>Email: {{tutor.email}}</div> 
                          <div>Phone Number: {{tutor.phone_number}}</div> 
                          <div v-if ="tutor.verified"> VERIFIEDD YESS BITCHH </div>
                          <h1 v-else>Oh no 😢</h1>
                          <button @click="verifyTutor(tutor.email)"> verify Tutor  </button>
                        </div>
            </div>
        </div>

</div>
</template>
<script src="./tutorpg.js">
</script>