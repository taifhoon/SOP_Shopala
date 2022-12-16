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
                  v-model="$v.email.$model"
                  :class="{ 'is-danger': $v.email.$error }"
                  type="email"
                  placeholder="youremail@hotmail.com"
                  class="input"
                  required
                />
                <span class="icon is-small is-left">
                  <i class="fa fa-envelope"></i>
                </span>
              </div>
              <template v-if="$v.email.$error">
                <p class="help is-danger" v-if="!$v.email.required">
                  This field is required
                </p>
                <p class="help is-danger" v-if="!$v.email.email">
                  The email format is incorrect
                </p>
                <p class="help is-danger" v-if="!$v.email.minLength">
                  The name less be at much 5 letters
                </p>
              </template>
            </div>
            <div class="field">
              <label for="" class="label">Password</label>
              <div class="control has-icons-left">
                <input
                  v-model="$v.password.$model"
                  :class="{ 'is-danger': $v.email.$error }"
                  type="password"
                  placeholder="*******"
                  class="input"
                  required
                />
                <span class="icon is-small is-left">
                  <i class="fa fa-lock"></i>
                </span>
              </div>
              <template v-if="$v.password.$error">
                <p class="help is-danger" v-if="!$v.password.required">
                  This field is required
                </p>
                <p class="help is-danger" v-if="!$v.password.minLength">
                  The password must be at least 8 letters
                </p>
                <p class="help is-danger" v-if="!$v.password.complexPassword">
                  The password is too easy
                </p>
              </template>
            </div>
            <div class="field">
              <label for="" class="label">confirm Password</label>
              <div class="control has-icons-left">
                <input
                  v-model="$v.confirm_password.$model"
                  :class="{ 'is-danger': $v.confirm_password.$error }"
                  type="password"
                  placeholder="*******"
                  class="input"
                  required
                />
                <span class="icon is-small is-left">
                  <i class="fa fa-lock"></i>
                </span>
              </div>
              <template v-if="$v.confirm_password.$error">
                <p class="help is-danger" v-if="!$v.confirm_password.sameAs">
                  This password not match
                </p>
              </template>
            </div>
            <div class="field">
              <label for="" class="label">Name</label>
              <div class="control has-icons-left">
                <input
                  v-model="$v.c_name.$model"
                  :class="{ 'is-danger': $v.c_name.$error }"
                  type="name"
                  placeholder="Firstname  Lastname"
                  class="input"
                  required
                />
                <span class="icon is-small is-left">
                  <i class="fa fa-envelope"></i>
                </span>
              </div>
              <template v-if="$v.c_name.$error">
                <p class="help is-danger" v-if="!$v.c_name.maxLength">
                  The name must be at much 150 letters
                </p>
                <p class="help is-danger" v-if="!$v.c_name.required">
                  This field is required
                </p>
              </template>
            </div>
            <div class="field">
              <label for="" class="label">Phonenumber</label>
              <div class="control has-icons-left">
                <input
                  v-model="$v.mobile.$model"
                  :class="{ 'is-danger': $v.mobile.$error }"
                  type="phonenumber"
                  placeholder="xxx-xxx-xxxx"
                  class="input"
                  required
                />
                <span class="icon is-small is-left">
                  <i class="fa fa-lock"></i>
                </span>
              </div>
              <template v-if="$v.mobile.$error">
                <p class="help is-danger" v-if="!$v.mobile.required">
                  This field is required
                </p>
                <p class="help is-danger" v-if="!$v.mobile.mobile">
                  Invalid Mobile Number
                </p>
              </template>
            </div>
            <div class="field">
              <button class="button has-background-black">
                <strong class="has-text-white" @click="submit()"
                  >Sign up</strong
                >
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import axios from "@/plugins/axios";
import {
  required,
  email,
  minLength,
  maxLength,
  sameAs,
} from "vuelidate/lib/validators";

function mobile(value) {
  return !!value.match(/0[0-9]{9}/);
}

function complexPassword(value) {
  if (!(value.match(/[a-z]/) && value.match(/[A-Z]/) && value.match(/[0-9]/))) {
    return false;
  }
  return true;
}

export default {
  name: "app",
  props: ["user"],
  data() {
    return {
      password: "",
      confirm_password: "",
      email: "",
      mobile: "",
      c_name: "",
    };
  },
  mounted() {},
  computed: {},
  methods: {
    submit() {
      // Validate all fields
      this.$v.$touch();

      // เช็คว่าในฟอร์มไม่มี error
      if (!this.$v.$invalid) {
        let data = {
          password: this.password,
          confirm_password: this.confirm_password,
          email: this.email,
          mobile: this.mobile,
          c_name: this.c_name,
        };

        axios
          .post("http://localhost:3000/user/signup", data)
          .then((res) => {
            console.log(res);
            alert("Sign up Success");
            this.$router.push({ path: "/user/login" });
          })
          .catch((err) => {
            alert(err.response.data.details.message);
          });
      }
    },
  },
  validations: {
    email: {
      required: required,
      email,
    },
    mobile: {
      required: required,
      mobile: mobile,
    },
    password: {
      required: required,
      minLength: minLength(8),
      complex: complexPassword,
    },
    confirm_password: {
      sameAs: sameAs("password"),
    },
    c_name: {
      maxLength: maxLength(150),
      required: required,
    },
  },
};
</script>
