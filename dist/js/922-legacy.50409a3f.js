"use strict";(self["webpackChunkfrontend"]=self["webpackChunkfrontend"]||[]).push([[922],{5922:function(t,s,a){a.r(s),a.d(s,{default:function(){return d}});var e=function(){var t=this,s=t.$createElement,a=t._self._c||s;return a("section",{staticClass:"section",attrs:{id:"app"}},[a("div",{staticClass:"content"},[a("div",{staticClass:"columns"},[a("div",{staticClass:"column is-1 has-text-left has-text-white p-5"}),a("div",{staticClass:"column box has-background-grey-lighter has-text-left has-text-black p-5"},[a("h2",[t._v("ข้อมูลการจอง")]),a("p",{staticClass:"is-size-5"},[t._v("เลขที่รายการคำสั่งซื้อ : "+t._s(t.order.order_id))]),a("p",{staticClass:"is-size-5"},[t._v("ชื่อลูกค้า : "+t._s(t.customer.c_name))]),a("p",{staticClass:"is-size-5"},[t._v("เรื่อง : "+t._s(t.movies.m_name))]),a("p",{staticClass:"is-size-5"},[t._v("วันที่ฉาย : "+t._s(t.show.show_date))]),a("p",{staticClass:"is-size-5"},[t._v("รอบฉาย : "+t._s(t.show.st_time)+" น.")]),a("p",{staticClass:"is-size-5"},[t._v("สถานที่ : "+t._s(t.theatre.tname))]),a("p",{staticClass:"is-size-5"},[t._v("ที่นั่งทั้งหมด : "+t._s(t.order.order_seats))]),a("p",{staticClass:"is-size-5"},[t._v("สรุปรายการสั่งซื้อ : "+t._s(t.order.total_price)+" บาท")])]),a("div",{staticClass:"column  has-text-white"},[a("img",{staticStyle:{height:"350px","margin-left":"auto","margin-right":"auto"},attrs:{src:t.image(t.movies.img_movie),alt:"Placeholder image"}})]),a("div",{staticClass:"column is-1 has-text-left has-text-white p-5"})]),a("div",{staticClass:"columns pt-5"},[a("div",{staticClass:"column box has-background-danger has-text-white"},[t._m(0),a("div",{staticClass:"column mb-3 box has-background-danger-light has-text-centered"},[a("h2",{staticClass:"my-5"},[t._v("ช่องทางการชำระเงิน")]),a("div",{staticClass:"row"},[a("div",{staticClass:"columns my-5 px-3 buttons"},[a("button",{staticClass:"column button",staticStyle:{height:"200px"},on:{click:function(s){return t.payment(t.order.order_id)}}},[a("h5",[t._v("บัตรเครดิตหรือบัตรเดบิต")]),a("img",{staticStyle:{height:"100px","margin-left":"auto","margin-right":"auto"},attrs:{src:"https://cdn.pixabay.com/photo/2017/09/18/08/56/credit-card-2761073_1280.png",alt:"Placeholder image"}})]),a("button",{staticClass:"column button is-dark",staticStyle:{height:"200px"},on:{click:function(s){return t.payment(t.order.order_id)}}},[a("h5",{staticClass:"has-text-white"},[t._v("Line Pay")]),a("img",{staticStyle:{height:"100px","margin-left":"auto","margin-right":"auto"},attrs:{src:"https://scontent.fbkk5-7.fna.fbcdn.net/v/t1.6435-9/92341124_870244826783542_351061654588358656_n.png?_nc_cat=107&ccb=1-5&_nc_sid=09cbfe&_nc_eui2=AeFb8B8GF-BUydiNIwjdSFhRrPDRVvqF402s8NFW-oXjTbzW_cRiMOtKz59CI5JRT7CQITqXGQ_CrC1KOBY6XRE2&_nc_ohc=awm9jQlVKp4AX-lpoqj&tn=UYmsLABXkAD-x4wL&_nc_ht=scontent.fbkk5-7.fna&oh=00_AT8K-Lr1pNvTPXfus_X1MXg3nMmzA6Vdk0EbsMkrGg2gbg&oe=628EC060",alt:"Placeholder image"}})]),a("button",{staticClass:"column button",staticStyle:{height:"200px"},on:{click:function(s){return t.payment(t.order.order_id)}}},[a("h5",[t._v("Paypal/Amex")]),a("img",{staticStyle:{height:"100px","margin-left":"auto","margin-right":"auto"},attrs:{src:"http://pngimg.com/uploads/paypal/paypal_PNG22.png",alt:"Placeholder image"}})]),a("button",{staticClass:"column button is-dark has-text-white",staticStyle:{height:"200px"},on:{click:function(s){return t.payment(t.order.order_id)}}},[a("h5",{staticClass:"has-text-white"},[t._v("QR code")]),a("img",{staticStyle:{height:"100px","margin-left":"auto","margin-right":"auto"},attrs:{src:"https://th.qr-code-generator.com/wp-content/themes/qr/new_structure/markets/basic_market/generator/dist/generator/assets/images/websiteQRCode_noFrame.png",alt:"Placeholder image"}})])])]),a("div",{staticClass:"row"},[a("div",{staticClass:"columns"},[a("div",{staticClass:"column is-3"}),a("div",{staticClass:"column"},[a("router-link",{staticClass:"card-footer-item has-text-light",attrs:{to:"/profile/myorder/"+t.order.order_id}},[a("button",{staticClass:"button is-dark has-text-white"},[t._v("ชำระเงินภายหลัง")])])],1),a("div",{staticClass:"column is-3"})])])])])])]),a("div",{staticClass:"modal",class:{"is-active":t.checkPayment}},[a("div",{staticClass:"modal-background"}),a("div",{staticClass:"modal-card"},[t._m(1),t._m(2),a("footer",{staticClass:"modal-card-foot"},[a("router-link",{staticClass:"card-footer-item has-text-light",attrs:{to:"/profile/myorder/"+t.order.order_id}},[a("button",{staticClass:"button is-success"},[t._v("ยืนยัน")])])],1)])])])},i=[function(){var t=this,s=t.$createElement,a=t._self._c||s;return a("div",{staticClass:"has-text-left my-5"},[a("h2",{staticClass:"is-underlined"},[t._v("สำหรับการซื้อตั๋ว")]),a("p",{staticClass:"is-size-4"},[t._v(" • ข้อตกลงและเงื่อนไข")]),a("p",{staticClass:"is-size-6"},[t._v("   - ลูกค้าต้องทำการชำระเงินก่อนรอบฉาย 25 นาที มิฉะนั้นบัตรที่จองไว้จะถูกยกเลิกโดยอัตโนมัติ")]),a("p",{staticClass:"is-size-6"},[t._v("   - เมื่อลูกค้าทำการซื้อบัตรเรียบร้อยเเล้ว ก่อนเข้าชมภาพยนต์จะต้องโชว์ข้อมูลการชำระเงินไปแล้วให้ทางเจ้าหน้าที่ตรวจสอบ")])])},function(){var t=this,s=t.$createElement,a=t._self._c||s;return a("header",{staticClass:"modal-card-head"},[a("p",{staticClass:"modal-card-title has-text-success"},[a("b",{staticClass:"is-size-3"},[t._v("ชำระเงินสำเร็จ")])])])},function(){var t=this,s=t.$createElement,a=t._self._c||s;return a("section",{staticClass:"modal-card-body"},[a("img",{staticClass:"my-3",staticStyle:{height:"100px","margin-left":"auto","margin-right":"auto"},attrs:{src:"https://cdn4.iconfinder.com/data/icons/colicon/24/checkmark_done_complete-512.png",alt:"Placeholder image"}}),a("p",{staticClass:"is-size-6 mb-3"},[t._v("ระบบได้ยืนยันการสั่งซื้อของลูกค้าเรียบร้อยแล้ว")]),a("p",{staticClass:"is-size-6 mb-3"},[t._v("ขอบคุณที่ใช้บริการ")])])}],o=a(4408),c={name:"app",props:["user"],data:function(){return{order:[],customer:[],show:[],movies:[],theatre:[],checkPayment:!1}},mounted:function(){window.scrollTo(0,0),this.getOrder(this.$route.params.orderId)},computed:{},methods:{getOrder:function(t){var s=this;o.Z.get("http://localhost:3000/booking/".concat(t)).then((function(t){console.log(t.data.show),s.order=t.data.order[0],s.customer=t.data.customer[0],s.show=t.data.show[0],s.movies=t.data.movies[0],s.theatre=t.data.theatre[0],s.show.show_date=new Date(s.show.show_date).toDateString();var a=s.order.order_seats.substring(0,s.order.order_seats.length-2);s.order.order_seats=a})).catch((function(t){console.log(t)}))},payment:function(t){this.checkPayment=!0,o.Z.put("http://localhost:3000/booking/".concat(t)).then((function(t){console.log(t)})).catch((function(t){console.log(t)}))},image:function(t){return t?"http://localhost:3000/"+t:"https://bulma.io/images/placeholders/640x360.png"}}},r=c,n=a(1001),l=(0,n.Z)(r,e,i,!1,null,null,null),d=l.exports}}]);
//# sourceMappingURL=922-legacy.50409a3f.js.map