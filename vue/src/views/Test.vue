<template>
  <div>
      <new-curriculum></new-curriculum>
      <lesson-card></lesson-card>
      <lesson-details></lesson-details>
  </div>
</template>

<script>

import LessonCard from '../components/MiscComp/LessonCard.vue'
import LessonDetails from '../components/LessonDetails.vue'
import NewCurriculum from '../components/NewCurriculum.vue'
export default {
  components: { NewCurriculum, LessonCard, LessonDetails },

}
</script>

<style>
    

</style>