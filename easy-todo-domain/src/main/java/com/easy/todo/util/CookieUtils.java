package com.easy.todo.util;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * cookie访问工具
 * User: zhangtan@gmail.com
 * Date: 2011-9-5
 * Time: 18:34:49
 */
public class CookieUtils {
    private final static Log log = LogFactory.getLog(CookieUtils.class);
    private Map<String, EasyCookie> cookieMap;

    /**
     * 从cookie中取值值，会自动解密(如果是加密保存)。
     *
     * @param servletRequest
     * @param name
     * @return
     */
    public String getCookieValue(HttpServletRequest servletRequest, String name) {
        Cookie[] cookies = servletRequest.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                String cookieName = cookie.getName();
                if (cookieName.equals(name)) {
                    if (cookieMap != null && cookieMap.containsKey(name)) {
                        EasyCookie EasyCookie = cookieMap.get(name);
                        return EasyCookie.getValue(cookie.getValue());
                    }
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    /**
     * 删除cookie，不管有没有定义都能删除
     *
     * @param servletResponse
     * @param name
     **/
    public final void deleteCookie(HttpServletResponse servletResponse, String name) {
        Cookie cookie;
        if (cookieMap != null && cookieMap.containsKey(name)) {
            EasyCookie EasyCookie = cookieMap.get(name);
            cookie = EasyCookie.newCookie(null);
        } else {
            cookie = new Cookie(name, null);
        }
        cookie.setMaxAge(0);
        servletResponse.addCookie(cookie);
    }

    /**
     * 设置cookie值，必须定义后才能设置。
     *
     * @param servletResponse
     * @param name
     * @param value
     **/
    public void setCookie(HttpServletResponse servletResponse, String name, String value) {
        if (cookieMap != null && cookieMap.containsKey(name)) {
            EasyCookie EasyCookie = cookieMap.get(name);
            Cookie cookie = EasyCookie.newCookie(value);
            servletResponse.addCookie(cookie);
        } else {
            throw new RuntimeException("Cookie " + name + " is undefined!");
        }
    }


    /**
     * 设置cookie定义值
     *
     * @param EasyCookieList
     */
    public void setEasyCookie(List<EasyCookie> EasyCookieList) {
        if (EasyCookieList != null) {
            HashMap<String, EasyCookie> EasyCookieHashMap = new HashMap<String, EasyCookie>(EasyCookieList.size());
            for (EasyCookie EasyCookie : EasyCookieList) {
                EasyCookieHashMap.put(EasyCookie.getName(), EasyCookie);
            }
            cookieMap = EasyCookieHashMap;
        }
    }

    /**
     * 删除所有状态没有设置过期的cookie
     *
     * @param request
     * @param response
     */
    public void invalidate(HttpServletRequest request, HttpServletResponse response) {
        if (cookieMap != null && cookieMap.size() > 0) {
            for (Map.Entry<String, EasyCookie> entry : cookieMap.entrySet()) {
                String key = entry.getKey();
                EasyCookie EasyCookie = entry.getValue();
                if (EasyCookie.getExpiry() < 1) {
                    if (StringUtils.isNotEmpty(getCookieValue(request, key))) {
                        deleteCookie(response, key);
                    }
                }
            }
        }
    }

}
