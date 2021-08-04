<template>
  <div id="app" class="order">
    <my-Heard></my-Heard>
    <div class="pageN">
      <div class="nav"><a href="#">首页</a>>订单管理</div>
      <div class="content">
        <div id="placeholder"></div>
        <LeftBar></LeftBar>
        <div class="right-content">
          <router-view />
        </div>
      </div>
    </div>
    <Bottom-content></Bottom-content>
  </div>
</template>

<style>
body {
  margin: 0;
  padding: 0;
  /*background-color: #e6e6e6;*/
}
a {
  text-decoration: none;
  color: #999999;
}
ul {
  margin-bottom: 0;
  margin-top: 0;
}
li {
  list-style: none;
}
.order {
}
.pageN {
  background-color: rgba(243, 243, 243, 0.2);
}
.nav {
  width: 80%;
  line-height: 50px;
  margin: auto;
  color: #999999;
}
.nav a {
  color: #999999;
}
.content {
  width: 80%;
  height: 1100px;
  margin: auto;
  display: flex;
}
.right-content {
  height: 90%;
  background-color: rgba(253, 253, 253, 0.4);
  flex: 1;
  margin-left: 5%;
  padding: 30px 0 30px 30px;
}
#placeholder {
  width: 15%;
  height: 90%;
}
.order {
  background: url("../assets/img/312.png") center center fixed;
  min-height: 1400px;
}
</style>
