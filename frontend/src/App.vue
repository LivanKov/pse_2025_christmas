<template>
  <div id="app">
    <h1>{{ title }}</h1>
    <div v-if="message" class="message">
      {{ message }}
    </div>
    <button @click="fetchMessage">Fetch Message from Backend</button>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'App',
  data() {
    return {
      title: 'Quarkus + Vue.js Application',
      message: ''
    }
  },
  methods: {
    async fetchMessage() {
      try {
        const response = await axios.get('http://localhost:8080/api/hello')
        this.message = response.data.message
      } catch (error) {
        console.error('Error fetching message:', error)
        this.message = 'Error fetching message from backend'
      }
    }
  }
}
</script>

<style>
#app {
  font-family: Arial, sans-serif;
  max-width: 800px;
  margin: 0 auto;
  padding: 2rem;
  text-align: center;
}

button {
  background-color: #4CAF50;
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
  border-radius: 4px;
}

.message {
  margin: 20px 0;
  padding: 20px;
  background-color: #f0f0f0;
  border-radius: 4px;
}
</style>
