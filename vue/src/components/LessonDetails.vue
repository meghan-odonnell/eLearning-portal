<template>
<div>Test LESSON DETAILS
  <div class="lesson-detail" v-for="item in curriculum" v-bind:key="item.curriculumId">  
 
    <h1>{{ item.curricurriculumName }}</h1>
    <th>{{ item.curriculumName }}</th>
        <p>{{ item.reading }}</p>
        <p>HOMEWORK: {{ item.homework}}</p>
        <p>RESOURCES: {{ item.resources}}</p>
        
   <table>
        

      </table>
  </div>
  </div>
</template>

<script>
import DatabaseService from '../services/DatabaseService.js';

export default {
  name: 'lesson-detail',
  data() {
    return {
      curriculum: [],
    };
  },


  created() {

    //this returns them all
      DatabaseService.getAllCurriculum().then((response) => {
      this.curriculum = response.data;
      });


      
    // const curriculumId = this.$route.params.id;
    // const curriculumId = "S2C1";
    
  //this returns multiple records but they are blank

    // DatabaseService.getOneCurriculum(this.$route.params.id)
    // .then((response) => {
    //   console.log(this.$route.params.id),
    //   console.log("???")
    //   this.curriculum = response.data;
    //   })
    // .catch(
    //   console.log("error"),
    //   console.log(this.$route.params.id)
    //   )
    // },

},
}
</script>