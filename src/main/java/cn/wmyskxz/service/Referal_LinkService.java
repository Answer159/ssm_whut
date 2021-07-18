package cn.wmyskxz.service;
import cn.wmyskxz.pojo.Referal_Link;
import java.util.List;
public interface Referal_LinkService {
    /**
     * 列出所有超链接
     * @return
     */
    List<Referal_Link> listAll();

    /**
     * 根据id获取超链接
     * @param id
     * @return
     */
    Referal_Link get(Integer id);

    /**
     * 删除
     * @param id
     */
    void delete(Integer id);

    /**
     * 更新
     * @param referal_link
     */
    void update(Referal_Link referal_link);

    /**
     * 新增
     * @param referal_link
     */
    void add(Referal_Link referal_link);
}
