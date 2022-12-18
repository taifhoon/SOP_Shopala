<template>
    <div class="container is-widescreen">
        <section class="section" id="app">
            <div class="content">
                <p class="title has-text-left mb-2">
                    My Order
                </p>
                <hr />
                <div class="columns is-multiline">
                    <div class="column is-3 mt-5">
                        <div class="card has-text-dark">
                            <div class="card-image pt-5">
                                <figure>
                                    <!-- ไว้ใส่รูป -->
                                    <img style=" width: 150px; height: 237px;"
                                        src="https://twicpics.celine.com/product-prd/images/large/344893602C.38NO_1_WIN21.jpg?twic=v1/cover=1:1/resize-max=480"
                                        alt="Placeholder image" />
                                </figure>
                            </div>
                            <div class="card-content">
                                <div class="content" style="height: 100px">
                                    รายการสั่งซื้อที่: 1<br />
                                    จำนวนเงิน: 4025 ฿<br />
                                    วันที่: 22/12/2022
                                </div>
                            </div>
                            <div class="columns card-content">
                            <button @click="linkOrder(wait.order_id)"
                                class="card-footer-item  button is-black">เพิ่มเติม</button>
                            <button class="card-footer-item  button "
                                @click="cancleModal = true">ยกเลิกคำสั่งซื้อ</button>
                            </div>
                        </div>
                        <div class="modal" :class="{ 'is-active': cancleModal }">
                            <div class="modal-background"></div>
                            <div class="modal-card">
                                <header class="modal-card-head">
                                    <p class="modal-card-title"><strong>Are you sure want to delete รายการสั่งซื้อที่
                                            1?</strong></p>
                                </header>
                                <footer class="modal-card-foot">
                                    <button @click="confirmDelete(wait.order_id)" class="button is-black">Yes</button>
                                    <button @click="cancleModal = false" class="button ">No</button>
                                </footer>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>
</template>
<script>
//   import axios from "@/plugins/axios";
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
    // mounted() {
    //   window.scrollTo(0, 0)
    //   this.getOrderCustomer(this.$route.params.id);
    // },
    // computed: {},
    // methods: {
    //   getOrderCustomer(id) {
    //     axios.get(`http://localhost:3000/profile/myorder/${id}`).then((res) => {
    //       this.order = res.data.order;
    //       this.paid = res.data.paid;
    //       this.wait = res.data.wait;
    //       for (var i = 0; i < this.paid.length; i++){
    //         this.paid[i].show_date = new Date(this.paid[i].show_date).toDateString()
    //       }
    //       for (var j = 0; j < this.wait.length; j++){
    //         this.wait[i].show_date = new Date(this.wait[i].show_date).toDateString()
    //       }
    //     });
    //   },
    //   confirmDelete(id){
    //           axios
    //     .delete(`http://localhost:3000/movie/cancel/${id}`)
    //     .then((res) => {
    //       this.cancleModal = false
    //       this.getOrderCustomer(this.$route.params.id);
    //       console.log(res)
    //     }).catch((err) => {
    //         console.log(err);
    //       });
    //   },
    //   linkOrder(id){
    //     this.$router.push({path: `/booking/${id}`})
    //   },
    //   getTicket(id){
    //     this.ticketModal = true
    //     axios.get(`http://localhost:3000/profile/myorder/ticket/${id}`)
    //     .then((res) => {
    //       this.ticket = res.data.ticket
    //       for (var j = 0; j < this.ticket.length; j++){
    //         this.ticket[j].show_date = new Date(this.ticket[j].show_date).toDateString()
    //       }
    //     })
    //   },
    //   image(file_path){
    //       if (file_path) {
    //       return "http://localhost:3000/" + file_path;
    //     } else {
    //       return "https://bulma.io/images/placeholders/640x360.png";
    //     }
    //   }
    // },
};
</script>
<style>
.card {
    width: 100%;
    background-color: rgb(213, 215, 218);
    border-radius: 15px;
    padding-top: 20px;

}
</style>