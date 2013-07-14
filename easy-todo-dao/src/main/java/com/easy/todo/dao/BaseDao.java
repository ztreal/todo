package com.easy.todo.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * User: zhangtan
 * Date: 12-9-7
 * Time: 上午9:28
 */
public class BaseDao {
    protected MongoTemplate mongoOps;
    protected transient Log log = LogFactory.getLog(getClass());

    public MongoTemplate getMongoOps() {
        return mongoOps;
    }

    public void setMongoOps(MongoTemplate mongoOps) {
        this.mongoOps = mongoOps;
    }
}
