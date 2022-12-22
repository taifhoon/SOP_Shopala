<template>
  <div class="container is-widescreen">
    <section class="section box" id="app">
      <p class="title has-text-left pl-5">My Profile</p>
      <hr />
      <div class="columns">
        <div class="column is-2">
          <img style="width: 130px; height: 130px"
            src="https://upload.wikimedia.org/wikipedia/commons/thumb/7/7e/Circle-icons-profile.svg/2048px-Circle-icons-profile.svg.png"
            alt="Placeholder image" />
        </div>
        <div class="column">
          <div class="row">
            <div class="columns">
              <div class="column is-2">
                <p>ชื่อ :</p>
              </div>
              <div class="column is-5">
                <input class="input" type="text" v-model="customer.name" />
              </div>
            </div>
          </div>
          <div class="row">
            <div class="columns">
              <div class="column is-2">
                <p>อีเมล :</p>
              </div>
              <div class="column is-5">
                <input class="input" type="text" v-model="customer.email" />
              </div>
            </div>
          </div>
          <div class="row">
            <div class="columns">
              <div class="column is-2">
                <p>รหัสผ่าน :</p>
              </div>
              <div class="column is-5">
                <input class="input" type="text" v-model="customer.password" />
              </div>
            </div>
          </div>
          <div class="row">
            <div class="columns">
              <div class="column is-2">
                <p>เบอร์โทรศัพท์ :</p>
              </div>
              <div class="column is-5">
                <input class="input" type="text" v-model="customer.tel" />
              </div>
            </div>
          </div>
          <div class="row">
            <div class="columns">
              <div class="column is-2">
                <p>ที่อยู่ :</p>
              </div>
              <div class="column is-5">
                <input class="input" type="text" v-model="customer.address" />
              </div>
            </div>
          </div>
          <div class="row mt-5">
            <div class="columns">
              <div class="column is-2">
                <div class="buttons">
                  <router-link to="/">
                    <button class="button is-info" @click="save()" style="width: 140px;">
                      Save
                    </button>
                  </router-link>
                </div>
              </div>
              <div class="column is-2">
                <div class="buttons">
                  <router-link to="/">
                    <button class="button is-info" style="width: 140px;">
                      Cancel
                    </button>
                  </router-link>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>
<script>
import axios from "@/plugins/axios";
export default {
  name: "app",
  // props: ["user"],
  data() {
    return {
      // passwordModal: false,
      // newpassword: "",
      // confirmpassword: "",
      // confirmnewpassword: "",
      // email: "",
      // name: "",
      // phone: "",
      // password: "",
      // err: "",
      // success: null,
      customer: {}
    };
  },
  mounted() {
    this.getCustomer()
  },
  methods: {
    getCustomer() {
      axios
        .get(`http://localhost:8003/getCustomers`)
        .then((res) => {
          this.customer = res.data.filter(item => {
            return item._id == localStorage.getItem("customerId")
          })[0]
        })
        .catch((error) => {
          alert(error.response.data.message)
        });
    },
    save(){
      axios
        .post(`http://localhost:8003/updateCustomer`, this.customer)
        .then((res) => {
          this.customer = res.data.filter(item => {
            return item._id == localStorage.getItem("customerId")
          })[0]
        })
        .catch((error) => {
          alert(error.response.data.message)
        });
    }
  }
  // mounted() {
  //   window.scrollTo(0, 0);
  // },
  // created() {
  //   this.getProfile();
  // },
  // methods: {
  //   ChangePassword() {
  //     var id = this.$route.params.id;
  //     if (this.newpassword != this.confirmpassword) {
  //       this.err = "รหัสผ่านใหม่ไม่ตรงกัน";
  //     } else {
  //       axios
  //         .put(`/user/change/${id}`, {
  //           oldpassword: this.oldpassword,
  //           newpassword: this.newpassword,
  //         })
  //         .then((res) => {
  //           this.err = res.data;
  //           if (this.err != "รหัสผ่านไม่ถูกต้อง") {
  //             this.passwordModal = false;
  //             this.err = null;
  //             this.success = res.data;
  //             (this.oldpassword = ""),
  //               (this.newpassword = ""),
  //               (this.confirmpassword = "");
  //           } else if (this.err == "รหัสผ่านไม่ถูกต้อง") {
  //             this.err = res.data;
  //             this.success = null;
  //           }
  //         });
  //     }
  //   },
  //   getProfile() {
  //     this.email = this.user.email_id;
  //     this.name = this.user.c_name;
  //     this.phone = this.user.phone_no;
  //   },
  // },

}
</script>
