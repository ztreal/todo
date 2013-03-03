package com.easy.todo.manager.impl;

import com.easy.todo.dao.UserDao;
import com.easy.todo.manager.BaseManager;
import com.easy.todo.manager.UserManager;
import com.easy.todo.domain.user.User;

/**
 * User: zhangtan
 * Date: 12-9-7
 * Time: 上午9:41
 */
public class UserManagerImpl extends BaseManager implements UserManager {

    private UserDao userDao;

    public void insertUser(User user){
        userDao.insertUser(user);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
