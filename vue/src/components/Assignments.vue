<template>
<div>
  <h3>Assignments</h3>
  <div >
      <table>
        <th>Student Id</th>
        <th>Student Name</th>
        <th>Submission Date</th>
        <th>Status</th>
        <tr v-for="item in assignments" v-bind:key="item.assignmentId">
        <td>{{ item.studentId }}</td>
        <td>{{ item.studentName }}</td>
        <td>{{ item.submissionDate }}</td>
        <td>{{ item.status }}</td>
        </tr>
      </table>
    </div>
    </div>
</template>

<script>
import DatabaseService from '../services/DatabaseService.js'

export default {
 name: "homework-details",
   
  
  data() {
    return {
      assignments: [],
    };
  },
  created() {
    DatabaseService.getHomework()
      .then(response => {
        this.assignments = response.data;
      })
      .catch(error => {
        console.error(error);
      });
  },
};
</script>
