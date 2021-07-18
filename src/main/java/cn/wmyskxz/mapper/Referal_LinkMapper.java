package cn.wmyskxz.mapper;

import cn.wmyskxz.pojo.Referal_Link;
import cn.wmyskxz.pojo.Referal_LinkExample;
import java.util.List;

public interface Referal_LinkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Referal_Link record);

    int insertSelective(Referal_Link record);

    List<Referal_Link> selectByExample(Referal_LinkExample example);

    Referal_Link selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Referal_Link record);

    int updateByPrimaryKey(Referal_Link record);
}