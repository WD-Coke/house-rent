<template>
  <div class="left-bar">
    <div id="aa">
      <ul>
        <h3>用户服务</h3>
        <router-link to="/order/home"
          ><li :class="{ active: 1 === index }" @click="addActive(1)">
            租房订单
          </li></router-link
        >
      </ul>
    </div>
    <div id="bb">
      <ul>
        <h3>房东服务</h3>
        <router-link to="/order/home-m"
          ><li :class="{ active: 2 === index }" @click="addActive(2)">
            房间管理
          </li></router-link
        >
        <router-link to="/order/home-order"
          ><li :class="{ active: 3 === index }" @click="addActive(3)">
            全部订单
          </li></router-link
        >
        <router-link to="/order/home-application"
          ><li :class="{ active: 4 === index }" @click="addActive(4)">
            入住申请
          </li></router-link
        >
        <router-link to="/order/cancel-order"
          ><li :class="{ active: 5 === index }" @click="addActive(5)">
            退订申请
          </li></router-link
        >
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  name: "LeftBar",
  data() {
    return {
      index: 1
    };
  },
  methods: {
    addActive(span) {
      this.index = span;
    }
  }
};
</script>

<style scoped>
.left-bar {
  width: 12%;
  height: 40%;
  background-color: rgba(253, 253, 253, 0.2);
  padding: 30px 0 30px 50px;
  box-shadow: 2px 2px 2px rgba(158, 158, 158, 0.2);
  position: fixed;
}
.left-bar h3 {
  margin-bottom: 0;
}
.left-bar li {
  margin-top: 15px;
  font-size: 14px;
}
a:hover {
  color: #409eff;
}
#aa {
  position: relative;
}
#bb,
#aa {
  margin-top: 15px;
}
.active {
  border-right: 3px solid #409eff;
  color: #409eff;
}
</style>
