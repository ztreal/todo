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

    /**
     * 根据邮箱查询一个用户
     * @param email
     * @return
     */
    public User selectUserByEmail(String email);

    /**
     * 修改用户资料
     * @param user
     * @return
     */
    public User modifyUser(User user);

    /**
     * 根据主键查询用户信息
     * @param uid
     * @return
     */
    public User selectUserByUid(String uid);
}
