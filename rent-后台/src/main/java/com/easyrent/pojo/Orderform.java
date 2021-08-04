package com.easyrent.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Orderform {
    private String orderid;

    private String account;

    private String houseid;

    private Date checkintime;

    private Integer days;

    private BigDecimal price;

    private Integer conditional;

    private String occupants;

    private String phonenum;

    private String housename;

    private Integer usercancelcondition;

    private Integer ownercancelconditon;

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getHouseid() {
        return houseid;
    }

    public void setHouseid(String houseid) {
        this.houseid = houseid == null ? null : houseid.trim();
    }

    public Date getCheckintime() {
        return checkintime;
    }

    public void setCheckintime(Date checkintime) {
        this.checkintime = checkintime;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getConditional() {
        return conditional;
    }

    public void setConditional(Integer conditional) {
        this.conditional = conditional;
    }

    public String getOccupants() {
        return occupants;
    }

    public void setOccupants(String occupants) {
        this.occupants = occupants == null ? null : occupants.trim();
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum == null ? null : phonenum.trim();
    }

    public String getHousename() {
        return housename;
    }

    public void setHousename(String housename) {
        this.housename = housename == null ? null : housename.trim();
    }

    public Integer getUsercancelcondition() {
        return usercancelcondition;
    }

    public void setUsercancelcondition(Integer usercancelcondition) {
        this.usercancelcondition = usercancelcondition;
    }

    public Integer getOwnercancelconditon() {
        return ownercancelconditon;
    }

    public void setOwnercancelconditon(Integer ownercancelconditon) {
        this.ownercancelconditon = ownercancelconditon;
    }
}