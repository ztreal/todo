package com.easy.todo.dao;

import com.easy.todo.domain.todo.Todo;

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

}
