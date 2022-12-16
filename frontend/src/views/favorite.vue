<template>
    <body class='homepage'>
    <div class="container is-widescreen">
      <section class="section">
        <div class="content">
          <h1 class="title has-text-left">รายการโปรด</h1>
          <div class="columns is-multiline">
            <div class="column is-3" >
              <div class="card" id="card1">
                <div class="card-image pt-4">
                  <figure>
                    <img src="https://twicpics.celine.com/product-prd/images/large/344893602C.38NO_1_WIN21.jpg?twic=v1/cover=1:1/resize-max=480" alt="">
                  </figure>
                </div>
                <div class="card-content">
                  <div class="text">CELINE MARGARET LOAFER WITH TRIOMPHE CHAIN IN POLISHED BULLBLACK</div>
                  <div class="content zonecon">
                    <span>฿</span>
                    39,500
                  </div>
                </div>
                <footer class="card-footer">
                  <router-link class="card-footer-item has-text-dark" id='button' :to="`/detail`">Details</router-link>
                </footer>
              </div>
            </div>
          </div>
        </div>
      </section>
    </div>
    </body>
  </template>

<script>
export default {
  name: "app",
  props: ['user'],
  data() {
    return {
    };
  },
};
</script>