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