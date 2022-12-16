<template>
  <section class="section" id="app">
    <div class="content">
      <div class="columns">
        <div class="column">
          <img
            style="
              width: 432px;
              height: 587px;
              margin-left: 15%;
              margin-right: 15%;
            "
            :src="image(movie.img_movie)"
          />
        </div>
        <div class="column is-6 level-right">
          <div class="title">
            <p class="title has-text-white">{{ movie.m_name }}</p>
          </div>
          <hr />
          <div class="detail">
            <p class="has-text-white has-text-justified">
              {{ movie.plot }}
            </p>
            <table
              class="table is-bordered has-background-black has-text-white"
            >
              <tr>
                <td>Theatre</td>
                <td>{{ movie.tname }}</td>
              </tr>
              <tr>
                <td>Date</td>
                <td>{{ movie.show_date }}</td>
              </tr>
              <tr>
                <td>Time</td>
                <td>{{ movie.st_time }} - {{ movie.end_time }}</td>
              </tr>
              <tr>
                <td>Language</td>
                <td>{{ movie.language }}</td>
              </tr>
              <tr>
                <td>Director</td>
                <td>{{ movie.director }}</td>
              </tr>
              <tr>
                <td>Cast</td>
                <td>
                  {{ movie.actors }}
                </td>
              </tr>
            </table>
          </div>
        </div>
        
      </div>
      <div class="columns m-5 is-multiline">
        <div class="column is-8"> 
          <table class="mx-auto" style="width: 80%;">
            <tbody>
              <tr v-for="r in rows" :key="r">
                <td v-for="c in cols" class="pl-2" :key="c">
                  <div class=" has-text-white" v-if="seatBook.includes(r + c)">
                    <img style="width: 100%;height: 100%" src="https://media.discordapp.net/attachments/953696113448337498/969286008040468510/reserved.png"/>
                    {{ r }}{{ c }}
                  </div>
                  <a  @click="selectSeat(r,c)" v-else-if="selectSeats.includes(r + c) && isCusto()" ><div class=" has-text-white">
                    <img style="width: 100%;height: 100%" src="https://media.discordapp.net/attachments/953696113448337498/969286008229220362/select.png"/>
                    {{ r }}{{ c }}
                  </div></a>
                  <a v-else-if="getType(r,c) == 'Normal'" @click="selectSeat(r,c)" ><div class='has-text-white'>
                     <img style="width: 100%;height: 100%" src="https://media.discordapp.net/attachments/953696113448337498/969283005338251274/seat.png"/>
                    {{ r }}{{ c }}
                  </div></a>
                  <a v-else-if="getType(r,c) == 'Honeymoon'" @click="selectSeat(r,c)" ><div class='has-text-white'>
                     <img style="width: 100%;height: 100%;" src="https://media.discordapp.net/attachments/953696113448337498/969283005833166878/seatHoneymoon.png"/>
                    {{ r }}{{ c }}
                  </div></a>
                  
                  <a v-else-if="getType(r,c) == 'First Class'" @click="selectSeat(r,c)" ><div class='has-text-white'>
                    <img style="width: 100%;height: 100%;" src="https://media.discordapp.net/attachments/953696113448337498/969283005598281798/seatFirstclass.png"/>
                    {{ r }}{{ c }}
                  </div></a>
                </td>
              </tr>
            </tbody>
          </table>
                    <div class="columns is-centered has-background-danger-dark p-2 mt-5">
            <p class="is-size-3 has-text-white">SCREEN</p>
          </div>
          <div class="columns is-centered is-multiline mt-5">
            <div class='column is-1 has-text-white is-size-7'>
              <img style="width: 80%;height: 60%" src="https://media.discordapp.net/attachments/953696113448337498/969283005338251274/seat.png"/>
            <br>200 ฿
            </div>
            <div class='column is-1 has-text-white is-size-7'>
              <img style="width: 80%;height: 60%" src="https://media.discordapp.net/attachments/953696113448337498/969283005833166878/seatHoneymoon.png"/>
            <br>260 ฿
            </div>
            <div class='column is-1 has-text-white is-size-7'>
              <img style="width: 80%;height: 60%" src="https://media.discordapp.net/attachments/953696113448337498/969283005598281798/seatFirstclass.png"/>
            <br>300 ฿
            </div>
            
            <div class='column is-1 has-text-white is-size-7'>
              <img style="width: 80%;height: 60%" src="https://media.discordapp.net/attachments/953696113448337498/969286008040468510/reserved.png"/>
            <br>Reserved
            </div>
            <div class='column is-1 has-text-white is-size-7'>
              <img style="width: 80%;height: 60%" src="https://media.discordapp.net/attachments/953696113448337498/969286008229220362/select.png"/>
            <br>Selecting
            </div>

          </div>
        </div>
        <div v-if="isCusto()" class="column is-4">
          <p class="has-text-left has-text-white is-size-5">SUMMARY</p>
          <div class="box has-text-white has-background-grey">
            <div class="columns mt-2">
              <img style=" width: 132px; height: 187px; margin-left: 10%; margin-right: 5%;" :src="image(movie.img_movie)"/>
              <p class="has-text-left"><b>{{movie.m_name}} ({{movie.language}})</b> <br><br>
              {{movie.show_date}}
              <br> {{movie.st_time}} - {{movie.end_time}}<br><br><span class="is-italic"> {{movie.tname}} Theatre<br> {{movie.location}}</span></p>
            </div>
            <div class="columns ml-5">
              <div class="column is-6 has-text-left">Seats: {{selectSeats}}</div>
              <div class="column is-6">Price: {{priceOrder}} ฿</div>
            </div>
              <div v-if="selectSeats.length > 0" class="column">
                <button @click="confirmOrder(user.cid)" class="button is-danger is-fullwidth is-rounded"><span>Confirm Order</span></button>
              </div>
            </div>
        </div>
      </div>
    </div>
    <div v-if="isCusto()" class="modal" :class="{'is-active':  confirmModal}">
       <div class="modal-background"></div>
          <div class="modal-card">
             <header class="modal-card-head">
                <p class="modal-card-title"><strong>Confirm Order</strong></p>
            </header>
            <section class="modal-card-body">
              <img style=" width: 132px; height: 187px; margin-left: 10%; margin-right: 5%; margin-bottom: 5%" :src="image(movie.img_movie)"/>
              <p class="has-text-centered"><b>{{movie.m_name}} ({{movie.language}})</b></p><br>
              <p class="has-text-left"><b>Date:&nbsp;&nbsp;&nbsp;&nbsp;</b>{{movie.show_date}}, {{movie.st_time}} - {{movie.end_time}}</p>
              <p class="has-text-left"><b>Location:&nbsp;&nbsp;</b>{{movie.tname}} Theatre, {{movie.location}}</p>
              <p class="has-text-left"><b>Seats:&nbsp;&nbsp;</b> {{selectSeats}}</p>
              <p class="has-text-left"><b>Total Price:&nbsp;&nbsp;</b> {{priceOrder}} ฿</p>
            </section>
            <footer class="modal-card-foot">
              <router-link
                :to="`/booking/${this.orderId}`"
                class="card-footer-item has-text-light">
                <button class="button is-danger">Yes</button>
              </router-link>
              <button @click="closeModal()" class="button">No</button>
            </footer>
          </div>
        </div>
  </section>
