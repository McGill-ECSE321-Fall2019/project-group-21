<template>
<body>
  <nav class="navbar navbar-expand-lg navbar-light bg-light static-top">
    <!-- <div class="container"> -->
    <a class="navbar-brand" href="#">
      <img
        alt="Brand"
        src="../assets/quality.png"
        class="image-responsive"
        style="max-width: 3rem;overflow: visible;"
      />Quality Academy
    </a>
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
      <ul class="navbar-nav ml-auto">
        <li class="nav-item">
          <router-link to="/Manager" class="nav-link">Profile</router-link>
        </li>
        <li class="nav-item">
          <router-link to="/Logout" class="nav-link">Logout</router-link>
        </li>
      </ul>
    </div>
    <!-- </div> uncomment to make the nav bar more narrow -->
  </nav>

  <div id="id">
    <div class="jumbotron jumbotron-fluid position-fixed">
      <div class="container">
        <h1 class="display-4">{{tutor.first_name}} {{tutor.last_name}}</h1>
      </div>
    </div>

    <div class="container-fluid">
      <div class="row">
        <div
          class="col-12 col-md-5 col-lg-4 col-xl-3 mx-auto d-block d-sm-none d-md-block position-fixed"
          id="sticky-sidebar"
        >
          <!-- <div class="sticky-top"> -->
          <div class="card mx-auto">
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
              <li class="list-group-item">
                <button type="button" class="btn btn-block btn-danger">
                  <div v-if="tutor.verified">Fire 🔥</div>
                  <div v-else>Delete ✖️</div>
                </button>
              </li>
              <li v-if="!tutor.verified" class="list-group-item">
                <button type="button" class="btn btn-block btn-success">Hire 💼</button>
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
              <li class="list-group-item">
                <button type="button" class="btn btn-block btn-danger">Fire 🔥</button>
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
                <span class="badge badge-secondary">Edit</span> button to edit the content of the review body.
              </li>
              <li class="list-group-item">
                Press the
                <span class="badge badge-success">Submit</span> button to save the changes and finish editing.
              </li>
            </ul>

            <!-- <div v-for="review in tutor_reviews" class="card mb-2">
              <div class="card-header">
                <div v-if="review.stars == 1">
                ⭐
                </div>
                <div v-if="review.stars == 2">
                ⭐⭐
                </div>
                <div v-if="review.stars == 3">
                ⭐⭐⭐
                </div>
                <div v-if="review.stars == 4">
                ⭐⭐⭐⭐
                </div>
                <div v-if="review.stars == 5">
                ⭐⭐⭐⭐⭐
                </div>
                <button type="button" class="btn btn-primary float-right">Edit</button>
              </div>
              <div class="card-body">
                <blockquote class="blockquote mb-0">
                  <p>Good Tutor</p>
                  <footer class="blockquote-footer">
                    <cite title="Source Title">Student</cite>
                  </footer>
                </blockquote>
              </div>
            </div>-->

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
            <div class="card">
              <div class="card-header">⭐⭐⭐⭐⭐</div>
              <div class="card-body">
                <blockquote class="blockquote mb-0">
                  <p>Good Tutor</p>
                  <footer class="blockquote-footer">
                    Louca Dufault,
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
                    Louca Dufault,
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
                    Louca Dufault,
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
                    Louca Dufault,
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
                    Louca Dufault,
                    <cite title="Source Title">Student</cite>
                  </footer>
                </blockquote>
              </div>
            </div>
          </div>
        </div>
      </div>
      <!-- <div class="row">
      <div class="col-12 col-md-5 col-lg-4 col-xl-3 mb-4">
        <div class="card mx-auto">
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
          </ul>
        </div>
      </div>
      <div class="col-12 col-md-7 col-lg-8 col-xl-9">
        <div class="card mx-auto">
          <h5 class="card-header">Reviews</h5>
          <div class="card-body">
            <p class="card-text">List of all reviews written about this tutor by students.</p>
            <p class="card-text">How to use:</p>
          </div>
          <ul class="list-group list-group-flush">
            <li class="list-group-item">
              Press the
              <span class="badge badge-secondary">Edit</span> button to edit the content of the review body.
            </li>
            <li class="list-group-item">
              Press the
              <span class="badge badge-success">Submit</span> button to save the changes and finish editing.
            </li>
          </ul>
        </div>
      </div>
    </div>
    <div class="row justify-content-end">
      <div class="col-12 col-md-7 col-lg-8 col-xl-9">
        <div class="card">
          <div class="card-header">⭐⭐⭐⭐⭐</div>
          <div class="card-body">
            <blockquote class="blockquote mb-0">
              <p>Good Tutor</p>
              <footer class="blockquote-footer">
                Louca Dufault,
                <cite title="Source Title">Student</cite>
              </footer>
            </blockquote>
          </div>
        </div>
      </div>
      </div>-->
      <!-- <div v-for="review in tutor.reviews" class="card mx-auto">
        <div class="card-header"><nobr v-for="star in review.stars">⭐</nobr></div>
        <div class="card-body">
          <blockquote class="blockquote mb-0">
            <p>{{review.body}}</p>
            <footer class="blockquote-footer">
              {{review.student}}
              <cite title="Source Title">Student</cite>
            </footer>
          </blockquote>
        </div>
      </div>-->
    </div>
  </div>
  <!-- </div> -->
  <!-- </div>-->
</body>
</template>
<script src="./tutorpg.js">
</script>