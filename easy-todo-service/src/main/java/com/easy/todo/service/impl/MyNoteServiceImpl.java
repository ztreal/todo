package com.easy.todo.service.impl;

import com.easy.todo.dao.ContextDao;
import com.easy.todo.dao.TodoDao;
import com.easy.todo.domain.constants.TodoBaseConstants;
import com.easy.todo.domain.context.Context;
import com.easy.todo.domain.todo.Todo;
import com.easy.todo.service.BaseService;
import com.easy.todo.service.MyNoteService;
import com.easy.todo.util.other.IDGenerate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 代办事项工具类.
 * User: zhangtan
 * Date: 13-7-14
 * Time: 下午11:24
 */
@Service
public class MyNoteServiceImpl extends BaseService implements MyNoteService {
    @Resource
    private TodoDao todoDao;
    @Resource
    private ContextDao contextDao;


    @Override
    public List<Context> getMyContextList(String userId) {
        List<Context> contextList = contextDao.queryContextListByUsrId(userId);
        if (contextList == null || contextList.size() == 0) {
            contextList = new ArrayList<Context>();
            Context context = new Context();
            context.setName(TodoBaseConstants.DEFAULT_CONTEXT);
            context.setParaentId(IDGenerate.generateContextID());
            context.setUsrId(userId);
            context.setCreateDate(new Date());
            context.setUpdateDate(new Date());
            context.setDefaultActive(true);
            contextDao.addContext(context);
            contextList.add(context);
        }
        return contextDao.queryContextListByUsrId(userId);
    }

    @Override
    public void addTodo(Todo todo) {
        todoDao.addTodo(todo);
        log.info("add Todo sucess!");
    }

    @Override
    public List<Todo> getMyTodoListByCtxId(Todo todo) {
        return todoDao.listTodo(todo);
    }

    @Override
    public void delTodo(Todo todo ){
        todoDao.delTodo(todo);
    }

    @Override
      public void modifyTodo(Todo todo){

          todoDao.modifyTodo(todo);
      }
}
