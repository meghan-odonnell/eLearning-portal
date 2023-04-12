<template>
  <div>
     <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
    <h1 class="curriculum">Science Curriculum:</h1>
    <div v-for="item in curriculum" v-bind:key="item.curriculumId">
      <h2>{{ item.curriculumName }}</h2>
      <p>{{ item.reading }}</p>
    </div>
  </div>
</template>

<script>
import DatabaseService from "../services/DatabaseService.js";

export default {
  name: "curriculum",
  data() {
    return {
      curriculum: [],
    };
  },
  created() {
    DatabaseService.getAllCurriculum().then((response) => {
      this.curriculum = response.data;
    });
  },
};
</script>

<style>

.curriculum {
  font-size: 36px;
  color: #f5a623;
  text-align: center;
}




/* h1.classlist {
    color: rgb(0, 0, 0);
    padding: 20px;
    font-family: "Didact Gothic";
    font-size: 40px;
    display: block;
    margin-left: 70px;
    margin-right: auto;
    width: 100%;
    margin-bottom: 0px;
    text-decoration-line: underline;
/* } */



</style>