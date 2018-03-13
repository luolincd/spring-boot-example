package com.tech.court.entity;

import java.util.ArrayList;
import java.util.List;

public class CourtLiveExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CourtLiveExample() {
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

        public Criteria andFtsyidIsNull() {
            addCriterion("ftsyid is null");
            return (Criteria) this;
        }

        public Criteria andFtsyidIsNotNull() {
            addCriterion("ftsyid is not null");
            return (Criteria) this;
        }

        public Criteria andFtsyidEqualTo(String value) {
            addCriterion("ftsyid =", value, "ftsyid");
            return (Criteria) this;
        }

        public Criteria andFtsyidNotEqualTo(String value) {
            addCriterion("ftsyid <>", value, "ftsyid");
            return (Criteria) this;
        }

        public Criteria andFtsyidGreaterThan(String value) {
            addCriterion("ftsyid >", value, "ftsyid");
            return (Criteria) this;
        }

        public Criteria andFtsyidGreaterThanOrEqualTo(String value) {
            addCriterion("ftsyid >=", value, "ftsyid");
            return (Criteria) this;
        }

        public Criteria andFtsyidLessThan(String value) {
            addCriterion("ftsyid <", value, "ftsyid");
            return (Criteria) this;
        }

        public Criteria andFtsyidLessThanOrEqualTo(String value) {
            addCriterion("ftsyid <=", value, "ftsyid");
            return (Criteria) this;
        }

        public Criteria andFtsyidLike(String value) {
            addCriterion("ftsyid like", value, "ftsyid");
            return (Criteria) this;
        }

        public Criteria andFtsyidNotLike(String value) {
            addCriterion("ftsyid not like", value, "ftsyid");
            return (Criteria) this;
        }

        public Criteria andFtsyidIn(List<String> values) {
            addCriterion("ftsyid in", values, "ftsyid");
            return (Criteria) this;
        }

        public Criteria andFtsyidNotIn(List<String> values) {
            addCriterion("ftsyid not in", values, "ftsyid");
            return (Criteria) this;
        }

        public Criteria andFtsyidBetween(String value1, String value2) {
            addCriterion("ftsyid between", value1, value2, "ftsyid");
            return (Criteria) this;
        }

        public Criteria andFtsyidNotBetween(String value1, String value2) {
            addCriterion("ftsyid not between", value1, value2, "ftsyid");
            return (Criteria) this;
        }

        public Criteria andAjbsIsNull() {
            addCriterion("ajbs is null");
            return (Criteria) this;
        }

        public Criteria andAjbsIsNotNull() {
            addCriterion("ajbs is not null");
            return (Criteria) this;
        }

        public Criteria andAjbsEqualTo(String value) {
            addCriterion("ajbs =", value, "ajbs");
            return (Criteria) this;
        }

        public Criteria andAjbsNotEqualTo(String value) {
            addCriterion("ajbs <>", value, "ajbs");
            return (Criteria) this;
        }

        public Criteria andAjbsGreaterThan(String value) {
            addCriterion("ajbs >", value, "ajbs");
            return (Criteria) this;
        }

        public Criteria andAjbsGreaterThanOrEqualTo(String value) {
            addCriterion("ajbs >=", value, "ajbs");
            return (Criteria) this;
        }

        public Criteria andAjbsLessThan(String value) {
            addCriterion("ajbs <", value, "ajbs");
            return (Criteria) this;
        }

        public Criteria andAjbsLessThanOrEqualTo(String value) {
            addCriterion("ajbs <=", value, "ajbs");
            return (Criteria) this;
        }

        public Criteria andAjbsLike(String value) {
            addCriterion("ajbs like", value, "ajbs");
            return (Criteria) this;
        }

        public Criteria andAjbsNotLike(String value) {
            addCriterion("ajbs not like", value, "ajbs");
            return (Criteria) this;
        }

        public Criteria andAjbsIn(List<String> values) {
            addCriterion("ajbs in", values, "ajbs");
            return (Criteria) this;
        }

        public Criteria andAjbsNotIn(List<String> values) {
            addCriterion("ajbs not in", values, "ajbs");
            return (Criteria) this;
        }

        public Criteria andAjbsBetween(String value1, String value2) {
            addCriterion("ajbs between", value1, value2, "ajbs");
            return (Criteria) this;
        }

        public Criteria andAjbsNotBetween(String value1, String value2) {
            addCriterion("ajbs not between", value1, value2, "ajbs");
            return (Criteria) this;
        }

        public Criteria andAjlxbsIsNull() {
            addCriterion("ajlxbs is null");
            return (Criteria) this;
        }

        public Criteria andAjlxbsIsNotNull() {
            addCriterion("ajlxbs is not null");
            return (Criteria) this;
        }

        public Criteria andAjlxbsEqualTo(String value) {
            addCriterion("ajlxbs =", value, "ajlxbs");
            return (Criteria) this;
        }

        public Criteria andAjlxbsNotEqualTo(String value) {
            addCriterion("ajlxbs <>", value, "ajlxbs");
            return (Criteria) this;
        }

        public Criteria andAjlxbsGreaterThan(String value) {
            addCriterion("ajlxbs >", value, "ajlxbs");
            return (Criteria) this;
        }

        public Criteria andAjlxbsGreaterThanOrEqualTo(String value) {
            addCriterion("ajlxbs >=", value, "ajlxbs");
            return (Criteria) this;
        }

        public Criteria andAjlxbsLessThan(String value) {
            addCriterion("ajlxbs <", value, "ajlxbs");
            return (Criteria) this;
        }

        public Criteria andAjlxbsLessThanOrEqualTo(String value) {
            addCriterion("ajlxbs <=", value, "ajlxbs");
            return (Criteria) this;
        }

        public Criteria andAjlxbsLike(String value) {
            addCriterion("ajlxbs like", value, "ajlxbs");
            return (Criteria) this;
        }

        public Criteria andAjlxbsNotLike(String value) {
            addCriterion("ajlxbs not like", value, "ajlxbs");
            return (Criteria) this;
        }

        public Criteria andAjlxbsIn(List<String> values) {
            addCriterion("ajlxbs in", values, "ajlxbs");
            return (Criteria) this;
        }

        public Criteria andAjlxbsNotIn(List<String> values) {
            addCriterion("ajlxbs not in", values, "ajlxbs");
            return (Criteria) this;
        }

        public Criteria andAjlxbsBetween(String value1, String value2) {
            addCriterion("ajlxbs between", value1, value2, "ajlxbs");
            return (Criteria) this;
        }

        public Criteria andAjlxbsNotBetween(String value1, String value2) {
            addCriterion("ajlxbs not between", value1, value2, "ajlxbs");
            return (Criteria) this;
        }

        public Criteria andAjlxIsNull() {
            addCriterion("ajlx is null");
            return (Criteria) this;
        }

        public Criteria andAjlxIsNotNull() {
            addCriterion("ajlx is not null");
            return (Criteria) this;
        }

        public Criteria andAjlxEqualTo(String value) {
            addCriterion("ajlx =", value, "ajlx");
            return (Criteria) this;
        }

        public Criteria andAjlxNotEqualTo(String value) {
            addCriterion("ajlx <>", value, "ajlx");
            return (Criteria) this;
        }

        public Criteria andAjlxGreaterThan(String value) {
            addCriterion("ajlx >", value, "ajlx");
            return (Criteria) this;
        }

        public Criteria andAjlxGreaterThanOrEqualTo(String value) {
            addCriterion("ajlx >=", value, "ajlx");
            return (Criteria) this;
        }

        public Criteria andAjlxLessThan(String value) {
            addCriterion("ajlx <", value, "ajlx");
            return (Criteria) this;
        }

        public Criteria andAjlxLessThanOrEqualTo(String value) {
            addCriterion("ajlx <=", value, "ajlx");
            return (Criteria) this;
        }

        public Criteria andAjlxLike(String value) {
            addCriterion("ajlx like", value, "ajlx");
            return (Criteria) this;
        }

        public Criteria andAjlxNotLike(String value) {
            addCriterion("ajlx not like", value, "ajlx");
            return (Criteria) this;
        }

        public Criteria andAjlxIn(List<String> values) {
            addCriterion("ajlx in", values, "ajlx");
            return (Criteria) this;
        }

        public Criteria andAjlxNotIn(List<String> values) {
            addCriterion("ajlx not in", values, "ajlx");
            return (Criteria) this;
        }

        public Criteria andAjlxBetween(String value1, String value2) {
            addCriterion("ajlx between", value1, value2, "ajlx");
            return (Criteria) this;
        }

        public Criteria andAjlxNotBetween(String value1, String value2) {
            addCriterion("ajlx not between", value1, value2, "ajlx");
            return (Criteria) this;
        }

        public Criteria andSpcxbsIsNull() {
            addCriterion("spcxbs is null");
            return (Criteria) this;
        }

        public Criteria andSpcxbsIsNotNull() {
            addCriterion("spcxbs is not null");
            return (Criteria) this;
        }

        public Criteria andSpcxbsEqualTo(String value) {
            addCriterion("spcxbs =", value, "spcxbs");
            return (Criteria) this;
        }

        public Criteria andSpcxbsNotEqualTo(String value) {
            addCriterion("spcxbs <>", value, "spcxbs");
            return (Criteria) this;
        }

        public Criteria andSpcxbsGreaterThan(String value) {
            addCriterion("spcxbs >", value, "spcxbs");
            return (Criteria) this;
        }

        public Criteria andSpcxbsGreaterThanOrEqualTo(String value) {
            addCriterion("spcxbs >=", value, "spcxbs");
            return (Criteria) this;
        }

        public Criteria andSpcxbsLessThan(String value) {
            addCriterion("spcxbs <", value, "spcxbs");
            return (Criteria) this;
        }

        public Criteria andSpcxbsLessThanOrEqualTo(String value) {
            addCriterion("spcxbs <=", value, "spcxbs");
            return (Criteria) this;
        }

        public Criteria andSpcxbsLike(String value) {
            addCriterion("spcxbs like", value, "spcxbs");
            return (Criteria) this;
        }

        public Criteria andSpcxbsNotLike(String value) {
            addCriterion("spcxbs not like", value, "spcxbs");
            return (Criteria) this;
        }

        public Criteria andSpcxbsIn(List<String> values) {
            addCriterion("spcxbs in", values, "spcxbs");
            return (Criteria) this;
        }

        public Criteria andSpcxbsNotIn(List<String> values) {
            addCriterion("spcxbs not in", values, "spcxbs");
            return (Criteria) this;
        }

        public Criteria andSpcxbsBetween(String value1, String value2) {
            addCriterion("spcxbs between", value1, value2, "spcxbs");
            return (Criteria) this;
        }

        public Criteria andSpcxbsNotBetween(String value1, String value2) {
            addCriterion("spcxbs not between", value1, value2, "spcxbs");
            return (Criteria) this;
        }

        public Criteria andSpcxIsNull() {
            addCriterion("spcx is null");
            return (Criteria) this;
        }

        public Criteria andSpcxIsNotNull() {
            addCriterion("spcx is not null");
            return (Criteria) this;
        }

        public Criteria andSpcxEqualTo(String value) {
            addCriterion("spcx =", value, "spcx");
            return (Criteria) this;
        }

        public Criteria andSpcxNotEqualTo(String value) {
            addCriterion("spcx <>", value, "spcx");
            return (Criteria) this;
        }

        public Criteria andSpcxGreaterThan(String value) {
            addCriterion("spcx >", value, "spcx");
            return (Criteria) this;
        }

        public Criteria andSpcxGreaterThanOrEqualTo(String value) {
            addCriterion("spcx >=", value, "spcx");
            return (Criteria) this;
        }

        public Criteria andSpcxLessThan(String value) {
            addCriterion("spcx <", value, "spcx");
            return (Criteria) this;
        }

        public Criteria andSpcxLessThanOrEqualTo(String value) {
            addCriterion("spcx <=", value, "spcx");
            return (Criteria) this;
        }

        public Criteria andSpcxLike(String value) {
            addCriterion("spcx like", value, "spcx");
            return (Criteria) this;
        }

        public Criteria andSpcxNotLike(String value) {
            addCriterion("spcx not like", value, "spcx");
            return (Criteria) this;
        }

        public Criteria andSpcxIn(List<String> values) {
            addCriterion("spcx in", values, "spcx");
            return (Criteria) this;
        }

        public Criteria andSpcxNotIn(List<String> values) {
            addCriterion("spcx not in", values, "spcx");
            return (Criteria) this;
        }

        public Criteria andSpcxBetween(String value1, String value2) {
            addCriterion("spcx between", value1, value2, "spcx");
            return (Criteria) this;
        }

        public Criteria andSpcxNotBetween(String value1, String value2) {
            addCriterion("spcx not between", value1, value2, "spcx");
            return (Criteria) this;
        }

        public Criteria andAybsIsNull() {
            addCriterion("aybs is null");
            return (Criteria) this;
        }

        public Criteria andAybsIsNotNull() {
            addCriterion("aybs is not null");
            return (Criteria) this;
        }

        public Criteria andAybsEqualTo(String value) {
            addCriterion("aybs =", value, "aybs");
            return (Criteria) this;
        }

        public Criteria andAybsNotEqualTo(String value) {
            addCriterion("aybs <>", value, "aybs");
            return (Criteria) this;
        }

