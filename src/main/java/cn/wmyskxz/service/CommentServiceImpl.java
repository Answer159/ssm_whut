package cn.wmyskxz.service;
import cn.wmyskxz.pojo.Comment;
import cn.wmyskxz.mapper.CommentMapper;
import cn.wmyskxz.pojo.CommentExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    CommentMapper commentMapper;
    @Override
    public List<Comment> listByUser(Integer user_id){
        CommentExample example=new CommentExample();
        example.or().andUse_idEqualTo(user_id);
        return commentMapper.selectByExample(example);
    }
    @Override
    public List<Comment> listByClass(Integer class_id){
        CommentExample example=new CommentExample();
        example.or().andClass_idEqualTo(class_id);
        return commentMapper.selectByExample(example);
    }
    @Override
    public void delete(Integer id){
        Comment comment=get(id);
        comment.setQuestion_id(-1);
        comment.setClass_id(-1);
        update(comment);

    }
    @Override
    public void add(Comment comment){
        commentMapper.insert(comment);
    }
    @Override
    public Comment get(Integer id){
        return commentMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer getCount(Integer product_id) {
        return listByClass(product_id).size();
    }

    @Override
    public void update(Comment comment) {
        commentMapper.updateByPrimaryKeySelective(comment);

    }
    @Override
    public List<Comment> listByQuestion(Integer question_id){
        CommentExample example=new CommentExample();
        example.or().andQuestion_idEqualTo(question_id);
        return commentMapper.selectByExample(example);
    }
}
/**
 * @Author :wzh
 * @Date :
 * @Description :
 */
