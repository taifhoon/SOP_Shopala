<template>

  <body class='homepage'>
    <div class="container is-widescreen">
      <section class="section">
        <div class="content">
          <h1 class="title has-text-left">สินค้าแนะนำ</h1>

          <!-- ลองหน้าของ seller -->
          <span>
            <router-link class="has-text-dark" id='button' to="/seller/home">Seller Home</router-link>
          </span>
          <br/>
          <span>
            <router-link class="has-text-dark" id='button' to="/customer/profile">Customer Profile</router-link>
          </span>
          <br/>
          <span>
            <router-link class="has-text-dark" id='button' to="/seller/profile">Seller Profile</router-link>
          </span>

          <div class="columns is-multiline">
            <div class="column is-3" v-for="(item, index) in listProducts" :key="index">
              <div class="card" id="card1">
                <div class="card-image pt-4">
                  <figure>
                    <img
                      src="https://twicpics.celine.com/product-prd/images/large/344893602C.38NO_1_WIN21.jpg?twic=v1/cover=1:1/resize-max=480"
                      alt="">
                  </figure>
                </div>
                <div class="card-content">
                  <div class="text"><h4>{{ item.name }}</h4></div>
                  <div class="text">{{ item.detail }}</div>
                  <div class="content zonecon" v-if="item.type.length >= 1">
                    <span>฿</span>
                    {{ item.type[0].price }} - {{ item.type[item.type.length-1].price }}
                  </div>
                </div>
                <footer class="card-footer">
                  <router-link class="card-footer-item has-text-dark" id='button' :to="`/detail/${item._id}`">Details</router-link>
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
      search: "",
      movie: [],
      order: "show_date",
      theatre: "none",

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
            "price": "39900",
            "color": "gold",
            "size": "128GB",
            "quantity": 4
          }
        ]
      }]
    };
  },
  mounted() {
    window.scrollTo(0, 0)
    this.getMovie();

    this.getProducts()
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
    image(file_path){
        if (file_path) {
        return "http://localhost:3000/" + file_path;
      } else {
        return "https://bulma.io/images/placeholders/640x360.png";
      }
    },
    isAdmin(){
      if (!this.user) return false
      return this.user.role == 'admin'
    },
    isCusto(){
      if (!this.user) return false
      return this.user.role == 'customer'
    }

  },
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