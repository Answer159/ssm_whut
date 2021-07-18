package cn.wmyskxz.service;
import cn.wmyskxz.mapper.Order_qMapper;
import cn.wmyskxz.pojo.Order_;
import cn.wmyskxz.pojo.Order_qExample;
import org.springframework.beans.factory.annotation.Autowired;
import cn.wmyskxz.pojo.Order_q;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Order_qServiceImpl implements  Order_qService{
    @Autowired
    Order_qMapper order_qmapper;

    @Override
    public List<Order_q> listAll() {
        Order_qExample example=new Order_qExample();
        return order_qmapper.selectByExample(example);
    }

    @Override
    public List<Order_q> listByBuyer(Integer user_id) {
        Order_qExample example=new Order_qExample();
        example.or().andBuyer_idEqualTo(user_id).andBuyer_statuEqualTo(0);
        return order_qmapper.selectByExample(example);
    }

    @Override
    public List<Order_q> listBySeller(Integer user_id) {
        Order_qExample example=new Order_qExample();
        example.or().andSeller_idEqualTo(user_id).andSeller_statuEqualTo(0);
        return order_qmapper.selectByExample(example);
    }

    @Override
    public List<Order_q> listByStatus(Integer user_id, String status,String identity) {
        Order_qExample example=new Order_qExample();
        if(identity=="buyer"){
            example.or().andBuyer_idEqualTo(user_id).andOrder_statusEqualTo(status).andBuyer_statuEqualTo(0);
            return order_qmapper.selectByExample(example);
        }
        else{
            example.or().andSeller_idEqualTo(user_id).andOrder_statusEqualTo(status).andSeller_statuEqualTo(0);
            return order_qmapper.selectByExample(example);
        }
    }

    @Override
    public List<Order_q> listByQuestion(Integer question_id){
        Order_qExample example=new Order_qExample();
        example.or().andQuestion_idEqualTo(question_id).andSeller_statuEqualTo(1);
        return order_qmapper.selectByExample(example);
    }
    @Override
    public Order_q get(Integer id){
        return order_qmapper.selectByPrimaryKey(id);
    }
    @Override
    public void add(Order_q order_q){
        order_qmapper.insert(order_q);
    }
    @Override
    public void update(Order_q order_q){
        order_qmapper.updateByPrimaryKey(order_q);
    }

    @Override
    public void delete(Integer id,int user_id){
        Order_q order_q=order_qmapper.selectByPrimaryKey(id);
        if(order_q.getBuyer_id()==user_id){
            order_q.setBuyer_statu(-1);
        }
        else if(order_q.getSeller_id()==user_id){
            order_q.setSeller_statu(-1);
        }
        update(order_q);
    }
}
/**
 * @Author :wzh
 * @Date :
 * @Description :
 */