</template>

<script>
import axios from '@/plugins/axios'
export default {
  name: "app",
   props: ['user'],
  data() {
    return {
      seat: [],
      movie: [],
      seatBook: [],
      rows: [],
      cols: [],
      selectSeats: [],
      color: null,
      confirmModal: false,
      orderId: null,
      orderType: [],
      itemId: [],
      seatId: [],
    };
  },
  mounted() {
    window.scrollTo(0, 0)
    this.getSeat(this.$route.params.id);
  },
  computed: {
    priceOrder(){
      var total = 0

      for (var i = 0; i < this.selectSeats.length; i++) {
        for (var j = 0; j < this.seat.length; j++) {
          if (this.seat[j].no_of_seats == this.selectSeats[i]){
            total += this.seat[j].type_price
          }
        }
      }
      return total
    }
  },
  methods: {
    getSeat(id) {
      axios
        .get(`http://localhost:3000/movie/${id}`)
        .then((response) => {
          this.seat = response.data.seat;
          this.movie = response.data.movie[0];
          this.getSeatBook(response.data.seatBook);
          this.movie.show_date = new Date(this.movie.show_date).toDateString()
          if (this.seat[0].THEATRE_tid == 1 || this.seat[0].THEATRE_tid == 2) {
            this.rows = ["A", "B", "C", "D", "E"];
            this.cols = ["01", "02", "03", "04", "05", "06", "07", "08", "09", "10"];
          } else if (this.seat[0].THEATRE_tid == 3) {
            this.rows = ["A", "B", "C"];
            this.cols = ["01", "02", "03", "04", "05"];
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
    getSeatBook(Book) {
      for (var i = 0; i < Book.length; i++) {
        this.seatBook.push(Book[i].no_of_seats);
      }
    },
    selectSeat(r, c){
      if (this.selectSeats.includes(r+c)){
        this.selectSeats.splice(this.selectSeats.indexOf(r+c), 1)
      }else{
        this.selectSeats.push(r+c);
      }
    },
    getType(r, c){
      for (var i = 0; i < this.seat.length; i++) {
        if (this.seat[i].no_of_seats.includes(r+c)){
          var type = i
        }
      }
      return this.seat[type].type_name
    },
    confirmOrder(id){
      this.confirmModal = true
      for (var i = 0; i < this.selectSeats.length; i++) {
        for (var j = 0; j < this.seat.length; j++) {
          if (this.seat[j].no_of_seats == this.selectSeats[i]){
            this.orderType.push(this.seat[j].type_price)
          }
        }
      }
      this.getSeatId()
      axios
      .put(`http://localhost:3000/movie/confirm/${id}`, {
            selectSeat: this.selectSeats,
            price: this.priceOrder,
            type: this.orderType,
            movie: this.movie,
            seatId: this.seatId
        })
      .then((res) => {
        this.orderId = res.data.orderId
        this.itemId = res.data.itemId
        console.log(this.orderId)
      }).catch((err) => {
          console.log(err);
        });
    },
    closeModal(){
      this.confirmModal = false
      this.orderType = []
      axios
      .delete(`http://localhost:3000/movie/cancel/${this.orderId}`,{
        itemId: this.itemId
      })
      .then((res) => {
        res
      }).catch((err) => {
          console.log(err);
        });
    },
    getSeatId(){
      for (var i=0; i < this.selectSeats.length; i++){
        for (var j=0; j < this.seat.length; j++){
          if (this.selectSeats[i] == this.seat[j].no_of_seats)
          this.seatId.push(this.seat[j].seat_id)
        }
      }
      console.log(this.seatId)
    },
    image(file_path){
        if (file_path) {
        return "http://localhost:3000/" + file_path;
      } else {
        return "https://bulma.io/images/placeholders/640x360.png";
      }
    },
    isAdmin(){
      if (!this.user) return false
      return this.user.role == 'admin'
    },
    isCusto(){
      if (!this.user) return false
      return this.user.role == 'customer'
    }
  }
};
</script>