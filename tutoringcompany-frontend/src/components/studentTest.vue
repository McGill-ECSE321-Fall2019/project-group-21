<template>
    <div id="student">
        <h1>our Students </h1>
        <div class="container-fluid">
          <div v-for="(student) in students">
              <div class="card" style="width: 14rem; color: #00000; ">
                <div class="card-body">
                    <h5 class="card-title">
                        <td >{{ student.first_name }} {{student.last_name}}</td>
                      </h5>
                    <p class="card-text">
                        <td>{{student.email}} {{email}}</td>
                       </p>
                      <button @click="getStudent(student.email)">Log in</button>
                    <a href="#" class="btn btn-primary" >checkout {{student.first_name}}</a>
                  </div>
              </div>
          </div>
         </div>
     </div>
</template>


<style>
  #student {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    color: #172431;
    font-size: 25px;
    background: #a7c5e0;
    grid-template-rows: min-content;
 
  }
</style>