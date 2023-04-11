<template>
  <div id="register" class="text-center">
    <form @submit.prevent="register">
      <h1>Create Account</h1>
      <div role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <div class="form-input-group">
        <label for="username">Username</label>
        <input type="text" id="username" v-model="user.username" required autofocus />
      </div>
      <div class="form-input-group">
        <label for="password">Password</label>
        <input type="password" id="password" v-model="user.password" required />
      </div>
      <div class="form-input-group">
        <label for="confirmPassword">Confirm Password</label>
        <input type="password" id="confirmPassword" v-model="user.confirmPassword" required />
      </div>
      <button type="submit">Create Account</button>
      <p><router-link :to="{ name: 'login' }">Already have an account? Log in.</router-link></p>
    </form>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Comfortaa|Didact Gothic">
  </div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style scoped>
.form-input-group {
  margin-bottom: 1rem;
}
label {
  margin-right: 0.5rem;
}

h1 {
    color: rgb(0, 0, 0);
    padding: 20px;
    font-family: "Comfortaa";
    font-size: xx-large;
    max-width: 100%;
    display: block;
    margin-left: auto;
    margin-right: auto;
    width: 300px;
    text-align: center;
    margin-bottom: 40px;
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
    width: 400px;
    text-align: center;
    margin-bottom: 30px;
}

button {
    color: rgb(250, 249, 249);
    font-family: "Comfortaa";
    font-size: large;
    padding-top: 20px;
    padding-bottom: 18px;
    padding-right: 4px;
    padding-left: 1px;
    background: rgb(6, 61, 94);
    width: 20%;
    display: block;
    margin-left: auto;
    margin-right: auto;
    text-align: center;
    border-radius: 25px;
    margin-bottom: 80px;
    overflow: hidden;
    white-space: nowrap;
}

p {
    color: rgb(0, 0, 0);
    font-family: "Didact Gothic";
    font-weight: bold;
    padding: 5px;
    max-width: 100%;
    font-size: large;
    display: block;
    margin-left: auto;
    margin-right: auto;
    width: 30%;
    text-align: center;
    background: rgb(142, 219, 238);
    border-radius: 10px;
    overflow: hidden;
    white-space: nowrap;
}
</style>
