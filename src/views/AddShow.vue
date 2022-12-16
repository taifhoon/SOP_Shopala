<template>
  <div class="container is-widescreen">
    <div class="columns pb-5">
      <div class="column box mx-5 mb-5 has-background-grey-dark" style="box-shadow: rgba(0, 0, 0, 0.17) 0px -23px 25px 0px inset, rgba(0, 0, 0, 0.15) 0px -36px 30px 0px inset, rgba(0, 0, 0, 0.1) 0px -79px 40px 0px inset, rgba(0, 0, 0, 0.06) 0px 2px 1px, rgba(0, 0, 0, 0.09) 0px 4px 2px, rgba(0, 0, 0, 0.09) 0px 8px 4px, rgba(0, 0, 0, 0.09) 0px 16px 8px, rgba(0, 0, 0, 0.09) 0px 32px 16px;">
        <section class="hero">
          <div class="hero-body">
            <p class="title has-text-white">Add New Show</p>
          </div>
        </section>
        <section class="px-6">
          <div class="columns">
          <div class="column">
              <div class="field mt-5">
                <label class="label has-text-white">ชื่อหนัง</label>
                <div class="control">
                  <div class="select is-normal" style="left: 0;">
                        <select v-model="m_name">
                            <option v-for="m in movie" :value="m.m_name" :key="m.m_name">{{m.m_name}}</option>
                        </select>
                    </div>
                </div>
              </div>
              <div class="field mt-5">
                <label class="label has-text-white">วันที่ฉาย</label>
                <div class="control">
                  <input style="width: 380px; height: 40px;" type="date" id="date" name="Date" v-model="show_date">
                </div>
              </div>
              <div class="field mt-5">
                <label class="label has-text-white">เวลาจบฉาย</label>
                <div class="control ">
                  <input style="width: 380px; height: 40px;" type="time" v-model="end_time" id="start_show" name="start_show" min="00:00" max="23:59">
                </div>
              </div>
            </div>
            <div class="column">
              <div class="field mt-5">
                <label class="label has-text-white">โรงหนัง</label>
                <div class="control">
                  <div class="select is-normal">
                        <select v-model="t_name" style="width: 380px; height: 40px;">
                            <option v-for="t in theatre" :value="t.tname" :key="t.tname">{{t.tname}}</option>
                        </select>
                    </div>
                </div>
              </div>
              <div class="field mt-5">
                <label class="label has-text-white">เวลาเริ่มฉาย</label>
                <div class="control">
                  <input style="width: 380px; height: 40px;" type="time" v-model="st_time" id="start_show" name="start_show" min="00:00" max="23:59">
                </div>
              </div>
              <div class="field mt-5">
                <label class="label has-text-white">ภาษา</label>
                <div class="control ">
                  <div class="select is-normal">
                    <select v-model="language" style="width: 380px; height: 40px;">
                      <option>ENG</option>
                      <option>TH</option>
                    </select>
                  </div>
                </div>
              </div>
              </div>
              </div>
              <div class="columns my-5 ">
                <div class="column is-3"></div>
                <div class="column is-3">
                  <div class="field mt-5">
                    <div class="control">
                      <button @click="submitShow()" class="button is-danger" style="width: 200px; height: 40px;">Submit</button>
                    </div>
                  </div>
                </div>
                <div class="column is-3">
                  <div class="field mt-5">
                    <div class="control">
                    <router-link :to="`/movies/detail/${this.$route.params.id}`" class="has-text-light">
                        <button class="button is-danger is-light" style="width: 200px; height: 40px;">Cancel</button>
                      </router-link>
                    </div>
                  </div>
                </div>
                <div class="column is-3"></div>
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
        movie: [],
        theatre: [],
        m_name: "",
        t_name: "",
        show_date: "",
        language: "ENG",
        st_time: "",
        end_time: "",
    };
  },
  mounted() {
    window.scrollTo(0, 0)
    this.getMovieDetail(this.$route.params.id);
  },
  methods: {
      getMovieDetail(id) {
      axios
        .get(`http://localhost:3000/addShow/${id}`)
        .then((response) => {
          this.m_name = response.data.m_name[0].m_name;
          this.movie = response.data.movie;
          this.theatre = response.data.theatre;
          this.t_name = response.data.theatre[0].tname;
        })
        .catch((err) => {
          console.log(err);
        });
    },
      submitShow() {
        console.log(this.show_date)
          axios
            .post("http://localhost:3000/addShow/add", {
                m_name: this.m_name,
                tname: this.t_name,
                show_date: this.show_date,
                language: this.language,
                st_time: this.st_time+":00",
                end_time: this.end_time+":00"
            })
            .then((response) => {
              this.$router.push({ path: `/movies/detail/${response.data}` });
            })
            .catch((error) => {
                this.error = error.message;
            });
      },
      image(file_path){
        if (file_path) {
        return "http://localhost:3000/" + file_path;
      } else {
        return "https://bulma.io/images/placeholders/640x360.png";
      }
    },
  },
};
</script>

<style>
</style>