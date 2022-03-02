<template>
  <div class="hello">
    <Header />
    <div class="container mrgnbtm">
          <div class="row">
            <div class="col-md-8" v-if="this.CreateUpdateMode=='view'">
                <SingleUser v-if="this.selectedUser!=null" :users="this.selectedUser" @switchMode="switchMode($event)"/>
            </div>
            <div class="col-md-8" v-else>
                <CreateUser @switchMode="switchMode($event)" @createUser="userCreate($event)" @updateUser="userUpdate($event)" :mode="this.CreateUpdateMode" :user="this.selectedUser"/>
            </div>
            <div class="col-md-4">
                <DisplayBoard :numberOfUsers="numberOfUsers" @getAllUsers="getAllUsers()" />
            </div>
          </div>
    </div>
    <div class="row mrgnbtm">
        <Users v-if="users.length>0" :users="users" @deleteUser="userDelete($event)" @switchMode="switchMode($event)" @selectUser="userSelect($event)" />
    </div>
  </div>
</template>

<script>
import Header from './Header.vue'
import CreateUser from './CreateUser.vue'
import DisplayBoard from './DisplayBoard.vue'
import SingleUser from './SingleUser.vue'
import Users from './Users.vue'
import { getAllUsers, createUser, updateUser, deleteUser } from '../services/UserService'

export default {
  name: 'Dashboard',
  components: {
    Header,
    CreateUser,
    DisplayBoard,
    SingleUser,
    Users
  },
  data() {
      return {
          users: [],
          numberOfUsers: 0,
          selectedUser : null,
          CreateUpdateMode : 'create'
      }
  },
  methods: {
    getAllUsers() {
      getAllUsers().then(response => {
        console.log(response)
        this.users = response
        this.numberOfUsers = this.users.length
      })
    },
    userCreate(data) {
      console.log('data:::', data)
      data.id = this.numberOfUsers + 1
      createUser(data).then(response => {
        console.log(response);
        this.getAllUsers();
      });
    },
    userDelete(data){
      console.log('data:::', data)
      deleteUser(data).then(response => {
        console.log(response);
        this.getAllUsers();
      });
    },
    userUpdate(data){
      console.log('data:::', data)
      updateUser(data).then(response => {
        console.log(response);
        this.getAllUsers();
      })
    },
    switchMode(modeData){
      console.log('switch to mode:::', modeData)
      this.CreateUpdateMode = modeData;
      this.getAllUsers();
    },
    userSelect(selectedId){
      console.log('data selected:::', selectedId)
      for (var i in this.users) {
        if (this.users[i].id == selectedId) {
          this.selectedUser = this.users[i];
        }
      }
    }
  },
  mounted () {
    console.log("mounted OK, calling findAll...");
    this.getAllUsers();
    console.log("findAll worked");
  }
}
</script>