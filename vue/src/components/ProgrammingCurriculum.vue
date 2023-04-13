<template>
  <div>
    <h1 class="curriculum">Programming Curriculum:</h1>

    <VueAccordion :multiple="true" :activeIndex="0">
      <VueAccordionTab v-for="item in curriculum" :header="item.title" :key="item.id">
        <p>{{ item.content }}</p>
      </VueAccordionTab>
    </VueAccordion>
  </div>
</template>

<script>
import DatabaseService from "../services/DatabaseService.js";
import { VueAccordion, VueAccordionTab } from "vue-accordion";
// import Accordion from 'primevue/accordion';
// import AccordionTab from 'primevue/accordiontab';

export default {
  name: "programmingcurriculum",
  components: {
    VueAccordion,
    VueAccordionTab,

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

.curriculum {
  font-size: 36px;
  color: #f5a623;
  text-align: center;
}
.p-accordion {
  width: 100%;
}

.p-accordion .p-accordion-tab {
  border-bottom: 1px solid #ddd;
}

.p-accordion .p-accordion-header {
  font-weight: bold;
  background-color: #f5f5f5;
  padding: 10px;
  cursor: pointer;
}

.p-accordion .p-accordion-header:focus {
  outline: none;
}

.p-accordion .p-accordion-header:hover {
  background-color: #e5e5e5;
}

.p-accordion .p-accordion-content {
  padding: 10px;
  background-color: #fff;
}




</style>