        public Criteria andAybsGreaterThan(String value) {
            addCriterion("aybs >", value, "aybs");
            return (Criteria) this;
        }

        public Criteria andAybsGreaterThanOrEqualTo(String value) {
            addCriterion("aybs >=", value, "aybs");
            return (Criteria) this;
        }

        public Criteria andAybsLessThan(String value) {
            addCriterion("aybs <", value, "aybs");
            return (Criteria) this;
        }

        public Criteria andAybsLessThanOrEqualTo(String value) {
            addCriterion("aybs <=", value, "aybs");
            return (Criteria) this;
        }

        public Criteria andAybsLike(String value) {
            addCriterion("aybs like", value, "aybs");
            return (Criteria) this;
        }

        public Criteria andAybsNotLike(String value) {
            addCriterion("aybs not like", value, "aybs");
            return (Criteria) this;
        }

        public Criteria andAybsIn(List<String> values) {
            addCriterion("aybs in", values, "aybs");
            return (Criteria) this;
        }

        public Criteria andAybsNotIn(List<String> values) {
            addCriterion("aybs not in", values, "aybs");
            return (Criteria) this;
        }

        public Criteria andAybsBetween(String value1, String value2) {
            addCriterion("aybs between", value1, value2, "aybs");
            return (Criteria) this;
        }

        public Criteria andAybsNotBetween(String value1, String value2) {
            addCriterion("aybs not between", value1, value2, "aybs");
            return (Criteria) this;
        }

        public Criteria andAymcIsNull() {
            addCriterion("aymc is null");
            return (Criteria) this;
        }

        public Criteria andAymcIsNotNull() {
            addCriterion("aymc is not null");
            return (Criteria) this;
        }

        public Criteria andAymcEqualTo(String value) {
            addCriterion("aymc =", value, "aymc");
            return (Criteria) this;
        }

        public Criteria andAymcNotEqualTo(String value) {
            addCriterion("aymc <>", value, "aymc");
            return (Criteria) this;
        }

        public Criteria andAymcGreaterThan(String value) {
            addCriterion("aymc >", value, "aymc");
            return (Criteria) this;
        }

        public Criteria andAymcGreaterThanOrEqualTo(String value) {
            addCriterion("aymc >=", value, "aymc");
            return (Criteria) this;
        }

        public Criteria andAymcLessThan(String value) {
            addCriterion("aymc <", value, "aymc");
            return (Criteria) this;
        }

        public Criteria andAymcLessThanOrEqualTo(String value) {
            addCriterion("aymc <=", value, "aymc");
            return (Criteria) this;
        }

        public Criteria andAymcLike(String value) {
            addCriterion("aymc like", value, "aymc");
            return (Criteria) this;
        }

        public Criteria andAymcNotLike(String value) {
            addCriterion("aymc not like", value, "aymc");
            return (Criteria) this;
        }

        public Criteria andAymcIn(List<String> values) {
            addCriterion("aymc in", values, "aymc");
            return (Criteria) this;
        }

        public Criteria andAymcNotIn(List<String> values) {
            addCriterion("aymc not in", values, "aymc");
            return (Criteria) this;
        }

        public Criteria andAymcBetween(String value1, String value2) {
            addCriterion("aymc between", value1, value2, "aymc");
            return (Criteria) this;
        }

        public Criteria andAymcNotBetween(String value1, String value2) {
            addCriterion("aymc not between", value1, value2, "aymc");
            return (Criteria) this;
        }

        public Criteria andAqIsNull() {
            addCriterion("aq is null");
            return (Criteria) this;
        }

        public Criteria andAqIsNotNull() {
            addCriterion("aq is not null");
            return (Criteria) this;
        }

        public Criteria andAqEqualTo(String value) {
            addCriterion("aq =", value, "aq");
            return (Criteria) this;
        }

        public Criteria andAqNotEqualTo(String value) {
            addCriterion("aq <>", value, "aq");
            return (Criteria) this;
        }

        public Criteria andAqGreaterThan(String value) {
            addCriterion("aq >", value, "aq");
            return (Criteria) this;
        }

        public Criteria andAqGreaterThanOrEqualTo(String value) {
            addCriterion("aq >=", value, "aq");
            return (Criteria) this;
        }

        public Criteria andAqLessThan(String value) {
            addCriterion("aq <", value, "aq");
            return (Criteria) this;
        }

        public Criteria andAqLessThanOrEqualTo(String value) {
            addCriterion("aq <=", value, "aq");
            return (Criteria) this;
        }

        public Criteria andAqLike(String value) {
            addCriterion("aq like", value, "aq");
            return (Criteria) this;
        }

        public Criteria andAqNotLike(String value) {
            addCriterion("aq not like", value, "aq");
            return (Criteria) this;
        }

        public Criteria andAqIn(List<String> values) {
            addCriterion("aq in", values, "aq");
            return (Criteria) this;
        }

        public Criteria andAqNotIn(List<String> values) {
            addCriterion("aq not in", values, "aq");
            return (Criteria) this;
        }

        public Criteria andAqBetween(String value1, String value2) {
            addCriterion("aq between", value1, value2, "aq");
            return (Criteria) this;
        }

        public Criteria andAqNotBetween(String value1, String value2) {
            addCriterion("aq not between", value1, value2, "aq");
            return (Criteria) this;
        }

        public Criteria andNianIsNull() {
            addCriterion("nian is null");
            return (Criteria) this;
        }

        public Criteria andNianIsNotNull() {
            addCriterion("nian is not null");
            return (Criteria) this;
        }

        public Criteria andNianEqualTo(Integer value) {
            addCriterion("nian =", value, "nian");
            return (Criteria) this;
        }

        public Criteria andNianNotEqualTo(Integer value) {
            addCriterion("nian <>", value, "nian");
            return (Criteria) this;
        }

        public Criteria andNianGreaterThan(Integer value) {
            addCriterion("nian >", value, "nian");
            return (Criteria) this;
        }

        public Criteria andNianGreaterThanOrEqualTo(Integer value) {
            addCriterion("nian >=", value, "nian");
            return (Criteria) this;
        }

        public Criteria andNianLessThan(Integer value) {
            addCriterion("nian <", value, "nian");
            return (Criteria) this;
        }

        public Criteria andNianLessThanOrEqualTo(Integer value) {
            addCriterion("nian <=", value, "nian");
            return (Criteria) this;
        }

        public Criteria andNianIn(List<Integer> values) {
            addCriterion("nian in", values, "nian");
            return (Criteria) this;
        }

        public Criteria andNianNotIn(List<Integer> values) {
            addCriterion("nian not in", values, "nian");
            return (Criteria) this;
        }

        public Criteria andNianBetween(Integer value1, Integer value2) {
            addCriterion("nian between", value1, value2, "nian");
            return (Criteria) this;
        }

        public Criteria andNianNotBetween(Integer value1, Integer value2) {
            addCriterion("nian not between", value1, value2, "nian");
            return (Criteria) this;
        }

        public Criteria andFyjcIsNull() {
            addCriterion("fyjc is null");
            return (Criteria) this;
        }

        public Criteria andFyjcIsNotNull() {
            addCriterion("fyjc is not null");
            return (Criteria) this;
        }

        public Criteria andFyjcEqualTo(String value) {
            addCriterion("fyjc =", value, "fyjc");
            return (Criteria) this;
        }

        public Criteria andFyjcNotEqualTo(String value) {
            addCriterion("fyjc <>", value, "fyjc");
            return (Criteria) this;
        }

        public Criteria andFyjcGreaterThan(String value) {
            addCriterion("fyjc >", value, "fyjc");
            return (Criteria) this;
        }

        public Criteria andFyjcGreaterThanOrEqualTo(String value) {
            addCriterion("fyjc >=", value, "fyjc");
            return (Criteria) this;
        }

        public Criteria andFyjcLessThan(String value) {
            addCriterion("fyjc <", value, "fyjc");
            return (Criteria) this;
        }

        public Criteria andFyjcLessThanOrEqualTo(String value) {
            addCriterion("fyjc <=", value, "fyjc");
            return (Criteria) this;
        }

        public Criteria andFyjcLike(String value) {
            addCriterion("fyjc like", value, "fyjc");
            return (Criteria) this;
        }

        public Criteria andFyjcNotLike(String value) {
            addCriterion("fyjc not like", value, "fyjc");
            return (Criteria) this;
        }

        public Criteria andFyjcIn(List<String> values) {
            addCriterion("fyjc in", values, "fyjc");
            return (Criteria) this;
        }

        public Criteria andFyjcNotIn(List<String> values) {
            addCriterion("fyjc not in", values, "fyjc");
            return (Criteria) this;
        }

        public Criteria andFyjcBetween(String value1, String value2) {
            addCriterion("fyjc between", value1, value2, "fyjc");
            return (Criteria) this;
        }

        public Criteria andFyjcNotBetween(String value1, String value2) {
            addCriterion("fyjc not between", value1, value2, "fyjc");
            return (Criteria) this;
        }

        public Criteria andAjbhIsNull() {
            addCriterion("ajbh is null");
            return (Criteria) this;
        }

        public Criteria andAjbhIsNotNull() {
            addCriterion("ajbh is not null");
            return (Criteria) this;
        }

        public Criteria andAjbhEqualTo(String value) {
            addCriterion("ajbh =", value, "ajbh");
            return (Criteria) this;
        }

        public Criteria andAjbhNotEqualTo(String value) {
            addCriterion("ajbh <>", value, "ajbh");
            return (Criteria) this;
        }

        public Criteria andAjbhGreaterThan(String value) {
            addCriterion("ajbh >", value, "ajbh");
            return (Criteria) this;
        }

        public Criteria andAjbhGreaterThanOrEqualTo(String value) {
            addCriterion("ajbh >=", value, "ajbh");
            return (Criteria) this;
        }

        public Criteria andAjbhLessThan(String value) {
            addCriterion("ajbh <", value, "ajbh");
            return (Criteria) this;
        }

        public Criteria andAjbhLessThanOrEqualTo(String value) {
            addCriterion("ajbh <=", value, "ajbh");
            return (Criteria) this;
        }

        public Criteria andAjbhLike(String value) {
            addCriterion("ajbh like", value, "ajbh");
            return (Criteria) this;
        }

        public Criteria andAjbhNotLike(String value) {
            addCriterion("ajbh not like", value, "ajbh");
            return (Criteria) this;
        }

        public Criteria andAjbhIn(List<String> values) {
            addCriterion("ajbh in", values, "ajbh");
            return (Criteria) this;
        }

        public Criteria andAjbhNotIn(List<String> values) {
            addCriterion("ajbh not in", values, "ajbh");
            return (Criteria) this;
        }

        public Criteria andAjbhBetween(String value1, String value2) {
            addCriterion("ajbh between", value1, value2, "ajbh");
            return (Criteria) this;
        }

        public Criteria andAjbhNotBetween(String value1, String value2) {
            addCriterion("ajbh not between", value1, value2, "ajbh");
            return (Criteria) this;
        }

        public Criteria andSpzhbsIsNull() {
            addCriterion("spzhbs is null");
            return (Criteria) this;
        }

        public Criteria andSpzhbsIsNotNull() {
            addCriterion("spzhbs is not null");
            return (Criteria) this;
        }

        public Criteria andSpzhbsEqualTo(String value) {
            addCriterion("spzhbs =", value, "spzhbs");
            return (Criteria) this;
        }

        public Criteria andSpzhbsNotEqualTo(String value) {
            addCriterion("spzhbs <>", value, "spzhbs");
            return (Criteria) this;
        }

        public Criteria andSpzhbsGreaterThan(String value) {
            addCriterion("spzhbs >", value, "spzhbs");
            return (Criteria) this;
        }

        public Criteria andSpzhbsGreaterThanOrEqualTo(String value) {
            addCriterion("spzhbs >=", value, "spzhbs");
            return (Criteria) this;
        }

        public Criteria andSpzhbsLessThan(String value) {
            addCriterion("spzhbs <", value, "spzhbs");
            return (Criteria) this;
        }

        public Criteria andSpzhbsLessThanOrEqualTo(String value) {
            addCriterion("spzhbs <=", value, "spzhbs");
            return (Criteria) this;
        }

        public Criteria andSpzhbsLike(String value) {
            addCriterion("spzhbs like", value, "spzhbs");
            return (Criteria) this;
        }

        public Criteria andSpzhbsNotLike(String value) {
            addCriterion("spzhbs not like", value, "spzhbs");
            return (Criteria) this;
        }

        public Criteria andSpzhbsIn(List<String> values) {
            addCriterion("spzhbs in", values, "spzhbs");
            return (Criteria) this;
        }

        public Criteria andSpzhbsNotIn(List<String> values) {
            addCriterion("spzhbs not in", values, "spzhbs");
            return (Criteria) this;
        }

        public Criteria andSpzhbsBetween(String value1, String value2) {
            addCriterion("spzhbs between", value1, value2, "spzhbs");
            return (Criteria) this;
        }

        public Criteria andSpzhbsNotBetween(String value1, String value2) {
            addCriterion("spzhbs not between", value1, value2, "spzhbs");
            return (Criteria) this;
        }

        public Criteria andSpzhIsNull() {
            addCriterion("spzh is null");
            return (Criteria) this;
        }

        public Criteria andSpzhIsNotNull() {
            addCriterion("spzh is not null");
            return (Criteria) this;
        }

