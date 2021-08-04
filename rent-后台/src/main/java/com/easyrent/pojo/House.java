package com.easyrent.pojo;

import java.util.Date;

public class House {
    private String houseid;
    private Integer housearea;
    private Integer housemin;
    private Integer housemax;
    private Integer houserent;
    private String housename;
    private String housedescribe;
    private String houseaddress;
    private String housetype;
    private Integer houselimit;
    private String houseroom;
    private String houserefund;
    private String housemainpic;
    private Integer housestate;

    private String pic1;

    private String pic2;

    private String pic3;

    private String pic4;

    private String pic5;

    private String pic6;

    private String account;

    private Date housecreate;

    public String getHouseid() {
        return houseid;
    }

    public void setHouseid(String houseid) {
        this.houseid = houseid == null ? null : houseid.trim();
    }

    public Integer getHousearea() {
        return housearea;
    }

    public void setHousearea(Integer housearea) {
        this.housearea = housearea;
    }

    public Integer getHousemin() {
        return housemin;
    }

    public void setHousemin(Integer housemin) {
        this.housemin = housemin;
    }

    public Integer getHousemax() {
        return housemax;
    }

    public void setHousemax(Integer housemax) {
        this.housemax = housemax;
    }

    public Integer getHouserent() {
        return houserent;
    }

    public void setHouserent(Integer houserent) {
        this.houserent = houserent;
    }

    public String getHousename() {
        return housename;
    }

    public void setHousename(String housename) {
        this.housename = housename == null ? null : housename.trim();
    }

    public String getHousedescribe() {
        return housedescribe;
    }

    public void setHousedescribe(String housedescribe) {
        this.housedescribe = housedescribe == null ? null : housedescribe.trim();
    }

    public String getHouseaddress() {
        return houseaddress;
    }

    public void setHouseaddress(String houseaddress) {
        this.houseaddress = houseaddress == null ? null : houseaddress.trim();
    }

    public String getHousetype() {
        return housetype;
    }

    public void setHousetype(String housetype) {
        this.housetype = housetype == null ? null : housetype.trim();
    }

    public Integer getHouselimit() {
        return houselimit;
    }

    public void setHouselimit(Integer houselimit) {
        this.houselimit = houselimit;
    }

    public String getHouseroom() {
        return houseroom;
    }

    public void setHouseroom(String houseroom) {
        this.houseroom = houseroom == null ? null : houseroom.trim();
    }

    public String getHouserefund() {
        return houserefund;
    }

    public void setHouserefund(String houserefund) {
        this.houserefund = houserefund == null ? null : houserefund.trim();
    }

    public String getHousemainpic() {
        return housemainpic;
    }

    public void setHousemainpic(String housemainpic) {
        this.housemainpic = housemainpic == null ? null : housemainpic.trim();
    }

    public Integer getHousestate() {
        return housestate;
    }

    public void setHousestate(Integer housestate) {
        this.housestate = housestate;
    }

    public String getPic1() {
        return pic1;
    }

    public void setPic1(String pic1) {
        this.pic1 = pic1 == null ? null : pic1.trim();
    }

    public String getPic2() {
        return pic2;
    }

    public void setPic2(String pic2) {
        this.pic2 = pic2 == null ? null : pic2.trim();
    }

    public String getPic3() {
        return pic3;
    }

    public void setPic3(String pic3) {
        this.pic3 = pic3 == null ? null : pic3.trim();
    }

    public String getPic4() {
        return pic4;
    }

    public void setPic4(String pic4) {
        this.pic4 = pic4 == null ? null : pic4.trim();
    }

    public String getPic5() {
        return pic5;
    }

    public void setPic5(String pic5) {
        this.pic5 = pic5 == null ? null : pic5.trim();
    }

    public String getPic6() {
        return pic6;
    }

    public void setPic6(String pic6) {
        this.pic6 = pic6 == null ? null : pic6.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public Date getHousecreate() {
        return housecreate;
    }

    public void setHousecreate(Date housecreate) {
        this.housecreate = housecreate;
    }

}