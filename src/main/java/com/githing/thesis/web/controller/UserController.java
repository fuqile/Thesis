package com.githing.thesis.web.controller;

import com.githing.thesis.common.result.RestResult;
import com.githing.thesis.core.manager.UserManager;
import com.githing.thesis.dao.model.User;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;

/**
 * 用户控制器
 *
 * @author githing <rdystwnts@126.com>
 * @date 2017/10/20
 */
@RestController
@RequestMapping("/user")
public class UserController {

  @Resource
  private UserManager userManager;

  /**
   * 添加新用户
   *
   * @param user 用户数据对象
   * @return 是否添加成功
   */
  @RequestMapping(value = "/register", method = RequestMethod.POST)
  public RestResult<Boolean> register(@RequestBody User user) {
    return new RestResult<>(userManager.addUser(user));
  }

  /**
   * 更新用户信息
   *
   * @param user 用户数据对象
   * @return 是否更新成功
   */
  @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
  public RestResult<Boolean> updateUser(@RequestBody User user) {
    return new RestResult<>(userManager.updateUserById(user));
  }

  /**
   * 删除用户信息
   *
   * @param id 用户id
   * @return 是否删除成功
   */
  @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
  public RestResult<Boolean> deleteUser(@RequestParam("id") Long id) {
    return new RestResult<>(userManager.deleteUserById(id));
  }

  /**
   * 获取所有用户数据
   *
   * @return 所有用户数据
   */
  @RequestMapping(value = "/queryUserListByUserName")
  public RestResult<List<User>> queryUserListByUserName(@RequestParam("userName") String userName) {
    return new RestResult<>(userManager.getUserListByUserName(userName));
  }

  /**
   * 登录
   *
   * @param userName 用户名
   * @param password 密码
   */
  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public RestResult<Boolean> login(@RequestParam("userName") String userName,
      @RequestParam("password") String password) {
    RestResult<Boolean> restResult = new RestResult<>(true);
    User user = userManager.getUserByUserName(userName);
    if (user == null) {
      restResult.setMessage("用户不存在");
      restResult.setResultData(false);
      return restResult;
    }
    if (!StringUtils.equals(user.getPassword(), password)) {
      restResult.setMessage("密码不正确");
      restResult.setResultData(false);
      return restResult;
    }
    return restResult;
  }

  @RequestMapping(value = "/checkUserExist", method = RequestMethod.POST)
  public RestResult<Boolean> checkUserExist(@RequestParam("userName") String userName) {
    User user = userManager.getUserByUserName(userName);
    return new RestResult<>(user != null);
  }
}
