<template>
  <div>
    <h2>Add Course Details</h2>

    <form class="create-course" v-on:submit.prevent>
      <div class="form-input-group">
        <label for="courseId">Course ID</label>
        <input name="courseId" type="text" v-model="course.courseId" />
      </div>
      <div class="form-input-group">
        <label for="courseName">Course Name</label>
        <input name="courseName" type="text" v-model="course.courseName" />
      </div>
      <div class="form-input-group">
        <label for="courseDescription">Description</label>
        <input
          name="courseDescription"
          type="text"
          v-model="course.courseDescription"
        />
      </div>
      <div class="form-input-group">
        <label for="difficulty">Level of Difficulty</label>
        <input name="difficulty" type="text" v-model="course.difficulty" />
      </div>
      <div class="form-input-group">
        <label for="cost">Cost</label>
        <input name="cost" type="text" v-model="course.cost" />
      </div>
      <div class="form-input-group">
        <button type="submit" class="btn" v-on:click="saveCourse()">
          Submit
        </button>
      </div>
    </form>
  </div>
</template>

<script>
import DatabaseService from "../services/DatabaseService";

export default {
  name: "create-course",
  data() {
    return {
      course: {
        courseId: "",
        courseName: "",
        courseDescription: "",
        difficulty: "",
        cost: 0,
      },
    };
  },
  methods: {
    setCourseId() {},
    // get the course id based on the teacher's course selection. Teacher should not be entering manually

    saveCourse() {
      const newCourse = {
        courseId: this.course.courseId,
        courseName: this.course.courseName,
        courseDescription: this.course.courseDescription,
        difficulty: this.course.difficulty,
        cost: this.course.cost,
      };

      DatabaseService.createCourse(newCourse)
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
.create-course {
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