<template>
  <div>
    <header-pic></header-pic>
    <router-link class="btn-2" v-bind:to="{ name: 'courseform' }">
      Add Course
    </router-link>
    <router-link class="btn-2" v-bind:to="{ name: 'curriculumform' }">
      Add Curriculum</router-link
    >

    <router-link
      v-bind:to="{ name: 'logout' }"
      v-if="$store.state.token != ''"
      class="table-link"
    >
      Logout
    </router-link>
    &nbsp;
    <ungraded></ungraded>
    <assignments></assignments>
    <class-list></class-list>
  </div>
</template>

<script>
import Assignments from "../components/Assignments.vue";

import ClassList from "../components/ClassList.vue";
import HeaderPic from "../components/HeaderPic.vue";
import Ungraded from "../components/Ungraded.vue";

export default {
  components: {
    ClassList,
    Assignments,
    HeaderPic,
    Ungraded,
  },
};
</script>
      



<style scoped>
.btn-2 {
  color: #f8f8f8;
  font-family: "Comfortaa", sans-serif;
  font-size: 20px;
  text-transform: uppercase;

  padding: 8px 8px;
  border-radius: 10px;
  background-color: #f8f8f8;
  margin: 0 5px;
  transition: background-color 0.3s ease;
  float: left;
}
.btn-2 {
  background-color: #5f9ea0;
  color: #f8f8f8;
  transition: background-color 0.3s ease;
}
</style>