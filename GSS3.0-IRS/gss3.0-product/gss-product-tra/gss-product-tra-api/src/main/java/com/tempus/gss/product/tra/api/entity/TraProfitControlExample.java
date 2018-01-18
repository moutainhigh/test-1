package com.tempus.gss.product.tra.api.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TraProfitControlExample   {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table TRA_PROFIT_CONTROL
     *
     * @mbggenerated Fri Feb 24 15:34:26 CST 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table TRA_PROFIT_CONTROL
     *
     * @mbggenerated Fri Feb 24 15:34:26 CST 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table TRA_PROFIT_CONTROL
     *
     * @mbggenerated Fri Feb 24 15:34:26 CST 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRA_PROFIT_CONTROL
     *
     * @mbggenerated Fri Feb 24 15:34:26 CST 2017
     */
    public TraProfitControlExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRA_PROFIT_CONTROL
     *
     * @mbggenerated Fri Feb 24 15:34:26 CST 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRA_PROFIT_CONTROL
     *
     * @mbggenerated Fri Feb 24 15:34:26 CST 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRA_PROFIT_CONTROL
     *
     * @mbggenerated Fri Feb 24 15:34:26 CST 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRA_PROFIT_CONTROL
     *
     * @mbggenerated Fri Feb 24 15:34:26 CST 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRA_PROFIT_CONTROL
     *
     * @mbggenerated Fri Feb 24 15:34:26 CST 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRA_PROFIT_CONTROL
     *
     * @mbggenerated Fri Feb 24 15:34:26 CST 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRA_PROFIT_CONTROL
     *
     * @mbggenerated Fri Feb 24 15:34:26 CST 2017
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRA_PROFIT_CONTROL
     *
     * @mbggenerated Fri Feb 24 15:34:26 CST 2017
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRA_PROFIT_CONTROL
     *
     * @mbggenerated Fri Feb 24 15:34:26 CST 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRA_PROFIT_CONTROL
     *
     * @mbggenerated Fri Feb 24 15:34:26 CST 2017
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TRA_PROFIT_CONTROL
     *
     * @mbggenerated Fri Feb 24 15:34:26 CST 2017
     */
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

        public Criteria andProfitControlNoIsNull() {
            addCriterion("PROFIT_CONTROL_NO is null");
            return (Criteria) this;
        }

        public Criteria andProfitControlNoIsNotNull() {
            addCriterion("PROFIT_CONTROL_NO is not null");
            return (Criteria) this;
        }

        public Criteria andProfitControlNoEqualTo(Long value) {
            addCriterion("PROFIT_CONTROL_NO =", value, "profitControlNo");
            return (Criteria) this;
        }

        public Criteria andProfitControlNoNotEqualTo(Long value) {
            addCriterion("PROFIT_CONTROL_NO <>", value, "profitControlNo");
            return (Criteria) this;
        }

        public Criteria andProfitControlNoGreaterThan(Long value) {
            addCriterion("PROFIT_CONTROL_NO >", value, "profitControlNo");
            return (Criteria) this;
        }

        public Criteria andProfitControlNoGreaterThanOrEqualTo(Long value) {
            addCriterion("PROFIT_CONTROL_NO >=", value, "profitControlNo");
            return (Criteria) this;
        }

        public Criteria andProfitControlNoLessThan(Long value) {
            addCriterion("PROFIT_CONTROL_NO <", value, "profitControlNo");
            return (Criteria) this;
        }

        public Criteria andProfitControlNoLessThanOrEqualTo(Long value) {
            addCriterion("PROFIT_CONTROL_NO <=", value, "profitControlNo");
            return (Criteria) this;
        }

        public Criteria andProfitControlNoIn(List<Long> values) {
            addCriterion("PROFIT_CONTROL_NO in", values, "profitControlNo");
            return (Criteria) this;
        }

        public Criteria andProfitControlNoNotIn(List<Long> values) {
            addCriterion("PROFIT_CONTROL_NO not in", values, "profitControlNo");
            return (Criteria) this;
        }

        public Criteria andProfitControlNoBetween(Long value1, Long value2) {
            addCriterion("PROFIT_CONTROL_NO between", value1, value2, "profitControlNo");
            return (Criteria) this;
        }

        public Criteria andProfitControlNoNotBetween(Long value1, Long value2) {
            addCriterion("PROFIT_CONTROL_NO not between", value1, value2, "profitControlNo");
            return (Criteria) this;
        }

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andOwnerIsNull() {
            addCriterion("OWNER is null");
            return (Criteria) this;
        }

        public Criteria andOwnerIsNotNull() {
            addCriterion("OWNER is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerEqualTo(Integer value) {
            addCriterion("OWNER =", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotEqualTo(Integer value) {
            addCriterion("OWNER <>", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerGreaterThan(Integer value) {
            addCriterion("OWNER >", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerGreaterThanOrEqualTo(Integer value) {
            addCriterion("OWNER >=", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLessThan(Integer value) {
            addCriterion("OWNER <", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLessThanOrEqualTo(Integer value) {
            addCriterion("OWNER <=", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerIn(List<Integer> values) {
            addCriterion("OWNER in", values, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotIn(List<Integer> values) {
            addCriterion("OWNER not in", values, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerBetween(Integer value1, Integer value2) {
            addCriterion("OWNER between", value1, value2, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotBetween(Integer value1, Integer value2) {
            addCriterion("OWNER not between", value1, value2, "owner");
            return (Criteria) this;
        }

        public Criteria andInsuranceNoIsNull() {
            addCriterion("INSURANCE_NO is null");
            return (Criteria) this;
        }

        public Criteria andInsuranceNoIsNotNull() {
            addCriterion("INSURANCE_NO is not null");
            return (Criteria) this;
        }

        public Criteria andInsuranceNoEqualTo(Long value) {
            addCriterion("INSURANCE_NO =", value, "insuranceNo");
            return (Criteria) this;
        }

        public Criteria andInsuranceNoNotEqualTo(Long value) {
            addCriterion("INSURANCE_NO <>", value, "insuranceNo");
            return (Criteria) this;
        }

        public Criteria andInsuranceNoGreaterThan(Long value) {
            addCriterion("INSURANCE_NO >", value, "insuranceNo");
            return (Criteria) this;
        }

        public Criteria andInsuranceNoGreaterThanOrEqualTo(Long value) {
            addCriterion("INSURANCE_NO >=", value, "insuranceNo");
            return (Criteria) this;
        }

        public Criteria andInsuranceNoLessThan(Long value) {
            addCriterion("INSURANCE_NO <", value, "insuranceNo");
            return (Criteria) this;
        }

        public Criteria andInsuranceNoLessThanOrEqualTo(Long value) {
            addCriterion("INSURANCE_NO <=", value, "insuranceNo");
            return (Criteria) this;
        }

        public Criteria andInsuranceNoIn(List<Long> values) {
            addCriterion("INSURANCE_NO in", values, "insuranceNo");
            return (Criteria) this;
        }

        public Criteria andInsuranceNoNotIn(List<Long> values) {
            addCriterion("INSURANCE_NO not in", values, "insuranceNo");
            return (Criteria) this;
        }

        public Criteria andInsuranceNoBetween(Long value1, Long value2) {
            addCriterion("INSURANCE_NO between", value1, value2, "insuranceNo");
            return (Criteria) this;
        }

        public Criteria andInsuranceNoNotBetween(Long value1, Long value2) {
            addCriterion("INSURANCE_NO not between", value1, value2, "insuranceNo");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeNoIsNull() {
            addCriterion("CUSTOMER_TYPE_NO is null");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeNoIsNotNull() {
            addCriterion("CUSTOMER_TYPE_NO is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeNoEqualTo(Long value) {
            addCriterion("CUSTOMER_TYPE_NO =", value, "customerTypeNo");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeNoNotEqualTo(Long value) {
            addCriterion("CUSTOMER_TYPE_NO <>", value, "customerTypeNo");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeNoGreaterThan(Long value) {
            addCriterion("CUSTOMER_TYPE_NO >", value, "customerTypeNo");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeNoGreaterThanOrEqualTo(Long value) {
            addCriterion("CUSTOMER_TYPE_NO >=", value, "customerTypeNo");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeNoLessThan(Long value) {
            addCriterion("CUSTOMER_TYPE_NO <", value, "customerTypeNo");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeNoLessThanOrEqualTo(Long value) {
            addCriterion("CUSTOMER_TYPE_NO <=", value, "customerTypeNo");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeNoIn(List<Long> values) {
            addCriterion("CUSTOMER_TYPE_NO in", values, "customerTypeNo");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeNoNotIn(List<Long> values) {
            addCriterion("CUSTOMER_TYPE_NO not in", values, "customerTypeNo");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeNoBetween(Long value1, Long value2) {
            addCriterion("CUSTOMER_TYPE_NO between", value1, value2, "customerTypeNo");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeNoNotBetween(Long value1, Long value2) {
            addCriterion("CUSTOMER_TYPE_NO not between", value1, value2, "customerTypeNo");
            return (Criteria) this;
        }

        public Criteria andBrokerageIsNull() {
            addCriterion("brokerage is null");
            return (Criteria) this;
        }

        public Criteria andBrokerageIsNotNull() {
            addCriterion("brokerage is not null");
            return (Criteria) this;
        }

        public Criteria andBrokerageEqualTo(BigDecimal value) {
            addCriterion("brokerage =", value, "brokerage");
            return (Criteria) this;
        }

        public Criteria andBrokerageNotEqualTo(BigDecimal value) {
            addCriterion("brokerage <>", value, "brokerage");
            return (Criteria) this;
        }

        public Criteria andBrokerageGreaterThan(BigDecimal value) {
            addCriterion("brokerage >", value, "brokerage");
            return (Criteria) this;
        }

        public Criteria andBrokerageGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("brokerage >=", value, "brokerage");
            return (Criteria) this;
        }

        public Criteria andBrokerageLessThan(BigDecimal value) {
            addCriterion("brokerage <", value, "brokerage");
            return (Criteria) this;
        }

        public Criteria andBrokerageLessThanOrEqualTo(BigDecimal value) {
            addCriterion("brokerage <=", value, "brokerage");
            return (Criteria) this;
        }

        public Criteria andBrokerageIn(List<BigDecimal> values) {
            addCriterion("brokerage in", values, "brokerage");
            return (Criteria) this;
        }

        public Criteria andBrokerageNotIn(List<BigDecimal> values) {
            addCriterion("brokerage not in", values, "brokerage");
            return (Criteria) this;
        }

        public Criteria andBrokerageBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("brokerage between", value1, value2, "brokerage");
            return (Criteria) this;
        }

        public Criteria andBrokerageNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("brokerage not between", value1, value2, "brokerage");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNull() {
            addCriterion("MODIFY_TIME is null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNotNull() {
            addCriterion("MODIFY_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeEqualTo(Date value) {
            addCriterion("MODIFY_TIME =", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotEqualTo(Date value) {
            addCriterion("MODIFY_TIME <>", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThan(Date value) {
            addCriterion("MODIFY_TIME >", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("MODIFY_TIME >=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThan(Date value) {
            addCriterion("MODIFY_TIME <", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("MODIFY_TIME <=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIn(List<Date> values) {
            addCriterion("MODIFY_TIME in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotIn(List<Date> values) {
            addCriterion("MODIFY_TIME not in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeBetween(Date value1, Date value2) {
            addCriterion("MODIFY_TIME between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("MODIFY_TIME not between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNull() {
            addCriterion("CREATOR is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNotNull() {
            addCriterion("CREATOR is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorEqualTo(String value) {
            addCriterion("CREATOR =", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotEqualTo(String value) {
            addCriterion("CREATOR <>", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThan(String value) {
            addCriterion("CREATOR >", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("CREATOR >=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThan(String value) {
            addCriterion("CREATOR <", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThanOrEqualTo(String value) {
            addCriterion("CREATOR <=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLike(String value) {
            addCriterion("CREATOR like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotLike(String value) {
            addCriterion("CREATOR not like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorIn(List<String> values) {
            addCriterion("CREATOR in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotIn(List<String> values) {
            addCriterion("CREATOR not in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorBetween(String value1, String value2) {
            addCriterion("CREATOR between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotBetween(String value1, String value2) {
            addCriterion("CREATOR not between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andModifierIsNull() {
            addCriterion("MODIFIER is null");
            return (Criteria) this;
        }

        public Criteria andModifierIsNotNull() {
            addCriterion("MODIFIER is not null");
            return (Criteria) this;
        }

        public Criteria andModifierEqualTo(String value) {
            addCriterion("MODIFIER =", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotEqualTo(String value) {
            addCriterion("MODIFIER <>", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierGreaterThan(String value) {
            addCriterion("MODIFIER >", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierGreaterThanOrEqualTo(String value) {
            addCriterion("MODIFIER >=", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierLessThan(String value) {
            addCriterion("MODIFIER <", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierLessThanOrEqualTo(String value) {
            addCriterion("MODIFIER <=", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierLike(String value) {
            addCriterion("MODIFIER like", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotLike(String value) {
            addCriterion("MODIFIER not like", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierIn(List<String> values) {
            addCriterion("MODIFIER in", values, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotIn(List<String> values) {
            addCriterion("MODIFIER not in", values, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierBetween(String value1, String value2) {
            addCriterion("MODIFIER between", value1, value2, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotBetween(String value1, String value2) {
            addCriterion("MODIFIER not between", value1, value2, "modifier");
            return (Criteria) this;
        }

        public Criteria andValidIsNull() {
            addCriterion("VALID is null");
            return (Criteria) this;
        }

        public Criteria andValidIsNotNull() {
            addCriterion("VALID is not null");
            return (Criteria) this;
        }

        public Criteria andValidEqualTo(Boolean value) {
            addCriterion("VALID =", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidNotEqualTo(Boolean value) {
            addCriterion("VALID <>", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidGreaterThan(Boolean value) {
            addCriterion("VALID >", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidGreaterThanOrEqualTo(Boolean value) {
            addCriterion("VALID >=", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidLessThan(Boolean value) {
            addCriterion("VALID <", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidLessThanOrEqualTo(Boolean value) {
            addCriterion("VALID <=", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidIn(List<Boolean> values) {
            addCriterion("VALID in", values, "valid");
            return (Criteria) this;
        }

        public Criteria andValidNotIn(List<Boolean> values) {
            addCriterion("VALID not in", values, "valid");
            return (Criteria) this;
        }

        public Criteria andValidBetween(Boolean value1, Boolean value2) {
            addCriterion("VALID between", value1, value2, "valid");
            return (Criteria) this;
        }

        public Criteria andValidNotBetween(Boolean value1, Boolean value2) {
            addCriterion("VALID not between", value1, value2, "valid");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TRA_PROFIT_CONTROL
     *
     * @mbggenerated do_not_delete_during_merge Fri Feb 24 15:34:26 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TRA_PROFIT_CONTROL
     *
     * @mbggenerated Fri Feb 24 15:34:26 CST 2017
     */
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