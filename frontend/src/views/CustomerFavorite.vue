<template>
  <body class="homepage">
    <div class="container is-widescreen">
      <router-link class="has-text-dark" id="button" to="/">
        <div class="arrow">
          <img
            class="imgarrow"
            src="https://cdn.discordapp.com/attachments/1033283242121498625/1055543133351448678/arrow-left.png"
            alt=""
          />
        </div>
      </router-link>
      <section class="section">
        <div class="content">
          <h1 class="title has-text-left">รายการโปรด</h1>

          <div class="columns is-multiline">
            <div class="column is-3" v-for="(item, index) in product" :key="index">
              <div class="card" id="card">
                <div class="card-image pt-4">
                  <figure>
                    <img
                    class="imaproduct"
                      :src="item.photo"
                      alt=""
                    />
                  </figure>
                </div>
                <div class="card-content">
                  <div class="text">
                    <h4>{{ item.name }}</h4>
                  </div>
                  <div class="text">{{ item.detail }}</div>
                  <div class="content zonecon">
                    <span>฿</span>
                    {{ item.type[0].price }}
                  </div>
                </div>
                <footer class="card-footer">
                  <router-link
                    class="card-footer-item has-text-dark"
                    id="button"
                    :to="`/detail/${item._id}`"
                    >Details</router-link
                  >
                </footer>
              </div>
            </div>
          </div>
        </div>
      </section>
    </div>
  </body>
</template>

<script>
import axios from "@/plugins/axios";
export default {
  name: "app",
  props: ["user"],
  data() {
    return {
      customer: {},
      product: [],
    };
  },
  mounted() {
    this.getCustomer();
    
  },
  methods: {
    async getCustomer() {
      await axios
        .get(`http://localhost:8003/getCustomers`)
        .then((res) => {
          this.customer = res.data.filter((item) => {
            return item._id == localStorage.getItem("customerId");
          })[0];
        })
        .catch((error) => {
          alert(error.response.data.message);
        });
        // console.log(this.customer)
        this.getProducts();
        
    },
    async getProducts() {
      await axios
        .get(`http://localhost:8001/getProducts`)
        .then((res) => {
          this.product = res.data.filter((item) => {
            // console.log(this.customer)
            if (this.customer.favoriteProductId.indexOf(item._id) != -1) {
              // console.log("complete")
              return item
            }
            // this.customer.favoriteProductId.forEach((fav) => {
            // //   console.log(item._id)
            //   console.log("+ " + fav)
            //   return item._id == fav;
            // });
          });[0]
        })
        .catch((error) => {
          alert(error.response.data.message);
        });
        console.log(this.product)
    },
  },
};
</script>
<style>
.arrow {
  width: 30px;
  height: 30px;
  position: absolute;
  top: -5%;
  left: 0;
}
.imaproduct {
  height: 220px;
  object-fit: cover;
}
#card{
   width:100%;
   background-color: rgb(255, 255, 255);
   border-radius: 15px;
   padding-top:20px;
   
 }
 #card:hover{
   box-shadow: 6px 6px rgb(133, 131, 131);
   transform: scale(1.02);
   transition: ease-out 0.5s;
 }
</style>
