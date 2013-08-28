package com.easy.todo.dao;

import com.easy.todo.domain.todo.Todo;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhangtan
 * Date: 13-7-14
 * Time: 下午10:31
 */
public interface TodoDao {
    /**
     * 添加代办事项
     * @param todo
     */
    public void addTodo(Todo todo);

    /**
     * 根据上下文id获取待办事项列表
     * @param ctxId
     */
    public List<Todo>  listTodo(String ctxId);

}
