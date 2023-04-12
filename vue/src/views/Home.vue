<template>
  <div class="home">
    <h1 id="home">Home</h1>
    <p id="auth">Courses</p>
    <class-list> </class-list>
    <curriculum>
      <book-card v-bind:sciencecurriculum="scienceCurriculum" v-for="scienceCurriculum in $store.state.scienceCurriculum" v-bind:key="scienceCurriculum.courseId" />
    </curriculum>
    <p class="mathfact">Here's a random math fact:</p>
    <math-fact class="mathfact"></math-fact>
    <p class="math">{{ mathFact }}</p>

    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css?family=Comfortaa%7CDidact Gothic"
    />
  </div>
</template>

<script>
import ClassList from "../components/ClassList.vue";
import MathFact from "../components/MathFact.vue";
import Curriculum from "../components/Curriculum.vue";

export default {
  components: {
    ClassList,
    MathFact,
    Curriculum,
  },

  name: "home",
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