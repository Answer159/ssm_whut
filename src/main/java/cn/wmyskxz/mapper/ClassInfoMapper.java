package cn.wmyskxz.mapper;

import cn.wmyskxz.pojo.ClassInfo;
import cn.wmyskxz.pojo.ClassInfoExample;
import java.util.List;

public interface ClassInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ClassInfo record);

    int insertSelective(ClassInfo record);

    List<ClassInfo> selectByExample(ClassInfoExample example);

    ClassInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ClassInfo record);

    int updateByPrimaryKey(ClassInfo record);
}