package com.easyrent.pojo;

/**
 * 返回的房间简短信息
 */
public class HouseShort {
    private String houseid;
    private Integer housearea;
    private String housename;
    private String housedescribe;
    private String houseaddress;
    private Integer houserent;
    private String houseroom;
    private String housemainpic;

    public String getHousemainpic() {
        return housemainpic;
    }

    public void setHousemainpic(String housemainpic) {
        this.housemainpic = housemainpic;
    }

    public String getHouseroom() {
        return houseroom;
    }

    public void setHouseroom(String houseroom) {
        this.houseroom = houseroom;
    }

    public Integer getHouserent() {
        return houserent;
    }

    public void setHouserent(Integer houserent) {
        this.houserent = houserent;
    }

    public String getHouseid() {
        return houseid;
    }

    public void setHouseid(String houseid) {
        this.houseid = houseid;
    }

    public Integer getHousearea() {
        return housearea;
    }

    public void setHousearea(Integer housearea) {
        this.housearea = housearea;
    }

    public String getHousename() {
        return housename;
    }

    public void setHousename(String housename) {
        this.housename = housename;
    }

    public String getHousedescribe() {
        return housedescribe;
    }

    public void setHousedescribe(String housedescribe) {
        this.housedescribe = housedescribe;
    }

    public String getHouseaddress() {
        return houseaddress;
    }

    public void setHouseaddress(String houseaddress) {
        this.houseaddress = houseaddress;
    }

}
