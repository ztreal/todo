package com.jd.todo;

/**
 * Created with IntelliJ IDEA.
 * User: zhangtan
 * Date: 12-11-8
 * Time: 上午11:05
 * To change this template use File | Settings | File Templates.
 */
public class Crash {
    public static void  main(String[] args){
        Object[] o = null;
        for(;;){
            o = new Object[]{};
        }
    }
}
