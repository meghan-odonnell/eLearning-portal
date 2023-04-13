<template>
  <form class="create-curriculum" v-on:submit.prevent>
      <label for="courseId">"courseId"</label>
    <input name="courseId" type="text" v-model="curriculum.courseId" />

      <label for="curriculumId">"curriculumId"</label>>
    <input name="curriculumId" type="text" v-model="curriculum.curriculumId" />

      <label for="chapterName">"curriculumName"</label>
    <input name="chapterName" type="text" v-model="curriculum.curriculumName"/>

      <label for="reading">"reading"</label>
    <input name="reading" type="text" v-model="curriculum.reading" />

      <label for="homework">"homework"</label>
    <input name="homework" type="text" v-model="curriculum.homework" />

      <label for="resources">"resources"</label>
    <input name="resources" type="text" v-model="curriculum.resources" />


    <button type="submit" class="btn-submit" v-on:click="saveCurriculum()">
      Submit</button>
  </form>
</template>

<script>
import DatabaseService from "../services/DatabaseService";

export default {
  name: "create-curriculum",
  data() {
    return {
      curriculum: {
        curriculumId: "",
        curriculumName: "",
        courseId: "",
        homework: "",
        resources: "",
        reading: "",
      },
    };
  },
  methods: {
    setCourseId() {},
    // get the course id based on the teacher's course selection. Teacher should not be entering manually
    setCurriculumID() {
      //  get the week/day number from form? and then concat with this.courseId
    },

    saveCurriculum() {
        const newCurriculum = {
        curriculumId: this.curriculum.curriculumId,
        curriculumName: this.curriculum.curriculumName,
        courseId: this.curriculum.courseId,
        homework: this.curriculum.homework,
        resources: this.curriculum.resources,
        reading: this.curriculum.reading,
        };

        
      DatabaseService
      .createCurriculum(newCurriculum)
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