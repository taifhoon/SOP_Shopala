<template>
    <div class="container is-widescreen">
        <section class="section box" id="app">
            <p class="title has-text-left pl-5">My Profile</p>
            <hr />
            <div class="columns">
                <div class="column is-2">
                    <img style="width: 130px; height: 130px"
                        src="https://upload.wikimedia.org/wikipedia/commons/thumb/7/7e/Circle-icons-profile.svg/2048px-Circle-icons-profile.svg.png"
                        alt="Placeholder image" />
                </div>
                <div class="column">
                    <div class="row">
                        <div class="columns">
                            <div class="column is-2">
                                <p>ชื่อ :</p>
                            </div>
                            <div class="column is-5">
                                <input class="input" type="text" v-model="seller.name" />
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="columns">
                            <div class="column is-2">
                                <p>อีเมล :</p>
                            </div>
                            <div class="column is-5">
                                <input class="input" type="text" v-model="seller.email" />
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="columns">
                            <div class="column is-2">
                                <p>รหัสผ่าน :</p>
                            </div>
                            <div class="column is-5">
                                <input class="input" type="text" v-model="seller.password" />
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="columns">
                            <div class="column is-2">
                                <p>ที่อยู่ :</p>
                            </div>
                            <div class="column is-5">
                                <input class="input" type="text" v-model="seller.address" />
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="columns">
                            <div class="column is-2">
                                <p>ธนาคาร :</p>
                            </div>
                            <div class="column is-5">
                                <input class="input" type="text" v-model="seller.bank" />
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="columns">
                            <div class="column is-2">
                                <p>เลขบัญชี :</p>
                            </div>
                            <div class="column is-5">
                                <input class="input" type="text" v-model="seller.accountNumber" />
                            </div>
                        </div>
                    </div>
                    <div class="row mt-5">
                        <div class="columns">
                            <div class="column is-2">
                                <router-link to="/seller/home">
                                    <button class="button is-success" @click="save()" style="width: 140px;">
                                        Save
                                    </button>
                                </router-link>
                            </div>
                            <div class="column is-2">
                                <router-link to="/seller/home">
                                    <button class="button is-info" style="width: 140px;">Cancel</button>
                                </router-link>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>
</template>
<script>
import axios from 'axios';

// import axios from "@/plugins/axios";
export default {
    name: "app",
    props: ["user"],
    data() {
        return {
            seller: {},
            password: "",
            email: "",
            name: "",
            address: "",
            bank: "",
            numberBank: ""
        };
    },
    mounted() {
        this.getSeller()
    },
    // created() {
    //   this.getProfile();
    // },
    methods: {
        getSeller() {
            axios.get("http://localhost:8004/getSellers")
                .then((res) => {
                    this.seller = res.data.filter(item => {
                        return item._id == localStorage.getItem("sellerId")
                    })[0]
                })
                .catch((error) => {
                    alert(error.response.data.message)
                });
        },
        save(){
            axios.post("http://localhost:8004/updateSeller", this.seller)
                .then((res) => {
                    console.log(res)
                })
                .catch((error) => {
                    alert(error.response.data.message)
                });
        }
    },

}
</script>
  