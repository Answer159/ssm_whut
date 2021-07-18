package cn.wmyskxz.service;
import cn.wmyskxz.pojo.ClassImageInfo;

import java.util.List;
/**
 * @author 10844
 */
public interface ClassImageInfoService {
    void delete(Integer id);


    int add(ClassImageInfo classImageInfo);


    List<ClassImageInfo> list(Integer class_id);
    ClassImageInfo get(Integer id);
    void update(ClassImageInfo classImageInfo);
}
