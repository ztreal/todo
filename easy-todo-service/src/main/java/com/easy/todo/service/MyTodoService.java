package com.easy.todo.service;

import com.easy.todo.domain.context.Context;
import com.easy.todo.domain.todo.Todo;

import java.util.List;

/**
 * 分类管理方法.
 * User: zhangtan
 * Date: 13-8-15
 * Time: 下午3:34
 */
public interface MyTodoService {
    List<Context> getMyContextList(String userId);

    /**
     * 添加代办事项
     *
     * @param todo
     */
    public void addTodo(Todo todo);

    /**
     * 根据上线文id获取本人的待办事项
     *
     * @param ctxId
     * @return
     */
    public List<Todo> getMyTodoListByCtxId(String ctxId);

    /**
     * 根据待办事项主键删除一个待办事项
     * @param todoId
     */
    public void delTodo(String todoId);
}
