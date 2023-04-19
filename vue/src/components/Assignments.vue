<template>
  <div>
    <h1>Assignments</h1>
    
    <div>
      <table>
        <th>Lesson</th>
        <th @click="sortBy('studentId')">Student Id</th>
        <th @click="sortBy('studentName')">Student Name</th>
        <th @click="sortBy('submittedDate')">Submission Date</th>
        <th @click="sortBy('submitted')">Submitted</th>
        <th @click="sortBy('grade')">Grade</th>
        <tr
          v-for="item in assignments"
          v-bind:key="item.assignmentId"
          v-bind:class="{ 'not-submitted': !item.submitted }"
        >
          <td>{{ item.curriculumId }}</td>
          <td>{{ item.studentId }}</td>
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
  name: "homework-details",

  data() {
    return {
      assignments: [],
    };
  },
  computed: {
    isAdmin() {
      return this.$store.state.user.authorities[0].name === "ROLE_ADMIN";
    },

    // // Calculate completion percentage for a given student ID
    // completionPercentage: function (studentId) {
    //   const studentAssignments = this.assignments.filter(
    //     (item) => item.studentId === studentId
    //   );
    //   const completedAssignments = studentAssignments.filter(
    //     (item) => item.status === true
    //   );
    //   const completionPercent =
    //     (completedAssignments.length / studentAssignments.length) * 100;
    //   return completionPercent.toFixed(2);
    // },
  // Calculate average grade for a given student ID
      // averageGrade: function (studentId) {
      //   const studentAssignments = this.assignments.filter(
      //     (item) => item.studentId === studentId
      //   );
      //   const totalGrade = studentAssignments.reduce(
      //     (accumulator, item) => accumulator + item.grade,
      //     0
      //   );
      //   const averageGrade = totalGrade / studentAssignments.length;
      //   return averageGrade.toFixed(2);
      // },

    // sortedAssignments() {
    //   const sortedAssignments = [...this.assignments];
    //   return sortedAssignments.sort((a, b) => {
    //     let comparison = 0;
    //     if (a[this.sortByColumn] > b[this.sortByColumn]) {
    //       comparison = 1;
    //     } else if (a[this.sortByColumn] < b[this.sortByColumn]) {
    //       comparison = -1;
    //     }
    //     return this.sortDirection * comparison;
    //   });
    // },
  },
  methods: {
    // sortBy(column) {
    //   if (this.sortByColumn === column) {
    //     this.sortDirection = -this.sortDirection;
    //   } else {
    //     this.sortByColumn = column;
    //     this.sortDirection = 1;
    //   }
    // },
  },

  created() {
    if (this.isAdmin) {
      DatabaseService.getHomework()
        .then((response) => {
          this.assignments = response.data;
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
