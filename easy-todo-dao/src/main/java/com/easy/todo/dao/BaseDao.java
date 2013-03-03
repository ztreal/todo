package com.easy.todo.dao;

import org.apache.log4j.Logger;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * User: zhangtan
 * Date: 12-9-7
 * Time: 上午9:28
 */
public class BaseDao {
    protected MongoTemplate mongoOps;
    protected Logger log = Logger.getLogger(this.getClass());

    public MongoTemplate getMongoOps() {
        return mongoOps;
    }

    public void setMongoOps(MongoTemplate mongoOps) {
        this.mongoOps = mongoOps;
    }
}
