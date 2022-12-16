<template>
  <section class="hero is-white">
    <div class="hero-body">
      <div class="container">
        <div class="columns is-centered">
          <div
            class="
              column
              is-5-tablet is-4-desktop is-3-widescreen
              box
              has-background-grey-light
            "
          >
            <div class="field">
              <label for="" class="label">Email</label>
              <div class="control has-icons-left">
                <input
                  v-model="email"
                  type="email"
                  placeholder="youremail@hotmail.com"
                  class="input"
                  required
                />
                <span class="icon is-small is-left">
                  <i class="fa fa-envelope"></i>
                </span>
              </div>
            </div>
            <div class="field">
              <label for="" class="label">Password</label>
              <div class="control has-icons-left">
                <input
                  v-model="password"
                  type="password"
                  placeholder="*******"
                  class="input"
                  required
                />
                <span class="icon is-small is-left">
                  <i class="fa fa-lock"></i>
                </span>
              </div>
            </div>
            <div class="field">          
              <div class="control">
                <label class="radio">
                  <input type="radio" name="login" value="admin" v-model="role">
                  Admin
                </label>
                <label class="radio">
                  <input type="radio" name="login" value="customer" v-model="role">
                  Customer
                </label>
              </div>
            </div>
            <div class="field">
              <button class="button has-background-black is-outlined" @click="submit">
                <strong class="has-text-white">Log in</strong>
              </button>
              {{ incorrect }}
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import axios from "@/plugins/axios";
export default {
  name: "App",
  data() {
    return {
      username: "",
      email: "",
      password: "",
      incorrect: "",
      role: "",
    };
  },
  methods: {
    submit() {
      if (!this.role){
        alert("Please choose role to login.")
        return
      }
      const data = {
        username: this.email,
        password: this.password,
        role: this.role,
      };

      axios
        .post("http://localhost:3000/user/login/", data)
        .then((res) => {
          const token = res.data.token;
          localStorage.setItem("token", token);
          this.$emit("auth-change");
          this.$router.push({ path: "/" });
        })
        .catch((error) => {
          this.error = error.response.data;
          console.log(error.response.data);
        });
    },
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