        public Criteria andSpzhEqualTo(String value) {
            addCriterion("spzh =", value, "spzh");
            return (Criteria) this;
        }

        public Criteria andSpzhNotEqualTo(String value) {
            addCriterion("spzh <>", value, "spzh");
            return (Criteria) this;
        }

        public Criteria andSpzhGreaterThan(String value) {
            addCriterion("spzh >", value, "spzh");
            return (Criteria) this;
        }

        public Criteria andSpzhGreaterThanOrEqualTo(String value) {
            addCriterion("spzh >=", value, "spzh");
            return (Criteria) this;
        }

        public Criteria andSpzhLessThan(String value) {
            addCriterion("spzh <", value, "spzh");
            return (Criteria) this;
        }

        public Criteria andSpzhLessThanOrEqualTo(String value) {
            addCriterion("spzh <=", value, "spzh");
            return (Criteria) this;
        }

        public Criteria andSpzhLike(String value) {
            addCriterion("spzh like", value, "spzh");
            return (Criteria) this;
        }

        public Criteria andSpzhNotLike(String value) {
            addCriterion("spzh not like", value, "spzh");
            return (Criteria) this;
        }

        public Criteria andSpzhIn(List<String> values) {
            addCriterion("spzh in", values, "spzh");
            return (Criteria) this;
        }

        public Criteria andSpzhNotIn(List<String> values) {
            addCriterion("spzh not in", values, "spzh");
            return (Criteria) this;
        }

        public Criteria andSpzhBetween(String value1, String value2) {
            addCriterion("spzh between", value1, value2, "spzh");
            return (Criteria) this;
        }

        public Criteria andSpzhNotBetween(String value1, String value2) {
            addCriterion("spzh not between", value1, value2, "spzh");
            return (Criteria) this;
        }

        public Criteria andAhIsNull() {
            addCriterion("ah is null");
            return (Criteria) this;
        }

        public Criteria andAhIsNotNull() {
            addCriterion("ah is not null");
            return (Criteria) this;
        }

        public Criteria andAhEqualTo(String value) {
            addCriterion("ah =", value, "ah");
            return (Criteria) this;
        }

        public Criteria andAhNotEqualTo(String value) {
            addCriterion("ah <>", value, "ah");
            return (Criteria) this;
        }

        public Criteria andAhGreaterThan(String value) {
            addCriterion("ah >", value, "ah");
            return (Criteria) this;
        }

        public Criteria andAhGreaterThanOrEqualTo(String value) {
            addCriterion("ah >=", value, "ah");
            return (Criteria) this;
        }

        public Criteria andAhLessThan(String value) {
            addCriterion("ah <", value, "ah");
            return (Criteria) this;
        }

        public Criteria andAhLessThanOrEqualTo(String value) {
            addCriterion("ah <=", value, "ah");
            return (Criteria) this;
        }

        public Criteria andAhLike(String value) {
            addCriterion("ah like", value, "ah");
            return (Criteria) this;
        }

        public Criteria andAhNotLike(String value) {
            addCriterion("ah not like", value, "ah");
            return (Criteria) this;
        }

        public Criteria andAhIn(List<String> values) {
            addCriterion("ah in", values, "ah");
            return (Criteria) this;
        }

        public Criteria andAhNotIn(List<String> values) {
            addCriterion("ah not in", values, "ah");
            return (Criteria) this;
        }

        public Criteria andAhBetween(String value1, String value2) {
            addCriterion("ah between", value1, value2, "ah");
            return (Criteria) this;
        }

        public Criteria andAhNotBetween(String value1, String value2) {
            addCriterion("ah not between", value1, value2, "ah");
            return (Criteria) this;
        }

        public Criteria andLarqIsNull() {
            addCriterion("larq is null");
            return (Criteria) this;
        }

        public Criteria andLarqIsNotNull() {
            addCriterion("larq is not null");
            return (Criteria) this;
        }

        public Criteria andLarqEqualTo(String value) {
            addCriterion("larq =", value, "larq");
            return (Criteria) this;
        }

        public Criteria andLarqNotEqualTo(String value) {
            addCriterion("larq <>", value, "larq");
            return (Criteria) this;
        }

        public Criteria andLarqGreaterThan(String value) {
            addCriterion("larq >", value, "larq");
            return (Criteria) this;
        }

        public Criteria andLarqGreaterThanOrEqualTo(String value) {
            addCriterion("larq >=", value, "larq");
            return (Criteria) this;
        }

        public Criteria andLarqLessThan(String value) {
            addCriterion("larq <", value, "larq");
            return (Criteria) this;
        }

        public Criteria andLarqLessThanOrEqualTo(String value) {
            addCriterion("larq <=", value, "larq");
            return (Criteria) this;
        }

        public Criteria andLarqLike(String value) {
            addCriterion("larq like", value, "larq");
            return (Criteria) this;
        }

        public Criteria andLarqNotLike(String value) {
            addCriterion("larq not like", value, "larq");
            return (Criteria) this;
        }

        public Criteria andLarqIn(List<String> values) {
            addCriterion("larq in", values, "larq");
            return (Criteria) this;
        }

        public Criteria andLarqNotIn(List<String> values) {
            addCriterion("larq not in", values, "larq");
            return (Criteria) this;
        }

        public Criteria andLarqBetween(String value1, String value2) {
            addCriterion("larq between", value1, value2, "larq");
            return (Criteria) this;
        }

        public Criteria andLarqNotBetween(String value1, String value2) {
            addCriterion("larq not between", value1, value2, "larq");
            return (Criteria) this;
        }

        public Criteria andCbsptbsIsNull() {
            addCriterion("cbsptbs is null");
            return (Criteria) this;
        }

        public Criteria andCbsptbsIsNotNull() {
            addCriterion("cbsptbs is not null");
            return (Criteria) this;
        }

        public Criteria andCbsptbsEqualTo(String value) {
            addCriterion("cbsptbs =", value, "cbsptbs");
            return (Criteria) this;
        }

        public Criteria andCbsptbsNotEqualTo(String value) {
            addCriterion("cbsptbs <>", value, "cbsptbs");
            return (Criteria) this;
        }

        public Criteria andCbsptbsGreaterThan(String value) {
            addCriterion("cbsptbs >", value, "cbsptbs");
            return (Criteria) this;
        }

        public Criteria andCbsptbsGreaterThanOrEqualTo(String value) {
            addCriterion("cbsptbs >=", value, "cbsptbs");
            return (Criteria) this;
        }

        public Criteria andCbsptbsLessThan(String value) {
            addCriterion("cbsptbs <", value, "cbsptbs");
            return (Criteria) this;
        }

        public Criteria andCbsptbsLessThanOrEqualTo(String value) {
            addCriterion("cbsptbs <=", value, "cbsptbs");
            return (Criteria) this;
        }

        public Criteria andCbsptbsLike(String value) {
            addCriterion("cbsptbs like", value, "cbsptbs");
            return (Criteria) this;
        }

        public Criteria andCbsptbsNotLike(String value) {
            addCriterion("cbsptbs not like", value, "cbsptbs");
            return (Criteria) this;
        }

        public Criteria andCbsptbsIn(List<String> values) {
            addCriterion("cbsptbs in", values, "cbsptbs");
            return (Criteria) this;
        }

        public Criteria andCbsptbsNotIn(List<String> values) {
            addCriterion("cbsptbs not in", values, "cbsptbs");
            return (Criteria) this;
        }

        public Criteria andCbsptbsBetween(String value1, String value2) {
            addCriterion("cbsptbs between", value1, value2, "cbsptbs");
            return (Criteria) this;
        }

        public Criteria andCbsptbsNotBetween(String value1, String value2) {
            addCriterion("cbsptbs not between", value1, value2, "cbsptbs");
            return (Criteria) this;
        }

        public Criteria andCbsptIsNull() {
            addCriterion("cbspt is null");
            return (Criteria) this;
        }

        public Criteria andCbsptIsNotNull() {
            addCriterion("cbspt is not null");
            return (Criteria) this;
        }

        public Criteria andCbsptEqualTo(String value) {
            addCriterion("cbspt =", value, "cbspt");
            return (Criteria) this;
        }

        public Criteria andCbsptNotEqualTo(String value) {
            addCriterion("cbspt <>", value, "cbspt");
            return (Criteria) this;
        }

        public Criteria andCbsptGreaterThan(String value) {
            addCriterion("cbspt >", value, "cbspt");
            return (Criteria) this;
        }

        public Criteria andCbsptGreaterThanOrEqualTo(String value) {
            addCriterion("cbspt >=", value, "cbspt");
            return (Criteria) this;
        }

        public Criteria andCbsptLessThan(String value) {
            addCriterion("cbspt <", value, "cbspt");
            return (Criteria) this;
        }

        public Criteria andCbsptLessThanOrEqualTo(String value) {
            addCriterion("cbspt <=", value, "cbspt");
            return (Criteria) this;
        }

        public Criteria andCbsptLike(String value) {
            addCriterion("cbspt like", value, "cbspt");
            return (Criteria) this;
        }

        public Criteria andCbsptNotLike(String value) {
            addCriterion("cbspt not like", value, "cbspt");
            return (Criteria) this;
        }

        public Criteria andCbsptIn(List<String> values) {
            addCriterion("cbspt in", values, "cbspt");
            return (Criteria) this;
        }

        public Criteria andCbsptNotIn(List<String> values) {
            addCriterion("cbspt not in", values, "cbspt");
            return (Criteria) this;
        }

        public Criteria andCbsptBetween(String value1, String value2) {
            addCriterion("cbspt between", value1, value2, "cbspt");
            return (Criteria) this;
        }

        public Criteria andCbsptNotBetween(String value1, String value2) {
            addCriterion("cbspt not between", value1, value2, "cbspt");
            return (Criteria) this;
        }

        public Criteria andCbrbsIsNull() {
            addCriterion("cbrbs is null");
            return (Criteria) this;
        }

        public Criteria andCbrbsIsNotNull() {
            addCriterion("cbrbs is not null");
            return (Criteria) this;
        }

        public Criteria andCbrbsEqualTo(String value) {
            addCriterion("cbrbs =", value, "cbrbs");
            return (Criteria) this;
        }

        public Criteria andCbrbsNotEqualTo(String value) {
            addCriterion("cbrbs <>", value, "cbrbs");
            return (Criteria) this;
        }

        public Criteria andCbrbsGreaterThan(String value) {
            addCriterion("cbrbs >", value, "cbrbs");
            return (Criteria) this;
        }

        public Criteria andCbrbsGreaterThanOrEqualTo(String value) {
            addCriterion("cbrbs >=", value, "cbrbs");
            return (Criteria) this;
        }

        public Criteria andCbrbsLessThan(String value) {
            addCriterion("cbrbs <", value, "cbrbs");
            return (Criteria) this;
        }

        public Criteria andCbrbsLessThanOrEqualTo(String value) {
            addCriterion("cbrbs <=", value, "cbrbs");
            return (Criteria) this;
        }

        public Criteria andCbrbsLike(String value) {
            addCriterion("cbrbs like", value, "cbrbs");
            return (Criteria) this;
        }

        public Criteria andCbrbsNotLike(String value) {
            addCriterion("cbrbs not like", value, "cbrbs");
            return (Criteria) this;
        }

        public Criteria andCbrbsIn(List<String> values) {
            addCriterion("cbrbs in", values, "cbrbs");
            return (Criteria) this;
        }

        public Criteria andCbrbsNotIn(List<String> values) {
            addCriterion("cbrbs not in", values, "cbrbs");
            return (Criteria) this;
        }

        public Criteria andCbrbsBetween(String value1, String value2) {
            addCriterion("cbrbs between", value1, value2, "cbrbs");
            return (Criteria) this;
        }

        public Criteria andCbrbsNotBetween(String value1, String value2) {
            addCriterion("cbrbs not between", value1, value2, "cbrbs");
            return (Criteria) this;
        }

        public Criteria andCbrIsNull() {
            addCriterion("cbr is null");
            return (Criteria) this;
        }

        public Criteria andCbrIsNotNull() {
            addCriterion("cbr is not null");
            return (Criteria) this;
        }

        public Criteria andCbrEqualTo(String value) {
            addCriterion("cbr =", value, "cbr");
            return (Criteria) this;
        }

        public Criteria andCbrNotEqualTo(String value) {
            addCriterion("cbr <>", value, "cbr");
            return (Criteria) this;
        }

        public Criteria andCbrGreaterThan(String value) {
            addCriterion("cbr >", value, "cbr");
            return (Criteria) this;
        }

        public Criteria andCbrGreaterThanOrEqualTo(String value) {
            addCriterion("cbr >=", value, "cbr");
            return (Criteria) this;
        }

        public Criteria andCbrLessThan(String value) {
            addCriterion("cbr <", value, "cbr");
            return (Criteria) this;
        }

        public Criteria andCbrLessThanOrEqualTo(String value) {
            addCriterion("cbr <=", value, "cbr");
            return (Criteria) this;
        }

        public Criteria andCbrLike(String value) {
            addCriterion("cbr like", value, "cbr");
            return (Criteria) this;
        }

        public Criteria andCbrNotLike(String value) {
            addCriterion("cbr not like", value, "cbr");
            return (Criteria) this;
        }

        public Criteria andCbrIn(List<String> values) {
            addCriterion("cbr in", values, "cbr");
            return (Criteria) this;
        }

