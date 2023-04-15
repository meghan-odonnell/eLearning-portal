<template>
  <div class="home">
    <div class="container">
      <img src="../img/superSmartBanner.jpg" alt="super-smart" />
  </div>
   <button>
    <router-link v-bind:to="{name: 'teacherdashboard' }"> hi
    </router-link>

   </button>
    <class-list></class-list>
    

    <!-- <p class="mathfact">Here's a random math fact:</p>
    <math-fact class="mathfact"></math-fact> -->

    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Comfortaa%7CDidact Gothic" />
  </div>
</template>

<script>
import ClassList from "../components/ClassList.vue";

// import MathFact from "../components/MathFact.vue";

export default {
  components: {
    ClassList
    // MathFact,
  
   
  },

  name: "home",
};

</script>
<style>
.container {
  max-width: 100%;
  text-align: center;
}

.home img {
  width: 100%;
  justify-content: center;
  text-align: center;
  margin: 0 auto;
}

.table a {
  color: #5f9ea0;
  font-family: "Comfortaa", sans-serif;
  font-size: 24px;
  text-transform: uppercase;
  text-decoration: none;
  padding: 10px 20px;
  border-radius: 10px;
  background-color: #f8f8f8;
  margin: 0 10px;
  transition: background-color 0.3s ease;
}

.table a:hover {
  background-color: #5f9ea0;
  color: #f8f8f8;
  transition: background-color 0.3s ease;
}
</style>