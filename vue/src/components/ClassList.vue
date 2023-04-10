<template>
  <div>
      <h1>Class List</h1>
      <table>
          <thead>
              <tr>
                  <th>Math</th>
                  <th>Science</th>
                  <th>Computer Programming</th>
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

</style>