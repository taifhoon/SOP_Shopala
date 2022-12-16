import Vue from 'vue'
import App from './App.vue'
import router from './router/index'
import Vuelidate from 'vuelidate'
import 'bulma/css/bulma.css'

Vue.use(Vuelidate)
Vue.config.productionTip = false

// เป็นการสร้าง instance ของ Vue
new Vue({
  router,
    render: h => h(App),
}).$mount('#app')