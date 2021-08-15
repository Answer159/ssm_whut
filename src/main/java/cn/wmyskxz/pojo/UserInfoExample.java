package cn.wmyskxz.pojo;

import java.util.ArrayList;
import java.util.List;

public class UserInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserInfoExample() {
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

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(Integer value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(Integer value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(Integer value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(Integer value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(Integer value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<Integer> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<Integer> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(Integer value1, Integer value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(Integer value1, Integer value2) {
            addCriterion("sex not between", value1, value2, "sex");
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

        public Criteria andAccountIsNull() {
            addCriterion("account is null");
            return (Criteria) this;
        }

        public Criteria andAccountIsNotNull() {
            addCriterion("account is not null");
            return (Criteria) this;
        }

        public Criteria andAccountEqualTo(String value) {
            addCriterion("account =", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotEqualTo(String value) {
            addCriterion("account <>", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThan(String value) {
            addCriterion("account >", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThanOrEqualTo(String value) {
            addCriterion("account >=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThan(String value) {
            addCriterion("account <", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThanOrEqualTo(String value) {
            addCriterion("account <=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLike(String value) {
            addCriterion("account like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotLike(String value) {
            addCriterion("account not like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountIn(List<String> values) {
            addCriterion("account in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotIn(List<String> values) {
            addCriterion("account not in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountBetween(String value1, String value2) {
            addCriterion("account between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotBetween(String value1, String value2) {
            addCriterion("account not between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andGraghIdIsNull() {
            addCriterion("graghId is null");
            return (Criteria) this;
        }

        public Criteria andGraghIdIsNotNull() {
            addCriterion("graghId is not null");
            return (Criteria) this;
        }

        public Criteria andGraghIdEqualTo(String value) {
            addCriterion("graghId =", value, "graghId");
            return (Criteria) this;
        }

        public Criteria andGraghIdNotEqualTo(String value) {
            addCriterion("graghId <>", value, "graghId");
            return (Criteria) this;
        }

        public Criteria andGraghIdGreaterThan(String value) {
            addCriterion("graghId >", value, "graghId");
            return (Criteria) this;
        }

        public Criteria andGraghIdGreaterThanOrEqualTo(String value) {
            addCriterion("graghId >=", value, "graghId");
            return (Criteria) this;
        }

        public Criteria andGraghIdLessThan(String value) {
            addCriterion("graghId <", value, "graghId");
            return (Criteria) this;
        }

        public Criteria andGraghIdLessThanOrEqualTo(String value) {
            addCriterion("graghId <=", value, "graghId");
            return (Criteria) this;
        }

        public Criteria andGraghIdLike(String value) {
            addCriterion("graghId like", value, "graghId");
            return (Criteria) this;
        }

        public Criteria andGraghIdNotLike(String value) {
            addCriterion("graghId not like", value, "graghId");
            return (Criteria) this;
        }

        public Criteria andGraghIdIn(List<String> values) {
            addCriterion("graghId in", values, "graghId");
            return (Criteria) this;
        }

        public Criteria andGraghIdNotIn(List<String> values) {
            addCriterion("graghId not in", values, "graghId");
            return (Criteria) this;
        }

        public Criteria andGraghIdBetween(String value1, String value2) {
            addCriterion("graghId between", value1, value2, "graghId");
            return (Criteria) this;
        }

        public Criteria andGraghIdNotBetween(String value1, String value2) {
            addCriterion("graghId not between", value1, value2, "graghId");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andCollection_classIsNull() {
            addCriterion("collection_class is null");
            return (Criteria) this;
        }

        public Criteria andCollection_classIsNotNull() {
            addCriterion("collection_class is not null");
            return (Criteria) this;
        }

        public Criteria andCollection_classEqualTo(String value) {
            addCriterion("collection_class =", value, "collection_class");
            return (Criteria) this;
        }

        public Criteria andCollection_classNotEqualTo(String value) {
            addCriterion("collection_class <>", value, "collection_class");
            return (Criteria) this;
        }

        public Criteria andCollection_classGreaterThan(String value) {
            addCriterion("collection_class >", value, "collection_class");
            return (Criteria) this;
        }

        public Criteria andCollection_classGreaterThanOrEqualTo(String value) {
            addCriterion("collection_class >=", value, "collection_class");
            return (Criteria) this;
        }

        public Criteria andCollection_classLessThan(String value) {
            addCriterion("collection_class <", value, "collection_class");
            return (Criteria) this;
        }

        public Criteria andCollection_classLessThanOrEqualTo(String value) {
            addCriterion("collection_class <=", value, "collection_class");
            return (Criteria) this;
        }

        public Criteria andCollection_classLike(String value) {
            addCriterion("collection_class like", value, "collection_class");
            return (Criteria) this;
        }

        public Criteria andCollection_classNotLike(String value) {
            addCriterion("collection_class not like", value, "collection_class");
            return (Criteria) this;
        }

        public Criteria andCollection_classIn(List<String> values) {
            addCriterion("collection_class in", values, "collection_class");
            return (Criteria) this;
        }

        public Criteria andCollection_classNotIn(List<String> values) {
            addCriterion("collection_class not in", values, "collection_class");
            return (Criteria) this;
        }

        public Criteria andCollection_classBetween(String value1, String value2) {
            addCriterion("collection_class between", value1, value2, "collection_class");
            return (Criteria) this;
        }

        public Criteria andCollection_classNotBetween(String value1, String value2) {
            addCriterion("collection_class not between", value1, value2, "collection_class");
            return (Criteria) this;
        }

        public Criteria andCollection_questionIsNull() {
            addCriterion("collection_question is null");
            return (Criteria) this;
        }

        public Criteria andCollection_questionIsNotNull() {
            addCriterion("collection_question is not null");
            return (Criteria) this;
        }

        public Criteria andCollection_questionEqualTo(String value) {
            addCriterion("collection_question =", value, "collection_question");
            return (Criteria) this;
        }

        public Criteria andCollection_questionNotEqualTo(String value) {
            addCriterion("collection_question <>", value, "collection_question");
            return (Criteria) this;
        }

        public Criteria andCollection_questionGreaterThan(String value) {
            addCriterion("collection_question >", value, "collection_question");
            return (Criteria) this;
        }

        public Criteria andCollection_questionGreaterThanOrEqualTo(String value) {
            addCriterion("collection_question >=", value, "collection_question");
            return (Criteria) this;
        }

        public Criteria andCollection_questionLessThan(String value) {
            addCriterion("collection_question <", value, "collection_question");
            return (Criteria) this;
        }

        public Criteria andCollection_questionLessThanOrEqualTo(String value) {
            addCriterion("collection_question <=", value, "collection_question");
            return (Criteria) this;
        }

        public Criteria andCollection_questionLike(String value) {
            addCriterion("collection_question like", value, "collection_question");
            return (Criteria) this;
        }

        public Criteria andCollection_questionNotLike(String value) {
            addCriterion("collection_question not like", value, "collection_question");
            return (Criteria) this;
        }

        public Criteria andCollection_questionIn(List<String> values) {
            addCriterion("collection_question in", values, "collection_question");
            return (Criteria) this;
        }

        public Criteria andCollection_questionNotIn(List<String> values) {
            addCriterion("collection_question not in", values, "collection_question");
            return (Criteria) this;
        }

        public Criteria andCollection_questionBetween(String value1, String value2) {
            addCriterion("collection_question between", value1, value2, "collection_question");
            return (Criteria) this;
        }

        public Criteria andCollection_questionNotBetween(String value1, String value2) {
            addCriterion("collection_question not between", value1, value2, "collection_question");
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