<template>
  <div>
    <div  class="container">
   <header-pic></header-pic>
</div>
 <router-link 
  class="btn-2" v-bind:to="{name: 'curriculumform'}" 
  v-if="this.$store.state.user.authorities[0].name === 'ROLE_ADMIN'"
  > Add Curriculum</router-link>


<router-link
  v-bind:to="{ name: 'logout' }"
  v-if="$store.state.token != ''"
  class="table-link"
>
  Logout
</router-link>

<router-link
      v-bind:to="dashboardRoute"
      v-if="$store.state.token != ''"
      class="table-link"
    >
      HOME
    </router-link>
    &nbsp;
      <curriculum></curriculum>
    </div>
</template>

<script>
import Curriculum from '../components/Curriculum.vue'
import HeaderPic from '../components/HeaderPic.vue';

export default {
  components: {
    Curriculum,
    HeaderPic,
  },

  name: "curriculum-list",

  computed: {
    dashboardRoute() {
       if(this.$store.state.user.authorities[0].name === 'ROLE_ADMIN') {
            return {name: "teacherdashboard"};
          } else {
            return {name: "studentdashboard"};
          }
    }
  }
}


</script>
<style>

.container img {
  width: 100%;
  justify-content: center;
  text-align: center;
  margin: 0 auto;
}


.home img {
  width: 100%;
  justify-content: center;
  text-align: center;
  margin: 0 auto;
}

p#auth {
  color: rgb(11, 12, 12);
  font-family: "Comfortaa";
  font-size: 30px;
  max-width: 100%;
  display: block;
  margin-left: auto;
  margin-right: auto;
  width: 100%;
  text-align: center;
  border-radius: 20px;
  margin-bottom: 50px;
}

h1#home {
  color: rgb(0, 0, 0);
  font-family: "Comfortaa";
  font-size: 40px;
  max-width: 100%;
  display: block;
  margin-left: auto;
  margin-right: auto;
  width: 100%;
  text-align: center;
  border-radius: 20px;
  margin-bottom: 50px;
}
.table-link {
  color: #5F9EA0;
  font-family: "Comfortaa", sans-serif;
  font-size: 20px;
  text-transform: uppercase;
  text-decoration: none;
  padding: 8px 8px;
  border-radius: 10px;
  background-color: #F8F8F8;
  margin: 0 5px;
  transition: background-color 0.3s ease;
  float: right;
}
.table-link:hover {
  background-color: #5F9EA0;
  color: #F8F8F8;
  transition: background-color 0.3s ease;
}
</style>