<template>
  <div>

    <!-- <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp; -->
    
   <programming-curriculum></programming-curriculum> 

   
  </div>
</template>

<script>

import ProgrammingCurriculum from '../components/ProgrammingCurriculum.vue';

export default {
  name: "Programming",
  components: {
   ProgrammingCurriculum,
   
  }
}
</script>



<style>

</style>