package com.easy.todo;

import com.easy.todo.domain.user.User;
import com.mongodb.DBCollection;
import org.junit.Test;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Created by IntelliJ IDEA.
 * User: zhangtan
 * Date: 12-7-28
 * Time: 11：19
 */
public class MongoTest extends BaseTestCase {

    private MongoTemplate mongoOps;

    @Test
    public void insertLog()  {
        User user = new User("1","1",1,1);
        mongoOps.insert(user);
//
//
//
////     mongoOps.dropCollection("person");
//
//
//        //save
        mongoOps.save(user,"userLog");
//
//        //find
//        User savedLog =  mongoOps.findOne(new Query(where("operater").is("zt")), User.class);
//
//        log.error(savedLog);
//        System.out.println("savedLog : " + savedLog);
//
//        //update
//        WriteResult updateResult =  mongoOps.updateFirst(new Query(where("operater").is("zt")),
//                Update.update("operater", "qs"), UserLog.class);
//
//
//        System.out.println("updateResult : " + updateResult.getN());
//
//        //delete
//        mongoOps.remove(new Query(where("operater").is("zt")),"userLog");
//
//        //List
        DBCollection dBCollection = mongoOps.getCollection("user");

        System.out.println("Number of user = " + dBCollection.getCount());
    }


    public MongoTemplate getMongoOps() {
        return mongoOps;
    }

    public void setMongoOps(MongoTemplate mongoOps) {
        this.mongoOps = mongoOps;
    }
}
