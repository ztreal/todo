package com.easy.todo.dao;

import com.easy.todo.BaseTestCase;
import com.easy.todo.domain.user.User;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: zhangtan
 * Date: 13-8-15
 * Time: 下午2:01
 */
public class UserDaoTest extends BaseTestCase {
    @Resource
    UserDao userDao;

    @Test
    public void addUser() {
        User user = new User();
        user.setEmail("a@sina.com");
         userDao.insertUser(user);
        System.out.println(user.toString());
    }

    @Test
    public void selectUserByEmail() {
        User user = userDao.selectUserByEmail("a@sina.com");
        System.out.println(user.toString());
    }


}
