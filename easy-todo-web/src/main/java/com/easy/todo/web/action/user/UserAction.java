package com.easy.todo.web.action.user;

import com.easy.todo.domain.user.User;
import com.easy.todo.service.UserService;
import com.easy.todo.web.action.base.BaseAction;
import org.apache.commons.lang.xwork.StringUtils;

/**
 * User: zhangtan
 * Date: 12-9-7
 * Time: 下午4:47
 */
public class UserAction extends BaseAction {
    private String email;
    private String pwd;
    private UserService  userService;
    private String SQ_ID;

    public String register(){

       if(StringUtils.isBlank(pwd)||StringUtils.isBlank(email)){
           return ERROR;
       }
        User user = new User();
        user.setEmail(email);
        user.setPwd(pwd);
        userService.insertUser(user,SQ_ID);
       return "toIndex";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String getSQ_ID() {
        return SQ_ID;
    }

    public void setSQ_ID(String SQ_ID) {
        this.SQ_ID = SQ_ID;
    }
}
