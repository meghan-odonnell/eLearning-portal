
<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
   <class-list></class-list>
  
  <rest-math-facts-service></rest-math-facts-service>
  <p>Here's a random math fact:  </p>
  <p>{{ mathFact }}</p>
  </div>
    
</template>

<script>
import ClassList from '../components/ClassList.vue'
import RestMathFactsService from '../services/RestMathFactsService.js'

export default {
  components: { 
      ClassList,
      RestMathFactsService
    },

  name: "home",


  data() {
    return {
      mathFact: ""
    }
  },
  created() {
    RestMathFactsService.getMathFact().then(response => {
      this.mathFact = response.data
    })
    .catch(error => {
      console.log(error)
    })
  }
}




</script>

