<template>
  <div>
    <h1>Update Grade and Submit</h1>

    <div class="homework-to-grade">
      <table>
        <th>Student Id</th>
        <th>Student Name</th>
        <th>Submission Date</th>
        <th>Submitted</th>
        <th>Update Grade</th>
        <th></th>

        <tr>
          <td>{{ assignments.studentId }}</td>
          <td>{{ assignments.studentName }}</td>
          <td>{{ assignments.submittedDate }}</td>
          <td>
            {{ assignments.submitted === true ? "Submitted" : "Not submitted" }}
          </td>
          <td>
            <div class="form-input-group">
              <select name="grade">
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
        submissionDate: "",
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
        submissionDate: this.assignments.submissionDate,
        status: true,
        grade: this.assignments.grade,        
      };

      DatabaseService.submitGrade(this.assignments.assignmentId,updateGrade)
     .then((response) => {
          if (response.status === 201) {
            this.$router.push({name: 'curriculumlist', params: {courseName: this.curriculum.courseId}});
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

<style>
</style>