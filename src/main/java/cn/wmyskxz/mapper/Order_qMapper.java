package cn.wmyskxz.mapper;

import cn.wmyskxz.pojo.Order_q;
import cn.wmyskxz.pojo.Order_qExample;
import java.util.List;

public interface Order_qMapper {
    int deleteByExample(Order_qExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Order_q record);

    int insertSelective(Order_q record);

    List<Order_q> selectByExample(Order_qExample example);

    Order_q selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order_q record);

    int updateByPrimaryKey(Order_q record);
}