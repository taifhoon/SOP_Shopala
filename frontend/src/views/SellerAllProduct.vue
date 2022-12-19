
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
                <p class="title has-text-left mb-2">
                    สินค้าทั้งหมด (1)
                </p>
                <hr />

                <div class="columns is-multiline" >
                    <div class="column is-3" v-for="(item, index) in listProducts" :key="index">
                        <div class="card" id="card1">
                            <div class="card-image pt-4">
                                <figure>
                                    <img src="https://twicpics.celine.com/product-prd/images/large/344893602C.38NO_1_WIN21.jpg?twic=v1/cover=1:1/resize-max=480"
                                        alt="">
                                </figure>
                            </div>
                            <div class="card-content">
                                <div class="text"><h4>{{ item.name }}</h4></div>
                                <div class="text">{{ item.detail }}</div>
                            </div>
                            <footer class="card-footer">
                                <router-link class="card-footer-item has-text-dark" id='button' 
                                :to="`/editproduct/${item._id}`">Edit</router-link>
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

<style>
.arrow {
    width: 30px;
    height: 30px;
    position: absolute;
    top: -5%;
    left: 0;
}
</style>
