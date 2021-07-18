package cn.wmyskxz.pojo;

import java.util.Date;

public class Comment {
    private Integer id;

    private String content;

    private Integer use_id;

    private Integer class_id;

    private Date createDate;

    private Integer question_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getUse_id() {
        return use_id;
    }

    public void setUse_id(Integer use_id) {
        this.use_id = use_id;
    }

    public Integer getClass_id() {
        return class_id;
    }

    public void setClass_id(Integer class_id) {
        this.class_id = class_id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(Integer question_id) {
        this.question_id = question_id;
    }
}