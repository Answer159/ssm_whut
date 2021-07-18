package cn.wmyskxz.mapper;

import cn.wmyskxz.pojo.ClassImageInfo;
import cn.wmyskxz.pojo.ClassImageInfoExample;
import java.util.List;

public interface ClassImageInfoMapper {
    int deleteByExample(ClassImageInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ClassImageInfo record);

    int insertSelective(ClassImageInfo record);

    List<ClassImageInfo> selectByExample(ClassImageInfoExample example);

    ClassImageInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ClassImageInfo record);

    int updateByPrimaryKey(ClassImageInfo record);
}