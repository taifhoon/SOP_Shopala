"use strict";(self["webpackChunkfrontend"]=self["webpackChunkfrontend"]||[]).push([[181],{8181:function(t,s,e){e.r(s),e.d(s,{default:function(){return h}});var i=function(){var t=this,s=t.$createElement,e=t._self._c||s;return e("section",{staticClass:"section",attrs:{id:"app"}},[e("div",{staticClass:"content"},[e("div",{staticClass:"columns"},[e("div",{staticClass:"column"},[e("img",{staticStyle:{width:"432px",height:"587px","margin-left":"15%","margin-right":"15%"},attrs:{src:t.image(t.movie.img_movie)}})]),e("div",{staticClass:"column is-6 level-right"},[e("div",{staticClass:"title"},[e("p",{staticClass:"title has-text-white"},[t._v(t._s(t.movie.m_name))])]),e("hr"),e("div",{staticClass:"detail"},[e("p",{staticClass:"has-text-white has-text-justified"},[t._v(" "+t._s(t.movie.plot)+" ")]),e("table",{staticClass:"table is-bordered has-background-black has-text-white"},[e("tr",[e("td",[t._v("Release Date")]),e("td",[t._v(t._s(t.movie.release_date))])]),e("tr",[e("td",[t._v("Director")]),e("td",[t._v(t._s(t.movie.director))])]),e("tr",[e("td",[t._v("Cast")]),e("td",[t._v(" "+t._s(t.movie.actors)+" ")])])])])])]),e("div",{staticClass:"column m-5"},[e("p",{staticClass:"title has-text-white"},[t._v("รอบฉาย")]),e("div",{staticClass:"field level-right"},[e("div",{staticClass:"control"},[t.isAdmin()?e("router-link",{attrs:{to:"/AddShow/"+t.movie.m_id}},[e("button",{staticClass:"button is-warning"},[e("strong",[t._v("Add Show")])])]):t._e(),0==t.editShow&&t.isAdmin()?e("span",[e("button",{staticClass:"button is-danger ml-5",on:{click:function(s){return t.checkEditShow()}}},[e("strong",[t._v("Edit Show")])])]):1==t.editShow&&t.isAdmin()?e("span",[e("button",{staticClass:"button is-info ml-5",on:{click:function(s){return t.CancelEditShow()}}},[e("strong",[t._v("Cancel")])])]):t._e()],1)]),e("table",{staticClass:"table is-bordered has-background-danger-dark has-text-white"},[t._m(0),t._l(t.show,(function(s){return e("tr",{key:s.show_id,staticClass:"has-background-danger-light has-text-black"},[e("td",[t._v(t._s(s.tname))]),e("td",[t._v(t._s(s.show_date))]),e("td",[t._v(t._s(s.st_time))]),e("td",[t._v(t._s(s.end_time))]),e("td",[t._v(t._s(s.language))]),e("td",[0==t.editShow?e("div",[e("router-link",{attrs:{to:"/show/"+s.show_id}},[e("button",{staticClass:"button is-success"},[e("span",[t._v("Click")])])])],1):e("span",[e("router-link",{attrs:{to:"/edit/show/"+s.show_id}},[e("button",{staticClass:"button is-warning ml-2",on:{click:function(e){return t.EditShow(s.show_id)}}},[e("span",[t._v("Edit")])])]),e("button",{staticClass:"button is-danger ml-2",on:{click:function(e){return t.DeleteShow(s.show_id)}}},[e("span",[t._v("Delete")])])],1)])])})),0==t.show.length?e("tr",{staticClass:"has-background-danger-light has-text-black"},[e("td",[t._v("-")]),e("td",[t._v("-")]),e("td",[t._v("-")]),e("td",[t._v("-")]),e("td",[t._v("-")]),e("td",[t._v("-")])]):t._e()],2)])])])},a=[function(){var t=this,s=t.$createElement,e=t._self._c||s;return e("tr",[e("td",[t._v("Theatre")]),e("td",[t._v("Date")]),e("td",[t._v("Start")]),e("td",[t._v("End")]),e("td",[t._v("Language")]),e("td",[t._v("Link")])])}],o=e(4408),n={name:"app",props:["user"],data(){return{movie:[],show:[],editShow:!1}},mounted(){window.scrollTo(0,0),this.getMovieDetail(this.$route.params.id)},methods:{getMovieDetail(t){o.Z.get(`http://localhost:3000/movies/detail/${t}`).then((t=>{this.movie=t.data.moviedetail[0],this.show=t.data.show,this.movie.release_date=new Date(this.movie.release_date).toDateString();for(var s=0;s<this.show.length;s++)this.show[s].show_date=new Date(this.show[s].show_date).toDateString()})).catch((t=>{console.log(t)}))},image(t){return t?"http://localhost:3000/"+t:"https://bulma.io/images/placeholders/640x360.png"},isAdmin(){return!!this.user&&"admin"==this.user.role},isCusto(){return!!this.user&&"customer"==this.user.role},checkEditShow(){this.editShow=!0},CancelEditShow(){this.editShow=!1},DeleteShow(t){const s=confirm("Are you sure you want to delete this show ?");s&&o.Z["delete"](`http://localhost:3000/show/delete/${t}`).then((t=>{this.getMovieDetail(this.$route.params.id),this.editShow=!1,console.log(t)})).catch((t=>{alert(t.response.data.message)}))}}},l=n,r=e(1001),d=(0,r.Z)(l,i,a,!1,null,null,null),h=d.exports}}]);
//# sourceMappingURL=181.90c73977.js.map