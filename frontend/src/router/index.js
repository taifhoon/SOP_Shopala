import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)
const routes = [
  {
    path: '/',
    name: 'Home',
    meta: { login: true },
    component: () => import('../views/CustomerHome.vue') // set home as path '/'
  },
  {
    path: '/seller/home',
    name: 'HomeSeller',
    meta: { seller: true },
    component: () => import('../views/SellerHome.vue') // set home as path '/'
  },
  {
    path: '/user/login',
    name: 'login',
    meta: { guess: true },
    component: () => import('../views/Login.vue')
  },
  {
    path: '/user/signup',
    name: 'Sign up',
    meta: { guess: true },
    component: () => import('../views/Signup.vue')
  },
  {
    path: '/customer/profile',
    name: 'My profile',
    meta: { login: true},
    component: () => import('../views/CustomerProfile.vue')
  },
  {
    path: '/customer/cart',
    name: 'Cart',
    meta: { login: true},
    component: () => import('../views/CustomerCart.vue')
  },
  {
    path: '/customer/myorder/',
    name: 'Order',
    meta: { login: true},
    component: () => import('../views/CustomerMyOrder.vue')
  },
  {
    path: '/detail/:id',
    name: 'Detail',
    meta: {login: true},
    component: () => import('../views/Detail.vue')
  },
  {
    path: '/seller/profile',
    name: 'My profile',
    meta: { seller: true},
    component: () => import('../views/SellerProfile.vue')
  },
  {
    path: '/seller/order',
    name: 'Seller Order',
    meta: {seller: true},
    component: () => import('../views/SellerOrder.vue')
  },
  {
    path: '/seller/customerdeatil',
    name: 'Customer Detail',
    meta: {seller: true},
    component: () => import('../views/SellerCustomerDetail.vue')
  },
  {
    path: '/allproduct',
    name: 'All Product',
    meta: {seller: true},
    component: () => import('../views/SellerAllProduct.vue')
  },
  {
    path: '/addproduct',
    name: 'Add Product',
    meta: {seller: true},
    component: () => import('../views/SellerAddProduct.vue')
  },
  {
    path: '/editproduct/:id',
    name: 'Edit Product',
    meta: {seller: true},
    component: () => import('../views/SellerEditProduct.vue')
  },
  {
    path: '/payment',
    name: 'payment',
    meta: {login: true},
    component: () => import('../views/CustomerPayment.vue')
  },
  {
    path: '/favorite',
    name: 'favorite',
    meta: {login: true},
    component: () => import('../views/CustomerFavorite.vue')
  },
  {
    path: '/user/loginseller',
    name: 'seller login',
    meta: { sellguess: true},
    component: () => import('../views/loginseller.vue')
  },
  {
    path: '/user/signupseller',
    name: 'seller signup',
    meta: { sellguess: true},
    component: () => import('../views/signupseller.vue')
  }
]


const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})
router.beforeEach((to, from, next) => {
  const isLoggedIn = !!localStorage.getItem('customerId')
  const sellerLoggedIn = !!localStorage.getItem('sellerId')
  if (to.meta.login && !isLoggedIn) {
    alert('Please login first!')
    next({ path: '/user/login' })
  }
  else if (to.meta.guess && isLoggedIn) {
    alert("You've already logged in")
    next({ path: '/'})
  }
  else if (to.meta.sellguess && sellerLoggedIn) {
    alert("You've already logged in Seller")
    next({ path: '/seller/home'})
  }
  else if(to.meta.seller && !sellerLoggedIn){
    alert('Please login Seller first!')
    next({ path: '/user/loginseller' })
  }

  next()
})


export default router
