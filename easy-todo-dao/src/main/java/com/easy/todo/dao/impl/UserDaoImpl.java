package com.easy.todo.dao.impl;

import com.easy.todo.dao.BaseDao;
import com.easy.todo.dao.UserDao;
import com.easy.todo.domain.user.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import static org.springframework.data.mongodb.core.query.Criteria.where;

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

    public User selectUserByEmail(String email) {
        return mongoOps.findOne(new Query(Criteria.where("email").is(email)), User.class);
    }

    public User selectUserByUid(String uid) {
        return mongoOps.findOne(new Query(Criteria.where("_id").is(uid)), User.class);
    }

    public User modifyUser(User user) {
        Update update = new Update();
        Query findQuery = new Query();
        if (StringUtils.isNotBlank(user.getPwd())) {
            update.set("pwd", user.getPwd());
            findQuery.addCriteria(where("pwd").is(user.getPwd()));
        }
        if (user.getHeadPic() != null) {
            update.set("headPic", user.getHeadPic());
        }

        findQuery.addCriteria(where("_id").is(user.getUserId()));
        return mongoOps.findAndModify(findQuery, update, User.class);
    }
}
