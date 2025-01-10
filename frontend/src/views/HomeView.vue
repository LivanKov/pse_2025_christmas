<template>
  <div class="home-container">
    <div class="app-container">
      <div class="snowflake-1"></div>
      <div class="snowflake-2"></div>
      <div class="snowflake-3"></div>
      <div class="login-container">
        <div class="login-box">
          <div class="login-type-indicator">
            <div class="indicator-line">
              <div class="indicator-highlight" :class="{ 'vendor': isVendorLogin }"></div>
            </div>
            <div class="indicator-labels">
              <span :class="{ 'active': !isVendorLogin }">Customer</span>
              <span :class="{ 'active': isVendorLogin }">Vendor</span>
            </div>
          </div>
          <div class="snowflake-icon">❄️</div>
          <h1>Welcome Back</h1>
          
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

          <div class="login-options">
            <div class="forgot-password">
              <a href="#">Forgot your password?</a>
            </div>
            <button @click="toggleLoginType" class="toggle-login-button">
              {{ isVendorLogin ? 'Customer? Click here!' : 'Vendor? Click here!' }}
            </button>
          </div>
        </div>
      </div>
      <div class="ground">
        <div class="snow-hills"></div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'HomeView',
  data() {
    return {
      email: '',
      vendorId: '',
      vendorPassword: '',
      isVendorLogin: false
    }
  },
  methods: {
    async handleLogin() {
      console.log('Customer login attempted with:', this.email)
    },
    async handleVendorLogin() {
      console.log('Vendor login attempted with ID:', this.vendorId, 'and password:', this.vendorPassword)
    },
    toggleLoginType() {
      this.isVendorLogin = !this.isVendorLogin
      // Reset form fields when switching
      this.email = ''
      this.vendorId = ''
      this.vendorPassword = ''
    }
  }
}
</script>

<style scoped>
.app-container {
  min-height: 100vh;
  background: linear-gradient(180deg, 
    #a8e6ff 0%, 
    #ECF0F1 60%, 
    #FFFFFF 60%, 
    #FFFFFF 100%
  );
  position: relative;
  overflow: hidden;
}

.login-container {
  display: flex;
  justify-content: flex-start;
  align-items: center;
  min-height: 100vh;
  padding: 20px;
  padding-left: 15%;
  position: relative;
  z-index: 2;
}

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

.snowflake {
  position: fixed;
  color: #fff;
  font-size: 1.5em;
  text-shadow: 0 0 5px rgba(255, 255, 255, 0.8);
  animation: snowfall linear infinite;
  z-index: 1;
}

@keyframes snowfall {
  0% {
    transform: translateY(-100vh) rotate(0deg);
  }
  100% {
    transform: translateY(100vh) rotate(360deg);
  }
}

.app-container::before,
.app-container::after,
.snowflake-1::before,
.snowflake-2::before,
.snowflake-3::before {
  content: "❄";
  position: fixed;
  top: -20px;
  color: rgba(255, 255, 255, 0.8);
  text-shadow: 0 0 5px rgba(255, 255, 255, 0.5);
  z-index: 1;
}

.app-container::before { left: 20%; animation: snowfall 15s linear infinite; font-size: 30px; }
.app-container::after { left: 40%; animation: snowfall 12s linear infinite; font-size: 25px; }
.snowflake-1::before { left: 60%; animation: snowfall 10s linear infinite; font-size: 35px; }
.snowflake-2::before { left: 80%; animation: snowfall 14s linear infinite; font-size: 28px; }
.snowflake-3::before { left: 90%; animation: snowfall 13s linear infinite; font-size: 32px; }

.ground {
  position: absolute;
  bottom: 0;
  left: 0;
  right: 0;
  height: 40vh;
  background: linear-gradient(180deg, 
    rgba(255, 255, 255, 0.8) 0%,
    #FFFFFF 20%
  );
  z-index: 1;
}

.snow-hills::before,
.snow-hills::after {
  content: "";
  position: absolute;
  bottom: 39vh;
  width: 100%;
  height: 80px;
  background: #FFFFFF;
  border-radius: 50% 50% 0 0;
  z-index: 1;
}

.snow-hills::before {
  left: -50%;
  transform: scale(2);
}

.snow-hills::after {
  right: -50%;
  transform: scale(1.5);
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
  justify-content: space-between;
  margin-top: 8px;
  padding: 0 10px;
}

.indicator-labels span {
  font-size: 14px;
  color: #999;
  transition: color 0.3s ease;
}

.indicator-labels span.active {
  color: var(--accent-color);
  font-weight: 500;
}
</style>
