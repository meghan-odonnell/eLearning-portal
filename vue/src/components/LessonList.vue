<template>
  <div>
    <h1>{{ courseName }} Curriculum</h1>
    <ul>
      <li v-for="curriculum in curricula" :key="curriculum.curriculum_id">
        <router-link :to="{ name: 'LessonDetail', params: { id: curriculum.curriculumId } }">
          {{ curriculum.curriculumName }}
        </router-link>
      </li>
    </ul>
  </div>
</template>

<script>
import DatabaseService from '../services/DatabaseService.js';

export default {
  name: 'CurriculumList',
  data() {
    return {
      curricula: [],
      courseName: '',
    };
  },
  async created() {
    const courseId = this.$route.params.id;
    const response = await DatabaseService.getOneCurriculum(this.curriculum.curriculumId;
    this.curricula = response.data;
    
};
</script>
