<template>
  <div class="login-form">
    <h2>Вход в приложение</h2>
    <form @submit.prevent="login">
      <div class="form-group">
        <label for="username">Username</label>
        <input class="textInput" type="text" id="username" v-model="username" placeholder="Username"/>
      </div>
      <div class="form-group">
        <label for="password">Password</label>
        <input class="textInput" type="password" id="password" v-model="password" placeholder="Password"/>
      </div>
      <button class="btn" type="submit">Войти</button>
    </form>
    <p v-if="error" class="error">{{ error }}</p>
  </div>
</template>

<script>
import { useAuthStore } from '@/auth';  // Импортируем хранилище

export default {
  props: {
    error: String,
  },
  data() {
    return {
      username: '',
      password: '',
    };
  },
  methods: {
      async login()
      {
        const authStore = useAuthStore();  // Получаем доступ к хранилищу
        if (!this.username || !this.password) {
          this.$emit('setError', 'Пожалуйста, заполните все поля.');
          return;
        }
        // Вызов метода login из хранилища Pinia
        await authStore.login({username: this.username, password: this.password});
      },
  },
};
</script>


<style scoped>
.login-form {
  display: inline-grid;
  grid-template-areas:
        "title"
        "inputs"
        "button";
  gap: 20px; /* Отступы между элементами формы */
  background: #ecf0f3;
  border-radius: 20px;
  box-shadow: -8px -8px 16px 0 #ffffff,
  8px 8px 16px 0 #d1d9e6;
  padding: 40px;
  width: 300px;
  justify-items: center;
  font-family: "Gowun Batang", serif;
}
.login-form .form-group{
  margin-top: 20px;
}
.login-form h2 {
  grid-area: title;
  font-size: 24px;
  color: #394a56;
  margin: 0;
  text-align: center;
}
.login-form label{
  padding-bottom: 5px;
}
.login-form .textInput {
  grid-area: inputs;
  font-size: 16px;
  border-radius: 8px;
  line-height: 1.5;
  padding: 10px 15px;
  border: 2px solid #dee1e2;
  color: rgb(53, 53, 87);
  background: #dee1e2;
  width: 100%;
  box-sizing: border-box;
  transition: box-shadow 100ms ease-in, border 100ms ease-in, background-color 100ms ease-in;
}

.login-form .textInput:hover {
  border-color: #ccc;
}

.login-form .textInput:focus {
  outline: none;
  border-color: #394a56;
  box-shadow: 0 0 8px rgba(57, 74, 86, 0.3);
}

.login-form .btn {
  grid-area: button;
  border: none;
  border-radius: 10px;
  background: #e2e8ed;
  box-shadow: 0 5px 0 #c6cfdd;
  font-size: 14px;
  font-weight: bold;
  padding: 10px 20px;
  color: #394a56;
  text-align: center;
  cursor: pointer;
  transition: all 0.3s ease;
  width: 100%;
  margin-top: 20px;
}

.login-form .btn:hover {
  background: #bec5d3;
  box-shadow: none;
  top: 5px;
}

.login-form .btn:active {
  background: #353557;
  color: #fff;
  box-shadow: inset 0 5px 10px rgba(0, 0, 0, 0.2);
}

.error {
  color: red;
  margin-top: 10px;
  font-size: 14px;
}
</style>