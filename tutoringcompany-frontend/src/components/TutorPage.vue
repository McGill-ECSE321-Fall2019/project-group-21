<template>
<body>
  <nav class="navbar navbar-expand-lg navbar-light bg-light static-top">
    <!-- <div class="container"> -->
    <router-link
      to="/HomePage"
      class="navbar-brand mr-0"
      style="max-width:calc((1em + 1vw) * 7 + .5rem + 1vw + 30px);font-size:calc(1em + 1vw);"
    >
      <img
        alt="Brand"
        src="../assets/quality.png"
        class="image-responsive mr-2"
        style="max-width:calc(30px + 1vw);overflow: visible;"
      />Quality Academy
    </router-link>
    <button
      class="navbar-toggler"
      type="button"
      data-toggle="collapse"
      data-target="#navbarResponsive"
      aria-controls="navbarResponsive"
      aria-expanded="false"
      aria-label="Toggle navigation"
    >
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarResponsive">
      <!-- <div class="float-right"> -->
      <ul class="navbar-nav ml-auto">
        <li class="nav-item">
          <router-link to="/ManagerHomePage" class="nav-link">Manager Home</router-link>
        </li>
        <li class="nav-item active">
          <router-link to="/TutorsM" class="nav-link">
            Tutors
            <span class="sr-only">(current)</span>
          </router-link>
        </li>
        <li class="nav-item">
          <router-link to="/StudentsM" class="nav-link">Students</router-link>
        </li>
        <li class="nav-item">
          <router-link to="/CoursesM" class="nav-link">Courses</router-link>
        </li>
        <li class="nav-item">
          <router-link to="/RoomsM" class="nav-link">Rooms</router-link>
        </li>
        <li class="nav-item">
          <router-link to="/SessionsM" class="nav-link">Sessions</router-link>
        </li>
      </ul>
      <!-- </div> uncomment for main links left justified-->
      <ul class="navbar-nav ml-auto">
        <li class="nav-item dropdown">
          <a
            class="nav-link"
            href="#"
            id="navbarDropdown"
            data-toggle="dropdown"
            aria-haspopup="true"
            aria-expanded="false"
          >
            <i class="fa fa-user"></i>
            <i class="fa fa-caret-down"></i>
          </a>
          <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
            <a class="dropdown-item" href="#">Profile</a>
            <a @click="ManagerLogout()" class="dropdown-item">Logout</a>
          </div>
        </li>
      </ul>
    </div>
    <!-- </div> uncomment to make the nav bar more narrow -->
  </nav>

  <div id="id">
    <div class="jumbotron jumbotron-fluid">
      <div class="container">
        <h1 class="display-4">{{tutor.first_name}} {{tutor.last_name}}</h1>
      </div>
    </div>

    <div class="container-fluid">
      <div class="row">
        <div
          class="col-12 col-md-5 col-lg-4 col-xl-3 mx-auto d-none d-md-block position-fixed"
          id="sticky-sidebar"
        >
          <!-- <div class="sticky-top"> -->
          <div class="card mx-auto">
            <div class="card-body">
              <h5 class="card-title">{{ tutor.first_name }} {{tutor.last_name}}</h5>
              <h6 class="card-subtitle mb-2 text-muted">
                Tutor
                <span v-if="tutor.verified" class="badge badge-pill badge-success">
                  Verified
                  <i class="fa fa-check ml-1"></i>
                </span>
              </h6>
              <p class="card-text"></p>
            </div>
            <ul class="list-group list-group-flush">
              <li class="list-group-item">Email: {{tutor.email}}</li>
              <li class="list-group-item">Phone #: {{tutor.phone_number}}</li>
              <li class="list-group-item">Verified: {{tutor.verified}}</li>
              <li class="list-group-item" v-if="tutor.verified">
                <button
                  v-if="tutor.verified"
                  @click="deleteTutor(tutor.email)"
                  class="btn btn-block btn-danger"
                  type="button"
                >
                  
                      Fire
                      <i class="fa fa-fire ml-3"></i>
                    
                </button>
              </li>
              <li v-if="!tutor.verified" class="list-group-item">
                <button
                  type="button"
                  class="btn btn-block btn-success"
                  @click="verifyTutor(tutor.email)"
                >
                  Hire
                  <i class="fa fa-briefcase ml-3"></i>
                </button>
              </li>
            </ul>
          </div>
        </div>

        <div
          class="col-12 col-md-7 col-lg-8 col-xl-9 offset-sm-0 offset-md-5 offset-lg-4 offset-xl-3"
          id="main"
        >
          <div class="card mx-auto mb-4 d-md-none">
            <div class="card-body">
              <h5 class="card-title">{{ tutor.first_name }} {{tutor.last_name}}</h5>
              <h6 class="card-subtitle mb-2 text-muted">
                Tutor
                <span v-if="tutor.verified" class="badge badge-pill badge-success">Verified ✔</span>
              </h6>
              <p class="card-text"></p>
            </div>
            <ul class="list-group list-group-flush">
              <li class="list-group-item">Email: {{tutor.email}}</li>
              <li class="list-group-item">Phone #: {{tutor.phone_number}}</li>
              <li class="list-group-item">Verified: {{tutor.verified}}</li>
              <li class="list-group-item" v-if="tutor.verified">
                <button
                  v-if="tutor.verified"
                  @click="deleteTutor(tutor.email)"
                  class="btn btn-block btn-danger"
                  type="button"
                >
                  
                      Fire
                      <i class="fa fa-fire ml-3"></i>
                    
                </button>
              </li>
              <li v-if="!tutor.verified" class="list-group-item">
                <button
                  type="button"
                  class="btn btn-block btn-success"
                  @click="verifyTutor(tutor.email)"
                >
                  Hire
                  <i class="fa fa-briefcase ml-3"></i>
                </button>
              </li>
            </ul>
          </div>
          <div class="card mx-auto mb-4 sticky-top sticky-offset">
            <h5 class="card-header">Reviews</h5>
          </div>
          <div class="jumbotron">
            <p class="lead">List of all reviews written about this tutor by students.</p>
            <hr class="my-4" />
            <ul class="list-group list-group-flush mb-4">
              <li class="list-group-item">
                Press the
                <span class="badge badge-primary">Edit</span> button to edit the the review contents.
              </li>
              <li class="list-group-item">
                Press the
                <span class="badge badge-success">Submit</span> button to save the changes to the review contents and finish editing.
              </li>
            </ul>

            <!-- Modal -->
            <div
              class="modal fade"
              id="exampleModal"
              tabindex="-1"
              role="dialog"
              aria-labelledby="exampleModalLabel"
              aria-hidden="true"
            >
              <div class="modal-dialog" role="document">
                <div class="modal-content">
                  <div class="modal-header">
                    <h5
                      class="modal-title"
                      id="exampleModalLabel"
                    >Edit review for {{tutor.first_name}} {{tutor.last_name}}</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                      <span aria-hidden="true">&times;</span>
                    </button>
                  </div>
                  <div class="modal-body">
                    <form>
                      <div class="form-group">
                        <label for="message-text" class="col-form-label">Message:</label>
                        <textarea class="form-control" id="message-text"></textarea>
                      </div>
                    </form>
                  </div>
                  <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                    <button type="button" class="btn btn-primary">Save changes</button>
                  </div>
                </div>
              </div>
            </div>

            <div v-for="review in tutorReviews" class="card mb-2">
              <div class="card-header">
                <div class="row justify-content-between">
                  <div v-if="review.stars == 1">⭐</div>
                  <div v-if="review.stars == 2">⭐⭐</div>
                  <div v-if="review.stars == 3">⭐⭐⭐</div>
                  <div v-if="review.stars == 4">⭐⭐⭐⭐</div>
                  <div v-if="review.stars == 5">⭐⭐⭐⭐⭐</div>
                  <!-- Button trigger modal -->
                  <button
                    type="button"
                    class="btn btn-primary"
                    data-toggle="modal"
                    data-target="#exampleModal"
                  >Edit</button>
                </div>
              </div>
              <div class="card-body">
                <blockquote class="blockquote mb-0">
                  <p>{{ review.body }}</p>
                  <footer class="blockquote-footer">
                    <cite title="Source Title">Student</cite>
                  </footer>
                </blockquote>
              </div>
            </div>

            <div class="card">
              <div class="card-header">⭐⭐⭐⭐⭐</div>
              <div class="card-body">
                <blockquote class="blockquote mb-0">
                  <p>Good Tutor</p>
                  <footer class="blockquote-footer">
                    Louca Dussssfault,
                    <cite title="Source Title">Student</cite>
                  </footer>
                </blockquote>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- </div> -->
  <!-- </div>-->
</body>
</template>
<script src="./tutorpg.js">
</script>