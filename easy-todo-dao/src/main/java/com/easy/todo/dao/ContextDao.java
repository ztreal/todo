package com.easy.todo.dao;

import com.easy.todo.domain.context.Context;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhangtan
 * Date: 13-8-15
 * Time: 下午2:29
 */
public interface ContextDao {
    /**
     * 添加目录类别
     * @param context
     */
    void addContext(Context context);

    /**
     * 查询用户所属的所有一级context
     * @param usrId
     * @return
     */
    public List<Context> queryContextListByUsrId(String usrId);
}
