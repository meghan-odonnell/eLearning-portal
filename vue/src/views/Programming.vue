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
  name: "Programming",
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
    console.log("Fetching curriculum data...");
    DatabaseService.getAllCurriculum().then((response) => {
      this.curriculum = response.data;
      console.log("Curriculum data retrieved:", this.curriculum);
    });
  },
};
</script>



<style>
p#auth {
  color: rgb(11, 12, 12);
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
</style>