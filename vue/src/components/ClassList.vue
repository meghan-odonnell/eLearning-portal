<template>
  <div>
      <h1 class="classlist">Class List:</h1>
      <table>
          <thead>
              <tr>
                  <th class="math">Math</th>
                  <th class="science">Science</th>
                  <th class="cp">Computer Programming</th>
              </tr>
          </thead>
          <tbody>
              <tr  v-for="item in classes" v-bind:key="item.courseId">
              <td>{{ item.courseId }}</td>
              <td>{{ item.courseName }}</td>
              <td>{{ item.courseDescription }}</td>
              </tr>
          </tbody>
      </table>
  </div>
</template>

<script>

import classListService from '../services/ClassList.js'

export default {
    name: 'class-list',
    data() {
        return {
            classes: [],
        }
    },
    created() {
        classListService.getAllClasses().then(response => {
            this.classes = response.data;
        })
    }

}
</script>

<style>
h1.classlist {
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
    margin-top: 10px;
    
}


</style>