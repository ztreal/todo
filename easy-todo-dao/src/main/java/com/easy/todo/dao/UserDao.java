package com.easy.todo.dao;

import com.easy.todo.domain.user.User;

/**
 * User: zhangtan
 * Date: 12-9-7
 * Time: 上午9:27
 */
public interface UserDao {

    /**
     * 增加用户
     * @param user  用户vo
     */
    public void insertUser(User user);
}
