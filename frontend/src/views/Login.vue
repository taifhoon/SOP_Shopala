<template>
  <section class="hero is-white">
    <div class="hero-body">
      <div class="container">
        <p class="title ">Login Customer</p>
        <div class="columns is-centered">
          <div class="
              column
              is-5-tablet is-4-desktop is-3-widescreen
              box
              has-background-grey-light
            ">
            <div class="field">
              <label for="" class="label">Email</label>
              <div class="control has-icons-left">
                <input v-model="email" type="email" placeholder="youremail@hotmail.com" class="input" required />
                <span class="icon is-small is-left">
                  <i class="fa fa-envelope"></i>
                </span>
              </div>
            </div>
            <div class="field">
              <label for="" class="label">Password</label>
              <div class="control has-icons-left">
                <input v-model="password" type="password" placeholder="*******" class="input" required />
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
              <button class="button has-background-black is-outlined" @click="submit">
                <strong class="has-text-white">Log in</strong>
              </button>
              {{ incorrect }}
            </div>

          </div>
        </div>
        <p class="my-3">
          Don't have an account yet? 
          <router-link to="/user/signup" >
          <a class='loginbutton'>Signup</a>
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
      listCustomers:[],
      username: "",
      email: "",
      password: "",
      incorrect: "",
      role: "",
    };
  },
  mounted(){
    this.getCustomers()
  },
  methods: {
    getCustomers(){
      axios
        .get(`http://localhost:8003/getCustomers`)
        .then((res) => {
          this.listCustomers = res.data
        })
        .catch((error) => {
          alert(error.response.data.message)
        });
    },
    submit() {
      var check = false
      this.listCustomers.forEach(cus => {
        if (cus.email == this.email && cus.password == this.password){
          localStorage.setItem("customerId", cus._id);
          check = true
          location.reload()
          
        }
      })
      if (!check){
        console.log("incorrect Email or Password")
      }
      
      // if (!this.role) {
      //   alert("Please choose role to login.")
      //   return
      // }
      // const data = {
      //   username: this.email,
      //   password: this.password,
      //   role: this.role,
      // };

      // axios
      //   .post("http://localhost:3000/user/login/", data)
      //   .then((res) => {
      //     const token = res.data.token;
      //     localStorage.setItem("token", token);
      //     this.$emit("auth-change");
      //     this.$router.push({ path: "/" });
      //   })
      //   .catch((error) => {
      //     this.error = error.response.data;
      //     console.log(error.response.data);
      //   });
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
.loginbutton{
  color: #3273dc;
  cursor: pointer;
  text-decoration: none;
}
</style>
