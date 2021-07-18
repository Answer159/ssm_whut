package cn.wmyskxz.pojo;

import java.util.ArrayList;
import java.util.List;

public class ClassInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ClassInfoExample() {
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

        public Criteria andDomain_idIsNull() {
            addCriterion("domain_id is null");
            return (Criteria) this;
        }

        public Criteria andDomain_idIsNotNull() {
            addCriterion("domain_id is not null");
            return (Criteria) this;
        }

        public Criteria andDomain_idEqualTo(Integer value) {
            addCriterion("domain_id =", value, "domain_id");
            return (Criteria) this;
        }

        public Criteria andDomain_idNotEqualTo(Integer value) {
            addCriterion("domain_id <>", value, "domain_id");
            return (Criteria) this;
        }

        public Criteria andDomain_idGreaterThan(Integer value) {
            addCriterion("domain_id >", value, "domain_id");
            return (Criteria) this;
        }

        public Criteria andDomain_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("domain_id >=", value, "domain_id");
            return (Criteria) this;
        }

        public Criteria andDomain_idLessThan(Integer value) {
            addCriterion("domain_id <", value, "domain_id");
            return (Criteria) this;
        }

        public Criteria andDomain_idLessThanOrEqualTo(Integer value) {
            addCriterion("domain_id <=", value, "domain_id");
            return (Criteria) this;
        }

        public Criteria andDomain_idIn(List<Integer> values) {
            addCriterion("domain_id in", values, "domain_id");
            return (Criteria) this;
        }

        public Criteria andDomain_idNotIn(List<Integer> values) {
            addCriterion("domain_id not in", values, "domain_id");
            return (Criteria) this;
        }

        public Criteria andDomain_idBetween(Integer value1, Integer value2) {
            addCriterion("domain_id between", value1, value2, "domain_id");
            return (Criteria) this;
        }

        public Criteria andDomain_idNotBetween(Integer value1, Integer value2) {
            addCriterion("domain_id not between", value1, value2, "domain_id");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
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

        public Criteria andTextIntroIsNull() {
            addCriterion("textIntro is null");
            return (Criteria) this;
        }

        public Criteria andTextIntroIsNotNull() {
            addCriterion("textIntro is not null");
            return (Criteria) this;
        }

        public Criteria andTextIntroEqualTo(String value) {
            addCriterion("textIntro =", value, "textIntro");
            return (Criteria) this;
        }

        public Criteria andTextIntroNotEqualTo(String value) {
            addCriterion("textIntro <>", value, "textIntro");
            return (Criteria) this;
        }

        public Criteria andTextIntroGreaterThan(String value) {
            addCriterion("textIntro >", value, "textIntro");
            return (Criteria) this;
        }

        public Criteria andTextIntroGreaterThanOrEqualTo(String value) {
            addCriterion("textIntro >=", value, "textIntro");
            return (Criteria) this;
        }

        public Criteria andTextIntroLessThan(String value) {
            addCriterion("textIntro <", value, "textIntro");
            return (Criteria) this;
        }

        public Criteria andTextIntroLessThanOrEqualTo(String value) {
            addCriterion("textIntro <=", value, "textIntro");
            return (Criteria) this;
        }

        public Criteria andTextIntroLike(String value) {
            addCriterion("textIntro like", value, "textIntro");
            return (Criteria) this;
        }

        public Criteria andTextIntroNotLike(String value) {
            addCriterion("textIntro not like", value, "textIntro");
            return (Criteria) this;
        }

        public Criteria andTextIntroIn(List<String> values) {
            addCriterion("textIntro in", values, "textIntro");
            return (Criteria) this;
        }

        public Criteria andTextIntroNotIn(List<String> values) {
            addCriterion("textIntro not in", values, "textIntro");
            return (Criteria) this;
        }

        public Criteria andTextIntroBetween(String value1, String value2) {
            addCriterion("textIntro between", value1, value2, "textIntro");
            return (Criteria) this;
        }

        public Criteria andTextIntroNotBetween(String value1, String value2) {
            addCriterion("textIntro not between", value1, value2, "textIntro");
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

        public Criteria andFront_knowledgeIsNull() {
            addCriterion("front_knowledge is null");
            return (Criteria) this;
        }

        public Criteria andFront_knowledgeIsNotNull() {
            addCriterion("front_knowledge is not null");
            return (Criteria) this;
        }

        public Criteria andFront_knowledgeEqualTo(String value) {
            addCriterion("front_knowledge =", value, "front_knowledge");
            return (Criteria) this;
        }

        public Criteria andFront_knowledgeNotEqualTo(String value) {
            addCriterion("front_knowledge <>", value, "front_knowledge");
            return (Criteria) this;
        }

        public Criteria andFront_knowledgeGreaterThan(String value) {
            addCriterion("front_knowledge >", value, "front_knowledge");
            return (Criteria) this;
        }

        public Criteria andFront_knowledgeGreaterThanOrEqualTo(String value) {
            addCriterion("front_knowledge >=", value, "front_knowledge");
            return (Criteria) this;
        }

        public Criteria andFront_knowledgeLessThan(String value) {
            addCriterion("front_knowledge <", value, "front_knowledge");
            return (Criteria) this;
        }

        public Criteria andFront_knowledgeLessThanOrEqualTo(String value) {
            addCriterion("front_knowledge <=", value, "front_knowledge");
            return (Criteria) this;
        }

        public Criteria andFront_knowledgeLike(String value) {
            addCriterion("front_knowledge like", value, "front_knowledge");
            return (Criteria) this;
        }

        public Criteria andFront_knowledgeNotLike(String value) {
            addCriterion("front_knowledge not like", value, "front_knowledge");
            return (Criteria) this;
        }

        public Criteria andFront_knowledgeIn(List<String> values) {
            addCriterion("front_knowledge in", values, "front_knowledge");
            return (Criteria) this;
        }

        public Criteria andFront_knowledgeNotIn(List<String> values) {
            addCriterion("front_knowledge not in", values, "front_knowledge");
            return (Criteria) this;
        }

        public Criteria andFront_knowledgeBetween(String value1, String value2) {
            addCriterion("front_knowledge between", value1, value2, "front_knowledge");
            return (Criteria) this;
        }

        public Criteria andFront_knowledgeNotBetween(String value1, String value2) {
            addCriterion("front_knowledge not between", value1, value2, "front_knowledge");
            return (Criteria) this;
        }

        public Criteria andToolsIsNull() {
            addCriterion("tools is null");
            return (Criteria) this;
        }

        public Criteria andToolsIsNotNull() {
            addCriterion("tools is not null");
            return (Criteria) this;
        }

        public Criteria andToolsEqualTo(String value) {
            addCriterion("tools =", value, "tools");
            return (Criteria) this;
        }

        public Criteria andToolsNotEqualTo(String value) {
            addCriterion("tools <>", value, "tools");
            return (Criteria) this;
        }

        public Criteria andToolsGreaterThan(String value) {
            addCriterion("tools >", value, "tools");
            return (Criteria) this;
        }

        public Criteria andToolsGreaterThanOrEqualTo(String value) {
            addCriterion("tools >=", value, "tools");
            return (Criteria) this;
        }

        public Criteria andToolsLessThan(String value) {
            addCriterion("tools <", value, "tools");
            return (Criteria) this;
        }

        public Criteria andToolsLessThanOrEqualTo(String value) {
            addCriterion("tools <=", value, "tools");
            return (Criteria) this;
        }

        public Criteria andToolsLike(String value) {
            addCriterion("tools like", value, "tools");
            return (Criteria) this;
        }

        public Criteria andToolsNotLike(String value) {
            addCriterion("tools not like", value, "tools");
            return (Criteria) this;
        }

        public Criteria andToolsIn(List<String> values) {
            addCriterion("tools in", values, "tools");
            return (Criteria) this;
        }

        public Criteria andToolsNotIn(List<String> values) {
            addCriterion("tools not in", values, "tools");
            return (Criteria) this;
        }

        public Criteria andToolsBetween(String value1, String value2) {
            addCriterion("tools between", value1, value2, "tools");
            return (Criteria) this;
        }

        public Criteria andToolsNotBetween(String value1, String value2) {
            addCriterion("tools not between", value1, value2, "tools");
            return (Criteria) this;
        }

        public Criteria andClass_contentIsNull() {
            addCriterion("class_content is null");
            return (Criteria) this;
        }

        public Criteria andClass_contentIsNotNull() {
            addCriterion("class_content is not null");
            return (Criteria) this;
        }

        public Criteria andClass_contentEqualTo(String value) {
            addCriterion("class_content =", value, "class_content");
            return (Criteria) this;
        }

        public Criteria andClass_contentNotEqualTo(String value) {
            addCriterion("class_content <>", value, "class_content");
            return (Criteria) this;
        }

        public Criteria andClass_contentGreaterThan(String value) {
            addCriterion("class_content >", value, "class_content");
            return (Criteria) this;
        }

        public Criteria andClass_contentGreaterThanOrEqualTo(String value) {
            addCriterion("class_content >=", value, "class_content");
            return (Criteria) this;
        }

        public Criteria andClass_contentLessThan(String value) {
            addCriterion("class_content <", value, "class_content");
            return (Criteria) this;
        }

        public Criteria andClass_contentLessThanOrEqualTo(String value) {
            addCriterion("class_content <=", value, "class_content");
            return (Criteria) this;
        }

        public Criteria andClass_contentLike(String value) {
            addCriterion("class_content like", value, "class_content");
            return (Criteria) this;
        }

        public Criteria andClass_contentNotLike(String value) {
            addCriterion("class_content not like", value, "class_content");
            return (Criteria) this;
        }

        public Criteria andClass_contentIn(List<String> values) {
            addCriterion("class_content in", values, "class_content");
            return (Criteria) this;
        }

        public Criteria andClass_contentNotIn(List<String> values) {
            addCriterion("class_content not in", values, "class_content");
            return (Criteria) this;
        }

        public Criteria andClass_contentBetween(String value1, String value2) {
            addCriterion("class_content between", value1, value2, "class_content");
            return (Criteria) this;
        }

        public Criteria andClass_contentNotBetween(String value1, String value2) {
            addCriterion("class_content not between", value1, value2, "class_content");
            return (Criteria) this;
        }

        public Criteria andStatuIsNull() {
            addCriterion("statu is null");
            return (Criteria) this;
        }

        public Criteria andStatuIsNotNull() {
            addCriterion("statu is not null");
            return (Criteria) this;
        }

        public Criteria andStatuEqualTo(Integer value) {
            addCriterion("statu =", value, "statu");
            return (Criteria) this;
        }

        public Criteria andStatuNotEqualTo(Integer value) {
            addCriterion("statu <>", value, "statu");
            return (Criteria) this;
        }

        public Criteria andStatuGreaterThan(Integer value) {
            addCriterion("statu >", value, "statu");
            return (Criteria) this;
        }

        public Criteria andStatuGreaterThanOrEqualTo(Integer value) {
            addCriterion("statu >=", value, "statu");
            return (Criteria) this;
        }

        public Criteria andStatuLessThan(Integer value) {
            addCriterion("statu <", value, "statu");
            return (Criteria) this;
        }

        public Criteria andStatuLessThanOrEqualTo(Integer value) {
            addCriterion("statu <=", value, "statu");
            return (Criteria) this;
        }

        public Criteria andStatuIn(List<Integer> values) {
            addCriterion("statu in", values, "statu");
            return (Criteria) this;
        }

        public Criteria andStatuNotIn(List<Integer> values) {
            addCriterion("statu not in", values, "statu");
            return (Criteria) this;
        }

        public Criteria andStatuBetween(Integer value1, Integer value2) {
            addCriterion("statu between", value1, value2, "statu");
            return (Criteria) this;
        }

        public Criteria andStatuNotBetween(Integer value1, Integer value2) {
            addCriterion("statu not between", value1, value2, "statu");
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