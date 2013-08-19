package com.easy.todo.dao;

import com.easy.todo.BaseTestCase;
import com.easy.todo.domain.context.Context;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhangtan
 * Date: 13-8-15
 * Time: 下午2:01
 */
public class ContextDaoTest extends BaseTestCase {
    @Resource
    ContextDao contextDao;

    @Test
    public void addContext(){
        Context context = new Context();
        context.setUsrId("userId");
        context.setId("id");
        context.setName("name");
        contextDao.addContext(context);
    }

    @Test
    public void selectUserByEmail(){
        List<Context> contextList = contextDao.queryContextListByUsrId("userId");
        for(Context context : contextList){
            log.info(context.getName());
        }
    }
}
