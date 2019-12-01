<template>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1 shrink-to-fit=no"/>
    <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
  </head>
  <div id="app">

    <router-view></router-view>
  </div>
  
</html>
</template>

<script>
export default {
  name: 'app'
}
</script>

<style>
/* Fixes dropdown menus placed on the right side */
.ml-auto .dropdown-menu {
  left: auto !important;
  right: 0px;
}

/* #app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;

  color: #2c3e50;
  margin-top: 0px;
} */
</style>
