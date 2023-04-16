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
          <label for="homework">Homework Ansers:</label>
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
tr:nth-child(even) {
  background-color: #F8F8F8;
}
tr:hover {
  background-color: #F5F5F5;
  transition: background-color 0.3s ease;
}
td:first-child {
  color: #F5A623;
  font-weight: bold;
}
td:nth-child(2) {
  color: #7F7F7F;
}
tbody {
  font-family: "Comfortaa", sans-serif;
}
.table-link {
  color: #5F9EA0;
  font-family: "Comfortaa", sans-serif;
  font-size: 20px;
  text-transform: uppercase;
  text-decoration: none;
  padding: 8px 8px;
  border-radius: 10px;
  background-color: #F8F8F8;
  margin: 0 5px;
  transition: background-color 0.3s ease;
  float: right;
}
.table-link:hover {
  background-color: #5F9EA0;
  color: #F8F8F8;
  transition: background-color 0.3s ease;
}

</style>