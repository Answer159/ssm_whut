package cn.wmyskxz.service;
import cn.wmyskxz.pojo.Order_;
import cn.wmyskxz.mapper.Order_Mapper;
import cn.wmyskxz.pojo.Order_Example;
//import jdk.internal.org.objectweb.asm.tree.IincInsnNode;
import cn.wmyskxz.pojo.Order_q;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Order_ServiceImpl implements Order_Service{
    @Autowired
    Order_Mapper order_mapper;

    @Override
    public List<Order_> listAll() {
        Order_Example example=new Order_Example();
        return order_mapper.selectByExample(example);
    }

    @Override
    public List<Order_> listByBuyer(Integer user_id) {
        Order_Example example=new Order_Example();
        example.or().andBuyer_idEqualTo(user_id).andBuyer_statuEqualTo(1);
        return order_mapper.selectByExample(example);
    }

    @Override
    public List<Order_> listBySeller(Integer user_id) {
        Order_Example example=new Order_Example();
        example.or().andSeller_idEqualTo(user_id).andSeller_idEqualTo(1);
        return order_mapper.selectByExample(example);
    }

    @Override
    public List<Order_> listByStatus(Integer user_id, String status,String identity) {
        Order_Example example=new Order_Example();
        if(identity=="buyer"){
            example.or().andBuyer_idEqualTo(user_id).andOrder_statusEqualTo(status).andBuyer_statuEqualTo(1);
            return order_mapper.selectByExample(example);
        }
        else if(identity=="seller"){
            example.or().andSeller_idEqualTo(user_id).andOrder_statusEqualTo(status).andSeller_statuEqualTo(1);
            return order_mapper.selectByExample(example);
        }
        else{
            example.or().andOrder_statusEqualTo(status);
            return order_mapper.selectByExample(example);
        }
    }

    @Override
    public List<Order_> listByClass(Integer class_id){
        Order_Example example=new Order_Example();
        example.or().andClass_idEqualTo(class_id).andSeller_idEqualTo(1);
        return order_mapper.selectByExample(example);
    }
    @Override
    public Order_ get(Integer id){
        return order_mapper.selectByPrimaryKey(id);
    }
    @Override
    public void add(Order_ order_){
        order_mapper.insert(order_);
    }
    @Override
    public void update(Order_ order_){
        order_mapper.updateByPrimaryKey(order_);
    }

    @Override
    public void delete(Integer id,int user_id){
        Order_ order_=order_mapper.selectByPrimaryKey(id);
        if(order_.getBuyer_id()==user_id){
            order_.setBuyer_statu(-1);
        }
        else if(order_.getSeller_id()==user_id){
            order_.setSeller_statu(-1);
        }
        update(order_);
    }
//    @Override
//    public void setStatus(Integer id,String str){
//        Order_ order_=order_mapper.selectByPrimaryKey(id);
//        order_.setOrder_status(str);
//        order_mapper.updateByPrimaryKey(order_);
//    }
}
/**
 * @Author :wzh
 * @Date :
 * @Description :
 */
