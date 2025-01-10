<template>
  <div class="admin-container">
    <div class="admin-content">
      <div class="login-side">
        <h1>Welcome back.</h1>
        <p class="location">
          <span class="snowflake">❄</span> North Pole, Santa's Workshop
        </p>
      </div>
      <div class="login-form-container">
        <div class="login-box">
          <h2>Admin Dashboard</h2>
          <p class="description">Access the administrative controls for the Christmas gift management system.</p>
          
          <form @submit.prevent="handleAdminLogin" class="login-form">
            <div class="form-group">
              <label>Email address</label>
              <input 
                type="email" 
                v-model="email" 
                placeholder="admin@northpole.com"
                required
              />
            </div>
            <div class="form-group">
              <label>Password</label>
              <input 
                type="password" 
                v-model="password" 
                placeholder="Enter your password"
                required
              />
            </div>
            <div class="form-footer">
              <a href="#" class="forgot-password">Forgot your password?</a>
              <button type="submit" class="login-button">Log in</button>
            </div>
          </form>

          <div class="terms">
            <small>
              This site is protected by Christmas Magic. 
              <a href="#">Terms of Service</a> and 
              <a href="#">Privacy Policy</a> apply.
            </small>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'AdminView',
  data() {
    return {
      email: '',
      password: ''
    }
  },
  methods: {
    async handleAdminLogin() {
      // TODO: Implement actual admin login
      console.log('Admin login attempted with:', this.email)
    }
  }
}
</script>

<style scoped>
.admin-container {
  min-height: 100vh;
  background: linear-gradient(135deg, 
    #1a2a3a 0%,
    #2c3e50 100%
  );
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 2rem;
}

.admin-content {
  display: flex;
  background: rgba(255, 255, 255, 0.05);
  border-radius: 20px;
  overflow: hidden;
  width: 100%;
  max-width: 1200px;
  min-height: 600px;
  box-shadow: 0 8px 32px rgba(0, 0, 0, 0.2);
  backdrop-filter: blur(10px);
}

.login-side {
  flex: 1;
  padding: 4rem;
  background: linear-gradient(rgba(0, 0, 0, 0.3), rgba(0, 0, 0, 0.3)),
              url('https://images.unsplash.com/photo-1543589077-47d81606c1bf') center/cover;
  color: white;
  display: flex;
  flex-direction: column;
  justify-content: flex-end;
}

.login-side h1 {
  font-size: 3.5rem;
  margin-bottom: 1rem;
  font-weight: 600;
}

.location {
  font-size: 1rem;
  opacity: 0.9;
  display: flex;
  align-items: center;
  gap: 0.5rem;
}

.snowflake {
  animation: float 3s ease-in-out infinite;
}

.login-form-container {
  flex: 1;
  padding: 4rem;
  background: white;
  display: flex;
  align-items: center;
}

.login-box {
  width: 100%;
  max-width: 400px;
  margin: 0 auto;
}

h2 {
  color: #1a2a3a;
  font-size: 1.8rem;
  margin-bottom: 1rem;
  font-weight: 600;
}

.description {
  color: #666;
  margin-bottom: 2rem;
}

.form-group {
  margin-bottom: 1.5rem;
}

label {
  display: block;
  margin-bottom: 0.5rem;
  color: #1a2a3a;
  font-weight: 500;
}

input {
  width: 100%;
  padding: 0.8rem 1rem;
  border: 2px solid #e1e1e1;
  border-radius: 8px;
  font-size: 1rem;
  transition: all 0.3s ease;
}

input:focus {
  outline: none;
  border-color: #3498db;
  box-shadow: 0 0 0 3px rgba(52, 152, 219, 0.1);
}

.form-footer {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-top: 2rem;
}

.forgot-password {
  color: #3498db;
  text-decoration: none;
  font-size: 0.9rem;
}

.login-button {
  background: #3498db;
  color: white;
  border: none;
  padding: 0.8rem 2rem;
  border-radius: 8px;
  font-weight: 600;
  cursor: pointer;
  transition: all 0.3s ease;
}

.login-button:hover {
  background: #2980b9;
  transform: translateY(-1px);
}

.terms {
  margin-top: 2rem;
  text-align: center;
  color: #666;
}

.terms a {
  color: #3498db;
  text-decoration: none;
}

@keyframes float {
  0%, 100% {
    transform: translateY(0);
  }
  50% {
    transform: translateY(-10px);
  }
}

@media (max-width: 768px) {
  .admin-content {
    flex-direction: column;
  }
  
  .login-side {
    padding: 2rem;
    min-height: 200px;
  }
  
  .login-form-container {
    padding: 2rem;
  }
}
</style>
