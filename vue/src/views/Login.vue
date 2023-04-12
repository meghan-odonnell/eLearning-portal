
<template>
  <div id="login">
    <form @submit.prevent="login">
      <h1>Welcome to Super-Smart</h1>
      <h2>eLearning Solutions</h2>
      <h3>Please Sign In</h3>
      <div class="alert" role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div class="alert" role="alert" v-if="this.$route.query.registration" v-alert:value="alert">
        Registration successful!
      </div>


      <!-- <input type="button" value = "Test the alert" onclick="alert('Registration successful!');" /> -->
      

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
   <h3 class="math">Random Math Fact</h3>
   <math-fact class="math"></math-fact>
  </div>
</template>

<script>
import authService from "../services/AuthService";
import MathFact from "../components/MathFact.vue"


export default {
  name: "login",
  components: {
   MathFact
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
body {
   background-image: url("../img/image.png");
    
}

.form-input-group {
  margin-bottom: 1rem;
}

.math {
    /* margin-left: 30px; */
    display: block;
    margin-left: auto;
    margin-right: auto;
    width: 100%;
    text-align: center;
  }

h1 { 
    color: rgb(0, 4, 10);
    font-family: "Comfortaa";
    font-size: 50px;
    max-width: 100%;
    display: block;
    margin-left: auto;
    margin-right: auto;
    width: 100%;
    text-align: center;

}

h2 { 
    color: rgb(0, 4, 10);
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

h3 { 
    color: rgb(0, 4, 10);
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
    border-color: black;
    font-family: "Didact Gothic";
    font-size: small;
    font-weight: bold;
    max-width: 100%;
    display: block;
    margin-left: auto;
    margin-right: auto;
    width: 300px;
    text-align: center;
    /* margin-bottom: 30px; */
}

button {
    color: rgb(250, 249, 249);
    font-family: "Comfortaa";
    font-size: large;
    font-weight: bold;
    background: rgb(6, 61, 94);
    max-width: 100%;
    display: block;
    margin-left: auto;
    margin-right: auto;
    padding-top: 20px;
    padding-bottom: 18px;
    padding-right: 1px;
    padding-left: 1px;
    width: 20%;
    text-align: center;
    border-radius: 25px;
    margin-bottom: 80px;
    overflow: hidden;
    white-space: nowrap;
}

p {
    font-family: "Didact Gothic";
    font-weight: bold;
    color: rgb(0, 0, 0);
    max-width: 30%;
    font-size: large;
    display: block;
    padding-top: 1px;
    padding-bottom: 5px;
    padding-right: 10px;
    padding-left: 10px;
    margin-left: auto;
    margin-right: auto;
    text-align: center;
    /* background: rgb(142, 219, 238); */
    border-radius: 10px;
    overflow: hidden;
    white-space: nowrap;
}

/* .alert {
    text-align: center;
    font-family: "Comfortaa";
}

label {
  margin-right: 0.5rem;
} */



/* #modalContainer {
	background-color:rgba(0, 0, 0, 0.3);
	position:absolute;
  top:0;
	width:100%;
	height:100%;
	left:0px;
	z-index:10000;
}

#alertBox {
	position:relative;
	width:33%;
	min-height:100px;
  max-height:400px;
	margin-top:50px;
	border:1px solid #fff;
	background-color:#fff;
	background-repeat:no-repeat;
  top:30%;
}

#modalContainer > #alertBox {
	position:fixed;
}

#alertBox h1 {
	margin:0;
	font:bold 1em Raleway,arial;
	background-color:#f97352;
	color:#FFF;
	border-bottom:1px solid #f97352;
	padding:10px 0 10px 5px;
}

#alertBox p {
	height:50px;
	padding-left:5px;
  padding-top:30px;
  text-align:center;
  vertical-align:middle;
}

#alertBox #closeBtn {
	display:block;
	position:relative;
	margin:10px auto 10px auto;
	padding:7px;
	border:0 none;
	width:70px;
	text-transform:uppercase;
	text-align:center;
	color:#FFF;
	background-color:#f97352;
	border-radius: 0px;
	text-decoration:none;
  outline:0!important;
} */

</style>