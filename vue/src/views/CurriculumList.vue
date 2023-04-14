<template>
  <div>
      <curriculum></curriculum>
    </div>
</template>

<script>
import Curriculum from '../components/Curriculum.vue'

export default {
  components: {
    Curriculum,
  },

  name: "curriculum-list",
};
</script>
<style>
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
</style>