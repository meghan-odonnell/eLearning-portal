<template>
  <div class="home">
    <div class="container">
      <img src="../img/superSmartBannerfixedup.jpg" alt="super-smart" />
    </div>

    <router-link
      v-bind:to="{ name: 'logout' }"
      v-if="$store.state.token != ''"
      class="table-link"
      >Logout</router-link
    >
    &nbsp;

    <class-list></class-list>
  </div>
</template>

<script>
import ClassList from "../components/ClassList.vue";

export default {
  components: {
    ClassList,
  },
  name: "home",
};
</script>
<style scoped>
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

.table a {
  color: #5f9ea0;
  font-family: "Comfortaa", sans-serif;
  font-size: 24px;
  text-transform: uppercase;
  text-decoration: none;
  padding: 10px 20px;
  border-radius: 10px;
  background-color: #f8f8f8;
  margin: 0 10px;
}
</style>