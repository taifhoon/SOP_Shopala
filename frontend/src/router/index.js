import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)
const routes = [
  {
    path: '/',
    name: 'Home',
    // meta: { login: true },
    component: () => import('../views/CustomerHome.vue') // set home as path '/'
  },
  {
    path: '/seller/home',
    name: 'HomeSeller',
    // meta: { login: true },
    component: () => import('../views/SellerHome.vue') // set home as path '/'
  },
  // {
  //   path: '/show/:id',
  //   name: 'Book Ticket',
  //   // meta: { login: true },
  //   component: () => import('../views/show.vue')
  // },
  // {
  //   path: '/AddShow/:id',
  //   name: 'Ass Show',
  //   // meta: { login: true },
  //   component: () => import('../views/AddShow.vue')
  // },
  {
    path: '/user/login',
    name: 'login',
    // meta: { guess: true },
    component: () => import('../views/Login.vue')
  },
  {
    path: '/user/signup',
    name: 'Sign up',
    // meta: { guess: true },
    component: () => import('../views/Signup.vue')
  },
  // {
  //   path: '/booking/:orderId',
  //   name: 'Confirm Ticket',
  //   // meta: { login: true },
  //   component: () => import('../views/Booking.vue')
  // },
  // {
  //   path: '/profile/:id',
  //   name: 'My profile',
  //   // meta: { login: true},
  //   component: () => import('../views/Profile.vue')
  // },
  {
    path: '/customer/order',
    name: 'Order',
    // meta: { login: true},
    component: () => import('../views/CustomerOrder.vue')
  },
  {
    path: '/customer/myorder/',
    name: 'Order',
    // meta: { login: true},
    component: () => import('../views/CustomerMyOrder.vue')
  },
  // {
  //   path: '/movies',
  //   name: 'Movie',
  //   // meta: { login: true},
  //   component: () => import('../views/movie.vue')
  // },
  {
    path: '/detail',
    name: 'Detail',
    // meta: {login: true},
    component: () => import('../views/Detail.vue')
  },
  {
    path: '/seller/order',
    name: 'Seller Order',
    // meta: {login: true},
    component: () => import('../views/SellerOrder.vue')
  },
  {
    path: '/seller/customerdeatil',
    name: 'Customer Detail',
    // meta: {login: true},
    component: () => import('../views/SellerCustomerDetail.vue')
  },
  {
    path: '/allproduct',
    name: 'All Product',
    // meta: {login: true},
    component: () => import('../views/SellerAllProduct.vue')
  },
  {
    path: '/addproduct',
    name: 'Add Product',
    // meta: {login: true},
    component: () => import('../views/SellerAddProduct.vue')
  },
  {
    path: '/editproduct',
    name: 'Edit Product',
    // meta: {login: true},
    component: () => import('../views/SellerEditProduct.vue')
  },
  // {
  //   path: '/edit/show/:id',
  //   name: 'Edit Show',
  //   // meta: {login: true},
  //   component: () => import('../views/UpdateShow.vue')
  // },
  {
    path: '/payment',
    name: 'payment',
    // meta: {login: true},
    component: () => import('../views/CustomerPayment.vue')
  },
  {
    path: '/favorite',
    name: 'favorite',
    // meta: {login: true},
    component: () => import('../views/CustomerFavorite.vue')
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
