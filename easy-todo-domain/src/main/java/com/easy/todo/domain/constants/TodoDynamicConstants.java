package com.easy.todo.domain.constants;

/**
 * 工程基础常量.
 * User: zhangtan
 * Date: 13-8-21
 * Time: 下午4:33
 */

public class TodoDynamicConstants {

    private String domain;

    private int   loginCookieDayTime;

    private String cookieKey;

    private String imgPath;

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public int getLoginCookieDayTime() {
        return loginCookieDayTime;
    }

    public void setLoginCookieDayTime(int loginCookieDayTime) {
        this.loginCookieDayTime = loginCookieDayTime;
    }

    public String getCookieKey() {
        return cookieKey;
    }

    public void setCookieKey(String cookieKey) {
        this.cookieKey = cookieKey;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
}
