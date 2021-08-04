// 插件模块

import axios from "axios";

const MyHttpServer = {};

MyHttpServer.install = Vue => {
  axios.defaults.baseURL = "http://47.115.31.127/rent/"; // 基础地址

  axios.defaults.headers.post["Content-Type"] =
    "application/x-www-form-urlencoded";

  // // 添加请求拦截器
  // axios.interceptors.request.use(function (config) {
  //   // 在发送请求之前做些什么
  //   // config 请求头的信息
  //     console.log('拦截器触发')
  //     console.log(config.url)
  //     if (config.url !== '/content'||config.url !== 'rentinhome') {

  //       const AUTH_TOKEN = localStorage.getItem('token')
  //       config.headers['Authorization'] = AUTH_TOKEN // 给headers添加一个属性
  //     }
  //     console.log(config)
  //     return config
  //   }, function (error) {
  //   // 对请求错误做些什么
  //     return Promise.reject(error)
  //   })

  Vue.prototype.$axios = axios;
};

export default MyHttpServer;
