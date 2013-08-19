package com.easy.todo.dao.impl;

import com.easy.todo.dao.BaseDao;
import com.easy.todo.dao.UserDao;
import com.easy.todo.domain.user.User;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * User: zhangtan
 * Date: 12-9-7
 * Time: 上午9:27
 */
@Service
public class UserDaoImpl extends BaseDao implements UserDao {
    @Resource
    private MongoTemplate mongoOps;

    public void insertUser(User user) {
        mongoOps.insert(user);
    }

    public User selectUserByEmail(String email){
        return   mongoOps.findOne(new Query(Criteria.where("email").is(email)), User.class);
    }
}
