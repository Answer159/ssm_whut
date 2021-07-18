package cn.wmyskxz.service;
import cn.wmyskxz.pojo.ClassInfo;
import cn.wmyskxz.pojo.ClassInfoExample;
import cn.wmyskxz.pojo.Question;
import cn.wmyskxz.mapper.QuestionMapper;
import cn.wmyskxz.pojo.QuestionExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuestionServiceImpl implements QuestionService{
    @Autowired
    QuestionMapper questionMapper;
    @Override
    public List<Question> list(){
        QuestionExample example=new QuestionExample();
        example.or().andStatuEqualTo(1);
        return questionMapper.selectByExample(example);
    }
    @Override
    public Question get(Integer id){
        return questionMapper.selectByPrimaryKey(id);
    }
    @Override
    public List<Question> listByUser(Integer user_id){
        QuestionExample example=new QuestionExample();
        example.or().andUse_idEqualTo(user_id).andStatuEqualTo(1);
        return questionMapper.selectByExample(example);
    }
    @Override
    public int update(Question question){
        return questionMapper.updateByPrimaryKey(question);
    }
    @Override
    public int add(Question question){
        return questionMapper.insert(question);
    }
    @Override
    public void delete(Integer id){
        Question question=questionMapper.selectByPrimaryKey(id);
        question.setStatu(-1);
        update(question);
    }

    @Override
    public List<Question> search(String keyword) {
        QuestionExample example=new QuestionExample();
        example.or().andTitleLike("%"+keyword+"%").andStatuEqualTo(1);
        example.setOrderByClause("id desc");
        return questionMapper.selectByExample(example);


    }
}
/**
 * @Author :wzh
 * @Date :
 * @Description :
 */
