package com.githing.thesis.core.manager;

import com.githing.thesis.dao.model.User;
import java.util.List;

/**
 * 用户管理
 *
 * @author githing <rdystwnts@126.com>
 * @date 2017/10/21
 */
public interface UserManager {

  Boolean addUser(User user);

  Boolean deleteUserById(Long id);

  Boolean updateUserById(User user);

  List<User> getUserListByUserName(String userName);

  User getUserByUserName(String userName);

}
