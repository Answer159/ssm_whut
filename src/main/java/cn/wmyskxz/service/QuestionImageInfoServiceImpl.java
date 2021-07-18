package cn.wmyskxz.service;
import cn.wmyskxz.mapper.QuestionImageInfoMapper;
import cn.wmyskxz.pojo.QuestionImageInfoExample;
import cn.wmyskxz.pojo.QuestionImageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuestionImageInfoServiceImpl implements QuestionImageInfoService{
    @Autowired
    QuestionImageInfoMapper questionImageInfoMapper;

    @Override
    public void delete(Integer id){
        QuestionImageInfo questionImageInfo=questionImageInfoMapper.selectByPrimaryKey(id);
        questionImageInfo.setStatu(-1);
        questionImageInfoMapper.updateByPrimaryKey(questionImageInfo);
    }

    @Override
    public int add(QuestionImageInfo questionImageInfo){
        return questionImageInfoMapper.insert(questionImageInfo);

    }

    @Override
    public List<QuestionImageInfo> list(Integer question_id){
        QuestionImageInfoExample questionImageInfoExample=new QuestionImageInfoExample();
        questionImageInfoExample.or().andQuestion_idEqualTo(question_id).andStatuEqualTo(1);
        return questionImageInfoMapper.selectByExample(questionImageInfoExample);
    }
}
/**
 * @Author :wzh
 * @Date :
 * @Description :
 */
