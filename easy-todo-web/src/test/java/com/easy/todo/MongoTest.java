package com.easy.todo;

import com.easy.todo.domain.todo.Todo;
import com.mongodb.WriteResult;
import org.junit.Test;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

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
    public void insertLog() {
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
//        Todo todo = mongoOps.findOne(new Query(where("todoId").is("TODO_52204be2c2e6ad39edacc36a1")), Todo.class);
//        log.info(todo.getTodoId());
//        System.out.println("savedLog : " + savedLog);

//      根据多条件
        Query findQuery = new Query();
        findQuery.addCriteria(where("status").is("2"));
        findQuery.addCriteria(where("contextId").is("521edebcc2e6ef694209edf4"));
        List<Todo> todoList = mongoOps.find(findQuery, Todo.class);
        log.info(todoList.size()+"----"+todoList.get(0).getTodoId());


//        修改一个值
//        WriteResult updateResult = mongoOps.updateFirst(new Query(where("todoId").is("TODO_52204be2c2e6ad39edacc36a1")),
//                Update.update("content", "1111111"), Todo.class);
//        System.out.println(updateResult.getN());

//            修改多个值
        Update update = new Update();
        update.set("content", "333333");
        update.set("status", "2");

        WriteResult updateResult2 = mongoOps.updateFirst(new Query(where("todoId").is("TODO_52204be2c2e6ad39edacc36a1")),
                update, Todo.class);
        System.out.println(updateResult2.getN());


//        System.out.println("updateResult : " + updateResult.getN());
//
//        //delete
//        mongoOps.remove(new Query(where("todoId").is("TODO_521edec6c2e6ef69ed842d202")), "todo");
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
