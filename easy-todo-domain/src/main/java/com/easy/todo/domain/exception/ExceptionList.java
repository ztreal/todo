package com.easy.todo.domain.exception;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhangtan
 * Date: 13-8-20
 * Time: 下午4:39
 */
public class ExceptionList extends Exception {

    /**
     * 容纳 所有的异常
     */
    private List<Throwable> causes = new ArrayList<Throwable>();

    /**
     * 构造 函数,传递一个异常列表
     */
    public ExceptionList(List<? extends Throwable> _cause) {
        causes.addAll(_cause);
    }

    /**
     *  读取 所有的异常
     * @return  异常列表
     */

    public List<Throwable> getExceptions() {
        return causes;
    }


}
