<template>
  <div>
      <h1 class="classlist">Class List:</h1>
      <table>
          <!-- <thead>
              <tr>
                  <th class="math">Math</th>
                  <th class="science">Science</th>
                  <th class="cp">Computer Programming</th>
              </tr>
          </thead> -->
          <tbody>
              <tr  v-for="item in classes" v-bind:key="item.courseId">
              
              <td>{{ item.courseName }}</td>
              <td>{{ item.courseDescription }}</td>
              </tr>
          </tbody>
      </table>
  </div>
</template>

<script>

import DatabaseService from '../services/DatabaseService.js'

export default {
    name: 'class-list',
    data() {
        return {
            classes: [],
        }
    },
    created() {
        DatabaseService.getAllClasses().then(response => {
            this.classes = response.data;
        })
    }

}
</script>

<style>

.classlist {
  font-size: 36px;
  color: #f5a623;
  text-align: center;
}

table {
  border-collapse: collapse;
  margin: 20px auto;
  width: 80%;
}

th, td {
  border: 1px solid #ccc;
  padding: 12px;
  text-align: left;
}

th {
  background-color: #f5a623;
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
   font-family: 'Comfortaa', sans-serif;
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