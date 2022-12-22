
<template>
    <div class="container is-widescreen">
        <router-link class="has-text-dark" id='button' to="/seller/home">
            <div class="arrow">
                <img class="imgarrow"
                    src="https://cdn.discordapp.com/attachments/1033283242121498625/1055543133351448678/arrow-left.png"
                    alt="">
            </div>
        </router-link>
        <section class="section" id="app">
            <div class="columns mb-6 is-justify-content-center">
                <input class="input column is-6 is-align-self-center" type="text" v-model="searchinput"
                    placeholder="Search anything that you wants . . . ">
                <div class="btnsearc column is-1" @click="Search()">
                    <a class="navbar-item">
                        <img src="https://cdn.discordapp.com/attachments/1033283242121498625/1054774681930047518/search.png"
                            class="imgsearch">
                    </a>
                </div>
            </div>
            <div class="content">
                <p class="title has-text-left mb-2">
                    สินค้าทั้งหมด ({{ listProducts.length }})
                </p>
                <hr />

                <div class="columns is-multiline">
                    <div class="column is-3" v-for="(item, index) in listProducts" :key="index">
                        <div class="card" id="card1">
                            <div class="card-image pt-4">
                                <figure>
                                    <img 
                                    class="imaproduct"
                                    :src="item.photo"
                                        alt="">
                                </figure>
                            </div>
                            <div class="card-content">
                                <div class="text">
                                    <h4>{{ item.name }}</h4>
                                </div>
                                <div class="text">{{ item.detail }}</div>
                                
                                <div class="content zonecon" v-if="item.type.length > 1">
                                    <span>฿</span>
                                    {{ item.type[0].price }} - {{ item.type[item.type.length - 1].price }}
                                </div>
                                <div class="content zonecon" v-else>
                                    <span>฿ {{ item.type.price }}</span>
                                </div>
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

<script>
// import router from '@/router';

import axios from "@/plugins/axios";
export default {
    name: "app",
    props: ["user"],
    data() {
        return {
            searchinput: "",
            userid:"1",
            // customer: [],
            // order: [],
            // paid: [],
            // wait: [],
            // ticket: [],
            // cancleModal: false,
            // ticketModal: false,
            listProducts: []
        };
    },
    // components: { router }
    mounted() {
        this.getProducts()
    },
    methods: {
        getProducts() {
            axios
                .get(`http://localhost:8001/getProducts`)
                .then((res) => {
                    this.listProducts = res.data.filter(item => {
                        return item.sellerId == this.userid
                    })
                    console.log(this.listProducts)
                })
                .catch((error) => {
                    alert(error.response.data.message)
                });
        },
        Search() {
            if (this.searchinput != "") {
                this.listProducts = this.listProducts.filter((item) => item.name.toLowerCase().includes(this.searchinput.toLowerCase()));
            }
            // axios
            //     .get(`http://localhost:8001/getProducts`)
            //     .then((res) => {
            //         this.listProducts = res.data

            //         if (this.searchinput != "") {
            //             this.listProducts = this.listProducts.filter((item) => item.name.includes(this.searchinput));
            //         }
            //     })
            //     .catch((error) => {
            //         alert(error.response.data.message)
            //     });
        },
    }
};
</script>
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

.arrow {
    width: 30px;
    height: 30px;
    position: absolute;
    top: 0%;
    left: 0;
}
.imaproduct {
  height: 220px;
  object-fit: cover;
}
</style>
