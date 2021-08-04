<template>
  <div class="page2">
    <div class="home-order">
      <div class="page-title">
        <img src="../../assets/img/dingdan.svg" />
        <span>入住申请</span>
      </div>
    </div>
    <div class="page-order" v-show="order !== 0">
      <el-table :data="order" style="width: 100%">
        <el-table-column type="expand">
          <template slot-scope="props">
            <el-form label-position="left" inline class="demo-table-expand">
              <el-form-item label="房间名称:">
                <span>{{ props.row.housename }}</span>
              </el-form-item>
              <el-form-item label="房间 ID:">
                <span>{{ props.row.houseid }}</span>
              </el-form-item>
              <el-form-item label="订单状态:">
                <span>{{ props.row.conditional | forConditional }}</span>
              </el-form-item>
              <el-form-item label="订单价格:">
                <span>{{ props.row.price }}</span>
              </el-form-item>
              <el-form-item label="下单时间:">
                <span>{{ props.row.checkintime | fmtdata }}</span>
              </el-form-item>
              <el-form-item label="入住天数:">
                <span>{{ props.row.days }}</span>
              </el-form-item>
              <el-form-item label="入住人:">
                <span>{{ props.row.occupants }}</span>
              </el-form-item>
              <el-form-item label="联系电话:">
                <span>{{ props.row.phonenum }}</span>
              </el-form-item>
            </el-form>
          </template>
        </el-table-column>
        <el-table-column label="订单 ID" prop="orderid"></el-table-column>
        <el-table-column label="房间名称" prop="housename"></el-table-column>
        <el-table-column label="入住人" prop="occupants"></el-table-column>
        <el-table-column label="操作" width="220px">
          <template slot-scope="scope">
            <el-row>
              <el-button
                type="success"
                icon="el-icon-circle-check"
                size="mini"
                @click="agreement(scope.row.orderid)"
                >同意</el-button
              >
            </el-row>
            <el-row>
              <el-button
                type="danger"
                id="modify"
                icon="el-icon-circle-close"
                size="mini"
                @click="refuse(scope.row.orderid)"
                >拒绝</el-button
              >
            </el-row>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <div class="block">
      <el-pagination
        :hide-on-single-page="true"
        @current-change="handleCurrentChange"
        :current-page.sync="currentPage"
        :page-size="10"
        layout="prev, pager, next, jumper"
        :total="this.size"
      ></el-pagination>
    </div>
  </div>
</template>

<script>
export default {
  name: "HomeA",
  created() {
    this.addAccount();
    this.getOrder2({
      account: this.account,
      pagecount: this.currentPage
    });
  },
  data() {
    return {
      order: [],
      size: 1,
      account: "",
      currentPage: 1,
      centerDialogVisible: false,
      centerDialog: false
    };
  },
  filters: {
    forConditional(num) {
      if (num === 0) {
        num = "等待确认";
        return num;
      }
    }
  },
  methods: {
    addAccount() {
      this.account = localStorage.getItem("account");
    },
    async getOrder2(ev) {
      const res = await this.$axios.get("/findownconfirmorder", { params: ev });
      // const { status, data, message } = res.data
      this.size = res.data.data.size;
      this.order = res.data.data.data;
    },
    handleCurrentChange(ev) {
      this.currentPage = ev;
      console.log(this.currentPage);
      this.getOrder2({
        account: this.account,
        pagecount: this.currentPage
      });
    },
    async agreement(ev) {
      this.orderid = ev;
      const res = await this.$axios.post("/checkorder?orderid=" + this.orderid);
      console.log(res);
      this.$message.success("操作成功！");
      this.getOrder2({
        account: this.account,
        pagecount: this.currentPage
      });
    },
    async refuse(ev) {
      this.orderid = ev;
      const res = await this.$axios.post(
        "/checkcancelorder?orderid=",
        this.orderid
      );
      console.log(res);
      this.$message.success("操作成功！");
      this.getOrder2({
        account: this.account,
        pagecount: this.currentPage
      });
    }
  }
};
</script>

<style scoped>
.page2 {
  width: 100%;
  height: 100%;
}
.home-order {
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
.order-page-in img {
  height: 100%;
  margin-right: 40px;
  float: left;
}

#modify {
  margin: 10px 0 0 0;
}
.block {
  text-align: center;
}
.color1 {
  color: red;
}

.demo-table-expand {
  font-size: 0;
}
.demo-table-expand label {
  width: 90px;
  color: #99a9bf;
}
.demo-table-expand .el-form-item {
  margin-right: 0;
  margin-bottom: 0;
  width: 50%;
}
</style>
