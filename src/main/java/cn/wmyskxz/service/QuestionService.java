package cn.wmyskxz.service;
import cn.wmyskxz.pojo.ClassInfo;
import cn.wmyskxz.pojo.Question;
import java.util.List;
public interface QuestionService {
    /**
     * 列出提问信息
     * @return
     */
    List<Question> list();

    /**
     * 根据id获取提问信息
     * @param id
     * @return
     */
    Question get(Integer id);

    /**
     * 根据用户id获取所有提问
     * @param user_id
     * @return
     */
    List<Question> listByUser(Integer user_id);

    /**
     * 更新提问内容
     * @param question
     */
    int update(Question question);
    /**
     * 添加新的提问
     */
    int add(Question question);

    /**
     * 删除提问
     * @param id
     */
    void delete(Integer id);

    List<Question> search(String keyword);


}