        public Criteria andCbrNotIn(List<String> values) {
            addCriterion("cbr not in", values, "cbr");
            return (Criteria) this;
        }

        public Criteria andCbrBetween(String value1, String value2) {
            addCriterion("cbr between", value1, value2, "cbr");
            return (Criteria) this;
        }

        public Criteria andCbrNotBetween(String value1, String value2) {
            addCriterion("cbr not between", value1, value2, "cbr");
            return (Criteria) this;
        }

        public Criteria andSychIsNull() {
            addCriterion("sych is null");
            return (Criteria) this;
        }

        public Criteria andSychIsNotNull() {
            addCriterion("sych is not null");
            return (Criteria) this;
        }

        public Criteria andSychEqualTo(Integer value) {
            addCriterion("sych =", value, "sych");
            return (Criteria) this;
        }

        public Criteria andSychNotEqualTo(Integer value) {
            addCriterion("sych <>", value, "sych");
            return (Criteria) this;
        }

        public Criteria andSychGreaterThan(Integer value) {
            addCriterion("sych >", value, "sych");
            return (Criteria) this;
        }

        public Criteria andSychGreaterThanOrEqualTo(Integer value) {
            addCriterion("sych >=", value, "sych");
            return (Criteria) this;
        }

        public Criteria andSychLessThan(Integer value) {
            addCriterion("sych <", value, "sych");
            return (Criteria) this;
        }

        public Criteria andSychLessThanOrEqualTo(Integer value) {
            addCriterion("sych <=", value, "sych");
            return (Criteria) this;
        }

        public Criteria andSychIn(List<Integer> values) {
            addCriterion("sych in", values, "sych");
            return (Criteria) this;
        }

        public Criteria andSychNotIn(List<Integer> values) {
            addCriterion("sych not in", values, "sych");
            return (Criteria) this;
        }

        public Criteria andSychBetween(Integer value1, Integer value2) {
            addCriterion("sych between", value1, value2, "sych");
            return (Criteria) this;
        }

        public Criteria andSychNotBetween(Integer value1, Integer value2) {
            addCriterion("sych not between", value1, value2, "sych");
            return (Criteria) this;
        }

        public Criteria andSfgkIsNull() {
            addCriterion("sfgk is null");
            return (Criteria) this;
        }

        public Criteria andSfgkIsNotNull() {
            addCriterion("sfgk is not null");
            return (Criteria) this;
        }

        public Criteria andSfgkEqualTo(Integer value) {
            addCriterion("sfgk =", value, "sfgk");
            return (Criteria) this;
        }

        public Criteria andSfgkNotEqualTo(Integer value) {
            addCriterion("sfgk <>", value, "sfgk");
            return (Criteria) this;
        }

        public Criteria andSfgkGreaterThan(Integer value) {
            addCriterion("sfgk >", value, "sfgk");
            return (Criteria) this;
        }

        public Criteria andSfgkGreaterThanOrEqualTo(Integer value) {
            addCriterion("sfgk >=", value, "sfgk");
            return (Criteria) this;
        }

        public Criteria andSfgkLessThan(Integer value) {
            addCriterion("sfgk <", value, "sfgk");
            return (Criteria) this;
        }

        public Criteria andSfgkLessThanOrEqualTo(Integer value) {
            addCriterion("sfgk <=", value, "sfgk");
            return (Criteria) this;
        }

        public Criteria andSfgkIn(List<Integer> values) {
            addCriterion("sfgk in", values, "sfgk");
            return (Criteria) this;
        }

        public Criteria andSfgkNotIn(List<Integer> values) {
            addCriterion("sfgk not in", values, "sfgk");
            return (Criteria) this;
        }

        public Criteria andSfgkBetween(Integer value1, Integer value2) {
            addCriterion("sfgk between", value1, value2, "sfgk");
            return (Criteria) this;
        }

        public Criteria andSfgkNotBetween(Integer value1, Integer value2) {
            addCriterion("sfgk not between", value1, value2, "sfgk");
            return (Criteria) this;
        }

        public Criteria andDwidIsNull() {
            addCriterion("dwid is null");
            return (Criteria) this;
        }

        public Criteria andDwidIsNotNull() {
            addCriterion("dwid is not null");
            return (Criteria) this;
        }

        public Criteria andDwidEqualTo(String value) {
            addCriterion("dwid =", value, "dwid");
            return (Criteria) this;
        }

        public Criteria andDwidNotEqualTo(String value) {
            addCriterion("dwid <>", value, "dwid");
            return (Criteria) this;
        }

        public Criteria andDwidGreaterThan(String value) {
            addCriterion("dwid >", value, "dwid");
            return (Criteria) this;
        }

        public Criteria andDwidGreaterThanOrEqualTo(String value) {
            addCriterion("dwid >=", value, "dwid");
            return (Criteria) this;
        }

        public Criteria andDwidLessThan(String value) {
            addCriterion("dwid <", value, "dwid");
            return (Criteria) this;
        }

        public Criteria andDwidLessThanOrEqualTo(String value) {
            addCriterion("dwid <=", value, "dwid");
            return (Criteria) this;
        }

        public Criteria andDwidLike(String value) {
            addCriterion("dwid like", value, "dwid");
            return (Criteria) this;
        }

        public Criteria andDwidNotLike(String value) {
            addCriterion("dwid not like", value, "dwid");
            return (Criteria) this;
        }

        public Criteria andDwidIn(List<String> values) {
            addCriterion("dwid in", values, "dwid");
            return (Criteria) this;
        }

        public Criteria andDwidNotIn(List<String> values) {
            addCriterion("dwid not in", values, "dwid");
            return (Criteria) this;
        }

        public Criteria andDwidBetween(String value1, String value2) {
            addCriterion("dwid between", value1, value2, "dwid");
            return (Criteria) this;
        }

        public Criteria andDwidNotBetween(String value1, String value2) {
            addCriterion("dwid not between", value1, value2, "dwid");
            return (Criteria) this;
        }

        public Criteria andZtbsIsNull() {
            addCriterion("ztbs is null");
            return (Criteria) this;
        }

        public Criteria andZtbsIsNotNull() {
            addCriterion("ztbs is not null");
            return (Criteria) this;
        }

        public Criteria andZtbsEqualTo(Integer value) {
            addCriterion("ztbs =", value, "ztbs");
            return (Criteria) this;
        }

        public Criteria andZtbsNotEqualTo(Integer value) {
            addCriterion("ztbs <>", value, "ztbs");
            return (Criteria) this;
        }

        public Criteria andZtbsGreaterThan(Integer value) {
            addCriterion("ztbs >", value, "ztbs");
            return (Criteria) this;
        }

        public Criteria andZtbsGreaterThanOrEqualTo(Integer value) {
            addCriterion("ztbs >=", value, "ztbs");
            return (Criteria) this;
        }

        public Criteria andZtbsLessThan(Integer value) {
            addCriterion("ztbs <", value, "ztbs");
            return (Criteria) this;
        }

        public Criteria andZtbsLessThanOrEqualTo(Integer value) {
            addCriterion("ztbs <=", value, "ztbs");
            return (Criteria) this;
        }

        public Criteria andZtbsIn(List<Integer> values) {
            addCriterion("ztbs in", values, "ztbs");
            return (Criteria) this;
        }

        public Criteria andZtbsNotIn(List<Integer> values) {
            addCriterion("ztbs not in", values, "ztbs");
            return (Criteria) this;
        }

        public Criteria andZtbsBetween(Integer value1, Integer value2) {
            addCriterion("ztbs between", value1, value2, "ztbs");
            return (Criteria) this;
        }

        public Criteria andZtbsNotBetween(Integer value1, Integer value2) {
            addCriterion("ztbs not between", value1, value2, "ztbs");
            return (Criteria) this;
        }

        public Criteria andDsrIsNull() {
            addCriterion("dsr is null");
            return (Criteria) this;
        }

        public Criteria andDsrIsNotNull() {
            addCriterion("dsr is not null");
            return (Criteria) this;
        }

        public Criteria andDsrEqualTo(String value) {
            addCriterion("dsr =", value, "dsr");
            return (Criteria) this;
        }

        public Criteria andDsrNotEqualTo(String value) {
            addCriterion("dsr <>", value, "dsr");
            return (Criteria) this;
        }

        public Criteria andDsrGreaterThan(String value) {
            addCriterion("dsr >", value, "dsr");
            return (Criteria) this;
        }

        public Criteria andDsrGreaterThanOrEqualTo(String value) {
            addCriterion("dsr >=", value, "dsr");
            return (Criteria) this;
        }

        public Criteria andDsrLessThan(String value) {
            addCriterion("dsr <", value, "dsr");
            return (Criteria) this;
        }

        public Criteria andDsrLessThanOrEqualTo(String value) {
            addCriterion("dsr <=", value, "dsr");
            return (Criteria) this;
        }

        public Criteria andDsrLike(String value) {
            addCriterion("dsr like", value, "dsr");
            return (Criteria) this;
        }

        public Criteria andDsrNotLike(String value) {
            addCriterion("dsr not like", value, "dsr");
            return (Criteria) this;
        }

        public Criteria andDsrIn(List<String> values) {
            addCriterion("dsr in", values, "dsr");
            return (Criteria) this;
        }

        public Criteria andDsrNotIn(List<String> values) {
            addCriterion("dsr not in", values, "dsr");
            return (Criteria) this;
        }

        public Criteria andDsrBetween(String value1, String value2) {
            addCriterion("dsr between", value1, value2, "dsr");
            return (Criteria) this;
        }

        public Criteria andDsrNotBetween(String value1, String value2) {
            addCriterion("dsr not between", value1, value2, "dsr");
            return (Criteria) this;
        }

        public Criteria andAjcsIsNull() {
            addCriterion("ajcs is null");
            return (Criteria) this;
        }

        public Criteria andAjcsIsNotNull() {
            addCriterion("ajcs is not null");
            return (Criteria) this;
        }

        public Criteria andAjcsEqualTo(Integer value) {
            addCriterion("ajcs =", value, "ajcs");
            return (Criteria) this;
        }

        public Criteria andAjcsNotEqualTo(Integer value) {
            addCriterion("ajcs <>", value, "ajcs");
            return (Criteria) this;
        }

        public Criteria andAjcsGreaterThan(Integer value) {
            addCriterion("ajcs >", value, "ajcs");
            return (Criteria) this;
        }

        public Criteria andAjcsGreaterThanOrEqualTo(Integer value) {
            addCriterion("ajcs >=", value, "ajcs");
            return (Criteria) this;
        }

        public Criteria andAjcsLessThan(Integer value) {
            addCriterion("ajcs <", value, "ajcs");
            return (Criteria) this;
        }

        public Criteria andAjcsLessThanOrEqualTo(Integer value) {
            addCriterion("ajcs <=", value, "ajcs");
            return (Criteria) this;
        }

        public Criteria andAjcsIn(List<Integer> values) {
            addCriterion("ajcs in", values, "ajcs");
            return (Criteria) this;
        }

        public Criteria andAjcsNotIn(List<Integer> values) {
            addCriterion("ajcs not in", values, "ajcs");
            return (Criteria) this;
        }

        public Criteria andAjcsBetween(Integer value1, Integer value2) {
            addCriterion("ajcs between", value1, value2, "ajcs");
            return (Criteria) this;
        }

        public Criteria andAjcsNotBetween(Integer value1, Integer value2) {
            addCriterion("ajcs not between", value1, value2, "ajcs");
            return (Criteria) this;
        }

        public Criteria andFtytIsNull() {
            addCriterion("ftyt is null");
            return (Criteria) this;
        }

        public Criteria andFtytIsNotNull() {
            addCriterion("ftyt is not null");
            return (Criteria) this;
        }

        public Criteria andFtytEqualTo(Integer value) {
            addCriterion("ftyt =", value, "ftyt");
            return (Criteria) this;
        }

        public Criteria andFtytNotEqualTo(Integer value) {
            addCriterion("ftyt <>", value, "ftyt");
            return (Criteria) this;
        }

        public Criteria andFtytGreaterThan(Integer value) {
            addCriterion("ftyt >", value, "ftyt");
            return (Criteria) this;
        }

        public Criteria andFtytGreaterThanOrEqualTo(Integer value) {
            addCriterion("ftyt >=", value, "ftyt");
            return (Criteria) this;
        }

        public Criteria andFtytLessThan(Integer value) {
            addCriterion("ftyt <", value, "ftyt");
            return (Criteria) this;
        }

        public Criteria andFtytLessThanOrEqualTo(Integer value) {
            addCriterion("ftyt <=", value, "ftyt");
            return (Criteria) this;
        }

        public Criteria andFtytIn(List<Integer> values) {
            addCriterion("ftyt in", values, "ftyt");
            return (Criteria) this;
        }

        public Criteria andFtytNotIn(List<Integer> values) {
            addCriterion("ftyt not in", values, "ftyt");
            return (Criteria) this;
        }

        public Criteria andFtytBetween(Integer value1, Integer value2) {
            addCriterion("ftyt between", value1, value2, "ftyt");
            return (Criteria) this;
        }

        public Criteria andFtytNotBetween(Integer value1, Integer value2) {
            addCriterion("ftyt not between", value1, value2, "ftyt");
            return (Criteria) this;
        }

