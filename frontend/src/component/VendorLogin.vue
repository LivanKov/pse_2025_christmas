<template>
  <div class="login-box">
    <div class="login-type-indicator">
      <div class="indicator-line">
        <div class="indicator-highlight" :class="{ 'vendor': isVendorLogin }"></div>
      </div>
      <div class="indicator-labels">
        <span 
          :class="{ 'active': !isVendorLogin }" 
          @click="toggleLoginType"
          class="clickable"
        >Customer</span>
        <span 
          :class="{ 'active': isVendorLogin }" 
          @click="toggleLoginType"
          class="clickable"
        >Vendor</span>
      </div>
    </div>
    <div class="snowflake-icon">❄️</div>
    <h1>Welcome to 2025 PSE Christmas Market!</h1>
    
    <!-- Customer Login Form -->
    <form v-if="!isVendorLogin" @submit.prevent="handleLogin" class="login-form">
      <div class="form-group">
        <input 
          type="email" 
          v-model="email" 
          placeholder="Email"
          required
        />
      </div>
      <div class="form-group">
        <input
          type="text"
          v-model="username"
          placeholder="Full Name"
          required
        />
      </div>
      <button type="submit" class="login-button">
        Sign In
      </button>
    </form>

    <!-- Vendor Login Form -->
    <form v-else @submit.prevent="handleVendorLogin" class="login-form">
      <div class="form-group">
        <input 
          type="text" 
          v-model="vendorId" 
          placeholder="Vendor ID"
          required
        />
      </div>
      <div class="form-group">
        <input 
          type="password" 
          v-model="vendorPassword" 
          placeholder="Password"
          required
        />
      </div>
      <button type="submit" class="login-button">
        Sign In as Vendor
      </button>
    </form>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'
import { useAuthStore } from '../stores/auth'

const router = useRouter()
const authStore = useAuthStore()

const email = ref('')
const username = ref('')
const vendorId = ref('')
const vendorPassword = ref('')
const isVendorLogin = ref(false)

async function handleLogin() {
  if (email.value.trim()) {
    authStore.login('visitor', { username: email.value })
    router.push('/dashboard')
  }
}

async function handleVendorLogin() {
  if (vendorId.value.trim() && vendorPassword.value.trim()) {
    authStore.login('vendor', { 
      username: vendorId.value,
      password: vendorPassword.value 
    })
    router.push('/dashboard')
  }
}

function toggleLoginType() {
  isVendorLogin.value = !isVendorLogin.value
  // Reset form fields when switching
  email.value = ''
  vendorId.value = ''
  vendorPassword.value = ''
}
</script>

<style scoped>
.login-box {
  background: rgba(255, 255, 255, 0.95);
  padding: 40px;
  border-radius: 20px;
  box-shadow: 0 8px 32px rgba(31, 38, 135, 0.15);
  width: 100%;
  max-width: 400px;
  text-align: center;
  position: relative;
  backdrop-filter: blur(4px);
  z-index: 2;
}

.snowflake-icon {
  font-size: 48px;
  margin-bottom: 20px;
}

h1 {
  color: var(--text-color);
  margin-bottom: 30px;
  font-size: 28px;
  font-weight: 700;
}

.form-group {
  margin-bottom: 20px;
}

input {
  width: 100%;
  padding: 12px 20px;
  border: 2px solid #e0e0e0;
  border-radius: 10px;
  font-size: 16px;
  transition: all 0.3s ease;
  background: var(--snow-color);
}

input:focus {
  outline: none;
  border-color: var(--accent-color);
  box-shadow: 0 0 0 2px rgba(52, 152, 219, 0.2);
}

.login-button {
  width: 100%;
  padding: 12px;
  background: linear-gradient(135deg, var(--accent-color) 0%, #2980B9 100%);
  border: none;
  border-radius: 10px;
  color: white;
  font-size: 16px;
  font-weight: 600;
  cursor: pointer;
  transition: all 0.3s ease;
}

.login-button:hover {
  transform: translateY(-2px);
  box-shadow: 0 4px 12px rgba(52, 152, 219, 0.4);
}

.forgot-password {
  margin-top: 20px;
}

.forgot-password a {
  color: var(--accent-color);
  text-decoration: none;
  font-size: 14px;
  transition: all 0.3s ease;
}

.forgot-password a:hover {
  color: #2980B9;
  text-decoration: underline;
}

.login-options {
  margin-top: 20px;
  display: flex;
  flex-direction: column;
  gap: 15px;
  align-items: center;
}

.toggle-login-button {
  background: none;
  border: none;
  color: var(--accent-color);
  font-size: 14px;
  cursor: pointer;
  padding: 5px 10px;
  text-decoration: underline;
  transition: all 0.3s ease;
}

.toggle-login-button:hover {
  color: #2980B9;
  transform: translateY(-1px);
}

.login-type-indicator {
  width: 100%;
  margin-bottom: 20px;
}

.indicator-line {
  height: 3px;
  background-color: #e0e0e0;
  position: relative;
  border-radius: 1.5px;
  overflow: hidden;
}

.indicator-highlight {
  position: absolute;
  width: 50%;
  height: 100%;
  background: linear-gradient(90deg, var(--accent-color) 0%, #2980B9 100%);
  transition: transform 0.3s ease-in-out;
  transform: translateX(0%);
}

.indicator-highlight.vendor {
  transform: translateX(100%);
}

.indicator-labels {
  display: flex;
  justify-content: space-around;
  margin-top: 8px;
}

.indicator-labels span {
  font-size: 14px;
  color: #999;
  transition: color 0.3s ease;
  cursor: pointer;
}

.indicator-labels span:hover {
  color: var(--accent-color);
}

.indicator-labels span.active {
  color: var(--accent-color);
  font-weight: 500;
}
</style>
