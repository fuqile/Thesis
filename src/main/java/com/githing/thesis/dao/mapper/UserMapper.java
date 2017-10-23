package com.githing.thesis.dao.mapper;

import com.githing.thesis.dao.model.User;
import java.util.List;

public interface UserMapper {

  int deleteByPrimaryKey(Long id);

  int insert(User record);

  int insertSelective(User record);

  User selectByPrimaryKey(Long id);

  User selectByUserName(String userName);

  List<User> selectAllUser();

  List<User> selectUserListByUserName(String userName);

  int updateByPrimaryKeySelective(User record);

  int updateByPrimaryKey(User record);
}