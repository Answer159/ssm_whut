package cn.wmyskxz.pojo;

public class Question {
    private Integer id;

    private Integer domain_id;

    private String title;

    private Double price;

    private Double suggestTime;

    private String textIntro;

    private Integer use_id;

    private String front_knowledge;

    private String tools;

    private String question_content;

    private Integer statu;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDomain_id() {
        return domain_id;
    }

    public void setDomain_id(Integer domain_id) {
        this.domain_id = domain_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getSuggestTime() {
        return suggestTime;
    }

    public void setSuggestTime(Double suggestTime) {
        this.suggestTime = suggestTime;
    }

    public String getTextIntro() {
        return textIntro;
    }

    public void setTextIntro(String textIntro) {
        this.textIntro = textIntro == null ? null : textIntro.trim();
    }

    public Integer getUse_id() {
        return use_id;
    }

    public void setUse_id(Integer use_id) {
        this.use_id = use_id;
    }

    public String getFront_knowledge() {
        return front_knowledge;
    }

    public void setFront_knowledge(String front_knowledge) {
        this.front_knowledge = front_knowledge == null ? null : front_knowledge.trim();
    }

    public String getTools() {
        return tools;
    }

    public void setTools(String tools) {
        this.tools = tools == null ? null : tools.trim();
    }

    public String getQuestion_content() {
        return question_content;
    }

    public void setQuestion_content(String question_content) {
        this.question_content = question_content == null ? null : question_content.trim();
    }

    public Integer getStatu() {
        return statu;
    }

    public void setStatu(Integer statu) {
        this.statu = statu;
    }
}