<template>
  <div class="container is-widescreen">
    <section class="hero">
      <div class="hero-body">
        <p class="title has-text-white">รายการภาพยนตร์ทั้งหมด</p>
        <div class="columns">
          <div class="column is-10">
            <input
              class="input is-danger"
              type="text"
              v-model="searchdetail"
              placeholder="Search Movie"
            />
          </div>
          <div class="column is-2">
            <button class="button is-danger px-3 is-fullwidth" @click="getMovie()">
              <strong>Search</strong>
            </button>
          </div>
        </div>
      </div>
    </section>
    <section class="section" id="app">
      <div class="field level-right">
        <div class="control">
        <router-link to="/add/movies" v-if="isAdmin()"><button class="button is-warning">
              <strong>Add Movie</strong>
            </button></router-link>
            <button  class="button is-danger ml-5" @click="deleteButton = !deleteButton" v-if="deleteButton == false && isAdmin()">
              <strong>Edit Movie</strong>
            </button>
            <button class="button is-info ml-5" @click="deleteButton = !deleteButton" v-if="deleteButton == true && isAdmin()">
              <strong>Cancel</strong>
            </button>
          <div class="select ml-5 is-danger">
            <select v-model="sortdetail" @change="getMovie()">
              <option value="m_name asc">เรียงลำดับจาก a-z</option>
              <option value="m_name desc">เรียงลำดับจาก z-a</option>
            </select>
          </div>
        </div>
      </div>
      <div class="content">
        <div class="columns is-multiline">
          <!-- loop -->
          <div class="listmovie column is-3 mt-5" v-for="(movie) in moviedetail" :key="movie.m_id">
            <div class="card" style=" background-image: linear-gradient(rgb(116, 203, 255), white);">
              <div class="card-image pt-5">
                <figure>
                  <!-- ไว้ใส่รูป -->
                  <img style=" width: 180px; height: 284px; box-shadow: rgba(0, 0, 0, 0.25) 0px 14px 28px, rgba(0, 0, 0, 0.22) 0px 10px 10px;"
                    :src="image(movie.img_movie)"
                    alt="Placeholder image"
                  />
                </figure>
              </div>
              <div class="card-content">
                <div class="content" style="height: 40px">
                  {{ movie.m_name }}
                </div>
              </div>
            </div>
            <footer class="card-footer has-background-info" v-if="deleteButton == false">
              <router-link
                :to="`/movies/detail/${movie.m_id}`"
                class="card-footer-item has-text-light"
              >
                <span>More details</span></router-link
              >
            </footer>
              <footer class="card-footer" v-if="deleteButton == true">
              <router-link :to="`/add/movies/${movie.m_id}`"
                class="card-footer-item has-text-black has-background-warning"
              >
                <span>Edit</span></router-link
              >
                            <a @click="deleteMovie(movie.m_id, movie.m_name)"
                class="card-footer-item has-text-light has-background-danger"
              >
                <span>Delete</span></a
              >
            </footer>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
import axios from '@/plugins/axios'
export default {
  name: "app",
  props: ['user'],
  data() {
    return {
      searchdetail: "",
      moviedetail: [],
      sortdetail: "m_name asc",
      deleteButton: false
    };
  },
  mounted() {
    window.scrollTo(0, 0)
    this.getMovie();
  },
  methods: {
    getMovie() {
      axios
        .get("http://localhost:3000/movies/detail", {
          params: {
            searchdetail: this.searchdetail,
            sortdetail: this.sortdetail,
          },
        })
        .then((response) => {
          this.moviedetail = response.data.moviedetail;
        })
        .catch((err) => {
          console.log(err);
        });
    },
    image(file_path){
        if (file_path) {
        return "http://localhost:3000/" + file_path;
      } else {
        return "https://bulma.io/images/placeholders/640x360.png";
      }
    },
    deleteMovie(id, movie){
      const result = confirm('Are you sure you want to delete '+`${movie}`);
      if (result){
        axios
        .delete(`http://localhost:3000/movies/delete/${id}`)
        .then((response) => {
          this.getMovie();
          this.deleteButton = false
          console.log(response)
        })
        .catch((error) => {
          alert(error.response.data.message)
        });
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