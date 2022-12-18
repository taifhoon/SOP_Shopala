
<template>
    <div class="container is-widescreen">
        <router-link class="has-text-dark" id='button' to="/seller/home">
            <div class="arrow">
                <img class="imgarrow"
                    src="https://www.flaticon.com/svg/vstatic/svg/3916/3916810.svg?token=exp=1671377228~hmac=1258a1e45339936c5da1bcba43dcf873"
                    alt="">
            </div>
        </router-link>
        <section class="section" id="app">
            <div class="content">
                <p class="title has-text-left  mb-2">
                    คำสั่งซื้อ (1)
                </p>
                <hr />
                <div class="columns">
                    <div class="column">
                        <div class="row">
                            <div class="columns box">
                                <div class="column is-2 pt-5">Johnny</div>
                                <div class="column is-2 pt-5">22/10/2022</div>
                                <div class="column box is-4">
                                    <div class="row">
                                        <div class="column">CELINE MARGARET LOAFER WITH TRIOMPHE CHAIN IN
                                            POLISHED
                                            BULLBLACK </div>
                                        <hr />
                                        <div class="column">DIOR ADDICT LIP GLOW</div>
                                    </div>
                                </div>
                                <div class="column is-2 pt-5">รวม 4,000 ฿</div>
                                <div class="column is-2">
                                    <router-link class="has-text-dark" id='button' to="/seller/customerdeatil">
                                        <button class="button has-background-black has-text-white"
                                            style="width: 150px; height: 40px;">รายละเอียด</button>
                                    </router-link>
                                </div>
                            </div>
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