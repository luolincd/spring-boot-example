package com.tech.court.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CaseReportExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public CaseReportExample() {
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

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andYearIsNull() {
            addCriterion("year is null");
            return (Criteria) this;
        }

        public Criteria andYearIsNotNull() {
            addCriterion("year is not null");
            return (Criteria) this;
        }

        public Criteria andYearEqualTo(Integer value) {
            addCriterion("year =", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotEqualTo(Integer value) {
            addCriterion("year <>", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThan(Integer value) {
            addCriterion("year >", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("year >=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThan(Integer value) {
            addCriterion("year <", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThanOrEqualTo(Integer value) {
            addCriterion("year <=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearIn(List<Integer> values) {
            addCriterion("year in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotIn(List<Integer> values) {
            addCriterion("year not in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearBetween(Integer value1, Integer value2) {
            addCriterion("year between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotBetween(Integer value1, Integer value2) {
            addCriterion("year not between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andQuarterIsNull() {
            addCriterion("quarter is null");
            return (Criteria) this;
        }

        public Criteria andQuarterIsNotNull() {
            addCriterion("quarter is not null");
            return (Criteria) this;
        }

        public Criteria andQuarterEqualTo(Integer value) {
            addCriterion("quarter =", value, "quarter");
            return (Criteria) this;
        }

        public Criteria andQuarterNotEqualTo(Integer value) {
            addCriterion("quarter <>", value, "quarter");
            return (Criteria) this;
        }

        public Criteria andQuarterGreaterThan(Integer value) {
            addCriterion("quarter >", value, "quarter");
            return (Criteria) this;
        }

        public Criteria andQuarterGreaterThanOrEqualTo(Integer value) {
            addCriterion("quarter >=", value, "quarter");
            return (Criteria) this;
        }

        public Criteria andQuarterLessThan(Integer value) {
            addCriterion("quarter <", value, "quarter");
            return (Criteria) this;
        }

        public Criteria andQuarterLessThanOrEqualTo(Integer value) {
            addCriterion("quarter <=", value, "quarter");
            return (Criteria) this;
        }

        public Criteria andQuarterIn(List<Integer> values) {
            addCriterion("quarter in", values, "quarter");
            return (Criteria) this;
        }

        public Criteria andQuarterNotIn(List<Integer> values) {
            addCriterion("quarter not in", values, "quarter");
            return (Criteria) this;
        }

        public Criteria andQuarterBetween(Integer value1, Integer value2) {
            addCriterion("quarter between", value1, value2, "quarter");
            return (Criteria) this;
        }

        public Criteria andQuarterNotBetween(Integer value1, Integer value2) {
            addCriterion("quarter not between", value1, value2, "quarter");
            return (Criteria) this;
        }

        public Criteria andMonthIsNull() {
            addCriterion("month is null");
            return (Criteria) this;
        }

        public Criteria andMonthIsNotNull() {
            addCriterion("month is not null");
            return (Criteria) this;
        }

        public Criteria andMonthEqualTo(Integer value) {
            addCriterion("month =", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotEqualTo(Integer value) {
            addCriterion("month <>", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthGreaterThan(Integer value) {
            addCriterion("month >", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("month >=", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthLessThan(Integer value) {
            addCriterion("month <", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthLessThanOrEqualTo(Integer value) {
            addCriterion("month <=", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthIn(List<Integer> values) {
            addCriterion("month in", values, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotIn(List<Integer> values) {
            addCriterion("month not in", values, "month");
            return (Criteria) this;
        }

        public Criteria andMonthBetween(Integer value1, Integer value2) {
            addCriterion("month between", value1, value2, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotBetween(Integer value1, Integer value2) {
            addCriterion("month not between", value1, value2, "month");
            return (Criteria) this;
        }

        public Criteria andRegisterNumberIsNull() {
            addCriterion("register_number is null");
            return (Criteria) this;
        }

        public Criteria andRegisterNumberIsNotNull() {
            addCriterion("register_number is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterNumberEqualTo(Integer value) {
            addCriterion("register_number =", value, "registerNumber");
            return (Criteria) this;
        }

        public Criteria andRegisterNumberNotEqualTo(Integer value) {
            addCriterion("register_number <>", value, "registerNumber");
            return (Criteria) this;
        }

        public Criteria andRegisterNumberGreaterThan(Integer value) {
            addCriterion("register_number >", value, "registerNumber");
            return (Criteria) this;
        }

        public Criteria andRegisterNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("register_number >=", value, "registerNumber");
            return (Criteria) this;
        }

        public Criteria andRegisterNumberLessThan(Integer value) {
            addCriterion("register_number <", value, "registerNumber");
            return (Criteria) this;
        }

        public Criteria andRegisterNumberLessThanOrEqualTo(Integer value) {
            addCriterion("register_number <=", value, "registerNumber");
            return (Criteria) this;
        }

        public Criteria andRegisterNumberIn(List<Integer> values) {
            addCriterion("register_number in", values, "registerNumber");
            return (Criteria) this;
        }

        public Criteria andRegisterNumberNotIn(List<Integer> values) {
            addCriterion("register_number not in", values, "registerNumber");
            return (Criteria) this;
        }

        public Criteria andRegisterNumberBetween(Integer value1, Integer value2) {
            addCriterion("register_number between", value1, value2, "registerNumber");
            return (Criteria) this;
        }

        public Criteria andRegisterNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("register_number not between", value1, value2, "registerNumber");
            return (Criteria) this;
        }

        public Criteria andEndNumberIsNull() {
            addCriterion("end_number is null");
            return (Criteria) this;
        }

        public Criteria andEndNumberIsNotNull() {
            addCriterion("end_number is not null");
            return (Criteria) this;
        }

        public Criteria andEndNumberEqualTo(Integer value) {
            addCriterion("end_number =", value, "endNumber");
            return (Criteria) this;
        }

        public Criteria andEndNumberNotEqualTo(Integer value) {
            addCriterion("end_number <>", value, "endNumber");
            return (Criteria) this;
        }

        public Criteria andEndNumberGreaterThan(Integer value) {
            addCriterion("end_number >", value, "endNumber");
            return (Criteria) this;
        }

        public Criteria andEndNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("end_number >=", value, "endNumber");
            return (Criteria) this;
        }

        public Criteria andEndNumberLessThan(Integer value) {
            addCriterion("end_number <", value, "endNumber");
            return (Criteria) this;
        }

        public Criteria andEndNumberLessThanOrEqualTo(Integer value) {
            addCriterion("end_number <=", value, "endNumber");
            return (Criteria) this;
        }

        public Criteria andEndNumberIn(List<Integer> values) {
            addCriterion("end_number in", values, "endNumber");
            return (Criteria) this;
        }

        public Criteria andEndNumberNotIn(List<Integer> values) {
            addCriterion("end_number not in", values, "endNumber");
            return (Criteria) this;
        }

        public Criteria andEndNumberBetween(Integer value1, Integer value2) {
            addCriterion("end_number between", value1, value2, "endNumber");
            return (Criteria) this;
        }

        public Criteria andEndNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("end_number not between", value1, value2, "endNumber");
            return (Criteria) this;
        }

        public Criteria andNoneEndNumberIsNull() {
            addCriterion("none_end_number is null");
            return (Criteria) this;
        }

        public Criteria andNoneEndNumberIsNotNull() {
            addCriterion("none_end_number is not null");
            return (Criteria) this;
        }

        public Criteria andNoneEndNumberEqualTo(Integer value) {
            addCriterion("none_end_number =", value, "noneEndNumber");
            return (Criteria) this;
        }

        public Criteria andNoneEndNumberNotEqualTo(Integer value) {
            addCriterion("none_end_number <>", value, "noneEndNumber");
            return (Criteria) this;
        }

        public Criteria andNoneEndNumberGreaterThan(Integer value) {
            addCriterion("none_end_number >", value, "noneEndNumber");
            return (Criteria) this;
        }

        public Criteria andNoneEndNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("none_end_number >=", value, "noneEndNumber");
            return (Criteria) this;
        }

        public Criteria andNoneEndNumberLessThan(Integer value) {
            addCriterion("none_end_number <", value, "noneEndNumber");
            return (Criteria) this;
        }

        public Criteria andNoneEndNumberLessThanOrEqualTo(Integer value) {
            addCriterion("none_end_number <=", value, "noneEndNumber");
            return (Criteria) this;
        }

        public Criteria andNoneEndNumberIn(List<Integer> values) {
            addCriterion("none_end_number in", values, "noneEndNumber");
            return (Criteria) this;
        }

        public Criteria andNoneEndNumberNotIn(List<Integer> values) {
            addCriterion("none_end_number not in", values, "noneEndNumber");
            return (Criteria) this;
        }

        public Criteria andNoneEndNumberBetween(Integer value1, Integer value2) {
            addCriterion("none_end_number between", value1, value2, "noneEndNumber");
            return (Criteria) this;
        }

        public Criteria andNoneEndNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("none_end_number not between", value1, value2, "noneEndNumber");
            return (Criteria) this;
        }

        public Criteria andEndRateIsNull() {
            addCriterion("end_rate is null");
            return (Criteria) this;
        }

        public Criteria andEndRateIsNotNull() {
            addCriterion("end_rate is not null");
            return (Criteria) this;
        }

        public Criteria andEndRateEqualTo(BigDecimal value) {
            addCriterion("end_rate =", value, "endRate");
            return (Criteria) this;
        }

        public Criteria andEndRateNotEqualTo(BigDecimal value) {
            addCriterion("end_rate <>", value, "endRate");
            return (Criteria) this;
        }

        public Criteria andEndRateGreaterThan(BigDecimal value) {
            addCriterion("end_rate >", value, "endRate");
            return (Criteria) this;
        }

        public Criteria andEndRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("end_rate >=", value, "endRate");
            return (Criteria) this;
        }

        public Criteria andEndRateLessThan(BigDecimal value) {
            addCriterion("end_rate <", value, "endRate");
            return (Criteria) this;
        }

        public Criteria andEndRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("end_rate <=", value, "endRate");
            return (Criteria) this;
        }

        public Criteria andEndRateIn(List<BigDecimal> values) {
            addCriterion("end_rate in", values, "endRate");
            return (Criteria) this;
        }

        public Criteria andEndRateNotIn(List<BigDecimal> values) {
            addCriterion("end_rate not in", values, "endRate");
            return (Criteria) this;
        }

        public Criteria andEndRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("end_rate between", value1, value2, "endRate");
            return (Criteria) this;
        }

        public Criteria andEndRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("end_rate not between", value1, value2, "endRate");
            return (Criteria) this;
        }

        public Criteria andJudgeDaysIsNull() {
            addCriterion("judge_days is null");
            return (Criteria) this;
        }

        public Criteria andJudgeDaysIsNotNull() {
            addCriterion("judge_days is not null");
            return (Criteria) this;
        }

        public Criteria andJudgeDaysEqualTo(BigDecimal value) {
            addCriterion("judge_days =", value, "judgeDays");
            return (Criteria) this;
        }

        public Criteria andJudgeDaysNotEqualTo(BigDecimal value) {
            addCriterion("judge_days <>", value, "judgeDays");
            return (Criteria) this;
        }

        public Criteria andJudgeDaysGreaterThan(BigDecimal value) {
            addCriterion("judge_days >", value, "judgeDays");
            return (Criteria) this;
        }

        public Criteria andJudgeDaysGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("judge_days >=", value, "judgeDays");
            return (Criteria) this;
        }

        public Criteria andJudgeDaysLessThan(BigDecimal value) {
            addCriterion("judge_days <", value, "judgeDays");
            return (Criteria) this;
        }

        public Criteria andJudgeDaysLessThanOrEqualTo(BigDecimal value) {
            addCriterion("judge_days <=", value, "judgeDays");
            return (Criteria) this;
        }

        public Criteria andJudgeDaysIn(List<BigDecimal> values) {
            addCriterion("judge_days in", values, "judgeDays");
            return (Criteria) this;
        }

        public Criteria andJudgeDaysNotIn(List<BigDecimal> values) {
            addCriterion("judge_days not in", values, "judgeDays");
            return (Criteria) this;
        }

        public Criteria andJudgeDaysBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("judge_days between", value1, value2, "judgeDays");
            return (Criteria) this;
        }

        public Criteria andJudgeDaysNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("judge_days not between", value1, value2, "judgeDays");
            return (Criteria) this;
        }

        public Criteria andEnforceEndRateIsNull() {
            addCriterion("enforce_end_Rate is null");
            return (Criteria) this;
        }

        public Criteria andEnforceEndRateIsNotNull() {
            addCriterion("enforce_end_Rate is not null");
            return (Criteria) this;
        }

        public Criteria andEnforceEndRateEqualTo(BigDecimal value) {
            addCriterion("enforce_end_Rate =", value, "enforceEndRate");
            return (Criteria) this;
        }

        public Criteria andEnforceEndRateNotEqualTo(BigDecimal value) {
            addCriterion("enforce_end_Rate <>", value, "enforceEndRate");
            return (Criteria) this;
        }

        public Criteria andEnforceEndRateGreaterThan(BigDecimal value) {
            addCriterion("enforce_end_Rate >", value, "enforceEndRate");
            return (Criteria) this;
        }

        public Criteria andEnforceEndRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("enforce_end_Rate >=", value, "enforceEndRate");
            return (Criteria) this;
        }

        public Criteria andEnforceEndRateLessThan(BigDecimal value) {
            addCriterion("enforce_end_Rate <", value, "enforceEndRate");
            return (Criteria) this;
        }

        public Criteria andEnforceEndRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("enforce_end_Rate <=", value, "enforceEndRate");
            return (Criteria) this;
        }

        public Criteria andEnforceEndRateIn(List<BigDecimal> values) {
            addCriterion("enforce_end_Rate in", values, "enforceEndRate");
            return (Criteria) this;
        }

        public Criteria andEnforceEndRateNotIn(List<BigDecimal> values) {
            addCriterion("enforce_end_Rate not in", values, "enforceEndRate");
            return (Criteria) this;
        }

        public Criteria andEnforceEndRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("enforce_end_Rate between", value1, value2, "enforceEndRate");
            return (Criteria) this;
        }

        public Criteria andEnforceEndRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("enforce_end_Rate not between", value1, value2, "enforceEndRate");
            return (Criteria) this;
        }

        public Criteria andLimitEndRateIsNull() {
            addCriterion("limit_end_rate is null");
            return (Criteria) this;
        }

        public Criteria andLimitEndRateIsNotNull() {
            addCriterion("limit_end_rate is not null");
            return (Criteria) this;
        }

        public Criteria andLimitEndRateEqualTo(BigDecimal value) {
            addCriterion("limit_end_rate =", value, "limitEndRate");
            return (Criteria) this;
        }

        public Criteria andLimitEndRateNotEqualTo(BigDecimal value) {
            addCriterion("limit_end_rate <>", value, "limitEndRate");
            return (Criteria) this;
        }

        public Criteria andLimitEndRateGreaterThan(BigDecimal value) {
            addCriterion("limit_end_rate >", value, "limitEndRate");
            return (Criteria) this;
        }

        public Criteria andLimitEndRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("limit_end_rate >=", value, "limitEndRate");
            return (Criteria) this;
        }

        public Criteria andLimitEndRateLessThan(BigDecimal value) {
            addCriterion("limit_end_rate <", value, "limitEndRate");
            return (Criteria) this;
        }

        public Criteria andLimitEndRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("limit_end_rate <=", value, "limitEndRate");
            return (Criteria) this;
        }

        public Criteria andLimitEndRateIn(List<BigDecimal> values) {
            addCriterion("limit_end_rate in", values, "limitEndRate");
            return (Criteria) this;
        }

        public Criteria andLimitEndRateNotIn(List<BigDecimal> values) {
            addCriterion("limit_end_rate not in", values, "limitEndRate");
            return (Criteria) this;
        }

        public Criteria andLimitEndRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("limit_end_rate between", value1, value2, "limitEndRate");
            return (Criteria) this;
        }

        public Criteria andLimitEndRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("limit_end_rate not between", value1, value2, "limitEndRate");
            return (Criteria) this;
        }

        public Criteria andAgreeRateIsNull() {
            addCriterion("agree_rate is null");
            return (Criteria) this;
        }

        public Criteria andAgreeRateIsNotNull() {
            addCriterion("agree_rate is not null");
            return (Criteria) this;
        }

        public Criteria andAgreeRateEqualTo(BigDecimal value) {
            addCriterion("agree_rate =", value, "agreeRate");
            return (Criteria) this;
        }

        public Criteria andAgreeRateNotEqualTo(BigDecimal value) {
            addCriterion("agree_rate <>", value, "agreeRate");
            return (Criteria) this;
        }

        public Criteria andAgreeRateGreaterThan(BigDecimal value) {
            addCriterion("agree_rate >", value, "agreeRate");
            return (Criteria) this;
        }

        public Criteria andAgreeRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("agree_rate >=", value, "agreeRate");
            return (Criteria) this;
        }

        public Criteria andAgreeRateLessThan(BigDecimal value) {
            addCriterion("agree_rate <", value, "agreeRate");
            return (Criteria) this;
        }

        public Criteria andAgreeRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("agree_rate <=", value, "agreeRate");
            return (Criteria) this;
        }

        public Criteria andAgreeRateIn(List<BigDecimal> values) {
            addCriterion("agree_rate in", values, "agreeRate");
            return (Criteria) this;
        }

        public Criteria andAgreeRateNotIn(List<BigDecimal> values) {
            addCriterion("agree_rate not in", values, "agreeRate");
            return (Criteria) this;
        }

        public Criteria andAgreeRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("agree_rate between", value1, value2, "agreeRate");
            return (Criteria) this;
        }

        public Criteria andAgreeRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("agree_rate not between", value1, value2, "agreeRate");
            return (Criteria) this;
        }

        public Criteria andEnforceRegisterNumberIsNull() {
            addCriterion("enforce_register_number is null");
            return (Criteria) this;
        }

        public Criteria andEnforceRegisterNumberIsNotNull() {
            addCriterion("enforce_register_number is not null");
            return (Criteria) this;
        }

        public Criteria andEnforceRegisterNumberEqualTo(Integer value) {
            addCriterion("enforce_register_number =", value, "enforceRegisterNumber");
            return (Criteria) this;
        }

        public Criteria andEnforceRegisterNumberNotEqualTo(Integer value) {
            addCriterion("enforce_register_number <>", value, "enforceRegisterNumber");
            return (Criteria) this;
        }

        public Criteria andEnforceRegisterNumberGreaterThan(Integer value) {
            addCriterion("enforce_register_number >", value, "enforceRegisterNumber");
            return (Criteria) this;
        }

        public Criteria andEnforceRegisterNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("enforce_register_number >=", value, "enforceRegisterNumber");
            return (Criteria) this;
        }

        public Criteria andEnforceRegisterNumberLessThan(Integer value) {
            addCriterion("enforce_register_number <", value, "enforceRegisterNumber");
            return (Criteria) this;
        }

        public Criteria andEnforceRegisterNumberLessThanOrEqualTo(Integer value) {
            addCriterion("enforce_register_number <=", value, "enforceRegisterNumber");
            return (Criteria) this;
        }

        public Criteria andEnforceRegisterNumberIn(List<Integer> values) {
            addCriterion("enforce_register_number in", values, "enforceRegisterNumber");
            return (Criteria) this;
        }

        public Criteria andEnforceRegisterNumberNotIn(List<Integer> values) {
            addCriterion("enforce_register_number not in", values, "enforceRegisterNumber");
            return (Criteria) this;
        }

        public Criteria andEnforceRegisterNumberBetween(Integer value1, Integer value2) {
            addCriterion("enforce_register_number between", value1, value2, "enforceRegisterNumber");
            return (Criteria) this;
        }

        public Criteria andEnforceRegisterNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("enforce_register_number not between", value1, value2, "enforceRegisterNumber");
            return (Criteria) this;
        }

        public Criteria andEnforceEndNumberIsNull() {
            addCriterion("enforce_end_number is null");
            return (Criteria) this;
        }

        public Criteria andEnforceEndNumberIsNotNull() {
            addCriterion("enforce_end_number is not null");
            return (Criteria) this;
        }

        public Criteria andEnforceEndNumberEqualTo(Integer value) {
            addCriterion("enforce_end_number =", value, "enforceEndNumber");
            return (Criteria) this;
        }

        public Criteria andEnforceEndNumberNotEqualTo(Integer value) {
            addCriterion("enforce_end_number <>", value, "enforceEndNumber");
            return (Criteria) this;
        }

        public Criteria andEnforceEndNumberGreaterThan(Integer value) {
            addCriterion("enforce_end_number >", value, "enforceEndNumber");
            return (Criteria) this;
        }

        public Criteria andEnforceEndNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("enforce_end_number >=", value, "enforceEndNumber");
            return (Criteria) this;
        }

        public Criteria andEnforceEndNumberLessThan(Integer value) {
            addCriterion("enforce_end_number <", value, "enforceEndNumber");
            return (Criteria) this;
        }

        public Criteria andEnforceEndNumberLessThanOrEqualTo(Integer value) {
            addCriterion("enforce_end_number <=", value, "enforceEndNumber");
            return (Criteria) this;
        }

        public Criteria andEnforceEndNumberIn(List<Integer> values) {
            addCriterion("enforce_end_number in", values, "enforceEndNumber");
            return (Criteria) this;
        }

        public Criteria andEnforceEndNumberNotIn(List<Integer> values) {
            addCriterion("enforce_end_number not in", values, "enforceEndNumber");
            return (Criteria) this;
        }

        public Criteria andEnforceEndNumberBetween(Integer value1, Integer value2) {
            addCriterion("enforce_end_number between", value1, value2, "enforceEndNumber");
            return (Criteria) this;
        }

        public Criteria andEnforceEndNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("enforce_end_number not between", value1, value2, "enforceEndNumber");
            return (Criteria) this;
        }
    }

    /**
     */
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