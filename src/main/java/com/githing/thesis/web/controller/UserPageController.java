package com.githing.thesis.web.controller;

import com.githing.thesis.dao.model.User;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户控制器
 *
 * @author githing <rdystwnts@126.com>
 * @date 2017/10/20
 */
@Controller
@RequestMapping("/")
public class UserPageController {

  @RequestMapping("/register")
  public String register(@ModelAttribute User user) {
    return "register";
  }

  @RequestMapping("/index")
  public String index(Map<String, Object> model) {
    return "index";
  }

  @RequestMapping("/login")
  public String login() {
    return "login";
  }
}
