<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
   <class-list></class-list>
  </div>
</template>

<script>
import ClassList from '../components/ClassList.vue'
export default {
  components: { 
      ClassList
    },
  name: "home",


};
</script>
