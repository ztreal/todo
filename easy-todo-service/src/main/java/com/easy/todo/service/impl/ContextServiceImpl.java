package com.easy.todo.service.impl;

import com.easy.todo.dao.ContextDao;
import com.easy.todo.dao.TodoDao;
import com.easy.todo.domain.context.Context;
import com.easy.todo.service.BaseService;
import com.easy.todo.service.ContextService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 代办事项工具类.
 * User: zhangtan
 * Date: 13-7-14
 * Time: 下午11:24
 */
@Service
public class ContextServiceImpl extends BaseService implements  ContextService {
    @Resource
    private TodoDao todoDao;
    @Resource
    private ContextDao contextDao;




    @Override
    public List<Context> getMyContextList(String userId) {
        return contextDao.queryContextListByUsrId (userId);
    }
}
