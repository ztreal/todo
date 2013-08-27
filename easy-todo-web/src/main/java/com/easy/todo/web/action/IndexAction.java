package com.easy.todo.web.action;

import com.easy.todo.service.TodoService;
import com.easy.todo.util.spring.BaseAction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * User: zhangtan
 * Date: 12-9-7
 * Time: 下午4:47
 */
@Controller
public class IndexAction extends BaseAction {


    @Resource
    private TodoService todoService;


    @RequestMapping(value = "/index", method = {RequestMethod.GET,
            RequestMethod.POST})
    public String toIndex(Model model) {
        return "index";
    }

    @RequestMapping(value = "/to-register", method = {RequestMethod.GET,
            RequestMethod.POST})
    public String toRegister(Model model) {
        return "register";
    }

    @RequestMapping(value = "/to-login", method = {RequestMethod.GET,
            RequestMethod.POST})
    public String toLogin(Model model) {
        return "login";
    }



}
