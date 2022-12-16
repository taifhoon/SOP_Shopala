<template>
  <!-- <div class="container is-widescreen">
    <div class="card-image pt-5">
      <figure class="image is-1186x800"> -->
        <!-- ไว้ใส่รูป -->
       
      <!-- </figure>
    </div>
    <section class="hero">
      <div class="hero-body">
        <p class="title has-text-white">กำลังฉาย</p>

      </div>
    </section>
    <section class="section" id="app">
      <div class="field level-right">
        <div class="control">
          <div class="select is-danger">
            <select v-model="theatre" @change="getMovie()">
            {{theatre}}
              <option value="none">เลือกโรงหนัง</option>
              <option value="JunRongJai 1">JunRongJai 1</option>
              <option value="JunRongJai 2">JunRongJai 2</option>
              <option value="RongJai 1">RongJai 1</option>
            </select>
          </div>
          <div class="select ml-5 is-danger is-outlined">
            <select v-model="order" @change="getMovie()">
              <option value="show_date">เรียงลำดับจาก ล่าสุด</option>
              <option value="m_name asc">เรียงลำดับจาก a-z</option>
              <option value="m_name desc">เรียงลำดับจาก z-a</option>
            </select>
          </div>
        </div>
      </div>
      <div class="content">
        <div class="columns is-multiline"> -->
          <!-- loop -->
          <!-- <p
            v-if="movie.length == 0"
            class="title has-text-centered has-text-white"
          >
            ไม่ค้นพบรายการที่ต้องการ
          </p>
          <div class="listmovie column is-3 mt-5" v-for="(movie) in movie" :key="movie.id" >
            <div class="level-left has-text-white">{{ movie.tname }}</div>
            <div class="level-left has-text-white">{{ movie.show_date }}</div>
            <div class="level-left mb-3 has-text-white">
              {{ movie.st_time }}
            </div>
            <div class="card " style=" background-color: #a40606; background-color: #99201c;
background-image: linear-gradient(#FF7D7D, #ffffff);">
              <div class="card-image pt-5">
                <figure> -->
                  <!-- ไว้ใส่รูป -->
                  <!-- <img style=" width: 180px; height: 284px; box-shadow: rgba(0, 0, 0, 0.25) 0px 14px 28px, rgba(0, 0, 0, 0.22) 0px 10px 10px;"
                    :src="image(movie.img_movie)"
                    alt="Placeholder image"
                  />
                </figure>
              </div>
              <div class="card-content">
                <div class="content has-text-black" style="height: 40px">
                  {{ movie.m_name }}
                </div>
              </div>
            </div>
            <footer class="card-footer has-background-danger-dark">
              <router-link
                :to="`/show/${movie.show_id}`"
                class="card-footer-item has-text-light"
              >
                <span v-if="isCusto()">Buy Now</span><span v-if="isAdmin()">Detail</span></router-link
              >
            </footer>
          </div>
        </div>
      </div>
    </section>
  </div> -->
  <body class='homepage'>
  <div class="container is-widescreen">
    <section class="section">
      <div class="content">
        <h1 class="title has-text-left">สินค้าแนะนำ</h1>
        <div class="columns is-multiline">
          <div class="column is-3" >
            <div class="card" id="card1">
              <div class="card-image pt-4">
                <figure>
                  <img src="https://twicpics.celine.com/product-prd/images/large/344893602C.38NO_1_WIN21.jpg?twic=v1/cover=1:1/resize-max=480" alt="">
                </figure>
              </div>
              <div class="card-content">
                <div class="text">CELINE MARGARET LOAFER WITH TRIOMPHE CHAIN IN POLISHED BULLBLACK</div>
                <div class="content zonecon">
                  <span>฿</span>
                  39,500
                </div>
              </div>
              <footer class="card-footer">
                <router-link class="card-footer-item has-text-dark" id='button' :to="`/movies/detail/${movie.m_id}`">Details</router-link>
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
// import axios from '@/plugins/axios'
export default {
  name: "app",
  props: ['user'],
  data() {
    return {
      search: "",
      movie: [],
      order: "show_date",
      theatre: "none",
    };
  },
  mounted() {
    window.scrollTo(0, 0)
    this.getMovie();
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
 #card1{
   width:100%;
   background-color: rgb(213, 215, 218);
   border-radius: 15px;
   padding-top:20px;
   
 }
</style>