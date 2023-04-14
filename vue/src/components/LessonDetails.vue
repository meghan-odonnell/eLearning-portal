<template>
<div>Test LESSON DETAILS
  <div class="lesson-detail">  
 
    <h1>{{ curriculum.curriculumName }}</h1>
    <th>{{ curriculum.curriculumName }}</th>
        <p>{{ curriculum.reading }}</p>
        <p>HOMEWORK: {{ curriculum.homework}}</p>
        <p>RESOURCES: {{ curriculum.resources}}</p>
        
 
  </div>
  </div>
</template>

<script>
import DatabaseService from '../services/DatabaseService.js';

export default {
  name: 'lesson-detail',
  
  data() {
    return {
      curriculum: [],
    };
  },


  created() {
    DatabaseService.getOneCurriculum(this.$route.params.id)
    .then((response) => {
      this.curriculum = response.data;
      })
    .catch(
      
      )
    

},
}
</script>