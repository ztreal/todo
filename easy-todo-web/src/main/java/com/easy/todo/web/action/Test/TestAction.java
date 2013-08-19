package com.easy.todo.web.action.Test;

import com.easy.todo.util.cookie.CookieUtils;
import com.easy.todo.util.spring.BaseAction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 测试servlet.
 * User: zhangtan
 * Date: 13-8-14
 * Time: 上午9:57
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class TestAction extends BaseAction {


     private HttpServletRequest request;

    private HttpServletResponse  response;

    @ModelAttribute
    public void setRequestAndResponse(HttpServletRequest request,HttpServletResponse response){
        this.response = response;
        this.request = request;
    }

    //http://localhost:8080/testAddCookie?value=abcd
    @RequestMapping(value = "/testAddCookie", method = {RequestMethod.GET,
            RequestMethod.POST})
    @ResponseBody
    public String register(@RequestParam("value") String value) {
        CookieUtils cookieUtils = new CookieUtils();
        cookieUtils.addEasyCookie(response, "localhost","test",300000,value);//cookie有的效期


        return "ok";
    }

}