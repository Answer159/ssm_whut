package cn.wmyskxz.service;
import cn.wmyskxz.mapper.QuestionVideoInfoMapper;
import cn.wmyskxz.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuestionVideoInfoServiceImpl implements QuestionVideoInfoService{
    @Autowired
    QuestionVideoInfoMapper questionVideoInfoMapper;

    @Override
    public void delete(Integer id){
        QuestionVideoInfo questionVideoInfo=get(id);
        questionVideoInfo.setStatu(-1);
        update(questionVideoInfo);

    }

    @Override
    public int add(QuestionVideoInfo questionVideoInfo){
        return questionVideoInfoMapper.insert(questionVideoInfo);
    }

    @Override
    public List<QuestionVideoInfo> list(Integer question_id){
        QuestionVideoInfoExample questionVideoInfoExample=new QuestionVideoInfoExample();
        questionVideoInfoExample.or().andQuestion_idEqualTo(question_id).andStatuEqualTo(1);
        return questionVideoInfoMapper.selectByExample(questionVideoInfoExample);
    }
    @Override
    public QuestionVideoInfo get(Integer id){
        return questionVideoInfoMapper.selectByPrimaryKey(id);
    }
    @Override
    public boolean update(QuestionVideoInfo questionVideoInfo){
        questionVideoInfoMapper.updateByPrimaryKeySelective(questionVideoInfo);
        return true;
    }
}
/**
 * @Author :wzh
 * @Date :
 * @Description :
 */
