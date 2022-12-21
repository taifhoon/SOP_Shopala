<template>
  <div class="container is-widescreen">
    <router-link class="has-text-dark" id='button' to="/">
      <div class="arrow">
        <img class="imgarrow"
          src="https://www.flaticon.com/svg/vstatic/svg/3916/3916810.svg?token=exp=1671377228~hmac=1258a1e45339936c5da1bcba43dcf873"
          alt="">
      </div>
    </router-link>
    <section class="section" id="app">
      <div class="content">
        <div class="columns">
          <div class="column is-6">
            <img class="productimg"
              src="https://twicpics.celine.com/product-prd/images/large/344893602C.38NO_1_WIN21.jpg?twic=v1/cover=1:1/resize-max=480"
              alt="">
          </div>
          <div class="column is-6 ">
            <div class="title">
              <p class="title "></p>
            </div>
            <hr />
            <div class="coloumn is-6">
              <p class=" has-text-justified">
                <span>฿</span>
                {{ this.product.type[0].price }}
              </p>
              <div class=" has-text-left">
                <div class=" componentorder is-size-4 has-text-left"> สี </div>
                <button class="button colorbtn" :class="[checkColorSelect(item) ? 'is-dark' : 'is-light']"
                  v-for="(item, index) in this.type.color" :key="index" @click="selColor = item">{{ item }}</button>
              </div>
              <div class=" has-text-left">
                <div class=" componentorder is-size-4 has-text-left"> ขนาด </div>
                <button class="button colorbtn" :class="[checkSizeSelect(item) ? 'is-dark' : 'is-light']"
                  v-for="(item, index) in this.type.size" :key="index" @click="selSize = item">{{ item }}</button>
              </div>
              <div class="has-text-left">
                <div class="componentorder is-size-4 has-text-left">จำนวน <span class="is-size-6 has-text-grey"
                    v-if="!(selColor == '' || selSize == '')">(ยอดคงเหลือ : {{ checkQuantity() }})</span></div>
                <div class="columns">
                  <div class="column is-6">
                    <button class="button is-grey-dark" @click="minusfunc()">-</button>
                    <input class="countinput input" v-model="numQuantity" type="number" value="1">
                    <button class="button is-grey-dark" @click="plusfunc()">+</button>
                  </div>
                </div>
              </div>
            </div>
            <div class=" has-text-left column is-12 btnspace">
              <button class="button is-dark ordering mr-5">เพิ่มสินค้าลงในตะกร้า</button>
              <!-- <button class="button is-dark ordering">เพิ่มสินค้าลงในรายการโปรด</button> -->
              <a><img src="https://cdn-icons-png.flaticon.com/512/1077/1077035.png" width="40" v-if="fav == false"
                  @click="fav = true">
                <img src="https://cdn-icons-png.flaticon.com/512/1077/1077086.png" width="40" v-else-if="fav"
                  @click="fav = false"></a>
            </div>
            <div class="detail">
              <p class="textcolor is-size-4 has-text-left">รายละเอียดสินค้า</p>
              <p class="has-text-left">{{ this.product.detail }}</p>
            </div>
          </div>
        </div>
      </div>
    </section>
    <div class="box">

    </div>
  </div>
</template>
<script>
import axios from "@/plugins/axios";
export default {
  name: "app",
  props: ["user"],
  data() {
    return {
      fav: false,
      selColor: "",
      selSize: "",
      numQuantity: "1",
      movie: [],
      show: [],
      editShow: false,
      type: { color: [], size: [] },
      product: {
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
          }, {
            "price": "39900",
            "color": "black",
            "size": "256GB",
            "quantity": 3
          },
          {
            "price": "21900",
            "color": "blue",
            "size": "256GB",
            "quantity": 7
          },
          {
            "price": "41900",
            "color": "blue",
            "size": "1TB",
            "quantity": 1
          }
        ]
      },
    };
  },
  mounted() {
    window.scrollTo(0, 0)
    // this.getMovieDetail(this.$route.params.id);

    // this.getProducts(this.$route.params.id)
    this.selectType()
  },
  methods: {
    getProducts(id) {
      axios
        .get(`http://localhost:8001/getProducts`)
        .then((res) => {
          this.product = res.data.filter(item => {
            return item._id == id
          })[0]
        })
        .catch((error) => {
          alert(error.response.data.message)
        });
    },
    selectType() {
      this.product.type.forEach(item => {
        if (this.type.color.indexOf(item.color) == -1) {
          this.type.color.push(item.color)
        }
        if (this.type.size.indexOf(item.size) == -1) {
          this.type.size.push(item.size)
        }

      });
    },
    checkQuantity() {
      if (this.selColor == '' || this.selSize == '') {
        return ""
      }
      return this.product.type.find(item => item.color == this.selColor && item.size == this.selSize).quantity
    },
    checkColorSelect(item) {
      return this.selColor == item
    },
    checkSizeSelect(item) {
      return this.selSize == item
    },
    // getMovieDetail(id) {
    //   axios
    //     .get(`http://localhost:3000/movies/detail/${id}`)
    //     .then((response) => {
    //       this.movie = response.data.moviedetail[0];
    //       this.show = response.data.show;
    //       this.movie.release_date = new Date(this.movie.release_date).toDateString()

    //       for (var i = 0; i < this.show.length; i++) {
    //         this.show[i].show_date = new Date(this.show[i].show_date).toDateString()
    //       }
    //     })
    //     .catch((err) => {
    //       console.log(err);
    //     });
    // },
    image(file_path) {
      if (file_path) {
        return "http://localhost:3000/" + file_path;
      } else {
        return "https://bulma.io/images/placeholders/640x360.png";
      }
    },
    isAdmin() {
      if (!this.user) return false
      return this.user.role == 'admin'
    },
    isCusto() {
      if (!this.user) return false
      return this.user.role == 'customer'
    },
    checkEditShow() {
      this.editShow = true
    },
    CancelEditShow() {
      this.editShow = false
    },
    DeleteShow(id) {
      const result = confirm('Are you sure you want to delete this show ?');
      if (result) {
        axios
          .delete(`http://localhost:3000/show/delete/${id}`)
          .then((response) => {
            this.getMovieDetail(this.$route.params.id);
            this.editShow = false
            console.log(response)
          })
          .catch((error) => {
            alert(error.response.data.message)
          });
      }
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
    }


  },
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

.productimg {
  width: 432px;
  height: 587px;
  margin-left: 15%;
  margin-right: 15%;
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