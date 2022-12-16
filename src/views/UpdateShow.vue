<template>
  <div class="container is-widescreen">
    <div class="columns pb-5">
      <div class="column box mx-5 mb-5 has-background-grey-dark">
        <section class="hero">
          <div class="hero-body">
            <p class="title has-text-white">Edit New Show</p>
          </div>
        </section>
        <section class="px-6">
          <div class="columns">
          <div class="column">
              <div class="field mt-5">
                <label class="label has-text-white">ชื่อหนัง</label>
                <div class="control">
                  <div class="select is-normal" style="left: 0;">
                        <select v-model="m_name" disabled>
                            <option>{{m_name}}</option>
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
                        <select v-model="t_name" style="width: 380px; height: 40px;" disabled>
                            <option>{{t_name}}</option>
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
                      <option value="ENG">ENG</option>
                      <option value="TH">TH</option>
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
                    <router-link :to="`/movies/detail/${this.moviedetail.m_id}`" class="has-text-light">
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
        moviedetail: [],
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
    this.getShow(this.$route.params.id)
  },
  methods: {
      getShow(id) {
      axios
        .get(`http://localhost:3000/edit/show/${id}`)
        .then((response) => {
          this.moviedetail =  response.data.show[0]
          this.m_name = response.data.show[0].m_name
          console.log(this.m_name)
          this.t_name = response.data.show[0].tname;
          this.st_time = response.data.show[0].st_time;
          this.end_time = response.data.show[0].end_time;
          this.language = response.data.show[0].language;
          this.show_date = response.data.show[0].show_date;
          var date = this.show_date.split('T')[0].split('-')
          this.show_date = date[0]+'-'+date[1]+'-'+(parseInt(date[2])+1)
        })
        .catch((err) => {
          console.log(err);
        });
    },
      submitShow() {
          axios
            .post(`http://localhost:3000/edit/show/${this.$route.params.id}`, {
                show_date: this.show_date,
                language: this.language,
                st_time: this.st_time,
                end_time: this.end_time
            })
            .then((response) => {
              console.log(response)
              this.$router.push({ path: `/movies/detail/${this.moviedetail.m_id}` });
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