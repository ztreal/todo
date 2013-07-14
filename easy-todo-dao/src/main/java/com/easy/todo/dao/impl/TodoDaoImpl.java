package com.easy.todo.dao.impl;

import com.easy.todo.dao.TodoDao;
import com.easy.todo.domain.todo.Todo;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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

    public void addTodo(Todo todo){
        mongoOps.insert(todo);
    }
}
