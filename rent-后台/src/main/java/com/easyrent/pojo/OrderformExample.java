package com.easyrent.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderformExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderformExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andOrderidIsNull() {
            addCriterion("orderid is null");
            return (Criteria) this;
        }

        public Criteria andOrderidIsNotNull() {
            addCriterion("orderid is not null");
            return (Criteria) this;
        }

        public Criteria andOrderidEqualTo(String value) {
            addCriterion("orderid =", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotEqualTo(String value) {
            addCriterion("orderid <>", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThan(String value) {
            addCriterion("orderid >", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThanOrEqualTo(String value) {
            addCriterion("orderid >=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThan(String value) {
            addCriterion("orderid <", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThanOrEqualTo(String value) {
            addCriterion("orderid <=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLike(String value) {
            addCriterion("orderid like", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotLike(String value) {
            addCriterion("orderid not like", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidIn(List<String> values) {
            addCriterion("orderid in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotIn(List<String> values) {
            addCriterion("orderid not in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidBetween(String value1, String value2) {
            addCriterion("orderid between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotBetween(String value1, String value2) {
            addCriterion("orderid not between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andAccountIsNull() {
            addCriterion("account is null");
            return (Criteria) this;
        }

        public Criteria andAccountIsNotNull() {
            addCriterion("account is not null");
            return (Criteria) this;
        }

        public Criteria andAccountEqualTo(String value) {
            addCriterion("account =", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotEqualTo(String value) {
            addCriterion("account <>", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThan(String value) {
            addCriterion("account >", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThanOrEqualTo(String value) {
            addCriterion("account >=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThan(String value) {
            addCriterion("account <", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThanOrEqualTo(String value) {
            addCriterion("account <=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLike(String value) {
            addCriterion("account like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotLike(String value) {
            addCriterion("account not like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountIn(List<String> values) {
            addCriterion("account in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotIn(List<String> values) {
            addCriterion("account not in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountBetween(String value1, String value2) {
            addCriterion("account between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotBetween(String value1, String value2) {
            addCriterion("account not between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andHouseidIsNull() {
            addCriterion("houseid is null");
            return (Criteria) this;
        }

        public Criteria andHouseidIsNotNull() {
            addCriterion("houseid is not null");
            return (Criteria) this;
        }

        public Criteria andHouseidEqualTo(String value) {
            addCriterion("houseid =", value, "houseid");
            return (Criteria) this;
        }

        public Criteria andHouseidNotEqualTo(String value) {
            addCriterion("houseid <>", value, "houseid");
            return (Criteria) this;
        }

        public Criteria andHouseidGreaterThan(String value) {
            addCriterion("houseid >", value, "houseid");
            return (Criteria) this;
        }

        public Criteria andHouseidGreaterThanOrEqualTo(String value) {
            addCriterion("houseid >=", value, "houseid");
            return (Criteria) this;
        }

        public Criteria andHouseidLessThan(String value) {
            addCriterion("houseid <", value, "houseid");
            return (Criteria) this;
        }

        public Criteria andHouseidLessThanOrEqualTo(String value) {
            addCriterion("houseid <=", value, "houseid");
            return (Criteria) this;
        }

        public Criteria andHouseidLike(String value) {
            addCriterion("houseid like", value, "houseid");
            return (Criteria) this;
        }

        public Criteria andHouseidNotLike(String value) {
            addCriterion("houseid not like", value, "houseid");
            return (Criteria) this;
        }

        public Criteria andHouseidIn(List<String> values) {
            addCriterion("houseid in", values, "houseid");
            return (Criteria) this;
        }

        public Criteria andHouseidNotIn(List<String> values) {
            addCriterion("houseid not in", values, "houseid");
            return (Criteria) this;
        }

        public Criteria andHouseidBetween(String value1, String value2) {
            addCriterion("houseid between", value1, value2, "houseid");
            return (Criteria) this;
        }

        public Criteria andHouseidNotBetween(String value1, String value2) {
            addCriterion("houseid not between", value1, value2, "houseid");
            return (Criteria) this;
        }

        public Criteria andCheckintimeIsNull() {
            addCriterion("checkintime is null");
            return (Criteria) this;
        }

        public Criteria andCheckintimeIsNotNull() {
            addCriterion("checkintime is not null");
            return (Criteria) this;
        }

        public Criteria andCheckintimeEqualTo(Date value) {
            addCriterion("checkintime =", value, "checkintime");
            return (Criteria) this;
        }

        public Criteria andCheckintimeNotEqualTo(Date value) {
            addCriterion("checkintime <>", value, "checkintime");
            return (Criteria) this;
        }

        public Criteria andCheckintimeGreaterThan(Date value) {
            addCriterion("checkintime >", value, "checkintime");
            return (Criteria) this;
        }

        public Criteria andCheckintimeGreaterThanOrEqualTo(Date value) {
            addCriterion("checkintime >=", value, "checkintime");
            return (Criteria) this;
        }

        public Criteria andCheckintimeLessThan(Date value) {
            addCriterion("checkintime <", value, "checkintime");
            return (Criteria) this;
        }

        public Criteria andCheckintimeLessThanOrEqualTo(Date value) {
            addCriterion("checkintime <=", value, "checkintime");
            return (Criteria) this;
        }

        public Criteria andCheckintimeIn(List<Date> values) {
            addCriterion("checkintime in", values, "checkintime");
            return (Criteria) this;
        }

        public Criteria andCheckintimeNotIn(List<Date> values) {
            addCriterion("checkintime not in", values, "checkintime");
            return (Criteria) this;
        }

        public Criteria andCheckintimeBetween(Date value1, Date value2) {
            addCriterion("checkintime between", value1, value2, "checkintime");
            return (Criteria) this;
        }

        public Criteria andCheckintimeNotBetween(Date value1, Date value2) {
            addCriterion("checkintime not between", value1, value2, "checkintime");
            return (Criteria) this;
        }

        public Criteria andDaysIsNull() {
            addCriterion("days is null");
            return (Criteria) this;
        }

        public Criteria andDaysIsNotNull() {
            addCriterion("days is not null");
            return (Criteria) this;
        }

        public Criteria andDaysEqualTo(Integer value) {
            addCriterion("days =", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysNotEqualTo(Integer value) {
            addCriterion("days <>", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysGreaterThan(Integer value) {
            addCriterion("days >", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("days >=", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysLessThan(Integer value) {
            addCriterion("days <", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysLessThanOrEqualTo(Integer value) {
            addCriterion("days <=", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysIn(List<Integer> values) {
            addCriterion("days in", values, "days");
            return (Criteria) this;
        }

        public Criteria andDaysNotIn(List<Integer> values) {
            addCriterion("days not in", values, "days");
            return (Criteria) this;
        }

        public Criteria andDaysBetween(Integer value1, Integer value2) {
            addCriterion("days between", value1, value2, "days");
            return (Criteria) this;
        }

        public Criteria andDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("days not between", value1, value2, "days");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andConditionalIsNull() {
            addCriterion("conditional is null");
            return (Criteria) this;
        }

        public Criteria andConditionalIsNotNull() {
            addCriterion("conditional is not null");
            return (Criteria) this;
        }

        public Criteria andConditionalEqualTo(Integer value) {
            addCriterion("conditional =", value, "conditional");
            return (Criteria) this;
        }

        public Criteria andConditionalNotEqualTo(Integer value) {
            addCriterion("conditional <>", value, "conditional");
            return (Criteria) this;
        }

        public Criteria andConditionalGreaterThan(Integer value) {
            addCriterion("conditional >", value, "conditional");
            return (Criteria) this;
        }

        public Criteria andConditionalGreaterThanOrEqualTo(Integer value) {
            addCriterion("conditional >=", value, "conditional");
            return (Criteria) this;
        }

        public Criteria andConditionalLessThan(Integer value) {
            addCriterion("conditional <", value, "conditional");
            return (Criteria) this;
        }

        public Criteria andConditionalLessThanOrEqualTo(Integer value) {
            addCriterion("conditional <=", value, "conditional");
            return (Criteria) this;
        }

        public Criteria andConditionalIn(List<Integer> values) {
            addCriterion("conditional in", values, "conditional");
            return (Criteria) this;
        }

        public Criteria andConditionalNotIn(List<Integer> values) {
            addCriterion("conditional not in", values, "conditional");
            return (Criteria) this;
        }

        public Criteria andConditionalBetween(Integer value1, Integer value2) {
            addCriterion("conditional between", value1, value2, "conditional");
            return (Criteria) this;
        }

        public Criteria andConditionalNotBetween(Integer value1, Integer value2) {
            addCriterion("conditional not between", value1, value2, "conditional");
            return (Criteria) this;
        }

        public Criteria andOccupantsIsNull() {
            addCriterion("occupants is null");
            return (Criteria) this;
        }

        public Criteria andOccupantsIsNotNull() {
            addCriterion("occupants is not null");
            return (Criteria) this;
        }

        public Criteria andOccupantsEqualTo(String value) {
            addCriterion("occupants =", value, "occupants");
            return (Criteria) this;
        }

        public Criteria andOccupantsNotEqualTo(String value) {
            addCriterion("occupants <>", value, "occupants");
            return (Criteria) this;
        }

        public Criteria andOccupantsGreaterThan(String value) {
            addCriterion("occupants >", value, "occupants");
            return (Criteria) this;
        }

        public Criteria andOccupantsGreaterThanOrEqualTo(String value) {
            addCriterion("occupants >=", value, "occupants");
            return (Criteria) this;
        }

        public Criteria andOccupantsLessThan(String value) {
            addCriterion("occupants <", value, "occupants");
            return (Criteria) this;
        }

        public Criteria andOccupantsLessThanOrEqualTo(String value) {
            addCriterion("occupants <=", value, "occupants");
            return (Criteria) this;
        }

        public Criteria andOccupantsLike(String value) {
            addCriterion("occupants like", value, "occupants");
            return (Criteria) this;
        }

        public Criteria andOccupantsNotLike(String value) {
            addCriterion("occupants not like", value, "occupants");
            return (Criteria) this;
        }

        public Criteria andOccupantsIn(List<String> values) {
            addCriterion("occupants in", values, "occupants");
            return (Criteria) this;
        }

        public Criteria andOccupantsNotIn(List<String> values) {
            addCriterion("occupants not in", values, "occupants");
            return (Criteria) this;
        }

        public Criteria andOccupantsBetween(String value1, String value2) {
            addCriterion("occupants between", value1, value2, "occupants");
            return (Criteria) this;
        }

        public Criteria andOccupantsNotBetween(String value1, String value2) {
            addCriterion("occupants not between", value1, value2, "occupants");
            return (Criteria) this;
        }

        public Criteria andPhonenumIsNull() {
            addCriterion("phonenum is null");
            return (Criteria) this;
        }

        public Criteria andPhonenumIsNotNull() {
            addCriterion("phonenum is not null");
            return (Criteria) this;
        }

        public Criteria andPhonenumEqualTo(String value) {
            addCriterion("phonenum =", value, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumNotEqualTo(String value) {
            addCriterion("phonenum <>", value, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumGreaterThan(String value) {
            addCriterion("phonenum >", value, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumGreaterThanOrEqualTo(String value) {
            addCriterion("phonenum >=", value, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumLessThan(String value) {
            addCriterion("phonenum <", value, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumLessThanOrEqualTo(String value) {
            addCriterion("phonenum <=", value, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumLike(String value) {
            addCriterion("phonenum like", value, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumNotLike(String value) {
            addCriterion("phonenum not like", value, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumIn(List<String> values) {
            addCriterion("phonenum in", values, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumNotIn(List<String> values) {
            addCriterion("phonenum not in", values, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumBetween(String value1, String value2) {
            addCriterion("phonenum between", value1, value2, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumNotBetween(String value1, String value2) {
            addCriterion("phonenum not between", value1, value2, "phonenum");
            return (Criteria) this;
        }

        public Criteria andHousenameIsNull() {
            addCriterion("housename is null");
            return (Criteria) this;
        }

        public Criteria andHousenameIsNotNull() {
            addCriterion("housename is not null");
            return (Criteria) this;
        }

        public Criteria andHousenameEqualTo(String value) {
            addCriterion("housename =", value, "housename");
            return (Criteria) this;
        }

        public Criteria andHousenameNotEqualTo(String value) {
            addCriterion("housename <>", value, "housename");
            return (Criteria) this;
        }

        public Criteria andHousenameGreaterThan(String value) {
            addCriterion("housename >", value, "housename");
            return (Criteria) this;
        }

        public Criteria andHousenameGreaterThanOrEqualTo(String value) {
            addCriterion("housename >=", value, "housename");
            return (Criteria) this;
        }

        public Criteria andHousenameLessThan(String value) {
            addCriterion("housename <", value, "housename");
            return (Criteria) this;
        }

        public Criteria andHousenameLessThanOrEqualTo(String value) {
            addCriterion("housename <=", value, "housename");
            return (Criteria) this;
        }

        public Criteria andHousenameLike(String value) {
            addCriterion("housename like", value, "housename");
            return (Criteria) this;
        }

        public Criteria andHousenameNotLike(String value) {
            addCriterion("housename not like", value, "housename");
            return (Criteria) this;
        }

        public Criteria andHousenameIn(List<String> values) {
            addCriterion("housename in", values, "housename");
            return (Criteria) this;
        }

        public Criteria andHousenameNotIn(List<String> values) {
            addCriterion("housename not in", values, "housename");
            return (Criteria) this;
        }

        public Criteria andHousenameBetween(String value1, String value2) {
            addCriterion("housename between", value1, value2, "housename");
            return (Criteria) this;
        }

        public Criteria andHousenameNotBetween(String value1, String value2) {
            addCriterion("housename not between", value1, value2, "housename");
            return (Criteria) this;
        }

        public Criteria andUsercancelconditionIsNull() {
            addCriterion("usercancelcondition is null");
            return (Criteria) this;
        }

        public Criteria andUsercancelconditionIsNotNull() {
            addCriterion("usercancelcondition is not null");
            return (Criteria) this;
        }

        public Criteria andUsercancelconditionEqualTo(Integer value) {
            addCriterion("usercancelcondition =", value, "usercancelcondition");
            return (Criteria) this;
        }

        public Criteria andUsercancelconditionNotEqualTo(Integer value) {
            addCriterion("usercancelcondition <>", value, "usercancelcondition");
            return (Criteria) this;
        }

        public Criteria andUsercancelconditionGreaterThan(Integer value) {
            addCriterion("usercancelcondition >", value, "usercancelcondition");
            return (Criteria) this;
        }

        public Criteria andUsercancelconditionGreaterThanOrEqualTo(Integer value) {
            addCriterion("usercancelcondition >=", value, "usercancelcondition");
            return (Criteria) this;
        }

        public Criteria andUsercancelconditionLessThan(Integer value) {
            addCriterion("usercancelcondition <", value, "usercancelcondition");
            return (Criteria) this;
        }

        public Criteria andUsercancelconditionLessThanOrEqualTo(Integer value) {
            addCriterion("usercancelcondition <=", value, "usercancelcondition");
            return (Criteria) this;
        }

        public Criteria andUsercancelconditionIn(List<Integer> values) {
            addCriterion("usercancelcondition in", values, "usercancelcondition");
            return (Criteria) this;
        }

        public Criteria andUsercancelconditionNotIn(List<Integer> values) {
            addCriterion("usercancelcondition not in", values, "usercancelcondition");
            return (Criteria) this;
        }

        public Criteria andUsercancelconditionBetween(Integer value1, Integer value2) {
            addCriterion("usercancelcondition between", value1, value2, "usercancelcondition");
            return (Criteria) this;
        }

        public Criteria andUsercancelconditionNotBetween(Integer value1, Integer value2) {
            addCriterion("usercancelcondition not between", value1, value2, "usercancelcondition");
            return (Criteria) this;
        }

        public Criteria andOwnercancelconditonIsNull() {
            addCriterion("ownercancelconditon is null");
            return (Criteria) this;
        }

        public Criteria andOwnercancelconditonIsNotNull() {
            addCriterion("ownercancelconditon is not null");
            return (Criteria) this;
        }

        public Criteria andOwnercancelconditonEqualTo(Integer value) {
            addCriterion("ownercancelconditon =", value, "ownercancelconditon");
            return (Criteria) this;
        }

        public Criteria andOwnercancelconditonNotEqualTo(Integer value) {
            addCriterion("ownercancelconditon <>", value, "ownercancelconditon");
            return (Criteria) this;
        }

        public Criteria andOwnercancelconditonGreaterThan(Integer value) {
            addCriterion("ownercancelconditon >", value, "ownercancelconditon");
            return (Criteria) this;
        }

        public Criteria andOwnercancelconditonGreaterThanOrEqualTo(Integer value) {
            addCriterion("ownercancelconditon >=", value, "ownercancelconditon");
            return (Criteria) this;
        }

        public Criteria andOwnercancelconditonLessThan(Integer value) {
            addCriterion("ownercancelconditon <", value, "ownercancelconditon");
            return (Criteria) this;
        }

        public Criteria andOwnercancelconditonLessThanOrEqualTo(Integer value) {
            addCriterion("ownercancelconditon <=", value, "ownercancelconditon");
            return (Criteria) this;
        }

        public Criteria andOwnercancelconditonIn(List<Integer> values) {
            addCriterion("ownercancelconditon in", values, "ownercancelconditon");
            return (Criteria) this;
        }

        public Criteria andOwnercancelconditonNotIn(List<Integer> values) {
            addCriterion("ownercancelconditon not in", values, "ownercancelconditon");
            return (Criteria) this;
        }

        public Criteria andOwnercancelconditonBetween(Integer value1, Integer value2) {
            addCriterion("ownercancelconditon between", value1, value2, "ownercancelconditon");
            return (Criteria) this;
        }

        public Criteria andOwnercancelconditonNotBetween(Integer value1, Integer value2) {
            addCriterion("ownercancelconditon not between", value1, value2, "ownercancelconditon");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}