import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

export default new Vuex.Store({
    state: {
        token: localStorage.getItem('token') || '',  // 初始从 localStorage 获取 token
    },
    mutations: {
        setToken(state, token) {
            state.token = token;
            localStorage.setItem('token', token);  // 将 token 存储到 localStorage
        },
        clearToken(state) {
            state.token = '';
            localStorage.removeItem('token');  // 清除 token
        },
    },
    actions: {
        setToken({ commit }, token) {
            commit('setToken', token);
        },
        clearToken({ commit }) {
            commit('clearToken');
        },
    },
    getters: {
        isAuthenticated: (state) => !!state.token,  // 判断是否已经登录
    },
});
