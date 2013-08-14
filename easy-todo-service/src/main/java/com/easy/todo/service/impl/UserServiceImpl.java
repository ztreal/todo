package com.easy.todo.service.impl;

import com.easy.todo.dao.UserDao;
import com.easy.todo.domain.user.User;
import com.easy.todo.service.BaseService;
import com.easy.todo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * User: zhangtan
 * Date: 12-9-7
 * Time: 上午9:47
 */
@Service
public class UserServiceImpl  extends BaseService implements UserService{

    @Resource
    private UserDao userDao ;

    public void insertUser(User user) {
        userDao.insertUser(user);
        log.info("add user sucess!");
    }

    public void login(User user) {
        userDao.insertUser(user);
        log.info("add user sucess!");
    }
}
