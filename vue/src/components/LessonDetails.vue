<template>
  <div>
    <h1>{{ curriculumName }}</h1>
    <p>{{ reading }}</p>
    <p>{{ homework }}</p>
    <p>{{ resources }}</p>
  </div>
</template>

<script>
import DatabaseService from '../services/DatabaseService.js';

export default {
  name: 'CurriculumDetail',
  data() {
    return {
      curriculumName: '',
      reading: '',
      homework: '',
      resources: '',
    };
  },
  async created() {
    const curriculumId = this.$route.params.id;
    const response = await DatabaseService.getCurriculumById(curriculumId);
    this.curriculumName = response.curriculum_name;
    this.reading = response.reading;
    this.homework = response.homework;
    this.resources = response.resources;
  },
};
</script>