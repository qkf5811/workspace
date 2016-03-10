package com.dkt.school.stu.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class StudentInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StudentInfoExample() {
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

        public Criteria andStudentNumberIsNull() {
            addCriterion("student_number is null");
            return (Criteria) this;
        }

        public Criteria andStudentNumberIsNotNull() {
            addCriterion("student_number is not null");
            return (Criteria) this;
        }

        public Criteria andStudentNumberEqualTo(String value) {
            addCriterion("student_number =", value, "studentNumber");
            return (Criteria) this;
        }

        public Criteria andStudentNumberNotEqualTo(String value) {
            addCriterion("student_number <>", value, "studentNumber");
            return (Criteria) this;
        }

        public Criteria andStudentNumberGreaterThan(String value) {
            addCriterion("student_number >", value, "studentNumber");
            return (Criteria) this;
        }

        public Criteria andStudentNumberGreaterThanOrEqualTo(String value) {
            addCriterion("student_number >=", value, "studentNumber");
            return (Criteria) this;
        }

        public Criteria andStudentNumberLessThan(String value) {
            addCriterion("student_number <", value, "studentNumber");
            return (Criteria) this;
        }

        public Criteria andStudentNumberLessThanOrEqualTo(String value) {
            addCriterion("student_number <=", value, "studentNumber");
            return (Criteria) this;
        }

        public Criteria andStudentNumberLike(String value) {
            addCriterion("student_number like", value, "studentNumber");
            return (Criteria) this;
        }

        public Criteria andStudentNumberNotLike(String value) {
            addCriterion("student_number not like", value, "studentNumber");
            return (Criteria) this;
        }

        public Criteria andStudentNumberIn(List<String> values) {
            addCriterion("student_number in", values, "studentNumber");
            return (Criteria) this;
        }

        public Criteria andStudentNumberNotIn(List<String> values) {
            addCriterion("student_number not in", values, "studentNumber");
            return (Criteria) this;
        }

        public Criteria andStudentNumberBetween(String value1, String value2) {
            addCriterion("student_number between", value1, value2, "studentNumber");
            return (Criteria) this;
        }

        public Criteria andStudentNumberNotBetween(String value1, String value2) {
            addCriterion("student_number not between", value1, value2, "studentNumber");
            return (Criteria) this;
        }

        public Criteria andSexTypeIsNull() {
            addCriterion("sex_type is null");
            return (Criteria) this;
        }

        public Criteria andSexTypeIsNotNull() {
            addCriterion("sex_type is not null");
            return (Criteria) this;
        }

        public Criteria andSexTypeEqualTo(Integer value) {
            addCriterion("sex_type =", value, "sexType");
            return (Criteria) this;
        }

        public Criteria andSexTypeNotEqualTo(Integer value) {
            addCriterion("sex_type <>", value, "sexType");
            return (Criteria) this;
        }

        public Criteria andSexTypeGreaterThan(Integer value) {
            addCriterion("sex_type >", value, "sexType");
            return (Criteria) this;
        }

        public Criteria andSexTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("sex_type >=", value, "sexType");
            return (Criteria) this;
        }

        public Criteria andSexTypeLessThan(Integer value) {
            addCriterion("sex_type <", value, "sexType");
            return (Criteria) this;
        }

        public Criteria andSexTypeLessThanOrEqualTo(Integer value) {
            addCriterion("sex_type <=", value, "sexType");
            return (Criteria) this;
        }

        public Criteria andSexTypeIn(List<Integer> values) {
            addCriterion("sex_type in", values, "sexType");
            return (Criteria) this;
        }

        public Criteria andSexTypeNotIn(List<Integer> values) {
            addCriterion("sex_type not in", values, "sexType");
            return (Criteria) this;
        }

        public Criteria andSexTypeBetween(Integer value1, Integer value2) {
            addCriterion("sex_type between", value1, value2, "sexType");
            return (Criteria) this;
        }

        public Criteria andSexTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("sex_type not between", value1, value2, "sexType");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(Date value) {
            addCriterionForJDBCDate("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(Date value) {
            addCriterionForJDBCDate("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(Date value) {
            addCriterionForJDBCDate("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(Date value) {
            addCriterionForJDBCDate("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<Date> values) {
            addCriterionForJDBCDate("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<Date> values) {
            addCriterionForJDBCDate("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birthday not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andIdCardIsNull() {
            addCriterion("id_card is null");
            return (Criteria) this;
        }

        public Criteria andIdCardIsNotNull() {
            addCriterion("id_card is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardEqualTo(String value) {
            addCriterion("id_card =", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotEqualTo(String value) {
            addCriterion("id_card <>", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardGreaterThan(String value) {
            addCriterion("id_card >", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardGreaterThanOrEqualTo(String value) {
            addCriterion("id_card >=", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLessThan(String value) {
            addCriterion("id_card <", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLessThanOrEqualTo(String value) {
            addCriterion("id_card <=", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLike(String value) {
            addCriterion("id_card like", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotLike(String value) {
            addCriterion("id_card not like", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardIn(List<String> values) {
            addCriterion("id_card in", values, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotIn(List<String> values) {
            addCriterion("id_card not in", values, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardBetween(String value1, String value2) {
            addCriterion("id_card between", value1, value2, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotBetween(String value1, String value2) {
            addCriterion("id_card not between", value1, value2, "idCard");
            return (Criteria) this;
        }

        public Criteria andNationTypeIsNull() {
            addCriterion("nation_type is null");
            return (Criteria) this;
        }

        public Criteria andNationTypeIsNotNull() {
            addCriterion("nation_type is not null");
            return (Criteria) this;
        }

        public Criteria andNationTypeEqualTo(Integer value) {
            addCriterion("nation_type =", value, "nationType");
            return (Criteria) this;
        }

        public Criteria andNationTypeNotEqualTo(Integer value) {
            addCriterion("nation_type <>", value, "nationType");
            return (Criteria) this;
        }

        public Criteria andNationTypeGreaterThan(Integer value) {
            addCriterion("nation_type >", value, "nationType");
            return (Criteria) this;
        }

        public Criteria andNationTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("nation_type >=", value, "nationType");
            return (Criteria) this;
        }

        public Criteria andNationTypeLessThan(Integer value) {
            addCriterion("nation_type <", value, "nationType");
            return (Criteria) this;
        }

        public Criteria andNationTypeLessThanOrEqualTo(Integer value) {
            addCriterion("nation_type <=", value, "nationType");
            return (Criteria) this;
        }

        public Criteria andNationTypeIn(List<Integer> values) {
            addCriterion("nation_type in", values, "nationType");
            return (Criteria) this;
        }

        public Criteria andNationTypeNotIn(List<Integer> values) {
            addCriterion("nation_type not in", values, "nationType");
            return (Criteria) this;
        }

        public Criteria andNationTypeBetween(Integer value1, Integer value2) {
            addCriterion("nation_type between", value1, value2, "nationType");
            return (Criteria) this;
        }

        public Criteria andNationTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("nation_type not between", value1, value2, "nationType");
            return (Criteria) this;
        }

        public Criteria andPoliticalFeatureTypeIsNull() {
            addCriterion("political_feature_type is null");
            return (Criteria) this;
        }

        public Criteria andPoliticalFeatureTypeIsNotNull() {
            addCriterion("political_feature_type is not null");
            return (Criteria) this;
        }

        public Criteria andPoliticalFeatureTypeEqualTo(Integer value) {
            addCriterion("political_feature_type =", value, "politicalFeatureType");
            return (Criteria) this;
        }

        public Criteria andPoliticalFeatureTypeNotEqualTo(Integer value) {
            addCriterion("political_feature_type <>", value, "politicalFeatureType");
            return (Criteria) this;
        }

        public Criteria andPoliticalFeatureTypeGreaterThan(Integer value) {
            addCriterion("political_feature_type >", value, "politicalFeatureType");
            return (Criteria) this;
        }

        public Criteria andPoliticalFeatureTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("political_feature_type >=", value, "politicalFeatureType");
            return (Criteria) this;
        }

        public Criteria andPoliticalFeatureTypeLessThan(Integer value) {
            addCriterion("political_feature_type <", value, "politicalFeatureType");
            return (Criteria) this;
        }

        public Criteria andPoliticalFeatureTypeLessThanOrEqualTo(Integer value) {
            addCriterion("political_feature_type <=", value, "politicalFeatureType");
            return (Criteria) this;
        }

        public Criteria andPoliticalFeatureTypeIn(List<Integer> values) {
            addCriterion("political_feature_type in", values, "politicalFeatureType");
            return (Criteria) this;
        }

        public Criteria andPoliticalFeatureTypeNotIn(List<Integer> values) {
            addCriterion("political_feature_type not in", values, "politicalFeatureType");
            return (Criteria) this;
        }

        public Criteria andPoliticalFeatureTypeBetween(Integer value1, Integer value2) {
            addCriterion("political_feature_type between", value1, value2, "politicalFeatureType");
            return (Criteria) this;
        }

        public Criteria andPoliticalFeatureTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("political_feature_type not between", value1, value2, "politicalFeatureType");
            return (Criteria) this;
        }

        public Criteria andHealthTypeIsNull() {
            addCriterion("health_type is null");
            return (Criteria) this;
        }

        public Criteria andHealthTypeIsNotNull() {
            addCriterion("health_type is not null");
            return (Criteria) this;
        }

        public Criteria andHealthTypeEqualTo(Integer value) {
            addCriterion("health_type =", value, "healthType");
            return (Criteria) this;
        }

        public Criteria andHealthTypeNotEqualTo(Integer value) {
            addCriterion("health_type <>", value, "healthType");
            return (Criteria) this;
        }

        public Criteria andHealthTypeGreaterThan(Integer value) {
            addCriterion("health_type >", value, "healthType");
            return (Criteria) this;
        }

        public Criteria andHealthTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("health_type >=", value, "healthType");
            return (Criteria) this;
        }

        public Criteria andHealthTypeLessThan(Integer value) {
            addCriterion("health_type <", value, "healthType");
            return (Criteria) this;
        }

        public Criteria andHealthTypeLessThanOrEqualTo(Integer value) {
            addCriterion("health_type <=", value, "healthType");
            return (Criteria) this;
        }

        public Criteria andHealthTypeIn(List<Integer> values) {
            addCriterion("health_type in", values, "healthType");
            return (Criteria) this;
        }

        public Criteria andHealthTypeNotIn(List<Integer> values) {
            addCriterion("health_type not in", values, "healthType");
            return (Criteria) this;
        }

        public Criteria andHealthTypeBetween(Integer value1, Integer value2) {
            addCriterion("health_type between", value1, value2, "healthType");
            return (Criteria) this;
        }

        public Criteria andHealthTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("health_type not between", value1, value2, "healthType");
            return (Criteria) this;
        }

        public Criteria andIsHkMcIsNull() {
            addCriterion("is_hk_mc is null");
            return (Criteria) this;
        }

        public Criteria andIsHkMcIsNotNull() {
            addCriterion("is_hk_mc is not null");
            return (Criteria) this;
        }

        public Criteria andIsHkMcEqualTo(Integer value) {
            addCriterion("is_hk_mc =", value, "isHkMc");
            return (Criteria) this;
        }

        public Criteria andIsHkMcNotEqualTo(Integer value) {
            addCriterion("is_hk_mc <>", value, "isHkMc");
            return (Criteria) this;
        }

        public Criteria andIsHkMcGreaterThan(Integer value) {
            addCriterion("is_hk_mc >", value, "isHkMc");
            return (Criteria) this;
        }

        public Criteria andIsHkMcGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_hk_mc >=", value, "isHkMc");
            return (Criteria) this;
        }

        public Criteria andIsHkMcLessThan(Integer value) {
            addCriterion("is_hk_mc <", value, "isHkMc");
            return (Criteria) this;
        }

        public Criteria andIsHkMcLessThanOrEqualTo(Integer value) {
            addCriterion("is_hk_mc <=", value, "isHkMc");
            return (Criteria) this;
        }

        public Criteria andIsHkMcIn(List<Integer> values) {
            addCriterion("is_hk_mc in", values, "isHkMc");
            return (Criteria) this;
        }

        public Criteria andIsHkMcNotIn(List<Integer> values) {
            addCriterion("is_hk_mc not in", values, "isHkMc");
            return (Criteria) this;
        }

        public Criteria andIsHkMcBetween(Integer value1, Integer value2) {
            addCriterion("is_hk_mc between", value1, value2, "isHkMc");
            return (Criteria) this;
        }

        public Criteria andIsHkMcNotBetween(Integer value1, Integer value2) {
            addCriterion("is_hk_mc not between", value1, value2, "isHkMc");
            return (Criteria) this;
        }

        public Criteria andNativePlaceIsNull() {
            addCriterion("native_place is null");
            return (Criteria) this;
        }

        public Criteria andNativePlaceIsNotNull() {
            addCriterion("native_place is not null");
            return (Criteria) this;
        }

        public Criteria andNativePlaceEqualTo(String value) {
            addCriterion("native_place =", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceNotEqualTo(String value) {
            addCriterion("native_place <>", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceGreaterThan(String value) {
            addCriterion("native_place >", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceGreaterThanOrEqualTo(String value) {
            addCriterion("native_place >=", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceLessThan(String value) {
            addCriterion("native_place <", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceLessThanOrEqualTo(String value) {
            addCriterion("native_place <=", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceLike(String value) {
            addCriterion("native_place like", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceNotLike(String value) {
            addCriterion("native_place not like", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceIn(List<String> values) {
            addCriterion("native_place in", values, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceNotIn(List<String> values) {
            addCriterion("native_place not in", values, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceBetween(String value1, String value2) {
            addCriterion("native_place between", value1, value2, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceNotBetween(String value1, String value2) {
            addCriterion("native_place not between", value1, value2, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andHouseholdTypeIsNull() {
            addCriterion("household_type is null");
            return (Criteria) this;
        }

        public Criteria andHouseholdTypeIsNotNull() {
            addCriterion("household_type is not null");
            return (Criteria) this;
        }

        public Criteria andHouseholdTypeEqualTo(Integer value) {
            addCriterion("household_type =", value, "householdType");
            return (Criteria) this;
        }

        public Criteria andHouseholdTypeNotEqualTo(Integer value) {
            addCriterion("household_type <>", value, "householdType");
            return (Criteria) this;
        }

        public Criteria andHouseholdTypeGreaterThan(Integer value) {
            addCriterion("household_type >", value, "householdType");
            return (Criteria) this;
        }

        public Criteria andHouseholdTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("household_type >=", value, "householdType");
            return (Criteria) this;
        }

        public Criteria andHouseholdTypeLessThan(Integer value) {
            addCriterion("household_type <", value, "householdType");
            return (Criteria) this;
        }

        public Criteria andHouseholdTypeLessThanOrEqualTo(Integer value) {
            addCriterion("household_type <=", value, "householdType");
            return (Criteria) this;
        }

        public Criteria andHouseholdTypeIn(List<Integer> values) {
            addCriterion("household_type in", values, "householdType");
            return (Criteria) this;
        }

        public Criteria andHouseholdTypeNotIn(List<Integer> values) {
            addCriterion("household_type not in", values, "householdType");
            return (Criteria) this;
        }

        public Criteria andHouseholdTypeBetween(Integer value1, Integer value2) {
            addCriterion("household_type between", value1, value2, "householdType");
            return (Criteria) this;
        }

        public Criteria andHouseholdTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("household_type not between", value1, value2, "householdType");
            return (Criteria) this;
        }

        public Criteria andHouseholdLocationIsNull() {
            addCriterion("household_location is null");
            return (Criteria) this;
        }

        public Criteria andHouseholdLocationIsNotNull() {
            addCriterion("household_location is not null");
            return (Criteria) this;
        }

        public Criteria andHouseholdLocationEqualTo(String value) {
            addCriterion("household_location =", value, "householdLocation");
            return (Criteria) this;
        }

        public Criteria andHouseholdLocationNotEqualTo(String value) {
            addCriterion("household_location <>", value, "householdLocation");
            return (Criteria) this;
        }

        public Criteria andHouseholdLocationGreaterThan(String value) {
            addCriterion("household_location >", value, "householdLocation");
            return (Criteria) this;
        }

        public Criteria andHouseholdLocationGreaterThanOrEqualTo(String value) {
            addCriterion("household_location >=", value, "householdLocation");
            return (Criteria) this;
        }

        public Criteria andHouseholdLocationLessThan(String value) {
            addCriterion("household_location <", value, "householdLocation");
            return (Criteria) this;
        }

        public Criteria andHouseholdLocationLessThanOrEqualTo(String value) {
            addCriterion("household_location <=", value, "householdLocation");
            return (Criteria) this;
        }

        public Criteria andHouseholdLocationLike(String value) {
            addCriterion("household_location like", value, "householdLocation");
            return (Criteria) this;
        }

        public Criteria andHouseholdLocationNotLike(String value) {
            addCriterion("household_location not like", value, "householdLocation");
            return (Criteria) this;
        }

        public Criteria andHouseholdLocationIn(List<String> values) {
            addCriterion("household_location in", values, "householdLocation");
            return (Criteria) this;
        }

        public Criteria andHouseholdLocationNotIn(List<String> values) {
            addCriterion("household_location not in", values, "householdLocation");
            return (Criteria) this;
        }

        public Criteria andHouseholdLocationBetween(String value1, String value2) {
            addCriterion("household_location between", value1, value2, "householdLocation");
            return (Criteria) this;
        }

        public Criteria andHouseholdLocationNotBetween(String value1, String value2) {
            addCriterion("household_location not between", value1, value2, "householdLocation");
            return (Criteria) this;
        }

        public Criteria andFamilyAddressIsNull() {
            addCriterion("family_address is null");
            return (Criteria) this;
        }

        public Criteria andFamilyAddressIsNotNull() {
            addCriterion("family_address is not null");
            return (Criteria) this;
        }

        public Criteria andFamilyAddressEqualTo(String value) {
            addCriterion("family_address =", value, "familyAddress");
            return (Criteria) this;
        }

        public Criteria andFamilyAddressNotEqualTo(String value) {
            addCriterion("family_address <>", value, "familyAddress");
            return (Criteria) this;
        }

        public Criteria andFamilyAddressGreaterThan(String value) {
            addCriterion("family_address >", value, "familyAddress");
            return (Criteria) this;
        }

        public Criteria andFamilyAddressGreaterThanOrEqualTo(String value) {
            addCriterion("family_address >=", value, "familyAddress");
            return (Criteria) this;
        }

        public Criteria andFamilyAddressLessThan(String value) {
            addCriterion("family_address <", value, "familyAddress");
            return (Criteria) this;
        }

        public Criteria andFamilyAddressLessThanOrEqualTo(String value) {
            addCriterion("family_address <=", value, "familyAddress");
            return (Criteria) this;
        }

        public Criteria andFamilyAddressLike(String value) {
            addCriterion("family_address like", value, "familyAddress");
            return (Criteria) this;
        }

        public Criteria andFamilyAddressNotLike(String value) {
            addCriterion("family_address not like", value, "familyAddress");
            return (Criteria) this;
        }

        public Criteria andFamilyAddressIn(List<String> values) {
            addCriterion("family_address in", values, "familyAddress");
            return (Criteria) this;
        }

        public Criteria andFamilyAddressNotIn(List<String> values) {
            addCriterion("family_address not in", values, "familyAddress");
            return (Criteria) this;
        }

        public Criteria andFamilyAddressBetween(String value1, String value2) {
            addCriterion("family_address between", value1, value2, "familyAddress");
            return (Criteria) this;
        }

        public Criteria andFamilyAddressNotBetween(String value1, String value2) {
            addCriterion("family_address not between", value1, value2, "familyAddress");
            return (Criteria) this;
        }

        public Criteria andPostcodeIsNull() {
            addCriterion("postcode is null");
            return (Criteria) this;
        }

        public Criteria andPostcodeIsNotNull() {
            addCriterion("postcode is not null");
            return (Criteria) this;
        }

        public Criteria andPostcodeEqualTo(String value) {
            addCriterion("postcode =", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotEqualTo(String value) {
            addCriterion("postcode <>", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeGreaterThan(String value) {
            addCriterion("postcode >", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeGreaterThanOrEqualTo(String value) {
            addCriterion("postcode >=", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLessThan(String value) {
            addCriterion("postcode <", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLessThanOrEqualTo(String value) {
            addCriterion("postcode <=", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLike(String value) {
            addCriterion("postcode like", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotLike(String value) {
            addCriterion("postcode not like", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeIn(List<String> values) {
            addCriterion("postcode in", values, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotIn(List<String> values) {
            addCriterion("postcode not in", values, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeBetween(String value1, String value2) {
            addCriterion("postcode between", value1, value2, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotBetween(String value1, String value2) {
            addCriterion("postcode not between", value1, value2, "postcode");
            return (Criteria) this;
        }

        public Criteria andFamilyPhoneIsNull() {
            addCriterion("family_phone is null");
            return (Criteria) this;
        }

        public Criteria andFamilyPhoneIsNotNull() {
            addCriterion("family_phone is not null");
            return (Criteria) this;
        }

        public Criteria andFamilyPhoneEqualTo(String value) {
            addCriterion("family_phone =", value, "familyPhone");
            return (Criteria) this;
        }

        public Criteria andFamilyPhoneNotEqualTo(String value) {
            addCriterion("family_phone <>", value, "familyPhone");
            return (Criteria) this;
        }

        public Criteria andFamilyPhoneGreaterThan(String value) {
            addCriterion("family_phone >", value, "familyPhone");
            return (Criteria) this;
        }

        public Criteria andFamilyPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("family_phone >=", value, "familyPhone");
            return (Criteria) this;
        }

        public Criteria andFamilyPhoneLessThan(String value) {
            addCriterion("family_phone <", value, "familyPhone");
            return (Criteria) this;
        }

        public Criteria andFamilyPhoneLessThanOrEqualTo(String value) {
            addCriterion("family_phone <=", value, "familyPhone");
            return (Criteria) this;
        }

        public Criteria andFamilyPhoneLike(String value) {
            addCriterion("family_phone like", value, "familyPhone");
            return (Criteria) this;
        }

        public Criteria andFamilyPhoneNotLike(String value) {
            addCriterion("family_phone not like", value, "familyPhone");
            return (Criteria) this;
        }

        public Criteria andFamilyPhoneIn(List<String> values) {
            addCriterion("family_phone in", values, "familyPhone");
            return (Criteria) this;
        }

        public Criteria andFamilyPhoneNotIn(List<String> values) {
            addCriterion("family_phone not in", values, "familyPhone");
            return (Criteria) this;
        }

        public Criteria andFamilyPhoneBetween(String value1, String value2) {
            addCriterion("family_phone between", value1, value2, "familyPhone");
            return (Criteria) this;
        }

        public Criteria andFamilyPhoneNotBetween(String value1, String value2) {
            addCriterion("family_phone not between", value1, value2, "familyPhone");
            return (Criteria) this;
        }

        public Criteria andExamineeTypeIsNull() {
            addCriterion("examinee_type is null");
            return (Criteria) this;
        }

        public Criteria andExamineeTypeIsNotNull() {
            addCriterion("examinee_type is not null");
            return (Criteria) this;
        }

        public Criteria andExamineeTypeEqualTo(Integer value) {
            addCriterion("examinee_type =", value, "examineeType");
            return (Criteria) this;
        }

        public Criteria andExamineeTypeNotEqualTo(Integer value) {
            addCriterion("examinee_type <>", value, "examineeType");
            return (Criteria) this;
        }

        public Criteria andExamineeTypeGreaterThan(Integer value) {
            addCriterion("examinee_type >", value, "examineeType");
            return (Criteria) this;
        }

        public Criteria andExamineeTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("examinee_type >=", value, "examineeType");
            return (Criteria) this;
        }

        public Criteria andExamineeTypeLessThan(Integer value) {
            addCriterion("examinee_type <", value, "examineeType");
            return (Criteria) this;
        }

        public Criteria andExamineeTypeLessThanOrEqualTo(Integer value) {
            addCriterion("examinee_type <=", value, "examineeType");
            return (Criteria) this;
        }

        public Criteria andExamineeTypeIn(List<Integer> values) {
            addCriterion("examinee_type in", values, "examineeType");
            return (Criteria) this;
        }

        public Criteria andExamineeTypeNotIn(List<Integer> values) {
            addCriterion("examinee_type not in", values, "examineeType");
            return (Criteria) this;
        }

        public Criteria andExamineeTypeBetween(Integer value1, Integer value2) {
            addCriterion("examinee_type between", value1, value2, "examineeType");
            return (Criteria) this;
        }

        public Criteria andExamineeTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("examinee_type not between", value1, value2, "examineeType");
            return (Criteria) this;
        }

        public Criteria andGraduationSchoolIsNull() {
            addCriterion("graduation_school is null");
            return (Criteria) this;
        }

        public Criteria andGraduationSchoolIsNotNull() {
            addCriterion("graduation_school is not null");
            return (Criteria) this;
        }

        public Criteria andGraduationSchoolEqualTo(String value) {
            addCriterion("graduation_school =", value, "graduationSchool");
            return (Criteria) this;
        }

        public Criteria andGraduationSchoolNotEqualTo(String value) {
            addCriterion("graduation_school <>", value, "graduationSchool");
            return (Criteria) this;
        }

        public Criteria andGraduationSchoolGreaterThan(String value) {
            addCriterion("graduation_school >", value, "graduationSchool");
            return (Criteria) this;
        }

        public Criteria andGraduationSchoolGreaterThanOrEqualTo(String value) {
            addCriterion("graduation_school >=", value, "graduationSchool");
            return (Criteria) this;
        }

        public Criteria andGraduationSchoolLessThan(String value) {
            addCriterion("graduation_school <", value, "graduationSchool");
            return (Criteria) this;
        }

        public Criteria andGraduationSchoolLessThanOrEqualTo(String value) {
            addCriterion("graduation_school <=", value, "graduationSchool");
            return (Criteria) this;
        }

        public Criteria andGraduationSchoolLike(String value) {
            addCriterion("graduation_school like", value, "graduationSchool");
            return (Criteria) this;
        }

        public Criteria andGraduationSchoolNotLike(String value) {
            addCriterion("graduation_school not like", value, "graduationSchool");
            return (Criteria) this;
        }

        public Criteria andGraduationSchoolIn(List<String> values) {
            addCriterion("graduation_school in", values, "graduationSchool");
            return (Criteria) this;
        }

        public Criteria andGraduationSchoolNotIn(List<String> values) {
            addCriterion("graduation_school not in", values, "graduationSchool");
            return (Criteria) this;
        }

        public Criteria andGraduationSchoolBetween(String value1, String value2) {
            addCriterion("graduation_school between", value1, value2, "graduationSchool");
            return (Criteria) this;
        }

        public Criteria andGraduationSchoolNotBetween(String value1, String value2) {
            addCriterion("graduation_school not between", value1, value2, "graduationSchool");
            return (Criteria) this;
        }

        public Criteria andMajorFieldIdIsNull() {
            addCriterion("major_field_id is null");
            return (Criteria) this;
        }

        public Criteria andMajorFieldIdIsNotNull() {
            addCriterion("major_field_id is not null");
            return (Criteria) this;
        }

        public Criteria andMajorFieldIdEqualTo(Integer value) {
            addCriterion("major_field_id =", value, "majorFieldId");
            return (Criteria) this;
        }

        public Criteria andMajorFieldIdNotEqualTo(Integer value) {
            addCriterion("major_field_id <>", value, "majorFieldId");
            return (Criteria) this;
        }

        public Criteria andMajorFieldIdGreaterThan(Integer value) {
            addCriterion("major_field_id >", value, "majorFieldId");
            return (Criteria) this;
        }

        public Criteria andMajorFieldIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("major_field_id >=", value, "majorFieldId");
            return (Criteria) this;
        }

        public Criteria andMajorFieldIdLessThan(Integer value) {
            addCriterion("major_field_id <", value, "majorFieldId");
            return (Criteria) this;
        }

        public Criteria andMajorFieldIdLessThanOrEqualTo(Integer value) {
            addCriterion("major_field_id <=", value, "majorFieldId");
            return (Criteria) this;
        }

        public Criteria andMajorFieldIdIn(List<Integer> values) {
            addCriterion("major_field_id in", values, "majorFieldId");
            return (Criteria) this;
        }

        public Criteria andMajorFieldIdNotIn(List<Integer> values) {
            addCriterion("major_field_id not in", values, "majorFieldId");
            return (Criteria) this;
        }

        public Criteria andMajorFieldIdBetween(Integer value1, Integer value2) {
            addCriterion("major_field_id between", value1, value2, "majorFieldId");
            return (Criteria) this;
        }

        public Criteria andMajorFieldIdNotBetween(Integer value1, Integer value2) {
            addCriterion("major_field_id not between", value1, value2, "majorFieldId");
            return (Criteria) this;
        }

        public Criteria andExamNumberIsNull() {
            addCriterion("exam_number is null");
            return (Criteria) this;
        }

        public Criteria andExamNumberIsNotNull() {
            addCriterion("exam_number is not null");
            return (Criteria) this;
        }

        public Criteria andExamNumberEqualTo(String value) {
            addCriterion("exam_number =", value, "examNumber");
            return (Criteria) this;
        }

        public Criteria andExamNumberNotEqualTo(String value) {
            addCriterion("exam_number <>", value, "examNumber");
            return (Criteria) this;
        }

        public Criteria andExamNumberGreaterThan(String value) {
            addCriterion("exam_number >", value, "examNumber");
            return (Criteria) this;
        }

        public Criteria andExamNumberGreaterThanOrEqualTo(String value) {
            addCriterion("exam_number >=", value, "examNumber");
            return (Criteria) this;
        }

        public Criteria andExamNumberLessThan(String value) {
            addCriterion("exam_number <", value, "examNumber");
            return (Criteria) this;
        }

        public Criteria andExamNumberLessThanOrEqualTo(String value) {
            addCriterion("exam_number <=", value, "examNumber");
            return (Criteria) this;
        }

        public Criteria andExamNumberLike(String value) {
            addCriterion("exam_number like", value, "examNumber");
            return (Criteria) this;
        }

        public Criteria andExamNumberNotLike(String value) {
            addCriterion("exam_number not like", value, "examNumber");
            return (Criteria) this;
        }

        public Criteria andExamNumberIn(List<String> values) {
            addCriterion("exam_number in", values, "examNumber");
            return (Criteria) this;
        }

        public Criteria andExamNumberNotIn(List<String> values) {
            addCriterion("exam_number not in", values, "examNumber");
            return (Criteria) this;
        }

        public Criteria andExamNumberBetween(String value1, String value2) {
            addCriterion("exam_number between", value1, value2, "examNumber");
            return (Criteria) this;
        }

        public Criteria andExamNumberNotBetween(String value1, String value2) {
            addCriterion("exam_number not between", value1, value2, "examNumber");
            return (Criteria) this;
        }

        public Criteria andExamTotalScoreIsNull() {
            addCriterion("exam_total_score is null");
            return (Criteria) this;
        }

        public Criteria andExamTotalScoreIsNotNull() {
            addCriterion("exam_total_score is not null");
            return (Criteria) this;
        }

        public Criteria andExamTotalScoreEqualTo(Integer value) {
            addCriterion("exam_total_score =", value, "examTotalScore");
            return (Criteria) this;
        }

        public Criteria andExamTotalScoreNotEqualTo(Integer value) {
            addCriterion("exam_total_score <>", value, "examTotalScore");
            return (Criteria) this;
        }

        public Criteria andExamTotalScoreGreaterThan(Integer value) {
            addCriterion("exam_total_score >", value, "examTotalScore");
            return (Criteria) this;
        }

        public Criteria andExamTotalScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("exam_total_score >=", value, "examTotalScore");
            return (Criteria) this;
        }

        public Criteria andExamTotalScoreLessThan(Integer value) {
            addCriterion("exam_total_score <", value, "examTotalScore");
            return (Criteria) this;
        }

        public Criteria andExamTotalScoreLessThanOrEqualTo(Integer value) {
            addCriterion("exam_total_score <=", value, "examTotalScore");
            return (Criteria) this;
        }

        public Criteria andExamTotalScoreIn(List<Integer> values) {
            addCriterion("exam_total_score in", values, "examTotalScore");
            return (Criteria) this;
        }

        public Criteria andExamTotalScoreNotIn(List<Integer> values) {
            addCriterion("exam_total_score not in", values, "examTotalScore");
            return (Criteria) this;
        }

        public Criteria andExamTotalScoreBetween(Integer value1, Integer value2) {
            addCriterion("exam_total_score between", value1, value2, "examTotalScore");
            return (Criteria) this;
        }

        public Criteria andExamTotalScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("exam_total_score not between", value1, value2, "examTotalScore");
            return (Criteria) this;
        }

        public Criteria andStudyTypeIsNull() {
            addCriterion("study_type is null");
            return (Criteria) this;
        }

        public Criteria andStudyTypeIsNotNull() {
            addCriterion("study_type is not null");
            return (Criteria) this;
        }

        public Criteria andStudyTypeEqualTo(Integer value) {
            addCriterion("study_type =", value, "studyType");
            return (Criteria) this;
        }

        public Criteria andStudyTypeNotEqualTo(Integer value) {
            addCriterion("study_type <>", value, "studyType");
            return (Criteria) this;
        }

        public Criteria andStudyTypeGreaterThan(Integer value) {
            addCriterion("study_type >", value, "studyType");
            return (Criteria) this;
        }

        public Criteria andStudyTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("study_type >=", value, "studyType");
            return (Criteria) this;
        }

        public Criteria andStudyTypeLessThan(Integer value) {
            addCriterion("study_type <", value, "studyType");
            return (Criteria) this;
        }

        public Criteria andStudyTypeLessThanOrEqualTo(Integer value) {
            addCriterion("study_type <=", value, "studyType");
            return (Criteria) this;
        }

        public Criteria andStudyTypeIn(List<Integer> values) {
            addCriterion("study_type in", values, "studyType");
            return (Criteria) this;
        }

        public Criteria andStudyTypeNotIn(List<Integer> values) {
            addCriterion("study_type not in", values, "studyType");
            return (Criteria) this;
        }

        public Criteria andStudyTypeBetween(Integer value1, Integer value2) {
            addCriterion("study_type between", value1, value2, "studyType");
            return (Criteria) this;
        }

        public Criteria andStudyTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("study_type not between", value1, value2, "studyType");
            return (Criteria) this;
        }

        public Criteria andStudyMethodIsNull() {
            addCriterion("study_method is null");
            return (Criteria) this;
        }

        public Criteria andStudyMethodIsNotNull() {
            addCriterion("study_method is not null");
            return (Criteria) this;
        }

        public Criteria andStudyMethodEqualTo(Integer value) {
            addCriterion("study_method =", value, "studyMethod");
            return (Criteria) this;
        }

        public Criteria andStudyMethodNotEqualTo(Integer value) {
            addCriterion("study_method <>", value, "studyMethod");
            return (Criteria) this;
        }

        public Criteria andStudyMethodGreaterThan(Integer value) {
            addCriterion("study_method >", value, "studyMethod");
            return (Criteria) this;
        }

        public Criteria andStudyMethodGreaterThanOrEqualTo(Integer value) {
            addCriterion("study_method >=", value, "studyMethod");
            return (Criteria) this;
        }

        public Criteria andStudyMethodLessThan(Integer value) {
            addCriterion("study_method <", value, "studyMethod");
            return (Criteria) this;
        }

        public Criteria andStudyMethodLessThanOrEqualTo(Integer value) {
            addCriterion("study_method <=", value, "studyMethod");
            return (Criteria) this;
        }

        public Criteria andStudyMethodIn(List<Integer> values) {
            addCriterion("study_method in", values, "studyMethod");
            return (Criteria) this;
        }

        public Criteria andStudyMethodNotIn(List<Integer> values) {
            addCriterion("study_method not in", values, "studyMethod");
            return (Criteria) this;
        }

        public Criteria andStudyMethodBetween(Integer value1, Integer value2) {
            addCriterion("study_method between", value1, value2, "studyMethod");
            return (Criteria) this;
        }

        public Criteria andStudyMethodNotBetween(Integer value1, Integer value2) {
            addCriterion("study_method not between", value1, value2, "studyMethod");
            return (Criteria) this;
        }

        public Criteria andEnterSchoolTypeIsNull() {
            addCriterion("enter_school_type is null");
            return (Criteria) this;
        }

        public Criteria andEnterSchoolTypeIsNotNull() {
            addCriterion("enter_school_type is not null");
            return (Criteria) this;
        }

        public Criteria andEnterSchoolTypeEqualTo(Integer value) {
            addCriterion("enter_school_type =", value, "enterSchoolType");
            return (Criteria) this;
        }

        public Criteria andEnterSchoolTypeNotEqualTo(Integer value) {
            addCriterion("enter_school_type <>", value, "enterSchoolType");
            return (Criteria) this;
        }

        public Criteria andEnterSchoolTypeGreaterThan(Integer value) {
            addCriterion("enter_school_type >", value, "enterSchoolType");
            return (Criteria) this;
        }

        public Criteria andEnterSchoolTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("enter_school_type >=", value, "enterSchoolType");
            return (Criteria) this;
        }

        public Criteria andEnterSchoolTypeLessThan(Integer value) {
            addCriterion("enter_school_type <", value, "enterSchoolType");
            return (Criteria) this;
        }

        public Criteria andEnterSchoolTypeLessThanOrEqualTo(Integer value) {
            addCriterion("enter_school_type <=", value, "enterSchoolType");
            return (Criteria) this;
        }

        public Criteria andEnterSchoolTypeIn(List<Integer> values) {
            addCriterion("enter_school_type in", values, "enterSchoolType");
            return (Criteria) this;
        }

        public Criteria andEnterSchoolTypeNotIn(List<Integer> values) {
            addCriterion("enter_school_type not in", values, "enterSchoolType");
            return (Criteria) this;
        }

        public Criteria andEnterSchoolTypeBetween(Integer value1, Integer value2) {
            addCriterion("enter_school_type between", value1, value2, "enterSchoolType");
            return (Criteria) this;
        }

        public Criteria andEnterSchoolTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("enter_school_type not between", value1, value2, "enterSchoolType");
            return (Criteria) this;
        }

        public Criteria andEduStageTypeIsNull() {
            addCriterion("edu_stage_type is null");
            return (Criteria) this;
        }

        public Criteria andEduStageTypeIsNotNull() {
            addCriterion("edu_stage_type is not null");
            return (Criteria) this;
        }

        public Criteria andEduStageTypeEqualTo(Integer value) {
            addCriterion("edu_stage_type =", value, "eduStageType");
            return (Criteria) this;
        }

        public Criteria andEduStageTypeNotEqualTo(Integer value) {
            addCriterion("edu_stage_type <>", value, "eduStageType");
            return (Criteria) this;
        }

        public Criteria andEduStageTypeGreaterThan(Integer value) {
            addCriterion("edu_stage_type >", value, "eduStageType");
            return (Criteria) this;
        }

        public Criteria andEduStageTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("edu_stage_type >=", value, "eduStageType");
            return (Criteria) this;
        }

        public Criteria andEduStageTypeLessThan(Integer value) {
            addCriterion("edu_stage_type <", value, "eduStageType");
            return (Criteria) this;
        }

        public Criteria andEduStageTypeLessThanOrEqualTo(Integer value) {
            addCriterion("edu_stage_type <=", value, "eduStageType");
            return (Criteria) this;
        }

        public Criteria andEduStageTypeIn(List<Integer> values) {
            addCriterion("edu_stage_type in", values, "eduStageType");
            return (Criteria) this;
        }

        public Criteria andEduStageTypeNotIn(List<Integer> values) {
            addCriterion("edu_stage_type not in", values, "eduStageType");
            return (Criteria) this;
        }

        public Criteria andEduStageTypeBetween(Integer value1, Integer value2) {
            addCriterion("edu_stage_type between", value1, value2, "eduStageType");
            return (Criteria) this;
        }

        public Criteria andEduStageTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("edu_stage_type not between", value1, value2, "eduStageType");
            return (Criteria) this;
        }

        public Criteria andAdmissionNumberIsNull() {
            addCriterion("admission_number is null");
            return (Criteria) this;
        }

        public Criteria andAdmissionNumberIsNotNull() {
            addCriterion("admission_number is not null");
            return (Criteria) this;
        }

        public Criteria andAdmissionNumberEqualTo(String value) {
            addCriterion("admission_number =", value, "admissionNumber");
            return (Criteria) this;
        }

        public Criteria andAdmissionNumberNotEqualTo(String value) {
            addCriterion("admission_number <>", value, "admissionNumber");
            return (Criteria) this;
        }

        public Criteria andAdmissionNumberGreaterThan(String value) {
            addCriterion("admission_number >", value, "admissionNumber");
            return (Criteria) this;
        }

        public Criteria andAdmissionNumberGreaterThanOrEqualTo(String value) {
            addCriterion("admission_number >=", value, "admissionNumber");
            return (Criteria) this;
        }

        public Criteria andAdmissionNumberLessThan(String value) {
            addCriterion("admission_number <", value, "admissionNumber");
            return (Criteria) this;
        }

        public Criteria andAdmissionNumberLessThanOrEqualTo(String value) {
            addCriterion("admission_number <=", value, "admissionNumber");
            return (Criteria) this;
        }

        public Criteria andAdmissionNumberLike(String value) {
            addCriterion("admission_number like", value, "admissionNumber");
            return (Criteria) this;
        }

        public Criteria andAdmissionNumberNotLike(String value) {
            addCriterion("admission_number not like", value, "admissionNumber");
            return (Criteria) this;
        }

        public Criteria andAdmissionNumberIn(List<String> values) {
            addCriterion("admission_number in", values, "admissionNumber");
            return (Criteria) this;
        }

        public Criteria andAdmissionNumberNotIn(List<String> values) {
            addCriterion("admission_number not in", values, "admissionNumber");
            return (Criteria) this;
        }

        public Criteria andAdmissionNumberBetween(String value1, String value2) {
            addCriterion("admission_number between", value1, value2, "admissionNumber");
            return (Criteria) this;
        }

        public Criteria andAdmissionNumberNotBetween(String value1, String value2) {
            addCriterion("admission_number not between", value1, value2, "admissionNumber");
            return (Criteria) this;
        }

        public Criteria andIsDivideClassIsNull() {
            addCriterion("is_divide_class is null");
            return (Criteria) this;
        }

        public Criteria andIsDivideClassIsNotNull() {
            addCriterion("is_divide_class is not null");
            return (Criteria) this;
        }

        public Criteria andIsDivideClassEqualTo(Integer value) {
            addCriterion("is_divide_class =", value, "isDivideClass");
            return (Criteria) this;
        }

        public Criteria andIsDivideClassNotEqualTo(Integer value) {
            addCriterion("is_divide_class <>", value, "isDivideClass");
            return (Criteria) this;
        }

        public Criteria andIsDivideClassGreaterThan(Integer value) {
            addCriterion("is_divide_class >", value, "isDivideClass");
            return (Criteria) this;
        }

        public Criteria andIsDivideClassGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_divide_class >=", value, "isDivideClass");
            return (Criteria) this;
        }

        public Criteria andIsDivideClassLessThan(Integer value) {
            addCriterion("is_divide_class <", value, "isDivideClass");
            return (Criteria) this;
        }

        public Criteria andIsDivideClassLessThanOrEqualTo(Integer value) {
            addCriterion("is_divide_class <=", value, "isDivideClass");
            return (Criteria) this;
        }

        public Criteria andIsDivideClassIn(List<Integer> values) {
            addCriterion("is_divide_class in", values, "isDivideClass");
            return (Criteria) this;
        }

        public Criteria andIsDivideClassNotIn(List<Integer> values) {
            addCriterion("is_divide_class not in", values, "isDivideClass");
            return (Criteria) this;
        }

        public Criteria andIsDivideClassBetween(Integer value1, Integer value2) {
            addCriterion("is_divide_class between", value1, value2, "isDivideClass");
            return (Criteria) this;
        }

        public Criteria andIsDivideClassNotBetween(Integer value1, Integer value2) {
            addCriterion("is_divide_class not between", value1, value2, "isDivideClass");
            return (Criteria) this;
        }

        public Criteria andStudyStatusIsNull() {
            addCriterion("study_status is null");
            return (Criteria) this;
        }

        public Criteria andStudyStatusIsNotNull() {
            addCriterion("study_status is not null");
            return (Criteria) this;
        }

        public Criteria andStudyStatusEqualTo(Integer value) {
            addCriterion("study_status =", value, "studyStatus");
            return (Criteria) this;
        }

        public Criteria andStudyStatusNotEqualTo(Integer value) {
            addCriterion("study_status <>", value, "studyStatus");
            return (Criteria) this;
        }

        public Criteria andStudyStatusGreaterThan(Integer value) {
            addCriterion("study_status >", value, "studyStatus");
            return (Criteria) this;
        }

        public Criteria andStudyStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("study_status >=", value, "studyStatus");
            return (Criteria) this;
        }

        public Criteria andStudyStatusLessThan(Integer value) {
            addCriterion("study_status <", value, "studyStatus");
            return (Criteria) this;
        }

        public Criteria andStudyStatusLessThanOrEqualTo(Integer value) {
            addCriterion("study_status <=", value, "studyStatus");
            return (Criteria) this;
        }

        public Criteria andStudyStatusIn(List<Integer> values) {
            addCriterion("study_status in", values, "studyStatus");
            return (Criteria) this;
        }

        public Criteria andStudyStatusNotIn(List<Integer> values) {
            addCriterion("study_status not in", values, "studyStatus");
            return (Criteria) this;
        }

        public Criteria andStudyStatusBetween(Integer value1, Integer value2) {
            addCriterion("study_status between", value1, value2, "studyStatus");
            return (Criteria) this;
        }

        public Criteria andStudyStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("study_status not between", value1, value2, "studyStatus");
            return (Criteria) this;
        }

        public Criteria andEntranceDateIsNull() {
            addCriterion("entrance_date is null");
            return (Criteria) this;
        }

        public Criteria andEntranceDateIsNotNull() {
            addCriterion("entrance_date is not null");
            return (Criteria) this;
        }

        public Criteria andEntranceDateEqualTo(Date value) {
            addCriterionForJDBCDate("entrance_date =", value, "entranceDate");
            return (Criteria) this;
        }

        public Criteria andEntranceDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("entrance_date <>", value, "entranceDate");
            return (Criteria) this;
        }

        public Criteria andEntranceDateGreaterThan(Date value) {
            addCriterionForJDBCDate("entrance_date >", value, "entranceDate");
            return (Criteria) this;
        }

        public Criteria andEntranceDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("entrance_date >=", value, "entranceDate");
            return (Criteria) this;
        }

        public Criteria andEntranceDateLessThan(Date value) {
            addCriterionForJDBCDate("entrance_date <", value, "entranceDate");
            return (Criteria) this;
        }

        public Criteria andEntranceDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("entrance_date <=", value, "entranceDate");
            return (Criteria) this;
        }

        public Criteria andEntranceDateIn(List<Date> values) {
            addCriterionForJDBCDate("entrance_date in", values, "entranceDate");
            return (Criteria) this;
        }

        public Criteria andEntranceDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("entrance_date not in", values, "entranceDate");
            return (Criteria) this;
        }

        public Criteria andEntranceDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("entrance_date between", value1, value2, "entranceDate");
            return (Criteria) this;
        }

        public Criteria andEntranceDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("entrance_date not between", value1, value2, "entranceDate");
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