package com.easy.todo.web.action.note;

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
public class NoteAction extends BaseAction {


    @Resource
    private MyTodoService myNoteService;
    private HttpServletRequest request;

    private HttpServletResponse response;

    @ModelAttribute
    public void setRequestAndResponse(HttpServletRequest request, HttpServletResponse response) {
        this.response = response;
        this.request = request;
    }



    @RequestMapping(value = "/to-note", method = {RequestMethod.GET,
            RequestMethod.POST})
    public String toNote(Model model) {
        return "note-list";
    }



}
