<template>
  <div>
    <div class="header">
      <el-row
        type="flex"
        class="row-bg row"
        justify="space-between"
        :gutter="0"
      >
        <el-col :span="6" class="head1">
          <div>
            <img
              src="../assets/3.gif"
              alt="Easyrent官网"
              width="100"
              height="60"
            />
          </div>
          <div class="head2">
            <el-dropdown @command="handleCommand">
              <span class="el-dropdown-link city">
                {{ city }}
                <i class="el-icon-arrow-down el-icon--right"></i>
              </span>
              <el-dropdown-menu slot="dropdown">
                <el-dropdown-item command="武汉市">武汉市</el-dropdown-item>
                <el-dropdown-item command="重庆市">重庆市</el-dropdown-item>
                <el-dropdown-item command="成都市">成都市</el-dropdown-item>
                <el-dropdown-item command="北京市">北京市</el-dropdown-item>
                <el-dropdown-item command="上海市">上海市</el-dropdown-item>
              </el-dropdown-menu>
            </el-dropdown>
          </div>
        </el-col>
        <el-col :span="10">
          <ul>
            <li v-for="(item, i) in lis" :key="i" @click="btnli(i)" ref="btnul">
              <a class="cursor">{{ item.name }}</a>
            </li>
          </ul>
        </el-col>
        <el-col :span="8">
          <div class="head3">
            <span class="font">
              <i class="el-icon-phone-outline"></i>023-8888-8888
            </span>
            <el-button
              type="primary"
              @click="requestLogin()"
              v-show="!logintoken"
            >
              <i class="el-icon-user el-icon--left"></i>登录
            </el-button>
          </div>
          <div class="head4" v-show="logintoken">
            <div class="nick">
              <router-link :to="{ path: '/order' }">
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
    </div>

    <!-- 登录弹窗 -->
    <el-dialog
      title="登录界面"
      :visible.sync="loginFormVisible"
      center
      width="450px"
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
  </div>
</template>

<script>
// 引入qs
import qs from "qs";

export default {
  name: "my-Heard",
  data() {
    return {
      token: localStorage.getItem("token"),
      nick: localStorage.getItem("nick"),
      logintoken: false,
      cancelvalue: false,
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
        username: "",
        idnumber: ""
      },
      loginFormVisible: false,
      registerFormVisible: false,
      city: "重庆市",
      lis: [
        { name: "首页", http: "/" },
        { name: "找房", http: "/rentinhome" },
        { name: "出租", http: "/order/home-m" },
        { name: "合租", http: "/" },
        { name: "整租", http: "/" },
        { name: "关于", http: "/" }
      ]
    };
  },
  computed: {
    account: function() {
      return localStorage.getItem("account");
    }
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
  mounted() {
    this.$refs.btnul[1].classList.add("activeLi");
  },
  methods: {
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
        username: this.form.username,
        idnumber: this.form.idnumber,
        cellphone: this.form.cellphone
      };
      console.log(params);
      const res = await this.$axios.post("/register", qs.stringify(params));
      console.log(res);
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
      const res = await this.$axios.post("/login", qs.stringify(params)); // 用qs.stringify()格式化参数
      const { status, data, message } = res.data;
      if (status == 200) {
        this.$message({
          message: message,
          type: "success",
          duration: 1000
        });
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
    // 选城市
    handleCommand(command) {
      this.$message({
        message: "click on item " + command,
        duration: 1000
      });
      this.city = command;
    },
    // 导航栏跳转
    btnli(ev) {
      console.log(this.lis[ev].http);
      this.$router.push(`${this.lis[ev].http}`);
      this.$refs.btnul[ev].classList.add("activeLi");
    }
  }
};
</script>

<style scoped>
.cursor {
  cursor: pointer;
}
.nick a:hover {
  color: #c212b6;
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

.header {
  width: 100%;
  height: 50px;
  display: inline-block;
  /* background: url(../assets/1.gif) no-repeat center center fixed; */
  z-index: 9;
  box-shadow: 0 0 10px 0 #aaa;
  -webkit-box-shadow: 0 0 10px 0 #aaa;
  text-align: center;
}
.row {
  width: 80%;
}
.header ul > li,
.header div {
  display: inline-block;
  color: rgb(92, 89, 89);
}
.header ul > li:hover {
  border-bottom: 2px solid #0d7767;
}
.header ul > li:hover a {
  color: #c212b6;
}
.head1 span {
  display: block;
  color: #fff;
  font-size: 14px;
  cursor: pointer;
}
.head1 {
  text-align: left;
}
.head2 {
  margin: 12px 0 0 20px;
  vertical-align: top;
}
.header ul > li {
  list-style: none;
  margin: 0 20px;
  line-height: 50px;
}
.head3 span:first-child {
  margin: 0 40px;
  line-height: 50px;
  vertical-align: middle;
}
.el-dropdown-link {
  cursor: pointer;
  color: #409eff;
}
.city {
  border-radius: 20px;
  padding: 5px;
  background-color: #999;
  color: #ffffff;
}
.font {
  font-size: 21px;
  height: 32px;
  line-height: 24px;
  font-weight: 600;
  color: #a6adac;
}
.bread {
  margin: 20px 0;
}
.activeLi {
  border-bottom: 2px solid #0d7767;
}
</style>
