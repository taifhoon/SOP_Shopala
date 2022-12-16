<template>
  <div :style="myStyle" id="wrapper">
    <nav class="navbar has-background-black" role="navigation" aria-label="main navigation">
      <div class="navbar-brand">
        <router-link to="/" class="navbar-item has-background-black">
          <a class="navbar-item"
            href="https://shopee.co.th/m/free-shipping?af_siteid=an_15131260000&af_sub_siteid=883977554---Maru-&pid=affiliates&utm_campaign=-&utm_content=883977554---Maru-&utm_medium=affiliates&utm_source=an_15131260000">
            <img src="//onlearn.it.kmitl.ac.th/pluginfile.php/1/theme_remui/logomini/1643255847/itonlearn.png"
              width="112" height="28">
          </a>
        </router-link>

        <a role="button" class="navbar-burger" aria-label="menu" aria-expanded="false" data-target="navbarBasicExample">
          <span aria-hidden="true"></span>
          <span aria-hidden="true"></span>
          <span aria-hidden="true"></span>
        </a>
      </div>

      <div id="navbarBasicExample" class="navbar-menu">
        <div class="search">
          <input class="input" type="text" placeholder="Search anything that you wants . . . ">
        </div>
        <a class="navbar-item is-hoverable has-background-black">
          <img src="https://media.discordapp.net/attachments/1033283242121498625/1053246514908123247/search.png"
            width="30" height="28" class="has-background-black">
        </a>


        <div class="navbar-end">
          <a class="navbar-item is-hoverable has-background-black">
            <img src="https://media.discordapp.net/attachments/1033283242121498625/1053243132524908576/love.png"
              width="30" height="28" class="has-background-black">
          </a>
          <a class="navbar-item is-hoverable has-background-black">
            <img src="https://media.discordapp.net/attachments/1033283242121498625/1053243132176760862/trolley-cart.png"
              width="30" height="28" class="has-background-black">
          </a>
          <div class="navbar-item">
            <div class="buttons">
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
        </div>
      </div>
    </nav>


    <!-- หมวดหมู่ -->
    <nav class="navbar has-background-grey-light is-justify-content-center" role="navigation"
      aria-label="main navigation">
      <div class="navbar-brand">
        <a class="navbar-item">เสื้อผ้า</a>
        <a class="navbar-item ">สุขภาพ/ความงาม</a>
        <a class="navbar-item">สินค้าแม่และเด็ก</a>
        <a class="navbar-item">เครื่องใช้ในบ้าน</a>
        <a class="navbar-item">กีฬา/การเดินทาง</a>
        <a class="navbar-item">อุปกรณ์อิเล็กทรอนิกส์</a>
      </div>
    </nav>



    <div id="app">
      <router-view :key="$route.fullPath" @auth-change="onAuthChange" :user="user" />
    </div>
  </div>
</template>

<script>
// import axios from '@/plugins/axios'
export default {
  data() {
    return {
      user: null,
      order: null,
      orderLength: '',
      myStyle: {
      },
    };
  },
  // mounted() {
  //   this.onAuthChange();
  // },
  // methods: {
  //   getOrderAndTicket(id){
  //     axios.get(`/order/ticket/${id}`)
  //       .then((res) => {
  //         this.order = res.data.order;
  //         var getOrder = res.data.order
  //         this.orderLength = getOrder.length
  //       });
  //   },
  //   onAuthChange() {
  //     const token = localStorage.getItem("token");
  //     if (token) {
  //       this.getUser();
  //     }
  //   },
  //   getUser() {
  //     axios.get("/user/me")
  //       .then((res) => {
  //         this.user = res.data;
  //         this.getOrderAndTicket(this.user.cid)
  //         console.log(this.user.role)
  //       });
  //   },
  //   logout(){
  //     this.user = null,
  //     localStorage.removeItem("token");
  //     this.$router.push({path: '/user/login'})
  //   },
  //   isAdmin(){
  //     if (!this.user) return false
  //     return this.user.role == 'admin'
  //   },
  //   isCusto(){
  //     if (!this.user) return false
  //     return this.user.role == 'customer'
  //   }
  // },
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
