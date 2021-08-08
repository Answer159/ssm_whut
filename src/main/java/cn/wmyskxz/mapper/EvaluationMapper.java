package cn.wmyskxz.mapper;

import cn.wmyskxz.pojo.Evaluation;
import cn.wmyskxz.pojo.EvaluationExample;
import java.util.List;

public interface EvaluationMapper {
    int deleteByExample(EvaluationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Evaluation record);

    int insertSelective(Evaluation record);

    List<Evaluation> selectByExampleWithBLOBs(EvaluationExample example);

    List<Evaluation> selectByExample(EvaluationExample example);

    Evaluation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Evaluation record);

    int updateByPrimaryKeyWithBLOBs(Evaluation record);

    int updateByPrimaryKey(Evaluation record);
}