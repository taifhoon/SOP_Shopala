<template>

  <div class="container is-widescreen">
    <div class="columns">
      <div class="column is-2"></div>
      <div class="column is-8 pb-5">
        <div class="columns">
          <div class="column box mx-5 mb-5 has-text-black pb-6">
            <section class="hero">
              <div class="hero-body">
                <p class="title">แก้ไขรายละเอียด</p>
              </div>
            </section>
            <section class="px-6">
              <div class="columns">
                             <div class="column is-1"></div>
                <div class="column is-10">
                  <div class="row">
                    <div class="columns">
                      <label class="label column is-3 has-text-right">รูปภาพ :</label>
                      <div class="control column is-align-content-start">
                        <input multiple type="file" accept="image/png, image/jpeg, image/webp" @change="selectImages"
                          style="width: 150px; height: 40px;" />
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="columns">
                      <label class="label column is-3 has-text-right">ชื่อสินค้า :</label>
                      <div class="column control">
                        <input v-model="listProducts.name" class="input" type="text" placeholder="movie name" />
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="columns">
                      <label class="label column is-3 has-text-right">รายละเอียดสินค้า :</label>
                      <div class="column control">
                        <textarea v-model="listProducts.detail" class="textarea" placeholder="Plot movie input"></textarea>
                      </div>
                    </div>
                  </div>
                  <div class="row" v-for="(item, index) in listProducts.type" :key="index">
                    <div class="columns">
                      <div class="column is-3">
                        <label class="label has-text-center">สี</label>
                        <input v-model="item.color" class="input" type="text" placeholder="color" />
                      </div>
                      <div class="column is-3">
                        <label class="label has-text-center">ขนาด</label>
                        <input v-model="item.size" class="input" type="text" placeholder="size" />
                      </div>
                      <div class="column is-3">
                        <label class="label has-text-center">ราคา</label>
                        <input v-model="item.price" class="input" type="text" placeholder="price" />
                      </div>
                      <div class="column is-3">
                        <label class="label has-text-center">
                          จำนวน
                          <a v-if="index == 0">
                            <div @click="addType()"><img class="imgplus is-flex-direction-row-reverse"
                                src="https://cdn.discordapp.com/attachments/1033283242121498625/1054425120325771355/plus.png"
                                width="20" alt=""></div>
                          </a>
                          <a v-else-if="index >= 1">
                            <div @click="deleteType(index)"><img class="imgplus is-flex-direction-row-reverse"
                                src="https://cdn.discordapp.com/attachments/1033283242121498625/1054440812693426276/minus.png"
                                width="20" alt=""></div>
                          </a>
                        </label>
                        <input v-model="item.quantity" class="input" type="text" placeholder="quantity" />
                      </div>
                    </div>
                  </div>
                  <div class="row mt-5">
                    <div class="columns">
                      <div class="column control">
                        <router-link to="/allproduct" class="has-text-light">
                          <button class="button " style="width: 200px; height: 40px;">Cancel</button>
                        </router-link>
                      </div>
                      <div class="column control">
                        <router-link class="has-text-dark" id='button' to="/allproduct">
                          <button class="button has-background-black has-text-white"
                            style="width: 200px; height: 40px;">บันทึก</button>
                        </router-link>
                      </div>
                      <div class="column control">
                        <router-link class="has-text-dark" id='button' to="/allproduct">
                          <button class="button has-background-danger has-text-white"
                            style="width: 200px; height: 40px;">ลบ</button>
                        </router-link>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="column is-1"></div>
              </div>
            </section>
          </div>
        </div>
      </div>
      <div class="column is-2 "></div>
    </div>
  </div>

</template>

<script>
import axios from '@/plugins/axios'

export default {
  data() {
    return {
      movie: "",
      plot: "",
      director: "",
      actors: "",
      myImage: "",
      listProducts:
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
            }
    };
  },
  mounted() {
    window.scrollTo(0, 0)
    this.getMovie(this.$route.params.id)
    this.getProducts(this.$route.params.id)
  },
  methods: {
    getMovie(id) {
      axios.get(`http://localhost:3000/movies/detail/${id}`)
        .then((response) => {
          console.log(response.data.moviedetail)
          this.movie = response.data.moviedetail[0].m_name
          this.plot = response.data.moviedetail[0].plot
          this.director = response.data.moviedetail[0].director
          this.actors = response.data.moviedetail[0].actors
        })
    },
    selectImages(event) {
      this.myImage = event.target.files;
      console.log(this.myImage[0])
    },
    submitMovie() {
      let formData = new FormData();
      formData.append("movie", this.movie);
      formData.append("plot", this.plot);
      formData.append("director", this.director);
      formData.append("actors", this.actors);
      formData.append("myImage", this.myImage[0]);
      axios
        .post(`http://localhost:3000/movies/edit/${this.$route.params.id}`, formData)
        .then((response) => {
          console.log(response.data)
          this.$router.push({ path: "/movies" });
        })
        .catch((error) => {
          this.error = error.message;
        });
    },
    getProducts(id) {
      axios
        .get(`http://localhost:8001/products/getProductsById/${id}`)
        .then((res) => {
          this.listProducts = res.data
        })
        .catch((error) => {
          alert(error.response.data.message)
        });
    }
  },
};
</script>

<style>
.imgplus {
  position: absolute;
  margin-left: 7%;
  margin-top: -1.5%;
}
</style>