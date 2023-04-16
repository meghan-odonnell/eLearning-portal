<template>
  <div>
      <router-link v-bind:to="{ name: 'teacherdashboard' }">
        Back to Dashboard
      </router-link>
    
      <new-course></new-course>
  </div>
</template>

<script>
import NewCourse from '../components/NewCourse.vue'
export default {
 components: { 
      NewCourse 
      },
}
</script>

<style>

