
<template>
    <div class="container is-widescreen">
        <section class="section" id="app">
            <div class="content">
                <p class="title has-text-left mb-2">
                    สินค้าทั้งหมด (1)
                </p>
                <hr />

                <div class="columns is-multiline">
                    <div class="column is-3">
                        <div class="card" id="card1">
                            <div class="card-image pt-4">
                                <figure>
                                    <img src="https://twicpics.celine.com/product-prd/images/large/344893602C.38NO_1_WIN21.jpg?twic=v1/cover=1:1/resize-max=480"
                                        alt="">
                                </figure>
                            </div>
                            <div class="card-content">
                                <div class="text">CELINE MARGARET LOAFER WITH TRIOMPHE CHAIN IN POLISHED BULLBLACK</div>
                                <div class="content zonecon">
                                    <span>฿</span>
                                    39,500
                                </div>
                            </div>
                            <footer class="card-footer">
                                <router-link class="card-footer-item has-text-dark" id='button'
                                    to="editproduct">Edit</router-link>
                            </footer>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>
</template>
<style>
.btn1 {
    width: 100%;
}
#card1 {
  width: 100%;
  background-color: rgb(213, 215, 218);
  border-radius: 15px;
  padding-top: 20px;

}
</style>
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
