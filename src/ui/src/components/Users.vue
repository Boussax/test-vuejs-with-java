<template>
    <div class="container">
        <h2>Users</h2>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>User Id</th>
                <th>Firstname</th>
                <th>Lastname</th>
                <th>Email</th>
                <th>Modify/Delete</th>
            </tr>
            </thead>
            <tbody>
              <tr v-for="item in users" :key="item.id">
                  <td>{{ item.id }}</td>
                  <td>{{ item.firstName }}</td>
                  <td>{{ item.lastName }}</td>
                  <td>{{ item.email }}</td>
                  <td>  <button v-on:click="modifyUser(item.id)">modify</button>
                        <button v-on:click="deleteUser(item)" >delete</button>
                        <button v-on:click="selectUser(item.id)" >details</button> </td>
              </tr>
            </tbody>
        </table>
    </div>
</template>

<script>

    export default {
        name: 'Users',
        props: ['users'],
        methods : {
            deleteUser(user){
                console.log('delete user :' + user.id);
                this.$emit('deleteUser', user);
            },
            modifyUser(userId){
                console.log('modify user :' + userId);
                this.$emit('switchMode', 'modify');
                this.$emit('selectUser', userId);
            },
            selectUser(userId) {
                console.log('selected user :' + userId);
                this.$emit('selectUser', userId);
                this.$emit('switchMode', 'view');
            }
        }
    }

</script>