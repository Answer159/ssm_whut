package cn.wmyskxz.service;
import cn.wmyskxz.pojo.ClassVideoInfo;
import cn.wmyskxz.pojo.Question;
import cn.wmyskxz.pojo.QuestionImageInfo;
import cn.wmyskxz.pojo.QuestionVideoInfo;

import java.util.List;
public interface QuestionVideoInfoService {
    void delete(Integer id);

    int add(QuestionVideoInfo questionImageInfo);

    List<QuestionVideoInfo> list(Integer question_id);

    QuestionVideoInfo get(Integer id);

    boolean update(QuestionVideoInfo questionVideoInfo);
}
