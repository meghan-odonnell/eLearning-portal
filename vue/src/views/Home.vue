
<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
   <class-list></class-list>
    
  <p>Here's a random math fact:  </p>
  <math-fact></math-fact>
  <p>{{ mathFact }}</p>
  
  </div>
    
</template>

<script>
import ClassList from '../components/ClassList.vue'
import MathFact from '../components/MathFact.vue'


export default {
  components: { 
      ClassList,
      MathFact,
    },

  name: "home",
}




</script>

