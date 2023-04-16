<template>
  <div class="header">

    <h1 class="classlist">Class List:</h1>
    <table>
      <tbody>
        <tr>
          <th>Course Name</th>
          <th>Course Description</th>
          <th>Cost</th>
        </tr>
        <tr v-for="item in classes" v-bind:key="item.courseId">
           
          <td>
           <router-link v-bind:to="{name: 'curriculumlist', params: {courseName:item.courseId}}"> 
            {{ item.courseName }}
             </router-link> 
             </td> 
           
          <td> {{ item.courseDescription }}</td>
          <td> $ {{ item.cost }} </td>
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
    DatabaseService.getAllClasses().then((response) => {
      this.classes = response.data;
    });
  },
};
</script>
<style scoped>

.classlist {
  font-size: 36px;
  color: #5F9EA0;
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

</style>