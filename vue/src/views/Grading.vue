<template>
  <div>
  <div>
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
</div>
&nbsp;

    <grading-hw></grading-hw>
  </div>
</template>

<script>
import GradingHw from "../components/GradingHw.vue";
export default {
  components: { GradingHw },
    computed: {
    dashboardRoute() {
       if(this.$store.state.user.authorities[0].name === 'ROLE_ADMIN') {
            return {name: "teacherdashboard"};
          } else {
            return {name: "studentdashboard"};
          }
    }
  },


};
</script>

<style>
</style>