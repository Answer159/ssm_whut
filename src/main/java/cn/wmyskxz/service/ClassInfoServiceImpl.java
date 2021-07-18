package cn.wmyskxz.service;
import cn.wmyskxz.mapper.ClassInfoMapper;
import cn.wmyskxz.pojo.ClassInfo;
import cn.wmyskxz.pojo.ClassInfoExample;
import cn.wmyskxz.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClassInfoServiceImpl implements ClassInfoService{
    @Autowired
    ClassInfoMapper classInfoMapper;

    @Override
    public ClassInfo get(Integer id){
        return classInfoMapper.selectByPrimaryKey(id);
    }
    @Override
    public List<ClassInfo> listByUser(Integer user_id){
        ClassInfoExample example=new ClassInfoExample();
        example.or().andUse_idEqualTo(user_id);
        return classInfoMapper.selectByExample(example);
    }
    @Override
    public int Update(ClassInfo classInfo){
        return classInfoMapper.updateByPrimaryKey(classInfo);
    }
    @Override
    public int add(ClassInfo classInfo){
        return classInfoMapper.insert(classInfo);
    }
    @Override
    public void delete(Integer id){
        ClassInfo classInfo=get(id);
        classInfo.setStatu(-1);
        Update(classInfo);
    }

    @Override
    public List<ClassInfo> listByCategory(Integer category_id) {
        ClassInfoExample example=new ClassInfoExample();
        example.or().andDomain_idEqualTo(category_id).andStatuEqualTo(0);
        return classInfoMapper.selectByExample(example);
    }

    @Override
    public List<ClassInfo> search(String keyword) {
        ClassInfoExample example=new ClassInfoExample();
        example.or().andTitleLike("%"+keyword+"%").andStatuEqualTo(0);
        example.setOrderByClause("id desc");
        return classInfoMapper.selectByExample(example);


    }
    @Override
    public List<ClassInfo> list(){
        ClassInfoExample example=new ClassInfoExample();
        example.or().andStatuEqualTo(1);
        return classInfoMapper.selectByExample(example);
    }
}
/**
 * @Author :wzh
 * @Date :
 * @Description :
 */
