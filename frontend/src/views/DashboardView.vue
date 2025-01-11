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
      <template>
        <div class="fixed inset-0 flex">
          <!-- Side bookmarks -->
          <div class="relative">
            <!-- Bookmark tabs -->
            <div class="absolute left-0 flex flex-col gap-2 -translate-x-full py-4">
              <button v-for="(tab, index) in tabs" :key="index" @click="activeTab = index"
                class="flex items-center bg-white shadow-md rounded-l-lg px-4 py-2 transition-all" :class="[
                  activeTab === index
                    ? 'translate-x-0 bg-blue-50'
                    : '-translate-x-2 hover:translate-x-0'
                ]">
                {{ tab.label }}
              </button>
            </div>
          </div>

          <!-- Main content area -->
          <div class="flex-1 bg-white shadow-lg p-8">
            <component :is="currentComponent" v-if="currentComponent" />
            <div v-else class="text-gray-500">
              Select a tab to view content
            </div>
          </div>
        </div>
      </template>
    </main>
  </div>
</template>

<script>
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
