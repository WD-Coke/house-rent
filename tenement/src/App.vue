<template>
  <div id="app" :style="{ width: maxWidth }">
    <router-view />
  </div>
</template>

<script>
export default {
  data() {
    return {};
  },
  computed: {
    maxWidth: function() {
      //屏幕可视区域的高度
      let clientWidth = document.documentElement.clientWidth + "px";
      // 窗口可视区域发生变化的时候执行
      window.onresize = () => {
        clientWidth = document.documentElement.clientWidth + "px";
        return clientWidth;
      };
      return clientWidth;
    }
  }
};
</script>

<style lang="scss">
html {
  overflow-x: hidden;
  overflow-y: auto;
}
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  // width: 1520px;
}
</style>
