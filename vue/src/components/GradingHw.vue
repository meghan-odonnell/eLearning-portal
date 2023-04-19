<template>
  <div>
    <h1>Update Grade and Submit</h1>

    <div class="homework-to-grade">
      <table>
        <th>Student Id</th>
        <th>Student Name</th>
        <th>Submission Date</th>
        <th class="answer">Answer</th>
        <th>Update Grade</th>
        <th></th>

        <tr>
          <td>{{ assignments.studentId }}</td>
          <td>{{ assignments.studentName }}</td>
          <td>{{ assignments.submittedDate }}</td>
          <td>{{ assignments.answer }}</td>
          
          <td>
            <div class="form-input-group" >
              <select name="grade" v-model="assignments.grade">
                <option value="0">0</option>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
              </select>
              
            </div>
            
          </td>
          <td>
             <div class="form-input-group">
        <button type="submit" class="btn" v-on:click="saveGrade">
          Submit
        </button>
      </div>
          </td>
        </tr>
      </table>
    </div>
  </div>
</template>

<script>
import DatabaseService from "../services/DatabaseService";
export default {
  components: {},
  name: "homework-to-grade",

  data() {
    return {
      assignments: {
        assignmentId: "",
        curriculumId: "",
        studentId: "",
        // submissionDate: this.assignments.submissionDate,
        submitted: false,
        grade: "", 
      },
    };
  },

  created() {
    DatabaseService.getOneAssignment(this.$route.params.id)
      .then((response) => {
        console.log("hits.then");
        this.assignments = response.data;
      })
      .catch(console.log("hits .catch"), console.error("error"));
  },

  methods: {
    saveGrade() {
      const updateGrade = {
        assignmentId: this.assignments.assignmentId,
        curriculumId: this.assignments.curriculumId,
        studentId: this.assignments.studentId,
        // submissionDate: this.assignments.submissionDate, 
        submitted: this.assignments.submitted,
        grade: this.assignments.grade,        
      };

      DatabaseService.submitGrade(this.assignments.assignmentId,updateGrade)
     .then((response) => {
          if (response.status === 201 || response.status === 200) {
            this.$router.push({ name: "teacherdashboard" });
          }
        })
        .catch((error) => {
          this.handleErrorResponse(error, "Adding");
        });
  },


    handleErrorResponse(error, verb) {
      if (error.response) {
        this.errorMsg =
          "Error " +
          verb +
          " curriculum. Response received was '" +
          error.response.statusText +
          "'.";
      } else if (error.request) {
        this.errorMsg =
          "Error " + verb + " curriculum. Server could not be reached.";
      } else {
        this.errorMsg =
          "Error " + verb + " curriculum. Request could not be created.";
      }
    },
  


}
}
</script>

<style scoped>

body {
  font-family: comforta, system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto,
    'Helvetica Neue', Arial, 'Noto Sans', sans-serif, 'Apple Color Emoji',
    'Segoe UI Emoji', 'Segoe UI Symbol', 'Noto Color Emoji' !important;
}

.container {
  width: 100%;
  max-width: 1100px;
  margin: 0 auto;
}

.loading {
  display: flex;
  justify-content: center;
  align-items: center;
}

.routerView {
  width: 79%;
  position: absolute;
  right: 0;
}

.btn {
  display: inline-block;
  font-weight: 400;
  color: #212529;
  text-align: center;
  vertical-align: middle;
  border: 1px solid transparent;
  padding: .375rem .75rem;
  margin-right: 10px;
  margin-bottom: 5px;
  font-size: 1rem;
  line-height: 1.5;
  border-radius: .25rem;
  cursor: pointer;
}
th:nth-child(4),
td:nth-child(4) {
  width: 50%;
}





</style>