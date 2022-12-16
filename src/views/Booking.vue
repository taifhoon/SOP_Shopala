<template>
  <section class="section" id="app">
    <div class="content">
      <div class="columns">
      <div class="column is-1 has-text-left has-text-white p-5"></div>
        <div class="column box has-background-grey-lighter has-text-left has-text-black p-5">
          <h2>ข้อมูลการจอง</h2>
          <p class="is-size-5">เลขที่รายการคำสั่งซื้อ : {{ order.order_id }}</p>
          <p class="is-size-5">ชื่อลูกค้า : {{ customer.c_name }}</p>
          <p class="is-size-5">เรื่อง : {{ movies.m_name }}</p>
          <p class="is-size-5">วันที่ฉาย : {{ show.show_date }}</p>
          <p class="is-size-5">รอบฉาย : {{ show.st_time }} น.</p>
          <p class="is-size-5">สถานที่ : {{ theatre.tname }}</p>
          <p class="is-size-5">ที่นั่งทั้งหมด : {{ order.order_seats }}</p>
          <p class="is-size-5">สรุปรายการสั่งซื้อ : {{ order.total_price }} บาท</p>
        </div>
        <div class="column  has-text-white">
            <img
              :src="image(movies.img_movie)"
              alt="Placeholder image"
              style="
              height: 350px;
              margin-left: auto;
              margin-right: auto;
              "
            />
        </div>
        <div class="column is-1 has-text-left has-text-white p-5"></div>
      </div>

      <div class="columns pt-5">
        <div class="column box has-background-danger has-text-white">
          <div class="has-text-left my-5">
            <h2 class="is-underlined">สำหรับการซื้อตั๋ว</h2>
            <p class="is-size-4">&emsp;• ข้อตกลงและเงื่อนไข</p>
            <p class="is-size-6">&emsp;&emsp;&emsp;- ลูกค้าต้องทำการชำระเงินก่อนรอบฉาย 25 นาที มิฉะนั้นบัตรที่จองไว้จะถูกยกเลิกโดยอัตโนมัติ</p>
            <p class="is-size-6">&emsp;&emsp;&emsp;- เมื่อลูกค้าทำการซื้อบัตรเรียบร้อยเเล้ว ก่อนเข้าชมภาพยนต์จะต้องโชว์ข้อมูลการชำระเงินไปแล้วให้ทางเจ้าหน้าที่ตรวจสอบ</p>
          </div>
          <div class="column mb-3 box has-background-danger-light has-text-centered">
            <h2 class="my-5">ช่องทางการชำระเงิน</h2>
            <div class="row">
              <div class="columns my-5 px-3 buttons">
                <button class="column button" style="height: 200px;" @click="payment(order.order_id)"><h5>บัตรเครดิตหรือบัตรเดบิต</h5>
                  <img src="https://cdn.pixabay.com/photo/2017/09/18/08/56/credit-card-2761073_1280.png" alt="Placeholder image"
                  style="
                  height: 100px;
                  margin-left: auto;
                  margin-right: auto;"/>
                </button>
                <button class="column button is-dark" style="height: 200px;" @click="payment(order.order_id)"><h5 class="has-text-white">Line Pay</h5>
                  <img src="https://scontent.fbkk5-7.fna.fbcdn.net/v/t1.6435-9/92341124_870244826783542_351061654588358656_n.png?_nc_cat=107&ccb=1-5&_nc_sid=09cbfe&_nc_eui2=AeFb8B8GF-BUydiNIwjdSFhRrPDRVvqF402s8NFW-oXjTbzW_cRiMOtKz59CI5JRT7CQITqXGQ_CrC1KOBY6XRE2&_nc_ohc=awm9jQlVKp4AX-lpoqj&tn=UYmsLABXkAD-x4wL&_nc_ht=scontent.fbkk5-7.fna&oh=00_AT8K-Lr1pNvTPXfus_X1MXg3nMmzA6Vdk0EbsMkrGg2gbg&oe=628EC060" alt="Placeholder image"
                  style="
                  height: 100px;
                  margin-left: auto;
                  margin-right: auto;"/>
                </button>
                <button class="column button" style="height: 200px;" @click="payment(order.order_id)"><h5>Paypal/Amex</h5>
                  <img src="http://pngimg.com/uploads/paypal/paypal_PNG22.png" alt="Placeholder image"
                  style="
                  height: 100px;
                  margin-left: auto;
                  margin-right: auto;"/>
                </button>
                <button class="column button is-dark has-text-white" style="height: 200px;" @click="payment(order.order_id)"><h5 class="has-text-white">QR code</h5>
                  <img src="https://th.qr-code-generator.com/wp-content/themes/qr/new_structure/markets/basic_market/generator/dist/generator/assets/images/websiteQRCode_noFrame.png" alt="Placeholder image"
                  style="
                  height: 100px;
                  margin-left: auto;
                  margin-right: auto;"/>
                </button>
              </div>
            </div>
            <div class="row">
              <div class="columns">
                <div class="column is-3"></div>
                <div class="column">
                <router-link
                  :to="`/profile/myorder/${order.order_id}`"
                  class="card-footer-item has-text-light">
                  <button class="button is-dark has-text-white" >ชำระเงินภายหลัง</button>
                </router-link>
                </div>
                <div class="column is-3"></div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    
    <div class="modal" :class="{'is-active':  checkPayment}">
      <div class="modal-background"></div>
        <div class="modal-card">
          <header class="modal-card-head">
            <p class="modal-card-title has-text-success"><b class="is-size-3">ชำระเงินสำเร็จ</b></p>
          </header>
          <section class="modal-card-body">
            <img class="my-3" src="https://cdn4.iconfinder.com/data/icons/colicon/24/checkmark_done_complete-512.png" alt="Placeholder image"
                style="
                height: 100px;
                margin-left: auto;
                margin-right: auto;"/>
            <p class="is-size-6 mb-3">ระบบได้ยืนยันการสั่งซื้อของลูกค้าเรียบร้อยแล้ว</p>
            <p class="is-size-6 mb-3">ขอบคุณที่ใช้บริการ</p>
          </section>
          <footer class="modal-card-foot">
            <router-link
                :to="`/profile/myorder/${order.order_id}`"
                class="card-footer-item has-text-light">
              <button class="button is-success" >ยืนยัน</button>
            </router-link>
          </footer>
        </div>
    </div>
  </section>
