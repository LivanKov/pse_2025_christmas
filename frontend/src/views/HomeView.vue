<template>
  <div class="home-container">
    <div class="app-container">
      <div class="snowflake-1"></div>
      <div class="snowflake-2"></div>
      <div class="snowflake-3"></div>
      <div class="login-container">
        <div class="login-box">
          <div class="snowflake-icon">❄️</div>
          <h1>Welcome Back</h1>
          <form @submit.prevent="handleLogin" class="login-form">
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
                type="password" 
                v-model="password" 
                placeholder="Password"
                required
              />
            </div>
            <button type="submit" class="login-button">
              Sign In
            </button>
          </form>
          <div class="forgot-password">
            <a href="#">Forgot your password?</a>
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
      password: ''
    }
  },
  methods: {
    async handleLogin() {
      // TODO: Implement login logic
      console.log('Login attempted with:', this.email)
    }
  }
}
</script>

<style scoped>
/* Copy the styles from App.vue */
.app-container {
  position: relative;
  min-height: 100vh;
  background: linear-gradient(135deg, #1e90ff 0%, #4169e1 100%);
  overflow: hidden;
}

.login-container {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  padding: 20px;
}

.login-box {
  background: rgba(255, 255, 255, 0.9);
  padding: 40px;
  border-radius: 20px;
  box-shadow: 0 8px 32px rgba(0, 0, 0, 0.1);
  text-align: center;
  position: relative;
  z-index: 1;
  backdrop-filter: blur(10px);
  max-width: 400px;
  width: 100%;
}

.snowflake-icon {
  font-size: 48px;
  margin-bottom: 20px;
}

.login-form {
  margin-top: 30px;
}

.form-group {
  margin-bottom: 20px;
}

input {
  width: 100%;
  padding: 12px;
  border: 2px solid #e1e1e1;
  border-radius: 8px;
  font-size: 16px;
  transition: border-color 0.3s;
}

input:focus {
  border-color: #4169e1;
  outline: none;
}

.login-button {
  width: 100%;
  padding: 12px;
  background: #4169e1;
  color: white;
  border: none;
  border-radius: 8px;
  font-size: 16px;
  cursor: pointer;
  transition: background 0.3s;
}

.login-button:hover {
  background: #1e90ff;
}

.forgot-password {
  margin-top: 20px;
}

.forgot-password a {
  color: #4169e1;
  text-decoration: none;
}

.forgot-password a:hover {
  text-decoration: underline;
}

/* Snowflakes */
@keyframes snowfall {
  0% { transform: translateY(-100vh) rotate(0deg); }
  100% { transform: translateY(100vh) rotate(360deg); }
}

.snowflake-1,
.snowflake-2,
.snowflake-3 {
  position: absolute;
  width: 10px;
  height: 10px;
  background: rgba(255, 255, 255, 0.8);
  border-radius: 50%;
}

.snowflake-1 {
  left: 20%;
  animation: snowfall 15s linear infinite;
}

.snowflake-2 {
  left: 50%;
  animation: snowfall 12s linear infinite;
  animation-delay: -5s;
}

.snowflake-3 {
  left: 80%;
  animation: snowfall 10s linear infinite;
  animation-delay: -2s;
}

/* Ground with snow hills */
.ground {
  position: absolute;
  bottom: 0;
  width: 100%;
  height: 100px;
}

.snow-hills {
  position: absolute;
  bottom: 0;
  width: 100%;
  height: 60px;
  background: white;
  border-radius: 100% 100% 0 0;
}

h1 {
  color: #333;
  margin-bottom: 20px;
}
</style>
