<template>
  <div>
    <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
    <h1 class="curriculum">Programming Curriculum:</h1>
    <vue-accordion>
      <vue-accordion-pane v-for="item in curriculum" :key="item.curriculumId">
        <template #title>
          <div class="pane-title">{{ item.curriculumName }}</div>
        </template>
        <template #content>
          <div class="pane-content">
            <p>{{ item.reading }}</p>
          </div>
        </template>
      </vue-accordion-pane>
    </vue-accordion>
  </div>
</template>

<script>
import DatabaseService from "../services/DatabaseService.js";
import { VueAccordion, VueAccordionPane } from "vue-accordion";

export default {
  name: "programmingcurriculum",
  components: {
    VueAccordion,
    VueAccordionPane,
  },
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