package com.easy.todo.web.action;

import com.easy.todo.domain.context.Context;
import com.easy.todo.service.ContextService;
import com.easy.todo.service.TodoService;
import com.easy.todo.service.UserService;
import com.easy.todo.util.spring.BaseAction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

/**
 * User: zhangtan
 * Date: 12-9-7
 * Time: 下午4:47
 */
@Controller
public class IndexAction extends BaseAction {

    @Resource
    private UserService userService;
    @Resource
    private TodoService todoService;
    @Resource
    private ContextService contextService;

    @RequestMapping(value = "/index", method = {RequestMethod.GET,
            RequestMethod.POST})
    public String toIndex(Model model) {
        return "index";
    }

    @RequestMapping(value = "/toRegister", method = {RequestMethod.GET,
            RequestMethod.POST})
    public String toRegister(Model model) {
        return "register";
    }

    @RequestMapping(value = "/myToDoList", method = {RequestMethod.GET,
            RequestMethod.POST})
    public String myToDoList(Model model) {
        String userId = "";
        List<Context> context = contextService.getMyContextList(userId);
        model.addAttribute("context", context);
        return "Todo-list";
    }


}
