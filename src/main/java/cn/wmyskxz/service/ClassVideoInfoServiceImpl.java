package cn.wmyskxz.service;

import cn.wmyskxz.mapper.ClassVideoInfoMapper;
import cn.wmyskxz.pojo.ClassVideoInfo;
import cn.wmyskxz.pojo.ClassVideoInfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClassVideoInfoServiceImpl implements ClassVideoInfoService {
    @Autowired
    ClassVideoInfoMapper classVideoInfoMapper;

    @Override
    public void delete(Integer id){
        ClassVideoInfo classVideoInfo=get(id);
        classVideoInfo.setStatu(-1);
        update(classVideoInfo);
    }
    @Override
    public int add(ClassVideoInfo classVideoInfo){
        return classVideoInfoMapper.insert(classVideoInfo);
    }

    @Override
    public List<ClassVideoInfo> list(Integer class_id){
        ClassVideoInfoExample classVideoInfoExample=new ClassVideoInfoExample();
        classVideoInfoExample.or().andClassInfo_idEqualTo(class_id).andStatuEqualTo(1);
        return classVideoInfoMapper.selectByExample(classVideoInfoExample);
    }
    @Override
    public ClassVideoInfo get(Integer id){
        return classVideoInfoMapper.selectByPrimaryKey(id);
    }
    @Override
    public boolean update(ClassVideoInfo classVideoInfo){
        classVideoInfoMapper.updateByPrimaryKeySelective(classVideoInfo);
        return true;
    }
}
/**
 * @Author :wzh
 * @Date :
 * @Description :
 */
