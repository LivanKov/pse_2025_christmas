<template>
  <div class="dashboard-container">
    <header class="dashboard-header">
      <h1>Welcome to Your Dashboard</h1>
      <div class="user-info">
        <span>{{ userType }}: {{ userIdentifier }}</span>
        <button @click="handleLogout" class="logout-button">Logout</button>
      </div>
    </header>
    <main class="dashboard-content">
      <button @click="check" class="logout-button">Check Axios</button>
    </main>
  </div>
</template>

<script>
import axios from 'axios';

export default {

  name: 'DashboardView',
  data() {
    return {
      userType: '',
      userIdentifier: '',
      activeTab: null
    }
  },
  created() {
    // Get user info from route params
    const { type, identifier } = this.$route.params
    this.userType = type || 'Customer'
    this.userIdentifier = identifier || 'Guest'
  },
  methods: {
    handleLogout() {
      // Navigate back to home
      this.$router.push('/')
    },
    check() {
      axios.get('http://localhost:8080/api/hello')
        .then(response => console.log(response))
        .catch(error => console.error(error))
    }
  }
}
</script>

<style scoped>
.dashboard-container {
  padding: 2rem;
  max-width: 1200px;
  margin: 0 auto;
}

.dashboard-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 2rem;
  padding-bottom: 1rem;
  border-bottom: 2px solid #eee;
}

.user-info {
  display: flex;
  align-items: center;
  gap: 1rem;
}

.logout-button {
  padding: 0.5rem 1rem;
  background-color: #dc3545;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  transition: background-color 0.3s;
}

.logout-button:hover {
  background-color: #c82333;
}

.dashboard-content {
  background: white;
  padding: 2rem;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}
</style>
