<template>
  <div>
      <!-- <rest-math-facts-service></rest-math-facts-service> -->
  <p>{{$store.state.mathFact}}</p>
  </div>
</template>

<script>


import RestMathFactsService from '../services/RestMathFactsService.js'

export default {
    
    name: 'math-fact',
    
    created() {
      RestMathFactsService.getMathFact().then(response => {
            this.$store.commit('SET_MATH_FACT',response.data)
        })
    }

}
</script>

<style>

</style>