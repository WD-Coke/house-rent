<template>
  <el-container class="all">
    <!-- nav -->
    <el-header class="headNav">
      <el-row>
        <el-col :span="3">
          <img
            style="width: 59px; height: 59px"
            src="@/assets/6.gif"
            class="logo"
          />
        </el-col>
        <el-col :span="18">
          <div class="headTitle">
            <el-col :span="4">
              <router-link :to="{ name: 'homepage' }">
                <span>首页</span>
              </router-link>
            </el-col>
            <el-col :span="4">
              <router-link :to="{ name: 'rentinhome' }">
                <span>我要租房</span>
              </router-link>
            </el-col>
            <el-col :span="4">
              <a @click="chuzhu()" class="cursor">
                <span>我要出租</span>
              </a>
            </el-col>
            <el-col :span="4">
              <a @click="dingdan()" class="cursor">
                <span>订单管理</span>
              </a>
            </el-col>
            <el-col :span="6">
              <el-input
                placeholder="搜城市，搜小区，搜公寓"
                v-model="input1"
                class="input-with-select"
              >
                <el-button slot="append" icon="el-icon-search"></el-button>
              </el-input>
            </el-col>
          </div>
        </el-col>
        <el-col :span="3" class="headTitle">
          <span @click="requestLogin()" v-show="!logintoken">{{ login }}</span>
          <!-- 增加首页的登录 -->
          <div class="head4" v-show="logintoken">
            <div class="nick">
              <router-link :to="{ path: 'order' }">
                <i class="el-icon-s-custom"></i>
                <span>{{ nick }}</span>
              </router-link>
            </div>
            <div class="cancel">
              <el-button type="info" size="mini" plain @click="cancel"
                >注销</el-button
              >
            </div>
          </div>
        </el-col>
      </el-row>
    </el-header>
    <el-carousel
      :interval="3000"
      type="card"
      height="300px"
      indicator-position="outside"
      @change="imgChange()"
      class="middle1"
    >
      <el-carousel-item
        v-for="(item, index) in imgs"
        :key="index"
        :name="'' + index"
        ref="zmd"
        class="middle2"
      >
        <img
          class="medium"
          style="width: 100%; height: 100%"
          :src="item.mainpic"
          :alt="index"
          @click="jump(item.houseid)"
        />
      </el-carousel-item>
    </el-carousel>
    <div class="footImg">
      <el-divider> <i class="el-icon-office-building"></i>房间详情 </el-divider>
      <div v-if="imgs.length > 1">
        <img :src="imgs[num].pic1" alt="2333" />
        <img :src="imgs[num].pic2" alt="2333" />
        <img :src="imgs[num].pic3" alt="2333" />
      </div>
    </div>

    <!-- 登录弹窗 -->
    <el-dialog
      title="登录界面"
      :visible.sync="loginFormVisible"
      center
      width="450px"
      :append-to-body="true"
    >
      <el-form :model="form" :rules="rules" label-width="80px">
        <el-form-item label="账号/手机号" prop="input1">
          <el-input
            placeholder="请输入账号/手机号"
            v-model="form.input1"
            clearable
          ></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="input2">
          <el-input
            placeholder="请输入密码"
            v-model="form.input2"
            show-password
          ></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button
          @click="(loginFormVisible = false), (registerFormVisible = true)"
          >注册</el-button
        >
        <el-button type="primary" @click="loginConfirm()">确 定</el-button>
      </div>
    </el-dialog>
    <!-- 注册弹窗 -->
    <el-dialog
      title="注册界面"
      :visible.sync="registerFormVisible"
      center
      width="450px"
      :append-to-body="true"
    >
      <el-form
        :model="form"
        :rules="rules"
        label-position="left"
        label-width="80px"
      >
        <el-form-item label="昵称" prop="nick">
          <el-input
            placeholder="请输入昵称"
            v-model="form.nick"
            clearable
          ></el-input>
        </el-form-item>
        <el-form-item label="电话号码" prop="cellphone">
          <el-input
            placeholder="请输入电话号码"
            v-model="form.cellphone"
            clearable
          ></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="input3">
          <el-input
            placeholder="请输入密码"
            v-model="form.input3"
            show-password
          ></el-input>
        </el-form-item>
        <el-form-item label="确认密码" prop="input4">
          <el-input
            placeholder="请输入密码"
            v-model="form.input4"
            show-password
          ></el-input>
        </el-form-item>
        <el-form-item label="性别" prop="gender">
          <el-radio-group v-model="form.gender">
            <el-radio label="男"></el-radio>
            <el-radio label="女"></el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="姓名" prop="username">
          <el-input
            placeholder="请输入姓名"
            v-model="form.username"
            clearable
          ></el-input>
        </el-form-item>
        <el-form-item label="身份证号" prop="idnumber">
          <el-input
            placeholder="请输入身份证号"
            v-model="form.idnumber"
            clearable
          ></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="registerFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="registerConfirm()">确 定</el-button>
      </div>
    </el-dialog>
  </el-container>
