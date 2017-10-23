package com.githing.thesis.core.manager.impl;

import com.githing.thesis.core.manager.UserManager;
import com.githing.thesis.dao.mapper.UserMapper;
import com.githing.thesis.dao.model.User;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * 用户管理实现
 *
 * @author githing <rdystwnts@126.com>
 * @date 2017/10/21
 */
@Component
public class UserManagerImpl implements UserManager {

  @Resource
  private UserMapper userMapper;

  @Override
  public Boolean addUser(User user) {
    return userMapper.insertSelective(user) > 0;
  }

  @Override
  public Boolean deleteUserById(Long id) {
    return userMapper.deleteByPrimaryKey(id) > 0;
  }

  @Override
  public Boolean updateUserById(User user) {
    return userMapper.updateByPrimaryKeySelective(user) > 0;
  }

  @Override
  public List<User> getUserListByUserName(String userName) {
    return userMapper.selectUserListByUserName(userName);
  }

  @Override
  public User getUserByUserName(String userName) {
    return userMapper.selectByUserName(userName);
  }
}
