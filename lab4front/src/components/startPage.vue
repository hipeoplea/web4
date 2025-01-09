<template>
  <div class="home-page">
    <div class="header">
      <h1>Черемисова Мария</h1>
      <h3>P3210</h3>
      <h3>409829</h3>
    </div>
    <main class="main-content">
      <loginform @login="login"/>
      <p v-if="error" class="error">{{ error }}</p>
    </main>
  </div>
</template>

<script>
import {useAuthStore} from '@/auth';  // Импортируем хранилище
import loginform from '../components/subStartPage/LoginForm.vue';
import {useRouter} from 'vue-router';
import {watch} from 'vue';

export default {
  name: 'StartPage',
  components: {
    loginform,
  },
  setup() {
    const authStore = useAuthStore();  // Получаем доступ к хранилищу
    const router = useRouter();

    // Следим за состоянием пользователя и переходим на главную страницу после успешного входа
    watch(authStore.user, (newUser) => {
      if (newUser) {
        router.push('/main');
      }
    });

    return {user: authStore.user, error: authStore.error, login: authStore.login};
  },
};
</script>

<style scoped>
.home-page {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: flex-start;
  min-height: 100vh;
  background: #ecf0f3;
  color: #394a56;
}

.header {
  padding: 20px;
  text-align: center;
}

.main-content {
  max-width: 500px;
  padding: 20px;
  border-radius: 10px;
  margin-top: 20px;
  box-sizing: border-box;
  overflow-y: auto;
  margin-bottom: 20px;
}

.error {
  color: red;
  margin-top: 10px;
  font-size: 14px;
}
</style>
