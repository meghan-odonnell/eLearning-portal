<template>
  <div>
      <rest-math-facts-service></rest-math-facts-service>
  <p>{{ mathFact }}</p>
  </div>
</template>

<script>


import RestMathFactsService from '../services/RestMathFactsService.js'

export default {
    components: { 
      RestMathFactsService
    
    },
    name: 'math-fact',
    data() {
        return {
            mathFact: "",
        }
    },
    created() {
      RestMathFactsService.getMathFact().then(response => {
            this.mathFact = response.data;
        })
    }

}
</script>

<style>

</style>