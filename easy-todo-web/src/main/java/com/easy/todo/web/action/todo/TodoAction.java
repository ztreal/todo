package com.easy.todo.web.action.todo;

import com.easy.todo.domain.context.Context;
import com.easy.todo.domain.todo.Todo;
import com.easy.todo.service.MyTodoService;
import com.easy.todo.service.UserService;
import com.easy.todo.util.other.IDGenerate;
import com.easy.todo.util.spring.BaseAction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * User: zhangtan
 * Date: 12-9-7
 * Time: 下午4:47
 */
@Controller
public class TodoAction extends BaseAction {


    @Resource
    private UserService userService;
    @Resource
    private MyTodoService myTodoService;

    private HttpServletRequest request;

    private HttpServletResponse response;

    @ModelAttribute
    public void setRequestAndResponse(HttpServletRequest request, HttpServletResponse response) {
        this.response = response;
        this.request = request;
    }

    @RequestMapping(value = "/my/addTodo", method = {RequestMethod.GET,
            RequestMethod.POST})
    @ResponseBody
    public String addTodo(@RequestParam("content") String content,@RequestParam("ctxId") String ctxId) {
        Todo todo = new Todo();
        Object userId = request.getAttribute("uid");
        if (userId == null) {
            try {
                response.sendRedirect("login");
            } catch (IOException e) {
                log.error("medthod myToDoList :response error -->", e);
            }
        }
        todo.setTodoId(IDGenerate.generateTodoID());
        todo.setContent(content);
        todo.setContextId(ctxId);
        todo.setUsrId(userId.toString());
        todo.setCreateDate(new Date());
        todo.setUpdateDate(new Date());
        myTodoService.addTodo(todo);
        return "OK";
    }


    @RequestMapping(value = "/my/delTodo", method = {RequestMethod.GET,
               RequestMethod.POST})
       @ResponseBody
       public String delTodo(@RequestParam("todoId") String todoId) {
           myTodoService.delTodo(todoId);
           return "OK";
       }

    @RequestMapping(value = "/my/my-todo-list", method = {RequestMethod.GET,
            RequestMethod.POST})
    public String myToDoList(Model model) {
        Object userId = request.getAttribute("uid");
        if (userId == null) {
            try {
                response.sendRedirect("login");
            } catch (IOException e) {
                log.error("medthod myToDoList :response error -->", e);
            }
        }
        List<Context> contextList = myTodoService.getMyContextList(userId.toString());
        model.addAttribute("contextList", contextList);
        for (Context context : contextList) {
            if (context.defaultActive) {
                List<Todo> todoList = myTodoService.getMyTodoListByCtxId(context.getId());
                model.addAttribute("todoList", todoList);
            }
        }

        return "todo-list";
    }

}