</template>

<script>
import axios from '@/plugins/axios'
export default {
  name: "app",
  props: ["user"],
  data() {
    return {
      order: [],
      customer: [],
      show: [],
      movies: [],
      theatre: [],
      checkPayment: false,
    };
  },
  mounted() {
    window.scrollTo(0, 0)
    this.getOrder(this.$route.params.orderId);
  },
  computed: {},
  methods: {
    getOrder(id) {
      axios
        .get(`http://localhost:3000/booking/${id}`)
        .then((response) => {
          console.log(response.data.show);
          this.order = response.data.order[0];
          this.customer = response.data.customer[0];
          this.show = response.data.show[0];
          this.movies = response.data.movies[0];
          this.theatre = response.data.theatre[0];
          this.show.show_date = new Date(this.show.show_date).toDateString()

          const all_seats = this.order.order_seats.substring(
            0,
            this.order.order_seats.length - 2
          );
          this.order.order_seats = all_seats;
        })
        .catch((err) => {
          console.log(err);
        });
    },
    payment(id) {
      this.checkPayment = true;
      axios
        .put(`http://localhost:3000/booking/${id}`)
        .then((response) => {
          console.log(response);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    image(file_path){
        if (file_path) {
        return "http://localhost:3000/" + file_path;
      } else {
        return "https://bulma.io/images/placeholders/640x360.png";
      }
    }
  },
};
</script>
