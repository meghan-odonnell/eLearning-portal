<template>
  <form class="create-curriculum" v-on:submit.prevent>
  

      <label for="curriculumId">"curriculumId"</label>>
    <input name="curriculumId" type="text" v-model="assignment.curriculumId" />

      <label for="status">"status"</label>
    <input name="status" type="text" v-model="assignment.status" />


    <button type="submit" class="btn-submit" v-on:click="saveAssignment()">
      Submit</button>
  </form>
</template>

<script>
import DatabaseService from "../services/DatabaseService";

export default {
  name: "assignments",
  data() {
    return {
      assignment: {
        assignmentId: 0,
        curriculumId: "",
        studentId: 0,
        submissionDate: Date,
        status: false,
        
      },
    };
  },
  methods: {
    setCourseId() {},
    // get the course id based on the teacher's course selection. Teacher should not be entering manually
    setCurriculumID() {
      //  get the week/day number from form? and then concat with this.courseId
    },

    saveAssignment() {
        const newAssignment = {
       assignmentId: this.assignment.assignmentId,
        curriculumId: this.assignment.curriculumId,
        studentId: this.assignment.studentId,
        submissionDate: this.assignment.submissionDate,
        status: this.assignment.status,

        };

        
      DatabaseService
      .createCurriculum(newAssignment)
      .then((response) => {
          if (response.status === 201) {
            this.$router.push("/");
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
  },
};
</script>

<style>
</style>