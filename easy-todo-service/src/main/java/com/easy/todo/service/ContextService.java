package com.easy.todo.service;

import com.easy.todo.domain.context.Context;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhangtan
 * Date: 13-8-15
 * Time: 下午3:34
 * To change this template use File | Settings | File Templates.
 */
public interface ContextService {
    List<Context> getMyContextList(String userId);
}
