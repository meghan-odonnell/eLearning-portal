<template>
  <div>
    <!-- <h1 class="curriculum">Curriculum:</h1> -->
    <router-link class="btn-2" v-bind:to="{name: 'curriculumform'}"> Add Curriculum</router-link>
    <div v-for="item in curriculum" v-bind:key="item.curriculumId">
      <table>
        <th>
          <router-link v-bind:to="{name: 'lesson', params: { id:item.curriculumId}}"> 
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

.btn-2 {

  color: #F8F8F8;
  font-family: "Comfortaa", sans-serif;
  font-size: 20px;
  text-transform: uppercase;
  
  padding: 8px 8px;
  border-radius: 10px;
  background-color: #F8F8F8;
  margin: 0 5px;
  transition: background-color 0.3s ease;
  float:left;
  


}
.btn-2 {
  background-color: #5F9EA0;
  color: #F8F8F8;
  transition: background-color 0.3s ease;
}


</style>