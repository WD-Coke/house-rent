<template>
  <div class="bcimg">
    <my-Heard></my-Heard>

    <div class="roomall">
      <div class="roomall1">
        <div class="leftdiv">
          <el-carousel trigger="click" height="380px">
            <el-carousel-item v-for="(item, index) in imgs" :key="index">
              <img :src="item" alt="" class="big-img" />
            </el-carousel-item>
          </el-carousel>
          <div class="small-img">
            <div class="img-list">
              <img
                v-for="(item, index) in imgs"
                :key="index"
                alt=""
                :src="item"
                height="80"
              />
            </div>
          </div>
        </div>
        <div class="rightdiv">
          <h1>{{ roomDetails.housename }}</h1>
          <div class="room-price">
            <div class="price-list moth">
              <label>日租金</label>
              <span>
                <div class="room-price-sale">
                  {{ roomDetails.houserent }}
                  <em>元/天</em>
                </div>
              </span>
              <label>总金额</label>
              <span>
                <div class="room-price-sale">
                  <el-input-number
                    v-model="daynum"
                    :min="roomDetails.housemin"
                    :max="roomDetails.housemax"
                    size="small"
                    label="描述文字"
                  ></el-input-number>
                  <span style="margin-left:60px">{{ allprise }}</span>
                  <em>元</em>
                </div>
              </span>
            </div>
          </div>
          <div class="room-list-new">
            <div>
              <span>建筑面积：{{ roomDetails.housearea }}cm²</span>
            </div>
            <div>
              <span>编号：{{ roomDetails.houseid }}</span>
            </div>
            <div>
              <span>最短出租时间：{{ roomDetails.housemin }}天</span>
            </div>
            <div>
              <span>最长出租时间：{{ roomDetails.housemax }}天</span>
            </div>
            <div>
              <span>房屋规模：{{ roomDetails.houseroom }}</span>
            </div>
            <div>
              <span>最大入住人数：{{ roomDetails.houselimit }}人</span>
            </div>
            <div>
              <span>退款日：{{ roomDetails.houserefund }}</span>
            </div>
            <div>
              <span>上次维护时间：{{ roomDetails.housecreate | fmtdata }}</span>
            </div>
            <div>
              <span>房屋地址：{{ roomDetails.houseaddress }}</span>
            </div>
          </div>
          <el-button type="primary" class="btnroom" @click="client()"
            >预 定 房 源</el-button
          >
        </div>
      </div>
      <el-divider class="easyfont">
        <span>易租公寓承诺</span>
      </el-divider>
      <div class="danke-promise">
        <div class="danke-promise-content">
          <div class="danke-promise-item">
            <img
              src="https://public.danke.com.cn/public-20180710-FgEl0lEz9s_ZE1PMx41B309vYI_8"
              alt
            />
            <p>百分百真实房源</p>
          </div>
          <div class="danke-promise-item">
            <img
              src="https://public.danke.com.cn/public-20180709-FmKudE1SpLyXqzZItWOzSlXt4zEx"
              alt
            />
            <p>不收取中介费</p>
          </div>
          <div class="danke-promise-item">
            <img
              src="https://public.danke.com.cn/public-20180709-FsP-XOTqpxKQPvbTxZU_1B4rdzC8"
              alt
            />
            <p>优质保洁</p>
          </div>
          <div class="danke-promise-item">
            <img
              src="https://public.danke.com.cn/public-20180710-FoppJzNZhyIQChrOizdbCraqhIKQ"
              alt
            />
            <p>售后维修及时上门</p>
          </div>
          <div class="danke-promise-item">
            <img
              src="https://public.danke.com.cn/public-20180709-FguIPSRzpZhmlhQrKFQz-4Gq8hpk"
              alt
            />
            <p>智能密码锁</p>
          </div>
          <div class="danke-promise-item">
            <img
              src="https://public.danke.com.cn/public-20180709-FtTfCx8--Zw1Af9W2jIOAYGgSu3a"
              alt
            />
            <p>极速WIFI</p>
          </div>
        </div>
      </div>
    </div>
    <!-- 入住人弹框 -->
    <el-dialog
      title="入住人信息"
      :visible.sync="clientFormVisible"
      center
      width="450px"
    >
      <el-form label-width="80px">
        <el-form-item label="姓名">
          <el-input
            placeholder="请输入姓名"
            v-model="inputname"
            clearable
          ></el-input>
        </el-form-item>
        <el-form-item label="联系电话">
          <el-input
            placeholder="请输入联系电话"
            v-model="inputphone"
            clearable
          ></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="clientFormVisible = false">取消</el-button>
        <el-button type="primary" @click="reservation()">确 定</el-button>
      </div>
    </el-dialog>
    <Bottom-content></Bottom-content>
  </div>
