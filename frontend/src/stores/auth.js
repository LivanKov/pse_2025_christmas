import { defineStore } from 'pinia'

const AUTH_KEY = 'auth_state'

export const useAuthStore = defineStore({
  id: 'auth',
  state: () => ({
    isAuthenticated: !!localStorage.getItem(AUTH_KEY),
    userType: null,
    user: null
  }),

  actions: {
    login(userType, credentials) {
      this.isAuthenticated = true
      this.userType = userType
      this.user = credentials
      localStorage.setItem(AUTH_KEY, 'true')
    },

    logout() {
      this.isAuthenticated = false
      this.userType = null
      this.user = null
      localStorage.removeItem(AUTH_KEY)
    },

    checkAuth() {
      return this.isAuthenticated
    }
  },

  getters: {
    isLoggedIn: (state) => state.isAuthenticated
  }
})
