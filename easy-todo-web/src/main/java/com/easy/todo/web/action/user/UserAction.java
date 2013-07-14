package com.easy.todo.web.action.user;

import com.easy.todo.domain.user.User;
import com.easy.todo.service.UserService;
import com.easy.todo.util.spring.BaseAction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * User: zhangtan
 * Date: 12-9-7
 * Time: 下午4:47
 */
@Controller
public class UserAction extends BaseAction {

    @Resource
    private UserService userService;


    @RequestMapping(value = "/register", method = {RequestMethod.GET,
            RequestMethod.POST})
    @ResponseBody
    public String register(@RequestParam("email") String email, @RequestParam("password") String pwd) {
        User user = new User();
        user.setEmail(email);
        user.setPwd(pwd);
        userService.insertUser(user);
        return "toIndex";
    }

}