</template>

<script>
import qs from "qs";
export default {
  data() {
    return {
      clientFormVisible: false,
      daynum: 1,
      inputname: "",
      inputphone: "",
      roomDetails: {},
      imgs: [],
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
  computed: {
    allprise: function() {
      return this.daynum * this.roomDetails.houserent;
    }
  },
  created() {
    this.getroomdetails(this.$route.params);
  },
  methods: {
    // 入住验证
    client() {
      let judge = localStorage.getItem("token");
      if (!judge) {
        this.$message({
          message: "请先登录",
          type: "warning",
          duration: 1000
        });
      } else {
        this.clientFormVisible = true;
      }
    },

    // 预定房间
    async reservation() {
      this.clientFormVisible = false;
      const res = await this.$axios.post(
        "/createorder",
        qs.stringify({
          account: localStorage.getItem("account"),
          houseid: this.roomDetails.houseid,
          price: this.roomDetails.houserent,
          days: this.daynum,
          occupants: this.inputname,
          phonenum: this.inputphone
        }),
        {
          headers: {
            "Content-Type": "application/x-www-form-urlencoded;charset=UTF-8"
          } // 修正中文乱码
        }
      );
      const { status, message } = res.data;
      if (status == 200) {
        this.$message({
          message: `${message}`,
          type: "success",
          duration: 1000
        });
      }
    },

    async getroomdetails(ev) {
      const res = await this.$axios.get(`/house/${ev.name}`);
      const { status, data, message } = res.data;
      if (status == 200) {
        this.$message({
          message: `${message}`,
          type: "success",
          duration: 1000
        });
        this.roomDetails = data;

        this.imgs[0] = data.pic1;
        this.imgs[1] = data.pic2;
        this.imgs[2] = data.pic3;
        this.imgs[3] = data.pic4;
      }
    },
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
}
.easyfont span {
  font-weight: 700;
  font-size: 24px;
}

.danke-promise {
  width: 1190px;
  margin: 10px auto;
}
.danke-promise-content {
  background-color: #fff;
  width: 100%;
  border-radius: 5px;
  box-shadow: 0 0 10px 3px rgba(231, 231, 231, 0.5);
  padding: 30px 0;
  margin-top: 30px;
}
.danke-promise-item {
  width: 16.3%;
  text-align: center;
  display: inline-block;
}

.danke-promise-item p {
  font-size: 16px;
  color: #333;
  text-align: center;
  margin-top: 20px;
}

.btnroom {
  width: 90%;
  margin: 10px 0 30px 30px;
}
.roomall1:after {
  content: "";
  display: block;
  height: 0;
  clear: both;
  visibility: hidden;
}
.roomall1 {
  margin: 20px auto;
}
em {
  font-style: normal;
}
.room-list-new div {
  width: 40%;
  float: left;
  height: 40px;
  margin-left: 20px;
  word-break: break-all;
}
.room-list-new div:last-child {
  width: 85%;
}
.room-list-new div span {
  margin-right: 20px;
  display: block;
  font-weight: 400;
  height: 40px;
  color: #666;
  font-size: 14px;
  line-height: 40px;
}
.room-list-new {
  width: 100%;
  display: block;
  padding-left: 40px;
  margin-bottom: 40px;
}
.room-price-sale {
  display: block;
  margin: 0 0 0 85px;
}
.room-price-sale {
  color: #ff7966;
  font-size: 32px;
  line-height: 42px;
  font-weight: 700;
}
.price-list label {
  float: left;
  width: 85px;
  line-height: 42px;
  font-size: 14px;
  color: #999;
  font-weight: 400;
}
.price-list {
  padding-top: 20px;
}
.room-price {
  overflow: hidden;
  background: #f9f9fb;
  padding: 0 25px 10px;
  min-height: 100px;
}
.rightdiv {
  margin-left: 0;
  float: right;
  width: 45%;
  height: 100%;
}
.rightdiv h1 {
  margin-bottom: 20px;
}
.roomall {
  width: 80%;
  margin: 10px auto;
}
.big-img {
  width: 100%;
  margin: 0 auto;
  height: 100%;
}
.img-list {
  margin-top: 10px;
}
.img-list img {
  width: 20%;
  margin: 0 5px;
}
.small-img {
  width: 100%;
  text-align: center;
}
.leftdiv {
  float: left;
  width: 50%;
  height: 100%;
}
</style>
