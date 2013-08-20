package com.easy.todo.service;

import com.easy.todo.domain.context.Context;

import java.util.List;

/**
 * 分类管理方法.
 * User: zhangtan
 * Date: 13-8-15
 * Time: 下午3:34
 */
public interface ContextService {
    List<Context> getMyContextList(String userId);
}
