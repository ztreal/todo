package com.easy.todo.web.action.user;

import com.easy.todo.domain.constants.TodoBaseConstants;
import com.easy.todo.domain.constants.TodoConstantsUtil;
import com.easy.todo.domain.user.User;
import com.easy.todo.service.UserService;
import com.easy.todo.util.cookie.CookieUtils;
import com.easy.todo.util.other.Md5Util;
import com.easy.todo.util.spring.BaseAction;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * User: zhangtan
 * Date: 12-9-7
 * Time: 下午4:47
 */
@Controller
public class UserAction extends BaseAction {

    @Resource
    private UserService userService;

    private HttpServletRequest request;

    private HttpServletResponse response;

    @ModelAttribute
    public void setRequestAndResponse(HttpServletRequest request, HttpServletResponse response) {
        this.response = response;
        this.request = request;
    }

    @RequestMapping(value = "/register", method = {RequestMethod.GET,
            RequestMethod.POST})
    public String register(@RequestParam("email") String email, @RequestParam("pwd") String pwd) {
        User user = new User();
        user.setEmail(email);
        String password = Md5Util.getMD5(pwd);
        user.setPwd(password);
        userService.insertUser(user);
        return "login";
    }

    @RequestMapping(value = "/login", method = {RequestMethod.GET,
            RequestMethod.POST})
    public String login(@RequestParam("email") String email, @RequestParam("password") String pwd, @RequestParam("valid") String valid, Model model) {
        List<Throwable> exceptionList = new ArrayList<Throwable>();
        //是否记住登陆
        boolean remberCookie = false;
        if(valid.equals(TodoBaseConstants.COOKIE_REMBER)){
            remberCookie = true;
        }
        User user = new User();
        user.setEmail(email);
        String password = Md5Util.getMD5(pwd);
        user.setPwd(password);
        String sid = null;
        try {
             sid = userService.login(user,remberCookie);
        } catch (Exception e) {
            log.info("login fails email = " + email);
            model.addAttribute("exceptionList", exceptionList);
        }
        if(StringUtils.isBlank(sid)){
            //生成sessionid失败处理
            log.info(" sid is null  email = " + email);
        }

        CookieUtils cookieUtils = new CookieUtils();
        cookieUtils.addEasyCookie(response, TodoConstantsUtil.domain, TodoConstantsUtil.SESSION_COOKIE_NAME, remberCookie,sid);//cookie有的效期
        try {
            response.sendRedirect("/my/my-todo-list");
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            return "index";
        }

        return null;
    }

}
