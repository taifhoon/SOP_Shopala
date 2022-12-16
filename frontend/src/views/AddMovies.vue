<template>
  <div class="container is-widescreen">
    <div class="columns pb-5">
      <div class="column box mx-5 mb-5 has-background-grey-dark" style="box-shadow: rgba(0, 0, 0, 0.17) 0px -23px 25px 0px inset, rgba(0, 0, 0, 0.15) 0px -36px 30px 0px inset, rgba(0, 0, 0, 0.1) 0px -79px 40px 0px inset, rgba(0, 0, 0, 0.06) 0px 2px 1px, rgba(0, 0, 0, 0.09) 0px 4px 2px, rgba(0, 0, 0, 0.09) 0px 8px 4px, rgba(0, 0, 0, 0.09) 0px 16px 8px, rgba(0, 0, 0, 0.09) 0px 32px 16px;">
        <section class="hero">
          <div class="hero-body">
            <p class="title has-text-white">Create New Movie</p>
          </div>
        </section>
        <section class="px-6">
            <div class="columns is-multiline">
            <div class="column is-6">
              <div class="field mt-5">
              <label class="label has-text-white">รูปภาพ</label>
                <div class="control">
                  <input class="mb-5 ml-2 pl-5 pt-2" multiple type="file" accept="image/png, image/jpeg, image/webp" @change="selectImages" style="width: 150px; height: 40px;" />
                </div>
              </div>
            </div>
            <div class="column is-6">
              <div class="field mt-5">
                <label class="label has-text-white">ชื่อหนัง</label>
                <div class="control">
                  <input
                      v-model="movie"
                      class="input"
                      type="text"
                      placeholder="movie name"
                    />
                </div>
              </div>
            </div>
          </div>

          <br ><br >
          <div class="columns is-multiline">
            <div class="column">
              <div class="field">
                <label class="label has-text-white">เนื้อเรื่องย่อ</label>
                  <div class="control">
                    <textarea
                        v-model="plot"
                        class="textarea"
                        placeholder="Plot movie input"
                    ></textarea>
                  </div>
              </div>
            </div>
          </div>

          <br ><br >
          <div class="columns is-multiline">
            <div class="column is-6">
              <div class="field mt-5">
                <label class="label has-text-white">ผู้กำกับ</label>
                <div class="control">
                  <input
                    v-model="director"
                    class="input"
                    type="text"
                    placeholder="Director name"
                  />
                </div>
              </div>
            </div>
            <div class="column is-6">
              <div class="field mt-5">
                <label class="label has-text-white">นักแสดง</label>
                <div class="control">
                  <input
                    v-model="actors"
                    class="input"
                    type="text"
                    placeholder="Actors name"
                  />
                </div>
              </div>
            </div>
          </div>
          <div class="columns my-5 ">
            <div class="column is-2">
              <div class="field is-grouped">
                <div class="control">
                  <button @click="submitMovie()" class="button is-danger" style="width: 150px; height: 40px; right: 0;">Submit</button>
                </div>
              </div>
            </div>
            <div class="column is-2">
              <div class="field is-grouped">
                <div class="control">
                <router-link :to="`/movies`" class="has-text-light">
                  <button @click='this.$router.push({ path: "/movies" })' class="button is-danger is-light" style="width: 150px; height: 40px;">Cancel</button>
                  </router-link>
                </div>
              </div>
            </div>
            <div class="column"></div>
          </div>
        </section>
      </div>
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
        images: [],
    };
  },
  methods: {
    selectImages(event){
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
            .post("http://localhost:3000/movies/add", formData)
            .then((response) => {
              console.log(response.data)
              this.$router.push({ path: "/movies" });
            })
            .catch((error) => {
                this.error = error.message;
            });
      }
  },
};
</script>

<style>
</style>