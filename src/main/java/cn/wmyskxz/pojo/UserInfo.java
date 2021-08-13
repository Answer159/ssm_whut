package cn.wmyskxz.pojo;

public class UserInfo {
    private Integer id;

    private Integer sex;

    private Integer domain_id;

    private String account;

    private String username;

    private String password;

    private Integer graghId;

    private String phone;

    private String collection_class;

    private String collection_question;

    private String selfIntro;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getDomain_id() {
        return domain_id;
    }

    public void setDomain_id(Integer domain_id) {
        this.domain_id = domain_id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getGraghId() {
        return graghId;
    }

    public void setGraghId(Integer graghId) {
        this.graghId = graghId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getCollection_class() {
        return collection_class;
    }

    public void setCollection_class(String collection_class) {
        this.collection_class = collection_class == null ? null : collection_class.trim();
    }

    public String getCollection_question() {
        return collection_question;
    }

    public void setCollection_question(String collection_question) {
        this.collection_question = collection_question == null ? null : collection_question.trim();
    }

    public String getSelfIntro() {
        return selfIntro;
    }

    public void setSelfIntro(String selfIntro) {
        this.selfIntro = selfIntro == null ? null : selfIntro.trim();
    }
}