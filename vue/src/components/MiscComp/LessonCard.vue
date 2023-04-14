<template>
  <div>
    <h2>Curricula for {{ curriculumName }}</h2>
    <ul>
      <li v-for="curriculum in curricula" :key="curriculum.id">
        <router-link :to="{ name: 'LessonDetails', params: { id: curriculum.curriculumId } }">{{ curriculum.curriculumName }}</router-link>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  props: {
    curriculumName: String,
    curricula: Array
  }
}
</script>
