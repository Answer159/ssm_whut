package cn.wmyskxz.service;

import cn.wmyskxz.pojo.Question;
import cn.wmyskxz.pojo.QuestionImageInfo;

import java.util.List;
public interface QuestionImageInfoService {
    void delete(Integer id);


    int add(QuestionImageInfo questionImageInfo);


    List<QuestionImageInfo> list(Integer question_id);
}
