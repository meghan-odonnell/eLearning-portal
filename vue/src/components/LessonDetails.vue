<template>
  <div>
    <header-pic></header-pic>
    <div class="lesson-detail">
      <h1>{{ curriculum.curriculumName }}</h1>
      <th>{{ curriculum.curriculumName }}</th>
      <p>{{ curriculum.reading }}</p>
      <p>HOMEWORK: {{ curriculum.homework}}</p>
      <p>RESOURCES: {{ curriculum.resources}}</p>
      </div>
      <div>
        <form @submit.prevent="submitHomework">
          <h3>Submit Homework</h3>
          <label for="studentId">Student ID:</label>
          <input type="text" id="studentId" v-model="studentId" />
          <label for="homework">Homework Answers:</label>
          <textarea
            id="homework"
            v-model="homework"
            placeholder="Enter your homework text here"
          ></textarea>
          <button type="submit">Submit Homework</button>
        </form>
      </div>
    </div>
  
</template>

<script>
import DatabaseService from "../services/DatabaseService.js";
import HeaderPic from "../components/HeaderPic.vue";

export default {
  components: {
    HeaderPic,
  },
  name: "lesson-detail",

  data() {
    return {
      curriculum: [],
    };
  },

  created() {
    DatabaseService.getOneCurriculum(this.$route.params.id)
      .then((response) => {
        this.curriculum = response.data;
      })
      .catch();
  },
};
</script>


<style>
.classlist {
  font-size: 36px;
  color: #5F9EA0;
  text-align: center;
}
table {
  border-collapse: separate;
  border-spacing: 0;
  margin: 20px auto;
  width: 80%;
  table-layout: fixed; /* or 'auto' */
}
th,
td {
  border: none;
  padding: 12px;
  text-align: left;
}
th {
  background-color: #82B3A4;
  color: white;
  font-weight: bold;
  text-transform: uppercase;
}

tr:hover {
  background-color: #F5F5F5;
  transition: background-color 0.3s ease;
}
td:first-child {
  color: #F5A623;
  font-weight: bold;
}

tbody {
  font-family: "Comfortaa", sans-serif;
}


</style>