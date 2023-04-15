<template>
    <div>
     x
      <assignments></assignments>
        <class-list></class-list>
    </div>
</template>

<script>
import Assignments from '../components/Assignments.vue'


import ClassList from '../components/ClassList.vue'

export default {
    components: {
       
        ClassList,
        Assignments
    } ,
    created() {
    console.log('teacher dashboard1');
  }
}
</script>
      



<style>

</style>