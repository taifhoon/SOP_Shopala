"use strict";(self["webpackChunkfrontend"]=self["webpackChunkfrontend"]||[]).push([[70],{70:function(t,s,a){a.r(s),a.d(s,{default:function(){return p}});var e=function(){var t=this,s=t.$createElement,a=t._self._c||s;return a("div",{staticClass:"container is-widescreen"},[a("div",{staticClass:"columns pb-5"},[a("div",{staticClass:"column box mx-5 mb-5 has-background-grey-dark",staticStyle:{"box-shadow":"rgba(0, 0, 0, 0.17) 0px -23px 25px 0px inset, rgba(0, 0, 0, 0.15) 0px -36px 30px 0px inset, rgba(0, 0, 0, 0.1) 0px -79px 40px 0px inset, rgba(0, 0, 0, 0.06) 0px 2px 1px, rgba(0, 0, 0, 0.09) 0px 4px 2px, rgba(0, 0, 0, 0.09) 0px 8px 4px, rgba(0, 0, 0, 0.09) 0px 16px 8px, rgba(0, 0, 0, 0.09) 0px 32px 16px"}},[t._m(0),a("section",{staticClass:"px-6"},[a("div",{staticClass:"columns is-multiline"},[a("div",{staticClass:"column is-6"},[a("div",{staticClass:"field mt-5"},[a("label",{staticClass:"label has-text-white"},[t._v("รูปภาพ")]),a("div",{staticClass:"control"},[a("input",{staticClass:"mb-5 ml-2 pl-5 pt-2",staticStyle:{width:"150px",height:"40px"},attrs:{multiple:"",type:"file",accept:"image/png, image/jpeg, image/webp"},on:{change:t.selectImages}})])])]),a("div",{staticClass:"column is-6"},[a("div",{staticClass:"field mt-5"},[a("label",{staticClass:"label has-text-white"},[t._v("ชื่อหนัง")]),a("div",{staticClass:"control"},[a("input",{directives:[{name:"model",rawName:"v-model",value:t.movie,expression:"movie"}],staticClass:"input",attrs:{type:"text",placeholder:"movie name"},domProps:{value:t.movie},on:{input:function(s){s.target.composing||(t.movie=s.target.value)}}})])])])]),a("br"),a("br"),a("div",{staticClass:"columns is-multiline"},[a("div",{staticClass:"column"},[a("div",{staticClass:"field"},[a("label",{staticClass:"label has-text-white"},[t._v("เนื้อเรื่องย่อ")]),a("div",{staticClass:"control"},[a("textarea",{directives:[{name:"model",rawName:"v-model",value:t.plot,expression:"plot"}],staticClass:"textarea",attrs:{placeholder:"Plot movie input"},domProps:{value:t.plot},on:{input:function(s){s.target.composing||(t.plot=s.target.value)}}})])])])]),a("br"),a("br"),a("div",{staticClass:"columns is-multiline"},[a("div",{staticClass:"column is-6"},[a("div",{staticClass:"field mt-5"},[a("label",{staticClass:"label has-text-white"},[t._v("ผู้กำกับ")]),a("div",{staticClass:"control"},[a("input",{directives:[{name:"model",rawName:"v-model",value:t.director,expression:"director"}],staticClass:"input",attrs:{type:"text",placeholder:"Director name"},domProps:{value:t.director},on:{input:function(s){s.target.composing||(t.director=s.target.value)}}})])])]),a("div",{staticClass:"column is-6"},[a("div",{staticClass:"field mt-5"},[a("label",{staticClass:"label has-text-white"},[t._v("นักแสดง")]),a("div",{staticClass:"control"},[a("input",{directives:[{name:"model",rawName:"v-model",value:t.actors,expression:"actors"}],staticClass:"input",attrs:{type:"text",placeholder:"Actors name"},domProps:{value:t.actors},on:{input:function(s){s.target.composing||(t.actors=s.target.value)}}})])])])]),a("div",{staticClass:"columns my-5 "},[a("div",{staticClass:"column is-2"},[a("div",{staticClass:"field is-grouped"},[a("div",{staticClass:"control"},[a("button",{staticClass:"button is-danger",staticStyle:{width:"150px",height:"40px",right:"0"},on:{click:function(s){return t.submitMovie()}}},[t._v("Submit")])])])]),a("div",{staticClass:"column is-2"},[a("div",{staticClass:"field is-grouped"},[a("div",{staticClass:"control"},[a("router-link",{staticClass:"has-text-light",attrs:{to:"/movies"}},[a("button",{staticClass:"button is-danger is-light",staticStyle:{width:"150px",height:"40px"},on:{click:function(t){return this.$router.push({path:"/movies"})}}},[t._v("Cancel")])])],1)])]),a("div",{staticClass:"column"})])])])])])},i=[function(){var t=this,s=t.$createElement,a=t._self._c||s;return a("section",{staticClass:"hero"},[a("div",{staticClass:"hero-body"},[a("p",{staticClass:"title has-text-white"},[t._v("Create New Movie")])])])}],l=a(4408),o={data:function(){return{movie:"",plot:"",director:"",actors:"",myImage:"",images:[]}},methods:{selectImages:function(t){this.myImage=t.target.files,console.log(this.myImage[0])},submitMovie:function(){var t=this,s=new FormData;s.append("movie",this.movie),s.append("plot",this.plot),s.append("director",this.director),s.append("actors",this.actors),s.append("myImage",this.myImage[0]),l.Z.post("http://localhost:3000/movies/add",s).then((function(s){console.log(s.data),t.$router.push({path:"/movies"})})).catch((function(s){t.error=s.message}))}}},c=o,n=a(1001),r=(0,n.Z)(c,e,i,!1,null,null,null),p=r.exports}}]);
//# sourceMappingURL=70-legacy.5d780073.js.map