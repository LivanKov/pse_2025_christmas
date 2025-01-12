<template>
  <div class="home-container">
    <div class="app-container">
      <div class="snowflake-1"></div>
      <div class="snowflake-2"></div>
      <div class="snowflake-3"></div>
      <div class="login-container">
        <VendorLogin />
      </div>
      <div class="ground">
        <div class="snow-hills"></div>
      </div>
    </div>
  </div>
</template>

<script setup>
import VendorLogin from '../component/VendorLogin.vue'
</script>

<style scoped>
.app-container {
  min-height: 100vh;
  background: linear-gradient(180deg, 
    #62b0cf 0%, 
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
