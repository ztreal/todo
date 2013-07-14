package com.easy.todo.service.impl;

import com.easy.todo.dao.TodoDao;
import com.easy.todo.domain.todo.Todo;
import com.easy.todo.service.BaseService;
import com.easy.todo.service.TodoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 代办事项工具类.
 * User: zhangtan
 * Date: 13-7-14
 * Time: 下午11:24
 */
@Service
public class TodoServiceImpl extends BaseService implements TodoService {
    @Resource
    private TodoDao todoDao;


    @Override
    public void addTodo(Todo todo) {
        todoDao.addTodo(todo);
        log.info("add user sucess!");
    }
}
