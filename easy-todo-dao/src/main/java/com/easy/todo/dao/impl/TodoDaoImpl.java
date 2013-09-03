package com.easy.todo.dao.impl;

import com.easy.todo.dao.TodoDao;
import com.easy.todo.domain.enumerate.TodoStatusEnum;
import com.easy.todo.domain.todo.Todo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * 任务事项管理dao.
 * User: zhangtan
 * Date: 13-7-14
 * Time: 下午10:31
 */
@Service
public class TodoDaoImpl implements TodoDao {
    @Resource
    private MongoTemplate mongoOps;

    public void addTodo(Todo todo) {
        mongoOps.insert(todo);
    }

    @Override
    public void delTodo(Todo todo) {
        Query findQuery = new Query();
        findQuery.addCriteria(where("usrId").is(todo.getUsrId()));
        findQuery.addCriteria(where("todoId").is(todo.getTodoId()));
        mongoOps.remove(findQuery, "todo");
    }

    @Override
    public List<Todo> listTodo(Todo todo) {
        Query findQuery = new Query();
        findQuery.addCriteria(where("status").is(TodoStatusEnum.TODO_STATUS_AGENCY.getValue()));
        findQuery.addCriteria(where("contextId").is(todo.getContextId()));
        findQuery.addCriteria(where("usrId").is(todo.getUsrId()));
        return mongoOps.find(findQuery, Todo.class);
    }

    @Override
    public void modifyTodo(Todo todo) {
        Update update = new Update();
        if (StringUtils.isNotBlank(todo.getContent())) {
            update.set("content", todo.getContent());
        }
        if (todo.getStatus() != null) {
            update.set("status", todo.getStatus());
        }
        Query findQuery = new Query();
        findQuery.addCriteria(where("_id").is(todo.getUsrId()));
        findQuery.addCriteria(where("todoId").is(todo.getTodoId()));
        mongoOps.findAndModify(new Query(Criteria.where("todoId").is(todo.getTodoId())), update, Todo.class);
    }

}
