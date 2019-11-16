<template>
    <div id="tutors">
        <td v-for="(tutor) in tutors">
            <h1>our tutors </h1>
            <div class="card" style="width: 14rem; color: #00000; ">
              <div class="card-body">
                  <h5 class="card-title">
                      <td >{{ tutor.first_name }} {{tutor.last_name}}</td>
                     </h5>
                  <p class="card-text">
                      <td>{{ tutor.email }}</td>
                     </p>
                  <a href="#" class="btn btn-primary">checkout {{tutor.first_name}}</a>
                 </div>
             </div>
         </td>
     </div>
</template>