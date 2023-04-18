<template>
  <div>
    <lesson-details></lesson-details>
    <!-- <router-link
      v-bind:to="{ name: 'home' }"
      v-if="$store.state.token != ''"
      class="table-link"
    >
      HOME
    </router-link>
   <router-link
      v-bind:to="{ name: 'logout' }"
      v-if="$store.state.token != ''"
      class="table-link"
    >
      Logout
    </router-link> -->
  </div>
</template>

<script>
import LessonDetails from "../components/LessonDetails.vue";

export default {
  components: {
    LessonDetails,
  },
  name: "lesson-view",
};
</script>

<style>
</style>