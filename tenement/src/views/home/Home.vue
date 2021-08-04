<template>
  <div class="page">
    <div class="home">
      <div class="page-title">
        <img src="../../assets/img/dingdan.svg" />
        <span>租房订单</span>
      </div>
    </div>
    <div v-if="orderNumber == 0" class="page-B">
      <img src="../../assets/img/订单.png" />
    </div>
    <div
      v-else
      class="order-page"
      v-for="(item, index) in orderNumber"
      :key="index"
    >
      <div class="order-page-in">
        <img src="../../assets/img/背景.jpg" />
        <div class="information">
          <strong>订单号：{{ item.orderid }}</strong>
          <p>房间号：{{ item.houseid }}</p>
          <p>订单创建时间：{{ item.checkintime | fmtdata }}</p>
          <p>入住天数：{{ item.days }}</p>
          <p>订单价格：{{ item.price }}</p>
          <p>订单状态：{{ item.conditional | forConditional }}</p>
        </div>
        <div class="orderNumber-pageB">
          <el-button
            type="danger"
            icon="el-icon-document-remove"
            :disabled="item.conditional !== 0 && item.conditional !== 1"
            @click="cancel(item.orderid)"
            >退订</el-button
          >
          <el-dialog
            title="取消订单"
            :visible.sync="centerDialogVisible"
            width="30%"
            center
          >
            <span>您确认要取消订单吗</span>
            <span slot="footer" class="dialog-footer">
              <el-button @click="centerDialogVisible = false">取 消</el-button>
              <el-button type="primary" @click="cancelOrder()">确 定</el-button>
            </span>
          </el-dialog>
          <el-button
            type="info"
            id="modify"
            icon="el-icon-delete"
            :disabled="item.conditional !== 3 && item.conditional !== 4"
            @click="dddelete(item.orderid)"
            >删除</el-button
          >
          <el-dialog
            title="删除订单"
            :visible.sync="centerDialog"
            width="30%"
            center
          >
            <span>您确认要删除订单吗</span>
            <span slot="footer" class="dialog-footer">
              <el-button @click="centerDialog = false">取 消</el-button>
              <el-button type="primary" @click="deleteOrder()">确 定</el-button>
            </span>
          </el-dialog>
        </div>
      </div>
    </div>
    <div class="block" v-show="size !== 0">
      <el-pagination
        @current-change="handleCurrentChange"
        :current-page.sync="currentPage"
        :page-size="5"
        layout="prev, pager, next, jumper"
        :total="this.size"
      >
      </el-pagination>
    </div>
  </div>
</template>

<script>
export default {
  name: "Home",
  created() {
    this.addAccount();
    this.getOrder({
      account: this.account,
      pagecount: this.currentPage
    });
  },
  data() {
    return {
      orderNumber: [],
      account: "",
      currentPage: 1,
      size: 0,
      centerDialogVisible: false,
      centerDialog: false
    };
  },
  filters: {
    forConditional(num) {
      if (num === 0) {
        num = "等待确认";
        return num;
      } else if (num === 1) {
        num = "已确认";
        return num;
      } else if (num === 2) {
        num = "申请取消";
        return num;
      } else if (num === 3) {
        num = "已取消";
        return num;
      } else if (num === 4) {
        num = "已完成";
        return num;
      } else {
        num = "已删除";
        return num;
      }
    }
  },
  methods: {
    addAccount() {
      this.account = localStorage.getItem("account");
    },
    async getOrder(ev) {
      const res = await this.$axios.get("/findmyorder", { params: ev });
      console.log(res);
      this.size = res.data.data.size;
      this.orderNumber = res.data.data.data;
    },
    handleCurrentChange(ev) {
      this.currentPage = ev;
      this.getOrder({
        account: this.account,
        pagecount: this.currentPage
      });
    },
    cancel(ev) {
      this.centerDialogVisible = true;
      this.orderid = ev;
    },
    dddelete(ev) {
      this.centerDialog = true;
      this.orderid = ev;
    },
    async deleteOrder() {
      this.centerDialog = false;
      await this.$axios.post("/deletemyorder?orderid=" + this.orderid);
      this.getOrder({
        account: this.account,
        pagecount: this.currentPage
      });
    },
    async cancelOrder() {
      this.centerDialogVisible = false;
      await this.$axios.post("/cancelorder?orderid=" + this.orderid);
      this.getOrder({
        account: this.account,
        pagecount: this.currentPage
      });
    }
  }
};
</script>

<style scoped>
.page {
  width: 100%;
  height: 100%;
}
.home {
  height: 8%;
  padding-right: 30px;
}
.page-title {
  height: 100%;
  border-bottom: 1px solid #e6e6e6;
  line-height: 8%;
  margin-bottom: 4%;
}
.page-title img {
  height: 30px;
  width: 30px;
  position: relative;
  top: 22%;
  margin-right: 10px;
}
.page-B img {
  position: relative;
  width: 90%;
  height: 70%;
  top: 50px;
}
.order-page {
  height: 14%;
  padding: 20px 30px 20px 0;
}
.order-page-in {
  height: 100%;
  border-bottom: 1px solid #e6e6e6;
}
.order-page-in img {
  height: 100%;
  margin-right: 40px;
  float: left;
}
.information {
  width: 50%;
  height: 85%;
  float: left;
}
.information p {
  color: #272929;
}
.information span {
  display: inline-block;
  height: 22px;
  width: 8%;
}
.orderNumber-pageB {
  width: 15%;
  height: 100%;
  float: right;
}
#modify {
  margin: 10px 0 0 0;
}
.block {
  text-align: center;
}
</style>
