<template>

  <body class='homepage'>
    <div class="container is-widescreen">
      <section class="section">

        <div class="columns mb-6 is-justify-content-center">
          <input class="input column is-6 is-align-self-center" type="text" v-model="searchinput" id="testborder"
            placeholder="Search anything that you wants . . . "> 
          <div class="btnsearc column is-1" @click="Search()">
            <a class="navbar-item">
              <img src="https://cdn.discordapp.com/attachments/1033283242121498625/1054774681930047518/search.png"
                class="imgsearch">
            </a>
          </div>
        </div>
        <div class="content">

          <h1 class="title has-text-left">สินค้าทั้งหมด</h1>
          <h1 class="title has-text-left">{{ search }}</h1>

          <!-- ลองหน้าของ seller -->
          <span>
            <router-link class="has-text-dark" id='button' to="/seller/home">Seller Home</router-link>
          </span>
          <br />
          <span>
            <router-link class="has-text-dark" id='button' to="/customer/profile">Customer Profile</router-link>
          </span>
          <br />
          <span>
            <router-link class="has-text-dark" id='button' to="/seller/profile">Seller Profile</router-link>
          </span>

          <div class="columns is-multiline">
            <div class="column is-3" v-for="(item, index) in listProducts" :key="index">
              <div class="card">
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
                  <!-- <div class="content zonecon" v-if="item.type.length > 1">
                    <span>฿</span>
                    {{ item.type[0].price }} - {{ item.type[item.type.length - 1].price }}
                  </div>
                  <div class="content zonecon" v-else>
                    <span>฿</span>
                    {{ item.type.price }}
                  </div> -->
                  <div class="content zonecon" v-if="item.type.length > 1">
                    <span>฿</span>
                    {{ item.type[0].price }}
                  </div>
                  <div class="content zonecon" v-else>
                    <span>฿</span>
                    {{ item.type.price }}
                  </div>
                </div>
                <footer class="card-footer">
                  <router-link class="card-footer-item has-text-dark" id='button'
                    :to="`/detail/${item._id}`">Details</router-link>
                </footer>
              </div>
            </div>
          </div>
        </div>
      </section>
    </div>
  </body>
</template>

<script>
import axios from '@/plugins/axios'
export default {
  name: "app",
  props: ['user'],
  data() {
    return {
      searchinput: "",
      cusId:null,
      product: [],
      // order: "show_date",
      // theatre: "none",

      listProducts: [
        {
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
          "name": "woranun",
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
              "price": "39900",
              "color": "gold",
              "size": "128GB",
              "quantity": 4
            }
          ]
        }
      ]
    };
  },
  mounted() {
    window.scrollTo(0, 0)
    // this.getMovie();

    this.getProducts()
    this.statelogin()
  },
  methods: {
    getProducts() {
      axios
        .get(`http://localhost:8001/getProducts`)
        .then((res) => {
          this.listProducts = res.data
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
      //   .get(`http://localhost:8001/getProducts`)
      //   .then((res) => {
      //     this.listProducts = res.data

      //     if (this.searchinput != "") {
      //       this.listProducts = this.listProducts.filter((item) => item.name.toLowerCase().includes(this.searchinput.toLowerCase()));
      //     }
      //   })
      //   .catch((error) => {
      //     alert(error.response.data.message)
      //   });
    },
    // getMovie() {
    //   axios
    //     .get("http://localhost:3000/", {
    //       params: {
    //         search: this.search,
    //         order: this.order,
    //         theatre: this.theatre,
    //       },
    //     })
    //     .then((response) => {
    //       this.movie = response.data;
    //       for (var i = 0; i < this.movie.length; i++) {
    //         this.movie[i].show_date = new Date(this.movie[i].show_date).toDateString()
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
    statelogin(){
      this.cusId = localStorage.getItem("customerId")
      if(this.cusId == null){
        alert("you are not login")
        this.$router.push({ path: "/user/login" })
      }
    }

  },
};
</script>
<style>
.card {
  width: 100%;
  background-color: rgb(251, 251, 251);
  /* border-radius: 20px; */
  padding-top: 20px;
  border: 3px solid black;
  border-image-source: linear-gradient(to bottom, #363636, #575757, #b3b3b3);
  border-image-slice: 1;
}
.imaproduct {
  height: 220px;
  object-fit: cover;
}

.btnsearch:hover {
  background-color: white;
}

#testborder {
   border-width: 3px;
   border-radius: 25px;
   border-color: rgb(142, 143, 146);
}
</style>