package com.easy.todo.web.action.todo;

import com.easy.todo.domain.todo.Todo;
import com.easy.todo.service.TodoService;
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
public class TodoAction extends BaseAction {

    @Resource
    private TodoService todoService;


    @RequestMapping(value = "/addTodo", method = {RequestMethod.GET,
            RequestMethod.POST})
    @ResponseBody
    public String addTodo(@RequestParam("content") String content) {
        Todo todo = new Todo() ;
        todo.setContent(content);
        todoService.addTodo(todo);
        return "toIndex";
    }



}
