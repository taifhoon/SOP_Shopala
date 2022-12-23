<template>
    <div class="container is-widescreen">
        <router-link class="has-text-dark" id='button' to="/">
            <div class="arrow">
                <img class="imgarrow"
                    src="https://cdn.discordapp.com/attachments/1033283242121498625/1055543133351448678/arrow-left.png"
                    alt="">
            </div>
        </router-link>
        <section class="section" id="app">
            <div class="content">
                <p class="title has-text-left mb-2">
                    My Order
                </p>
                <hr />
                <div class="columns is-multiline">
                    <div class="column is-4 mt-5" v-for="(item, index) in order" :key="index">
                        <div class="card" id="card">
                            <div class="card-image pt-5">
                                <figure>
                                    <!-- ไว้ใส่รูป -->
                                    <img style=" width: 150px; height: 237px;"
                                        :src="item.type[item.type.length-1].productId.photo"
                                        alt="" />
                                </figure>
                            </div>
                            <div class="card-content">
                                <div class="content" style="height: 5px">
                                    รายการสั่งซื้อที่: {{ index + 1 }}</div>
                                <div class="content" style="height: 5px" v-for="(ty, index1) in item.type"
                                    :key="index1">
                                    "{{ ty.name }}" {{ ty.size }} {{ ty.color }} {{ ty.price }} ฿</div>
                                <div class="content" style="height: 5px">
                                    ราคาสินค้าทั้งหมด: {{ item.sumPrice }} ฿</div>
                                <div class="content" style="height: 5px">
                                    วันที่: {{ item.date.slice(0, 10) }}</div>


                            </div>
                            <div class="columns card-content">
                                <!-- <button @click="linkOrder(wait.order_id)"
                                    class="card-footer-item  button is-black">เพิ่มเติม</button> -->
                                <button class="card-footer-item  button is-danger "
                                    @click="cancleOrder(item)">ยกเลิกคำสั่งซื้อ</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>
</template>
<script>
import axios from "@/plugins/axios";
export default {
    name: "app",
    props: ["user"],
    data() {
        return {
            customer: [],
            order: [],
            // paid: [],
            // wait: [],
            // ticket: [],
            // cancleModal: false,
            // ticketModal: false,
        };
    },
    mounted() {
        this.getOrderCustomer();
    },
    methods: {
        getProduct() {
            axios
                .get(`http://localhost:8001/getProducts`)
                .then((res) => {
                    this.order.forEach(element => {
                        res.data.forEach(product => {
                            if(element.type[element.type.length-1].productId == product._id){
                                element.type[element.type.length-1].productId = product
                            }
                        })
                    });
                })
                .catch((error) => {
                    alert(error.response.data.message)
                });
        },
        async getOrderCustomer() {
            await axios.get(`http://localhost:8002/getOrders`)
                .then((res) => {
                    this.order = res.data.filter(order => {
                        return order.customerId == localStorage.getItem("customerId")
                    })
                });
                this.getProduct()
        },
        async cancleOrder(item) {
            await axios.post(`http://localhost:8002/deleteOrder`, {
                "_id": item._id
            })
                .then((res) => {
                    console.log(res)
                });
            location.reload()
        },
    },
};
</script>
<style>
.card {
    width: 100%;
    background-color: rgb(197, 197, 197);
    border-radius: 15px;
    padding-top: 20px;

}

.arrow {
    width: 30px;
    height: 30px;
    position: absolute;
    top: -5%;
    left: 0;
}
#card:hover{
   box-shadow: 6px 6px rgb(133, 131, 131);
   transform: scale(1.02);
   transition: ease-out 0.5s;
 }
</style>