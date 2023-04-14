<template>
  <div>
      <new-curriculum></new-curriculum>
      
      <lesson-details></lesson-details>
  </div>
</template>

<script>


import LessonDetails from '../components/LessonDetails.vue'
import NewCurriculum from '../components/NewCurriculum.vue'
export default {
  components: { NewCurriculum, LessonDetails },

}
</script>

<style>
    

</style>