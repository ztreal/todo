package com.easy.todo.util.other;

import com.easy.todo.domain.BaseConstant;
import com.easy.todo.domain.param.InParam;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.HashMap;

/**
 * User: zhangtan
 * Date: 12-9-7
 * Time: 上午10:04
 */
public class LogThreadLocal {
    protected static transient Log log = LogFactory.getLog(LogThreadLocal.class);
    private static final ThreadLocal threadParam = new ThreadLocal();

    public static void getParam(HashMap... paramMap) {
        InParam s = (InParam) threadParam.get();
        try {
            if (s == null && paramMap.length == 1) {
                s = new InParam(Thread.currentThread().getName(),paramMap[0].get(BaseConstant.SQ_ID).toString(),paramMap[0]);
                threadParam.set(s);
                log.info("threadLocal is null , SQ_ID =  " + paramMap[0].toString());
            } else if (s != null) {
                if (s.getSQ_ID() == null ) {
                    log.error("thread name ="+Thread.currentThread().getName()+" log SQ_ID  is null ");
                }else if (paramMap[0].get(BaseConstant.SQ_ID)==null){
                    log.info("thread name ="+Thread.currentThread().getName()+" log SQ_ID  is  " + s.getSQ_ID());
                }else {
                    s = new InParam(Thread.currentThread().getName(),paramMap[0].get(BaseConstant.SQ_ID).toString(), paramMap[0]);
                    log.info("new thread param =  thread name =" + Thread.currentThread().getName()+"SQ_ID = "+paramMap[0].get(BaseConstant.SQ_ID).toString());
                    threadParam.set(s);
                }

            } else {
                log.error("s == null and paramMap.length()= " + paramMap.length);
            }
        } catch (Exception ex) {
            log.error("Medthod:getParam  error", ex);
        }
    }
}
