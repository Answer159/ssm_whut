package cn.wmyskxz.service;
import cn.wmyskxz.pojo.ClassInfo;
import cn.wmyskxz.pojo.UserInfo;
import java.util.List;
/**
 * @author 10844
 */
public interface ClassInfoService {

    /**
     * 根据id获取课程
     * @param id
     * @return
     */
    ClassInfo get(Integer id);

    /**
     * 根据用户id获取所有课程
     * @param user_id
     * @return
     */
    List<ClassInfo> listByUser(Integer user_id);

    /**
     * 更新课程
     * @param classInfo
     */
    int Update(ClassInfo classInfo);
    /**
     * 添加课程
     */
    int add(ClassInfo classInfo);

    /**
     * 删除课程
     * @param id
     */
    void delete(Integer id);

    List<ClassInfo> listByCategory(Integer category_id);

    List<ClassInfo> search(String keyword);

    List<ClassInfo> list();




}
