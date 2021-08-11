package cn.wmyskxz.pojo;

public class UserInfo {
    private Integer id;

    private String account;

    private String username;

    private String password;

    private Integer graghId;

    private String selfIntro;

    private String phone;

    private String collection_class;

    private String collection_question;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getSelfIntro() {
        return selfIntro;
    }

    public void setSelfIntro(String selfIntro) {
        this.selfIntro = selfIntro == null ? null : selfIntro.trim();
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
}