 <template>
   <div id="WelcomePage">
    <h1>Welcome to Quality over Quantity Tutoring Company</h1>
     <div id= "about">
        <h2>About us: </h2>
        <p> Who We Are?
            <b> Quality Over Quantity <a href="http://google.com">Tutors</a></b> 
            are an elite team of certified teachers who offer the best tutoring services available.
            Your child will be getting the instruction they need with our company. We are qualified to teach, 
        but we believe in the power of one-on-one tutoring. Our goal is to make sure your son or daughter has the tools and confidence to score straight A’s—while enjoying the process! 
          </p>
          </div>
          <div id= "Services">
         <p>Our Tutors:</p>
         <p>Our Courses:</p>
         <p>Our Offerings:</p>
         <p><a href="http://127.0.0.1:8087/#/login">Login</a></p>
         <p><a href="http://127.0.0.1:8087/#/signup" class="button">Sign up</a></p>
</div>
   </div> 
 </template>
<script>
</script>
<style>

  #WelcomePage {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    color: #172431;
    font-size: 25px;
    background: #a7c5e0;
    text-align: inherit
  }
  h2{
     text-align: left
  }
#about {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    color: #172431;
    font-size: 22px;
    background: #a7c5e0;
    text-align: center;
    display: block;
    grid-template-columns: 100px  600px
  }

  #Services{
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    color: #172431;
    font-size: 22px;
    background: #a7c5e0;
    text-align: center;
    display: -moz-grid;
    grid-area: span;
    grid-template-columns: 200px 200px 200px 200px 200px
  }

</style>