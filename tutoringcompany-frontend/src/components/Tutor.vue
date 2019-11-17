<template>
    <div id="tutors">
        <h1>our tutors </h1>
        <div class="container-fluid">
          <td v-for="(tutor) in tutors">
              <div class="card" style="width: 14rem; color: #00000; "> 
                <div class="card-body">
                    <h5 class="card-title">
                        <td >{{ tutor.first_name }} {{tutor.last_name}}</td>
                      </h5>
                    <p class="card-text">
                        <td>{{tutor.email}} {{email}}</td>
                       </p>
                      <button @click="getTutor(tutor.email)">Log in</button>
                    <a href="#" class="btn btn-primary" >checkout {{tutor.first_name}}</a>
                  </div>
              </div>
          </td>
         </div>
     </div>
</template>

<script src="./tut.js">
</script>

<style>
  #tutors {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    color: #172431;
    font-size: 25px;
    background: #a7c5e0;
    grid-template-rows: min-content;
 
  }
</style>