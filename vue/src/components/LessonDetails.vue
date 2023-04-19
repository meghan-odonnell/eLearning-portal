<template>
  <div>
    <header-pic></header-pic>
<div>
      <router-link
      v-bind:to="{ name: 'logout' }"
      v-if="$store.state.token != ''"
      class="table-link"
    >
      Logout
    </router-link>
    <router-link
      v-bind:to="dashboardRoute"
      v-if="$store.state.token != ''"
      class="table-link"
    >
      HOME
    </router-link>
</div>
&nbsp;

    <div class="lesson-detail">
      <table>
      <h1>{{ curriculum.curriculumName }}</h1>
  
      <tr>{{ curriculum.reading }}</tr>
      
      <h1>Homework: </h1>
        <tr>{{ curriculum.homework}}</tr>
      <h1>Resources:</h1>
      <tr> {{ curriculum.resources}}</tr>
      </table>
      </div>

&nbsp;
&nbsp;
&nbsp;
&nbsp;
&nbsp;
&nbsp;

      <div id="homework">
        <form v-on:submit.prevent>
          <h3>Submit Homework</h3>
          <div class ="form-input-group">
          <label for="studentId">Student ID:</label>
          <input type="text" id="studentId" v-model="this.$store.state.user.id" />
          </div>
          <div class ="form-input-group">
          <label for="homework">Homework Answers:</label>
          <textarea
            id="homework"
            v-model="homework.answer"
            placeholder="Enter your homework text here"
          ></textarea>
          </div>
          <div class ="form-input-group">
          <button type="submit" v-on:click="saveHomework">Submit Homework</button>
          </div>
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
      homework: {
        
        curriculumId: "",
        studentId: this.$store.state.user.id,
        status: true,
        grade: 0,
        answer: ""
        
      },
    };
  },

  created() {
    DatabaseService.getOneCurriculum(this.$route.params.id)
      .then((response) => {
        this.curriculum = response.data;
      })
      .catch();
  },
  methods: {
    saveHomework() {
      const updateHomework = {
        
        curriculumId: this.curriculum.curriculumId,
        studentId: this.$store.state.user.id,
    
        status: false,
        grade: this.homework.grade,
        answer: this.homework.answer
        
      }
      DatabaseService.submitHomework(this.$store.state.user.id, this.curriculum.curriculumId, updateHomework)
      .then((response) => {
        if(response.status === 201 || response.status === 200) {
          this.$router.push({name: "studentdashboard"});
        }
      })
      .catch((error) => {
          this.handleErrorResponse(error, "Adding");
        });
    }
  },

  computed: {
    dashboardRoute() {
       if(this.$store.state.user.authorities[0].name === 'ROLE_ADMIN') {
            return {name: "teacherdashboard"};
          } else {
            return {name: "studentdashboard"};
          }
    }
  },

  
};
</script>


<style>
#homework {
  max-width: 800px;
  margin: auto;
  padding: 20px;
  background-color: #fff;
  box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.2);
  font-family: 'Didact Gothic', sans-serif;
}
h3 {
  font-size: 24px;
  margin-top: 0;
  margin-bottom: 20px;
  text-align: center;
}
textarea {
  width: 95%;
  height: 20em;
  padding: 10px;
  font-size: 16px;
  border: 1px solid #ccc;
  border-radius: 5px;
}


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

tbody {
  font-family: "Comfortaa", sans-serif;
}
.form-input-group {
  margin-bottom: 20px;
}

label {
  display: block;
  font-size: 18px;
  margin-bottom: 5px;
}

input[type="text"],
input[type="homework"] {
  width: 95%;
  padding: 10px;
  font-size: 16px;
  border: 1px solid #ccc;
  border-radius: 5px;
}

button[type="submit"] {
  display: block;
  width: 100%;
  padding: 10px;
  font-size: 16px;
  border: none;
  border-radius: 5px;
  background-color: #007bff;
  color: #fff;
}

button[type="submit"]:hover {
  cursor: pointer;
  background-color: #0069d9;
}
.black-link {
  color: black;
  /* Additional styling if needed */
}

</style>