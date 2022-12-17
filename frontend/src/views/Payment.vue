<template>
  <section class="section" id="app">
    <div class="box">
      <div class="is-size-4 has-text-left">
        ที่อยู่ในการจัดส่ง
      </div>
      <div class="columns">
        <div class="column is-3 mt-2">
          <div class="has-text-left ">
            <p>วรณัน วารีประเสริฐ</p>
            <p>(+66) 85920978</p>
          </div>
        </div>
        <div class="column is-7 mt-2">
          <div class="has-text-left">
            <p>หอพัก SSYPLACE 419/4 ซอยฉลองกรุง 1 (ซอยเกกีงาม1) ถนนฉลองกรุง, เขตลาดกระบัง, จังหวัด กรุงเทพมหานคร 10520
            </p>
          </div>
        </div>
        <div class="column is-2">
          <button class="button is-dark " @click="openmodallocal()">เปลี่ยนที่อยู่</button>
        </div>
      </div>
    </div>

    <div class="box">
      <div class="row">
        <div class="columns">
          <div class="column is-3">สินค้า</div>
          <div class="column is-5">รายระเอียด</div>
          <div class="column is-2">จำนวน</div>
          <div class="column is-2">ราคารวม</div>
        </div>

        <div class="columns">
          <div class="column">
            <div class="row">
              <div class="columns is-align-items-center">
                <div class="column "><img
                    src="https://twicpics.celine.com/product-prd/images/large/344893602C.38NO_1_WIN21.jpg?twic=v1/cover=1:1/resize-max=480"
                    alt="" />
                </div>
              </div>
            </div>
          </div>
          <div class="column is-5">CELINE MARGARET LOAFER WITH TRIOMPHE CHAIN IN POLISHED BULLBLACK</div>
          <div class="column is-2">2</div>
          <div class="column is-2">4,000</div>
        </div>

      </div>

      <div class="columns">
        <div class="column is-1 is-align-self-center">หมายเหตุ :</div>
        <div class="column is-3">
          <input class="input" type="text" placeholder="ข้อความถึงผู้ขาย" />
        </div>
        <div class="column is-2 is-align-self-center">Shipping Option:</div>
        <div class="column is-4 is-align-self-center">Standard Delivery - ส่งธรรมดาในประเทศ <br> จะได้รับภายใน 3 - 4 วัน
        </div>
        <div class="column is-2 is-align-self-center">฿ 24</div>
      </div>
      <div class="columns box">
        <div class="column is-8"></div>
        <div class="column is-2 is-align-self-center">ยอดสั่งซื้อ :</div>
        <div class="column is-2 is-align-self-center pl-5 has-text-link">฿ 4,025</div>
      </div>
    </div>

    <div class="box">
      <div class="row">
        <h1 class="my-4">ช่องทางการชำระเงิน</h1>
        <div class="row">
          <div class="columns my-5 px-3 buttons">
            <button class="column button" style="height: 200px;" @click="payment(order.order_id)">
              <h5>บัตรเครดิตหรือบัตรเดบิต</h5>
              <img src="https://cdn.pixabay.com/photo/2017/09/18/08/56/credit-card-2761073_1280.png"
                alt="Placeholder image" style="
                  height: 100px;
                  margin-left: auto;
                  margin-right: auto;" />
            </button>
            <button class="column button is-dark" style="height: 200px;" @click="payment(order.order_id)">
              <h5 class="has-text-white">Line Pay</h5>
              <img
                src="https://d.line-scdn.net/linepay/partner/images/th/logo/linepay_logo_238x54_v5_th.png"
                alt="Placeholder image" style="
                  height: 100px;
                  margin-left: auto;
                  margin-right: auto;" />
            </button>
            <button class="column button" style="height: 200px;" @click="payment(order.order_id)">
              <h5>Paypal/Amex</h5>
              <img src="http://pngimg.com/uploads/paypal/paypal_PNG22.png" alt="Placeholder image" style="
                  height: 100px;
                  margin-left: auto;
                  margin-right: auto;" />
            </button>
            <button class="column button is-dark has-text-white" style="height: 200px;"
              @click="payment(order.order_id)">
              <h5 class="has-text-white">QR code</h5>
              <img
                src="https://th.qr-code-generator.com/wp-content/themes/qr/new_structure/markets/basic_market/generator/dist/generator/assets/images/websiteQRCode_noFrame.png"
                alt="Placeholder image" style="
                  height: 100px;
                  margin-left: auto;
                  margin-right: auto;" />
            </button>
          </div>
        </div>
      </div>
    </div>

    <div class="modal" :class="{ 'is-active': checkPayment }">
      <div class="modal-background"></div>
      <div class="modal-card">
        <header class="modal-card-head">
          <p class="modal-card-title has-text-success"><b class="is-size-3">ชำระเงินสำเร็จ</b></p>
        </header>
        <section class="modal-card-body">
          <img class="my-3" src="https://cdn4.iconfinder.com/data/icons/colicon/24/checkmark_done_complete-512.png"
            alt="Placeholder image" style="
                height: 100px;
                margin-left: auto;
                margin-right: auto;" />
          <p class="is-size-6 mb-3">ระบบได้ยืนยันการสั่งซื้อของลูกค้าเรียบร้อยแล้ว</p>
          <p class="is-size-6 mb-3">ขอบคุณที่ใช้บริการ</p>
        </section>
        <footer class="modal-card-foot">
          <router-link :to="`/profile/myorder/${order.order_id}`" class="card-footer-item has-text-light">
            <button class="button is-success">ยืนยัน</button>
          </router-link>
        </footer>
      </div>
    </div>

    <!-- openmodallocal -->
    <div class="modal" :class="{ 'is-active': localdata }">
      <div class="modal-background"></div>
      <div class="modal-card">
        <header class="modal-card-head">
          <p class="modal-card-title">เปลี่ยนที่อยู่</p>
          <button class="delete" aria-label="close" @click="cancel()"></button>
        </header>
        <section class="modal-card-body">
          <!-- Content ... -->
          <div class="box">
            <div class="columns">
              <input type="radio" key="1">
              <div class="column is-4 mt-2">
                <div class="has-text-left ">
                  <p>วรณัน วารีประเสริฐ</p>
                  <p>(+66) 85920978</p>
                </div>
              </div>
              <div class="column is-8 mt-2">
                <div class="has-text-left">
                  <p>หอพัก SSYPLACE 419/4 ซอยฉลองกรุง 1 (ซอยเกกีงาม1) ถนนฉลองกรุง, เขตลาดกระบัง, จังหวัด กรุงเทพมหานคร
                    10520
                  </p>
                </div>
              </div>
            </div>
          </div>
          <div class="box">
            <div class="columns">
              <input type="radio" key="1">
              <div class="column is-4 mt-2">
                <div class="has-text-left ">
                  <p>วรณัน วารีประเสริฐ</p>
                  <p>(+66) 85920978</p>
                </div>
              </div>
              <div class="column is-8 mt-2">
                <div class="has-text-left">
                  <p>หอพัก SSYPLACE 419/4 ซอยฉลองกรุง 1 (ซอยเกกีงาม1) ถนนฉลองกรุง, เขตลาดกระบัง, จังหวัด กรุงเทพมหานคร
                    10520
                  </p>
                </div>
              </div>
            </div>
          </div>
        </section>
        <footer class="modal-card-foot">
          <button class="button buttconfirm" @click="confirmaddshow()">
            Confirm
          </button>
          <button class="button buttcancle" @click="cancel()">Cancel</button>
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
      localdata: false,
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
    image(file_path) {
      if (file_path) {
        return "http://localhost:3000/" + file_path;
      } else {
        return "https://bulma.io/images/placeholders/640x360.png";
      }
    },
    openmodallocal() {
      this.localdata = true
    },
    cancel() {
      this.localdata = false
    },
    confirmaddshow(){
      this.localdata = false
    }
  },
};
</script>
