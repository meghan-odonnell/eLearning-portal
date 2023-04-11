
<template>
  <div id="login">
    <form @submit.prevent="login">
      <h1 >Welcome to the eLearning Portal!</h1>
      <h2>Please Sign In</h2>
      <div class="alert" role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div class="alert" role="alert" v-if="this.$route.query.registration" v-alert:value="alert">
        Registration successful!
      </div>
      <div class="form-input-group">
        <label for="username">Username</label>
        <input type="text" id="username" v-model="user.username" required autofocus />
      </div>
      <div class="form-input-group">
        <label for="password">Password</label>
        <input type="password" id="password" v-model="user.password" required />
      </div>
      <button type="submit">Sign in</button>
      <p>
      <router-link :to="{ name: 'register' }">Need an account? Sign up here.</router-link></p>
    </form>
   <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Comfortaa|Didact Gothic">
  </div>
</template>

<script>
import authService from "../services/AuthService";


export default {
  name: "login",
  components: {
   
  },
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style scoped>
.form-input-group {
  margin-bottom: 1rem;
}



h1 { 
    color: rgb(249, 250, 252);
    font-family: "Comfortaa";
    font-size: 50px;
    padding: 20px;
    max-width: 100%;
    display: block;
    margin-left: auto;
    margin-right: auto;
    width: 100%;
    text-align: center;
    border-radius: 20px;
    margin-bottom: 50px;
}

h2 { 
    color: rgb(0, 0, 0);
    padding: 20px;
    font-family: "Didact Gothic";
    font-size: xx-large;
    max-width: 100%;
    display: block;
    margin-left: auto;
    margin-right: auto;
    width: 300px;
    text-align: center;
    margin-bottom: 0px;
    text-decoration-line: underline;
}

div.form-input-group {
    color: rgb(0, 0, 0);
    padding: 20px;
    font-family: "Didact Gothic";
    font-size: large;
    font-weight: bold;
    max-width: 100%;
    display: block;
    margin-left: auto;
    margin-right: auto;
    width: 300px;
    text-align: center;
    margin-bottom: 30px;
}

button {
    color: rgb(250, 249, 249);
    font-family: "Comfortaa";
    font-size: large;
    font-weight: bold;
    padding: 20px;
    background: rgb(6, 61, 94);
    max-width: 100%;
    display: block;
    margin-left: auto;
    margin-right: auto;
    width: 8%;
    text-align: center;
    border-radius: 25px;
    margin-bottom: 80px;
}

p {
    font-family: "Didact Gothic";
    font-weight: bold;
    color: rgb(0, 0, 0);
    padding: 5px;
    max-width: 100%;
    font-size: large;
    display: block;
    margin-left: auto;
    margin-right: auto;
    width: 10%;
    text-align: center;
    background: rgb(142, 219, 238);
    border-radius: 10px;
}

.alert {
    text-align: center;
    font-family: "Comfortaa";
}

label {
  margin-right: 0.5rem;
}
</style>