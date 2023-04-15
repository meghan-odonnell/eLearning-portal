<template>
  <div>
    <h3>Test Page for Homework</h3>
    <ul>
      <li v-for="assignment in assignments" :key="assignment.studentId">
        {{ assignment.curriculumId }} - {{ assignment.status }}
      </li>
    </ul>
  </div>
</template>

<script>
import DatabaseService from '../services/DatabaseService.js'

export default {
  props: {
    studentId: {
      type: Number,
      required: true,
    },
  },
  data() {
    return {
      assignments: [],
    };
  },
  created() {
    DatabaseService.getHomework(this.studentId)
      .then(response => {
        this.assignments = response.data;
      })
      .catch(error => {
        console.error(error);
      });
  },
};
</script>
