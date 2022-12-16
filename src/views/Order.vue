<template>
  <div class="container is-widescreen">
    <section class="section" id="app">
      <div class="content">
        <p class="title has-text-left has-text-white mb-2">
          My Order ({{ order.length }})
        </p>
        <hr />
        <h1 class="is-size-4 has-text-left has-text-white mb-6">
          ยังไม่ได้ชำระเงิน ({{wait.length}})
        </h1>
        <div class="columns is-multiline">
          <!-- loop -->
                              <p v-if="wait.length == 0" class="ml-5 has-text-white" >
            ไม่มีรายการคำสั่งซื้อ
          </p>
          <div class="column is-3 mt-5" v-for="wait in wait" :key="wait">
            <div class="card" style=" background-image: linear-gradient(rgb(253, 86, 92), white);">
              <div class="card-image pt-5">
                <figure>
                  <!-- ไว้ใส่รูป -->
                  <img style=" width: 150px; height: 237px;"
                    :src="image(wait.img_movie)"
                    alt="Placeholder image"
                  />
                </figure>
              </div>
              <div class="card-content">
                <div class="content" style="height: 100px">
                  รายการสั่งซื้อที่: {{wait.order_id}}<br />
                  {{wait.m_name}} ({{wait.language}})<br />
                  วันที่ฉาย: {{wait.show_date}}
                </div>
              </div>
              <footer class="card-footer ">
                <button @click="linkOrder(wait.order_id)" class="card-footer-item  button is-success">ชำระเงิน</button>
                <button  class="card-footer-item  button is-danger" @click="cancleModal = true">ยกเลิก</button>
              </footer>
            </div>
          <div class="modal" :class="{'is-active':  cancleModal}">
            <div class="modal-background"></div>
              <div class="modal-card">
                <header class="modal-card-head">
                    <p class="modal-card-title"><strong>Are you sure want to delete รายการสั่งซื้อที่ {{wait.order_id}}?</strong></p>
                </header>
                <footer class="modal-card-foot">
                    <button @click="confirmDelete(wait.order_id)" class="button is-danger">Yes</button>
                  <button @click="cancleModal = false" class="button is-success">No</button>
                </footer>
              </div>
            </div>
          </div>
        </div>
        <hr class="mt-6" />
        <h1 class="is-size-4 has-text-left has-text-white mb-6">
          ชำระเงินแล้ว ({{paid.length}})
        </h1>
        <div class="columns is-multiline">
          <p v-if="paid.length == 0" class="ml-5 has-text-white" >
            ไม่มีรายการชำระเงิน
          </p>
          <!-- loop -->

          <div class="column is-3 mt-5" v-for="paid in paid" :key="paid.order_id">
            <div class="card" style=" background-image: linear-gradient(rgb(116, 203, 255), white);">
              <div class="card-image pt-5">
                <figure>
                  <!-- ไว้ใส่รูป -->
                  <img style=" width: 150px; height: 237px;"
                    :src="image(paid.img_movie)"
                    alt="Placeholder image"
                  />
                </figure>
              </div>
              <div class="card-content">
                <div class="content" style="height: 100px">
                  รายการสั่งซื้อที่: {{paid.order_id}}<br />
                  {{paid.m_name}}  ({{paid.language}})<br />
                  วันที่ฉาย: {{paid.show_date}}
                </div>
              </div>
                        <div class="modal" :class="{'is-active':  ticketModal}">
            <div class="modal-background"></div>
              <div class="modal-card">
                <header class="modal-card-head">
                    <p class="modal-card-title"><strong>รายการคำสั่งซื้อที่ {{paid.order_id}}</strong></p>
                </header>
                  <div class="modal-content">
                    <div class="card">
                      <div class="card-content" v-for="ticket in ticket" :key="ticket">
                        <div class="media box has-background-danger-light ">
                          <div class="media-left">
                            <figure class="image is-128x128">
                              <img :src="image(ticket.img_movie)" alt="Placeholder image">
                            </figure>
                          </div>
                          <div class="media-content box has-text-left has-background-info-light">
                            <b><p class=" is-4 is-size-6">{{ticket.m_name}} ({{ticket.language}})</p></b><br>
                            <p class="subtitle is-6">Date - {{ticket.show_date}}<br> Theatre - {{ticket.tname}}</p>
                            <p class="subtitle is-3">{{ticket.no_of_seats}} , {{ticket.st_time}}</p>     
                            <figure>
                              <img style="width: 100%; height: 50px;" src="https://pngimg.com/uploads/barcode/barcode_PNG41.png" alt="Placeholder image">
                              <p class="has-text-black">08548518265845215041</p>
                            </figure>
                          </div>
                        </div>
                        <br><br>
                      </div>
                    </div>
                  </div>
                  <footer class="modal-card-foot">
                    <button @click="ticketModal = false" class="button is-success">ออก</button>
                  </footer>
              </div>
            </div>
              <footer class="card-footer">
                <button  @click="getTicket(paid.order_id)" class="card-footer-item button is-info">รายละเอียดตั๋ว</button>
              </footer>
            </div>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>
<script>
import axios from "@/plugins/axios";
export default {
  name: "app",
  props: ["user"],
  data() {
    return {
      customer: [],
      order: [],
      paid: [],
      wait: [],
      ticket: [],
      cancleModal: false,
      ticketModal: false,
    };
  },
  mounted() {
    window.scrollTo(0, 0)
    this.getOrderCustomer(this.$route.params.id);
  },
  computed: {},
  methods: {
    getOrderCustomer(id) {
      axios.get(`http://localhost:3000/profile/myorder/${id}`).then((res) => {
        this.order = res.data.order;
        this.paid = res.data.paid;
        this.wait = res.data.wait;

        for (var i = 0; i < this.paid.length; i++){
          this.paid[i].show_date = new Date(this.paid[i].show_date).toDateString()
        }
        for (var j = 0; j < this.wait.length; j++){
          this.wait[i].show_date = new Date(this.wait[i].show_date).toDateString()
        }
      });
    },
    confirmDelete(id){
            axios
      .delete(`http://localhost:3000/movie/cancel/${id}`)
      .then((res) => {
        this.cancleModal = false
        this.getOrderCustomer(this.$route.params.id);
        console.log(res)
      }).catch((err) => {
          console.log(err);
        });
    },
    linkOrder(id){
      this.$router.push({path: `/booking/${id}`})
    },
    getTicket(id){
      this.ticketModal = true
      axios.get(`http://localhost:3000/profile/myorder/ticket/${id}`)
      .then((res) => {
        this.ticket = res.data.ticket
        for (var j = 0; j < this.ticket.length; j++){
          this.ticket[j].show_date = new Date(this.ticket[j].show_date).toDateString()
        }
      })
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