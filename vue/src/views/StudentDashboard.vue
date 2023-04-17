<template>
    <div>
        <header-pic></header-pic>
        
        <router-link
      v-bind:to="{ name: 'logout' }"
      v-if="$store.state.token != ''"
      class="table-link"
      >Logout</router-link>
      
  
    &nbsp;
        <class-list></class-list>
        <assignments></assignments>
    </div>
</template>
<script>
import Assignments from '../components/Assignments.vue'
import ClassList from '../components/ClassList.vue'
import HeaderPic from '../components/HeaderPic.vue'

export default {
    components: {
        Assignments,
        HeaderPic,
        ClassList
    } 
}
</script>



<style>

</style>