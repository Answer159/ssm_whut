package cn.wmyskxz.service;
import cn.wmyskxz.pojo.Comment;
import java.util.List;
public interface CommentService {
    /**
     * 根据用户id获取该用户所有评论
     * @param user_id
     * @return
     */
    List<Comment> listByUser(Integer user_id);

    /**
     * 根据课程id获取该课程下的所有评论
     * @param class_id
     * @return
     */
    List<Comment> listByClass(Integer class_id);

    /**
     * 根据id删除评论
     * @param id
     */
    void delete(Integer id);

    /**
     * 添加评论
     * @param comment
     */
    void add(Comment comment);

    /**
     * 根据id得到一条评论
     * @param id
     * @return
     */
    Comment get(Integer id);

    Integer getCount(Integer product_id);

    void update(Comment comment);

    List<Comment> listByQuestion(Integer question_id);

}
