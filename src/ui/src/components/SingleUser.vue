<template>
    <div class="container">
        <div class="table table-bordered">
            <h2>SingleUser</h2>
            <ul>
                <li>User Id : {{users.id}}</li>
                <li>Firstname : {{users.firstName}}</li>
                <li>Lastname : {{users.lastName}}</li>
                <li>Email : {{users.email}}</li>
            </ul>
            <button type="button" @click='backToCreate()' class="btn btn-warning">Go back</button>
        </div>

    </div>
</template>

<script>
    export default {
        name: 'SingleUser',
        props: ['users'],
        methods: {
            backToCreate() {
                this.$emit('switchMode','create');
            }
        },
        mounted () {
            console.log('users');
        }
    }
</script>