package com.dkt.school.equ.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RoomApplicationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RoomApplicationExample() {
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

        public Criteria andApplicationIdIsNull() {
            addCriterion("application_id is null");
            return (Criteria) this;
        }

        public Criteria andApplicationIdIsNotNull() {
            addCriterion("application_id is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationIdEqualTo(Integer value) {
            addCriterion("application_id =", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdNotEqualTo(Integer value) {
            addCriterion("application_id <>", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdGreaterThan(Integer value) {
            addCriterion("application_id >", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("application_id >=", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdLessThan(Integer value) {
            addCriterion("application_id <", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdLessThanOrEqualTo(Integer value) {
            addCriterion("application_id <=", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdIn(List<Integer> values) {
            addCriterion("application_id in", values, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdNotIn(List<Integer> values) {
            addCriterion("application_id not in", values, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdBetween(Integer value1, Integer value2) {
            addCriterion("application_id between", value1, value2, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdNotBetween(Integer value1, Integer value2) {
            addCriterion("application_id not between", value1, value2, "applicationId");
            return (Criteria) this;
        }

        public Criteria andFunctionRoomIdIsNull() {
            addCriterion("function_room_id is null");
            return (Criteria) this;
        }

        public Criteria andFunctionRoomIdIsNotNull() {
            addCriterion("function_room_id is not null");
            return (Criteria) this;
        }

        public Criteria andFunctionRoomIdEqualTo(Integer value) {
            addCriterion("function_room_id =", value, "functionRoomId");
            return (Criteria) this;
        }

        public Criteria andFunctionRoomIdNotEqualTo(Integer value) {
            addCriterion("function_room_id <>", value, "functionRoomId");
            return (Criteria) this;
        }

        public Criteria andFunctionRoomIdGreaterThan(Integer value) {
            addCriterion("function_room_id >", value, "functionRoomId");
            return (Criteria) this;
        }

        public Criteria andFunctionRoomIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("function_room_id >=", value, "functionRoomId");
            return (Criteria) this;
        }

        public Criteria andFunctionRoomIdLessThan(Integer value) {
            addCriterion("function_room_id <", value, "functionRoomId");
            return (Criteria) this;
        }

        public Criteria andFunctionRoomIdLessThanOrEqualTo(Integer value) {
            addCriterion("function_room_id <=", value, "functionRoomId");
            return (Criteria) this;
        }

        public Criteria andFunctionRoomIdIn(List<Integer> values) {
            addCriterion("function_room_id in", values, "functionRoomId");
            return (Criteria) this;
        }

        public Criteria andFunctionRoomIdNotIn(List<Integer> values) {
            addCriterion("function_room_id not in", values, "functionRoomId");
            return (Criteria) this;
        }

        public Criteria andFunctionRoomIdBetween(Integer value1, Integer value2) {
            addCriterion("function_room_id between", value1, value2, "functionRoomId");
            return (Criteria) this;
        }

        public Criteria andFunctionRoomIdNotBetween(Integer value1, Integer value2) {
            addCriterion("function_room_id not between", value1, value2, "functionRoomId");
            return (Criteria) this;
        }

        public Criteria andUseUserIdIsNull() {
            addCriterion("use_user_id is null");
            return (Criteria) this;
        }

        public Criteria andUseUserIdIsNotNull() {
            addCriterion("use_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUseUserIdEqualTo(Integer value) {
            addCriterion("use_user_id =", value, "useUserId");
            return (Criteria) this;
        }

        public Criteria andUseUserIdNotEqualTo(Integer value) {
            addCriterion("use_user_id <>", value, "useUserId");
            return (Criteria) this;
        }

        public Criteria andUseUserIdGreaterThan(Integer value) {
            addCriterion("use_user_id >", value, "useUserId");
            return (Criteria) this;
        }

        public Criteria andUseUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("use_user_id >=", value, "useUserId");
            return (Criteria) this;
        }

        public Criteria andUseUserIdLessThan(Integer value) {
            addCriterion("use_user_id <", value, "useUserId");
            return (Criteria) this;
        }

        public Criteria andUseUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("use_user_id <=", value, "useUserId");
            return (Criteria) this;
        }

        public Criteria andUseUserIdIn(List<Integer> values) {
            addCriterion("use_user_id in", values, "useUserId");
            return (Criteria) this;
        }

        public Criteria andUseUserIdNotIn(List<Integer> values) {
            addCriterion("use_user_id not in", values, "useUserId");
            return (Criteria) this;
        }

        public Criteria andUseUserIdBetween(Integer value1, Integer value2) {
            addCriterion("use_user_id between", value1, value2, "useUserId");
            return (Criteria) this;
        }

        public Criteria andUseUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("use_user_id not between", value1, value2, "useUserId");
            return (Criteria) this;
        }

        public Criteria andUseFromDateIsNull() {
            addCriterion("use_from_date is null");
            return (Criteria) this;
        }

        public Criteria andUseFromDateIsNotNull() {
            addCriterion("use_from_date is not null");
            return (Criteria) this;
        }

        public Criteria andUseFromDateEqualTo(Date value) {
            addCriterion("use_from_date =", value, "useFromDate");
            return (Criteria) this;
        }

        public Criteria andUseFromDateNotEqualTo(Date value) {
            addCriterion("use_from_date <>", value, "useFromDate");
            return (Criteria) this;
        }

        public Criteria andUseFromDateGreaterThan(Date value) {
            addCriterion("use_from_date >", value, "useFromDate");
            return (Criteria) this;
        }

        public Criteria andUseFromDateGreaterThanOrEqualTo(Date value) {
            addCriterion("use_from_date >=", value, "useFromDate");
            return (Criteria) this;
        }

        public Criteria andUseFromDateLessThan(Date value) {
            addCriterion("use_from_date <", value, "useFromDate");
            return (Criteria) this;
        }

        public Criteria andUseFromDateLessThanOrEqualTo(Date value) {
            addCriterion("use_from_date <=", value, "useFromDate");
            return (Criteria) this;
        }

        public Criteria andUseFromDateIn(List<Date> values) {
            addCriterion("use_from_date in", values, "useFromDate");
            return (Criteria) this;
        }

        public Criteria andUseFromDateNotIn(List<Date> values) {
            addCriterion("use_from_date not in", values, "useFromDate");
            return (Criteria) this;
        }

        public Criteria andUseFromDateBetween(Date value1, Date value2) {
            addCriterion("use_from_date between", value1, value2, "useFromDate");
            return (Criteria) this;
        }

        public Criteria andUseFromDateNotBetween(Date value1, Date value2) {
            addCriterion("use_from_date not between", value1, value2, "useFromDate");
            return (Criteria) this;
        }

        public Criteria andUseToDateIsNull() {
            addCriterion("use_to_date is null");
            return (Criteria) this;
        }

        public Criteria andUseToDateIsNotNull() {
            addCriterion("use_to_date is not null");
            return (Criteria) this;
        }

        public Criteria andUseToDateEqualTo(Date value) {
            addCriterion("use_to_date =", value, "useToDate");
            return (Criteria) this;
        }

        public Criteria andUseToDateNotEqualTo(Date value) {
            addCriterion("use_to_date <>", value, "useToDate");
            return (Criteria) this;
        }

        public Criteria andUseToDateGreaterThan(Date value) {
            addCriterion("use_to_date >", value, "useToDate");
            return (Criteria) this;
        }

        public Criteria andUseToDateGreaterThanOrEqualTo(Date value) {
            addCriterion("use_to_date >=", value, "useToDate");
            return (Criteria) this;
        }

        public Criteria andUseToDateLessThan(Date value) {
            addCriterion("use_to_date <", value, "useToDate");
            return (Criteria) this;
        }

        public Criteria andUseToDateLessThanOrEqualTo(Date value) {
            addCriterion("use_to_date <=", value, "useToDate");
            return (Criteria) this;
        }

        public Criteria andUseToDateIn(List<Date> values) {
            addCriterion("use_to_date in", values, "useToDate");
            return (Criteria) this;
        }

        public Criteria andUseToDateNotIn(List<Date> values) {
            addCriterion("use_to_date not in", values, "useToDate");
            return (Criteria) this;
        }

        public Criteria andUseToDateBetween(Date value1, Date value2) {
            addCriterion("use_to_date between", value1, value2, "useToDate");
            return (Criteria) this;
        }

        public Criteria andUseToDateNotBetween(Date value1, Date value2) {
            addCriterion("use_to_date not between", value1, value2, "useToDate");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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