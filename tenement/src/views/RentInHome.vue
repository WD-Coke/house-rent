<template>
  <div class="bcimg">
    <my-Heard></my-Heard>
    <div class="all">
      <div class="bread">
        <el-breadcrumb separator-class="el-icon-arrow-right">
          <el-breadcrumb-item :to="{ path: '/' }">Easyrent</el-breadcrumb-item>
          <el-breadcrumb-item>租房信息</el-breadcrumb-item>
        </el-breadcrumb>
      </div>
      <div class="search">
        <div class="searMenu">
          <input
            placeholder="请输入区域、地铁、小区名"
            v-model="input"
            class="input"
          />
          <button class="searchBtn" @click="search">
            <i class="el-icon-search"></i>搜索
          </button>
          <p class="seartitle">
            <span>您的选择：</span>
            <el-tag
              ref="seartitle"
              v-for="(item, index) in titleArr"
              :key="index"
              closable
              @close="handleClose(index)"
              >{{ item }}</el-tag
            >
          </p>
        </div>
        <div class="searchdd" ref="budong">
          <dl class="dl">
            <dt>位置：</dt>
            <dd>
              <div class="dldiv" ref="btnDiv">
                <a
                  v-for="(item, i) in dds[0]"
                  :key="i"
                  :class="{ onlist: i == dianfo.row0 }"
                  @click="btnA(i, item.rownum)"
                  >{{ item.name }}</a
                >
              </div>
            </dd>
          </dl>
          <dl class="dl">
            <dt>价格：</dt>
            <dd>
              <div class="dldiv" ref="btnDiv">
                <a
                  v-for="(item, i) in dds[1]"
                  :key="i"
                  :class="{ onlist: i == dianfo.row1 }"
                  @click="btnA(i, item.rownum)"
                  >{{ item.name }}</a
                >
              </div>
            </dd>
          </dl>
          <dl class="dl">
            <dt>居室：</dt>
            <dd>
              <div class="dldiv" ref="btnDiv">
                <a
                  v-for="(item, i) in dds[2]"
                  :key="i"
                  :class="{ onlist: i == dianfo.row2 }"
                  @click="btnA(i, item.rownum)"
                  >{{ item.name }}</a
                >
              </div>
            </dd>
          </dl>
          <dl class="dl">
            <dt>类型：</dt>
            <dd>
              <div class="dldiv" ref="btnDiv">
                <a
                  v-for="(item, i) in dds[3]"
                  :key="i"
                  :class="{ onlist: i == dianfo.row3 }"
                  @click="btnA(i, item.rownum)"
                  >{{ item.name }}</a
                >
              </div>
            </dd>
          </dl>
        </div>
      </div>
      <div class="roomlist">
        <div>
          <el-tabs v-model="activeName" type="card" @tab-click="handleClick">
            <el-tab-pane label="默认排序" name="first">
              <div>
                <div
                  class="roomcard"
                  v-for="(item, index) in roomdata"
                  :key="index"
                >
                  <el-row :gutter="20">
                    <el-col
                      :span="9"
                      @click.native="roomload(item)"
                      class="roomImg"
                    >
                      <img
                        :src="item.housemainpic"
                        alt="123"
                        width="400px"
                        height="210px"
                      />
                    </el-col>
                    <el-col :span="10" class="roomfont">
                      <p @click="roomload(item)">
                        <i class="el-icon-school"></i>
                        {{ item.housename }}
                      </p>
                      <p>
                        <i class="el-icon-location-outline"></i>
                        {{ item.houseaddress }}
                      </p>
                      <p>
                        <span>房间ID：{{ item.houseid }}</span
                        >|
                        <i class="el-icon-crop"></i>
                        <span>房间面积约{{ item.housearea }}</span>
                      </p>
                      <p>
                        房间描述：
                        <i class="el-icon-chat-line-round"></i>
                        {{ item.housedescribe }}
                      </p>
                    </el-col>
                    <el-col :span="5" class="roomright">
                      <p>
                        <span>{{ item.houserent }}</span>
                        <span>元/天</span>
                      </p>
                      <el-button
                        type="info"
                        plain
                        class="roombtn"
                        @click="roomload(item)"
                        >查看详情</el-button
                      >
                    </el-col>
                  </el-row>
                </div>
                <div class="pageFooter">
                  <el-pagination
                    background
                    @current-change="handleCurrentChange"
                    :current-page="currentPage"
                    :page-size="5"
                    layout="total, prev, pager, next, jumper"
                    :total="allpages"
                  ></el-pagination>
                </div>
              </div>
            </el-tab-pane>
            <el-tab-pane label="价格" name="second">
              <div>
                <div
                  class="roomcard"
                  v-for="(item, index) in roomdata"
                  :key="index"
                >
                  <el-row :gutter="20">
                    <el-col
                      :span="9"
                      @click.native="roomload(item)"
                      class="roomImg"
                    >
                      <img
                        :src="item.housemainpic"
                        alt="123"
                        width="400px"
                        height="210px"
                      />
                    </el-col>
                    <el-col :span="10" class="roomfont">
                      <p @click="roomload(item)">
                        <i class="el-icon-school"></i>
                        {{ item.housename }}
                      </p>
                      <p>
                        <i class="el-icon-location-outline"></i>
                        {{ item.houseaddress }}
                      </p>
                      <p>
                        <span>房间ID：{{ item.houseid }}</span
                        >|
                        <i class="el-icon-crop"></i>
                        <span>房间面积约{{ item.housearea }}</span>
                      </p>
                      <p>
                        房间描述：
                        <i class="el-icon-chat-line-round"></i>
                        {{ item.housedescribe }}
                      </p>
                    </el-col>
                    <el-col :span="5" class="roomright">
                      <p>
                        <span>{{ item.houserent }}</span>
                        <span>元/天</span>
                      </p>
                      <el-button
                        type="info"
                        plain
                        class="roombtn"
                        @click="roomload(item)"
                        >查看详情</el-button
                      >
                    </el-col>
                  </el-row>
                </div>
                <div class="pageFooter">
                  <el-pagination
                    background
                    @current-change="handleCurrentChangePrise"
                    :current-page="currentPage"
                    :page-size="5"
                    layout="total, prev, pager, next, jumper"
                    :total="allpages"
                  ></el-pagination>
                </div>
              </div>
            </el-tab-pane>
            <el-tab-pane label="面积" name="third">
              <div>
                <div
                  class="roomcard"
                  v-for="(item, index) in roomdata"
                  :key="index"
                >
                  <el-row :gutter="20">
                    <el-col
                      :span="9"
                      @click.native="roomload(item)"
                      class="roomImg"
                    >
                      <img
                        :src="item.housemainpic"
                        alt="123"
                        width="400px"
                        height="210px"
                      />
                    </el-col>
                    <el-col :span="10" class="roomfont">
                      <p @click="roomload(item)">
                        <i class="el-icon-school"></i>
                        {{ item.housename }}
                      </p>
                      <p>
                        <i class="el-icon-location-outline"></i>
                        {{ item.houseaddress }}
                      </p>
                      <p>
                        <span>房间ID：{{ item.houseid }}</span
                        >|
                        <i class="el-icon-crop"></i>
                        <span>房间面积约{{ item.housearea }}</span>
                      </p>
                      <p>
                        房间描述：
                        <i class="el-icon-chat-line-round"></i>
                        {{ item.housedescribe }}
                      </p>
                    </el-col>
                    <el-col :span="5" class="roomright">
                      <p>
                        <span>{{ item.houserent }}</span>
                        <span>元/天</span>
                      </p>
                      <el-button
                        type="info"
                        plain
                        class="roombtn"
                        @click="roomload(item)"
                        >查看详情</el-button
                      >
                    </el-col>
                  </el-row>
                </div>
                <div class="pageFooter">
                  <el-pagination
                    background
                    @current-change="handleCurrentChangeArea"
                    :current-page="currentPage"
                    :page-size="5"
                    layout="total, prev, pager, next, jumper"
                    :total="allpages"
                  ></el-pagination>
                </div>
              </div>
            </el-tab-pane>
          </el-tabs>
        </div>
      </div>
    </div>
    <Bottom-content></Bottom-content>
  </div>
