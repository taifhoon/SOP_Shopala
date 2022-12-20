
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
                                    <img src="https://twicpics.celine.com/product-prd/images/large/344893602C.38NO_1_WIN21.jpg?twic=v1/cover=1:1/resize-max=480"
                                        alt="">
                                </figure>
                            </div>
                            <div class="card-content">
                                <div class="text">
                                    <h4>{{ item.name }}</h4>
                                </div>
                                <div class="text">{{ item.detail }}</div>
                                <div class="content zonecon" v-if="item.type.length >= 1">
                                    <span>฿</span>
                                    {{ item.type[0].price }} - {{ item.type[item.type.length - 1].price }}
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

// import axios from "@/plugins/axios";
export default {
    name: "app",
    props: ["user"],
    data() {
        return {
            searchinput: "",
            // customer: [],
            // order: [],
            // paid: [],
            // wait: [],
            // ticket: [],
            // cancleModal: false,
            // ticketModal: false,
            listProducts: [{
                "_id": "a1bba32a-e382-48fc-b4d7-ee2931bac028",
                "name": "iphone 9",
                "photo": "hello",
                "sellerId": "fffffffffffffffffffffff",
                "detail": "ippp",
                "type": [
                    {
                        "price": "32900",
                        "color": "black",
                        "size": "128GB",
                        "quantity": 5
                    },
                    {
                        "price": "39900",
                        "color": "blue",
                        "size": "128GB",
                        "quantity": 3
                    }
                ]
            },
            {
                "_id": "e8fbfb5b-990d-46e9-8832-9a4a78c2a616",
                "name": "iphone XR",
                "detail": "XR",
                "photo": "hello",
                "sellerId": "fffffffffffffffffffffff",
                "type": [
                    {
                        "price": "41900",
                        "color": "silver",
                        "size": "256GB",
                        "quantity": 9
                    },
                    {
                        "price": "55900",
                        "color": "gold",
                        "size": "128GB",
                        "quantity": 4
                    }
                ]
            }]
        };
    },
    // components: { router }
    mounted() {
        // this.getProducts()
    },
    methods: {
        // getProducts() {
        //     axios
        //         .get(`http://localhost:8001/getProducts`)
        //         .then((res) => {
        //             this.listProducts = res.data
        //         })
        //         .catch((error) => {
        //             alert(error.response.data.message)
        //         });
        // },
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
</style>
