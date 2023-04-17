<template>
  <div>
    <h1>Assignments</h1>

    <div class="homework-to-grade">
      <table>
          
        <th>Student Id</th>
        <th>Student Name</th>
        <th>Submission Date</th>
        <th>Submitted</th>
        <th>Grade</th>
       
          <td>{{ assignments.studentId }}</td>
          <td>{{ assignments.studentName }}</td>
          <td>{{ assignments.submittedDate }}</td>
          <td >
           {{ assignments.submitted === true ? 'Submitted' : 'Not submitted' }}        
          </td>
          <td>{{ assignments.grade }}</td>
        
      </table>
    </div>
  </div>
</template>

<script>
import DatabaseService from '../services/DatabaseService';
export default {
    components: {

    },
    name: 'homework-to-grade',

    date() {
        return {
            assignments: [],
        };
    },

    created() {
      console.log(this.$route.params.id)
        DatabaseService.getOneAssignment(this.$route.params.id)
        .then((response) => {
            this.assignments = response.data;
        })
         .catch();
    }

}
</script>

<style>

</style>