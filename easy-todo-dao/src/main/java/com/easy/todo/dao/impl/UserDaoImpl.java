package com.easy.todo.dao.impl;

import com.easy.todo.dao.BaseDao;
import com.easy.todo.dao.UserDao;
import com.easy.todo.domain.user.User;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.HashMap;

/**
 * User: zhangtan
 * Date: 12-9-7
 * Time: 上午9:27
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    private MongoTemplate mongoOps;

    public void insertUser(User user) {
        mongoOps.insert(user);
    }

    public MongoTemplate getMongoOps() {
        return mongoOps;
    }

    public void setMongoOps(MongoTemplate mongoOps) {
        this.mongoOps = mongoOps;
    }
}
