<template>
  <div>
    <button class="btn-2"><router-link v-bind:to="{name: 'courseform'}">  Course </router-link></button> 
    <button class="btn-2"><router-link v-bind:to="{name: 'curriculumform'}"> Add Curriculum</router-link></button>
    <router-link
      v-bind:to="{ name: 'home' }"
      v-if="$store.state.token != ''"
      class="table-link"
    >
      HOME
    </router-link>
   <router-link
      v-bind:to="{ name: 'logout' }"
      v-if="$store.state.token != ''"
      class="table-link"
    >
      Logout
    </router-link>
   <assignments></assignments>
    <class-list></class-list>
  </div>
</template>

<script>
import Assignments from "../components/Assignments.vue";

import ClassList from "../components/ClassList.vue";

export default {
  components: {
    ClassList,

    Assignments,
  },
};
</script>
      



<style>
<<<<<<< HEAD

.btn-2 {

  color: #F8F8F8;
  font-family: "Comfortaa", sans-serif;
  font-size: 20px;
  text-transform: uppercase;
  
  padding: 8px 8px;
  border-radius: 10px;
  background-color: #F8F8F8;
  margin: 0 5px;
  transition: background-color 0.3s ease;
  display: block;
  


}
.btn-2 {
  background-color: #5F9EA0;
  color: #F8F8F8;
  transition: background-color 0.3s ease;
}




</style>