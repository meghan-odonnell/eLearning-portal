<template>
  <div>

    <!-- <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp; -->
    
   <programming-curriculum></programming-curriculum> 
   <accordion></accordion>
   <accordion-tab></accordion-tab>
   
  </div>
</template>

<script>

import ProgrammingCurriculum from '../components/ProgrammingCurriculum.vue';
import Accordion from 'primevue/accordion';
import AccordionTab from 'primevue/accordiontab';

export default {
  name: "Programming",
  components: {
   ProgrammingCurriculum,
     Accordion,
    AccordionTab  
  }
}
</script>



<style>

</style>