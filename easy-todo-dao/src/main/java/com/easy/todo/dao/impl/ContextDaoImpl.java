package com.easy.todo.dao.impl;

import com.easy.todo.dao.ContextDao;
import com.easy.todo.domain.context.Context;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * Created with IntelliJ IDEA.
 * User: zhangtan
 * Date: 13-8-15
 * Time: 下午2:19
 */
@Service
public class ContextDaoImpl implements ContextDao {
    @Resource
    private MongoTemplate mongoOps;

    @Override
    public void addContext(Context context){
        mongoOps.insert(context);
    }

    @Override
    public List<Context>  queryContextListByUsrId(String usrId){
        return mongoOps.find(new Query(where("userId").is(usrId)), Context.class);
    }
}