<template>
  <div>
    <h1>To Do!   Grade Assignments</h1>

    <div>
      <table>
        
        <th>Student Id</th>
        <th>Student Name</th>
        <th>Submission Date</th>
        <th>Submitted</th>
        <th>Grade</th>

        <tr
          v-for="item in assignments"
          v-bind:key="item.assignmentId"
          v-bind:class="{ 'not-submitted': !item.submitted }"
        >
          <router-link
            v-bind:to="{ name: 'grading', params: { id: item.assignmentId } }"
          >
            <td>{{ item.studentId }}</td>
          </router-link>
          <td>{{ item.studentName }}</td>
          <td>{{ item.submittedDate }}</td>
          <td>
            {{ item.submitted === true ? "Submitted" : "Not submitted" }}
          </td>
          <td>{{ item.grade }}</td>
        </tr>
      </table>
    </div>
  </div>
</template>

<script>
import DatabaseService from "../services/DatabaseService.js";

export default {
  name: "ungraded-list",

  data() {
    return {
      assignments: [],
    };
  },
  created() {
    console.log(this.$store.state.user.id);
    console.log(typeof this.$store.state.user.id);

    if (this.$store.state.user.authorities[0].name === "ROLE_ADMIN") {
      DatabaseService.getHomework()
        .then((response) => {
          this.assignments = response.data.filter(
            (item) => item.submitted === true && item.grade === 0
          );
        })
        .catch((error) => {
          console.error(error);
        });
    }
    if (this.$store.state.user.authorities[0].name === "ROLE_USER")
      DatabaseService.getMyAssignments(this.$store.state.user.id)
        .then((response) => {
          this.assignments = response.data;
          this.assignments.forEach((item) => {
            if (item.submissionDate) {
              item.status = true;
            } else {
              item.status = false;
            }
          });
        })

        .catch((error) => {
          console.error(error);
        });
  },
};
</script>

<style scoped >
.not-submitted {
  background-color: #ffe6e6; /* light pink */
}
h1 {
  font-size: 36px;
  color: #5f9ea0;
  text-align: center;
}
</style>
