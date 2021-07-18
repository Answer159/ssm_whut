package cn.wmyskxz.mapper;

import cn.wmyskxz.pojo.QuestionImageInfo;
import cn.wmyskxz.pojo.QuestionImageInfoExample;
import java.util.List;

public interface QuestionImageInfoMapper {
    int deleteByExample(QuestionImageInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(QuestionImageInfo record);

    int insertSelective(QuestionImageInfo record);

    List<QuestionImageInfo> selectByExample(QuestionImageInfoExample example);

    QuestionImageInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QuestionImageInfo record);

    int updateByPrimaryKey(QuestionImageInfo record);
}