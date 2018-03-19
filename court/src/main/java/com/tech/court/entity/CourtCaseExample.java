package com.tech.court.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CourtCaseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public CourtCaseExample() {
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

        public Criteria andDeadlineIsNull() {
            addCriterion("deadline is null");
            return (Criteria) this;
        }

        public Criteria andDeadlineIsNotNull() {
            addCriterion("deadline is not null");
            return (Criteria) this;
        }

        public Criteria andDeadlineEqualTo(Integer value) {
            addCriterion("deadline =", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineNotEqualTo(Integer value) {
            addCriterion("deadline <>", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineGreaterThan(Integer value) {
            addCriterion("deadline >", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineGreaterThanOrEqualTo(Integer value) {
            addCriterion("deadline >=", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineLessThan(Integer value) {
            addCriterion("deadline <", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineLessThanOrEqualTo(Integer value) {
            addCriterion("deadline <=", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineIn(List<Integer> values) {
            addCriterion("deadline in", values, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineNotIn(List<Integer> values) {
            addCriterion("deadline not in", values, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineBetween(Integer value1, Integer value2) {
            addCriterion("deadline between", value1, value2, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineNotBetween(Integer value1, Integer value2) {
            addCriterion("deadline not between", value1, value2, "deadline");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andReasonIsNull() {
            addCriterion("reason is null");
            return (Criteria) this;
        }

        public Criteria andReasonIsNotNull() {
            addCriterion("reason is not null");
            return (Criteria) this;
        }

        public Criteria andReasonEqualTo(String value) {
            addCriterion("reason =", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotEqualTo(String value) {
            addCriterion("reason <>", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThan(String value) {
            addCriterion("reason >", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThanOrEqualTo(String value) {
            addCriterion("reason >=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThan(String value) {
            addCriterion("reason <", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThanOrEqualTo(String value) {
            addCriterion("reason <=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLike(String value) {
            addCriterion("reason like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotLike(String value) {
            addCriterion("reason not like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonIn(List<String> values) {
            addCriterion("reason in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotIn(List<String> values) {
            addCriterion("reason not in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonBetween(String value1, String value2) {
            addCriterion("reason between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotBetween(String value1, String value2) {
            addCriterion("reason not between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andAcceptDateIsNull() {
            addCriterion("accept_date is null");
            return (Criteria) this;
        }

        public Criteria andAcceptDateIsNotNull() {
            addCriterion("accept_date is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptDateEqualTo(Date value) {
            addCriterionForJDBCDate("accept_date =", value, "acceptDate");
            return (Criteria) this;
        }

        public Criteria andAcceptDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("accept_date <>", value, "acceptDate");
            return (Criteria) this;
        }

        public Criteria andAcceptDateGreaterThan(Date value) {
            addCriterionForJDBCDate("accept_date >", value, "acceptDate");
            return (Criteria) this;
        }

        public Criteria andAcceptDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("accept_date >=", value, "acceptDate");
            return (Criteria) this;
        }

        public Criteria andAcceptDateLessThan(Date value) {
            addCriterionForJDBCDate("accept_date <", value, "acceptDate");
            return (Criteria) this;
        }

        public Criteria andAcceptDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("accept_date <=", value, "acceptDate");
            return (Criteria) this;
        }

        public Criteria andAcceptDateIn(List<Date> values) {
            addCriterionForJDBCDate("accept_date in", values, "acceptDate");
            return (Criteria) this;
        }

        public Criteria andAcceptDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("accept_date not in", values, "acceptDate");
            return (Criteria) this;
        }

        public Criteria andAcceptDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("accept_date between", value1, value2, "acceptDate");
            return (Criteria) this;
        }

        public Criteria andAcceptDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("accept_date not between", value1, value2, "acceptDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateIsNull() {
            addCriterion("register_date is null");
            return (Criteria) this;
        }

        public Criteria andRegisterDateIsNotNull() {
            addCriterion("register_date is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterDateEqualTo(Date value) {
            addCriterionForJDBCDate("register_date =", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("register_date <>", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateGreaterThan(Date value) {
            addCriterionForJDBCDate("register_date >", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("register_date >=", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateLessThan(Date value) {
            addCriterionForJDBCDate("register_date <", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("register_date <=", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateIn(List<Date> values) {
            addCriterionForJDBCDate("register_date in", values, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("register_date not in", values, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("register_date between", value1, value2, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("register_date not between", value1, value2, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterUserIsNull() {
            addCriterion("register_user is null");
            return (Criteria) this;
        }

        public Criteria andRegisterUserIsNotNull() {
            addCriterion("register_user is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterUserEqualTo(String value) {
            addCriterion("register_user =", value, "registerUser");
            return (Criteria) this;
        }

        public Criteria andRegisterUserNotEqualTo(String value) {
            addCriterion("register_user <>", value, "registerUser");
            return (Criteria) this;
        }

        public Criteria andRegisterUserGreaterThan(String value) {
            addCriterion("register_user >", value, "registerUser");
            return (Criteria) this;
        }

        public Criteria andRegisterUserGreaterThanOrEqualTo(String value) {
            addCriterion("register_user >=", value, "registerUser");
            return (Criteria) this;
        }

        public Criteria andRegisterUserLessThan(String value) {
            addCriterion("register_user <", value, "registerUser");
            return (Criteria) this;
        }

        public Criteria andRegisterUserLessThanOrEqualTo(String value) {
            addCriterion("register_user <=", value, "registerUser");
            return (Criteria) this;
        }

        public Criteria andRegisterUserLike(String value) {
            addCriterion("register_user like", value, "registerUser");
            return (Criteria) this;
        }

        public Criteria andRegisterUserNotLike(String value) {
            addCriterion("register_user not like", value, "registerUser");
            return (Criteria) this;
        }

        public Criteria andRegisterUserIn(List<String> values) {
            addCriterion("register_user in", values, "registerUser");
            return (Criteria) this;
        }

        public Criteria andRegisterUserNotIn(List<String> values) {
            addCriterion("register_user not in", values, "registerUser");
            return (Criteria) this;
        }

        public Criteria andRegisterUserBetween(String value1, String value2) {
            addCriterion("register_user between", value1, value2, "registerUser");
            return (Criteria) this;
        }

        public Criteria andRegisterUserNotBetween(String value1, String value2) {
            addCriterion("register_user not between", value1, value2, "registerUser");
            return (Criteria) this;
        }

        public Criteria andUndertakeDepartmentIsNull() {
            addCriterion("undertake_department is null");
            return (Criteria) this;
        }

        public Criteria andUndertakeDepartmentIsNotNull() {
            addCriterion("undertake_department is not null");
            return (Criteria) this;
        }

        public Criteria andUndertakeDepartmentEqualTo(String value) {
            addCriterion("undertake_department =", value, "undertakeDepartment");
            return (Criteria) this;
        }

        public Criteria andUndertakeDepartmentNotEqualTo(String value) {
            addCriterion("undertake_department <>", value, "undertakeDepartment");
            return (Criteria) this;
        }

        public Criteria andUndertakeDepartmentGreaterThan(String value) {
            addCriterion("undertake_department >", value, "undertakeDepartment");
            return (Criteria) this;
        }

        public Criteria andUndertakeDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("undertake_department >=", value, "undertakeDepartment");
            return (Criteria) this;
        }

        public Criteria andUndertakeDepartmentLessThan(String value) {
            addCriterion("undertake_department <", value, "undertakeDepartment");
            return (Criteria) this;
        }

        public Criteria andUndertakeDepartmentLessThanOrEqualTo(String value) {
            addCriterion("undertake_department <=", value, "undertakeDepartment");
            return (Criteria) this;
        }

        public Criteria andUndertakeDepartmentLike(String value) {
            addCriterion("undertake_department like", value, "undertakeDepartment");
            return (Criteria) this;
        }

        public Criteria andUndertakeDepartmentNotLike(String value) {
            addCriterion("undertake_department not like", value, "undertakeDepartment");
            return (Criteria) this;
        }

        public Criteria andUndertakeDepartmentIn(List<String> values) {
            addCriterion("undertake_department in", values, "undertakeDepartment");
            return (Criteria) this;
        }

        public Criteria andUndertakeDepartmentNotIn(List<String> values) {
            addCriterion("undertake_department not in", values, "undertakeDepartment");
            return (Criteria) this;
        }

        public Criteria andUndertakeDepartmentBetween(String value1, String value2) {
            addCriterion("undertake_department between", value1, value2, "undertakeDepartment");
            return (Criteria) this;
        }

        public Criteria andUndertakeDepartmentNotBetween(String value1, String value2) {
            addCriterion("undertake_department not between", value1, value2, "undertakeDepartment");
            return (Criteria) this;
        }

        public Criteria andUndertakeUserIsNull() {
            addCriterion("undertake_user is null");
            return (Criteria) this;
        }

        public Criteria andUndertakeUserIsNotNull() {
            addCriterion("undertake_user is not null");
            return (Criteria) this;
        }

        public Criteria andUndertakeUserEqualTo(String value) {
            addCriterion("undertake_user =", value, "undertakeUser");
            return (Criteria) this;
        }

        public Criteria andUndertakeUserNotEqualTo(String value) {
            addCriterion("undertake_user <>", value, "undertakeUser");
            return (Criteria) this;
        }

        public Criteria andUndertakeUserGreaterThan(String value) {
            addCriterion("undertake_user >", value, "undertakeUser");
            return (Criteria) this;
        }

        public Criteria andUndertakeUserGreaterThanOrEqualTo(String value) {
            addCriterion("undertake_user >=", value, "undertakeUser");
            return (Criteria) this;
        }

        public Criteria andUndertakeUserLessThan(String value) {
            addCriterion("undertake_user <", value, "undertakeUser");
            return (Criteria) this;
        }

        public Criteria andUndertakeUserLessThanOrEqualTo(String value) {
            addCriterion("undertake_user <=", value, "undertakeUser");
            return (Criteria) this;
        }

        public Criteria andUndertakeUserLike(String value) {
            addCriterion("undertake_user like", value, "undertakeUser");
            return (Criteria) this;
        }

        public Criteria andUndertakeUserNotLike(String value) {
            addCriterion("undertake_user not like", value, "undertakeUser");
            return (Criteria) this;
        }

        public Criteria andUndertakeUserIn(List<String> values) {
            addCriterion("undertake_user in", values, "undertakeUser");
            return (Criteria) this;
        }

        public Criteria andUndertakeUserNotIn(List<String> values) {
            addCriterion("undertake_user not in", values, "undertakeUser");
            return (Criteria) this;
        }

        public Criteria andUndertakeUserBetween(String value1, String value2) {
            addCriterion("undertake_user between", value1, value2, "undertakeUser");
            return (Criteria) this;
        }

        public Criteria andUndertakeUserNotBetween(String value1, String value2) {
            addCriterion("undertake_user not between", value1, value2, "undertakeUser");
            return (Criteria) this;
        }

        public Criteria andOpenDateIsNull() {
            addCriterion("open_date is null");
            return (Criteria) this;
        }

        public Criteria andOpenDateIsNotNull() {
            addCriterion("open_date is not null");
            return (Criteria) this;
        }

        public Criteria andOpenDateEqualTo(Date value) {
            addCriterionForJDBCDate("open_date =", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("open_date <>", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateGreaterThan(Date value) {
            addCriterionForJDBCDate("open_date >", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("open_date >=", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateLessThan(Date value) {
            addCriterionForJDBCDate("open_date <", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("open_date <=", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateIn(List<Date> values) {
            addCriterionForJDBCDate("open_date in", values, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("open_date not in", values, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("open_date between", value1, value2, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("open_date not between", value1, value2, "openDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNull() {
            addCriterion("end_date is null");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNotNull() {
            addCriterion("end_date is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(Date value) {
            addCriterionForJDBCDate("end_date =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("end_date <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(Date value) {
            addCriterionForJDBCDate("end_date >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("end_date >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(Date value) {
            addCriterionForJDBCDate("end_date <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("end_date <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<Date> values) {
            addCriterionForJDBCDate("end_date in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("end_date not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("end_date between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("end_date not between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andReportEndDateIsNull() {
            addCriterion("report_end_date is null");
            return (Criteria) this;
        }

        public Criteria andReportEndDateIsNotNull() {
            addCriterion("report_end_date is not null");
            return (Criteria) this;
        }

        public Criteria andReportEndDateEqualTo(Date value) {
            addCriterionForJDBCDate("report_end_date =", value, "reportEndDate");
            return (Criteria) this;
        }

        public Criteria andReportEndDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("report_end_date <>", value, "reportEndDate");
            return (Criteria) this;
        }

        public Criteria andReportEndDateGreaterThan(Date value) {
            addCriterionForJDBCDate("report_end_date >", value, "reportEndDate");
            return (Criteria) this;
        }

        public Criteria andReportEndDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("report_end_date >=", value, "reportEndDate");
            return (Criteria) this;
        }

        public Criteria andReportEndDateLessThan(Date value) {
            addCriterionForJDBCDate("report_end_date <", value, "reportEndDate");
            return (Criteria) this;
        }

        public Criteria andReportEndDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("report_end_date <=", value, "reportEndDate");
            return (Criteria) this;
        }

        public Criteria andReportEndDateIn(List<Date> values) {
            addCriterionForJDBCDate("report_end_date in", values, "reportEndDate");
            return (Criteria) this;
        }

        public Criteria andReportEndDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("report_end_date not in", values, "reportEndDate");
            return (Criteria) this;
        }

        public Criteria andReportEndDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("report_end_date between", value1, value2, "reportEndDate");
            return (Criteria) this;
        }

        public Criteria andReportEndDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("report_end_date not between", value1, value2, "reportEndDate");
            return (Criteria) this;
        }

        public Criteria andActualEndDateIsNull() {
            addCriterion("actual_end_date is null");
            return (Criteria) this;
        }

        public Criteria andActualEndDateIsNotNull() {
            addCriterion("actual_end_date is not null");
            return (Criteria) this;
        }

        public Criteria andActualEndDateEqualTo(Date value) {
            addCriterionForJDBCDate("actual_end_date =", value, "actualEndDate");
            return (Criteria) this;
        }

        public Criteria andActualEndDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("actual_end_date <>", value, "actualEndDate");
            return (Criteria) this;
        }

        public Criteria andActualEndDateGreaterThan(Date value) {
            addCriterionForJDBCDate("actual_end_date >", value, "actualEndDate");
            return (Criteria) this;
        }

        public Criteria andActualEndDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("actual_end_date >=", value, "actualEndDate");
            return (Criteria) this;
        }

        public Criteria andActualEndDateLessThan(Date value) {
            addCriterionForJDBCDate("actual_end_date <", value, "actualEndDate");
            return (Criteria) this;
        }

        public Criteria andActualEndDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("actual_end_date <=", value, "actualEndDate");
            return (Criteria) this;
        }

        public Criteria andActualEndDateIn(List<Date> values) {
            addCriterionForJDBCDate("actual_end_date in", values, "actualEndDate");
            return (Criteria) this;
        }

        public Criteria andActualEndDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("actual_end_date not in", values, "actualEndDate");
            return (Criteria) this;
        }

        public Criteria andActualEndDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("actual_end_date between", value1, value2, "actualEndDate");
            return (Criteria) this;
        }

        public Criteria andActualEndDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("actual_end_date not between", value1, value2, "actualEndDate");
            return (Criteria) this;
        }

        public Criteria andEndMethodIsNull() {
            addCriterion("end_method is null");
            return (Criteria) this;
        }

        public Criteria andEndMethodIsNotNull() {
            addCriterion("end_method is not null");
            return (Criteria) this;
        }

        public Criteria andEndMethodEqualTo(String value) {
            addCriterion("end_method =", value, "endMethod");
            return (Criteria) this;
        }

        public Criteria andEndMethodNotEqualTo(String value) {
            addCriterion("end_method <>", value, "endMethod");
            return (Criteria) this;
        }

        public Criteria andEndMethodGreaterThan(String value) {
            addCriterion("end_method >", value, "endMethod");
            return (Criteria) this;
        }

        public Criteria andEndMethodGreaterThanOrEqualTo(String value) {
            addCriterion("end_method >=", value, "endMethod");
            return (Criteria) this;
        }

        public Criteria andEndMethodLessThan(String value) {
            addCriterion("end_method <", value, "endMethod");
            return (Criteria) this;
        }

        public Criteria andEndMethodLessThanOrEqualTo(String value) {
            addCriterion("end_method <=", value, "endMethod");
            return (Criteria) this;
        }

        public Criteria andEndMethodLike(String value) {
            addCriterion("end_method like", value, "endMethod");
            return (Criteria) this;
        }

        public Criteria andEndMethodNotLike(String value) {
            addCriterion("end_method not like", value, "endMethod");
            return (Criteria) this;
        }

        public Criteria andEndMethodIn(List<String> values) {
            addCriterion("end_method in", values, "endMethod");
            return (Criteria) this;
        }

        public Criteria andEndMethodNotIn(List<String> values) {
            addCriterion("end_method not in", values, "endMethod");
            return (Criteria) this;
        }

        public Criteria andEndMethodBetween(String value1, String value2) {
            addCriterion("end_method between", value1, value2, "endMethod");
            return (Criteria) this;
        }

        public Criteria andEndMethodNotBetween(String value1, String value2) {
            addCriterion("end_method not between", value1, value2, "endMethod");
            return (Criteria) this;
        }

        public Criteria andRegisterAmountIsNull() {
            addCriterion("register_amount is null");
            return (Criteria) this;
        }

        public Criteria andRegisterAmountIsNotNull() {
            addCriterion("register_amount is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterAmountEqualTo(BigDecimal value) {
            addCriterion("register_amount =", value, "registerAmount");
            return (Criteria) this;
        }

        public Criteria andRegisterAmountNotEqualTo(BigDecimal value) {
            addCriterion("register_amount <>", value, "registerAmount");
            return (Criteria) this;
        }

        public Criteria andRegisterAmountGreaterThan(BigDecimal value) {
            addCriterion("register_amount >", value, "registerAmount");
            return (Criteria) this;
        }

        public Criteria andRegisterAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("register_amount >=", value, "registerAmount");
            return (Criteria) this;
        }

        public Criteria andRegisterAmountLessThan(BigDecimal value) {
            addCriterion("register_amount <", value, "registerAmount");
            return (Criteria) this;
        }

        public Criteria andRegisterAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("register_amount <=", value, "registerAmount");
            return (Criteria) this;
        }

        public Criteria andRegisterAmountIn(List<BigDecimal> values) {
            addCriterion("register_amount in", values, "registerAmount");
            return (Criteria) this;
        }

        public Criteria andRegisterAmountNotIn(List<BigDecimal> values) {
            addCriterion("register_amount not in", values, "registerAmount");
            return (Criteria) this;
        }

        public Criteria andRegisterAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("register_amount between", value1, value2, "registerAmount");
            return (Criteria) this;
        }

        public Criteria andRegisterAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("register_amount not between", value1, value2, "registerAmount");
            return (Criteria) this;
        }

        public Criteria andEndAmountIsNull() {
            addCriterion("end_amount is null");
            return (Criteria) this;
        }

        public Criteria andEndAmountIsNotNull() {
            addCriterion("end_amount is not null");
            return (Criteria) this;
        }

        public Criteria andEndAmountEqualTo(BigDecimal value) {
            addCriterion("end_amount =", value, "endAmount");
            return (Criteria) this;
        }

        public Criteria andEndAmountNotEqualTo(BigDecimal value) {
            addCriterion("end_amount <>", value, "endAmount");
            return (Criteria) this;
        }

        public Criteria andEndAmountGreaterThan(BigDecimal value) {
            addCriterion("end_amount >", value, "endAmount");
            return (Criteria) this;
        }

        public Criteria andEndAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("end_amount >=", value, "endAmount");
            return (Criteria) this;
        }

        public Criteria andEndAmountLessThan(BigDecimal value) {
            addCriterion("end_amount <", value, "endAmount");
            return (Criteria) this;
        }

        public Criteria andEndAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("end_amount <=", value, "endAmount");
            return (Criteria) this;
        }

        public Criteria andEndAmountIn(List<BigDecimal> values) {
            addCriterion("end_amount in", values, "endAmount");
            return (Criteria) this;
        }

        public Criteria andEndAmountNotIn(List<BigDecimal> values) {
            addCriterion("end_amount not in", values, "endAmount");
            return (Criteria) this;
        }

        public Criteria andEndAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("end_amount between", value1, value2, "endAmount");
            return (Criteria) this;
        }

        public Criteria andEndAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("end_amount not between", value1, value2, "endAmount");
            return (Criteria) this;
        }

        public Criteria andActualAmountIsNull() {
            addCriterion("actual_amount is null");
            return (Criteria) this;
        }

        public Criteria andActualAmountIsNotNull() {
            addCriterion("actual_amount is not null");
            return (Criteria) this;
        }

        public Criteria andActualAmountEqualTo(BigDecimal value) {
            addCriterion("actual_amount =", value, "actualAmount");
            return (Criteria) this;
        }

        public Criteria andActualAmountNotEqualTo(BigDecimal value) {
            addCriterion("actual_amount <>", value, "actualAmount");
            return (Criteria) this;
        }

        public Criteria andActualAmountGreaterThan(BigDecimal value) {
            addCriterion("actual_amount >", value, "actualAmount");
            return (Criteria) this;
        }

        public Criteria andActualAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("actual_amount >=", value, "actualAmount");
            return (Criteria) this;
        }

        public Criteria andActualAmountLessThan(BigDecimal value) {
            addCriterion("actual_amount <", value, "actualAmount");
            return (Criteria) this;
        }

        public Criteria andActualAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("actual_amount <=", value, "actualAmount");
            return (Criteria) this;
        }

        public Criteria andActualAmountIn(List<BigDecimal> values) {
            addCriterion("actual_amount in", values, "actualAmount");
            return (Criteria) this;
        }

        public Criteria andActualAmountNotIn(List<BigDecimal> values) {
            addCriterion("actual_amount not in", values, "actualAmount");
            return (Criteria) this;
        }

        public Criteria andActualAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("actual_amount between", value1, value2, "actualAmount");
            return (Criteria) this;
        }

        public Criteria andActualAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("actual_amount not between", value1, value2, "actualAmount");
            return (Criteria) this;
        }

        public Criteria andAbandonAmountIsNull() {
            addCriterion("abandon_amount is null");
            return (Criteria) this;
        }

        public Criteria andAbandonAmountIsNotNull() {
            addCriterion("abandon_amount is not null");
            return (Criteria) this;
        }

        public Criteria andAbandonAmountEqualTo(BigDecimal value) {
            addCriterion("abandon_amount =", value, "abandonAmount");
            return (Criteria) this;
        }

        public Criteria andAbandonAmountNotEqualTo(BigDecimal value) {
            addCriterion("abandon_amount <>", value, "abandonAmount");
            return (Criteria) this;
        }

        public Criteria andAbandonAmountGreaterThan(BigDecimal value) {
            addCriterion("abandon_amount >", value, "abandonAmount");
            return (Criteria) this;
        }

        public Criteria andAbandonAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("abandon_amount >=", value, "abandonAmount");
            return (Criteria) this;
        }

        public Criteria andAbandonAmountLessThan(BigDecimal value) {
            addCriterion("abandon_amount <", value, "abandonAmount");
            return (Criteria) this;
        }

        public Criteria andAbandonAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("abandon_amount <=", value, "abandonAmount");
            return (Criteria) this;
        }

        public Criteria andAbandonAmountIn(List<BigDecimal> values) {
            addCriterion("abandon_amount in", values, "abandonAmount");
            return (Criteria) this;
        }

        public Criteria andAbandonAmountNotIn(List<BigDecimal> values) {
            addCriterion("abandon_amount not in", values, "abandonAmount");
            return (Criteria) this;
        }

        public Criteria andAbandonAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("abandon_amount between", value1, value2, "abandonAmount");
            return (Criteria) this;
        }

        public Criteria andAbandonAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("abandon_amount not between", value1, value2, "abandonAmount");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andCaseInvolvedIsNull() {
            addCriterion("case_involved is null");
            return (Criteria) this;
        }

        public Criteria andCaseInvolvedIsNotNull() {
            addCriterion("case_involved is not null");
            return (Criteria) this;
        }

        public Criteria andCaseInvolvedEqualTo(String value) {
            addCriterion("case_involved =", value, "caseInvolved");
            return (Criteria) this;
        }

        public Criteria andCaseInvolvedNotEqualTo(String value) {
            addCriterion("case_involved <>", value, "caseInvolved");
            return (Criteria) this;
        }

        public Criteria andCaseInvolvedGreaterThan(String value) {
            addCriterion("case_involved >", value, "caseInvolved");
            return (Criteria) this;
        }

        public Criteria andCaseInvolvedGreaterThanOrEqualTo(String value) {
            addCriterion("case_involved >=", value, "caseInvolved");
            return (Criteria) this;
        }

        public Criteria andCaseInvolvedLessThan(String value) {
            addCriterion("case_involved <", value, "caseInvolved");
            return (Criteria) this;
        }

        public Criteria andCaseInvolvedLessThanOrEqualTo(String value) {
            addCriterion("case_involved <=", value, "caseInvolved");
            return (Criteria) this;
        }

        public Criteria andCaseInvolvedLike(String value) {
            addCriterion("case_involved like", value, "caseInvolved");
            return (Criteria) this;
        }

        public Criteria andCaseInvolvedNotLike(String value) {
            addCriterion("case_involved not like", value, "caseInvolved");
            return (Criteria) this;
        }

        public Criteria andCaseInvolvedIn(List<String> values) {
            addCriterion("case_involved in", values, "caseInvolved");
            return (Criteria) this;
        }

        public Criteria andCaseInvolvedNotIn(List<String> values) {
            addCriterion("case_involved not in", values, "caseInvolved");
            return (Criteria) this;
        }

        public Criteria andCaseInvolvedBetween(String value1, String value2) {
            addCriterion("case_involved between", value1, value2, "caseInvolved");
            return (Criteria) this;
        }

        public Criteria andCaseInvolvedNotBetween(String value1, String value2) {
            addCriterion("case_involved not between", value1, value2, "caseInvolved");
            return (Criteria) this;
        }

        public Criteria andChiefJudgeIsNull() {
            addCriterion("chief_judge is null");
            return (Criteria) this;
        }

        public Criteria andChiefJudgeIsNotNull() {
            addCriterion("chief_judge is not null");
            return (Criteria) this;
        }

        public Criteria andChiefJudgeEqualTo(String value) {
            addCriterion("chief_judge =", value, "chiefJudge");
            return (Criteria) this;
        }

        public Criteria andChiefJudgeNotEqualTo(String value) {
            addCriterion("chief_judge <>", value, "chiefJudge");
            return (Criteria) this;
        }

        public Criteria andChiefJudgeGreaterThan(String value) {
            addCriterion("chief_judge >", value, "chiefJudge");
            return (Criteria) this;
        }

        public Criteria andChiefJudgeGreaterThanOrEqualTo(String value) {
            addCriterion("chief_judge >=", value, "chiefJudge");
            return (Criteria) this;
        }

        public Criteria andChiefJudgeLessThan(String value) {
            addCriterion("chief_judge <", value, "chiefJudge");
            return (Criteria) this;
        }

        public Criteria andChiefJudgeLessThanOrEqualTo(String value) {
            addCriterion("chief_judge <=", value, "chiefJudge");
            return (Criteria) this;
        }

        public Criteria andChiefJudgeLike(String value) {
            addCriterion("chief_judge like", value, "chiefJudge");
            return (Criteria) this;
        }

        public Criteria andChiefJudgeNotLike(String value) {
            addCriterion("chief_judge not like", value, "chiefJudge");
            return (Criteria) this;
        }

        public Criteria andChiefJudgeIn(List<String> values) {
            addCriterion("chief_judge in", values, "chiefJudge");
            return (Criteria) this;
        }

        public Criteria andChiefJudgeNotIn(List<String> values) {
            addCriterion("chief_judge not in", values, "chiefJudge");
            return (Criteria) this;
        }

        public Criteria andChiefJudgeBetween(String value1, String value2) {
            addCriterion("chief_judge between", value1, value2, "chiefJudge");
            return (Criteria) this;
        }

        public Criteria andChiefJudgeNotBetween(String value1, String value2) {
            addCriterion("chief_judge not between", value1, value2, "chiefJudge");
            return (Criteria) this;
        }

        public Criteria andProgramIsNull() {
            addCriterion("program is null");
            return (Criteria) this;
        }

        public Criteria andProgramIsNotNull() {
            addCriterion("program is not null");
            return (Criteria) this;
        }

        public Criteria andProgramEqualTo(String value) {
            addCriterion("program =", value, "program");
            return (Criteria) this;
        }

        public Criteria andProgramNotEqualTo(String value) {
            addCriterion("program <>", value, "program");
            return (Criteria) this;
        }

        public Criteria andProgramGreaterThan(String value) {
            addCriterion("program >", value, "program");
            return (Criteria) this;
        }

        public Criteria andProgramGreaterThanOrEqualTo(String value) {
            addCriterion("program >=", value, "program");
            return (Criteria) this;
        }

        public Criteria andProgramLessThan(String value) {
            addCriterion("program <", value, "program");
            return (Criteria) this;
        }

        public Criteria andProgramLessThanOrEqualTo(String value) {
            addCriterion("program <=", value, "program");
            return (Criteria) this;
        }

        public Criteria andProgramLike(String value) {
            addCriterion("program like", value, "program");
            return (Criteria) this;
        }

        public Criteria andProgramNotLike(String value) {
            addCriterion("program not like", value, "program");
            return (Criteria) this;
        }

        public Criteria andProgramIn(List<String> values) {
            addCriterion("program in", values, "program");
            return (Criteria) this;
        }

        public Criteria andProgramNotIn(List<String> values) {
            addCriterion("program not in", values, "program");
            return (Criteria) this;
        }

        public Criteria andProgramBetween(String value1, String value2) {
            addCriterion("program between", value1, value2, "program");
            return (Criteria) this;
        }

        public Criteria andProgramNotBetween(String value1, String value2) {
            addCriterion("program not between", value1, value2, "program");
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

        public Criteria andJudgeDaysEqualTo(Integer value) {
            addCriterion("judge_days =", value, "judgeDays");
            return (Criteria) this;
        }

        public Criteria andJudgeDaysNotEqualTo(Integer value) {
            addCriterion("judge_days <>", value, "judgeDays");
            return (Criteria) this;
        }

        public Criteria andJudgeDaysGreaterThan(Integer value) {
            addCriterion("judge_days >", value, "judgeDays");
            return (Criteria) this;
        }

        public Criteria andJudgeDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("judge_days >=", value, "judgeDays");
            return (Criteria) this;
        }

        public Criteria andJudgeDaysLessThan(Integer value) {
            addCriterion("judge_days <", value, "judgeDays");
            return (Criteria) this;
        }

        public Criteria andJudgeDaysLessThanOrEqualTo(Integer value) {
            addCriterion("judge_days <=", value, "judgeDays");
            return (Criteria) this;
        }

        public Criteria andJudgeDaysIn(List<Integer> values) {
            addCriterion("judge_days in", values, "judgeDays");
            return (Criteria) this;
        }

        public Criteria andJudgeDaysNotIn(List<Integer> values) {
            addCriterion("judge_days not in", values, "judgeDays");
            return (Criteria) this;
        }

        public Criteria andJudgeDaysBetween(Integer value1, Integer value2) {
            addCriterion("judge_days between", value1, value2, "judgeDays");
            return (Criteria) this;
        }

        public Criteria andJudgeDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("judge_days not between", value1, value2, "judgeDays");
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