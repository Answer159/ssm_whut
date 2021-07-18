package cn.wmyskxz.pojo;

import java.util.Date;

public class Order_q {
    private Integer id;

    private String order_status;

    private Integer buyer_id;

    private Integer seller_id;

    private Integer question_id;

    private Date createDate;

    private Double price;

    private Double suggestTime;

    private Integer buyer_statu;

    private Integer seller_statu;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status == null ? null : order_status.trim();
    }

    public Integer getBuyer_id() {
        return buyer_id;
    }

    public void setBuyer_id(Integer buyer_id) {
        this.buyer_id = buyer_id;
    }

    public Integer getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(Integer seller_id) {
        this.seller_id = seller_id;
    }

    public Integer getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(Integer question_id) {
        this.question_id = question_id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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

    public Integer getBuyer_statu() {
        return buyer_statu;
    }

    public void setBuyer_statu(Integer buyer_statu) {
        this.buyer_statu = buyer_statu;
    }

    public Integer getSeller_statu() {
        return seller_statu;
    }

    public void setSeller_statu(Integer seller_statu) {
        this.seller_statu = seller_statu;
    }
}