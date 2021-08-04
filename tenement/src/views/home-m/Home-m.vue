<template>
  <div class="page3">
    <div class="home-m">
      <div class="page-title">
        <div class="pageI">
          <img src="../../assets/img/fangjian.svg" />
        </div>
        <div class="pageW">
          <span>房间管理</span>
        </div>
        <div class="pageA">
          <el-button type="primary" plain @click="addroom()"
            >新增房源</el-button
          >
        </div>
      </div>
    </div>
    <div v-if="room == 0" class="page-B">
      <img src="../../assets/img/房间.png" />
    </div>
    <div v-else class="room-page" v-for="(item, index) in room" :key="index">
      <div class="room-page-in">
        <el-popover
          placement="top-start"
          width="100"
          trigger="hover"
          content="点击查看详情"
        >
          <img
            :src="item.housemainpic"
            @click="roomload(item)"
            slot="reference"
          />
        </el-popover>
        <div class="information">
          <strong>{{ item.housename }}</strong>
          <p>房间号：{{ item.houseid }}</p>
          <p>房间面积(m²)：{{ item.housearea }}</p>
          <p>房间价格(元/天)：{{ item.houserent }}</p>
          <p>房间类型：{{ item.houseroom }}</p>
        </div>
        <div class="room-pageB">
          <el-button type="success" icon="el-icon-edit" @click="alter(index)"
            >修改</el-button
          >
          <el-button
            type="info"
            id="modify"
            icon="el-icon-delete"
            @click="addId(item.houseid)"
            >删除</el-button
          >
          <el-dialog
            title="删除房间"
            :visible.sync="centerDialog"
            width="30%"
            center
          >
            <span>您确认要删除此房间吗？</span>
            <span slot="footer" class="dialog-footer">
              <el-button @click="centerDialog = false">取 消</el-button>
              <el-button type="primary" @click="deleteRoom">确 定</el-button>
            </span>
          </el-dialog>
        </div>
      </div>
    </div>
    <div class="block">
      <el-pagination
        @current-change="handleCurrentChange"
        :current-page.sync="currentPage"
        :page-size="5"
        layout="prev, pager, next, jumper"
        :total="this.size"
      ></el-pagination>
    </div>
    <!-- 新增房屋弹窗 -->
    <el-dialog title="新增房屋" :visible.sync="dialogFormVisible">
      <el-form :model="form" enctype="multipart/form-data">
        <el-form-item label="房间名称" :label-width="formLabelWidth">
          <el-input v-model="form.housename" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="房间面积(m²)" :label-width="formLabelWidth">
          <el-input v-model="form.housearea" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="最短租住天数" :label-width="formLabelWidth">
          <el-input v-model="form.housemin" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="最长租住天数" :label-width="formLabelWidth">
          <el-input v-model="form.housemax" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="房间描述" :label-width="formLabelWidth">
          <el-input v-model="form.housedescribe" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="房间地址" :label-width="formLabelWidth">
          <el-input v-model="form.houseaddress" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="房间能住人数" :label-width="formLabelWidth">
          <el-input v-model="form.houselimit" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="全额退款日" :label-width="formLabelWidth">
          <el-input v-model="form.houserefund" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="房间价格(元/天)" :label-width="formLabelWidth">
          <el-input v-model="form.houserent" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="房间类型" :label-width="formLabelWidth">
          <el-input v-model="form.houseroom" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <el-upload
        action="http://47.115.31.127/rent/createhouse"
        ref="upload"
        list-type="picture-card"
        :on-remove="handleRemove"
        :on-success="handleSuccess"
        :data="form"
        class="upData"
        :auto-upload="false"
      >
        <i class="el-icon-plus"></i>
        <div slot="tip" class="el-upload__tip">
          请上传jpg/png文件，且不超过500kb
        </div>
      </el-upload>
      <el-dialog :visible.sync="dialogVisible">
        <img width="100%" :src="dialogImageUrl" alt />
      </el-dialog>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="postRoom">确 定</el-button>
      </div>
    </el-dialog>
    <!-- 修改房屋弹窗 -->
    <el-dialog title="修改房屋" :visible.sync="alterdialogFormVisible">
      <el-form :model="alertform" enctype="multipart/form-data">
        <el-form-item label="房间名称" :label-width="formLabelWidth">
          <el-input v-model="alertform.housename" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="房间面积(m²)" :label-width="formLabelWidth">
          <el-input v-model="alertform.housearea" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="最短租住天数" :label-width="formLabelWidth">
          <el-input v-model="alertform.housemin" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="最长租住天数" :label-width="formLabelWidth">
          <el-input v-model="alertform.housemax" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="房间描述" :label-width="formLabelWidth">
          <el-input
            v-model="alertform.housedescribe"
            autocomplete="off"
          ></el-input>
        </el-form-item>
        <el-form-item label="房间地址" :label-width="formLabelWidth">
          <el-input
            v-model="alertform.houseaddress"
            autocomplete="off"
          ></el-input>
        </el-form-item>
        <el-form-item label="房间能住人数" :label-width="formLabelWidth">
          <el-input
            v-model="alertform.houselimit"
            autocomplete="off"
          ></el-input>
        </el-form-item>
        <el-form-item label="全额退款日" :label-width="formLabelWidth">
          <el-input
            v-model="alertform.houserefund"
            autocomplete="off"
          ></el-input>
        </el-form-item>
        <el-form-item label="房间价格(元/天)" :label-width="formLabelWidth">
          <el-input v-model="alertform.houserent" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="房间类型" :label-width="formLabelWidth">
          <el-input v-model="alertform.houseroom" autocomplete="off"></el-input>
        </el-form-item>
        <!-- <img v-for="(item,index) in alertform.allpic" :key="index" :src="item.pic" @click="shanchu(index)"> -->
      </el-form>
      <el-upload
        action="http://47.115.31.127/rent/alerthouse"
        ref="upload"
        list-type="picture-card"
        :on-remove="handleRemove"
        :data="alertform"
        class="upData"
        :auto-upload="false"
        :http-request="alertRoom"
      >
        <i class="el-icon-plus"></i>
        <div slot="tip" class="el-upload__tip">
          请上传jpg/png文件，且不超过500kb
        </div>
      </el-upload>
      <el-dialog :visible.sync="dialogVisible">
        <img width="100%" :src="dialogImageUrl" alt />
      </el-dialog>
      <div slot="footer" class="dialog-footer">
        <el-button @click="alterdialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="alertRoom()">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import qs from "qs";
