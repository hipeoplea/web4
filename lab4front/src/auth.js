import { defineStore } from 'pinia';
import { ref } from 'vue';
import axios from 'axios';

export const useAuthStore = defineStore('auth', () => {
    const user = ref(null);
    const error = ref(null);

    const fetchUser = async () => {
        try {
            const response = await axios.get('http://localhost:8080/api/user');
            user.value = response.data;
        } catch (err) {
            error.value = err.message;
        }
    };

    const login = async (credentials) => {
        try {
            const response = await axios.post('http://localhost:8080/auth/login',
                new URLSearchParams({
                    username: credentials.username,
                    password: credentials.password,
                }),
                { headers: { 'Content-Type': 'application/x-www-form-urlencoded' } }
            );
            if (response.status === 200 && response.data === "Login successful") {
                await fetchUser();
            } else {
                throw new Error("Неверный логин или пароль");
            }
        } catch (err) {
            error.value = err.message;
        }
    };

    const logout = async () => {
        try {
            await axios.post('http://localhost:8080/auth/logout');
            user.value = null;
        } catch (err) {
            error.value = err.message;
        }
    };

    return { user, error, login, logout, fetchUser };
});
