
<template>
  <div class="home">
<<<<<<< HEAD
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>

   <class-list></class-list>
    
=======
    <h1 id="home">Home</h1>
    <p id="auth">Student View</p>
   <class-list></class-list>

  <p class="mathfact">Here's a random math fact:  </p>
  <math-fact class="mathfact"></math-fact>
  <p>{{ mathFact }}</p>

  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Comfortaa|Didact Gothic">
>>>>>>> dd457d2c99161adf0be951403142d88fd9081c9b
  </div>
</template>

<script>
<<<<<<< HEAD
import ClassList from '../components/ClassList.vue'

=======
import ClassList from '../components/ClassList.vue';
import MathFact from "../components/MathFact.vue";
>>>>>>> dd457d2c99161adf0be951403142d88fd9081c9b


export default {
  components: { 
      ClassList,
<<<<<<< HEAD
      
=======
      MathFact
>>>>>>> dd457d2c99161adf0be951403142d88fd9081c9b
    },

  name: "home"
}




</script>
<style>
  p#auth {
    color: rgb(249, 250, 252);
    font-family: "Comfortaa";
    font-size: 30px;
    max-width: 100%;
    display: block;
    margin-left: auto;
    margin-right: auto;
    width: 100%;
    text-align: center;
    border-radius: 20px;
    margin-bottom: 50px;
  }

  h1#home {
    color: rgb(0, 0, 0);
    font-family: "Comfortaa";
    font-size: 40px;
    max-width: 100%;
    display: block;
    margin-left: auto;
    margin-right: auto;
    width: 100%;
    text-align: center;
    border-radius: 20px;
    margin-bottom: 50px;
  }

  .mathfact {
    margin-left: 30px;
    font-family: "Comfortaa";
  }
</style>

