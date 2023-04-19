<template>
  <div>
    <h2>Add Curriculum Details</h2>
    <form class="create-curriculum" v-on:submit.prevent>
      <div class="form-input-group">
        <label for="courseId">Course ID</label>

        <input name="courseId" type="text" v-model="curriculum.courseId" />
      </div>

      <div class="form-input-group">
        <label for="curriculumId">Curriculum ID</label>
        <input
          name="curriculumId"
          type="text"
          v-model="curriculum.curriculumId"
        />
      </div>
      <div class="form-input-group">
        <label for="chapterName">Curriculum Name</label>
        <input
          name="chapterName"
          type="text"
          v-model="curriculum.curriculumName"
        />
      </div>
      <div class="form-input-group">
        <label for="reading">Reading Materials</label>
        <input name="reading" type="text" v-model="curriculum.reading" />
      </div>
      <div class="form-input-group">
        <label for="homework">Homework</label>
        <input name="homework" type="text" v-model="curriculum.homework" />
      </div>
      <div class="form-input-group">
        <label for="resources">Links / Additional Resources</label>
        <input name="resources" type="text" v-model="curriculum.resources" />
      </div>
      <div class="form-input-group">
        <button type="submit" class="btn" v-on:click="saveCurriculum">
          Submit
        </button>
      </div>
    </form>
  </div>
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

      const newAssignment = {
        curriculumId: newCurriculum.curriculumId,
      };

      Promise.all([
        DatabaseService.createCurriculum(newCurriculum),
        DatabaseService.createAssignment(newAssignment),
      ])
        .then(([curriculumResponse, assignmentResponse]) => {
          if (
            curriculumResponse.status === 201 &&
            assignmentResponse.status === 201
          ) {
            this.$router.push({
              name: "curriculumlist",
              params: { courseName: this.curriculum.courseId },
            });
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
.create-curriculum {
  max-width: 400px;
  margin: auto;
  padding: 20px;
  background-color: #fff;
  box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.2);
}

.form-input-group {
  margin-bottom: 20px;
}

h2 {
  text-align: center;
}
label {
  display: block;
  font-size: 18px;
  margin-bottom: 5px;
}

input[type="text"] {
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
  background-color: #5f9ea0;
  color: #fff;
}

button[type="submit"]:hover {
  cursor: pointer;
  background-color: #427f84;
}
</style>