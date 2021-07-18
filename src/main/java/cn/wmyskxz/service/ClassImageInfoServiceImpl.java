package cn.wmyskxz.service;

import cn.wmyskxz.mapper.ClassImageInfoMapper;
import cn.wmyskxz.mapper.ClassInfoMapper;
import cn.wmyskxz.pojo.ClassImageInfo;
import cn.wmyskxz.pojo.ClassImageInfoExample;
import cn.wmyskxz.pojo.ClassInfo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 10844
 */
@Service
public class ClassImageInfoServiceImpl implements ClassImageInfoService{
    @Autowired
    ClassImageInfoMapper classImageInfoMapper;
    @Autowired
    ClassInfoMapper classInfoMapper;

    @Override
    public void delete(Integer id){
        ClassImageInfo classImageInfo=get(id);
        classImageInfo.setStatu(-1);
        update(classImageInfo);
    }

    @Override
    public int add(ClassImageInfo classImageInfo){
        return classImageInfoMapper.insert(classImageInfo);
    }
    @Override
    public List<ClassImageInfo> list(Integer class_id){
        ClassImageInfoExample classImageInfoExample=new ClassImageInfoExample();
        classImageInfoExample.or().andClassInfo_idEqualTo(class_id);
        return classImageInfoMapper.selectByExample(classImageInfoExample);
    }
    @Override
    public ClassImageInfo get(Integer id){
        return classImageInfoMapper.selectByPrimaryKey(id);
    }
    @Override
    public void update(ClassImageInfo classImageInfo){
        classImageInfoMapper.updateByPrimaryKeySelective(classImageInfo);
    }
}
/**
 * @Author :wzh
 * @Date :
 * @Description :
 */
