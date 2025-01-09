<template>
  <router-view></router-view>
</template>

<script>
export default {
  name: 'App'
}
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
</style>