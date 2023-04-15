<template>
  <div>
    <assignments></assignments>
    <div>
      <button>
        <router-link v-bind:to="{ name: 'CourseForm' }">
          Course Form
        </router-link>
      </button>
    </div>
  </div>
</template>

<script>
import Assignments from "../components/Assignments.vue";

export default {
  components: {
    Assignments,
  },
};
</script>



<style>
</style>