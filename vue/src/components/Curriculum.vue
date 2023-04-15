<template>
  <div>
    <h1 class="curriculum">Curriculum:</h1>
    <div v-for="item in curriculum" v-bind:key="item.curriculumId">
      <table>
        <th>
          <router-link v-bind:to="{name: 'Lesson', params: { id:item.curriculumId}}"> 
          {{ item.curriculumName }}
           </router-link>
          </th>
        <td>{{ item.reading }}</td>
      </table>
    </div>
  </div>
</template>

<script>
import DatabaseService from "../services/DatabaseService.js";

export default {
  name: "curriculum",
  data() {
    return {
      curriculum: [],
    };
  },
  created() {
    // DatabaseService.getAllCurriculum().then((response) => {
    //   this.curriculum = response.data;
      // const courseId = "S2";
      
      DatabaseService.getCourseCurriculum(this.$route.params.courseName)
      .then((response) => {
        this.curriculum = response.data;
    })
  },
};
</script>

<style>
h1{
  font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
  text-align: center;
}
.container {
  max-width: 100%;
  text-align: center;
}

.home img {
  width: 100%;
  justify-content: center;
  text-align: center;
  margin: 0 auto;
}

</style>