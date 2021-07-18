package cn.wmyskxz.mapper;

import cn.wmyskxz.pojo.ClassVideoInfo;
import cn.wmyskxz.pojo.ClassVideoInfoExample;
import java.util.List;

public interface ClassVideoInfoMapper {
    int deleteByExample(ClassVideoInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ClassVideoInfo record);

    int insertSelective(ClassVideoInfo record);

    List<ClassVideoInfo> selectByExample(ClassVideoInfoExample example);

    ClassVideoInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ClassVideoInfo record);

    int updateByPrimaryKey(ClassVideoInfo record);
}