package com.easy.todo.web.interceptor;

import com.easy.todo.util.cookie.CookieUtils;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMapping;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: zhangtan
 * Date: 12-9-5
 * Time: 下午5:59
 */
@Service
public class LoginInterceptor implements MethodInterceptor {
    private final static Log log = LogFactory.getLog(LoginInterceptor.class);
    private CookieUtils cookieUtils;
    private String LAST_ACCESS_TIME_COOKIE_NAME = "sid";
    /**
     * 判断session有效时间，单位：分钟
     */
    private int sessionTimeout = 30;


    private boolean updateCookie(HttpServletRequest request, HttpServletResponse response) {
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

        return loginCookieValid;
    }



    /**
     * 从cookie中读入登录信息。并写入到logincontext中。
     * 只有登录成功后，才写入
     *
     * @param invocation
     * @return
     * @throws Exception
     */
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        log.info("登陆拦截开始！");
        Object[] args = invocation.getArguments();
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        ActionMapping mapping = null;
        for (Object arg : args) {
            if (arg instanceof HttpServletRequest) request = (HttpServletRequest) arg;
            if (arg instanceof HttpServletResponse) response = (HttpServletResponse) arg;
            if (arg instanceof ActionMapping) mapping = (ActionMapping) arg;
        }


        if (request != null && mapping != null) {
            String url = request.getRequestURI();
            if (!updateCookie(request, response)) {
                return mapping.findForward("loginInterceptor");
            } else {
                return invocation.proceed();
            }
        } else {
            return invocation.proceed();
        }

    }
}