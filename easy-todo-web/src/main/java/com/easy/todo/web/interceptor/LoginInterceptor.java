package com.easy.todo.web.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.easy.todo.domain.constants.TodoBaseConstants;
import com.easy.todo.domain.constants.TodoConstantsUtil;
import com.easy.todo.domain.enumerate.PrefixEnum;
import com.easy.todo.domain.session.SessionInfo;
import com.easy.todo.util.cookie.CookieUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: zhangtan
 * Date: 12-9-5
 * Time: 下午5:59
 */
@Service
public class LoginInterceptor implements HandlerInterceptor {
    private final static Log log = LogFactory.getLog(LoginInterceptor.class);
    @Resource
    private CookieUtils cookieUtils;


    private String mappingURL;//利用正则映射到需要拦截的路径

    /**
     * 判断session有效时间，单位：分钟
     */
    private int sessionTimeout = 30;

    public String getMappingURL() {
        return mappingURL;
    }

    public void setMappingURL(String mappingURL) {
        this.mappingURL = mappingURL;
    }

    @Resource
    private RedisTemplate<Serializable, Serializable> redisTemplate;

    private boolean updateCookie(HttpServletRequest request, HttpServletResponse response) {
        //判断session是否有效
        boolean loginCookieValid = false;
        boolean findFlag = false;
        String cookieSessionId = cookieUtils.getCookieValue(request, TodoConstantsUtil.SESSION_COOKIE_NAME);
        request.setAttribute("sid", cookieSessionId);
        if (StringUtils.isNotEmpty(cookieSessionId)) {
            String uid = cookieSessionId.substring(cookieSessionId.indexOf("_") + 1, cookieSessionId.lastIndexOf("_"));
            request.setAttribute("uid", uid);
            BoundHashOperations<Serializable, String, String> ops = redisTemplate.boundHashOps(PrefixEnum.SESSION_MAP.getValue() + uid);
            Map<String, String> redisTatleMap = ops.entries();

            for (Map.Entry entry : redisTatleMap.entrySet()) {
                String sessionKey = entry.getKey().toString();
                String sessionValue = entry.getValue().toString();
                SessionInfo sessionInfo = JSONObject.parseObject(sessionValue, SessionInfo.class);

                //值为空，或者没找到sessionid则continue
                if (null == entry.getValue()  ) {
                    continue;
                }
                //根据cookieId从缓存中取出session相关信息
                //如果是一周免登陆的
                if (sessionInfo.isValid()) {
                    if (((new DateTime(sessionInfo.getUpdateTime())).plusSeconds(TodoConstantsUtil.loginCookieSecondTime).toDate()).before(new Date())) {
                        ops.delete(sessionKey);
                    } else if (sessionInfo.getSessionId().equals(cookieSessionId)){
                        loginCookieValid = true;
                        sessionInfo.setUpdateTime(new Date());
                        ops.expire(TodoBaseConstants.COOKIE_MAX_VALID, TimeUnit.SECONDS);
                        ops.put("cookieSessionId", JSONObject.toJSON(sessionInfo).toString());
                        findFlag = true;
                    }
                } else { //非一周免登陆的有效期为30分钟
                    if (((new DateTime(sessionInfo.getUpdateTime())).plusMinutes(sessionTimeout).toDate()).before(new Date())) {
                        ops.delete(sessionKey);
                    } else if(sessionInfo.getSessionId().equals(cookieSessionId)){
                        loginCookieValid = true;
                        sessionInfo.setUpdateTime(new Date());
                        ops.expire(TodoBaseConstants.COOKIE_MAX_VALID, TimeUnit.SECONDS);
                        ops.put("cookieSessionId", JSONObject.toJSON(sessionInfo).toString());
                        findFlag = true;
                    }
                }
            }
            //根据cookie中的sessionId在缓存中没有找到相关信息，则删除cookie中的sid
            if (!findFlag) {
                Cookie cookie = new Cookie(TodoConstantsUtil.SESSION_COOKIE_NAME, null);
                cookie.setMaxAge(0);      //0立刻删除
                response.addCookie(cookie);     //如果已经超时则删除
            }

        }
        return loginCookieValid;
    }


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI();
        if (mappingURL == null || url.matches(mappingURL)) {
            log.info("login intercept begin！target is " + url);
            if (updateCookie(request, response)) {
                return true;
            } else {
                response.sendRedirect("/to-login");
                return false;
            }
        }
        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}