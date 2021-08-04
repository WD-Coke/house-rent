import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import ElementUI from "element-ui";
import "element-ui/lib/theme-chalk/index.css";
import "./styles.scss";

import moment from "moment";

// 导入全局样式
import "@/assets/css/reset.css";
// 引入axios
import MyHttpServer from "./plugins/axios";

// 全局过滤器 - 处理日期
Vue.filter("fmtdata", v => {
  return moment(v).format("YYYY-MM-DD");
});

// 导入自定义组件
import MyHeard from "@/components/myHeard.vue";
import LeftBar from "@/components/left-bar/LeftBar";
import BottomContent from "@/components/bottom-content/Bottom-content";
Vue.component(MyHeard.name, MyHeard);
Vue.component(LeftBar.name, LeftBar);
Vue.component(BottomContent.name, BottomContent);

Vue.use(ElementUI);
Vue.use(MyHttpServer);

Vue.config.productionTip = false;

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount("#app");
