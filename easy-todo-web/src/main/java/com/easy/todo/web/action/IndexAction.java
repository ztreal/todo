package com.easy.todo.web.action;

import com.easy.todo.service.UserService;
import com.easy.todo.util.spring.BaseAction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * User: zhangtan
 * Date: 12-9-7
 * Time: 下午4:47
 */
@Controller
public class IndexAction extends BaseAction {

    @Resource
    private UserService userService;


    @RequestMapping(value = "/index", method = {RequestMethod.GET,
            RequestMethod.POST})
    public ModelAndView toIndex() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        return mav;
    }

    @RequestMapping(value = "/toRegister", method = {RequestMethod.GET,
               RequestMethod.POST})
       public ModelAndView toRegister() {
           ModelAndView mav = new ModelAndView();
           mav.setViewName("register");
           return mav;
       }

    @RequestMapping(value = "/myToDoList", method = {RequestMethod.GET,
               RequestMethod.POST})
       public ModelAndView myToDoList() {
           ModelAndView mav = new ModelAndView();
           mav.setViewName("Todo-list");
           return mav;
       }



}
