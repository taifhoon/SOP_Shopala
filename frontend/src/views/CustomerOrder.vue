<template>
  <div class="container is-widescreen">
    <router-link class="has-text-dark" id='button' to="/">
        <div class="arrow">
          <img class="imgarrow"
            src="https://www.flaticon.com/svg/vstatic/svg/3916/3916810.svg?token=exp=1671377228~hmac=1258a1e45339936c5da1bcba43dcf873"
            alt="">
        </div>
      </router-link>
    <section class="section" id="app">
      <div class="content">
        <p class="title has-text-left  mb-2">
          My Order
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
                <div class="column is-4">รายระเอียด</div>
                <div class="column is-2">จำนวน</div>
                <div class="column is-2">ราคารวม</div>
              </div>

              <div class="columns box">
                <div class="column is-4">
                  <div class="row">
                    <div class="columns is-align-items-center">
                      <div class="column is-1"><input type="checkbox" /></div>
                      <div class="column "><img
                          src="https://twicpics.celine.com/product-prd/images/large/344893602C.38NO_1_WIN21.jpg?twic=v1/cover=1:1/resize-max=480"
                          alt="" />
                      </div>
                    </div>
                  </div>
                </div>
                <div class="column is-4">CELINE MARGARET LOAFER WITH TRIOMPHE CHAIN IN POLISHED BULLBLACK</div>
                <div class="column is-2">2</div>
                <div class="column is-2">4,000</div>
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

// import axios from "@/plugins/axios";
export default {
    name: "app",
    props: ["user"],
    data() {
        return {
        // customer: [],
        // order: [],
        // paid: [],
        // wait: [],
        // ticket: [],
        // cancleModal: false,
        // ticketModal: false,
        };
    },
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
