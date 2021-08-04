import Vue from "vue";
import VueRouter from "vue-router";
import HomePage from "../views/HomePage.vue";
import RentInHome from "../views/RentInHome.vue";
import Order from "../views/Order.vue";
import House from "../views/house.vue";

import Home from "../views/home/Home.vue";
import HomeM from "../views/home-m/Home-m.vue";
import HomeO from "../views/home-order/Home-order.vue";
import HomeA from "../views/home-application/home-application.vue";
import HomeC from "../views/cancel-order/cancel-order.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "homepage",
    component: HomePage
  },
  {
    path: "/rentinhome",
    name: "rentinhome",
    component: RentInHome
  },
  {
    path: "/order",
    name: "order",
    component: Order,
    redirect: "/order/home",
    children: [
      {
        path: "",
        redirect: "/order/home"
      },
      {
        path: "home",
        component: Home
      },
      {
        path: "home-m",
        component: HomeM
      },
      {
        path: "home-order",
        component: HomeO
      },
      {
        path: "home-application",
        component: HomeA
      },
      {
        path: "cancel-order",
        component: HomeC
      }
    ]
  },
  {
    name: "house",
    path: "/house/:name",
    component: House
  }
];

const router = new VueRouter({
  mode: "hash",
  routes
});

// router.beforeEach((to, from, next) => {
//   console.log(to, from)
//   // 如果要去的是登录
//   if (to.path === '/' || to.path === '/rentinhome') {
//     next()
//   } else {
//     const token = localStorage.getItem('token')
//     if (!token) {
//       this.$message.warning('请先登录')   // 这个Message也是单独应用的
//       router.push({   // 这里没有this.$router 所以直接使用router
//         name: 'homepage'
//       })
//       return
//     }
//     next()
//   }
// })

export default router;
