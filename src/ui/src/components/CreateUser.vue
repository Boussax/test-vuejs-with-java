<template>
  <div class="container">
    <div class="row">
        <div class="col-md-7 mrgnbtm">
        <h2>Create User</h2>
            <form v-if="mode=='modify'">
                <div class="row">
                    <div class="form-group col-md-6">
                        <label htmlFor="exampleInputEmail1">First Name</label>
                        <input type="text" class="form-control" v-model="user.firstName" name="firstname" id="firstname" aria-describedby="emailHelp" placeholder="First Name"/>
                    </div>
                    <div class="form-group col-md-6">
                        <label htmlFor="exampleInputPassword1">Last Name</label>
                        <input type="text" class="form-control" v-model="user.lastName" name="lastname" id="lastname" placeholder="Last Name" />
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-12">
                        <label htmlFor="exampleInputEmail1">Email</label>
                        <input type="text" class="form-control" v-model="user.email" name="email" id="email" aria-describedby="emailHelp" placeholder="Email" />
                    </div>
                </div>
                <div class="btn-group">
                    <button type="button" @click='updateUser()' class="btn btn-success">Update</button>
                    <button type="button" @click='backToCreate()' class="btn btn-warning">Go back</button>
                    <!-- <button type="reset" @click='cancelChanges()' class="btn btn-danger">Cancel</button> -->
                </div>
            </form>
            <form v-if="mode=='create'">
                <div class="row">
                    <div class="form-group col-md-6">
                        <label htmlFor="exampleInputEmail1">First Name</label>
                        <input type="text" class="form-control" v-model="firstName" name="firstname" id="firstname" aria-describedby="emailHelp" placeholder="First Name"/>
                    </div>
                    <div class="form-group col-md-6">
                        <label htmlFor="exampleInputPassword1">Last Name</label>
                        <input type="text" class="form-control" v-model="lastName" name="lastname" id="lastname" placeholder="Last Name" />
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-12">
                        <label htmlFor="exampleInputEmail1">Email</label>
                        <input type="text" class="form-control" v-model="email" name="email" id="email" aria-describedby="emailHelp" placeholder="Email" />
                    </div>
                </div>
                <div class="btn-group">
                    <button type="submit" @click='createUser()' class="btn btn-success">Create</button>
                    <button type="button" @click='clearForm()' class="btn btn-danger">Clear</button>
                </div>
            </form>
        </div>
    </div>
    </div>
</template>

<script>
export default {
  name: 'CreateUser',
  props:['mode', 'user'],
  data() {
    return {
      id: '',
      firstName: '',
      lastName: '',
      email: ''
    }
  },
  methods: {
      createUser() {
          console.log(this.firstName)
          const payload = {
              firstName: this.firstName,
              lastName: this.lastName,
              email: this.email
          }
          this.$emit('createUser', payload)
          this.clearForm();
      },
      updateUser() {
          console.log("update user : " + this.firstName);
          const payload = {
              id: this.user.id,
              firstName: this.user.firstName,
              lastName: this.user.lastName,
              email: this.user.email
          }
          this.$emit('updateUser', payload);
          this.$emit('switchMode', 'create');
          this.clearForm();
      },
      backToCreate() {
          this.$emit('switchMode', 'create');
      },
      cancelChanges() {
          console.log("Adrien............"+this.user.firstName);
          console.log("Adrien............"+this.user.lastName);
          console.log("Adrien............"+this.user.email);
          this.$emit('switchMode', 'create');
          this.clearForm();
      },
      clearForm() {
          this.firstName = "";
          this.lastName = "";
          this.email = "";
      }
  }
}
</script>