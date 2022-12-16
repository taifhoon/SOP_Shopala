import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)
const routes = [
  {
    path: '/',
    name: 'Home',
    // meta: { login: true },
    component: () => import('../views/Home.vue') // set home as path '/'
  },
  {
    path: '/show/:id',
    name: 'Book Ticket',
    // meta: { login: true },
    component: () => import('../views/show.vue')
  },
  {
    path: '/AddShow/:id',
    name: 'Ass Show',
    // meta: { login: true },
    component: () => import('../views/AddShow.vue')
  },
  {
    path: '/user/login',
    name: 'login',
    // meta: { guess: true },
    component: () => import('../views/Login.vue')
  },
  {
    path: '/booking/:orderId',
    name: 'Confirm Ticket',
    // meta: { login: true },
    component: () => import('../views/Booking.vue')
  },
  {
    path: '/profile/:id',
    name: 'My profile',
    // meta: { login: true},
    component: () => import('../views/Profile.vue')
  },
  {
    path: '/profile/myorder/:id',
    name: 'My Order',
    // meta: { login: true},
    component: () => import('../views/Order.vue')
  },
  {
    path: '/user/signup',
    name: 'Sign up',
    // meta: { guess: true },
    component: () => import('../views/Signup.vue')
  },
  {
    path: '/movies',
    name: 'Movie',
    // meta: { login: true},
    component: () => import('../views/movie.vue')
  },
  {
    path: '/movies/detail/:id',
    name: 'Movie Detail',
    // meta: {login: true},
    component: () => import('../views/movieDetail.vue')
  },
  {
    path: '/add/movies',
    name: 'Create Movies',
    // meta: {login: true},
    component: () => import('../views/AddMovies.vue')
  },
  {
    path: '/add/movies/:id',
    name: 'Edit Movies',
    // meta: {login: true},
    component: () => import('../views/UpdateMovies.vue')
  },
  {
    path: '/edit/show/:id',
    name: 'Edit Show',
    // meta: {login: true},
    component: () => import('../views/UpdateShow.vue')
  },
  {
    path: '/customer',
    name: 'All Customer',
    // meta: {login: true},
    component: () => import('../views/AllCustomer.vue')
  }
]


const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})
router.beforeEach((to, from, next) => {
  const isLoggedIn = !!localStorage.getItem('token')
  if (to.meta.login && !isLoggedIn) {
    alert('Please login first!')
    next({ path: '/user/login' })
  }
  if (to.meta.guess && isLoggedIn) {
    alert("You've already logged in")
    next({ path: '/'})
  }

  next()
})


export default router
