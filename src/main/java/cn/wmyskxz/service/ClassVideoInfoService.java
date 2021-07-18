package cn.wmyskxz.service;

import cn.wmyskxz.pojo.ClassImageInfo;
import cn.wmyskxz.pojo.ClassVideoInfo;

import java.util.List;

public interface ClassVideoInfoService {
    void delete(Integer id);

    int add(ClassVideoInfo classVideoInfo);

    List<ClassVideoInfo> list(Integer class_id);
    ClassVideoInfo get(Integer id);
    boolean update(ClassVideoInfo classVideoInfo);
}
