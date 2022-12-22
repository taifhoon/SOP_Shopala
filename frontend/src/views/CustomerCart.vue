<template>
  <div class="container is-widescreen">
    <router-link class="has-text-dark" id='button' to="/">
        <div class="arrow">
          <img class="imgarrow"
            src="https://cdn.discordapp.com/attachments/1033283242121498625/1055543133351448678/arrow-left.png"
            alt="">
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

              <div class="columns box" v-for="(item, index) in customer.cartList" :key="index">
                <div class="column is-4">
                  <div class="row">
                    <div class="columns is-align-items-center">
                      <div class="column is-1"><input type="checkbox" v-model="selOrder" /></div>
                      <div class="column "><img
                          :src="item.productId.photo"
                          alt="" />
                      </div>
                    </div>
                  </div>
                </div>
                <div class="column is-4">{{ item.productId.name }}</div>
                <div class="column is-2">{{item.quantity}}</div>
                <div class="column is-2">{{ calPrice(item) }}</div>
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
                <p class="column has-text-right">฿1500</p>
              </div>
              <div class="columns">
                <p class="column has-text-left">การจัดส่ง</p>
                <p class="column has-text-right">ฟรี</p>
              </div>
              <div class="columns">
                <p class="column has-text-left">รวม</p>
                <p class="column has-text-right">฿1500</p>
              </div>
            </div>
            <div class="has-text-centered ">
              <router-link class="navbar-item" to="/payment">
                <button class="button is-dark ordering btn1">ชำระสินค้า</button>
              </router-link>
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
          customer:{}
        // customer: [],
        // order: [],
        // paid: [],
        // wait: [],
        // ticket: [],
        // cancleModal: false,
        // ticketModal: false,
        };
    },
    mounted(){
      this.getCarts()
    },
    methods:{
      calPrice(){

      },
      async getCarts(){
        await axios
        .get(`http://localhost:8003/getCustomers`)
        .then((res) => {
          this.customer = res.data.filter(item => {
            return item._id == localStorage.getItem("customerId")
          })[0]
        })
        .catch((error) => {
          alert(error.response.data.message)
        });
        await axios
        .get(`http://localhost:8001/getProducts`)
        .then((res) => {
          
          this.customer.cartList.forEach(item => {
            res.data.forEach(product => {
              if(product._id == item.productId){
                item.productId = product
              }
            })
          });
          // this.product = res.data.filter(item => {
          //   return item._id == id
          // })[0]
        })
        .catch((error) => {
          alert(error.response.data.message)
        });
      },
      
    }
    // components: { router }
};
</script>
<style>
.btn1{
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
