<template>
  <RouterView />
</template>

<script setup>
import { RouterView } from 'vue-router'
</script>

<style>
:root {
  --primary-color: #2C3E50;
  --accent-color: #3498DB;
  --background-color: #ECF0F1;
  --snow-color: #FFFFFF;
  --text-color: #2C3E50;
  --error-color: #E74C3C;
}

* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

body {
  font-family: 'Arial', sans-serif;
  background-color: var(--background-color);
}
</style>