package com.easy.todo.service;

import com.easy.todo.domain.user.User;

/**
 * User: zhangtan
 * Date: 12-9-7
 * Time: 上午9:47
 */
public interface UserService {

    /**
     * 用户注册
     * @param user
     */
    public void insertUser(User user);

    /**
     * 用户登陆
     * @param user
     */
    public String login(User user) throws Exception;
}