        public Criteria andTcIsNull() {
            addCriterion("tc is null");
            return (Criteria) this;
        }

        public Criteria andTcIsNotNull() {
            addCriterion("tc is not null");
            return (Criteria) this;
        }

        public Criteria andTcEqualTo(Integer value) {
            addCriterion("tc =", value, "tc");
            return (Criteria) this;
        }

        public Criteria andTcNotEqualTo(Integer value) {
            addCriterion("tc <>", value, "tc");
            return (Criteria) this;
        }

        public Criteria andTcGreaterThan(Integer value) {
            addCriterion("tc >", value, "tc");
            return (Criteria) this;
        }

        public Criteria andTcGreaterThanOrEqualTo(Integer value) {
            addCriterion("tc >=", value, "tc");
            return (Criteria) this;
        }

        public Criteria andTcLessThan(Integer value) {
            addCriterion("tc <", value, "tc");
            return (Criteria) this;
        }

        public Criteria andTcLessThanOrEqualTo(Integer value) {
            addCriterion("tc <=", value, "tc");
            return (Criteria) this;
        }

        public Criteria andTcIn(List<Integer> values) {
            addCriterion("tc in", values, "tc");
            return (Criteria) this;
        }

        public Criteria andTcNotIn(List<Integer> values) {
            addCriterion("tc not in", values, "tc");
            return (Criteria) this;
        }

        public Criteria andTcBetween(Integer value1, Integer value2) {
            addCriterion("tc between", value1, value2, "tc");
            return (Criteria) this;
        }

        public Criteria andTcNotBetween(Integer value1, Integer value2) {
            addCriterion("tc not between", value1, value2, "tc");
            return (Criteria) this;
        }

        public Criteria andKsrqIsNull() {
            addCriterion("ksrq is null");
            return (Criteria) this;
        }

        public Criteria andKsrqIsNotNull() {
            addCriterion("ksrq is not null");
            return (Criteria) this;
        }

        public Criteria andKsrqEqualTo(String value) {
            addCriterion("ksrq =", value, "ksrq");
            return (Criteria) this;
        }

        public Criteria andKsrqNotEqualTo(String value) {
            addCriterion("ksrq <>", value, "ksrq");
            return (Criteria) this;
        }

        public Criteria andKsrqGreaterThan(String value) {
            addCriterion("ksrq >", value, "ksrq");
            return (Criteria) this;
        }

        public Criteria andKsrqGreaterThanOrEqualTo(String value) {
            addCriterion("ksrq >=", value, "ksrq");
            return (Criteria) this;
        }

        public Criteria andKsrqLessThan(String value) {
            addCriterion("ksrq <", value, "ksrq");
            return (Criteria) this;
        }

        public Criteria andKsrqLessThanOrEqualTo(String value) {
            addCriterion("ksrq <=", value, "ksrq");
            return (Criteria) this;
        }

        public Criteria andKsrqLike(String value) {
            addCriterion("ksrq like", value, "ksrq");
            return (Criteria) this;
        }

        public Criteria andKsrqNotLike(String value) {
            addCriterion("ksrq not like", value, "ksrq");
            return (Criteria) this;
        }

        public Criteria andKsrqIn(List<String> values) {
            addCriterion("ksrq in", values, "ksrq");
            return (Criteria) this;
        }

        public Criteria andKsrqNotIn(List<String> values) {
            addCriterion("ksrq not in", values, "ksrq");
            return (Criteria) this;
        }

        public Criteria andKsrqBetween(String value1, String value2) {
            addCriterion("ksrq between", value1, value2, "ksrq");
            return (Criteria) this;
        }

        public Criteria andKsrqNotBetween(String value1, String value2) {
            addCriterion("ksrq not between", value1, value2, "ksrq");
            return (Criteria) this;
        }

        public Criteria andKssjIsNull() {
            addCriterion("kssj is null");
            return (Criteria) this;
        }

        public Criteria andKssjIsNotNull() {
            addCriterion("kssj is not null");
            return (Criteria) this;
        }

        public Criteria andKssjEqualTo(String value) {
            addCriterion("kssj =", value, "kssj");
            return (Criteria) this;
        }

        public Criteria andKssjNotEqualTo(String value) {
            addCriterion("kssj <>", value, "kssj");
            return (Criteria) this;
        }

        public Criteria andKssjGreaterThan(String value) {
            addCriterion("kssj >", value, "kssj");
            return (Criteria) this;
        }

        public Criteria andKssjGreaterThanOrEqualTo(String value) {
            addCriterion("kssj >=", value, "kssj");
            return (Criteria) this;
        }

        public Criteria andKssjLessThan(String value) {
            addCriterion("kssj <", value, "kssj");
            return (Criteria) this;
        }

        public Criteria andKssjLessThanOrEqualTo(String value) {
            addCriterion("kssj <=", value, "kssj");
            return (Criteria) this;
        }

        public Criteria andKssjLike(String value) {
            addCriterion("kssj like", value, "kssj");
            return (Criteria) this;
        }

        public Criteria andKssjNotLike(String value) {
            addCriterion("kssj not like", value, "kssj");
            return (Criteria) this;
        }

        public Criteria andKssjIn(List<String> values) {
            addCriterion("kssj in", values, "kssj");
            return (Criteria) this;
        }

        public Criteria andKssjNotIn(List<String> values) {
            addCriterion("kssj not in", values, "kssj");
            return (Criteria) this;
        }

        public Criteria andKssjBetween(String value1, String value2) {
            addCriterion("kssj between", value1, value2, "kssj");
            return (Criteria) this;
        }

        public Criteria andKssjNotBetween(String value1, String value2) {
            addCriterion("kssj not between", value1, value2, "kssj");
            return (Criteria) this;
        }

        public Criteria andJsrqIsNull() {
            addCriterion("jsrq is null");
            return (Criteria) this;
        }

        public Criteria andJsrqIsNotNull() {
            addCriterion("jsrq is not null");
            return (Criteria) this;
        }

        public Criteria andJsrqEqualTo(String value) {
            addCriterion("jsrq =", value, "jsrq");
            return (Criteria) this;
        }

        public Criteria andJsrqNotEqualTo(String value) {
            addCriterion("jsrq <>", value, "jsrq");
            return (Criteria) this;
        }

        public Criteria andJsrqGreaterThan(String value) {
            addCriterion("jsrq >", value, "jsrq");
            return (Criteria) this;
        }

        public Criteria andJsrqGreaterThanOrEqualTo(String value) {
            addCriterion("jsrq >=", value, "jsrq");
            return (Criteria) this;
        }

        public Criteria andJsrqLessThan(String value) {
            addCriterion("jsrq <", value, "jsrq");
            return (Criteria) this;
        }

        public Criteria andJsrqLessThanOrEqualTo(String value) {
            addCriterion("jsrq <=", value, "jsrq");
            return (Criteria) this;
        }

        public Criteria andJsrqLike(String value) {
            addCriterion("jsrq like", value, "jsrq");
            return (Criteria) this;
        }

        public Criteria andJsrqNotLike(String value) {
            addCriterion("jsrq not like", value, "jsrq");
            return (Criteria) this;
        }

        public Criteria andJsrqIn(List<String> values) {
            addCriterion("jsrq in", values, "jsrq");
            return (Criteria) this;
        }

        public Criteria andJsrqNotIn(List<String> values) {
            addCriterion("jsrq not in", values, "jsrq");
            return (Criteria) this;
        }

        public Criteria andJsrqBetween(String value1, String value2) {
            addCriterion("jsrq between", value1, value2, "jsrq");
            return (Criteria) this;
        }

        public Criteria andJsrqNotBetween(String value1, String value2) {
            addCriterion("jsrq not between", value1, value2, "jsrq");
            return (Criteria) this;
        }

        public Criteria andJssjIsNull() {
            addCriterion("jssj is null");
            return (Criteria) this;
        }

        public Criteria andJssjIsNotNull() {
            addCriterion("jssj is not null");
            return (Criteria) this;
        }

        public Criteria andJssjEqualTo(String value) {
            addCriterion("jssj =", value, "jssj");
            return (Criteria) this;
        }

        public Criteria andJssjNotEqualTo(String value) {
            addCriterion("jssj <>", value, "jssj");
            return (Criteria) this;
        }

        public Criteria andJssjGreaterThan(String value) {
            addCriterion("jssj >", value, "jssj");
            return (Criteria) this;
        }

        public Criteria andJssjGreaterThanOrEqualTo(String value) {
            addCriterion("jssj >=", value, "jssj");
            return (Criteria) this;
        }

        public Criteria andJssjLessThan(String value) {
            addCriterion("jssj <", value, "jssj");
            return (Criteria) this;
        }

        public Criteria andJssjLessThanOrEqualTo(String value) {
            addCriterion("jssj <=", value, "jssj");
            return (Criteria) this;
        }

        public Criteria andJssjLike(String value) {
            addCriterion("jssj like", value, "jssj");
            return (Criteria) this;
        }

        public Criteria andJssjNotLike(String value) {
            addCriterion("jssj not like", value, "jssj");
            return (Criteria) this;
        }

        public Criteria andJssjIn(List<String> values) {
            addCriterion("jssj in", values, "jssj");
            return (Criteria) this;
        }

        public Criteria andJssjNotIn(List<String> values) {
            addCriterion("jssj not in", values, "jssj");
            return (Criteria) this;
        }

        public Criteria andJssjBetween(String value1, String value2) {
            addCriterion("jssj between", value1, value2, "jssj");
            return (Criteria) this;
        }

        public Criteria andJssjNotBetween(String value1, String value2) {
            addCriterion("jssj not between", value1, value2, "jssj");
            return (Criteria) this;
        }

        public Criteria andFtidIsNull() {
            addCriterion("ftid is null");
            return (Criteria) this;
        }

        public Criteria andFtidIsNotNull() {
            addCriterion("ftid is not null");
            return (Criteria) this;
        }

        public Criteria andFtidEqualTo(String value) {
            addCriterion("ftid =", value, "ftid");
            return (Criteria) this;
        }

        public Criteria andFtidNotEqualTo(String value) {
            addCriterion("ftid <>", value, "ftid");
            return (Criteria) this;
        }

        public Criteria andFtidGreaterThan(String value) {
            addCriterion("ftid >", value, "ftid");
            return (Criteria) this;
        }

        public Criteria andFtidGreaterThanOrEqualTo(String value) {
            addCriterion("ftid >=", value, "ftid");
            return (Criteria) this;
        }

        public Criteria andFtidLessThan(String value) {
            addCriterion("ftid <", value, "ftid");
            return (Criteria) this;
        }

        public Criteria andFtidLessThanOrEqualTo(String value) {
            addCriterion("ftid <=", value, "ftid");
            return (Criteria) this;
        }

        public Criteria andFtidLike(String value) {
            addCriterion("ftid like", value, "ftid");
            return (Criteria) this;
        }

        public Criteria andFtidNotLike(String value) {
            addCriterion("ftid not like", value, "ftid");
            return (Criteria) this;
        }

        public Criteria andFtidIn(List<String> values) {
            addCriterion("ftid in", values, "ftid");
            return (Criteria) this;
        }

        public Criteria andFtidNotIn(List<String> values) {
            addCriterion("ftid not in", values, "ftid");
            return (Criteria) this;
        }

        public Criteria andFtidBetween(String value1, String value2) {
            addCriterion("ftid between", value1, value2, "ftid");
            return (Criteria) this;
        }

        public Criteria andFtidNotBetween(String value1, String value2) {
            addCriterion("ftid not between", value1, value2, "ftid");
            return (Criteria) this;
        }

        public Criteria andFtmcIsNull() {
            addCriterion("ftmc is null");
            return (Criteria) this;
        }

        public Criteria andFtmcIsNotNull() {
            addCriterion("ftmc is not null");
            return (Criteria) this;
        }

        public Criteria andFtmcEqualTo(String value) {
            addCriterion("ftmc =", value, "ftmc");
            return (Criteria) this;
        }

        public Criteria andFtmcNotEqualTo(String value) {
            addCriterion("ftmc <>", value, "ftmc");
            return (Criteria) this;
        }

        public Criteria andFtmcGreaterThan(String value) {
            addCriterion("ftmc >", value, "ftmc");
            return (Criteria) this;
        }

        public Criteria andFtmcGreaterThanOrEqualTo(String value) {
            addCriterion("ftmc >=", value, "ftmc");
            return (Criteria) this;
        }

        public Criteria andFtmcLessThan(String value) {
            addCriterion("ftmc <", value, "ftmc");
            return (Criteria) this;
        }

        public Criteria andFtmcLessThanOrEqualTo(String value) {
            addCriterion("ftmc <=", value, "ftmc");
            return (Criteria) this;
        }

        public Criteria andFtmcLike(String value) {
            addCriterion("ftmc like", value, "ftmc");
            return (Criteria) this;
        }

        public Criteria andFtmcNotLike(String value) {
            addCriterion("ftmc not like", value, "ftmc");
            return (Criteria) this;
        }

        public Criteria andFtmcIn(List<String> values) {
            addCriterion("ftmc in", values, "ftmc");
            return (Criteria) this;
        }

        public Criteria andFtmcNotIn(List<String> values) {
            addCriterion("ftmc not in", values, "ftmc");
            return (Criteria) this;
        }

