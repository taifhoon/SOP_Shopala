<template>
  <section class="hero is-white">
    <div class="hero-body">
      <div class="container">
        <p class="title">Login seller</p>
        <div class="columns is-centered">
          <div
            class="
              column
              is-5-tablet is-4-desktop is-3-widescreen
              box
              has-background-link-light
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
            <!-- <div class="field">
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
              </div> -->
            <div class="field">
              <button
                class="button has-background-black is-outlined"
                @click="submit"
              >
                <strong class="has-text-white">Log in</strong>
              </button>
              {{ incorrect }}
            </div>
          </div>
        </div>
        <p class="my-3">
          Don't have an account yet?
          <router-link to="/user/signupseller">
            <a class="loginbutton">Signup</a>
          </router-link>
        </p>
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
      listseller: [],
    };
  },
  mounted() {
    this.getseller();
  },
  methods: {
    submit() {
      var check = false;
      this.listseller.forEach((cus) => {
        if (cus.email == this.email && cus.password == this.password) {
          localStorage.setItem("sellerId", cus._id);
          check = true;
          location.reload()
        }
      });
      if (!check) {
        console.log("incorrect Email or Password");
      }
    },
    getseller() {
      axios
        .get(`http://localhost:8004/getSellers`)
        .then((res) => {
          this.listseller = res.data;
        })
        .catch((error) => {
          alert(error.response.data.message);
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
.loginbutton {
  color: #3273dc;
  cursor: pointer;
  text-decoration: none;
}
</style>