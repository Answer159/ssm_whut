package cn.wmyskxz.pojo;

import java.util.ArrayList;
import java.util.List;

public class EvaluationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EvaluationExample() {
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

        public Criteria andUse_idIsNull() {
            addCriterion("use_id is null");
            return (Criteria) this;
        }

        public Criteria andUse_idIsNotNull() {
            addCriterion("use_id is not null");
            return (Criteria) this;
        }

        public Criteria andUse_idEqualTo(Integer value) {
            addCriterion("use_id =", value, "use_id");
            return (Criteria) this;
        }

        public Criteria andUse_idNotEqualTo(Integer value) {
            addCriterion("use_id <>", value, "use_id");
            return (Criteria) this;
        }

        public Criteria andUse_idGreaterThan(Integer value) {
            addCriterion("use_id >", value, "use_id");
            return (Criteria) this;
        }

        public Criteria andUse_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("use_id >=", value, "use_id");
            return (Criteria) this;
        }

        public Criteria andUse_idLessThan(Integer value) {
            addCriterion("use_id <", value, "use_id");
            return (Criteria) this;
        }

        public Criteria andUse_idLessThanOrEqualTo(Integer value) {
            addCriterion("use_id <=", value, "use_id");
            return (Criteria) this;
        }

        public Criteria andUse_idIn(List<Integer> values) {
            addCriterion("use_id in", values, "use_id");
            return (Criteria) this;
        }

        public Criteria andUse_idNotIn(List<Integer> values) {
            addCriterion("use_id not in", values, "use_id");
            return (Criteria) this;
        }

        public Criteria andUse_idBetween(Integer value1, Integer value2) {
            addCriterion("use_id between", value1, value2, "use_id");
            return (Criteria) this;
        }

        public Criteria andUse_idNotBetween(Integer value1, Integer value2) {
            addCriterion("use_id not between", value1, value2, "use_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrder_idIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_idEqualTo(Integer value) {
            addCriterion("order_id =", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idNotEqualTo(Integer value) {
            addCriterion("order_id <>", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idGreaterThan(Integer value) {
            addCriterion("order_id >", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_id >=", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idLessThan(Integer value) {
            addCriterion("order_id <", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idLessThanOrEqualTo(Integer value) {
            addCriterion("order_id <=", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idIn(List<Integer> values) {
            addCriterion("order_id in", values, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idNotIn(List<Integer> values) {
            addCriterion("order_id not in", values, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idBetween(Integer value1, Integer value2) {
            addCriterion("order_id between", value1, value2, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idNotBetween(Integer value1, Integer value2) {
            addCriterion("order_id not between", value1, value2, "order_id");
            return (Criteria) this;
        }

        public Criteria andLike_IsNull() {
            addCriterion("like_ is null");
            return (Criteria) this;
        }

        public Criteria andLike_IsNotNull() {
            addCriterion("like_ is not null");
            return (Criteria) this;
        }

        public Criteria andLike_EqualTo(Integer value) {
            addCriterion("like_ =", value, "like_");
            return (Criteria) this;
        }

        public Criteria andLike_NotEqualTo(Integer value) {
            addCriterion("like_ <>", value, "like_");
            return (Criteria) this;
        }

        public Criteria andLike_GreaterThan(Integer value) {
            addCriterion("like_ >", value, "like_");
            return (Criteria) this;
        }

        public Criteria andLike_GreaterThanOrEqualTo(Integer value) {
            addCriterion("like_ >=", value, "like_");
            return (Criteria) this;
        }

        public Criteria andLike_LessThan(Integer value) {
            addCriterion("like_ <", value, "like_");
            return (Criteria) this;
        }

        public Criteria andLike_LessThanOrEqualTo(Integer value) {
            addCriterion("like_ <=", value, "like_");
            return (Criteria) this;
        }

        public Criteria andLike_In(List<Integer> values) {
            addCriterion("like_ in", values, "like_");
            return (Criteria) this;
        }

        public Criteria andLike_NotIn(List<Integer> values) {
            addCriterion("like_ not in", values, "like_");
            return (Criteria) this;
        }

        public Criteria andLike_Between(Integer value1, Integer value2) {
            addCriterion("like_ between", value1, value2, "like_");
            return (Criteria) this;
        }

        public Criteria andLike_NotBetween(Integer value1, Integer value2) {
            addCriterion("like_ not between", value1, value2, "like_");
            return (Criteria) this;
        }

        public Criteria andClass_idIsNull() {
            addCriterion("class_id is null");
            return (Criteria) this;
        }

        public Criteria andClass_idIsNotNull() {
            addCriterion("class_id is not null");
            return (Criteria) this;
        }

        public Criteria andClass_idEqualTo(Integer value) {
            addCriterion("class_id =", value, "class_id");
            return (Criteria) this;
        }

        public Criteria andClass_idNotEqualTo(Integer value) {
            addCriterion("class_id <>", value, "class_id");
            return (Criteria) this;
        }

        public Criteria andClass_idGreaterThan(Integer value) {
            addCriterion("class_id >", value, "class_id");
            return (Criteria) this;
        }

        public Criteria andClass_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("class_id >=", value, "class_id");
            return (Criteria) this;
        }

        public Criteria andClass_idLessThan(Integer value) {
            addCriterion("class_id <", value, "class_id");
            return (Criteria) this;
        }

        public Criteria andClass_idLessThanOrEqualTo(Integer value) {
            addCriterion("class_id <=", value, "class_id");
            return (Criteria) this;
        }

        public Criteria andClass_idIn(List<Integer> values) {
            addCriterion("class_id in", values, "class_id");
            return (Criteria) this;
        }

        public Criteria andClass_idNotIn(List<Integer> values) {
            addCriterion("class_id not in", values, "class_id");
            return (Criteria) this;
        }

        public Criteria andClass_idBetween(Integer value1, Integer value2) {
            addCriterion("class_id between", value1, value2, "class_id");
            return (Criteria) this;
        }

        public Criteria andClass_idNotBetween(Integer value1, Integer value2) {
            addCriterion("class_id not between", value1, value2, "class_id");
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