        public Criteria andFtmcBetween(String value1, String value2) {
            addCriterion("ftmc between", value1, value2, "ftmc");
            return (Criteria) this;
        }

        public Criteria andFtmcNotBetween(String value1, String value2) {
            addCriterion("ftmc not between", value1, value2, "ftmc");
            return (Criteria) this;
        }

        public Criteria andGkktIsNull() {
            addCriterion("gkkt is null");
            return (Criteria) this;
        }

        public Criteria andGkktIsNotNull() {
            addCriterion("gkkt is not null");
            return (Criteria) this;
        }

        public Criteria andGkktEqualTo(Integer value) {
            addCriterion("gkkt =", value, "gkkt");
            return (Criteria) this;
        }

        public Criteria andGkktNotEqualTo(Integer value) {
            addCriterion("gkkt <>", value, "gkkt");
            return (Criteria) this;
        }

        public Criteria andGkktGreaterThan(Integer value) {
            addCriterion("gkkt >", value, "gkkt");
            return (Criteria) this;
        }

        public Criteria andGkktGreaterThanOrEqualTo(Integer value) {
            addCriterion("gkkt >=", value, "gkkt");
            return (Criteria) this;
        }

        public Criteria andGkktLessThan(Integer value) {
            addCriterion("gkkt <", value, "gkkt");
            return (Criteria) this;
        }

        public Criteria andGkktLessThanOrEqualTo(Integer value) {
            addCriterion("gkkt <=", value, "gkkt");
            return (Criteria) this;
        }

        public Criteria andGkktIn(List<Integer> values) {
            addCriterion("gkkt in", values, "gkkt");
            return (Criteria) this;
        }

        public Criteria andGkktNotIn(List<Integer> values) {
            addCriterion("gkkt not in", values, "gkkt");
            return (Criteria) this;
        }

        public Criteria andGkktBetween(Integer value1, Integer value2) {
            addCriterion("gkkt between", value1, value2, "gkkt");
            return (Criteria) this;
        }

        public Criteria andGkktNotBetween(Integer value1, Integer value2) {
            addCriterion("gkkt not between", value1, value2, "gkkt");
            return (Criteria) this;
        }

        public Criteria andZtIsNull() {
            addCriterion("zt is null");
            return (Criteria) this;
        }

        public Criteria andZtIsNotNull() {
            addCriterion("zt is not null");
            return (Criteria) this;
        }

