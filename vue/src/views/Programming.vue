<template>
  <div>

    <!-- <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp; -->
    
   <programming-curriculum></programming-curriculum> 

   
  </div>
</template>

<script>

import DatabaseService from "../services/DatabaseService.js";
// import { VueAccordion, VueAccordionPane } from "vue-accordion";

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