export default {
  name: "HomeM",
  created() {
    this.addAccount();
    this.getRoom({
      account: this.account,
      pagecount: this.currentPage
    });
  },
  data() {
    return {
      room: [],
      size: 1,
      account: "",
      currentPage: 1,
      centerDialog: false,
      alterdialogFormVisible: false,
      dialogFormVisible: false,
      houseid: "",
      //新增房屋数据
      form: {
        account: "",
        housearea: "",
        housemin: "",
        housemax: "",
        houserent: "",
        housename: "",
        housedescribe: "",
        houseaddress: "",
        houselimit: "",
        houseroom: "",
        houserefund: ""
        // file: []
      },
      alertform: {
        account: "",

        houseid: "",

        housearea: "",
        housemin: "",
        housemax: "",
        houserent: "",
        housename: "",
        housedescribe: "",
        houseaddress: "",
        houselimit: "",
        houseroom: "",
        houserefund: ""
      },
      formLabelWidth: "120px",
      //上传文件数据
      dialogImageUrl: "",
      dialogVisible: false
    };
  },
  methods: {
    // // 删除图片
    // shanchu(ev){
    //   this.alertform.allpic[ev]=''
    // },
    addAccount() {
      this.account = localStorage.getItem("account");
      this.form.account = this.account;
      this.alertform.account = this.account;
    },
    addroom() {
      // this.form=[]
      this.dialogFormVisible = true;
    },
    alter(ev) {
      console.log(ev);
      this.alertform = this.room[ev];
      console.log(this.alertform);
      this.alterdialogFormVisible = true;
    },
    // 新增房间
    async postRoom() {
      this.$refs.upload.submit(this.form);
      this.dialogFormVisible = false;
      this.getRoom({
        account: this.account,
        pagecount: 1
      });
    },
    // 修改房间
    async alertRoom() {
      delete this.alertform.housecreate;
      console.log(this.alertform);
      const res = await this.$axios.post(
        "/alerthouse",
        qs.stringify(this.alertform)
      );
      console.log(res);
      this.alterdialogFormVisible = false;
      this.getRoom({
        account: this.account,
        pagecount: 1
      });
    },

    async deleteRoom() {
      this.centerDialog = false;
      const res = await this.$axios.delete(
        "/deletemyhouse?houseid=" + this.houseid
      );
      console.log(res);
      this.getRoom({
        account: this.account,
        pagecount: this.currentPage
      });
    },
    addId(ev) {
      this.centerDialog = true;
      console.log(ev);
      this.houseid = ev;
    },
    //获取参数
    async getRoom(ev) {
      const res = await this.$axios.get("/myhouse", { params: ev });
      console.log(res);
      this.size = res.data.data.size;
      this.room = res.data.data.data;
    },
    handleCurrentChange(ev) {
      this.currentPage = ev;
      this.getRoom({
        account: this.account,
        pagecount: this.currentPage
      });
    },
    // 删除图片
    handleRemove(file, fileList) {
      console.log(file, fileList);
    },

    handleSuccess(response, file) {
      this.dialogImageUrl = file.url;
      console.log(this.dialogImageUrl);
      console.log(file);
      // this.form.file.push(this.dialogImageUrl);
    },

    roomload(ev) {
      this.$router.push(`/house/${ev.houseid}`);
    }
  }
};
</script>

<style scoped>
.page3 {
  width: 100%;
  height: 100%;
}
.home-m {
  height: 8%;
  padding-right: 30px;
}
.page-title {
  height: 100%;
  border-bottom: 1px solid #e6e6e6;
  line-height: 8%;
  margin-bottom: 4%;
}
.pageI {
  width: 5%;
  height: 100%;
  float: left;
  text-align: center;
}
.pageW {
  width: 15%;
  height: 100%;
  float: left;
  line-height: 65px;
}
.pageA {
  width: 15%;
  height: 100%;
  float: right;
  line-height: 65px;
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
.room-page {
  height: 14%;
  padding: 20px 30px 20px 0;
}
.room-page-in {
  height: 100%;
  border-bottom: 1px solid #e6e6e6;
}
.room-page-in img {
  height: 90%;
  width: 20%;
  margin-right: 40px;
  float: left;
  cursor: pointer;
}
.information {
  width: 50%;
  height: 85%;
  float: left;
}
.information p {
  color: #272929;
}
.room-pageB {
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
.upData {
  margin-left: 35px;
}
</style>
