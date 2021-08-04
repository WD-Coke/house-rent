package com.easyrent.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class HouseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HouseExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andHouseareaIsNull() {
            addCriterion("housearea is null");
            return (Criteria) this;
        }

        public Criteria andHouseareaIsNotNull() {
            addCriterion("housearea is not null");
            return (Criteria) this;
        }

        public Criteria andHouseareaEqualTo(Integer value) {
            addCriterion("housearea =", value, "housearea");
            return (Criteria) this;
        }

        public Criteria andHouseareaNotEqualTo(Integer value) {
            addCriterion("housearea <>", value, "housearea");
            return (Criteria) this;
        }

        public Criteria andHouseareaGreaterThan(Integer value) {
            addCriterion("housearea >", value, "housearea");
            return (Criteria) this;
        }

        public Criteria andHouseareaGreaterThanOrEqualTo(Integer value) {
            addCriterion("housearea >=", value, "housearea");
            return (Criteria) this;
        }

        public Criteria andHouseareaLessThan(Integer value) {
            addCriterion("housearea <", value, "housearea");
            return (Criteria) this;
        }

        public Criteria andHouseareaLessThanOrEqualTo(Integer value) {
            addCriterion("housearea <=", value, "housearea");
            return (Criteria) this;
        }

        public Criteria andHouseareaIn(List<Integer> values) {
            addCriterion("housearea in", values, "housearea");
            return (Criteria) this;
        }

        public Criteria andHouseareaNotIn(List<Integer> values) {
            addCriterion("housearea not in", values, "housearea");
            return (Criteria) this;
        }

        public Criteria andHouseareaBetween(Integer value1, Integer value2) {
            addCriterion("housearea between", value1, value2, "housearea");
            return (Criteria) this;
        }

        public Criteria andHouseareaNotBetween(Integer value1, Integer value2) {
            addCriterion("housearea not between", value1, value2, "housearea");
            return (Criteria) this;
        }

        public Criteria andHouseminIsNull() {
            addCriterion("housemin is null");
            return (Criteria) this;
        }

        public Criteria andHouseminIsNotNull() {
            addCriterion("housemin is not null");
            return (Criteria) this;
        }

        public Criteria andHouseminEqualTo(Integer value) {
            addCriterion("housemin =", value, "housemin");
            return (Criteria) this;
        }

        public Criteria andHouseminNotEqualTo(Integer value) {
            addCriterion("housemin <>", value, "housemin");
            return (Criteria) this;
        }

        public Criteria andHouseminGreaterThan(Integer value) {
            addCriterion("housemin >", value, "housemin");
            return (Criteria) this;
        }

        public Criteria andHouseminGreaterThanOrEqualTo(Integer value) {
            addCriterion("housemin >=", value, "housemin");
            return (Criteria) this;
        }

        public Criteria andHouseminLessThan(Integer value) {
            addCriterion("housemin <", value, "housemin");
            return (Criteria) this;
        }

        public Criteria andHouseminLessThanOrEqualTo(Integer value) {
            addCriterion("housemin <=", value, "housemin");
            return (Criteria) this;
        }

        public Criteria andHouseminIn(List<Integer> values) {
            addCriterion("housemin in", values, "housemin");
            return (Criteria) this;
        }

        public Criteria andHouseminNotIn(List<Integer> values) {
            addCriterion("housemin not in", values, "housemin");
            return (Criteria) this;
        }

        public Criteria andHouseminBetween(Integer value1, Integer value2) {
            addCriterion("housemin between", value1, value2, "housemin");
            return (Criteria) this;
        }

        public Criteria andHouseminNotBetween(Integer value1, Integer value2) {
            addCriterion("housemin not between", value1, value2, "housemin");
            return (Criteria) this;
        }

        public Criteria andHousemaxIsNull() {
            addCriterion("housemax is null");
            return (Criteria) this;
        }

        public Criteria andHousemaxIsNotNull() {
            addCriterion("housemax is not null");
            return (Criteria) this;
        }

        public Criteria andHousemaxEqualTo(Integer value) {
            addCriterion("housemax =", value, "housemax");
            return (Criteria) this;
        }

        public Criteria andHousemaxNotEqualTo(Integer value) {
            addCriterion("housemax <>", value, "housemax");
            return (Criteria) this;
        }

        public Criteria andHousemaxGreaterThan(Integer value) {
            addCriterion("housemax >", value, "housemax");
            return (Criteria) this;
        }

        public Criteria andHousemaxGreaterThanOrEqualTo(Integer value) {
            addCriterion("housemax >=", value, "housemax");
            return (Criteria) this;
        }

        public Criteria andHousemaxLessThan(Integer value) {
            addCriterion("housemax <", value, "housemax");
            return (Criteria) this;
        }

        public Criteria andHousemaxLessThanOrEqualTo(Integer value) {
            addCriterion("housemax <=", value, "housemax");
            return (Criteria) this;
        }

        public Criteria andHousemaxIn(List<Integer> values) {
            addCriterion("housemax in", values, "housemax");
            return (Criteria) this;
        }

        public Criteria andHousemaxNotIn(List<Integer> values) {
            addCriterion("housemax not in", values, "housemax");
            return (Criteria) this;
        }

        public Criteria andHousemaxBetween(Integer value1, Integer value2) {
            addCriterion("housemax between", value1, value2, "housemax");
            return (Criteria) this;
        }

        public Criteria andHousemaxNotBetween(Integer value1, Integer value2) {
            addCriterion("housemax not between", value1, value2, "housemax");
            return (Criteria) this;
        }

        public Criteria andHouserentIsNull() {
            addCriterion("houserent is null");
            return (Criteria) this;
        }

        public Criteria andHouserentIsNotNull() {
            addCriterion("houserent is not null");
            return (Criteria) this;
        }

        public Criteria andHouserentEqualTo(Integer value) {
            addCriterion("houserent =", value, "houserent");
            return (Criteria) this;
        }

        public Criteria andHouserentNotEqualTo(Integer value) {
            addCriterion("houserent <>", value, "houserent");
            return (Criteria) this;
        }

        public Criteria andHouserentGreaterThan(Integer value) {
            addCriterion("houserent >", value, "houserent");
            return (Criteria) this;
        }

        public Criteria andHouserentGreaterThanOrEqualTo(Integer value) {
            addCriterion("houserent >=", value, "houserent");
            return (Criteria) this;
        }

        public Criteria andHouserentLessThan(Integer value) {
            addCriterion("houserent <", value, "houserent");
            return (Criteria) this;
        }

        public Criteria andHouserentLessThanOrEqualTo(Integer value) {
            addCriterion("houserent <=", value, "houserent");
            return (Criteria) this;
        }

        public Criteria andHouserentIn(List<Integer> values) {
            addCriterion("houserent in", values, "houserent");
            return (Criteria) this;
        }

        public Criteria andHouserentNotIn(List<Integer> values) {
            addCriterion("houserent not in", values, "houserent");
            return (Criteria) this;
        }

        public Criteria andHouserentBetween(Integer value1, Integer value2) {
            addCriterion("houserent between", value1, value2, "houserent");
            return (Criteria) this;
        }

        public Criteria andHouserentNotBetween(Integer value1, Integer value2) {
            addCriterion("houserent not between", value1, value2, "houserent");
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

        public Criteria andHousedescribeIsNull() {
            addCriterion("housedescribe is null");
            return (Criteria) this;
        }

        public Criteria andHousedescribeIsNotNull() {
            addCriterion("housedescribe is not null");
            return (Criteria) this;
        }

        public Criteria andHousedescribeEqualTo(String value) {
            addCriterion("housedescribe =", value, "housedescribe");
            return (Criteria) this;
        }

        public Criteria andHousedescribeNotEqualTo(String value) {
            addCriterion("housedescribe <>", value, "housedescribe");
            return (Criteria) this;
        }

        public Criteria andHousedescribeGreaterThan(String value) {
            addCriterion("housedescribe >", value, "housedescribe");
            return (Criteria) this;
        }

        public Criteria andHousedescribeGreaterThanOrEqualTo(String value) {
            addCriterion("housedescribe >=", value, "housedescribe");
            return (Criteria) this;
        }

        public Criteria andHousedescribeLessThan(String value) {
            addCriterion("housedescribe <", value, "housedescribe");
            return (Criteria) this;
        }

        public Criteria andHousedescribeLessThanOrEqualTo(String value) {
            addCriterion("housedescribe <=", value, "housedescribe");
            return (Criteria) this;
        }

        public Criteria andHousedescribeLike(String value) {
            addCriterion("housedescribe like", value, "housedescribe");
            return (Criteria) this;
        }

        public Criteria andHousedescribeNotLike(String value) {
            addCriterion("housedescribe not like", value, "housedescribe");
            return (Criteria) this;
        }

        public Criteria andHousedescribeIn(List<String> values) {
            addCriterion("housedescribe in", values, "housedescribe");
            return (Criteria) this;
        }

        public Criteria andHousedescribeNotIn(List<String> values) {
            addCriterion("housedescribe not in", values, "housedescribe");
            return (Criteria) this;
        }

        public Criteria andHousedescribeBetween(String value1, String value2) {
            addCriterion("housedescribe between", value1, value2, "housedescribe");
            return (Criteria) this;
        }

        public Criteria andHousedescribeNotBetween(String value1, String value2) {
            addCriterion("housedescribe not between", value1, value2, "housedescribe");
            return (Criteria) this;
        }

        public Criteria andHouseaddressIsNull() {
            addCriterion("houseaddress is null");
            return (Criteria) this;
        }

        public Criteria andHouseaddressIsNotNull() {
            addCriterion("houseaddress is not null");
            return (Criteria) this;
        }

        public Criteria andHouseaddressEqualTo(String value) {
            addCriterion("houseaddress =", value, "houseaddress");
            return (Criteria) this;
        }

        public Criteria andHouseaddressNotEqualTo(String value) {
            addCriterion("houseaddress <>", value, "houseaddress");
            return (Criteria) this;
        }

        public Criteria andHouseaddressGreaterThan(String value) {
            addCriterion("houseaddress >", value, "houseaddress");
            return (Criteria) this;
        }

        public Criteria andHouseaddressGreaterThanOrEqualTo(String value) {
            addCriterion("houseaddress >=", value, "houseaddress");
            return (Criteria) this;
        }

        public Criteria andHouseaddressLessThan(String value) {
            addCriterion("houseaddress <", value, "houseaddress");
            return (Criteria) this;
        }

        public Criteria andHouseaddressLessThanOrEqualTo(String value) {
            addCriterion("houseaddress <=", value, "houseaddress");
            return (Criteria) this;
        }

        public Criteria andHouseaddressLike(String value) {
            addCriterion("houseaddress like", value, "houseaddress");
            return (Criteria) this;
        }

        public Criteria andHouseaddressNotLike(String value) {
            addCriterion("houseaddress not like", value, "houseaddress");
            return (Criteria) this;
        }

        public Criteria andHouseaddressIn(List<String> values) {
            addCriterion("houseaddress in", values, "houseaddress");
            return (Criteria) this;
        }

        public Criteria andHouseaddressNotIn(List<String> values) {
            addCriterion("houseaddress not in", values, "houseaddress");
            return (Criteria) this;
        }

        public Criteria andHouseaddressBetween(String value1, String value2) {
            addCriterion("houseaddress between", value1, value2, "houseaddress");
            return (Criteria) this;
        }

        public Criteria andHouseaddressNotBetween(String value1, String value2) {
            addCriterion("houseaddress not between", value1, value2, "houseaddress");
            return (Criteria) this;
        }

        public Criteria andHousetypeIsNull() {
            addCriterion("housetype is null");
            return (Criteria) this;
        }

        public Criteria andHousetypeIsNotNull() {
            addCriterion("housetype is not null");
            return (Criteria) this;
        }

        public Criteria andHousetypeEqualTo(String value) {
            addCriterion("housetype =", value, "housetype");
            return (Criteria) this;
        }

        public Criteria andHousetypeNotEqualTo(String value) {
            addCriterion("housetype <>", value, "housetype");
            return (Criteria) this;
        }

        public Criteria andHousetypeGreaterThan(String value) {
            addCriterion("housetype >", value, "housetype");
            return (Criteria) this;
        }

        public Criteria andHousetypeGreaterThanOrEqualTo(String value) {
            addCriterion("housetype >=", value, "housetype");
            return (Criteria) this;
        }

        public Criteria andHousetypeLessThan(String value) {
            addCriterion("housetype <", value, "housetype");
            return (Criteria) this;
        }

        public Criteria andHousetypeLessThanOrEqualTo(String value) {
            addCriterion("housetype <=", value, "housetype");
            return (Criteria) this;
        }

        public Criteria andHousetypeLike(String value) {
            addCriterion("housetype like", value, "housetype");
            return (Criteria) this;
        }

        public Criteria andHousetypeNotLike(String value) {
            addCriterion("housetype not like", value, "housetype");
            return (Criteria) this;
        }

        public Criteria andHousetypeIn(List<String> values) {
            addCriterion("housetype in", values, "housetype");
            return (Criteria) this;
        }

        public Criteria andHousetypeNotIn(List<String> values) {
            addCriterion("housetype not in", values, "housetype");
            return (Criteria) this;
        }

        public Criteria andHousetypeBetween(String value1, String value2) {
            addCriterion("housetype between", value1, value2, "housetype");
            return (Criteria) this;
        }

        public Criteria andHousetypeNotBetween(String value1, String value2) {
            addCriterion("housetype not between", value1, value2, "housetype");
            return (Criteria) this;
        }

        public Criteria andHouselimitIsNull() {
            addCriterion("houselimit is null");
            return (Criteria) this;
        }

        public Criteria andHouselimitIsNotNull() {
            addCriterion("houselimit is not null");
            return (Criteria) this;
        }

        public Criteria andHouselimitEqualTo(Integer value) {
            addCriterion("houselimit =", value, "houselimit");
            return (Criteria) this;
        }

        public Criteria andHouselimitNotEqualTo(Integer value) {
            addCriterion("houselimit <>", value, "houselimit");
            return (Criteria) this;
        }

        public Criteria andHouselimitGreaterThan(Integer value) {
            addCriterion("houselimit >", value, "houselimit");
            return (Criteria) this;
        }

        public Criteria andHouselimitGreaterThanOrEqualTo(Integer value) {
            addCriterion("houselimit >=", value, "houselimit");
            return (Criteria) this;
        }

        public Criteria andHouselimitLessThan(Integer value) {
            addCriterion("houselimit <", value, "houselimit");
            return (Criteria) this;
        }

        public Criteria andHouselimitLessThanOrEqualTo(Integer value) {
            addCriterion("houselimit <=", value, "houselimit");
            return (Criteria) this;
        }

        public Criteria andHouselimitIn(List<Integer> values) {
            addCriterion("houselimit in", values, "houselimit");
            return (Criteria) this;
        }

        public Criteria andHouselimitNotIn(List<Integer> values) {
            addCriterion("houselimit not in", values, "houselimit");
            return (Criteria) this;
        }

        public Criteria andHouselimitBetween(Integer value1, Integer value2) {
            addCriterion("houselimit between", value1, value2, "houselimit");
            return (Criteria) this;
        }

        public Criteria andHouselimitNotBetween(Integer value1, Integer value2) {
            addCriterion("houselimit not between", value1, value2, "houselimit");
            return (Criteria) this;
        }

        public Criteria andHouseroomIsNull() {
            addCriterion("houseroom is null");
            return (Criteria) this;
        }

        public Criteria andHouseroomIsNotNull() {
            addCriterion("houseroom is not null");
            return (Criteria) this;
        }

        public Criteria andHouseroomEqualTo(String value) {
            addCriterion("houseroom =", value, "houseroom");
            return (Criteria) this;
        }

        public Criteria andHouseroomNotEqualTo(String value) {
            addCriterion("houseroom <>", value, "houseroom");
            return (Criteria) this;
        }

        public Criteria andHouseroomGreaterThan(String value) {
            addCriterion("houseroom >", value, "houseroom");
            return (Criteria) this;
        }

        public Criteria andHouseroomGreaterThanOrEqualTo(String value) {
            addCriterion("houseroom >=", value, "houseroom");
            return (Criteria) this;
        }

        public Criteria andHouseroomLessThan(String value) {
            addCriterion("houseroom <", value, "houseroom");
            return (Criteria) this;
        }

        public Criteria andHouseroomLessThanOrEqualTo(String value) {
            addCriterion("houseroom <=", value, "houseroom");
            return (Criteria) this;
        }

        public Criteria andHouseroomLike(String value) {
            addCriterion("houseroom like", value, "houseroom");
            return (Criteria) this;
        }

        public Criteria andHouseroomNotLike(String value) {
            addCriterion("houseroom not like", value, "houseroom");
            return (Criteria) this;
        }

        public Criteria andHouseroomIn(List<String> values) {
            addCriterion("houseroom in", values, "houseroom");
            return (Criteria) this;
        }

        public Criteria andHouseroomNotIn(List<String> values) {
            addCriterion("houseroom not in", values, "houseroom");
            return (Criteria) this;
        }

        public Criteria andHouseroomBetween(String value1, String value2) {
            addCriterion("houseroom between", value1, value2, "houseroom");
            return (Criteria) this;
        }

        public Criteria andHouseroomNotBetween(String value1, String value2) {
            addCriterion("houseroom not between", value1, value2, "houseroom");
            return (Criteria) this;
        }

        public Criteria andHouserefundIsNull() {
            addCriterion("houserefund is null");
            return (Criteria) this;
        }

        public Criteria andHouserefundIsNotNull() {
            addCriterion("houserefund is not null");
            return (Criteria) this;
        }

        public Criteria andHouserefundEqualTo(String value) {
            addCriterion("houserefund =", value, "houserefund");
            return (Criteria) this;
        }

        public Criteria andHouserefundNotEqualTo(String value) {
            addCriterion("houserefund <>", value, "houserefund");
            return (Criteria) this;
        }

        public Criteria andHouserefundGreaterThan(String value) {
            addCriterion("houserefund >", value, "houserefund");
            return (Criteria) this;
        }

        public Criteria andHouserefundGreaterThanOrEqualTo(String value) {
            addCriterion("houserefund >=", value, "houserefund");
            return (Criteria) this;
        }

        public Criteria andHouserefundLessThan(String value) {
            addCriterion("houserefund <", value, "houserefund");
            return (Criteria) this;
        }

        public Criteria andHouserefundLessThanOrEqualTo(String value) {
            addCriterion("houserefund <=", value, "houserefund");
            return (Criteria) this;
        }

        public Criteria andHouserefundLike(String value) {
            addCriterion("houserefund like", value, "houserefund");
            return (Criteria) this;
        }

        public Criteria andHouserefundNotLike(String value) {
            addCriterion("houserefund not like", value, "houserefund");
            return (Criteria) this;
        }

        public Criteria andHouserefundIn(List<String> values) {
            addCriterion("houserefund in", values, "houserefund");
            return (Criteria) this;
        }

        public Criteria andHouserefundNotIn(List<String> values) {
            addCriterion("houserefund not in", values, "houserefund");
            return (Criteria) this;
        }

        public Criteria andHouserefundBetween(String value1, String value2) {
            addCriterion("houserefund between", value1, value2, "houserefund");
            return (Criteria) this;
        }

        public Criteria andHouserefundNotBetween(String value1, String value2) {
            addCriterion("houserefund not between", value1, value2, "houserefund");
            return (Criteria) this;
        }

        public Criteria andHousemainpicIsNull() {
            addCriterion("housemainpic is null");
            return (Criteria) this;
        }

        public Criteria andHousemainpicIsNotNull() {
            addCriterion("housemainpic is not null");
            return (Criteria) this;
        }

        public Criteria andHousemainpicEqualTo(String value) {
            addCriterion("housemainpic =", value, "housemainpic");
            return (Criteria) this;
        }

        public Criteria andHousemainpicNotEqualTo(String value) {
            addCriterion("housemainpic <>", value, "housemainpic");
            return (Criteria) this;
        }

        public Criteria andHousemainpicGreaterThan(String value) {
            addCriterion("housemainpic >", value, "housemainpic");
            return (Criteria) this;
        }

        public Criteria andHousemainpicGreaterThanOrEqualTo(String value) {
            addCriterion("housemainpic >=", value, "housemainpic");
            return (Criteria) this;
        }

        public Criteria andHousemainpicLessThan(String value) {
            addCriterion("housemainpic <", value, "housemainpic");
            return (Criteria) this;
        }

        public Criteria andHousemainpicLessThanOrEqualTo(String value) {
            addCriterion("housemainpic <=", value, "housemainpic");
            return (Criteria) this;
        }

        public Criteria andHousemainpicLike(String value) {
            addCriterion("housemainpic like", value, "housemainpic");
            return (Criteria) this;
        }

        public Criteria andHousemainpicNotLike(String value) {
            addCriterion("housemainpic not like", value, "housemainpic");
            return (Criteria) this;
        }

        public Criteria andHousemainpicIn(List<String> values) {
            addCriterion("housemainpic in", values, "housemainpic");
            return (Criteria) this;
        }

        public Criteria andHousemainpicNotIn(List<String> values) {
            addCriterion("housemainpic not in", values, "housemainpic");
            return (Criteria) this;
        }

        public Criteria andHousemainpicBetween(String value1, String value2) {
            addCriterion("housemainpic between", value1, value2, "housemainpic");
            return (Criteria) this;
        }

        public Criteria andHousemainpicNotBetween(String value1, String value2) {
            addCriterion("housemainpic not between", value1, value2, "housemainpic");
            return (Criteria) this;
        }

        public Criteria andHousestateIsNull() {
            addCriterion("housestate is null");
            return (Criteria) this;
        }

        public Criteria andHousestateIsNotNull() {
            addCriterion("housestate is not null");
            return (Criteria) this;
        }

        public Criteria andHousestateEqualTo(Integer value) {
            addCriterion("housestate =", value, "housestate");
            return (Criteria) this;
        }

        public Criteria andHousestateNotEqualTo(Integer value) {
            addCriterion("housestate <>", value, "housestate");
            return (Criteria) this;
        }

        public Criteria andHousestateGreaterThan(Integer value) {
            addCriterion("housestate >", value, "housestate");
            return (Criteria) this;
        }

        public Criteria andHousestateGreaterThanOrEqualTo(Integer value) {
            addCriterion("housestate >=", value, "housestate");
            return (Criteria) this;
        }

        public Criteria andHousestateLessThan(Integer value) {
            addCriterion("housestate <", value, "housestate");
            return (Criteria) this;
        }

        public Criteria andHousestateLessThanOrEqualTo(Integer value) {
            addCriterion("housestate <=", value, "housestate");
            return (Criteria) this;
        }

        public Criteria andHousestateIn(List<Integer> values) {
            addCriterion("housestate in", values, "housestate");
            return (Criteria) this;
        }

        public Criteria andHousestateNotIn(List<Integer> values) {
            addCriterion("housestate not in", values, "housestate");
            return (Criteria) this;
        }

        public Criteria andHousestateBetween(Integer value1, Integer value2) {
            addCriterion("housestate between", value1, value2, "housestate");
            return (Criteria) this;
        }

        public Criteria andHousestateNotBetween(Integer value1, Integer value2) {
            addCriterion("housestate not between", value1, value2, "housestate");
            return (Criteria) this;
        }

        public Criteria andPic1IsNull() {
            addCriterion("pic1 is null");
            return (Criteria) this;
        }

        public Criteria andPic1IsNotNull() {
            addCriterion("pic1 is not null");
            return (Criteria) this;
        }

        public Criteria andPic1EqualTo(String value) {
            addCriterion("pic1 =", value, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1NotEqualTo(String value) {
            addCriterion("pic1 <>", value, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1GreaterThan(String value) {
            addCriterion("pic1 >", value, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1GreaterThanOrEqualTo(String value) {
            addCriterion("pic1 >=", value, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1LessThan(String value) {
            addCriterion("pic1 <", value, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1LessThanOrEqualTo(String value) {
            addCriterion("pic1 <=", value, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1Like(String value) {
            addCriterion("pic1 like", value, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1NotLike(String value) {
            addCriterion("pic1 not like", value, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1In(List<String> values) {
            addCriterion("pic1 in", values, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1NotIn(List<String> values) {
            addCriterion("pic1 not in", values, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1Between(String value1, String value2) {
            addCriterion("pic1 between", value1, value2, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1NotBetween(String value1, String value2) {
            addCriterion("pic1 not between", value1, value2, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic2IsNull() {
            addCriterion("pic2 is null");
            return (Criteria) this;
        }

        public Criteria andPic2IsNotNull() {
            addCriterion("pic2 is not null");
            return (Criteria) this;
        }

        public Criteria andPic2EqualTo(String value) {
            addCriterion("pic2 =", value, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2NotEqualTo(String value) {
            addCriterion("pic2 <>", value, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2GreaterThan(String value) {
            addCriterion("pic2 >", value, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2GreaterThanOrEqualTo(String value) {
            addCriterion("pic2 >=", value, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2LessThan(String value) {
            addCriterion("pic2 <", value, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2LessThanOrEqualTo(String value) {
            addCriterion("pic2 <=", value, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2Like(String value) {
            addCriterion("pic2 like", value, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2NotLike(String value) {
            addCriterion("pic2 not like", value, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2In(List<String> values) {
            addCriterion("pic2 in", values, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2NotIn(List<String> values) {
            addCriterion("pic2 not in", values, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2Between(String value1, String value2) {
            addCriterion("pic2 between", value1, value2, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2NotBetween(String value1, String value2) {
            addCriterion("pic2 not between", value1, value2, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic3IsNull() {
            addCriterion("pic3 is null");
            return (Criteria) this;
        }

        public Criteria andPic3IsNotNull() {
            addCriterion("pic3 is not null");
            return (Criteria) this;
        }

        public Criteria andPic3EqualTo(String value) {
            addCriterion("pic3 =", value, "pic3");
            return (Criteria) this;
        }

        public Criteria andPic3NotEqualTo(String value) {
            addCriterion("pic3 <>", value, "pic3");
            return (Criteria) this;
        }

        public Criteria andPic3GreaterThan(String value) {
            addCriterion("pic3 >", value, "pic3");
            return (Criteria) this;
        }

        public Criteria andPic3GreaterThanOrEqualTo(String value) {
            addCriterion("pic3 >=", value, "pic3");
            return (Criteria) this;
        }

        public Criteria andPic3LessThan(String value) {
            addCriterion("pic3 <", value, "pic3");
            return (Criteria) this;
        }

        public Criteria andPic3LessThanOrEqualTo(String value) {
            addCriterion("pic3 <=", value, "pic3");
            return (Criteria) this;
        }

        public Criteria andPic3Like(String value) {
            addCriterion("pic3 like", value, "pic3");
            return (Criteria) this;
        }

        public Criteria andPic3NotLike(String value) {
            addCriterion("pic3 not like", value, "pic3");
            return (Criteria) this;
        }

        public Criteria andPic3In(List<String> values) {
            addCriterion("pic3 in", values, "pic3");
            return (Criteria) this;
        }

        public Criteria andPic3NotIn(List<String> values) {
            addCriterion("pic3 not in", values, "pic3");
            return (Criteria) this;
        }

        public Criteria andPic3Between(String value1, String value2) {
            addCriterion("pic3 between", value1, value2, "pic3");
            return (Criteria) this;
        }

        public Criteria andPic3NotBetween(String value1, String value2) {
            addCriterion("pic3 not between", value1, value2, "pic3");
            return (Criteria) this;
        }

        public Criteria andPic4IsNull() {
            addCriterion("pic4 is null");
            return (Criteria) this;
        }

        public Criteria andPic4IsNotNull() {
            addCriterion("pic4 is not null");
            return (Criteria) this;
        }

        public Criteria andPic4EqualTo(String value) {
            addCriterion("pic4 =", value, "pic4");
            return (Criteria) this;
        }

        public Criteria andPic4NotEqualTo(String value) {
            addCriterion("pic4 <>", value, "pic4");
            return (Criteria) this;
        }

        public Criteria andPic4GreaterThan(String value) {
            addCriterion("pic4 >", value, "pic4");
            return (Criteria) this;
        }

        public Criteria andPic4GreaterThanOrEqualTo(String value) {
            addCriterion("pic4 >=", value, "pic4");
            return (Criteria) this;
        }

        public Criteria andPic4LessThan(String value) {
            addCriterion("pic4 <", value, "pic4");
            return (Criteria) this;
        }

        public Criteria andPic4LessThanOrEqualTo(String value) {
            addCriterion("pic4 <=", value, "pic4");
            return (Criteria) this;
        }

        public Criteria andPic4Like(String value) {
            addCriterion("pic4 like", value, "pic4");
            return (Criteria) this;
        }

        public Criteria andPic4NotLike(String value) {
            addCriterion("pic4 not like", value, "pic4");
            return (Criteria) this;
        }

        public Criteria andPic4In(List<String> values) {
            addCriterion("pic4 in", values, "pic4");
            return (Criteria) this;
        }

        public Criteria andPic4NotIn(List<String> values) {
            addCriterion("pic4 not in", values, "pic4");
            return (Criteria) this;
        }

        public Criteria andPic4Between(String value1, String value2) {
            addCriterion("pic4 between", value1, value2, "pic4");
            return (Criteria) this;
        }

        public Criteria andPic4NotBetween(String value1, String value2) {
            addCriterion("pic4 not between", value1, value2, "pic4");
            return (Criteria) this;
        }

        public Criteria andPic5IsNull() {
            addCriterion("pic5 is null");
            return (Criteria) this;
        }

        public Criteria andPic5IsNotNull() {
            addCriterion("pic5 is not null");
            return (Criteria) this;
        }

        public Criteria andPic5EqualTo(String value) {
            addCriterion("pic5 =", value, "pic5");
            return (Criteria) this;
        }

        public Criteria andPic5NotEqualTo(String value) {
            addCriterion("pic5 <>", value, "pic5");
            return (Criteria) this;
        }

        public Criteria andPic5GreaterThan(String value) {
            addCriterion("pic5 >", value, "pic5");
            return (Criteria) this;
        }

        public Criteria andPic5GreaterThanOrEqualTo(String value) {
            addCriterion("pic5 >=", value, "pic5");
            return (Criteria) this;
        }

        public Criteria andPic5LessThan(String value) {
            addCriterion("pic5 <", value, "pic5");
            return (Criteria) this;
        }

        public Criteria andPic5LessThanOrEqualTo(String value) {
            addCriterion("pic5 <=", value, "pic5");
            return (Criteria) this;
        }

        public Criteria andPic5Like(String value) {
            addCriterion("pic5 like", value, "pic5");
            return (Criteria) this;
        }

        public Criteria andPic5NotLike(String value) {
            addCriterion("pic5 not like", value, "pic5");
            return (Criteria) this;
        }

        public Criteria andPic5In(List<String> values) {
            addCriterion("pic5 in", values, "pic5");
            return (Criteria) this;
        }

        public Criteria andPic5NotIn(List<String> values) {
            addCriterion("pic5 not in", values, "pic5");
            return (Criteria) this;
        }

        public Criteria andPic5Between(String value1, String value2) {
            addCriterion("pic5 between", value1, value2, "pic5");
            return (Criteria) this;
        }

        public Criteria andPic5NotBetween(String value1, String value2) {
            addCriterion("pic5 not between", value1, value2, "pic5");
            return (Criteria) this;
        }

        public Criteria andPic6IsNull() {
            addCriterion("pic6 is null");
            return (Criteria) this;
        }

        public Criteria andPic6IsNotNull() {
            addCriterion("pic6 is not null");
            return (Criteria) this;
        }

        public Criteria andPic6EqualTo(String value) {
            addCriterion("pic6 =", value, "pic6");
            return (Criteria) this;
        }

        public Criteria andPic6NotEqualTo(String value) {
            addCriterion("pic6 <>", value, "pic6");
            return (Criteria) this;
        }

        public Criteria andPic6GreaterThan(String value) {
            addCriterion("pic6 >", value, "pic6");
            return (Criteria) this;
        }

        public Criteria andPic6GreaterThanOrEqualTo(String value) {
            addCriterion("pic6 >=", value, "pic6");
            return (Criteria) this;
        }

        public Criteria andPic6LessThan(String value) {
            addCriterion("pic6 <", value, "pic6");
            return (Criteria) this;
        }

        public Criteria andPic6LessThanOrEqualTo(String value) {
            addCriterion("pic6 <=", value, "pic6");
            return (Criteria) this;
        }

        public Criteria andPic6Like(String value) {
            addCriterion("pic6 like", value, "pic6");
            return (Criteria) this;
        }

        public Criteria andPic6NotLike(String value) {
            addCriterion("pic6 not like", value, "pic6");
            return (Criteria) this;
        }

        public Criteria andPic6In(List<String> values) {
            addCriterion("pic6 in", values, "pic6");
            return (Criteria) this;
        }

        public Criteria andPic6NotIn(List<String> values) {
            addCriterion("pic6 not in", values, "pic6");
            return (Criteria) this;
        }

        public Criteria andPic6Between(String value1, String value2) {
            addCriterion("pic6 between", value1, value2, "pic6");
            return (Criteria) this;
        }

        public Criteria andPic6NotBetween(String value1, String value2) {
            addCriterion("pic6 not between", value1, value2, "pic6");
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

        public Criteria andHousecreateIsNull() {
            addCriterion("housecreate is null");
            return (Criteria) this;
        }

        public Criteria andHousecreateIsNotNull() {
            addCriterion("housecreate is not null");
            return (Criteria) this;
        }

        public Criteria andHousecreateEqualTo(Date value) {
            addCriterionForJDBCDate("housecreate =", value, "housecreate");
            return (Criteria) this;
        }

        public Criteria andHousecreateNotEqualTo(Date value) {
            addCriterionForJDBCDate("housecreate <>", value, "housecreate");
            return (Criteria) this;
        }

        public Criteria andHousecreateGreaterThan(Date value) {
            addCriterionForJDBCDate("housecreate >", value, "housecreate");
            return (Criteria) this;
        }

        public Criteria andHousecreateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("housecreate >=", value, "housecreate");
            return (Criteria) this;
        }

        public Criteria andHousecreateLessThan(Date value) {
            addCriterionForJDBCDate("housecreate <", value, "housecreate");
            return (Criteria) this;
        }

        public Criteria andHousecreateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("housecreate <=", value, "housecreate");
            return (Criteria) this;
        }

        public Criteria andHousecreateIn(List<Date> values) {
            addCriterionForJDBCDate("housecreate in", values, "housecreate");
            return (Criteria) this;
        }

        public Criteria andHousecreateNotIn(List<Date> values) {
            addCriterionForJDBCDate("housecreate not in", values, "housecreate");
            return (Criteria) this;
        }

        public Criteria andHousecreateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("housecreate between", value1, value2, "housecreate");
            return (Criteria) this;
        }

        public Criteria andHousecreateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("housecreate not between", value1, value2, "housecreate");
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