package com.easy.todo.web.action;

import com.easy.todo.service.MyTodoService;
import com.easy.todo.util.spring.BaseAction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * User: zhangtan
 * Date: 12-9-7
 * Time: 下午4:47
 */
@Controller
public class IndexAction extends BaseAction {


    @Resource
    private MyTodoService myTodoService;
    private HttpServletRequest request;

    private HttpServletResponse response;

    @ModelAttribute
    public void setRequestAndResponse(HttpServletRequest request, HttpServletResponse response) {
        this.response = response;
        this.request = request;
    }

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
//        try {
//            response.sendRedirect("login");
//        } catch (IOException e) {
//            log.error("to login error -->",e);
//        }
//        return null;
        return "login";
    }



}
