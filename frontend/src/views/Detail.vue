<template>
  <div class="container is-widescreen">
    <router-link class="has-text-dark" id="button" to="/">
      <div class="arrow">
        <img
          class="imgarrow"
          src="https://cdn.discordapp.com/attachments/1033283242121498625/1055543133351448678/arrow-left.png"
          alt=""
        />
      </div>
    </router-link>
    <section class="section" id="app">
      <div class="content">
        <div class="columns">
          <div class="column is-6">
            <div class="card">
              <figure>
                <img class="productimg" :src="this.product.photo" alt="" />
              </figure>
            </div>
          </div>
          <div class="column is-6">
            <div class="title">
              <p class="title">{{ this.product.name }}</p>
            </div>
            <hr />
            <div class="coloumn is-6">
              <p
                class="has-text-justified"
                v-if="selColor == '' || selSize == ''"
              >
                <span>฿</span>
                {{ GetPriceAll() }}
                <!-- {{ this.product.type[0].price }} - {{ this.product.type[this.product.type.length - 1].price }} -->
              </p>
              <p class="has-text-justified" v-else>
                <span>฿</span>
                {{ Price() }}
              </p>
              <div class="has-text-left">
                <div class="componentorder is-size-4 has-text-left">สี</div>
                <button
                  style="font-family: 'Prompt', sans-serif"
                  class="button colorbtn"
                  :class="[checkColorSelect(item) ? 'is-dark' : 'is-light']"
                  v-for="(item, index) in this.type.color"
                  :key="index"
                  @click="selColor = item"
                >
                  {{ item }}
                </button>
              </div>
              <div class="has-text-left">
                <div class="componentorder is-size-4 has-text-left">ขนาด</div>
                <button
                  style="font-family: 'Prompt', sans-serif"
                  class="button colorbtn"
                  :class="[checkSizeSelect(item) ? 'is-dark' : 'is-light']"
                  v-for="(item, index) in this.type.size"
                  :key="index"
                  @click="selSize = item"
                >
                  {{ item }}
                </button>
              </div>
              <div class="has-text-left">
                <div class="componentorder is-size-4 has-text-left">
                  จำนวน
                  <span
                    class="is-size-6 has-text-grey"
                    v-if="!(selColor == '' || selSize == '')"
                    >(ยอดคงเหลือ : {{ checkQuantity() }})</span
                  >
                </div>
                <div class="columns">
                  <div class="column is-6">
                    <button class="button is-grey-dark" @click="minusfunc()">
                      -
                    </button>
                    <input
                      class="countinput input"
                      v-model="numQuantity"
                      type="number"
                      value="1"
                    />
                    <button class="button is-grey-dark" @click="plusfunc()">
                      +
                    </button>
                  </div>
                </div>
              </div>
            </div>
            <div class="has-text-left column is-12 btnspace">
              <button
                style="font-family: 'Prompt', sans-serif"
                class="button is-dark ordering mr-5"
                @click="AddOrder()"
              >
                เพิ่มสินค้าลงในตะกร้า
              </button>
              <!-- <button class="button is-dark ordering">เพิ่มสินค้าลงในรายการโปรด</button> -->
              <a class="favo" @click="changefav()"
                ><img
                  src="https://cdn-icons-png.flaticon.com/512/1077/1077035.png"
                  width="40"
                  v-if="fav == false" />
                <img
                  src="https://cdn-icons-png.flaticon.com/512/1077/1077086.png"
                  width="40"
                  v-else-if="fav"
              /></a>
            </div>
            <div class="detail">
              <p class="textcolor is-size-4 has-text-left">รายละเอียดสินค้า</p>
              <p class="has-text-left">{{ this.product.detail }}</p>
            </div>
          </div>
        </div>
      </div>
    </section>
    <div class="box"></div>
  </div>
