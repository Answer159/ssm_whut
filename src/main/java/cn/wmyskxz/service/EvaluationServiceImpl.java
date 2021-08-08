package cn.wmyskxz.service;
import cn.wmyskxz.pojo.Evaluation;
import cn.wmyskxz.mapper.EvaluationMapper;
import cn.wmyskxz.pojo.EvaluationExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EvaluationServiceImpl implements EvaluationService{
    @Autowired
    EvaluationMapper evaluationMapper;
    @Override
    public int add(Evaluation evaluation){
        return evaluationMapper.insert(evaluation);
    }
    @Override
    public boolean delete(int id){
        try{
            Evaluation evaluation=evaluationMapper.selectByPrimaryKey(id);
            evaluation.setClass_id(-1);
            evaluationMapper.updateByPrimaryKey(evaluation);
        }
        catch (Exception e){
            return false;
        }
        return true;
    }
    @Override
    public int update(Evaluation evaluation){
        return evaluationMapper.updateByPrimaryKey(evaluation);
    }
    @Override
    public Evaluation get(int id){
        return evaluationMapper.selectByPrimaryKey(id);
    }
    @Override
    public List<Evaluation> listByClass(int class_id){
        EvaluationExample evaluationExample=new EvaluationExample();
        evaluationExample.or().andClass_idEqualTo(class_id);
        return evaluationMapper.selectByExample(evaluationExample);
    }
}
/**
 * @Author :wzh
 * @Date :
 * @Description :
 */
