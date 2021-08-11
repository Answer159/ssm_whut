package cn.wmyskxz.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommentExample() {
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

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
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

        public Criteria andQuestion_idIsNull() {
            addCriterion("question_id is null");
            return (Criteria) this;
        }

        public Criteria andQuestion_idIsNotNull() {
            addCriterion("question_id is not null");
            return (Criteria) this;
        }

        public Criteria andQuestion_idEqualTo(Integer value) {
            addCriterion("question_id =", value, "question_id");
            return (Criteria) this;
        }

        public Criteria andQuestion_idNotEqualTo(Integer value) {
            addCriterion("question_id <>", value, "question_id");
            return (Criteria) this;
        }

        public Criteria andQuestion_idGreaterThan(Integer value) {
            addCriterion("question_id >", value, "question_id");
            return (Criteria) this;
        }

        public Criteria andQuestion_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("question_id >=", value, "question_id");
            return (Criteria) this;
        }

        public Criteria andQuestion_idLessThan(Integer value) {
            addCriterion("question_id <", value, "question_id");
            return (Criteria) this;
        }

        public Criteria andQuestion_idLessThanOrEqualTo(Integer value) {
            addCriterion("question_id <=", value, "question_id");
            return (Criteria) this;
        }

        public Criteria andQuestion_idIn(List<Integer> values) {
            addCriterion("question_id in", values, "question_id");
            return (Criteria) this;
        }

        public Criteria andQuestion_idNotIn(List<Integer> values) {
            addCriterion("question_id not in", values, "question_id");
            return (Criteria) this;
        }

        public Criteria andQuestion_idBetween(Integer value1, Integer value2) {
            addCriterion("question_id between", value1, value2, "question_id");
            return (Criteria) this;
        }

        public Criteria andQuestion_idNotBetween(Integer value1, Integer value2) {
            addCriterion("question_id not between", value1, value2, "question_id");
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

        public Criteria andReplayNumIsNull() {
            addCriterion("replayNum is null");
            return (Criteria) this;
        }

        public Criteria andReplayNumIsNotNull() {
            addCriterion("replayNum is not null");
            return (Criteria) this;
        }

        public Criteria andReplayNumEqualTo(Integer value) {
            addCriterion("replayNum =", value, "replayNum");
            return (Criteria) this;
        }

        public Criteria andReplayNumNotEqualTo(Integer value) {
            addCriterion("replayNum <>", value, "replayNum");
            return (Criteria) this;
        }

        public Criteria andReplayNumGreaterThan(Integer value) {
            addCriterion("replayNum >", value, "replayNum");
            return (Criteria) this;
        }

        public Criteria andReplayNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("replayNum >=", value, "replayNum");
            return (Criteria) this;
        }

        public Criteria andReplayNumLessThan(Integer value) {
            addCriterion("replayNum <", value, "replayNum");
            return (Criteria) this;
        }

        public Criteria andReplayNumLessThanOrEqualTo(Integer value) {
            addCriterion("replayNum <=", value, "replayNum");
            return (Criteria) this;
        }

        public Criteria andReplayNumIn(List<Integer> values) {
            addCriterion("replayNum in", values, "replayNum");
            return (Criteria) this;
        }

        public Criteria andReplayNumNotIn(List<Integer> values) {
            addCriterion("replayNum not in", values, "replayNum");
            return (Criteria) this;
        }

        public Criteria andReplayNumBetween(Integer value1, Integer value2) {
            addCriterion("replayNum between", value1, value2, "replayNum");
            return (Criteria) this;
        }

        public Criteria andReplayNumNotBetween(Integer value1, Integer value2) {
            addCriterion("replayNum not between", value1, value2, "replayNum");
            return (Criteria) this;
        }

        public Criteria andReplay_idIsNull() {
            addCriterion("replay_id is null");
            return (Criteria) this;
        }

        public Criteria andReplay_idIsNotNull() {
            addCriterion("replay_id is not null");
            return (Criteria) this;
        }

        public Criteria andReplay_idEqualTo(Integer value) {
            addCriterion("replay_id =", value, "replay_id");
            return (Criteria) this;
        }

        public Criteria andReplay_idNotEqualTo(Integer value) {
            addCriterion("replay_id <>", value, "replay_id");
            return (Criteria) this;
        }

        public Criteria andReplay_idGreaterThan(Integer value) {
            addCriterion("replay_id >", value, "replay_id");
            return (Criteria) this;
        }

        public Criteria andReplay_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("replay_id >=", value, "replay_id");
            return (Criteria) this;
        }

        public Criteria andReplay_idLessThan(Integer value) {
            addCriterion("replay_id <", value, "replay_id");
            return (Criteria) this;
        }

        public Criteria andReplay_idLessThanOrEqualTo(Integer value) {
            addCriterion("replay_id <=", value, "replay_id");
            return (Criteria) this;
        }

        public Criteria andReplay_idIn(List<Integer> values) {
            addCriterion("replay_id in", values, "replay_id");
            return (Criteria) this;
        }

        public Criteria andReplay_idNotIn(List<Integer> values) {
            addCriterion("replay_id not in", values, "replay_id");
            return (Criteria) this;
        }

        public Criteria andReplay_idBetween(Integer value1, Integer value2) {
            addCriterion("replay_id between", value1, value2, "replay_id");
            return (Criteria) this;
        }

        public Criteria andReplay_idNotBetween(Integer value1, Integer value2) {
            addCriterion("replay_id not between", value1, value2, "replay_id");
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