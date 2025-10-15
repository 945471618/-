<template>
  <div id="app">
    <router-view></router-view>
    <!-- 页面内容根据路由加载 -->
    <MyCounter/>
  </div>
</template>

<script setup >

import MyCounter from "@/components/MyCounter.vue";
</script>