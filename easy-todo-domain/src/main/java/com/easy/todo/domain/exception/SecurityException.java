package com.easy.todo.domain.exception;

/**
 * 安全类异常.
 * User: zhangtan
 * Date: 13-8-20
 * Time: 下午4:48
 */
public class SecurityException extends Exception {
    static final long serialVersionUID = 3218375228346050155L;

     
    public SecurityException() {
        super();
    }
 
    public SecurityException(String message) {
        super(message);
    }
 
    public SecurityException(String message, Throwable cause) {
        super(message, cause);
    }

    
    public SecurityException(Throwable cause) {
        super(cause);
    }
}
