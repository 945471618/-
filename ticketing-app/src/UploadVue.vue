<script setup>
import {ElMessage} from "element-plus";
import { Plus } from '@element-plus/icons-vue'

const handleSuccess = (response) => {
  console.log('Upload response:', response);
  ElMessage.success('上传成功')
}

const handleError = (error) => {
  console.log('Upload error:', error);
  ElMessage.error('上传失败')
}
</script>

<template>
<el-upload action="/api/workorder/uploadimage"
accept="image/*"
:max-size="5242880"
:on-success="handleSuccess"
:on-error="handleError"
list-type="picture-card">
  <el-icon>
    <Plus />
  </el-icon>
  <div class="el-upload__text">点击上传图片</div>
</el-upload>
</template>

<style scoped>
</style>