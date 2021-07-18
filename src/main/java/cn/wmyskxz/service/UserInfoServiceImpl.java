package cn.wmyskxz.service;
import cn.wmyskxz.mapper.UserInfoMapper;
import cn.wmyskxz.pojo.UserInfo;
import cn.wmyskxz.pojo.UserInfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserInfoServiceImpl implements UserInfoService{
    @Autowired
    UserInfoMapper userInfoMapper;
    @Override
    public List<UserInfo> list() {
        UserInfoExample example = new UserInfoExample();
        return userInfoMapper.selectByExample(example);
    }
    @Override
    public void updatePassword(int id, String password) {
        UserInfo user = get(id);
        user.setPassword(password);
        userInfoMapper.updateByPrimaryKey(user);
    }
    @Override
    public UserInfo get(Integer id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }
    @Override
    public UserInfo get(String account, String password) {
        UserInfoExample example = new UserInfoExample();
        example.or().andAccountEqualTo(account).andPasswordEqualTo(password);
        List<UserInfo> result = userInfoMapper.selectByExample(example);
        if (result.isEmpty()) {
            return null;
        }
        return result.get(0);
    }
    @Override
    public boolean isExist(String account) {
        UserInfoExample example =new UserInfoExample();
        example.or().andAccountEqualTo(account);
        List<UserInfo> result= userInfoMapper.selectByExample(example);
        if(!result.isEmpty())
            return true;
        return false;
    }

    @Override
    public int add(UserInfo user) {
        return userInfoMapper.insert(user);
    }
    @Override
    public int update(UserInfo userInfo){
        return userInfoMapper.updateByPrimaryKey(userInfo);
    }
}
/**
 * @Author :wzh
 * @Date :
 * @Description :
 */
