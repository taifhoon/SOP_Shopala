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
                        <input multiple type="file" accept="image/png, image/jpeg, image/webp" 
                          style="width: 150px; height: 40px;" />
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="columns">
                      <label class="label column is-3 has-text-right">ชื่อสินค้า :</label>
                      <div class="column control">
                        <input v-model="product.name" class="input" type="text" placeholder="movie name" />
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="columns">
                      <label class="label column is-3 has-text-right">รายละเอียดสินค้า :</label>
                      <div class="column control">
                        <textarea v-model="product.detail" class="textarea" placeholder="Plot movie input"></textarea>
                      </div>
                    </div>
                  </div>
                  <div class="row" v-for="(item, index) in product.type" :key="index">
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
                        <router-link class="has-text-dark" id='button' to="/seller/home">
                          <button @click="updateProduct()" class="button has-background-black has-text-white" 
                            style="width: 200px; height: 40px;">บันทึก</button>
                        </router-link>
                      </div>
                      <div class="column control">
                        <router-link class="has-text-dark" id='button' to="/seller/home">
                          <button @click="deleteProduct()" class="button has-background-danger has-text-white"
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
      product:
        {
                // "_id": "a1bba32a-e382-48fc-b4d7-ee2931bac028",
                // "name": "iphone 9",
                // "photo": "hello",
                // "sellerId": "fffffffffffffffffffffff",
                // "detail": "ippp",
                // "type": [
                //     {
                //         "price": "32900",
                //         "color": "black",
                //         "size": "128GB",
                //         "quantity": 5
                //     },
                //     {
                //         "price": "39900",
                //         "color": "blue",
                //         "size": "128GB",
                //         "quantity": 3
                //     }
                // ]
            }
    };
  },
  mounted() {
    this.getProduct(this.$route.params.id)
  },
  methods: {
    getProduct(id) {
      axios
        .get(`http://localhost:8001/getProducts`)
        .then((res) => {
          this.product = res.data.filter(item => {return item._id == id})[0]
        })
        .catch((error) => {
          alert(error.response.data.message)
        });
    },
    updateProduct(){
      this.product.type.sort((a, b) => a.price - b.price);
      axios
        .post(`http://localhost:8001/updateProduct`, {
            "_id": this.product._id,
            "name": this.product.name,
            "detail": this.product.detail,
            "photo": this.product.photo,
            "sellerId": this.product.sellerId,
            "type": this.product.type
        })
        .then((res) => {
          console.log(res)
          
        })
        .catch((error) => {
          alert(error.response.data.message)
        });
    },
    deleteProduct(){
      axios
        .post(`http://localhost:8001/deleteProduct`, {
            "_id": this.product._id
        })
        .then((res) => {
          console.log(res)
        })
        .catch((error) => {
          alert(error)
        });
    },
    addType() {
      this.listType.push({ color: '', size: '', price: 0, quantity: 0 })
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