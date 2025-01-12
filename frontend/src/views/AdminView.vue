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
        <AdminLogin />
      </div>
    </div>
  </div>
</template>

<script setup>
import AdminLogin from '../component/AdminLogin.vue'
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
</style>
