package com.easy.todo.web.interceptor;

import com.easy.todo.util.CookieUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.StrutsStatics;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: zhangtan
 * Date: 12-9-5
 * Time: 下午5:59
 */
public class LoginInterceptor implements Interceptor {
    private final static Log log = LogFactory.getLog(LoginInterceptor.class);
    private CookieUtils cookieUtils;
    private String LAST_ACCESS_TIME_COOKIE_NAME = "todo_";
    /**
     * 判断session有效时间，单位：分钟
     */
    private int sessionTimeout = 30;


    private void updateCookie(HttpServletRequest request, HttpServletResponse response) {
        //判断session是否有效
        boolean loginCookieValid = false;
        String session = cookieUtils.getCookieValue(request, LAST_ACCESS_TIME_COOKIE_NAME);//cookie有的效期
        if (StringUtils.isNotEmpty(session)) {
            try {
                long lastTime = Long.parseLong(session);
                long currTime = System.currentTimeMillis();
                if (currTime - lastTime < sessionTimeout * 60 * 1000) {//如果没有超时
                    loginCookieValid = true;
                }
            } catch (Exception e) {
                log.error("login intercept error", e);
            }
        }

        //无效要清空session
        if (!loginCookieValid) {
            cookieUtils.invalidate(request, response);
        }

        //写最后一次访问的cookie
        cookieUtils.setCookie(response, LAST_ACCESS_TIME_COOKIE_NAME, Long.toString(System.currentTimeMillis()));
    }

    public void setCookieUtils(CookieUtils cookieUtils) {
        this.cookieUtils = cookieUtils;
    }

    public void setSessionTimeout(int sessionTimeout) {
        this.sessionTimeout = sessionTimeout;
    }

    public void destroy() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void init() {
        //To change body of implemented methods use File | Settings | File Templates.
    }


    /**
     * 从cookie中读入登录信息。并写入到logincontext中。
     * 只有登录成功后，才写入
     *
     * @param actionInvocation
     * @return
     * @throws Exception
     */

    public String intercept(ActionInvocation actionInvocation) throws Exception {
        ActionContext actionContext = actionInvocation.getInvocationContext();
                HttpServletRequest request = (HttpServletRequest) actionContext.get(StrutsStatics.HTTP_REQUEST);
                HttpServletResponse response = (HttpServletResponse) actionContext.get(StrutsStatics.HTTP_RESPONSE);

                try {
                    updateCookie(request, response);
                } catch (Exception e) {
                    log.warn("update cookie error!",e);
                }


                return actionInvocation.invoke();
    }
}