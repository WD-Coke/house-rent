<template>
  <div class="footer">
    <div class="website-help">
      <div class="wibsite-center">
        <div class="website-f-list">
          <span>用户帮助</span>
          <p><a href="#">入住指南</a></p>
          <p><a href="#">生活常识</a></p>
          <p><a href="#">租房问题</a></p>
        </div>
        <div class="website-f-list">
          <span>商务合作</span>
          <p><a href="#">商务合作</a></p>
        </div>
        <div class="website-f-list">
          <span>公司信息</span>
          <p><a href="#">关于Easyrent</a></p>
          <p><a href="#">联系Easyrent</a></p>
          <p><a href="#">加入Easyrent</a></p>
        </div>
        <div class="website-f-list">
          <span>客服热线</span>
          <p>4001-551-551</p>
        </div>
        <div class="website-f-right">
          <div class="weChat">
            <img src="../../assets/img/weixin.svg" />
            <img src="../../assets/img/erweima.svg" />
          </div>
          <div class="team">
            <span>研发团队: 可口可乐</span>
            <p>成员:任俊燊 余骏 朱飞 王乙博 杜虹铮 禹毅杰</p>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Bottom-content"
};
</script>

<style scoped>
.footer {
  overflow: hidden;
  margin-top: 40px;
  background: #212121;
  padding: 0 0 20px;
  z-index: 1;
}
.website-help .wibsite-center {
  width: 80%;
}
.wibsite-center {
  margin: 0 auto;
}
.website-f-list:first-child {
  padding-left: 0;
}
.website-f-list {
  float: left;
  padding: 40px 0 0 60px;
}
.website-f-list span {
  display: block;
  color: #aeaeae;
  padding: 0 0 45px;
  font-size: 20px;
}
.website-f-list p {
  display: block;
  text-align: left;
  color: #fff;
  font-size: 22px;
  white-space: nowrap;
  font-weight: 700;
}
.website-f-list p a {
  color: #e6e6e6;
  font-size: 16px;
}
.website-f-right {
  float: right;
  padding-right: 7px;
  width: 40%;
  height: 245px;
}
.weChat {
  padding-top: 40px;
}
.weChat img {
  width: 20%;
  height: 20%;
  padding: 0 0 30px 100px;
}
.team span {
  display: block;
  color: #aeaeae;
  padding: 0 0 25px 100px;
  font-size: 20px;
}
.team p {
  font-size: 18px;
  padding-left: 100px;
  color: #aeaeae;
}
.wibsite-center::before {
  content: " ";
  display: block;
  height: 8px;
  width: 100%;
  background: url(https://public.danke.com.cn/public-20180702-FjoS5QxpvjwOIz0RWWIE_saYDySJ)
    center repeat-x;
}
.crumbs-list a {
  display: inline-block;
  font-size: 12px;
  margin-right: 12px;
  margin-top: 10px;
}
</style>
