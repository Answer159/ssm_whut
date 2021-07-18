package cn.wmyskxz.mapper;

import cn.wmyskxz.pojo.Question;
import cn.wmyskxz.pojo.QuestionExample;
import java.util.List;

public interface QuestionMapper {
    int deleteByExample(QuestionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Question record);

    int insertSelective(Question record);

    List<Question> selectByExample(QuestionExample example);

    Question selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);
}