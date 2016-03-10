package com.dkt.school.edu.model;

import java.util.ArrayList;
import java.util.List;

public class TeachTaskExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TeachTaskExample() {
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

        public Criteria andStudyYearIdIsNull() {
            addCriterion("study_year_id is null");
            return (Criteria) this;
        }

        public Criteria andStudyYearIdIsNotNull() {
            addCriterion("study_year_id is not null");
            return (Criteria) this;
        }

        public Criteria andStudyYearIdEqualTo(Integer value) {
            addCriterion("study_year_id =", value, "studyYearId");
            return (Criteria) this;
        }

        public Criteria andStudyYearIdNotEqualTo(Integer value) {
            addCriterion("study_year_id <>", value, "studyYearId");
            return (Criteria) this;
        }

        public Criteria andStudyYearIdGreaterThan(Integer value) {
            addCriterion("study_year_id >", value, "studyYearId");
            return (Criteria) this;
        }

        public Criteria andStudyYearIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("study_year_id >=", value, "studyYearId");
            return (Criteria) this;
        }

        public Criteria andStudyYearIdLessThan(Integer value) {
            addCriterion("study_year_id <", value, "studyYearId");
            return (Criteria) this;
        }

        public Criteria andStudyYearIdLessThanOrEqualTo(Integer value) {
            addCriterion("study_year_id <=", value, "studyYearId");
            return (Criteria) this;
        }

        public Criteria andStudyYearIdIn(List<Integer> values) {
            addCriterion("study_year_id in", values, "studyYearId");
            return (Criteria) this;
        }

        public Criteria andStudyYearIdNotIn(List<Integer> values) {
            addCriterion("study_year_id not in", values, "studyYearId");
            return (Criteria) this;
        }

        public Criteria andStudyYearIdBetween(Integer value1, Integer value2) {
            addCriterion("study_year_id between", value1, value2, "studyYearId");
            return (Criteria) this;
        }

        public Criteria andStudyYearIdNotBetween(Integer value1, Integer value2) {
            addCriterion("study_year_id not between", value1, value2, "studyYearId");
            return (Criteria) this;
        }

        public Criteria andTermTypeIsNull() {
            addCriterion("term_type is null");
            return (Criteria) this;
        }

        public Criteria andTermTypeIsNotNull() {
            addCriterion("term_type is not null");
            return (Criteria) this;
        }

        public Criteria andTermTypeEqualTo(Integer value) {
            addCriterion("term_type =", value, "termType");
            return (Criteria) this;
        }

        public Criteria andTermTypeNotEqualTo(Integer value) {
            addCriterion("term_type <>", value, "termType");
            return (Criteria) this;
        }

        public Criteria andTermTypeGreaterThan(Integer value) {
            addCriterion("term_type >", value, "termType");
            return (Criteria) this;
        }

        public Criteria andTermTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("term_type >=", value, "termType");
            return (Criteria) this;
        }

        public Criteria andTermTypeLessThan(Integer value) {
            addCriterion("term_type <", value, "termType");
            return (Criteria) this;
        }

        public Criteria andTermTypeLessThanOrEqualTo(Integer value) {
            addCriterion("term_type <=", value, "termType");
            return (Criteria) this;
        }

        public Criteria andTermTypeIn(List<Integer> values) {
            addCriterion("term_type in", values, "termType");
            return (Criteria) this;
        }

        public Criteria andTermTypeNotIn(List<Integer> values) {
            addCriterion("term_type not in", values, "termType");
            return (Criteria) this;
        }

        public Criteria andTermTypeBetween(Integer value1, Integer value2) {
            addCriterion("term_type between", value1, value2, "termType");
            return (Criteria) this;
        }

        public Criteria andTermTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("term_type not between", value1, value2, "termType");
            return (Criteria) this;
        }

        public Criteria andCoursePlanIdIsNull() {
            addCriterion("course_plan_id is null");
            return (Criteria) this;
        }

        public Criteria andCoursePlanIdIsNotNull() {
            addCriterion("course_plan_id is not null");
            return (Criteria) this;
        }

        public Criteria andCoursePlanIdEqualTo(Integer value) {
            addCriterion("course_plan_id =", value, "coursePlanId");
            return (Criteria) this;
        }

        public Criteria andCoursePlanIdNotEqualTo(Integer value) {
            addCriterion("course_plan_id <>", value, "coursePlanId");
            return (Criteria) this;
        }

        public Criteria andCoursePlanIdGreaterThan(Integer value) {
            addCriterion("course_plan_id >", value, "coursePlanId");
            return (Criteria) this;
        }

        public Criteria andCoursePlanIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("course_plan_id >=", value, "coursePlanId");
            return (Criteria) this;
        }

        public Criteria andCoursePlanIdLessThan(Integer value) {
            addCriterion("course_plan_id <", value, "coursePlanId");
            return (Criteria) this;
        }

        public Criteria andCoursePlanIdLessThanOrEqualTo(Integer value) {
            addCriterion("course_plan_id <=", value, "coursePlanId");
            return (Criteria) this;
        }

        public Criteria andCoursePlanIdIn(List<Integer> values) {
            addCriterion("course_plan_id in", values, "coursePlanId");
            return (Criteria) this;
        }

        public Criteria andCoursePlanIdNotIn(List<Integer> values) {
            addCriterion("course_plan_id not in", values, "coursePlanId");
            return (Criteria) this;
        }

        public Criteria andCoursePlanIdBetween(Integer value1, Integer value2) {
            addCriterion("course_plan_id between", value1, value2, "coursePlanId");
            return (Criteria) this;
        }

        public Criteria andCoursePlanIdNotBetween(Integer value1, Integer value2) {
            addCriterion("course_plan_id not between", value1, value2, "coursePlanId");
            return (Criteria) this;
        }

        public Criteria andCourseIdIsNull() {
            addCriterion("course_id is null");
            return (Criteria) this;
        }

        public Criteria andCourseIdIsNotNull() {
            addCriterion("course_id is not null");
            return (Criteria) this;
        }

        public Criteria andCourseIdEqualTo(Integer value) {
            addCriterion("course_id =", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotEqualTo(Integer value) {
            addCriterion("course_id <>", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThan(Integer value) {
            addCriterion("course_id >", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("course_id >=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThan(Integer value) {
            addCriterion("course_id <", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThanOrEqualTo(Integer value) {
            addCriterion("course_id <=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdIn(List<Integer> values) {
            addCriterion("course_id in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotIn(List<Integer> values) {
            addCriterion("course_id not in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdBetween(Integer value1, Integer value2) {
            addCriterion("course_id between", value1, value2, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("course_id not between", value1, value2, "courseId");
            return (Criteria) this;
        }

        public Criteria andClassIdIsNull() {
            addCriterion("class_id is null");
            return (Criteria) this;
        }

        public Criteria andClassIdIsNotNull() {
            addCriterion("class_id is not null");
            return (Criteria) this;
        }

        public Criteria andClassIdEqualTo(Integer value) {
            addCriterion("class_id =", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotEqualTo(Integer value) {
            addCriterion("class_id <>", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdGreaterThan(Integer value) {
            addCriterion("class_id >", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("class_id >=", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdLessThan(Integer value) {
            addCriterion("class_id <", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdLessThanOrEqualTo(Integer value) {
            addCriterion("class_id <=", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdIn(List<Integer> values) {
            addCriterion("class_id in", values, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotIn(List<Integer> values) {
            addCriterion("class_id not in", values, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdBetween(Integer value1, Integer value2) {
            addCriterion("class_id between", value1, value2, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotBetween(Integer value1, Integer value2) {
            addCriterion("class_id not between", value1, value2, "classId");
            return (Criteria) this;
        }

        public Criteria andCourseSeqIsNull() {
            addCriterion("course_seq is null");
            return (Criteria) this;
        }

        public Criteria andCourseSeqIsNotNull() {
            addCriterion("course_seq is not null");
            return (Criteria) this;
        }

        public Criteria andCourseSeqEqualTo(Integer value) {
            addCriterion("course_seq =", value, "courseSeq");
            return (Criteria) this;
        }

        public Criteria andCourseSeqNotEqualTo(Integer value) {
            addCriterion("course_seq <>", value, "courseSeq");
            return (Criteria) this;
        }

        public Criteria andCourseSeqGreaterThan(Integer value) {
            addCriterion("course_seq >", value, "courseSeq");
            return (Criteria) this;
        }

        public Criteria andCourseSeqGreaterThanOrEqualTo(Integer value) {
            addCriterion("course_seq >=", value, "courseSeq");
            return (Criteria) this;
        }

        public Criteria andCourseSeqLessThan(Integer value) {
            addCriterion("course_seq <", value, "courseSeq");
            return (Criteria) this;
        }

        public Criteria andCourseSeqLessThanOrEqualTo(Integer value) {
            addCriterion("course_seq <=", value, "courseSeq");
            return (Criteria) this;
        }

        public Criteria andCourseSeqIn(List<Integer> values) {
            addCriterion("course_seq in", values, "courseSeq");
            return (Criteria) this;
        }

        public Criteria andCourseSeqNotIn(List<Integer> values) {
            addCriterion("course_seq not in", values, "courseSeq");
            return (Criteria) this;
        }

        public Criteria andCourseSeqBetween(Integer value1, Integer value2) {
            addCriterion("course_seq between", value1, value2, "courseSeq");
            return (Criteria) this;
        }

        public Criteria andCourseSeqNotBetween(Integer value1, Integer value2) {
            addCriterion("course_seq not between", value1, value2, "courseSeq");
            return (Criteria) this;
        }

        public Criteria andTeachCourseIdIsNull() {
            addCriterion("teach_course_id is null");
            return (Criteria) this;
        }

        public Criteria andTeachCourseIdIsNotNull() {
            addCriterion("teach_course_id is not null");
            return (Criteria) this;
        }

        public Criteria andTeachCourseIdEqualTo(Integer value) {
            addCriterion("teach_course_id =", value, "teachCourseId");
            return (Criteria) this;
        }

        public Criteria andTeachCourseIdNotEqualTo(Integer value) {
            addCriterion("teach_course_id <>", value, "teachCourseId");
            return (Criteria) this;
        }

        public Criteria andTeachCourseIdGreaterThan(Integer value) {
            addCriterion("teach_course_id >", value, "teachCourseId");
            return (Criteria) this;
        }

        public Criteria andTeachCourseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("teach_course_id >=", value, "teachCourseId");
            return (Criteria) this;
        }

        public Criteria andTeachCourseIdLessThan(Integer value) {
            addCriterion("teach_course_id <", value, "teachCourseId");
            return (Criteria) this;
        }

        public Criteria andTeachCourseIdLessThanOrEqualTo(Integer value) {
            addCriterion("teach_course_id <=", value, "teachCourseId");
            return (Criteria) this;
        }

        public Criteria andTeachCourseIdIn(List<Integer> values) {
            addCriterion("teach_course_id in", values, "teachCourseId");
            return (Criteria) this;
        }

        public Criteria andTeachCourseIdNotIn(List<Integer> values) {
            addCriterion("teach_course_id not in", values, "teachCourseId");
            return (Criteria) this;
        }

        public Criteria andTeachCourseIdBetween(Integer value1, Integer value2) {
            addCriterion("teach_course_id between", value1, value2, "teachCourseId");
            return (Criteria) this;
        }

        public Criteria andTeachCourseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("teach_course_id not between", value1, value2, "teachCourseId");
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