package com.dkt.school.stu.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class StuChangeClassExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StuChangeClassExample() {
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

        public Criteria andStudentIdIsNull() {
            addCriterion("student_id is null");
            return (Criteria) this;
        }

        public Criteria andStudentIdIsNotNull() {
            addCriterion("student_id is not null");
            return (Criteria) this;
        }

        public Criteria andStudentIdEqualTo(Integer value) {
            addCriterion("student_id =", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotEqualTo(Integer value) {
            addCriterion("student_id <>", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdGreaterThan(Integer value) {
            addCriterion("student_id >", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("student_id >=", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLessThan(Integer value) {
            addCriterion("student_id <", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLessThanOrEqualTo(Integer value) {
            addCriterion("student_id <=", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdIn(List<Integer> values) {
            addCriterion("student_id in", values, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotIn(List<Integer> values) {
            addCriterion("student_id not in", values, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdBetween(Integer value1, Integer value2) {
            addCriterion("student_id between", value1, value2, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("student_id not between", value1, value2, "studentId");
            return (Criteria) this;
        }

        public Criteria andChangeTypeIsNull() {
            addCriterion("change_type is null");
            return (Criteria) this;
        }

        public Criteria andChangeTypeIsNotNull() {
            addCriterion("change_type is not null");
            return (Criteria) this;
        }

        public Criteria andChangeTypeEqualTo(Integer value) {
            addCriterion("change_type =", value, "changeType");
            return (Criteria) this;
        }

        public Criteria andChangeTypeNotEqualTo(Integer value) {
            addCriterion("change_type <>", value, "changeType");
            return (Criteria) this;
        }

        public Criteria andChangeTypeGreaterThan(Integer value) {
            addCriterion("change_type >", value, "changeType");
            return (Criteria) this;
        }

        public Criteria andChangeTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("change_type >=", value, "changeType");
            return (Criteria) this;
        }

        public Criteria andChangeTypeLessThan(Integer value) {
            addCriterion("change_type <", value, "changeType");
            return (Criteria) this;
        }

        public Criteria andChangeTypeLessThanOrEqualTo(Integer value) {
            addCriterion("change_type <=", value, "changeType");
            return (Criteria) this;
        }

        public Criteria andChangeTypeIn(List<Integer> values) {
            addCriterion("change_type in", values, "changeType");
            return (Criteria) this;
        }

        public Criteria andChangeTypeNotIn(List<Integer> values) {
            addCriterion("change_type not in", values, "changeType");
            return (Criteria) this;
        }

        public Criteria andChangeTypeBetween(Integer value1, Integer value2) {
            addCriterion("change_type between", value1, value2, "changeType");
            return (Criteria) this;
        }

        public Criteria andChangeTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("change_type not between", value1, value2, "changeType");
            return (Criteria) this;
        }

        public Criteria andCauseIsNull() {
            addCriterion("cause is null");
            return (Criteria) this;
        }

        public Criteria andCauseIsNotNull() {
            addCriterion("cause is not null");
            return (Criteria) this;
        }

        public Criteria andCauseEqualTo(String value) {
            addCriterion("cause =", value, "cause");
            return (Criteria) this;
        }

        public Criteria andCauseNotEqualTo(String value) {
            addCriterion("cause <>", value, "cause");
            return (Criteria) this;
        }

        public Criteria andCauseGreaterThan(String value) {
            addCriterion("cause >", value, "cause");
            return (Criteria) this;
        }

        public Criteria andCauseGreaterThanOrEqualTo(String value) {
            addCriterion("cause >=", value, "cause");
            return (Criteria) this;
        }

        public Criteria andCauseLessThan(String value) {
            addCriterion("cause <", value, "cause");
            return (Criteria) this;
        }

        public Criteria andCauseLessThanOrEqualTo(String value) {
            addCriterion("cause <=", value, "cause");
            return (Criteria) this;
        }

        public Criteria andCauseLike(String value) {
            addCriterion("cause like", value, "cause");
            return (Criteria) this;
        }

        public Criteria andCauseNotLike(String value) {
            addCriterion("cause not like", value, "cause");
            return (Criteria) this;
        }

        public Criteria andCauseIn(List<String> values) {
            addCriterion("cause in", values, "cause");
            return (Criteria) this;
        }

        public Criteria andCauseNotIn(List<String> values) {
            addCriterion("cause not in", values, "cause");
            return (Criteria) this;
        }

        public Criteria andCauseBetween(String value1, String value2) {
            addCriterion("cause between", value1, value2, "cause");
            return (Criteria) this;
        }

        public Criteria andCauseNotBetween(String value1, String value2) {
            addCriterion("cause not between", value1, value2, "cause");
            return (Criteria) this;
        }

        public Criteria andOutClassIdIsNull() {
            addCriterion("out_class_id is null");
            return (Criteria) this;
        }

        public Criteria andOutClassIdIsNotNull() {
            addCriterion("out_class_id is not null");
            return (Criteria) this;
        }

        public Criteria andOutClassIdEqualTo(Integer value) {
            addCriterion("out_class_id =", value, "outClassId");
            return (Criteria) this;
        }

        public Criteria andOutClassIdNotEqualTo(Integer value) {
            addCriterion("out_class_id <>", value, "outClassId");
            return (Criteria) this;
        }

        public Criteria andOutClassIdGreaterThan(Integer value) {
            addCriterion("out_class_id >", value, "outClassId");
            return (Criteria) this;
        }

        public Criteria andOutClassIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("out_class_id >=", value, "outClassId");
            return (Criteria) this;
        }

        public Criteria andOutClassIdLessThan(Integer value) {
            addCriterion("out_class_id <", value, "outClassId");
            return (Criteria) this;
        }

        public Criteria andOutClassIdLessThanOrEqualTo(Integer value) {
            addCriterion("out_class_id <=", value, "outClassId");
            return (Criteria) this;
        }

        public Criteria andOutClassIdIn(List<Integer> values) {
            addCriterion("out_class_id in", values, "outClassId");
            return (Criteria) this;
        }

        public Criteria andOutClassIdNotIn(List<Integer> values) {
            addCriterion("out_class_id not in", values, "outClassId");
            return (Criteria) this;
        }

        public Criteria andOutClassIdBetween(Integer value1, Integer value2) {
            addCriterion("out_class_id between", value1, value2, "outClassId");
            return (Criteria) this;
        }

        public Criteria andOutClassIdNotBetween(Integer value1, Integer value2) {
            addCriterion("out_class_id not between", value1, value2, "outClassId");
            return (Criteria) this;
        }

        public Criteria andOutClassDateIsNull() {
            addCriterion("out_class_date is null");
            return (Criteria) this;
        }

        public Criteria andOutClassDateIsNotNull() {
            addCriterion("out_class_date is not null");
            return (Criteria) this;
        }

        public Criteria andOutClassDateEqualTo(Date value) {
            addCriterionForJDBCDate("out_class_date =", value, "outClassDate");
            return (Criteria) this;
        }

        public Criteria andOutClassDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("out_class_date <>", value, "outClassDate");
            return (Criteria) this;
        }

        public Criteria andOutClassDateGreaterThan(Date value) {
            addCriterionForJDBCDate("out_class_date >", value, "outClassDate");
            return (Criteria) this;
        }

        public Criteria andOutClassDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("out_class_date >=", value, "outClassDate");
            return (Criteria) this;
        }

        public Criteria andOutClassDateLessThan(Date value) {
            addCriterionForJDBCDate("out_class_date <", value, "outClassDate");
            return (Criteria) this;
        }

        public Criteria andOutClassDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("out_class_date <=", value, "outClassDate");
            return (Criteria) this;
        }

        public Criteria andOutClassDateIn(List<Date> values) {
            addCriterionForJDBCDate("out_class_date in", values, "outClassDate");
            return (Criteria) this;
        }

        public Criteria andOutClassDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("out_class_date not in", values, "outClassDate");
            return (Criteria) this;
        }

        public Criteria andOutClassDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("out_class_date between", value1, value2, "outClassDate");
            return (Criteria) this;
        }

        public Criteria andOutClassDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("out_class_date not between", value1, value2, "outClassDate");
            return (Criteria) this;
        }

        public Criteria andIntoClassIdIsNull() {
            addCriterion("into_class_id is null");
            return (Criteria) this;
        }

        public Criteria andIntoClassIdIsNotNull() {
            addCriterion("into_class_id is not null");
            return (Criteria) this;
        }

        public Criteria andIntoClassIdEqualTo(Integer value) {
            addCriterion("into_class_id =", value, "intoClassId");
            return (Criteria) this;
        }

        public Criteria andIntoClassIdNotEqualTo(Integer value) {
            addCriterion("into_class_id <>", value, "intoClassId");
            return (Criteria) this;
        }

        public Criteria andIntoClassIdGreaterThan(Integer value) {
            addCriterion("into_class_id >", value, "intoClassId");
            return (Criteria) this;
        }

        public Criteria andIntoClassIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("into_class_id >=", value, "intoClassId");
            return (Criteria) this;
        }

        public Criteria andIntoClassIdLessThan(Integer value) {
            addCriterion("into_class_id <", value, "intoClassId");
            return (Criteria) this;
        }

        public Criteria andIntoClassIdLessThanOrEqualTo(Integer value) {
            addCriterion("into_class_id <=", value, "intoClassId");
            return (Criteria) this;
        }

        public Criteria andIntoClassIdIn(List<Integer> values) {
            addCriterion("into_class_id in", values, "intoClassId");
            return (Criteria) this;
        }

        public Criteria andIntoClassIdNotIn(List<Integer> values) {
            addCriterion("into_class_id not in", values, "intoClassId");
            return (Criteria) this;
        }

        public Criteria andIntoClassIdBetween(Integer value1, Integer value2) {
            addCriterion("into_class_id between", value1, value2, "intoClassId");
            return (Criteria) this;
        }

        public Criteria andIntoClassIdNotBetween(Integer value1, Integer value2) {
            addCriterion("into_class_id not between", value1, value2, "intoClassId");
            return (Criteria) this;
        }

        public Criteria andIntoClassDateIsNull() {
            addCriterion("into_class_date is null");
            return (Criteria) this;
        }

        public Criteria andIntoClassDateIsNotNull() {
            addCriterion("into_class_date is not null");
            return (Criteria) this;
        }

        public Criteria andIntoClassDateEqualTo(Date value) {
            addCriterionForJDBCDate("into_class_date =", value, "intoClassDate");
            return (Criteria) this;
        }

        public Criteria andIntoClassDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("into_class_date <>", value, "intoClassDate");
            return (Criteria) this;
        }

        public Criteria andIntoClassDateGreaterThan(Date value) {
            addCriterionForJDBCDate("into_class_date >", value, "intoClassDate");
            return (Criteria) this;
        }

        public Criteria andIntoClassDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("into_class_date >=", value, "intoClassDate");
            return (Criteria) this;
        }

        public Criteria andIntoClassDateLessThan(Date value) {
            addCriterionForJDBCDate("into_class_date <", value, "intoClassDate");
            return (Criteria) this;
        }

        public Criteria andIntoClassDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("into_class_date <=", value, "intoClassDate");
            return (Criteria) this;
        }

        public Criteria andIntoClassDateIn(List<Date> values) {
            addCriterionForJDBCDate("into_class_date in", values, "intoClassDate");
            return (Criteria) this;
        }

        public Criteria andIntoClassDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("into_class_date not in", values, "intoClassDate");
            return (Criteria) this;
        }

        public Criteria andIntoClassDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("into_class_date between", value1, value2, "intoClassDate");
            return (Criteria) this;
        }

        public Criteria andIntoClassDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("into_class_date not between", value1, value2, "intoClassDate");
            return (Criteria) this;
        }

        public Criteria andOperUserIsNull() {
            addCriterion("oper_user is null");
            return (Criteria) this;
        }

        public Criteria andOperUserIsNotNull() {
            addCriterion("oper_user is not null");
            return (Criteria) this;
        }

        public Criteria andOperUserEqualTo(String value) {
            addCriterion("oper_user =", value, "operUser");
            return (Criteria) this;
        }

        public Criteria andOperUserNotEqualTo(String value) {
            addCriterion("oper_user <>", value, "operUser");
            return (Criteria) this;
        }

        public Criteria andOperUserGreaterThan(String value) {
            addCriterion("oper_user >", value, "operUser");
            return (Criteria) this;
        }

        public Criteria andOperUserGreaterThanOrEqualTo(String value) {
            addCriterion("oper_user >=", value, "operUser");
            return (Criteria) this;
        }

        public Criteria andOperUserLessThan(String value) {
            addCriterion("oper_user <", value, "operUser");
            return (Criteria) this;
        }

        public Criteria andOperUserLessThanOrEqualTo(String value) {
            addCriterion("oper_user <=", value, "operUser");
            return (Criteria) this;
        }

        public Criteria andOperUserLike(String value) {
            addCriterion("oper_user like", value, "operUser");
            return (Criteria) this;
        }

        public Criteria andOperUserNotLike(String value) {
            addCriterion("oper_user not like", value, "operUser");
            return (Criteria) this;
        }

        public Criteria andOperUserIn(List<String> values) {
            addCriterion("oper_user in", values, "operUser");
            return (Criteria) this;
        }

        public Criteria andOperUserNotIn(List<String> values) {
            addCriterion("oper_user not in", values, "operUser");
            return (Criteria) this;
        }

        public Criteria andOperUserBetween(String value1, String value2) {
            addCriterion("oper_user between", value1, value2, "operUser");
            return (Criteria) this;
        }

        public Criteria andOperUserNotBetween(String value1, String value2) {
            addCriterion("oper_user not between", value1, value2, "operUser");
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