</template>

<script>
// 引入qs
import qs from "qs";
var _this;
export default {
  data() {
    return {
      token: localStorage.getItem("token"),
      nick: localStorage.getItem("nick"),
      logintoken: false,
      cancelvalue: false,
      num: 0,
      login: "请登录",
      input1: "",
      imgs: [],
      rules: {
        input1: [
          { required: true, message: "请输入账号", trigger: "blur" },
          { min: 7, max: 10, message: "长度在 7 到 10 个字符", trigger: "blur" }
        ],
        input2: [{ required: true, message: "请输入密码", trigger: "blur" }],
        input3: [{ required: true, message: "请输入密码", trigger: "blur" }],
        input4: [{ required: true, message: "请输入密码", trigger: "blur" }],
        nick: [{ required: true, message: "请输入昵称", trigger: "blur" }],
        cellphone: [
          { required: true, message: "请输入账号", trigger: "blur" },
          {
            type: "number",
            message: "电话号码应该是数字",
            trigger: "change"
          },
          {
            min: 11,
            max: 11,
            message: "长度应为11个字符",
            trigger: "blur"
          }
        ],
        username: [{ required: true, message: "请输入昵称", trigger: "blur" }],
        gender: [
          { required: true, message: "请选择活动资源", trigger: "blur" }
        ],
        idnumber: [
          {
            required: true,
            message: "未响应国家政策，请进行实名认证",
            trigger: "blur"
          },
          {
            type: "number",
            message: "身份证应该是数字",
            trigger: "blur"
          },
          {
            min: 18,
            max: 18,
            message: "长度应为18个字符",
            trigger: "blur"
          }
        ]
      },
      form: {
        input1: "",
        input2: "",
        input3: "",
        input4: "",
        nick: "",
        cellphone: "",
        gender: "",
        idnumber: ""
      },
      loginFormVisible: false,
      registerFormVisible: false
    };
  },
  created() {
    _this = this;
    this.getimg(); // 数据请求
  },
  watch: {
    token: {
      handler() {
        if (!this.token) {
          this.logintoken = false;
        } else {
          this.logintoken = true;
        }
        return this.token;
      },
      deep: true,
      immediate: true
    }
  },
  computed: {
    account: function() {
      return localStorage.getItem("account");
    }
  },
  methods: {
    // 订单
    dingdan() {
      if (!this.token) {
        this.$message({
          message: "请先登录",
          type: "warning",
          duration: 1000
        });
        setTimeout(function() {
          _this.loginFormVisible = true;
        }, 1000);
      } else {
        this.$router.push({ name: "order" });
      }
    },
    // 出租
    chuzhu() {
      console.log(this.token);
      if (!this.token) {
        this.$message({
          message: "请先登录",
          type: "warning",
          duration: 1000
        });
        setTimeout(function() {
          _this.loginFormVisible = true;
        }, 1000);
      } else {
        this.$router.push({ path: "/order/home-m" });
      }
    },
    // 注销
    cancel() {
      localStorage.clear();
      this.logintoken = false;
    },
    // 注册
    async registerConfirm() {
      this.registerFormVisible = false;
      let params = {
        nick: this.form.nick,
        password: this.form.input3,
        gender: this.form.gender,
        idnumber: this.form.idnumber,
        cellphone: this.form.cellphone
      };
      const res = await this.$axios.post("/register", qs.stringify(params));

      const { status, account, message } = res.data;
      if (status == 201) {
        this.$alert(account, "你的id账号", {
          confirmButtonText: "确定",
          callback: () => {
            this.$message({
              type: "success",
              message: message,
              duration: 1000
            });
          },
          center: true
        });
      }
    },
    // 登录
    async loginConfirm() {
      this.loginFormVisible = false;
      console.log(this.form.input1);
      let params = {
        account: this.form.input1,
        password: this.form.input2
      };
      console.log(params);
      const res = await this.$axios.post("/login", qs.stringify(params)); // 用qs.stringify()格式化参数
      console.log(res);
      const { status, data, message } = res.data;
      if (status == 200) {
        this.$message({
          message: message,
          type: "success",
          duration: 1000
        });
        console.log(data);
        localStorage.setItem("nick", data.nick); // 给token赋值
        localStorage.setItem("account", data.account); // 给token赋值
        this.nick = localStorage.getItem("nick"); // 给this.nick更新
        const token = res.data.token;
        localStorage.setItem("token", token); // 给token赋值
        this.logintoken = true;
      } else {
        this.$message({
          message: message,
          type: "error",
          duration: 1000
        });
      }
    },
    // 点击登录
    requestLogin() {
      this.loginFormVisible = true;
      this.form = {};
    },

    imgChange() {
      let arr = this.$refs.zmd;
      for (let i = 0; i < arr.length; i++) {
        if (arr[i].active === true) {
          this.num = i;
        }
      }
    },
    async getimg() {
      const res = await this.$axios.get("/content");
      console.log(2);
      const { status, data, message } = res.data;
      console.log(data);
      console.log(status);
      if (status == 200) {
        this.$message({
          message: `欢迎光临`,
          type: "success",
          duration: 1000
        });
        this.imgs = data;
        console.log(this.imgs);
      } else {
        this.$message({
          message: `抱歉，${message}`,
          type: "error",
          duration: 1000
        });
      }
    },

    // 图片跳转
    jump(ev) {
      console.log(ev);
      this.$router.push(`/house/${ev}`);
    }
  }
};
</script>

