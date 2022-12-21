<template>

    <body class='homepage'>
        <div class="columns">
            <div class="column is-4">  
                <p class="title is-4 has-text-left ml-6">Welcome Back, Louis!</p>
            </div>
        </div>
        <div class="columns">
            <div class="column is-10 is-offset-1">
                <div class="box has-background-dark">
                    <p class="has-text-left has-text-light">...หลุยส์ตรงนี้ควรเขียนอะไรดีหรอ ^.^</p> <br><br><br>
                    <div class="columns">
                        <div class="column is-2 is-offset-2">
                           <div class="box is-clickable" @click="buylink()">
                                <p class="title is-4 pb-2">+1</p>
                                <p class="subtitle is-5">คำสั่งซื้อ</p>

                           </div>
                        </div>
                        <div class="column is-2 is-offset-1">
                            <div class="box is-clickable" @click="allproductlink()">
                                <p class="title is-4 pb-2">+ {{ listProducts.length }}</p>
                                <p class="subtitle is-5">สิ้นค้าทั้งหมด</p>
                            </div>
                        </div>
                        <div class="column is-2 is-offset-1">
                            <div class="box is-clickable" @click="addproductlink()">
                                <p class="title is-4 pb-2">+</p>
                                <p class="subtitle is-5">เพิ่มสินค้าใหม่</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- <div class="columns">
            <div class="menu column is-2 has-text-left box pl-5 pb-5 ml-6">
                <ul class="menu-list">
                    <li class="columns">
                    
                        <img src="https://www.flaticon.com/svg/vstatic/svg/7653/7653156.svg?token=exp=1671293890~hmac=b081aa7e3e4a467a11d47d13bf21176d"
                            width="20" alt="" />
                        <router-link class="card-footer-item has-text-dark" id='button' to="/seller/order">
                            <a>คำสั่งซื้อ</a>
                        </router-link>
                    </li>
                    <li>
                        <div class="columns">
                            <img src="https://www.flaticon.com/svg/vstatic/svg/7857/7857224.svg?token=exp=1671294380~hmac=613477b99e0d5c23bc6017ecec6a49af"
                                width="20" alt="" />
                            <a>สินค้า</a>
                        </div>
                        <ul>
                            <router-link class="card-footer-item has-text-dark" id='button' to="/allproduct">
                                <li><a>สินค้าของฉัน</a></li>
                            </router-link>
                            <router-link class="card-footer-item has-text-dark" id='button' to="/addproduct">
                                <li><a>เพิ่มสินค้าใหม่</a></li>
                            </router-link>
                        </ul>
                    </li>
                    <li class="columns pt-2">
                        <img src="https://www.flaticon.com/svg/vstatic/svg/3914/3914461.svg?token=exp=1671294499~hmac=191fa3c7b6b838b48690c35aeb6c4a18"
                            width="20" alt="" />
                        <a>การจัดส่ง</a>
                    </li>
                    <li class="columns">
                        <img src="https://www.flaticon.com/svg/vstatic/svg/3914/3914398.svg?token=exp=1671294692~hmac=f34539aa2aa41280ada4676a31338555"
                            width="20" alt="" />
                        <a>บัญชีธนาคาร</a>
                    </li>
                    <li class="columns">
                        <img src="https://www.flaticon.com/svg/vstatic/svg/3916/3916657.svg?token=exp=1671294827~hmac=0d90afec368ea5b54113a7e559416d83"
                            width="20" alt="" />
                        <a>รายละเอียดร้านค้า</a>
                    </li>
                    <li class="columns">
                        <img src="https://www.flaticon.com/svg/vstatic/svg/3917/3917058.svg?token=exp=1671294856~hmac=3859170f71278e2f079e55b4838ceb59"
                            width="20" alt="" />
                        <a>การตั้งค่า</a>
                    </li>
                </ul>
            </div>
            <div class="column is-1"></div>
            <div class="column box pl-5 pt-5">
                <h1 class="row has-text-left">รายการ</h1>
                <div class="row">
                    <div class="columns">
                        <router-link class="card-footer-item has-text-dark" id='button' to="/seller/order">
                            <a class="column">
                                <div>1</div>
                                <div>คำสั่งซื้อ</div>
                            </a>
                        </router-link>
                        <router-link class="card-footer-item has-text-dark" id='button' to="/allproduct">
                            <a class="column">
                                <div>1</div>
                                <div>สินค้าทั้งหมด</div>
                            </a>
                        </router-link>
                    </div>
                </div>
            </div>
            <div class="column is-1"></div>
        </div> -->
    </body>
</template>
  
<script>
import axios from "@/plugins/axios";
export default {
    name: "app",
    props: ['user'],
    data() {
        return {
            listProducts: [],
            search: "",
        };
    },
    mounted() {
        window.scrollTo(0, 0)
        // this.getMovie();
        this.getProducts()
    },
    methods: {
        getProducts() {
            axios
                .get(`http://localhost:8001/getProducts`)
                .then((res) => {
                    console.log(res)
                    this.listProducts = res.data
                })
                .catch((error) => {
                    alert(error.response.data.message)
                });
        },
        buylink () {
            this.$router.push("/seller/order");
        },
        allproductlink () {
            this.$router.push("/allproduct");
        },
        addproductlink () {
            this.$router.push("/addproduct");
        },
    },
    
    // methods: {
    //   getMovie() {
    //     axios
    //       .get("http://localhost:3000/", {
    //         params: {
    //           search: this.search,
    //           order: this.order,
    //           theatre: this.theatre,
    //         },
    //       })
    //       .then((response) => {
    //         this.movie = response.data;
    //         for (var i = 0; i < this.movie.length; i++) {
    //           this.movie[i].show_date = new Date(this.movie[i].show_date).toDateString()
    //         }
    //       })
    //       .catch((err) => {
    //         console.log(err);
    //       });
    //   },
    //   image(file_path){
    //       if (file_path) {
    //       return "http://localhost:3000/" + file_path;
    //     } else {
    //       return "https://bulma.io/images/placeholders/640x360.png";
    //     }
    //   },
    //   isAdmin(){
    //     if (!this.user) return false
    //     return this.user.role == 'admin'
    //   },
    //   isCusto(){
    //     if (!this.user) return false
    //     return this.user.role == 'customer'
    //   }

    // },
};
</script>
<style>

#card1 {
    width: 100%;
    background-color: rgb(213, 215, 218);
    border-radius: 15px;
    padding-top: 20px;

}
</style>