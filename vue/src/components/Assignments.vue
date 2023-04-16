<template>
<div>
  <h1>Assignments</h1>
  
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

    console.log(this.$store.state.user.id)
    console.log(typeof this.$store.state.user.id)

    if(this.$store.state.user.authorities[0].name === 'ROLE_ADMIN') {
      DatabaseService.getHomework()
      .then(response => {
        this.assignments = response.data;
      })
      .catch(error => {
        console.error(error);
      });
    }
   if(this.$store.state.user.authorities[0].name === 'ROLE_USER') 
    DatabaseService.getMyAssignments(this.$store.state.user.id)
      .then(response => {
        this.assignments = response.data;
      })
      .catch(error => {
        console.error(error);
      });
  },
};
</script>

<style >
h1 {
  font-size: 36px;
  color: #5F9EA0;
  text-align: center;
}
</style>
