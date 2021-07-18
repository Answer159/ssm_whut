package cn.wmyskxz.service;
import cn.wmyskxz.pojo.Order_q;
import java.util.List;

public interface Order_qService {
    String waitUpdate = "waitUpdate";
    String waitConfirm = "waitConfirm";
    String finish = "finish";
    String delete = "delete";
    List<Order_q> listAll();

    List<Order_q> listByBuyer(Integer user_id);

    List<Order_q> listBySeller(Integer user_id);

    List<Order_q> listByStatus(Integer user_id,String status,String identity);

    /**
     * 根据课程id列出该课程的所有订单
     * @param question_id
     * @return
     */
    List<Order_q> listByQuestion(Integer question_id);

    /**
     * 根据id获得一条订单
     * @param id
     * @return
     */
    Order_q get(Integer id);

    /**
     * 添加一条订单
     * @param order_
     */
    void add(Order_q order_);

    /**
     * 更新一条订单
     * @param order_
     */
    void update(Order_q order_);

    void delete(Integer id,int user_id);

}
