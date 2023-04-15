<template>
<div>
  <h3>fucking work you BITCH</h3>
  <div v-for="item in assignments" v-bind:key="item.assignmentId">
      <table>
        <!-- <th v-bind:to="{name: 'Home', params: { id:item.assignmentId}}">
        
          </th> -->
        <td>{{ item.status }}</td>
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
