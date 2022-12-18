<style>
.btn1 {
    width: 100%;
}
</style>
<template>
    <div class="container is-widescreen">
        <section class="section" id="app">
            <div class="content">
                <p class="title has-text-left  mb-2">
                    รายละเอียดคำสั่งซื้อ
                </p>
                <hr />
                <div class="box">
                <div class="row pt-5">
                    <div class="columns">
                        <div class="column is-2 has-text-right">ชื่อ :</div>
                        <div class="column has-text-left">Johnny</div>
                    </div>
                </div>
                <div class="row pt-5">
                    <div class="columns">
                        <div class="column is-2 has-text-right">วันที่สั่งซื้อ :</div>
                        <div class="column has-text-left">22/10/2022</div>
                    </div>
                </div>
                <div class="row pt-5">
                    <div class="columns">
                        <div class="column is-2 has-text-right">ที่อยู่ :</div>
                        <div class="column has-text-left">หอพัก SSYPLACE 419/4 ซอยฉลองกรุง 1 (ซอยเกกีงาม1) ถนนฉลองกรุง,
                            เขตลาดกระบัง, จังหวัด กรุงเทพมหานคร 10520</div>
                    </div>
                </div>
                <div class="row pt-5">
                    <div class="columns">
                        <div class="column is-2 has-text-right pt-5">สินค้า :</div>
                        <div class="column has-text-right">
                            <div class="row">
                                <div class="column is-12 has-text-left">
                                    <div class="row">
                                        <div class="columns">
                                            <div class="column is-8">
                                                CELINE MARGARET LOAFER WITH TRIOMPHE CHAIN IN POLISHED BULLBLACK
                                            </div>
                                            <div class="column is-4">
                                                 1 ชิ้น
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="column is-12 has-text-left">
                                    <div class="row">
                                        <div class="columns">
                                            <div class="column is-8">
                                                DIOR ADDICT LIP GLOW
                                            </div>
                                            <div class="column is-4">
                                                 2 ชิ้น
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row pt-5">
                    <div class="columns">
                        <div class="column is-2 has-text-right">รวมทั้งหมด :</div>
                        <div class="column has-text-left">4025 ฿</div>
                    </div>
                </div>
            </div>
                <div class="row pt-5">
                    <div class="columns">
                      <div class="column control">
                        <router-link to="/seller/order" class="has-text-light">
                        <button class="button " style="width: 200px; height: 40px;">Cancel</button>
                      </router-link>
                      </div>
                      <div class="column control">
                        <router-link class="has-text-dark" id='button' to="/seller/order">
                          <button class="button has-background-black has-text-white"
                            style="width: 200px; height: 40px;">ยืนยันคำสั่งซื้อ</button>
                        </router-link>
                      </div>
                    </div>
                </div>
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
