package cn.wmyskxz.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order_Example {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Order_Example() {
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

        public Criteria andOrder_statusIsNull() {
            addCriterion("order_status is null");
            return (Criteria) this;
        }

        public Criteria andOrder_statusIsNotNull() {
            addCriterion("order_status is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_statusEqualTo(String value) {
            addCriterion("order_status =", value, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusNotEqualTo(String value) {
            addCriterion("order_status <>", value, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusGreaterThan(String value) {
            addCriterion("order_status >", value, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusGreaterThanOrEqualTo(String value) {
            addCriterion("order_status >=", value, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusLessThan(String value) {
            addCriterion("order_status <", value, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusLessThanOrEqualTo(String value) {
            addCriterion("order_status <=", value, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusLike(String value) {
            addCriterion("order_status like", value, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusNotLike(String value) {
            addCriterion("order_status not like", value, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusIn(List<String> values) {
            addCriterion("order_status in", values, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusNotIn(List<String> values) {
            addCriterion("order_status not in", values, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusBetween(String value1, String value2) {
            addCriterion("order_status between", value1, value2, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusNotBetween(String value1, String value2) {
            addCriterion("order_status not between", value1, value2, "order_status");
            return (Criteria) this;
        }

        public Criteria andBuyer_idIsNull() {
            addCriterion("buyer_id is null");
            return (Criteria) this;
        }

        public Criteria andBuyer_idIsNotNull() {
            addCriterion("buyer_id is not null");
            return (Criteria) this;
        }

        public Criteria andBuyer_idEqualTo(Integer value) {
            addCriterion("buyer_id =", value, "buyer_id");
            return (Criteria) this;
        }

        public Criteria andBuyer_idNotEqualTo(Integer value) {
            addCriterion("buyer_id <>", value, "buyer_id");
            return (Criteria) this;
        }

        public Criteria andBuyer_idGreaterThan(Integer value) {
            addCriterion("buyer_id >", value, "buyer_id");
            return (Criteria) this;
        }

        public Criteria andBuyer_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("buyer_id >=", value, "buyer_id");
            return (Criteria) this;
        }

        public Criteria andBuyer_idLessThan(Integer value) {
            addCriterion("buyer_id <", value, "buyer_id");
            return (Criteria) this;
        }

        public Criteria andBuyer_idLessThanOrEqualTo(Integer value) {
            addCriterion("buyer_id <=", value, "buyer_id");
            return (Criteria) this;
        }

        public Criteria andBuyer_idIn(List<Integer> values) {
            addCriterion("buyer_id in", values, "buyer_id");
            return (Criteria) this;
        }

        public Criteria andBuyer_idNotIn(List<Integer> values) {
            addCriterion("buyer_id not in", values, "buyer_id");
            return (Criteria) this;
        }

        public Criteria andBuyer_idBetween(Integer value1, Integer value2) {
            addCriterion("buyer_id between", value1, value2, "buyer_id");
            return (Criteria) this;
        }

        public Criteria andBuyer_idNotBetween(Integer value1, Integer value2) {
            addCriterion("buyer_id not between", value1, value2, "buyer_id");
            return (Criteria) this;
        }

        public Criteria andSeller_idIsNull() {
            addCriterion("seller_id is null");
            return (Criteria) this;
        }

        public Criteria andSeller_idIsNotNull() {
            addCriterion("seller_id is not null");
            return (Criteria) this;
        }

        public Criteria andSeller_idEqualTo(Integer value) {
            addCriterion("seller_id =", value, "seller_id");
            return (Criteria) this;
        }

        public Criteria andSeller_idNotEqualTo(Integer value) {
            addCriterion("seller_id <>", value, "seller_id");
            return (Criteria) this;
        }

        public Criteria andSeller_idGreaterThan(Integer value) {
            addCriterion("seller_id >", value, "seller_id");
            return (Criteria) this;
        }

        public Criteria andSeller_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("seller_id >=", value, "seller_id");
            return (Criteria) this;
        }

        public Criteria andSeller_idLessThan(Integer value) {
            addCriterion("seller_id <", value, "seller_id");
            return (Criteria) this;
        }

        public Criteria andSeller_idLessThanOrEqualTo(Integer value) {
            addCriterion("seller_id <=", value, "seller_id");
            return (Criteria) this;
        }

        public Criteria andSeller_idIn(List<Integer> values) {
            addCriterion("seller_id in", values, "seller_id");
            return (Criteria) this;
        }

        public Criteria andSeller_idNotIn(List<Integer> values) {
            addCriterion("seller_id not in", values, "seller_id");
            return (Criteria) this;
        }

        public Criteria andSeller_idBetween(Integer value1, Integer value2) {
            addCriterion("seller_id between", value1, value2, "seller_id");
            return (Criteria) this;
        }

        public Criteria andSeller_idNotBetween(Integer value1, Integer value2) {
            addCriterion("seller_id not between", value1, value2, "seller_id");
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

        public Criteria andCreateDateIsNull() {
            addCriterion("createDate is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("createDate is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("createDate =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("createDate <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("createDate >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("createDate >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("createDate <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("createDate <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("createDate in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("createDate not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("createDate between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("createDate not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Double value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Double value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Double value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Double value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Double value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Double> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Double> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Double value1, Double value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Double value1, Double value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andSuggestTimeIsNull() {
            addCriterion("suggestTime is null");
            return (Criteria) this;
        }

        public Criteria andSuggestTimeIsNotNull() {
            addCriterion("suggestTime is not null");
            return (Criteria) this;
        }

        public Criteria andSuggestTimeEqualTo(Double value) {
            addCriterion("suggestTime =", value, "suggestTime");
            return (Criteria) this;
        }

        public Criteria andSuggestTimeNotEqualTo(Double value) {
            addCriterion("suggestTime <>", value, "suggestTime");
            return (Criteria) this;
        }

        public Criteria andSuggestTimeGreaterThan(Double value) {
            addCriterion("suggestTime >", value, "suggestTime");
            return (Criteria) this;
        }

        public Criteria andSuggestTimeGreaterThanOrEqualTo(Double value) {
            addCriterion("suggestTime >=", value, "suggestTime");
            return (Criteria) this;
        }

        public Criteria andSuggestTimeLessThan(Double value) {
            addCriterion("suggestTime <", value, "suggestTime");
            return (Criteria) this;
        }

        public Criteria andSuggestTimeLessThanOrEqualTo(Double value) {
            addCriterion("suggestTime <=", value, "suggestTime");
            return (Criteria) this;
        }

        public Criteria andSuggestTimeIn(List<Double> values) {
            addCriterion("suggestTime in", values, "suggestTime");
            return (Criteria) this;
        }

        public Criteria andSuggestTimeNotIn(List<Double> values) {
            addCriterion("suggestTime not in", values, "suggestTime");
            return (Criteria) this;
        }

        public Criteria andSuggestTimeBetween(Double value1, Double value2) {
            addCriterion("suggestTime between", value1, value2, "suggestTime");
            return (Criteria) this;
        }

        public Criteria andSuggestTimeNotBetween(Double value1, Double value2) {
            addCriterion("suggestTime not between", value1, value2, "suggestTime");
            return (Criteria) this;
        }

        public Criteria andBuyer_statuIsNull() {
            addCriterion("buyer_statu is null");
            return (Criteria) this;
        }

        public Criteria andBuyer_statuIsNotNull() {
            addCriterion("buyer_statu is not null");
            return (Criteria) this;
        }

        public Criteria andBuyer_statuEqualTo(Integer value) {
            addCriterion("buyer_statu =", value, "buyer_statu");
            return (Criteria) this;
        }

        public Criteria andBuyer_statuNotEqualTo(Integer value) {
            addCriterion("buyer_statu <>", value, "buyer_statu");
            return (Criteria) this;
        }

        public Criteria andBuyer_statuGreaterThan(Integer value) {
            addCriterion("buyer_statu >", value, "buyer_statu");
            return (Criteria) this;
        }

        public Criteria andBuyer_statuGreaterThanOrEqualTo(Integer value) {
            addCriterion("buyer_statu >=", value, "buyer_statu");
            return (Criteria) this;
        }

        public Criteria andBuyer_statuLessThan(Integer value) {
            addCriterion("buyer_statu <", value, "buyer_statu");
            return (Criteria) this;
        }

        public Criteria andBuyer_statuLessThanOrEqualTo(Integer value) {
            addCriterion("buyer_statu <=", value, "buyer_statu");
            return (Criteria) this;
        }

        public Criteria andBuyer_statuIn(List<Integer> values) {
            addCriterion("buyer_statu in", values, "buyer_statu");
            return (Criteria) this;
        }

        public Criteria andBuyer_statuNotIn(List<Integer> values) {
            addCriterion("buyer_statu not in", values, "buyer_statu");
            return (Criteria) this;
        }

        public Criteria andBuyer_statuBetween(Integer value1, Integer value2) {
            addCriterion("buyer_statu between", value1, value2, "buyer_statu");
            return (Criteria) this;
        }

        public Criteria andBuyer_statuNotBetween(Integer value1, Integer value2) {
            addCriterion("buyer_statu not between", value1, value2, "buyer_statu");
            return (Criteria) this;
        }

        public Criteria andSeller_statuIsNull() {
            addCriterion("seller_statu is null");
            return (Criteria) this;
        }

        public Criteria andSeller_statuIsNotNull() {
            addCriterion("seller_statu is not null");
            return (Criteria) this;
        }

        public Criteria andSeller_statuEqualTo(Integer value) {
            addCriterion("seller_statu =", value, "seller_statu");
            return (Criteria) this;
        }

        public Criteria andSeller_statuNotEqualTo(Integer value) {
            addCriterion("seller_statu <>", value, "seller_statu");
            return (Criteria) this;
        }

        public Criteria andSeller_statuGreaterThan(Integer value) {
            addCriterion("seller_statu >", value, "seller_statu");
            return (Criteria) this;
        }

        public Criteria andSeller_statuGreaterThanOrEqualTo(Integer value) {
            addCriterion("seller_statu >=", value, "seller_statu");
            return (Criteria) this;
        }

        public Criteria andSeller_statuLessThan(Integer value) {
            addCriterion("seller_statu <", value, "seller_statu");
            return (Criteria) this;
        }

        public Criteria andSeller_statuLessThanOrEqualTo(Integer value) {
            addCriterion("seller_statu <=", value, "seller_statu");
            return (Criteria) this;
        }

        public Criteria andSeller_statuIn(List<Integer> values) {
            addCriterion("seller_statu in", values, "seller_statu");
            return (Criteria) this;
        }

        public Criteria andSeller_statuNotIn(List<Integer> values) {
            addCriterion("seller_statu not in", values, "seller_statu");
            return (Criteria) this;
        }

        public Criteria andSeller_statuBetween(Integer value1, Integer value2) {
            addCriterion("seller_statu between", value1, value2, "seller_statu");
            return (Criteria) this;
        }

        public Criteria andSeller_statuNotBetween(Integer value1, Integer value2) {
            addCriterion("seller_statu not between", value1, value2, "seller_statu");
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