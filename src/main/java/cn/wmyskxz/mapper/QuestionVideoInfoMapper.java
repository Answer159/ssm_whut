package cn.wmyskxz.mapper;

import cn.wmyskxz.pojo.QuestionVideoInfo;
import cn.wmyskxz.pojo.QuestionVideoInfoExample;
import java.util.List;

public interface QuestionVideoInfoMapper {
    int deleteByExample(QuestionVideoInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(QuestionVideoInfo record);

    int insertSelective(QuestionVideoInfo record);

    List<QuestionVideoInfo> selectByExample(QuestionVideoInfoExample example);

    QuestionVideoInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QuestionVideoInfo record);

    int updateByPrimaryKey(QuestionVideoInfo record);
}