package com.dkt.school.fin.model;

import java.util.ArrayList;
import java.util.List;

public class ChargeStandardExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ChargeStandardExample() {
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

        public Criteria andGradeIdIsNull() {
            addCriterion("grade_id is null");
            return (Criteria) this;
        }

        public Criteria andGradeIdIsNotNull() {
            addCriterion("grade_id is not null");
            return (Criteria) this;
        }

        public Criteria andGradeIdEqualTo(Integer value) {
            addCriterion("grade_id =", value, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdNotEqualTo(Integer value) {
            addCriterion("grade_id <>", value, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdGreaterThan(Integer value) {
            addCriterion("grade_id >", value, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("grade_id >=", value, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdLessThan(Integer value) {
            addCriterion("grade_id <", value, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdLessThanOrEqualTo(Integer value) {
            addCriterion("grade_id <=", value, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdIn(List<Integer> values) {
            addCriterion("grade_id in", values, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdNotIn(List<Integer> values) {
            addCriterion("grade_id not in", values, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdBetween(Integer value1, Integer value2) {
            addCriterion("grade_id between", value1, value2, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("grade_id not between", value1, value2, "gradeId");
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

        public Criteria andMajorIdIsNull() {
            addCriterion("major_id is null");
            return (Criteria) this;
        }

        public Criteria andMajorIdIsNotNull() {
            addCriterion("major_id is not null");
            return (Criteria) this;
        }

        public Criteria andMajorIdEqualTo(Integer value) {
            addCriterion("major_id =", value, "majorId");
            return (Criteria) this;
        }

        public Criteria andMajorIdNotEqualTo(Integer value) {
            addCriterion("major_id <>", value, "majorId");
            return (Criteria) this;
        }

        public Criteria andMajorIdGreaterThan(Integer value) {
            addCriterion("major_id >", value, "majorId");
            return (Criteria) this;
        }

        public Criteria andMajorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("major_id >=", value, "majorId");
            return (Criteria) this;
        }

        public Criteria andMajorIdLessThan(Integer value) {
            addCriterion("major_id <", value, "majorId");
            return (Criteria) this;
        }

        public Criteria andMajorIdLessThanOrEqualTo(Integer value) {
            addCriterion("major_id <=", value, "majorId");
            return (Criteria) this;
        }

        public Criteria andMajorIdIn(List<Integer> values) {
            addCriterion("major_id in", values, "majorId");
            return (Criteria) this;
        }

        public Criteria andMajorIdNotIn(List<Integer> values) {
            addCriterion("major_id not in", values, "majorId");
            return (Criteria) this;
        }

        public Criteria andMajorIdBetween(Integer value1, Integer value2) {
            addCriterion("major_id between", value1, value2, "majorId");
            return (Criteria) this;
        }

        public Criteria andMajorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("major_id not between", value1, value2, "majorId");
            return (Criteria) this;
        }

        public Criteria andFieldIdIsNull() {
            addCriterion("field_id is null");
            return (Criteria) this;
        }

        public Criteria andFieldIdIsNotNull() {
            addCriterion("field_id is not null");
            return (Criteria) this;
        }

        public Criteria andFieldIdEqualTo(Integer value) {
            addCriterion("field_id =", value, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdNotEqualTo(Integer value) {
            addCriterion("field_id <>", value, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdGreaterThan(Integer value) {
            addCriterion("field_id >", value, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("field_id >=", value, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdLessThan(Integer value) {
            addCriterion("field_id <", value, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdLessThanOrEqualTo(Integer value) {
            addCriterion("field_id <=", value, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdIn(List<Integer> values) {
            addCriterion("field_id in", values, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdNotIn(List<Integer> values) {
            addCriterion("field_id not in", values, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdBetween(Integer value1, Integer value2) {
            addCriterion("field_id between", value1, value2, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdNotBetween(Integer value1, Integer value2) {
            addCriterion("field_id not between", value1, value2, "fieldId");
            return (Criteria) this;
        }

        public Criteria andTuitionFeeIsNull() {
            addCriterion("tuition_fee is null");
            return (Criteria) this;
        }

        public Criteria andTuitionFeeIsNotNull() {
            addCriterion("tuition_fee is not null");
            return (Criteria) this;
        }

        public Criteria andTuitionFeeEqualTo(Float value) {
            addCriterion("tuition_fee =", value, "tuitionFee");
            return (Criteria) this;
        }

        public Criteria andTuitionFeeNotEqualTo(Float value) {
            addCriterion("tuition_fee <>", value, "tuitionFee");
            return (Criteria) this;
        }

        public Criteria andTuitionFeeGreaterThan(Float value) {
            addCriterion("tuition_fee >", value, "tuitionFee");
            return (Criteria) this;
        }

        public Criteria andTuitionFeeGreaterThanOrEqualTo(Float value) {
            addCriterion("tuition_fee >=", value, "tuitionFee");
            return (Criteria) this;
        }

        public Criteria andTuitionFeeLessThan(Float value) {
            addCriterion("tuition_fee <", value, "tuitionFee");
            return (Criteria) this;
        }

        public Criteria andTuitionFeeLessThanOrEqualTo(Float value) {
            addCriterion("tuition_fee <=", value, "tuitionFee");
            return (Criteria) this;
        }

        public Criteria andTuitionFeeIn(List<Float> values) {
            addCriterion("tuition_fee in", values, "tuitionFee");
            return (Criteria) this;
        }

        public Criteria andTuitionFeeNotIn(List<Float> values) {
            addCriterion("tuition_fee not in", values, "tuitionFee");
            return (Criteria) this;
        }

        public Criteria andTuitionFeeBetween(Float value1, Float value2) {
            addCriterion("tuition_fee between", value1, value2, "tuitionFee");
            return (Criteria) this;
        }

        public Criteria andTuitionFeeNotBetween(Float value1, Float value2) {
            addCriterion("tuition_fee not between", value1, value2, "tuitionFee");
            return (Criteria) this;
        }

        public Criteria andRoomFeeGirlIsNull() {
            addCriterion("room_fee_girl is null");
            return (Criteria) this;
        }

        public Criteria andRoomFeeGirlIsNotNull() {
            addCriterion("room_fee_girl is not null");
            return (Criteria) this;
        }

        public Criteria andRoomFeeGirlEqualTo(Float value) {
            addCriterion("room_fee_girl =", value, "roomFeeGirl");
            return (Criteria) this;
        }

        public Criteria andRoomFeeGirlNotEqualTo(Float value) {
            addCriterion("room_fee_girl <>", value, "roomFeeGirl");
            return (Criteria) this;
        }

        public Criteria andRoomFeeGirlGreaterThan(Float value) {
            addCriterion("room_fee_girl >", value, "roomFeeGirl");
            return (Criteria) this;
        }

        public Criteria andRoomFeeGirlGreaterThanOrEqualTo(Float value) {
            addCriterion("room_fee_girl >=", value, "roomFeeGirl");
            return (Criteria) this;
        }

        public Criteria andRoomFeeGirlLessThan(Float value) {
            addCriterion("room_fee_girl <", value, "roomFeeGirl");
            return (Criteria) this;
        }

        public Criteria andRoomFeeGirlLessThanOrEqualTo(Float value) {
            addCriterion("room_fee_girl <=", value, "roomFeeGirl");
            return (Criteria) this;
        }

        public Criteria andRoomFeeGirlIn(List<Float> values) {
            addCriterion("room_fee_girl in", values, "roomFeeGirl");
            return (Criteria) this;
        }

        public Criteria andRoomFeeGirlNotIn(List<Float> values) {
            addCriterion("room_fee_girl not in", values, "roomFeeGirl");
            return (Criteria) this;
        }

        public Criteria andRoomFeeGirlBetween(Float value1, Float value2) {
            addCriterion("room_fee_girl between", value1, value2, "roomFeeGirl");
            return (Criteria) this;
        }

        public Criteria andRoomFeeGirlNotBetween(Float value1, Float value2) {
            addCriterion("room_fee_girl not between", value1, value2, "roomFeeGirl");
            return (Criteria) this;
        }

        public Criteria andRoomFeeBoyIsNull() {
            addCriterion("room_fee_boy is null");
            return (Criteria) this;
        }

        public Criteria andRoomFeeBoyIsNotNull() {
            addCriterion("room_fee_boy is not null");
            return (Criteria) this;
        }

        public Criteria andRoomFeeBoyEqualTo(Float value) {
            addCriterion("room_fee_boy =", value, "roomFeeBoy");
            return (Criteria) this;
        }

        public Criteria andRoomFeeBoyNotEqualTo(Float value) {
            addCriterion("room_fee_boy <>", value, "roomFeeBoy");
            return (Criteria) this;
        }

        public Criteria andRoomFeeBoyGreaterThan(Float value) {
            addCriterion("room_fee_boy >", value, "roomFeeBoy");
            return (Criteria) this;
        }

        public Criteria andRoomFeeBoyGreaterThanOrEqualTo(Float value) {
            addCriterion("room_fee_boy >=", value, "roomFeeBoy");
            return (Criteria) this;
        }

        public Criteria andRoomFeeBoyLessThan(Float value) {
            addCriterion("room_fee_boy <", value, "roomFeeBoy");
            return (Criteria) this;
        }

        public Criteria andRoomFeeBoyLessThanOrEqualTo(Float value) {
            addCriterion("room_fee_boy <=", value, "roomFeeBoy");
            return (Criteria) this;
        }

        public Criteria andRoomFeeBoyIn(List<Float> values) {
            addCriterion("room_fee_boy in", values, "roomFeeBoy");
            return (Criteria) this;
        }

        public Criteria andRoomFeeBoyNotIn(List<Float> values) {
            addCriterion("room_fee_boy not in", values, "roomFeeBoy");
            return (Criteria) this;
        }

        public Criteria andRoomFeeBoyBetween(Float value1, Float value2) {
            addCriterion("room_fee_boy between", value1, value2, "roomFeeBoy");
            return (Criteria) this;
        }

        public Criteria andRoomFeeBoyNotBetween(Float value1, Float value2) {
            addCriterion("room_fee_boy not between", value1, value2, "roomFeeBoy");
            return (Criteria) this;
        }

        public Criteria andBookFeeIsNull() {
            addCriterion("book_fee is null");
            return (Criteria) this;
        }

        public Criteria andBookFeeIsNotNull() {
            addCriterion("book_fee is not null");
            return (Criteria) this;
        }

        public Criteria andBookFeeEqualTo(Float value) {
            addCriterion("book_fee =", value, "bookFee");
            return (Criteria) this;
        }

        public Criteria andBookFeeNotEqualTo(Float value) {
            addCriterion("book_fee <>", value, "bookFee");
            return (Criteria) this;
        }

        public Criteria andBookFeeGreaterThan(Float value) {
            addCriterion("book_fee >", value, "bookFee");
            return (Criteria) this;
        }

        public Criteria andBookFeeGreaterThanOrEqualTo(Float value) {
            addCriterion("book_fee >=", value, "bookFee");
            return (Criteria) this;
        }

        public Criteria andBookFeeLessThan(Float value) {
            addCriterion("book_fee <", value, "bookFee");
            return (Criteria) this;
        }

        public Criteria andBookFeeLessThanOrEqualTo(Float value) {
            addCriterion("book_fee <=", value, "bookFee");
            return (Criteria) this;
        }

        public Criteria andBookFeeIn(List<Float> values) {
            addCriterion("book_fee in", values, "bookFee");
            return (Criteria) this;
        }

        public Criteria andBookFeeNotIn(List<Float> values) {
            addCriterion("book_fee not in", values, "bookFee");
            return (Criteria) this;
        }

        public Criteria andBookFeeBetween(Float value1, Float value2) {
            addCriterion("book_fee between", value1, value2, "bookFee");
            return (Criteria) this;
        }

        public Criteria andBookFeeNotBetween(Float value1, Float value2) {
            addCriterion("book_fee not between", value1, value2, "bookFee");
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