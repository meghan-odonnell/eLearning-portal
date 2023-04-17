<template>
  <div>
    <h1>Lessons</h1>

    <div v-for="item in curriculum" v-bind:key="item.curriculumId">
      <div>
        
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

      
      DatabaseService.getCourseCurriculum(this.$route.params.courseName)
      .then((response) => {
        this.curriculum = response.data;
    })
  },
};
</script>

<style >
h1{
  font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
  color: #5F9EA0;
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