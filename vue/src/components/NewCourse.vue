<template>
  <form class="create-course" v-on:submit.prevent>
      <label for="courseId">"courseId"</label>
    <input name="courseId" type="text" v-model="course.courseId" />

      <label for="courseName">"courseName"</label>>
    <input name="courseName" type="text" v-model="course.courseName" />

      <label for="courseDescription">"courseDescription"</label>
    <input name="courseDescription" type="text" v-model="course.courseDescription"/>

      <label for="difficulty">"difficulty"</label>
    <input name="difficulty" type="text" v-model="course.difficulty" />

      <label for="cost">"cost"</label>
    <input name="cost" type="text" v-model="course.cost" />


    <button type="submit" class="btn-submit" v-on:click="saveCourse()">
      Submit</button>
  </form>
</template>

<script>
import DatabaseService from "../services/DatabaseService";

export default {
  name: "create-curriculum",
  data() {
    return {
      course: {
        courseId: "",
        courseName: "",
        courseDescription: "",
        difficulty: "",
        cost: 0
      },
    };
  },
  methods: {
    setCourseId() {},
    // get the course id based on the teacher's course selection. Teacher should not be entering manually
    setCurriculumID() {
      //  get the week/day number from form? and then concat with this.courseId
    },

    saveCourse() {
        const newCourse = {
        courseId: this.course.courseId,
        courseName: this.course.courseName,
        courseDescription: this.course.courseDescription,
        difficulty: this.course.difficulty,
        cost: this.course.cost
        };

        
      DatabaseService
      .createCourse(newCourse)
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
          " course. Response received was '" +
          error.response.statusText +
          "'.";
      } else if (error.request) {
        this.errorMsg =
          "Error " + verb + " course. Server could not be reached.";
      } else {
        this.errorMsg =
          "Error " + verb + " course. Request could not be created.";
      }
    },
  },
};
</script>

<style>
</style>