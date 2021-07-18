package cn.wmyskxz.service;
import cn.wmyskxz.pojo.Order_;
import java.util.List;
public interface Order_Service {

    String waitUpdate = "waitUpdate";
    String waitConfirm = "waitConfirm";
    String finish = "finish";
    String delete = "delete";

    /**
     * 列出所有订单
     * @return
     */
    List<Order_> listAll();

    List<Order_> listByBuyer(Integer user_id);

    List<Order_> listBySeller(Integer user_id);

    List<Order_> listByStatus(Integer user_id,String status,String identity);

    /**
     * 根据课程id列出该课程的所有订单
     * @param class_id
     * @return
     */
    List<Order_> listByClass(Integer class_id);

    /**
     * 根据id获得一条订单
     * @param id
     * @return
     */
    Order_ get(Integer id);

    /**
     * 添加一条订单
     * @param order_
     */
    void add(Order_ order_);

    /**
     * 更新一条订单
     * @param order_
     */
    void update(Order_ order_);

    void delete(Integer id,int user_id);


    //void setStatus(Integer id,String str);
}
