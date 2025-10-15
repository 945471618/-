import { createRouter, createWebHistory } from 'vue-router';
import Login from '../pages/LoginPage.vue';
import Dashboard from '../pages/UserDashboard.vue';
import UploadVue from '../UploadVue.vue';

const routes = [
    {
        path: '/login',
        name: 'Login',
        component: Login,
    },
    {
        path: '/upload',
        name: 'Upload',
        component: UploadVue,
    },
    {
        path: '/dashboard',
        name: 'Dashboard',
        component: Dashboard,
        meta: { requiresAuth: true },
    },
    {
        path: '/',
        redirect: '/upload',
    },
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

// 路由守卫：检查是否已登录
router.beforeEach((to, from, next) => {
    if (to.matched.some(record => record.meta.requiresAuth)) {
        // 如果访问的页面需要登录
        // 注意：这里需要根据你的实际 Vuex store 结构进行调整
        // 如果没有 Vuex，你需要用其他方式检查登录状态
        next(); // 暂时直接通过，你需要根据实际情况修改
    } else {
        next(); // 如果不需要登录，直接访问
    }
});

export default router;