</template>
<script>
import axios from "@/plugins/axios";
export default {
  name: "app",
  props: ["user"],
  data() {
    return {
      listCustomers: [],
      fav: false,
      selColor: "",
      selSize: "",
      numQuantity: "1",
      movie: [],
      show: [],
      editShow: false,
      type: { color: [], size: [] },
      product: {},
      customer: {},
    };
  },
  mounted() {
    window.scrollTo(0, 0);
    this.getProducts(this.$route.params.id);
    // this.selectType()
  },
  methods: {
    async getProducts(id) {
      await axios
        .get(`http://localhost:8001/getProducts`)
        .then((res) => {
          this.product = res.data.filter((item) => {
            return item._id == id;
          })[0];
        })
        .catch((error) => {
          alert(error.response.data.message);
        });

      await axios
        .get(`http://localhost:8003/getCustomers`)
        .then((res) => {
          this.customer = res.data.filter((item) => {
            return item._id == localStorage.getItem("customerId");
          })[0];
        })
        .catch((error) => {
          alert(error.response.data.message);
        });
      this.selectType();
      this.Checkfav();
    },
    selectType() {
      this.product.type.forEach((item) => {
        if (this.type.color.indexOf(item.color) == -1) {
          this.type.color.push(item.color);
        }
        if (this.type.size.indexOf(item.size) == -1) {
          this.type.size.push(item.size);
        }
      });
    },
    checkQuantity() {
      if (this.selColor == "" || this.selSize == "") {
        return "";
      }
      return this.product.type.find(
        (item) => item.color == this.selColor && item.size == this.selSize
      ).quantity;
    },
    checkColorSelect(item) {
      return this.selColor == item;
    },
    checkSizeSelect(item) {
      return this.selSize == item;
    },
    GetPriceAll() {
      if (this.product.type.length == 1) {
        return this.product.type[0].price;
      } else {
        return (
          this.product.type[0].price +
          " - " +
          this.product.type[this.product.type.length - 1].price
        );
      }
    },
    Price() {
      return this.product.type.find(
        (item) => item.color == this.selColor && item.size == this.selSize
      ).price;
    },
    plusfunc() {
      console.log(this.numQuantity);
      // this.numtest += 1;
      parseInt(this.numQuantity++);
    },
    minusfunc() {
      if (this.numQuantity > 1) {
        parseInt(this.numQuantity--);
      }
    },

    async Checkfav() {
      // this.fav = !this.fav;
      console.log(this.customer.favoriteProductId.indexOf(this.product._id));
      if (this.customer.favoriteProductId.indexOf(this.product._id) >= 0) {
        this.fav = true;
      } else {
        this.fav = false;
      }
    },
    changefav() {
      if (this.fav) {
        console.log(this.customer.favoriteProductId.indexOf(this.product._id));
        this.customer.favoriteProductId.splice(
          this.customer.favoriteProductId.indexOf(this.product._id),
          1
        );
        this.fav = false;
      } else {
        this.customer.favoriteProductId.push(this.product._id);
        this.fav = true;
      }
      axios
        .post(`http://localhost:8003/updateCustomer`, this.customer)
        .then(() => {})
        .catch((error) => {
          alert(error.response.data.message);
        });
    },

    async AddOrder() {
      await axios
        .get(`http://localhost:8003/getCustomers`)
        .then((res) => {
          this.listCustomers = res.data;
        })
        .catch((error) => {
          alert(error.response.data.message);
        });
      var customer = this.listCustomers.filter((item) => {
        return item._id == localStorage.getItem("customerId");
      })[0];
      customer.cartList.push({
        productId: this.product._id,
        color: this.selColor,
        size: this.selSize,
        quantity: this.numQuantity,
        price: this.Price(),
      });
      this.product.type.find(
        (item) => item.color == this.selColor && item.size == this.selSize
      ).quantity = this.product.type.find(
        (item) => item.color == this.selColor && item.size == this.selSize
      ).quantity - 1
      console.log(customer);
      await axios
        .post(`http://localhost:8003/updateCustomer`, customer)
        .then((res) => {
          if (res.data.slice(0, 14) == "Update Success") {
            alert("Add to cart Success");
            this.$router.push("/customer/cart");
          }
        })
        .catch((error) => {
          alert(error.response.data.message);
        });
        await axios
        .post(`http://localhost:8001/updateProduct`, this.product)
        .then((res) => {
          if (res.data.slice(0, 14) == "Update Success") {
            alert("Add to cart Success");
            this.$router.push("/customer/cart");
          }
        })
        .catch((error) => {
          alert(error.response.data.message);
        });
    },
  },
};
</script>

<style>
.arrow {
  width: 30px;
  height: 30px;
  position: absolute;
  top: -2%;
  left: 0;
}

.productimg {
  width: 432px;
  height: 432px;
  margin-top: 20%;
  /* margin-left: 10%;
  margin-right: 10%; */
}

.colorbtn {
  margin-right: 1%;
  width: 65px;
  padding: 0%;
}

.ordering {
  margin-right: 1%;
  width: 200px;
}

.componentorder {
  padding: 0%;
  margin-top: 2%;
  margin-bottom: 1.5%;
}

.btnspace {
  padding: 0%;
  margin-top: 4%;
  margin-bottom: 4%;
}

.countinput {
  width: 25%;
  text-align: center;
}
</style>