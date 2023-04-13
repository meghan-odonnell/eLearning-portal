<template>
  <div class="header">
  <div class="header-image">
  <img src="../img/superSmartBanner.jpg" alt="super-smart" />
</div>

<router-link
  v-bind:to="{ name: 'logout' }"
  v-if="$store.state.token != ''"
  class="table-link"
>
  Logout
</router-link>


    <h1 class="classlist">Class List:</h1>
    <table>
      <tbody>
        <tr>
          <th>Course Name</th>
          <th>Course Description</th>
          <th>Cost</th>
        </tr>
        <tr v-for="item in classes" v-bind:key="item.courseId">
          <td>{{ item.courseName }}</td>
          <td>{{ item.courseDescription }}</td>
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

<style>
.header {
  position: relative;
  text-align: center;
}

.header img {
  width: 100%;
  max-height: 50%;
}

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
}

th,
td {
  border: none;
  padding: 12px;
  text-align: left;
}

th {
  background-color: #82b3a4;
  color: white;
  font-weight: bold;
  text-transform: uppercase;
}

tr:nth-child(even) {
  background-color: #f8f8f8;
}

tr:hover {
  background-color: #f5f5f5;
  transition: background-color 0.3s ease;
}

td:first-child {
  color: #f5a623;
  font-weight: bold;
}

td:nth-child(2) {
  color: #7f7f7f;
}

tbody {
  font-family: "Comfortaa", sans-serif;
}

.table-link {
  color: #5f9ea0;
  font-family: "Comfortaa", sans-serif;
  font-size: 20px;
  text-transform: uppercase;
  text-decoration: none;
  padding: 8px 8px;
  border-radius: 10px;
  background-color: #f8f8f8;
  margin: 0 5px;
  transition: background-color 0.3s ease;
  float: right;
}

.table-link:hover {
  background-color: #5f9ea0;
  color: #f8f8f8;
  transition: background-color 0.3s ease;
}






/* h1.classlist {
    color: rgb(0, 0, 0);
    padding: 20px;
    font-family: "Didact Gothic";
    font-size: 40px;
    display: block;
    margin-left: 70px;
    margin-right: auto;
    width: 100%;
    margin-bottom: 0px;
    text-decoration-line: underline;
}

table {
    color: rgb(0, 0, 0);
    padding: 20px;
    font-family: "Didact Gothic";
    font-size: 30px;
    display: block;
    margin-left: auto;
    margin-right: auto;
    width: 100%;
    margin-bottom: 0px;
}

th {
    border: thick dotted rgb(0, 0, 0);
    margin: auto;
    max-width: 100%;
    display: block;
    margin-left: auto;
    margin-right: auto;
    width: 100%;
    padding: 10px;
    margin-top: 10px; */
</style>