package com.easy.todo.service;

import com.easy.todo.domain.todo.Todo;

/**
 * Created with IntelliJ IDEA.
 * User: zhangtan
 * Date: 13-7-14
 * Time: 下午11:24
 */
public interface TodoService {
    /**
       * 添加代办事项
       * @param todo
       */
      public void addTodo(Todo todo);
}
