<template>
  <section class="section" id="app">
    <div class="content">
      <p class="title has-text-white">ข้อมูลลูกค้า</p>
      <div class="columns is-multiline">
        <div class="column is-10">
          <input
            class="input is-danger"
            type="text"
            v-model="search"
            placeholder="Customer Name, Movie Order"
          />
        </div>
        <div class="column is-2">
          <button
            @click="getCustomer()"
            class="button px-3 is-danger is-fullwidth"
          >
            <strong>Search</strong>
          </button>
        </div>
      </div>
      <div class="column m-5">
        <div class="field level-right">
          <div class="control"></div>
        </div>
        <table
          class="table is-bordered has-background-warning-dark has-text-white"
        >
          <tr>
            <td>ไอดี</td>
            <td>อีเมลล์</td>
            <td>ชื่อ</td>
            <td>เบอร์โทรศัพท์</td>
            <td>จำนวนรายการสั่งซื้อ</td>
            <td>ดูข้อมูล</td>
          </tr>
          <tr
            v-for="customer in customer"
            :key="customer.cid"
            class="has-background-warning-light has-text-black"
          >
            <td>{{ customer.cid }}</td>
            <td>{{ customer.email_id }}</td>
            <td>{{ customer.c_name }}</td>
            <td>{{ customer.phone_no }}</td>
            <td>{{ customer.order }}</td>
            <td>
              <button
                class="button is-success"
                @click="(customerModal = true), getOrder(customer.cid)"
              >
                รายละเอียด
              </button>
            </td>
            <div class="modal" :class="{ 'is-active': customerModal }">
              <div class="modal-background"></div>
              <div class="modal-card" style="width:80%">
                <header class="modal-card-head">
                  <div class="column">
                    <div class="column">
                      <p>ช้อมูลลูกค้าไอดี {{ customerDetail.cid }}</p>
                      <div class="column is-6 has-text-left">
                        <p>ไอดี: {{ customerDetail.cid }}</p>
                        <p>อีเมลล์: {{ customerDetail.email_id }}</p>
                        <p>ชื่อ: {{ customerDetail.c_name }}</p>
                        <p>เบอร์โทรศัพท์: {{ customerDetail.phone_no }}</p>
                      </div>
                    </div>
                  </div>
                </header>
                <section class="modal-card-body modal-content-width">
                    <p class="title">รายการคำสั่งซื้อทั้งหมด</p>
                        <table>
                            <tr>
                                <td>รายการคำสั่งซื้อที่</td>
                                <td>ที่นั่ง</td>
                                <td>ราคารวม</td>
                                <td>โรงหนัง</td>
                                <td>ชื่อหนัง</td>
                                <td>รอบฉายที่</td>
                                <td>วันที่ฉาย</td>
                                <td>เวลาเริ่ม</td>
                            </tr>
                            <tr v-for="order in orderDetail" :key="order.order_id">
                                <td>{{order.order_id}}</td>
                                <td>{{order.order_seats}}</td>
                                <td>{{order.total_price}}</td>
                                <td>{{order.tname}}</td>
                                <td>{{order.m_name}}</td>
                                <td>{{order.show_id}}</td>
                                <td>{{order.show_date}}</td>
                                <td>{{order.st_time}}</td>
                            </tr>
                            <tr v-if="orderDetail.length == 0">
                                <td>-</td>
                                <td>-</td>
                                <td>-</td>
                                <td>-</td>
                                <td>-</td>
                                <td>-</td>
                                <td>-</td>
                                <td>-</td>
                            </tr>
                        </table>
                </section>
                <footer class="modal-card-foot">
                  <button
                    @click="customerModal = false"
                    class="button is-success"
                  >
                    ออก
                  </button>
                </footer>
              </div>
            </div>
          </tr>
        </table>
      </div>
    </div>
  </section>
</template>
<script>
import axios from "@/plugins/axios";
export default {
  name: "app",
  props: ["user"],
  data() {
    return {
      customer: "",
      customerDetail: "",
      orderDetail: "",
      customerModal: false,
      search: ""
    };
  },
  mounted() {
    window.scrollTo(0, 0);
    this.getCustomer();
  },
  methods: {
    getCustomer() {
      axios
        .get(`http://localhost:3000/customer/`, {          params: {
            search: this.search}})
        .then((response) => {
          this.customer = response.data.customer;
        })
        .catch((err) => {
          console.log(err);
        });
    },
    getOrder(id) {
      axios
        .get(`http://localhost:3000/customer/detail/${id}`)
        .then((response) => {
          this.orderDetail = response.data.order;
          for (var i=0; i<this.orderDetail.length; i++){
              this.orderDetail[i].show_date = new Date(this.orderDetail[i].show_date).toDateString()
          }
          this.customerDetail = response.data.customer[0];

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
    },
  },
};
</script>