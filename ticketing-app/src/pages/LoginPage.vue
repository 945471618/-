<template>
  <div class="login">
    <h2>Login</h2>
    <input v-model="username" type="text" placeholder="Username" />
    <input v-model="password" type="password" placeholder="Password" />
    <button @click="handleLogin">Login</button>
  </div>
</template>

<script>
import axios from 'axios';
import { mapActions } from 'vuex';

export default {
  data() {
    return {
      username: '',
      password: '',
    };
  },
  methods: {
    ...mapActions(['setToken']),
    async handleLogin() {
      try {
        const response = await axios.post('http://localhost:8080/auth/login', {
          username: this.username,
          password: this.password,
        });
        this.setToken(response.data.access_token);  // 存储 token 到 Vuex
        this.$router.push('/dashboard');  // 登录成功后跳转到 Dashboard
      } catch (error) {
        console.error('Login failed:', error);
      }
    },
  },
};
</script>

<style scoped>
.login {
  padding: 20px;
}
input {
  margin: 10px 0;
}
button {
  padding: 10px;
  background-color: #4CAF50;
  color: white;
}
</style>
