<script src="https://kit.fontawesome.com/8ec5a2efe1.js" crossorigin="anonymous"></script>

<template>
  
  <div id="wrapper">
    <div v-if="user == null || user == true">
      <nav class="navbar has-background-black" role="navigation" aria-label="main navigation">
        <div class="navbar-brand">
          <router-link to="/" class="navbar-item has-background-black">
            <a class="navbar-item"
              href="">
              <img src="https://media.discordapp.net/attachments/1033283242121498625/1055520351569854474/logo_1.png"
                width="112" height="28">
            </a>
          </router-link>
          <a role="button" class="navbar-burger" aria-label="menu" aria-expanded="false"
            data-target="navbarBasicExample">
            <span aria-hidden="true"></span>
            <span aria-hidden="true"></span>
            <span aria-hidden="true"></span>
          </a>
        </div>
        <div id="navbarBasicExample" class="navbar-menu">
          <!-- <div class="search">
            <input class="input" type="text" v-model="searchinput" placeholder="Search anything that you wants . . . ">
          </div>
          <router-link to="/" class="button is-black">
            <a class="navbar-item is-hoverable has-background-black">
              <font-awesome-icon icon="far fa-star" />
              <img src="https://media.discordapp.net/attachments/1033283242121498625/1053246514908123247/search.png"
                width="30" height="28" class="has-background-black">
            </a>
          </router-link> -->
          <div class="navbar-end">
            
            <router-link class="navbar-item has-background-black" to="/favorite" v-if="user">
              <a class="navbar-item  is-hoverable has-background-black">
                <img src="https://media.discordapp.net/attachments/1033283242121498625/1053243132524908576/love.png"
                  width="30" height="28" class="has-background-black">
              </a>
            </router-link>
            <router-link class="navbar-item  has-background-black " to="/customer/cart" v-if="user">
              <a class="navbar-item is-hoverable has-background-black">
                <img
                  src="https://media.discordapp.net/attachments/1033283242121498625/1053243132176760862/trolley-cart.png"
                  width="30" height="28" class="has-background-black">
              </a>
            </router-link>
            <router-link class="navbar-item  has-background-black " to="/customer/myorder" v-if="user">
              <a class="navbar-item is-hoverable has-background-black">
                <img src="https://cdn.discordapp.com/attachments/1033283242121498625/1054128439562616925/truck_1.png"
                  width="33" height="33" class="has-background-black">
              </a>
            </router-link>
            <button class="button mt-2 ml-2" @click="logout()" v-if="user">
                  <a>
                    <strong class="has-text-black">Log out</strong>
                  </a>
            </button>
            <div class="navbar-item" v-if="user == null">
              <div class="buttons">
                <router-link to="/user/loginseller" class="button has-background-white-ter mr-6">
                  <a>
                    <strong class="has-text-black">Seller Center</strong>
                  </a>
                </router-link>
                <router-link to="/user/signup" class="button is-dark">
                  <a>
                    <strong class="has-text-white">Sign up</strong>
                  </a>
                </router-link>
                <router-link to="/user/login" class="button">
                  <a>
                    <strong class="has-text-black">Log in</strong>
                  </a>
                </router-link>
              </div>
            </div>
            <div class="navbar-item" v-else-if="user">
              <div class="buttons">
                <router-link to="/customer/profile" class="button is-black">
                  <a>
                    <strong class="has-text-white">{{customer.name}}</strong>
                  </a>
                </router-link>
              </div>
            </div>
          </div>
        </div>
      </nav>
      <!-- ???????????????????????? -->
      <!-- <nav class="navbar has-background-grey-light is-justify-content-center" role="navigation"
        aria-label="main navigation"> -->
        <!-- <div class="navbar-brand">
          <a class="navbar-item">????????????????????????</a>
          <a class="navbar-item ">??????????????????/?????????????????????</a>
          <a class="navbar-item">????????????????????????????????????????????????</a>
          <a class="navbar-item">????????????????????????????????????????????????</a>
          <a class="navbar-item">????????????/??????????????????????????????</a>
          <a class="navbar-item">???????????????????????????????????????????????????????????????</a>
        </div> -->
      <!-- </nav> -->
    </div>

    <div v-else-if="user == false">
      <nav class="navbar has-background-black" role="navigation" aria-label="main navigation">
        <div class="navbar-brand">
          <router-link to="/seller/home" class="navbar-item has-background-black">
            <a class="navbar-item"
            href="">
              <img src="https://media.discordapp.net/attachments/1033283242121498625/1055520351569854474/logo_1.png"
                width="112" height="28">
            </a>
          </router-link>
        </div>
        <div id="navbarBasicExample" class="navbar-menu">
          <div class="navbar-end">
            <div class="navbar-item"> 
              <div class="buttons">
                <button class="button " @click="sellerlogout()">
                  <a>
                    <strong class="has-text-black">Log out</strong>
                  </a>
                </button>
                <router-link to="/seller/profile" class="button is-black">
                  <a>
                    <strong class="has-text-white">{{seller.name}}</strong>
                  </a>
                </router-link>
              </div>
            </div>
          </div>
        </div>
      </nav>
    </div>

    <div id="app">
      <router-view :key="$route.fullPath" />
      <!-- <router-view v-slot="{ Component, route }">
        <component :is="Component" :key="route.path.search" />
      </router-view> -->
    </div>
  </div>
