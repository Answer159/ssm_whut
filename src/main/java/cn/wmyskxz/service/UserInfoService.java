package cn.wmyskxz.service;
import cn.wmyskxz.pojo.UserInfo;
import java.util.List;
public interface UserInfoService {
    List<UserInfo> list();

    /**
     * 修改密码
     * @param id
     * @param password
     */
    void updatePassword(int id, String password);

    /**根据id获取用户
     *
     * @param id
     * @return
     */
    UserInfo get(Integer id);
    /**
     * 根据名字和密码获取用户
     */
    UserInfo get(String account, String password);

    /**
     * 根据用户名判断用户是否存在
     * @param name
     * @return
     */
    boolean isExist(String account);

    /**
     * 添加一个用户
     * @param user
     */
    int  add(UserInfo user);

    int update(UserInfo user);

    List<UserInfo> search(String keyword);
}
