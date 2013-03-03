package com.easy.todo.domain.param;

import java.util.HashMap;
import java.util.Map;

/**
 * User: zhangtan
 * Date: 12-9-7
 * Time: 上午10:06
 */
public class InParam {
    private String threadName ;

    private String SQ_ID;

    private HashMap Param;

    public InParam( String threadName,HashMap param) {
        Param = param;
        this.threadName = threadName;
    }

    public InParam(String threadName, String SQ_ID, HashMap param) {
        this.threadName = threadName;
        this.SQ_ID = SQ_ID;
        Param = param;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public HashMap getParam() {
        return Param;
    }

    public void setParam(HashMap param) {
        Param = param;
    }

    public String getSQ_ID() {
        return SQ_ID;
    }

    public void setSQ_ID(String SQ_ID) {
        this.SQ_ID = SQ_ID;
    }
}
