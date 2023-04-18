<template>
  <div>
    <router-link v-bind:to="{ name: 'teacherdashboard' }">
      Back to Dashboard
    </router-link>

    <new-curriculum></new-curriculum>
  </div>
</template>

<script>
import NewCurriculum from "../components/NewCurriculum.vue";

export default {
  components: {
    NewCurriculum,
  },
};
</script>

<style scoped>
</style>