</template>

<script>
import axios from '@/plugins/axios'
// import customerhome from "./views/CustomerHome.vue";
export default {
  data() {
    return {
      user: true,
      customerId:null,
      sellerId:null,
      seller:{},
      customer:{},
      cusId:null,
      selId:null,
      // searchinput: customerhome.data().search = this.searchinput,
    };
  },
  mounted() {
    this.getCustomers()
    this.checkUser()
  },
  methods: {
    async getCustomers(){
      this.sellerId = localStorage.getItem("sellerId")
      this.customerId = localStorage.getItem("customerId")
      await axios
        .get(`http://localhost:8003/getCustomers`)
        .then((res) => {
          res.data.forEach(item => {
            if(item._id == this.customerId){
              this.customer = item
            }
          })
        })
        .catch((error) => {
          alert(error.response.data.message)
        });
        await axios
        .get(`http://localhost:8004/getSellers`)
        .then((res) => {
          res.data.forEach(item => {
            if(item._id == this.sellerId){
              this.seller = item
            }
          })
        })
        .catch((error) => {
          alert(error.response.data.message)
        });
        this.checkUser()
    },
    checkUser(){
      if (this.customerId == null && this.sellerId == null){
        this.user = null
      }
      else if(this.customerId != null){
        this.user = true
      }
      else if(this.sellerId != null){
        this.user = false
      }
      
    },
    logout(){
      localStorage.removeItem("customerId")
      this.$router.push({ path: "/user/login" });
      location.reload();
    },
    sellerlogout(){
      localStorage.removeItem("sellerId")
      this.$router.push({ path: "/user/loginseller" });
      location.reload();
    },
    // statelogin(){
    //   this.cusId = localStorage.getItem("customerId")
    //   this.selId = localStorage.getItem("sellerId")
    //   if(this.cusId == null){
    //     alert("you are not login")
    //     this.$router.push({ path: "/user/login" })
    //     this.selId = false
    //   }
    // }
    
    // Search() {
    //  customerhome.data().search = this.searchinput;
    // }
    // getOrderAndTicket(id){
    //   axios.get(`/order/ticket/${id}`)
    //     .then((res) => {
    //       this.order = res.data.order;
    //       var getOrder = res.data.order
    //       this.orderLength = getOrder.length
    //     });
    // },
    // onAuthChange() {
    //   const token = localStorage.getItem("token");
    //   if (token) {
    //     this.getUser();
    //   }
    // },
    // getUser() {
    //   axios.get("/user/me")
    //     .then((res) => {
    //       this.user = res.data;
    //       this.getOrderAndTicket(this.user.cid)
    //       console.log(this.user.role)
    //     });
    // },
    // logout(){
    //   this.user = null,
    //   localStorage.removeItem("token");
    //   this.$router.push({path: '/user/login'})
    // },
    // isAdmin(){
    //   if (!this.user) return false
    //   return this.user.role == 'admin'
    // },
    // isCusto(){
    //   if (!this.user) return false
    //   return this.user.role == 'customer'
    // }
  },
};
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+Thai:wght@300&family=Prompt:wght@200;300;500&display=swap');

#app {
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
  font-family: 'Noto Sans Thai', sans-serif;
  font-family: 'Prompt', sans-serif;
}

#wrapper {
  width: auto;
  height: 100%;
  background-color: white;
  /* background-image: linear-gradient(rgb(0, 0, 0), rgb(1, 35, 37), rgb(0, 0, 0)); */
  height: 100%;
}

* {
  font-family: 'Noto Sans Thai', sans-serif;
  font-family: 'Prompt', sans-serif;
}

.listmovie:hover {
  transform: scale(1.03);
  transition: 0.3s;
}

.search {
  margin-top: 0.5%;
  margin-left: 3%;
  width: 45%;
}

.iconimg:hover {
  background-color: black;
}

</style>
