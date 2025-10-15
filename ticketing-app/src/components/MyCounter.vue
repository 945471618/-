<script setup>
import { ref } from 'vue'
const count = ref(0)
const add = () => {
  count.value++
}
const subtract = () => {
  if (count.value > 0) count.value--;
}
</script>

<template>
<div><p>当前计数:{{ count }}</p>
  <button @click="add">+1</button>
  <button @click="subtract">-1</button>
</div>
</template>

<style scoped>

</style>