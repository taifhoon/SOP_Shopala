<template>
  <div class="container is-widescreen">
    <section class="section" id="app">
      <p class="title has-text-white has-text-left">My Profile</p>
      <div class="column has-background-white p-5 is-size-4">
        <div class="card-image m-5 p-5 has-text-center">
          <figure>
            <!-- ไว้ใส่รูป -->
            <img
              style="width: 180px; height: 100%"
              src="https://upload.wikimedia.org/wikipedia/commons/thumb/7/7e/Circle-icons-profile.svg/2048px-Circle-icons-profile.svg.png"
              alt="Placeholder image"
            />
          </figure>
        </div>
        <div class="columns has-text-left">
          <div class="column is-5">
            <p>Name</p>
            <input
              class="input is-hovered"
              type="text"
              v-model="name"
              disabled
            />
          </div>
          <div class="column is-5">
            <p>Phone Number</p>
            <input
              class="input is-hovered"
              type="text"
              v-model="phone"
              placeholder="Hovered input"
              disabled
            />
          </div>
        </div>
        <div class="columns has-text-left">
          <div class="column is-5">
            <p>Email</p>
            <input
              class="input is-hovered"
              type="text"
              v-model="email"
              placeholder="Hovered input"
              disabled
            />
          </div>
        </div>
        <div class="columns has-text-left">
          <div class="column is-5">
            <div class="buttons">
              <button
                class="button is-info"
                @click="passwordModal = !passwordModal"
              >
                Change password
              </button>
            </div>
          </div>
        </div>
        <p v-if="success" class="has-text-success is-size-7">{{ success }}</p>
        <br />
        <div class="column" v-if="passwordModal == true">
          <div class="columns">
            <div class="column is-3">
              <p class="is-size-6">Old Password</p>
              <input
                class="input is-hovered is-small"
                type="password"
                v-model="oldpassword"
                placeholder="Old password"
              />
            </div>
          </div>
          <div class="columns">
            <div class="column is-3">
              <p class="is-size-6">New Password</p>
              <input
                class="input is-hovered is-small"
                type="password"
                v-model="newpassword"
                placeholder="New password"
              />
            </div>
          </div>
          <div class="columns">
            <div class="column is-3">
              <p class="is-size-6">Confirm Password</p>
              <input
                class="input is-hovered is-small"
                type="password"
                v-model="confirmpassword"
                placeholder="Confirm password"
              />
            </div>
          </div>
          <p v-if="err" class="has-text-danger is-size-7">*{{ err }}</p>
          <br />
          <div class="buttons">
            <button class="button is-success" @click="ChangePassword()">
              Change
            </button>
            <button class="button is-danger" @click="passwordModal = false">
              Cancel
            </button>
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
  props: ["user"],
  data() {
    return {
      passwordModal: false,
      oldpassword: "",
      newpassword: "",
      confirmpassword: "",
      confirmnewpassword: "",
      email: "",
      name: "",
      phone: "",
      err: "",
      success: null,
    };
  },
  mounted() {
    window.scrollTo(0, 0);
  },
  created() {
    this.getProfile();
  },
  methods: {
    ChangePassword() {
      var id = this.$route.params.id;
      if (this.newpassword != this.confirmpassword) {
        this.err = "รหัสผ่านใหม่ไม่ตรงกัน";
      } else {
        axios
          .put(`/user/change/${id}`, {
            oldpassword: this.oldpassword,
            newpassword: this.newpassword,
          })
          .then((res) => {
            this.err = res.data;
            if (this.err != "รหัสผ่านไม่ถูกต้อง") {
              this.passwordModal = false;
              this.err = null;
              this.success = res.data;
              (this.oldpassword = ""),
                (this.newpassword = ""),
                (this.confirmpassword = "");
            } else if (this.err == "รหัสผ่านไม่ถูกต้อง") {
              this.err = res.data;
              this.success = null;
            }
          });
      }
    },
    getProfile() {
      this.email = this.user.email_id;
      this.name = this.user.c_name;
      this.phone = this.user.phone_no;
    },
  },
  
}
</script>
