package com.easy.todo;

import com.easy.todo.domain.todo.Todo;
import org.junit.Test;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import static org.springframework.data.mongodb.core.query.Criteria.where;

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
//        User user = new User("1","1",1,1);
//        mongoOps.insert(user);
//
//
//
////     mongoOps.dropCollection("person");
//
//
//        //save
//        mongoOps.save(user,"userLog");
//
//        //find
        Todo todo =  mongoOps.findOne(new Query(where("todoId").is("TODO_521edec6c2e6ef69ed842d202")), Todo.class);
         log.info(todo.getTodoId());
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
        mongoOps.remove(new Query(where("todoId").is("TODO_521edec6c2e6ef69ed842d202")), "todo");
//
//        //List
//        DBCollection dBCollection = mongoOps.getCollection("user");

//        System.out.println("Number of user = " + dBCollection.getCount());
    }


    public MongoTemplate getMongoOps() {
        return mongoOps;
    }

    public void setMongoOps(MongoTemplate mongoOps) {
        this.mongoOps = mongoOps;
    }
}
