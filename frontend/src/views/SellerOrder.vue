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
                                <div class="column is-4">CELINE MARGARET LOAFER WITH TRIOMPHE CHAIN IN POLISHED
                                    BULLBLACK</div>
                                <div class="column is-2">2</div>
                                <div class="column is-2">4,000</div>
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