package cn.wmyskxz.service;
import cn.wmyskxz.pojo.Referal_Link;
import java.util.List;
import cn.wmyskxz.mapper.Referal_LinkMapper;
import cn.wmyskxz.pojo.Referal_LinkExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Referal_LinkServiceImpl implements Referal_LinkService{
    @Autowired
    Referal_LinkMapper referal_linkMapper;
    @Override
    public List<Referal_Link> listAll(){
        Referal_LinkExample example=new Referal_LinkExample();
        return referal_linkMapper.selectByExample(example);
    }
    @Override
    public Referal_Link get(Integer id){
        return referal_linkMapper.selectByPrimaryKey(id);
    }
    @Override
    public void delete(Integer id){
        referal_linkMapper.deleteByPrimaryKey(id);
    }
    @Override
    public void update(Referal_Link referal_link){
        referal_linkMapper.updateByPrimaryKey(referal_link);
    }
    @Override
    public void add(Referal_Link referal_link){
        referal_linkMapper.insert(referal_link);
    }
}
/**
 * @Author :wzh
 * @Date :
 * @Description :
 */
