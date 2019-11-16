<template>
  <div id="tutors">
    <h1>our tutors </h1>
    <table>
      <td v-for="(tutor) in tutors" :key="tutor.email">name: {{ tutor.first_name }} email: {{tutor.email }} </td>
    </table>
</div>
</template>
<script src="./tut.js">
</script>
