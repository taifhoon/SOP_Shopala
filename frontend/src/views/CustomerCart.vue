<template>
  <div class="container is-widescreen">
    <router-link class="has-text-dark" id='button' to="/">
      <div class="arrow">
        <img class="imgarrow"
          src="https://cdn.discordapp.com/attachments/1033283242121498625/1055543133351448678/arrow-left.png" alt="">
      </div>
    </router-link>
    <section class="section" id="app">
      <div class="content">
        <p class="title has-text-left  mb-2">
          My Cart
        </p>
        <hr />
        <h1 class="is-size-4 has-text-left mb-6">
          ตะกร้าสินค้าของฉัน
        </h1>
        <div class="columns">
          <div class="column is-7">
            <div class="row">
              <div class="columns box">
                <div class="column is-4">สินค้า</div>
                <div class="column is-4">รายละเอียด</div>
                <div class="column is-2">จำนวน</div>
                <div class="column is-2">ราคารวม</div>
              </div>
              <div class="columns box" v-for="(item, index) in cart" :key="index">
                <div class="column is-4">
                  <div class="row">
                    <div class="columns is-align-items-center">
                      <div class="column is-1"><input type="checkbox" @change="priceofproduct()"
                          v-model="item.select" /></div>
                      <div class="column "><img :src="item.productId.photo" alt="" />
                        {{ item.productId.name }}
                      </div>
                    </div>
                  </div>
                </div>
                <div class="column is-4 has-text-left m">Size : {{ item.size }}
                  <br> color: {{ item.color }}
                  <br> price: {{ item.price }}
                </div>
                <div class="column is-1">{{ item.quantity }}</div>
                <div class="column is-2">{{ calPrice(item) }}{{ item.result }} ฿</div>
                <div class="button is-danger column is-1 pt-2" @click="removeItem(index)">ลบ</div>
              </div>
            </div>
          </div>
          <div class="column is-1"></div>
          <div class="column is-4">
            <div class="box">
              <p class="title has-text-left  mb-5">
                สรุปคำสั่งซื้อ
              </p>
              <div class="columns">
                <p class="column has-text-left">ราคาสินค้าทั้งหมด</p>
                <p class="column has-text-right">฿ {{ sumPrice }}</p>
              </div>
              <div class="columns">
                <p class="column has-text-left">การจัดส่ง</p>
                <p class="column has-text-right">ฟรี</p>
              </div>
              <div class="columns">
                <p class="column has-text-left">รวม</p>
                <p class="column has-text-right">฿ {{ sumPrice }}</p>
              </div>
            </div>
            <div class="has-text-centered ">
              <button class="button is-dark ordering btn1" @click="confirm()">ชำระสินค้า</button>
            </div>
          </div>
        </div>
      </div>
      <div>
      </div>
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
      selOrder: [],
      customer: {},
      cart: [],
      sumPrice: 0
      // customer: [],
      // order: [],
      // paid: [],
      // wait: [],
      // ticket: [],
      // cancleModal: false,
      // ticketModal: false,
    };
  },
  mounted() {
    this.getCarts()
  },
  methods: {
    calPrice(item) {
      axios
        .post(`http://localhost:8005/cal`, {
          "quantity": item.quantity,
          "price": item.price
        })
        .then((res) => {
          item.result = res.data
        })
        .catch((error) => {
          alert(error.response.data.message)
        });
    },
    async getCarts() {
      await axios
        .get(`http://localhost:8003/getCustomers`)
        .then((res) => {
          this.customer = res.data.filter(item => {
            return item._id == localStorage.getItem("customerId")
          })[0]
          this.cart = structuredClone(this.customer.cartList);
        })
        .catch((error) => {
          alert(error.response.data.message)
        });
      await axios
        .get(`http://localhost:8001/getProducts`)
        .then((res) => {
          this.cart.forEach(item => {
            item.select = false
            res.data.forEach(product => {
              if (product._id == item.productId) {
                item.productId = product
              }
            })
          });
        })
        .catch((error) => {
          alert(error.response.data.message)
        });
    },
    removeItem(index) {
      this.cart.splice(index, 1)
      this.customer.cartList.splice(index, 1)
      axios
        .post(`http://localhost:8003/updateCustomer`, this.customer)
        .then((res) => {
          console.log(res)
        })
        .catch((error) => {
          console.log(error)
        });
    },
    
    priceofproduct() {
      var price = 0
      var selec = []
      this.cart.forEach(item => {
        if (item.select) {
          price += item.result
          selec.push(item)
        }
      })
      this.sumPrice = price
      this.selOrder = selec
    },
    async confirm() {
      console.log("confirm")
      var newType = []
      this.selOrder.forEach(item => {
        newType.push({
              "productId":item.productId._id,
              "color":item.color,
              "size":item.size,
              "quantity":item.quantity,
              "name": item.productId.name,
              "price":item.result
        })
        this.removeItem(this.customer.cartList.indexOf(item))
      })
      await axios
      .post(`http://localhost:8002/createOrder`, {
          "customerId":localStorage.getItem("customerId"),
          "paymentId":"success",
          "sumPrice": this.sumPrice,
          "type": newType
      })
      .then((res) => {
        console.log(res)
      })
      .catch((error) => {
        console.log(error)
      });

    }
  }
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
