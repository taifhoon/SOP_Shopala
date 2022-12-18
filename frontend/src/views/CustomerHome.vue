<template>

  <body class='homepage'>
    <div class="container is-widescreen">
      <section class="section">
        <div class="content">
          <h1 class="title has-text-left">สินค้าแนะนำ</h1>

          <!-- ลองหน้าของ seller -->
          <span>
            <router-link class="has-text-dark" id='button' to="/seller/home">Seller</router-link>
          </span>

          <div class="columns is-multiline">
            <div class="column is-3">
              <div class="card" id="card1">
                <div class="card-image pt-4">
                  <figure>
                    <img
                      src="https://twicpics.celine.com/product-prd/images/large/344893602C.38NO_1_WIN21.jpg?twic=v1/cover=1:1/resize-max=480"
                      alt="">
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
                  <router-link class="card-footer-item has-text-dark" id='button' :to="`/detail`">Details</router-link>
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
#card1 {
  width: 100%;
  background-color: rgb(213, 215, 218);
  border-radius: 15px;
  padding-top: 20px;

}
</style>