<template>
    <div>
        <header-pic></header-pic>
        
        <router-link
      v-bind:to="{ name: 'logout' }"
      v-if="$store.state.token != ''"
      class="table-link"
      >Logout</router-link>
      
   <router-link
      v-bind:to="{ name: 'home' }"
      v-if="$store.state.token != ''"
      class="table-link"
    >
      HOME
    </router-link>

        <assignments></assignments>
    </div>
</template>
<script>
import Assignments from '../components/Assignments.vue'
import HeaderPic from '../components/HeaderPic.vue'

export default {
    components: {
        Assignments,
        HeaderPic
    } 
}
</script>



<style>

</style>