</template>

<script>
export default {
  data() {
    return {
      prisesort: 0,
      areasort: 0,
      roomdata: [],
      PriceRoomdata: [],
      AreaRoomdata: [],
      currentPage: 1,
      allpages: 100,
      parameter: {
        location: "武汉市",
        qhouseaddress: "",
        qhouserent: "",
        qhousebed: "",
        qhousetype: "",
        qhousedescribe: "",
        pagecount: 1
      },
      activeName: "first",
      titleArr: ["", "", "", "", ""],
      dianfo: { row0: 0, row1: 0, row2: 0, row3: 0 },
      dds: [
        [
          { name: "不限", rownum: "row0" },
          { name: "南岸区", rownum: "row0" },
          { name: "渝中区", rownum: "row0" },
          { name: "渝北区", rownum: "row0" },
          { name: "合川区", rownum: "row0" }
        ],
        [
          { name: "不限", rownum: "row1" },
          { name: "100以下", rownum: "row1" },
          { name: "100~200元", rownum: "row1" },
          { name: "200~300元", rownum: "row1" },
          { name: "300元以上", rownum: "row1" }
        ],
        [
          { name: "不限", rownum: "row2" },
          { name: "一居室", rownum: "row2" },
          { name: "二居室", rownum: "row2" },
          { name: "三居室", rownum: "row2" },
          { name: "四居室以上", rownum: "row2" }
        ],
        [
          { name: "不限", rownum: "row3" },
          { name: "整租", rownum: "row3" },
          { name: "合租", rownum: "row3" }
        ]
      ],
      title: "你选的你负责",
      input: "",
      city: "武汉市",
      lis: [
        { name: "首页", http: "/" },
        { name: "找房", http: "/rentinhome" },
        { name: "合租", http: "/" },
        { name: "整租", http: "/" },
        { name: "月租", http: "/" },
        { name: "关于", http: "/" }
      ]
    };
  },
  created() {
    this.getRoomdata(this.parameter);
  },
  mounted() {},
  computed: {
    // 给价钱定义参数格式
    price: function() {
      let n = this.titleArr[1].match(/\d+~?\d*/g);
      if (n == null) {
        n = "";
        console.log(n);
      } else {
        n = n.join("");
      }
      return n;
    },
    address: function() {
      if (this.titleArr[0] == "不限") {
        return "";
      }
      return this.titleArr[0];
    },
    bed: function() {
      if (this.titleArr[2] == "不限") {
        return "";
      } else {
        return this.titleArr[2].substr(0, 1) + this.titleArr[2].substr(2, 1);
      }
    },
    type: function() {
      if (this.titleArr[3] == "不限") {
        return "";
      }
      return this.titleArr[3];
    }
  },
  watch: {
    titleArr: function(newvalue) {
      this.parameter["location"] = this.city;
      this.parameter["qhouseaddress"] = this.address;
      this.parameter["qhouserent"] = this.price;
      this.parameter["qhousebed"] = this.bed;
      this.parameter["qhousetype"] = this.type;
      this.parameter["qhousedescribe"] = newvalue[4];
      this.parameter["pagecount"] = 1;
      this.parameter["order"] = 0;
      this.getRoomdata(this.parameter);
    }
  },
  methods: {
    // 房间详情
    roomload(ev) {
      //  const res = await this.$axios.get(`/house/${ev.houseid}`)
      this.$router.push(`/house/${ev.houseid}`);
    },
    // 页码切换
    handleCurrentChange(ev) {
      // 回调参数 当前页码
      this.parameter["pagecount"] = ev;
      this.getRoomdata(this.parameter);
    },
    handleCurrentChangeArea(ev) {
      // 回调参数 当前页码
      this.parameter["pagecount"] = ev;
      this.getAreaRoomdata(this.parameter);
    },
    handleCurrentChangePrise(ev) {
      // 回调参数 当前页码
      this.parameter["pagecount"] = ev;
      this.getPriseRoomdata(this.parameter);
    },
    // 切换排序
    handleClick(ev) {
      if (ev.index == 0) {
        (this.currentPage = 1), (this.parameter["pagecount"] = 1);
        this.getRoomdata(this.parameter);
      } else if (ev.index == 1 && this.prisesort == 0) {
        this.currentPage = 1;
        this.prisesort = 1;
        this.areasort == 0;
        this.parameter["order"] = 1;
        this.parameter["pagecount"] = 1;
        this.getPriseRoomdata(this.parameter);
      } else if (ev.index == 1 && this.prisesort == 1) {
        this.currentPage = 1;
        this.prisesort = 0;
        this.areasort == 0;
        this.parameter["order"] = 0;
        this.parameter["pagecount"] = 1;
        this.getPriseRoomdata(this.parameter);
      } else if (ev.index == 2 && this.areasort == 0) {
        this.currentPage = 1;
        this.areasort = 1;
        this.prisesort = 0;
        this.parameter["order"] = 1;
        this.parameter["pagecount"] = 1;
        this.getAreaRoomdata(this.parameter);
      } else if (ev.index == 2 && this.areasort == 1) {
        this.currentPage = 1;
        this.areasort = 0;
        this.prisesort = 0;
        this.parameter["order"] = 0;
        this.parameter["pagecount"] = 1;
        this.getAreaRoomdata(this.parameter);
      }
    },
    // 获取面积数据
    async getAreaRoomdata(ev) {
      const res = await this.$axios.get("/searcharea", { params: ev });
      const { status, data, message } = res.data;
      if (status == 200) {
        this.$message({
          message: `${message}`,
          type: "success",
          duration: 1000
        });
        this.roomdata = data.data;
        this.allpages = data.size;
      }
    },
    // 获取价格数据
    async getPriseRoomdata(ev) {
      const res = await this.$axios.get("/searchrent", { params: ev });
      const { status, data, message } = res.data;
      if (status == 200) {
        this.$message({
          message: `${message}`,
          type: "success",
          duration: 1000
        });
        this.roomdata = data.data;
        this.allpages = data.size;
      }
    },
    // 获取默认数据
    async getRoomdata(ev) {
      console.log(ev);
      const res = await this.$axios.get("/searchdefault", { params: ev });
      const { status, data } = res.data;
      console.log(res);
      if (status == 200) {
        // this.$message({
        //   message: `${message}`,
        //   type: "success",
        //   duration: 1000
        // });
        this.roomdata = data.data;
        this.allpages = data.size;
      }
    },
    // 点击搜索
    search() {
      if (this.input == "") {
        // 无效操作 只是刷新
        // this.titleArr[4] = this.input;
        // this.$refs.seartitle[4].$el.style.display = "none"; // 让title对应值消失
      } else {
        this.$set(this.titleArr, 4, this.input); // 使用$set改变数组，避免watch没法监听
        this.$refs.seartitle[4].$el.style.display = "inline-block";
        this.input = "";
      }
    },
    // 删除titileArr数组 点X
    handleClose(ev) {
      this.titleArr.splice(ev, 1, "");
      this.dianfo["row" + ev] = 0; // 让对应组变成不限
      console.log(this.dianfo);
      this.$refs.seartitle[ev].$el.style.display = "none"; // 让title对应值消失
    },

    // 控制点击dd选项  ev1组内序号 ev2组号
    btnA(ev1, ev2) {
      let n = parseInt(ev2.charAt(3));
      if (ev1 === 0) {
        this.$refs.seartitle[n].$el.style.display = "none"; // 让title对应值消失
      } else {
        this.$refs.seartitle[n].$el.style.display = "inline-block"; // 让title对应值出现
      }

      this.dianfo[ev2] = ev1;
      console.log(this.titleArr);
      this.titleArr.splice(n, 1, this.dds[n][ev1].name);
      console.log(this.titleArr);
    },
    // 选城市
    handleCommand(command) {
      this.$message({
        message: "click on item " + command,
        duration: 1000
      });
      this.city = command;
    },
    btnli(ev) {
      this.$router.push(`${this.lis[ev].http}`);
    }
  }
};
</script>
<style scoped>
.bcimg {
  background: url(../assets/5.png) no-repeat center center fixed;
  min-height: 1800px;
}

