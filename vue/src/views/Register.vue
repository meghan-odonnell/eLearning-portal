<template>
  <div id="register" class="text-center">
    <form @submit.prevent="register">
      <h1>Create Account</h1>
      <div role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
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
      <div class="form-input-group">
        <label for="confirmPassword">Confirm Password</label>
        <input
          type="password"
          id="confirmPassword"
          v-model="user.confirmPassword"
          required
        />
      </div>
      <div class="form-input-group">
        <label for="role">User Type: Choose One: </label>
        <select name="role" v-model="user.role" required>
          <option value="user">Student</option>
          <option value="admin">Teacher</option>
        </select>
      </div>
      <button type="submit">Create Account</button>
      <p>
        <router-link :to="{ name: 'login' }"
          >Already have an account? Log in.</router-link
        >
      </p>
    </form>
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css?family=Comfortaa|Didact Gothic"
    />
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "register",
  data() {
    return {
      user: {
        username: "",
        password: "",
        confirmPassword: "",
        role: "user",
      },
      registrationErrors: false,
      registrationErrorMsg: "There were problems registering this user.",
    };
  },
  methods: {
    register() {
      if (this.role === "ROLE_ADMIN") {
        this.role = "ROLE_ADMIN";
      } else {
        this.role = "ROLE_USER";
      }
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = "Password & Confirm Password do not match.";
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: "/login",
                query: { registration: "success" },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = "Bad Request: Validation Errors";
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = "There were problems registering this user.";
    },
  },
};
</script>

<style scoped>
#register {
  font-family: "Comfortaa", sans-serif;
  display: flex;
  flex-direction: column;
  align-items: center;
}

form {
  display: flex;
  flex-direction: column;
  align-items: center;
  background-color: #f5f5f5;
  padding: 20px;
  border-radius: 5px;
}

h1 {
  margin-bottom: 20px;
}

.form-input-group {
  display: flex;
  flex-direction: column;
  margin-bottom: 15px;
  width: 100%;
  max-width: 300px;
}

label {
  margin-bottom: 5px;
  font-weight: bold;
}

input[type="text"],
input[type="password"] {
  width: 93%;
  padding: 10px;
  font-size: 16px;
  border: none;
  border-radius: 5px;
  background-color: #fff;
  box-shadow: inset 0 1px 3px rgba(0, 0, 0, 0.12),
    inset 0 1px 2px rgba(0, 0, 0, 0.24);
}

input[type="text"]:focus,
input[type="password"]:focus {
  outline: none;
  box-shadow: inset 0 1px 3px rgba(0, 0, 0, 0.12),
    inset 0 1px 5px rgba(0, 0, 0, 0.24), 0 0 5px rgba(74, 144, 226, 0.5);
}

.form-input-group select {
  width: 100%;
  padding: 10px;
  font-size: 16px;
  border: none;
  border-radius: 5px;
  background-color: #fff;
  box-shadow: inset 0 1px 3px rgba(0, 0, 0, 0.12),
    inset 0 1px 2px rgba(0, 0, 0, 0.24);
}

button[type="submit"] {
  background-color: #4a90e2;
  color: #fff;
  border: none;
  padding: 10px 20px;
  margin-top: 20px;
  border-radius: 5px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

button[type="submit"]:hover {
  background-color: #387acc;
}

p {
  margin-top: 20px;
  font-size: 14px;
  text-align: center;
}

a {
  color: #4a90e2;
}

</style>
