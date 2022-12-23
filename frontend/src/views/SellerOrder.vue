
<template>
  <div class="container is-widescreen">
    <router-link class="has-text-dark" id="button" to="/seller/home">
      <div class="arrow">
        <img
          class="imgarrow"
          src="https://cdn.discordapp.com/attachments/1033283242121498625/1055543133351448678/arrow-left.png"
          alt=""
        />
      </div>
    </router-link>
    <section class="section" id="app">
      <div class="content">
        <p class="title has-text-left mb-2">
          คำสั่งซื้อ ({{ orders.length }})
        </p>
        <hr />
        <div class="columns">
          <div class="column">
            <div
              class="row"
              v-for="(order, index) in orders"
              :key="index"
            >
              <div class="columns box">
                <div class="column is-2 pt-5">
                  {{ getCustomerById(order.customerId) }}
                </div>
                <div class="column is-2 pt-5">
                  {{ order.date.slice(0, 10) }}
                </div>
                <div class="column box is-4">
                  <div
                    class="row"
                    v-for="(item, index) in order.type"
                    :key="index"
                  >
                    <div class="column">
                      Product: {{ item.name }}<br />Size: {{ item.size
                      }}<br />Color: {{ item.color }}<br />Price:
                      {{ item.price }} ฿
                    </div>
                    <!-- <hr /> -->
                  </div>
                </div>
                <div class="column is-2 pt-5">รวม {{ order.sumPrice }} ฿</div>
                <!-- <div class="column is-2">
                        <router-link class="has-text-dark" id='button' to="/seller/customerdeatil">
                            <button class="button has-background-black has-text-white"
                            style="width: 150px; height: 40px;">รายละเอียด</button>
                        </router-link>
                    </div> -->
              </div>
            </div>
          </div>
        </div>
      </div>
      <div></div>
    </section>
  </div>
</template>
<script>
// import router from '@/router';

import axios from "@/plugins/axios";
export default {
  name: "app",
  props: ["user"],
  data() {
    return {
      sellerId: "",
      sellerOrders: [],
      orders: [],
      products: [],
      customers: [],
      orderWithProduct: [],
      // paid: [],
      // wait: [],
      // ticket: [],
      // cancleModal: false,
      // ticketModal: false,
    };
  },
  mounted() {
    this.getData();
  },
  methods: {
    async getData() {
      await axios
        .get(`http://localhost:8002/getOrders`)
        .then((res) => {
          this.orders = res.data;
        })
        .catch((error) => {
          alert(error.response.data.message);
        });
      await axios
        .get(`http://localhost:8001/getProducts`)
        .then((res) => {
          this.products = res.data;
        })
        .catch((error) => {
          alert(error.response.data.message);
        });
      await axios
        .get(`http://localhost:8003/getCustomers`)
        .then((res) => {
          this.customers = res.data;
        })
        .catch((error) => {
          alert(error.response.data.message);
        });
      this.sellerId = localStorage.getItem("sellerId");
      this.filterOrders();
    },
    filterOrders() {
      // console.log(this.orders)
      this.orders.forEach((order) => {
        this.products.forEach((product) => {
          order.type.forEach((type) => {
            if (type.productId == product._id) {
              type.productId = product;
            }
          });
        });
      });
      this.orders.forEach((order) => {
        order.type.forEach((type) => {
          if (type.productId.sellerId == this.sellerId) {
            this.sellerOrders.push(order);
          }
        });
      });
    },
    getCustomerById(id) {
      var name;
      this.customers.forEach((item) => {
        if (item._id == id) {
          name = item.name;
        }
      });
      return name;
    },
  },
  // components: { router }
};
</script>
<style>
.btn1 {
  width: 100%;
}

.arrow {
  width: 30px;
  height: 30px;
  position: absolute;
  top: -5%;
  left: 0;
}
</style>