<style scoped>
.cursor {
  cursor: pointer;
}
.head4 .nick:hover span,
.head4 .nick:hover i {
  color: rgb(238, 82, 82);
  font-size: 18px;
}
.head4 span {
  font-size: 16px;
}
.cancel {
  margin-left: 20px;
}
.head4 {
  position: relative;
  line-height: 50px;
}
.head4 div {
  display: inline-block;
  line-height: 59px;
}
.all {
  text-align: center;
  opacity: 0.9;
  filter: alpha(opacity=90);
  height: auto;
  background: url(../assets/2.jpg) no-repeat center 0;
  background-size: 100% 100%;
}
.headTitle > div:last-of-type:hover {
  border: 0;
}
.headTitle span {
  color: rgb(27, 23, 23);
  font-weight: 500;
}
.headTitle span:hover {
  color: #d9dde9;
  font-size: 18px;
}
.headTitle > div:hover {
  border-bottom: 2px solid #7a85ec;
}
.headTitle {
  line-height: 59px;
}
.headNav {
  height: 60px;
  border-bottom: solid 1px #e6e6e6;
}
.footImg {
  position: relative;
  bottom: 20px;
  height: 300px;
}
.footImg img {
  width: 28%;
  height: 200px;
  margin: 20px;
  border-radius: 4px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12);
}
.logo {
  float: left;
}
body {
  text-align: center;
  margin: 0;
  background-repeat: no-repeat;
  background-attachment: fixed;
}
.middle1 {
  width: 80%;
  margin: 30px auto;
}
.middle2 {
  border-radius: 4px;
}
</style>
