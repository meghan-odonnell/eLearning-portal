<template>
  <div class="header">
    <h1 class="classlist">Class List</h1>
    <table>
      <tbody>
        <tr>
          <th>Course Name</th>
          <th>Course Description</th>
          <th>Cost</th>
        </tr>
        <tr v-for="item in classes" v-bind:key="item.courseId">
          <td>
            <router-link
              v-bind:to="{
                name: 'curriculumlist',
                params: { courseName: item.courseId },
              }"
            >
              {{ item.courseName }}
            </router-link>
          </td>

          <td>{{ item.courseDescription }}</td>
          <td>$ {{ item.cost }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>
<script>
import DatabaseService from "../services/DatabaseService.js";
export default {
  name: "class-list",
  data() {
    return {
      classes: [],
    };
  },
  created() {
    if (this.$store.state.user.authorities[0].name === "ROLE_USER") {
      DatabaseService.getMyClasses(this.$store.state.user.id).then(
        (response) => {
          this.classes = response.data;
        }
      );
    }
    if (this.$store.state.user.authorities[0].name === "ROLE_ADMIN") {
      DatabaseService.getAllClasses().then((response) => {
        this.classes = response.data;
      });
    }
  },
};
</script>
<style scoped>
.classlist {
  font-size: 36px;
  color: #5f9ea0;
  text-align: center;
}
table {
  border-collapse: separate;
  border-spacing: 0;
  margin: 20px auto;
  width: 80%;
  table-layout: fixed; /* or 'auto' */
}
th,
td {
  border: none;
  padding: 12px;
  text-align: left;
}
th:nth-child(2),
td:nth-child(2) {
  width: 70%;
}
</style>