        public Criteria andZtEqualTo(Integer value) {
            addCriterion("zt =", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtNotEqualTo(Integer value) {
            addCriterion("zt <>", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtGreaterThan(Integer value) {
            addCriterion("zt >", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtGreaterThanOrEqualTo(Integer value) {
            addCriterion("zt >=", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtLessThan(Integer value) {
            addCriterion("zt <", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtLessThanOrEqualTo(Integer value) {
            addCriterion("zt <=", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtIn(List<Integer> values) {
            addCriterion("zt in", values, "zt");
            return (Criteria) this;
        }

        public Criteria andZtNotIn(List<Integer> values) {
            addCriterion("zt not in", values, "zt");
            return (Criteria) this;
        }

        public Criteria andZtBetween(Integer value1, Integer value2) {
            addCriterion("zt between", value1, value2, "zt");
            return (Criteria) this;
        }

        public Criteria andZtNotBetween(Integer value1, Integer value2) {
            addCriterion("zt not between", value1, value2, "zt");
            return (Criteria) this;
        }

        public Criteria andKtlxIsNull() {
            addCriterion("ktlx is null");
            return (Criteria) this;
        }

        public Criteria andKtlxIsNotNull() {
            addCriterion("ktlx is not null");
            return (Criteria) this;
        }

        public Criteria andKtlxEqualTo(Integer value) {
            addCriterion("ktlx =", value, "ktlx");
            return (Criteria) this;
        }

        public Criteria andKtlxNotEqualTo(Integer value) {
            addCriterion("ktlx <>", value, "ktlx");
            return (Criteria) this;
        }

        public Criteria andKtlxGreaterThan(Integer value) {
            addCriterion("ktlx >", value, "ktlx");
            return (Criteria) this;
        }

        public Criteria andKtlxGreaterThanOrEqualTo(Integer value) {
            addCriterion("ktlx >=", value, "ktlx");
            return (Criteria) this;
        }

        public Criteria andKtlxLessThan(Integer value) {
            addCriterion("ktlx <", value, "ktlx");
            return (Criteria) this;
        }

        public Criteria andKtlxLessThanOrEqualTo(Integer value) {
            addCriterion("ktlx <=", value, "ktlx");
            return (Criteria) this;
        }

        public Criteria andKtlxIn(List<Integer> values) {
            addCriterion("ktlx in", values, "ktlx");
            return (Criteria) this;
        }

        public Criteria andKtlxNotIn(List<Integer> values) {
            addCriterion("ktlx not in", values, "ktlx");
            return (Criteria) this;
        }

        public Criteria andKtlxBetween(Integer value1, Integer value2) {
            addCriterion("ktlx between", value1, value2, "ktlx");
            return (Criteria) this;
        }

        public Criteria andKtlxNotBetween(Integer value1, Integer value2) {
            addCriterion("ktlx not between", value1, value2, "ktlx");
            return (Criteria) this;
        }

        public Criteria andSzftcsIsNull() {
            addCriterion("szftcs is null");
            return (Criteria) this;
        }

        public Criteria andSzftcsIsNotNull() {
            addCriterion("szftcs is not null");
            return (Criteria) this;
        }

        public Criteria andSzftcsEqualTo(Integer value) {
            addCriterion("szftcs =", value, "szftcs");
            return (Criteria) this;
        }

        public Criteria andSzftcsNotEqualTo(Integer value) {
            addCriterion("szftcs <>", value, "szftcs");
            return (Criteria) this;
        }

        public Criteria andSzftcsGreaterThan(Integer value) {
            addCriterion("szftcs >", value, "szftcs");
            return (Criteria) this;
        }

        public Criteria andSzftcsGreaterThanOrEqualTo(Integer value) {
            addCriterion("szftcs >=", value, "szftcs");
            return (Criteria) this;
        }

        public Criteria andSzftcsLessThan(Integer value) {
            addCriterion("szftcs <", value, "szftcs");
            return (Criteria) this;
        }

        public Criteria andSzftcsLessThanOrEqualTo(Integer value) {
            addCriterion("szftcs <=", value, "szftcs");
            return (Criteria) this;
        }

        public Criteria andSzftcsIn(List<Integer> values) {
            addCriterion("szftcs in", values, "szftcs");
            return (Criteria) this;
        }

        public Criteria andSzftcsNotIn(List<Integer> values) {
            addCriterion("szftcs not in", values, "szftcs");
            return (Criteria) this;
        }

        public Criteria andSzftcsBetween(Integer value1, Integer value2) {
            addCriterion("szftcs between", value1, value2, "szftcs");
            return (Criteria) this;
        }

        public Criteria andSzftcsNotBetween(Integer value1, Integer value2) {
            addCriterion("szftcs not between", value1, value2, "szftcs");
            return (Criteria) this;
        }

        public Criteria andSfcszIsNull() {
            addCriterion("sfcsz is null");
            return (Criteria) this;
        }

        public Criteria andSfcszIsNotNull() {
            addCriterion("sfcsz is not null");
            return (Criteria) this;
        }

        public Criteria andSfcszEqualTo(Integer value) {
            addCriterion("sfcsz =", value, "sfcsz");
            return (Criteria) this;
        }

        public Criteria andSfcszNotEqualTo(Integer value) {
            addCriterion("sfcsz <>", value, "sfcsz");
            return (Criteria) this;
        }

        public Criteria andSfcszGreaterThan(Integer value) {
            addCriterion("sfcsz >", value, "sfcsz");
            return (Criteria) this;
        }

        public Criteria andSfcszGreaterThanOrEqualTo(Integer value) {
            addCriterion("sfcsz >=", value, "sfcsz");
            return (Criteria) this;
        }

        public Criteria andSfcszLessThan(Integer value) {
            addCriterion("sfcsz <", value, "sfcsz");
            return (Criteria) this;
        }

        public Criteria andSfcszLessThanOrEqualTo(Integer value) {
            addCriterion("sfcsz <=", value, "sfcsz");
            return (Criteria) this;
        }

        public Criteria andSfcszIn(List<Integer> values) {
            addCriterion("sfcsz in", values, "sfcsz");
            return (Criteria) this;
        }

        public Criteria andSfcszNotIn(List<Integer> values) {
            addCriterion("sfcsz not in", values, "sfcsz");
            return (Criteria) this;
        }

        public Criteria andSfcszBetween(Integer value1, Integer value2) {
            addCriterion("sfcsz between", value1, value2, "sfcsz");
            return (Criteria) this;
        }

        public Criteria andSfcszNotBetween(Integer value1, Integer value2) {
            addCriterion("sfcsz not between", value1, value2, "sfcsz");
            return (Criteria) this;
        }

        public Criteria andSfklIsNull() {
            addCriterion("sfkl is null");
            return (Criteria) this;
        }

        public Criteria andSfklIsNotNull() {
            addCriterion("sfkl is not null");
            return (Criteria) this;
        }

        public Criteria andSfklEqualTo(Integer value) {
            addCriterion("sfkl =", value, "sfkl");
            return (Criteria) this;
        }

        public Criteria andSfklNotEqualTo(Integer value) {
            addCriterion("sfkl <>", value, "sfkl");
            return (Criteria) this;
        }

        public Criteria andSfklGreaterThan(Integer value) {
            addCriterion("sfkl >", value, "sfkl");
            return (Criteria) this;
        }

        public Criteria andSfklGreaterThanOrEqualTo(Integer value) {
            addCriterion("sfkl >=", value, "sfkl");
            return (Criteria) this;
        }

        public Criteria andSfklLessThan(Integer value) {
            addCriterion("sfkl <", value, "sfkl");
            return (Criteria) this;
        }

        public Criteria andSfklLessThanOrEqualTo(Integer value) {
            addCriterion("sfkl <=", value, "sfkl");
            return (Criteria) this;
        }

        public Criteria andSfklIn(List<Integer> values) {
            addCriterion("sfkl in", values, "sfkl");
            return (Criteria) this;
        }

        public Criteria andSfklNotIn(List<Integer> values) {
            addCriterion("sfkl not in", values, "sfkl");
            return (Criteria) this;
        }

        public Criteria andSfklBetween(Integer value1, Integer value2) {
            addCriterion("sfkl between", value1, value2, "sfkl");
            return (Criteria) this;
        }

        public Criteria andSfklNotBetween(Integer value1, Integer value2) {
            addCriterion("sfkl not between", value1, value2, "sfkl");
            return (Criteria) this;
        }

        public Criteria andSfzbIsNull() {
            addCriterion("sfzb is null");
            return (Criteria) this;
        }

        public Criteria andSfzbIsNotNull() {
            addCriterion("sfzb is not null");
            return (Criteria) this;
        }

        public Criteria andSfzbEqualTo(Integer value) {
            addCriterion("sfzb =", value, "sfzb");
            return (Criteria) this;
        }

        public Criteria andSfzbNotEqualTo(Integer value) {
            addCriterion("sfzb <>", value, "sfzb");
            return (Criteria) this;
        }

        public Criteria andSfzbGreaterThan(Integer value) {
            addCriterion("sfzb >", value, "sfzb");
            return (Criteria) this;
        }

        public Criteria andSfzbGreaterThanOrEqualTo(Integer value) {
            addCriterion("sfzb >=", value, "sfzb");
            return (Criteria) this;
        }

        public Criteria andSfzbLessThan(Integer value) {
            addCriterion("sfzb <", value, "sfzb");
            return (Criteria) this;
        }

        public Criteria andSfzbLessThanOrEqualTo(Integer value) {
            addCriterion("sfzb <=", value, "sfzb");
            return (Criteria) this;
        }

        public Criteria andSfzbIn(List<Integer> values) {
            addCriterion("sfzb in", values, "sfzb");
            return (Criteria) this;
        }

        public Criteria andSfzbNotIn(List<Integer> values) {
            addCriterion("sfzb not in", values, "sfzb");
            return (Criteria) this;
        }

        public Criteria andSfzbBetween(Integer value1, Integer value2) {
            addCriterion("sfzb between", value1, value2, "sfzb");
            return (Criteria) this;
        }

        public Criteria andSfzbNotBetween(Integer value1, Integer value2) {
            addCriterion("sfzb not between", value1, value2, "sfzb");
            return (Criteria) this;
        }

        public Criteria andTsmsIsNull() {
            addCriterion("tsms is null");
            return (Criteria) this;
        }

        public Criteria andTsmsIsNotNull() {
            addCriterion("tsms is not null");
            return (Criteria) this;
        }

        public Criteria andTsmsEqualTo(Integer value) {
            addCriterion("tsms =", value, "tsms");
            return (Criteria) this;
        }

        public Criteria andTsmsNotEqualTo(Integer value) {
            addCriterion("tsms <>", value, "tsms");
            return (Criteria) this;
        }

        public Criteria andTsmsGreaterThan(Integer value) {
            addCriterion("tsms >", value, "tsms");
            return (Criteria) this;
        }

        public Criteria andTsmsGreaterThanOrEqualTo(Integer value) {
            addCriterion("tsms >=", value, "tsms");
            return (Criteria) this;
        }

        public Criteria andTsmsLessThan(Integer value) {
            addCriterion("tsms <", value, "tsms");
            return (Criteria) this;
        }

        public Criteria andTsmsLessThanOrEqualTo(Integer value) {
            addCriterion("tsms <=", value, "tsms");
            return (Criteria) this;
        }

        public Criteria andTsmsIn(List<Integer> values) {
            addCriterion("tsms in", values, "tsms");
            return (Criteria) this;
        }

        public Criteria andTsmsNotIn(List<Integer> values) {
            addCriterion("tsms not in", values, "tsms");
            return (Criteria) this;
        }

        public Criteria andTsmsBetween(Integer value1, Integer value2) {
            addCriterion("tsms between", value1, value2, "tsms");
            return (Criteria) this;
        }

        public Criteria andTsmsNotBetween(Integer value1, Integer value2) {
            addCriterion("tsms not between", value1, value2, "tsms");
            return (Criteria) this;
        }

        public Criteria andSpzbsIsNull() {
            addCriterion("spzbs is null");
            return (Criteria) this;
        }

        public Criteria andSpzbsIsNotNull() {
            addCriterion("spzbs is not null");
            return (Criteria) this;
        }

        public Criteria andSpzbsEqualTo(String value) {
            addCriterion("spzbs =", value, "spzbs");
            return (Criteria) this;
        }

        public Criteria andSpzbsNotEqualTo(String value) {
            addCriterion("spzbs <>", value, "spzbs");
            return (Criteria) this;
        }

        public Criteria andSpzbsGreaterThan(String value) {
            addCriterion("spzbs >", value, "spzbs");
            return (Criteria) this;
        }

        public Criteria andSpzbsGreaterThanOrEqualTo(String value) {
            addCriterion("spzbs >=", value, "spzbs");
            return (Criteria) this;
        }

        public Criteria andSpzbsLessThan(String value) {
            addCriterion("spzbs <", value, "spzbs");
            return (Criteria) this;
        }

        public Criteria andSpzbsLessThanOrEqualTo(String value) {
            addCriterion("spzbs <=", value, "spzbs");
            return (Criteria) this;
        }

        public Criteria andSpzbsLike(String value) {
            addCriterion("spzbs like", value, "spzbs");
            return (Criteria) this;
        }

        public Criteria andSpzbsNotLike(String value) {
            addCriterion("spzbs not like", value, "spzbs");
            return (Criteria) this;
        }

        public Criteria andSpzbsIn(List<String> values) {
            addCriterion("spzbs in", values, "spzbs");
            return (Criteria) this;
        }

        public Criteria andSpzbsNotIn(List<String> values) {
            addCriterion("spzbs not in", values, "spzbs");
            return (Criteria) this;
        }

        public Criteria andSpzbsBetween(String value1, String value2) {
            addCriterion("spzbs between", value1, value2, "spzbs");
            return (Criteria) this;
        }

        public Criteria andSpzbsNotBetween(String value1, String value2) {
            addCriterion("spzbs not between", value1, value2, "spzbs");
            return (Criteria) this;
        }

        public Criteria andSpzmcIsNull() {
            addCriterion("spzmc is null");
            return (Criteria) this;
        }

        public Criteria andSpzmcIsNotNull() {
            addCriterion("spzmc is not null");
            return (Criteria) this;
        }

        public Criteria andSpzmcEqualTo(String value) {
            addCriterion("spzmc =", value, "spzmc");
            return (Criteria) this;
        }

        public Criteria andSpzmcNotEqualTo(String value) {
            addCriterion("spzmc <>", value, "spzmc");
            return (Criteria) this;
        }

        public Criteria andSpzmcGreaterThan(String value) {
            addCriterion("spzmc >", value, "spzmc");
            return (Criteria) this;
        }

        public Criteria andSpzmcGreaterThanOrEqualTo(String value) {
            addCriterion("spzmc >=", value, "spzmc");
            return (Criteria) this;
        }

        public Criteria andSpzmcLessThan(String value) {
            addCriterion("spzmc <", value, "spzmc");
            return (Criteria) this;
        }

        public Criteria andSpzmcLessThanOrEqualTo(String value) {
            addCriterion("spzmc <=", value, "spzmc");
            return (Criteria) this;
        }

        public Criteria andSpzmcLike(String value) {
            addCriterion("spzmc like", value, "spzmc");
            return (Criteria) this;
        }

        public Criteria andSpzmcNotLike(String value) {
            addCriterion("spzmc not like", value, "spzmc");
            return (Criteria) this;
        }

        public Criteria andSpzmcIn(List<String> values) {
            addCriterion("spzmc in", values, "spzmc");
            return (Criteria) this;
        }

        public Criteria andSpzmcNotIn(List<String> values) {
            addCriterion("spzmc not in", values, "spzmc");
            return (Criteria) this;
        }

        public Criteria andSpzmcBetween(String value1, String value2) {
            addCriterion("spzmc between", value1, value2, "spzmc");
            return (Criteria) this;
        }

        public Criteria andSpzmcNotBetween(String value1, String value2) {
            addCriterion("spzmc not between", value1, value2, "spzmc");
            return (Criteria) this;
        }

        public Criteria andSjybsIsNull() {
            addCriterion("sjybs is null");
            return (Criteria) this;
        }

        public Criteria andSjybsIsNotNull() {
            addCriterion("sjybs is not null");
            return (Criteria) this;
        }

        public Criteria andSjybsEqualTo(String value) {
            addCriterion("sjybs =", value, "sjybs");
            return (Criteria) this;
        }

        public Criteria andSjybsNotEqualTo(String value) {
            addCriterion("sjybs <>", value, "sjybs");
            return (Criteria) this;
        }

        public Criteria andSjybsGreaterThan(String value) {
            addCriterion("sjybs >", value, "sjybs");
            return (Criteria) this;
        }

        public Criteria andSjybsGreaterThanOrEqualTo(String value) {
            addCriterion("sjybs >=", value, "sjybs");
            return (Criteria) this;
        }

        public Criteria andSjybsLessThan(String value) {
            addCriterion("sjybs <", value, "sjybs");
            return (Criteria) this;
        }

        public Criteria andSjybsLessThanOrEqualTo(String value) {
            addCriterion("sjybs <=", value, "sjybs");
            return (Criteria) this;
        }

        public Criteria andSjybsLike(String value) {
            addCriterion("sjybs like", value, "sjybs");
            return (Criteria) this;
        }

        public Criteria andSjybsNotLike(String value) {
            addCriterion("sjybs not like", value, "sjybs");
            return (Criteria) this;
        }

        public Criteria andSjybsIn(List<String> values) {
            addCriterion("sjybs in", values, "sjybs");
            return (Criteria) this;
        }

        public Criteria andSjybsNotIn(List<String> values) {
            addCriterion("sjybs not in", values, "sjybs");
            return (Criteria) this;
        }

        public Criteria andSjybsBetween(String value1, String value2) {
            addCriterion("sjybs between", value1, value2, "sjybs");
            return (Criteria) this;
        }

        public Criteria andSjybsNotBetween(String value1, String value2) {
            addCriterion("sjybs not between", value1, value2, "sjybs");
            return (Criteria) this;
        }

        public Criteria andSjymcIsNull() {
            addCriterion("sjymc is null");
            return (Criteria) this;
        }

        public Criteria andSjymcIsNotNull() {
            addCriterion("sjymc is not null");
            return (Criteria) this;
        }

        public Criteria andSjymcEqualTo(String value) {
            addCriterion("sjymc =", value, "sjymc");
            return (Criteria) this;
        }

        public Criteria andSjymcNotEqualTo(String value) {
            addCriterion("sjymc <>", value, "sjymc");
            return (Criteria) this;
        }

        public Criteria andSjymcGreaterThan(String value) {
            addCriterion("sjymc >", value, "sjymc");
            return (Criteria) this;
        }

        public Criteria andSjymcGreaterThanOrEqualTo(String value) {
            addCriterion("sjymc >=", value, "sjymc");
            return (Criteria) this;
        }

        public Criteria andSjymcLessThan(String value) {
            addCriterion("sjymc <", value, "sjymc");
            return (Criteria) this;
        }

        public Criteria andSjymcLessThanOrEqualTo(String value) {
            addCriterion("sjymc <=", value, "sjymc");
            return (Criteria) this;
        }

        public Criteria andSjymcLike(String value) {
            addCriterion("sjymc like", value, "sjymc");
            return (Criteria) this;
        }

        public Criteria andSjymcNotLike(String value) {
            addCriterion("sjymc not like", value, "sjymc");
            return (Criteria) this;
        }

        public Criteria andSjymcIn(List<String> values) {
            addCriterion("sjymc in", values, "sjymc");
            return (Criteria) this;
        }

        public Criteria andSjymcNotIn(List<String> values) {
            addCriterion("sjymc not in", values, "sjymc");
            return (Criteria) this;
        }

        public Criteria andSjymcBetween(String value1, String value2) {
            addCriterion("sjymc between", value1, value2, "sjymc");
            return (Criteria) this;
        }

        public Criteria andSjymcNotBetween(String value1, String value2) {
            addCriterion("sjymc not between", value1, value2, "sjymc");
            return (Criteria) this;
        }

        public Criteria andSpybsIsNull() {
            addCriterion("spybs is null");
            return (Criteria) this;
        }

        public Criteria andSpybsIsNotNull() {
            addCriterion("spybs is not null");
            return (Criteria) this;
        }

        public Criteria andSpybsEqualTo(String value) {
            addCriterion("spybs =", value, "spybs");
            return (Criteria) this;
        }

        public Criteria andSpybsNotEqualTo(String value) {
            addCriterion("spybs <>", value, "spybs");
            return (Criteria) this;
        }

        public Criteria andSpybsGreaterThan(String value) {
            addCriterion("spybs >", value, "spybs");
            return (Criteria) this;
        }

        public Criteria andSpybsGreaterThanOrEqualTo(String value) {
            addCriterion("spybs >=", value, "spybs");
            return (Criteria) this;
        }

        public Criteria andSpybsLessThan(String value) {
            addCriterion("spybs <", value, "spybs");
            return (Criteria) this;
        }

        public Criteria andSpybsLessThanOrEqualTo(String value) {
            addCriterion("spybs <=", value, "spybs");
            return (Criteria) this;
        }

        public Criteria andSpybsLike(String value) {
            addCriterion("spybs like", value, "spybs");
            return (Criteria) this;
        }

        public Criteria andSpybsNotLike(String value) {
            addCriterion("spybs not like", value, "spybs");
            return (Criteria) this;
        }

        public Criteria andSpybsIn(List<String> values) {
            addCriterion("spybs in", values, "spybs");
            return (Criteria) this;
        }

        public Criteria andSpybsNotIn(List<String> values) {
            addCriterion("spybs not in", values, "spybs");
            return (Criteria) this;
        }

        public Criteria andSpybsBetween(String value1, String value2) {
            addCriterion("spybs between", value1, value2, "spybs");
            return (Criteria) this;
        }

        public Criteria andSpybsNotBetween(String value1, String value2) {
            addCriterion("spybs not between", value1, value2, "spybs");
            return (Criteria) this;
        }

        public Criteria andSpymcIsNull() {
            addCriterion("spymc is null");
            return (Criteria) this;
        }

        public Criteria andSpymcIsNotNull() {
            addCriterion("spymc is not null");
            return (Criteria) this;
        }

        public Criteria andSpymcEqualTo(String value) {
            addCriterion("spymc =", value, "spymc");
            return (Criteria) this;
        }

        public Criteria andSpymcNotEqualTo(String value) {
            addCriterion("spymc <>", value, "spymc");
            return (Criteria) this;
        }

        public Criteria andSpymcGreaterThan(String value) {
            addCriterion("spymc >", value, "spymc");
            return (Criteria) this;
        }

        public Criteria andSpymcGreaterThanOrEqualTo(String value) {
            addCriterion("spymc >=", value, "spymc");
            return (Criteria) this;
        }

        public Criteria andSpymcLessThan(String value) {
            addCriterion("spymc <", value, "spymc");
            return (Criteria) this;
        }

        public Criteria andSpymcLessThanOrEqualTo(String value) {
            addCriterion("spymc <=", value, "spymc");
            return (Criteria) this;
        }

        public Criteria andSpymcLike(String value) {
            addCriterion("spymc like", value, "spymc");
            return (Criteria) this;
        }

        public Criteria andSpymcNotLike(String value) {
            addCriterion("spymc not like", value, "spymc");
            return (Criteria) this;
        }

        public Criteria andSpymcIn(List<String> values) {
            addCriterion("spymc in", values, "spymc");
            return (Criteria) this;
        }

        public Criteria andSpymcNotIn(List<String> values) {
            addCriterion("spymc not in", values, "spymc");
            return (Criteria) this;
        }

        public Criteria andSpymcBetween(String value1, String value2) {
            addCriterion("spymc between", value1, value2, "spymc");
            return (Criteria) this;
        }

        public Criteria andSpymcNotBetween(String value1, String value2) {
            addCriterion("spymc not between", value1, value2, "spymc");
            return (Criteria) this;
        }

        public Criteria andRmpsyIsNull() {
            addCriterion("rmpsy is null");
            return (Criteria) this;
        }

        public Criteria andRmpsyIsNotNull() {
            addCriterion("rmpsy is not null");
            return (Criteria) this;
        }

        public Criteria andRmpsyEqualTo(String value) {
            addCriterion("rmpsy =", value, "rmpsy");
            return (Criteria) this;
        }

        public Criteria andRmpsyNotEqualTo(String value) {
            addCriterion("rmpsy <>", value, "rmpsy");
            return (Criteria) this;
        }

        public Criteria andRmpsyGreaterThan(String value) {
            addCriterion("rmpsy >", value, "rmpsy");
            return (Criteria) this;
        }

        public Criteria andRmpsyGreaterThanOrEqualTo(String value) {
            addCriterion("rmpsy >=", value, "rmpsy");
            return (Criteria) this;
        }

        public Criteria andRmpsyLessThan(String value) {
            addCriterion("rmpsy <", value, "rmpsy");
            return (Criteria) this;
        }

        public Criteria andRmpsyLessThanOrEqualTo(String value) {
            addCriterion("rmpsy <=", value, "rmpsy");
            return (Criteria) this;
        }

        public Criteria andRmpsyLike(String value) {
            addCriterion("rmpsy like", value, "rmpsy");
            return (Criteria) this;
        }

        public Criteria andRmpsyNotLike(String value) {
            addCriterion("rmpsy not like", value, "rmpsy");
            return (Criteria) this;
        }

        public Criteria andRmpsyIn(List<String> values) {
            addCriterion("rmpsy in", values, "rmpsy");
            return (Criteria) this;
        }

        public Criteria andRmpsyNotIn(List<String> values) {
            addCriterion("rmpsy not in", values, "rmpsy");
            return (Criteria) this;
        }

        public Criteria andRmpsyBetween(String value1, String value2) {
            addCriterion("rmpsy between", value1, value2, "rmpsy");
            return (Criteria) this;
        }

        public Criteria andRmpsyNotBetween(String value1, String value2) {
            addCriterion("rmpsy not between", value1, value2, "rmpsy");
            return (Criteria) this;
        }

        public Criteria andPqlxIsNull() {
            addCriterion("pqlx is null");
            return (Criteria) this;
        }

        public Criteria andPqlxIsNotNull() {
            addCriterion("pqlx is not null");
            return (Criteria) this;
        }

        public Criteria andPqlxEqualTo(Integer value) {
            addCriterion("pqlx =", value, "pqlx");
            return (Criteria) this;
        }

        public Criteria andPqlxNotEqualTo(Integer value) {
            addCriterion("pqlx <>", value, "pqlx");
            return (Criteria) this;
        }

        public Criteria andPqlxGreaterThan(Integer value) {
            addCriterion("pqlx >", value, "pqlx");
            return (Criteria) this;
        }

        public Criteria andPqlxGreaterThanOrEqualTo(Integer value) {
            addCriterion("pqlx >=", value, "pqlx");
            return (Criteria) this;
        }

        public Criteria andPqlxLessThan(Integer value) {
            addCriterion("pqlx <", value, "pqlx");
            return (Criteria) this;
        }

        public Criteria andPqlxLessThanOrEqualTo(Integer value) {
            addCriterion("pqlx <=", value, "pqlx");
            return (Criteria) this;
        }

        public Criteria andPqlxIn(List<Integer> values) {
            addCriterion("pqlx in", values, "pqlx");
            return (Criteria) this;
        }

        public Criteria andPqlxNotIn(List<Integer> values) {
            addCriterion("pqlx not in", values, "pqlx");
            return (Criteria) this;
        }

        public Criteria andPqlxBetween(Integer value1, Integer value2) {
            addCriterion("pqlx between", value1, value2, "pqlx");
            return (Criteria) this;
        }

        public Criteria andPqlxNotBetween(Integer value1, Integer value2) {
            addCriterion("pqlx not between", value1, value2, "pqlx");
            return (Criteria) this;
        }

        public Criteria andSfzhdbIsNull() {
            addCriterion("sfzhdb is null");
            return (Criteria) this;
        }

        public Criteria andSfzhdbIsNotNull() {
            addCriterion("sfzhdb is not null");
            return (Criteria) this;
        }

        public Criteria andSfzhdbEqualTo(Integer value) {
            addCriterion("sfzhdb =", value, "sfzhdb");
            return (Criteria) this;
        }

        public Criteria andSfzhdbNotEqualTo(Integer value) {
            addCriterion("sfzhdb <>", value, "sfzhdb");
            return (Criteria) this;
        }

        public Criteria andSfzhdbGreaterThan(Integer value) {
            addCriterion("sfzhdb >", value, "sfzhdb");
            return (Criteria) this;
        }

        public Criteria andSfzhdbGreaterThanOrEqualTo(Integer value) {
            addCriterion("sfzhdb >=", value, "sfzhdb");
            return (Criteria) this;
        }

        public Criteria andSfzhdbLessThan(Integer value) {
            addCriterion("sfzhdb <", value, "sfzhdb");
            return (Criteria) this;
        }

        public Criteria andSfzhdbLessThanOrEqualTo(Integer value) {
            addCriterion("sfzhdb <=", value, "sfzhdb");
            return (Criteria) this;
        }

        public Criteria andSfzhdbIn(List<Integer> values) {
            addCriterion("sfzhdb in", values, "sfzhdb");
            return (Criteria) this;
        }

        public Criteria andSfzhdbNotIn(List<Integer> values) {
            addCriterion("sfzhdb not in", values, "sfzhdb");
            return (Criteria) this;
        }

        public Criteria andSfzhdbBetween(Integer value1, Integer value2) {
            addCriterion("sfzhdb between", value1, value2, "sfzhdb");
            return (Criteria) this;
        }

        public Criteria andSfzhdbNotBetween(Integer value1, Integer value2) {
            addCriterion("sfzhdb not between", value1, value2, "sfzhdb");
            return (Criteria) this;
        }

        public Criteria andZdypxIsNull() {
            addCriterion("zdypx is null");
            return (Criteria) this;
        }

        public Criteria andZdypxIsNotNull() {
            addCriterion("zdypx is not null");
            return (Criteria) this;
        }

        public Criteria andZdypxEqualTo(Integer value) {
            addCriterion("zdypx =", value, "zdypx");
            return (Criteria) this;
        }

        public Criteria andZdypxNotEqualTo(Integer value) {
            addCriterion("zdypx <>", value, "zdypx");
            return (Criteria) this;
        }

        public Criteria andZdypxGreaterThan(Integer value) {
            addCriterion("zdypx >", value, "zdypx");
            return (Criteria) this;
        }

        public Criteria andZdypxGreaterThanOrEqualTo(Integer value) {
            addCriterion("zdypx >=", value, "zdypx");
            return (Criteria) this;
        }

        public Criteria andZdypxLessThan(Integer value) {
            addCriterion("zdypx <", value, "zdypx");
            return (Criteria) this;
        }

        public Criteria andZdypxLessThanOrEqualTo(Integer value) {
            addCriterion("zdypx <=", value, "zdypx");
            return (Criteria) this;
        }

        public Criteria andZdypxIn(List<Integer> values) {
            addCriterion("zdypx in", values, "zdypx");
            return (Criteria) this;
        }

        public Criteria andZdypxNotIn(List<Integer> values) {
            addCriterion("zdypx not in", values, "zdypx");
            return (Criteria) this;
        }

        public Criteria andZdypxBetween(Integer value1, Integer value2) {
            addCriterion("zdypx between", value1, value2, "zdypx");
            return (Criteria) this;
        }

        public Criteria andZdypxNotBetween(Integer value1, Integer value2) {
            addCriterion("zdypx not between", value1, value2, "zdypx");
            return (Criteria) this;
        }

        public Criteria andBrcystbsIsNull() {
            addCriterion("brcystbs is null");
            return (Criteria) this;
        }

        public Criteria andBrcystbsIsNotNull() {
            addCriterion("brcystbs is not null");
            return (Criteria) this;
        }

        public Criteria andBrcystbsEqualTo(String value) {
            addCriterion("brcystbs =", value, "brcystbs");
            return (Criteria) this;
        }

        public Criteria andBrcystbsNotEqualTo(String value) {
            addCriterion("brcystbs <>", value, "brcystbs");
            return (Criteria) this;
        }

        public Criteria andBrcystbsGreaterThan(String value) {
            addCriterion("brcystbs >", value, "brcystbs");
            return (Criteria) this;
        }

        public Criteria andBrcystbsGreaterThanOrEqualTo(String value) {
            addCriterion("brcystbs >=", value, "brcystbs");
            return (Criteria) this;
        }

        public Criteria andBrcystbsLessThan(String value) {
            addCriterion("brcystbs <", value, "brcystbs");
            return (Criteria) this;
        }

        public Criteria andBrcystbsLessThanOrEqualTo(String value) {
            addCriterion("brcystbs <=", value, "brcystbs");
            return (Criteria) this;
        }

        public Criteria andBrcystbsLike(String value) {
            addCriterion("brcystbs like", value, "brcystbs");
            return (Criteria) this;
        }

        public Criteria andBrcystbsNotLike(String value) {
            addCriterion("brcystbs not like", value, "brcystbs");
            return (Criteria) this;
        }

        public Criteria andBrcystbsIn(List<String> values) {
            addCriterion("brcystbs in", values, "brcystbs");
            return (Criteria) this;
        }

        public Criteria andBrcystbsNotIn(List<String> values) {
            addCriterion("brcystbs not in", values, "brcystbs");
            return (Criteria) this;
        }

        public Criteria andBrcystbsBetween(String value1, String value2) {
            addCriterion("brcystbs between", value1, value2, "brcystbs");
            return (Criteria) this;
        }

        public Criteria andBrcystbsNotBetween(String value1, String value2) {
            addCriterion("brcystbs not between", value1, value2, "brcystbs");
            return (Criteria) this;
        }

        public Criteria andBtdbIsNull() {
            addCriterion("btdb is null");
            return (Criteria) this;
        }

        public Criteria andBtdbIsNotNull() {
            addCriterion("btdb is not null");
            return (Criteria) this;
        }

        public Criteria andBtdbEqualTo(Integer value) {
            addCriterion("btdb =", value, "btdb");
            return (Criteria) this;
        }

        public Criteria andBtdbNotEqualTo(Integer value) {
            addCriterion("btdb <>", value, "btdb");
            return (Criteria) this;
        }

        public Criteria andBtdbGreaterThan(Integer value) {
            addCriterion("btdb >", value, "btdb");
            return (Criteria) this;
        }

        public Criteria andBtdbGreaterThanOrEqualTo(Integer value) {
            addCriterion("btdb >=", value, "btdb");
            return (Criteria) this;
        }

        public Criteria andBtdbLessThan(Integer value) {
            addCriterion("btdb <", value, "btdb");
            return (Criteria) this;
        }

        public Criteria andBtdbLessThanOrEqualTo(Integer value) {
            addCriterion("btdb <=", value, "btdb");
            return (Criteria) this;
        }

        public Criteria andBtdbIn(List<Integer> values) {
            addCriterion("btdb in", values, "btdb");
            return (Criteria) this;
        }

        public Criteria andBtdbNotIn(List<Integer> values) {
            addCriterion("btdb not in", values, "btdb");
            return (Criteria) this;
        }

        public Criteria andBtdbBetween(Integer value1, Integer value2) {
            addCriterion("btdb between", value1, value2, "btdb");
            return (Criteria) this;
        }

        public Criteria andBtdbNotBetween(Integer value1, Integer value2) {
            addCriterion("btdb not between", value1, value2, "btdb");
            return (Criteria) this;
        }

        public Criteria andXbtdbIsNull() {
            addCriterion("xbtdb is null");
            return (Criteria) this;
        }

        public Criteria andXbtdbIsNotNull() {
            addCriterion("xbtdb is not null");
            return (Criteria) this;
        }

        public Criteria andXbtdbEqualTo(Integer value) {
            addCriterion("xbtdb =", value, "xbtdb");
            return (Criteria) this;
        }

        public Criteria andXbtdbNotEqualTo(Integer value) {
            addCriterion("xbtdb <>", value, "xbtdb");
            return (Criteria) this;
        }

        public Criteria andXbtdbGreaterThan(Integer value) {
            addCriterion("xbtdb >", value, "xbtdb");
            return (Criteria) this;
        }

        public Criteria andXbtdbGreaterThanOrEqualTo(Integer value) {
            addCriterion("xbtdb >=", value, "xbtdb");
            return (Criteria) this;
        }

        public Criteria andXbtdbLessThan(Integer value) {
            addCriterion("xbtdb <", value, "xbtdb");
            return (Criteria) this;
        }

        public Criteria andXbtdbLessThanOrEqualTo(Integer value) {
            addCriterion("xbtdb <=", value, "xbtdb");
            return (Criteria) this;
        }

        public Criteria andXbtdbIn(List<Integer> values) {
            addCriterion("xbtdb in", values, "xbtdb");
            return (Criteria) this;
        }

        public Criteria andXbtdbNotIn(List<Integer> values) {
            addCriterion("xbtdb not in", values, "xbtdb");
            return (Criteria) this;
        }

        public Criteria andXbtdbBetween(Integer value1, Integer value2) {
            addCriterion("xbtdb between", value1, value2, "xbtdb");
            return (Criteria) this;
        }

        public Criteria andXbtdbNotBetween(Integer value1, Integer value2) {
            addCriterion("xbtdb not between", value1, value2, "xbtdb");
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