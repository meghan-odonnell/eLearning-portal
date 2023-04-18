<template>
  <div>
    <h1>Update Grade and Submit</h1>

    <div class="homework-to-grade">
      <table>
        <th>Student Id</th>
        <th>Student Name</th>
        <th>Submission Date</th>
        <th>Submitted</th>
        <th>Update Grade</th>

        <tr>
          <td>{{ assignments.studentId }}</td>
          <td>{{ assignments.username }}</td>
          <td>{{ assignments.submittedDate }}</td>
          <td>
            {{ assignments.submitted === true ? "Submitted" : "Not submitted" }}
          </td>
          <!-- <td >
            {{ assignments.grade }}
            </td> -->
          <td>
            <div class="form-input-group">
              <select name="grade">
                <option value="0">0</option>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
              </select>
            </div>
          </td>
        </tr>
      </table>
    </div>
  </div>
</template>

<script>
import DatabaseService from "../services/DatabaseService";
export default {
  components: {},
  name: "homework-to-grade",

  data() {
    return {
      assignments: {},
    };
  },

  created() {
    DatabaseService.getOneAssignment(this.$route.params.id)
      .then((response) => {
        console.log("hits.then");
        this.assignments = response.data;
      })
      .catch(console.log("hits .catch"), console.error("error"));
  },
};
</script>

<style>
</style>