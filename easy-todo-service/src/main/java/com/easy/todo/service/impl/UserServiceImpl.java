package com.easy.todo.service.impl;

import com.easy.todo.manager.UserManager;
import com.easy.todo.service.BaseService;
import com.easy.todo.service.UserService;
import com.easy.todo.domain.user.User;

/**
 * User: zhangtan
 * Date: 12-9-7
 * Time: 上午9:47
 */
public class UserServiceImpl  extends BaseService implements UserService{

    private UserManager userManager ;

    public void insertUser(User user,String SQ_ID) {
        userManager.insertUser(user);
        log.info("add user sucess!");
    }

    public UserManager getUserManager() {
        return userManager;
    }

    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }
}
