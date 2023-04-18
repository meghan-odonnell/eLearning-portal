import Vue from "vue"
import Router from "vue-router"
import Home from "../views/Home.vue"
import Login from "../views/Login.vue"
import Logout from "../views/Logout.vue"
import Register from "../views/Register.vue"
import store from "../store/index"
import Test from "../views/Test.vue"
import Lesson from "../views/Lesson.vue"
import CurriculumList from "../views/CurriculumList.vue"
import StudentDashboard from "../views/StudentDashboard.vue"
import CurriculumForm from "../views/CurriculumForm.vue"
import CourseForm from "../views/CourseForm.vue"
import TeacherDashboard from "../views/TeacherDashboard.vue"
import Grading from "../views/Grading.vue"


Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don"t need to) they"re allowed to go about their way.
 */

const router = new Router({
  mode: "history",
  base: process.env.BASE_URL,
  routes: [

    {
      path: "/",
      name: "home",
      component: Home,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/course/:courseName",
      name: "curriculumlist",
      component: CurriculumList
    },
    {
      path: "/test",
      name: "test",
      component: Test
    },
    {
      path: "/curriculum/:id",
      name: "lesson",
      component: Lesson
    },
    {
      path: "/studentDashboard",
      name: "studentdashboard",
      component: StudentDashboard
    },
    {
      path: "/teacherDashboard",
      name: "teacherdashboard",
      component: TeacherDashboard
    },
    {
      path: "/curriculumForm",
      name: "curriculumform",
      component: CurriculumForm
    },
    {
      path: "/courseForm",
      name: "courseform",
      component: CourseForm
    },
    {
      path: "/grading/:id",
      name: "grading",
      component: Grading
    },
  ]
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === "") {
    next("/login");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
