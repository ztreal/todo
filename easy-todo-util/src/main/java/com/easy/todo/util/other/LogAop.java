package com.easy.todo.util.other;

import com.easy.todo.domain.BaseConstant;
import com.easy.todo.domain.user.User;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Arrays;
import java.util.HashMap;


/**
 * User: zhangtan
 * Date: 12-9-7
 * Time: 上午10:00
 */
public class LogAop implements MethodInterceptor {
    /**
     * log
     */
    private final static Log log = LogFactory.getLog(LogAop.class);

    /**
     * 根据线程保存参数工具类
     */
    private LogThreadLocal logThreadLocal;

    /**
     * Method invoke ...
     *
     * @param methodInvocation of type MethodInvocation
     * @return Object
     * @throws Throwable when
     */
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        long procTime = System.currentTimeMillis();
        try {
//            LogThreadLocal.getParam();
            Object[] args = methodInvocation.getArguments();
            System.out.println("args = "+ Arrays.toString(args));
            HashMap<String, String> tempMap = new HashMap<String, String>();
             for(Object o : args){

                 log.info("o="+o.toString());
                 if(o.toString().contains("$")){
//                     Map tempMap = new HashMap();
                     tempMap.put(BaseConstant.SQ_ID,o.toString());
                 }
                 if(o instanceof User){
                     User tempUser = (User)o;
                     tempMap.put("email",tempUser.getEmail());
                     tempMap.put("pwd",tempUser.getPwd());
                 }
             }
            LogThreadLocal.getParam(tempMap);
            return methodInvocation.proceed();
        }catch (Exception e){
            log.error("error ",e);
        }
        finally {
            log.info(getMsg(methodInvocation, procTime));
        }
        return  methodInvocation.proceed();
    }

    private String getMsg(MethodInvocation methodInvocation, long procTime) {
        return "Process  method " + methodInvocation.getMethod().getDeclaringClass().getName() + "#" + methodInvocation.getMethod().getName() + " successful! Total time: " + procTime + " milliseconds!";
    }
}
