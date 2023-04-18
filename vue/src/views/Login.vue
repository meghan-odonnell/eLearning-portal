
<template>
  <div id="login">
    <form @submit.prevent="login">
      <h3>Welcome to</h3>
      <h1>Super-Smart</h1>
      <h2>eLearning Solutions</h2>
      <h3>Please Sign In</h3>
      <div class="badalert" role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div
        class="alert"
        role="alert"
        v-if="this.$route.query.registration"
        v-alert:value="alert"
      >
        Registration successful!
      </div>

      <div class="form-input-group">
        <label for="username">Username</label>
        <input
          type="text"
          id="username"
          v-model="user.username"
          required
          autofocus
        />
      </div>
      <div class="form-input-group">
        <label for="password">Password</label>
        <input type="password" id="password" v-model="user.password" required />
      </div>
      <button type="submit">Sign in</button>
      <p>
        <router-link :to="{ name: 'register' }"
          >Need an account? Sign up here.</router-link
        >
      </p>
    </form>
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css?family=Comfortaa|Didact Gothic"
    />
    <h3 class="math">Random Math Fact</h3>
    <math-fact class="math"></math-fact>
  </div>
</template>

<script>
import authService from "../services/AuthService";
import MathFact from "../components/MathFact.vue";

export default {
  name: "login",
  components: {
    MathFact,
  },
  data() {
    return {
      user: {
        username: "",
        password: "",
      },
      invalidCredentials: false,
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then((response) => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
          console.log(this.$store.state.user);
          if (this.$store.state.user.authorities[0].name === "ROLE_ADMIN") {
            this.$router.push({ name: "teacherdashboard" });
          } else if (
            this.$store.state.user.authorities[0].name === "ROLE_USER"
          ) {
            this.$router.push({ name: "studentdashboard" });
          }
        })
        .catch((error) => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },
  },
};
</script>

<style scoped>
#login {
  max-width: 400px;
  margin: auto;
  padding: 20px;
  background-color: #fff;
  box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.2);
  font-family: "Didact Gothic", sans-serif;
}

h1 {
  font-size: 40px;
  font-family: "Comfortaa", cursive;
  color: #5f9ea0;
  margin-top: 0;
  text-align: center;
}

h2 {
  font-size: 28px;
  font-family: "Comfortaa", cursive;
  color: #5f9ea0;
  margin-top: 0;
  text-align: center;
}

h3 {
  font-size: 24px;
  margin-top: 0;
  margin-bottom: 20px;
  text-align: center;
}

.form-input-group {
  margin-bottom: 20px;
}

label {
  display: block;
  font-size: 18px;
  margin-bottom: 5px;
}

input[type="text"],
input[type="password"] {
  width: 95%;
  padding: 10px;
  font-size: 16px;
  border: 1px solid #ccc;
  border-radius: 5px;
}

button[type="submit"] {
  display: block;
  width: 100%;
  padding: 10px;
  font-size: 16px;
  border: none;
  border-radius: 5px;
  background-color: #007bff;
  color: #fff;
}

button[type="submit"]:hover {
  cursor: pointer;
  background-color: #0069d9;
}

.alert {
  padding: 10px;
  margin-bottom: 20px;
  color: #0e551a;
  background-color: #bdd8bd;
  border: 1px solid #c6f5ce;
  border-radius: 5px;
  text-align: center;
}

.badalert {
  padding: 10px;
  margin-bottom: 20px;
  color: #6e1515;
  background-color: #dda9a9;
  border: 1px solid #dda9a9;
  border-radius: 5px;
  text-align: center;
}

.math {
  font-size: 20px;
  margin-top: 20px;
  text-align: center;
}
</style>