.roomImg {
  cursor: pointer;
}
.pageFooter {
  width: 50%;
  margin: 20px auto;
}
.roombtn {
  margin-top: 20px;
}
.roomright p span:first-child {
  font-size: 30px;
  color: #ff7966;
  letter-spacing: -1px;
}
/* 房间描述的字体 */
.roomfont p {
  margin-top: 20px;
}
.roomfont p:first-child {
  font-size: 20px;
  cursor: pointer;
}
.roomfont p:first-child:hover {
  color: rgb(255, 51, 82);
}
.roomcard {
  border-bottom: 1px solid #e6e6e6;
  padding: 30px 0;
  overflow: hidden;
  position: relative;
}
/* title样式 */
.seartitle span {
  margin-right: 10px;
  display: none;
}
.seartitle span:first-child {
  display: inline-block;
  height: 30px;
  line-height: 30px;
}

/* 点击样式 */
.dldiv .onlist {
  border-radius: 6px;
  background: #3dbcc6;
  color: #fff;
}
.dldiv a:hover {
  cursor: pointer;
  color: rgb(61, 188, 198);
}
.dldiv a {
  display: block;
  line-height: 24px;
  font-size: 14px;
  height: 24px;
  padding: 0 18px;
  float: left;
  color: #333;
}
.dldiv {
  float: left;
  line-height: 36px;
}
.dl {
  position: relative;
  display: inline-block;
  width: 100%;
  height: auto;
  padding-left: 20px;
}
.dl dt {
  font-weight: 700;
  float: left;
  width: 50px;
  line-height: 24px;
  padding-bottom: 12px;
  font-size: 14px;
  color: #666;
}
.searchdd {
  border: 1px solid #f0f0f0;
  border-top: none;
  padding: 15px 0 15px;
  margin: 0 auto;
  position: relative;
}
.searchBtn {
  width: 20%;
  border-radius: 0 5px 5px 0;
  border: none;
  background-color: #00a4ac;
  height: 60px;
  text-align: center;
  font-size: 18px;
  color: #fff;
  line-height: 60px;
  outline: none;
}
.input::-webkit-input-placeholder {
  color: #999;
}
.input {
  outline: none;
  margin-left: 20px;
  border: none;
  height: 60px;
  text-indent: 12px;
  font-size: 16px;
  padding-left: 30px;
  background-color: #fff;
  border-radius: 5px 0 0 5px;
  width: 70%;
}

.searMenu {
  height: 120px;
  padding: 20px 0 0 10px;
  background-color: #f0f0f0;
}
.searMenu p {
  margin: 20px 0 0 20px;
  color: #999;
}
.search {
  margin: 20px 0;
}
.all {
  width: 80%;
  margin: 0 auto;
}
.header {
  width: 100%;
  height: 50px;
  display: inline-block;
  background: #fff;
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
  margin-top: 15px;
  text-align: left;
}
.head1 > div {
  height: 50px;
  margin: 0 12px;
  vertical-align: bottom;
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
/* .butlogin {
  padding: 5px;
  background-color: aquamarine;
} */
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
