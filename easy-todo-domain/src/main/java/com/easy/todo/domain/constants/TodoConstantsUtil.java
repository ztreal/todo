package com.easy.todo.domain.constants;

/**
 * Created with IntelliJ IDEA.
 * User: zhangtan
 * Date: 13-8-21
 * Time: 下午5:01
 */

public class TodoConstantsUtil {


    private TodoDynamicConstants todoDynamicConstants;

    public static String domain;

    public static String cookieKey;

    public static String SESSION_COOKIE_NAME = "sid";

    public static String IMG_PATH ;


    /**
     * cookie有效期，单位分钟
     */
    public static int loginCookieSecondTime;


    public void init() {
        domain = todoDynamicConstants.getDomain();
        loginCookieSecondTime = todoDynamicConstants.getLoginCookieDayTime() * 24 * 60 * 60;
        cookieKey =  todoDynamicConstants.getCookieKey();
        IMG_PATH =   todoDynamicConstants.getImgPath();
    }

    public TodoDynamicConstants getTodoDynamicConstants() {
        return todoDynamicConstants;
    }

    public void setTodoDynamicConstants(TodoDynamicConstants todoDynamicConstants) {
        this.todoDynamicConstants = todoDynamicConstants;
    }

}
