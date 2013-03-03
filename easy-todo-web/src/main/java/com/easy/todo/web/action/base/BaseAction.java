package com.easy.todo.web.action.base;

import com.easy.todo.util.CookieUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import javax.security.auth.login.LoginContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * User: zhangtan
 * Date: 12-9-7
 * Time: 下午4:41
 */
/**
 * User: Administrator
 * Date: 2010-4-27
 * Time: 11:42:43
 */
public class BaseAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
    protected final Logger log = Logger.getLogger(this.getClass());
    private CookieUtils cookieUtils;


    protected HttpServletResponse response;
    protected HttpServletRequest request;

    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }

    public String getCookieValue(String name) {
        return cookieUtils.getCookieValue(request, name);
    }

    /**
     * 取得登录信息
     *
     * @return
     */
    public LoginContext getLoginContext() {
        return (LoginContext) ActionContext.getContext().get("todo");
    }

    /**
     * 设置cookie的值
     * cookie必须先定义后才能使用。
     *
     * @param name
     * @param value
     */
    public void setCookie(String name, String value) {
        cookieUtils.setCookie(response, name, value);
    }


    public void deleteCookie(String name) {
        cookieUtils.deleteCookie(response, name);
    }

    /*
    * 获取真实的IP地址
    *
    */

    public String getRemoteIP() {
        String ip = request.getRemoteAddr();
        if (request.getHeader("x-forwarded-for") != null
                && !"unknown".equalsIgnoreCase(request.getHeader("x-forwarded-for"))) {
            ip = ip + "," + request.getHeader("x-forwarded-for");
        }
        return ip;
    }

    public static final int PAGE_SIZE = 20;

    /**
     * 来路
     */
    protected String refer;

    public String getRefer() {
        return refer;
    }

    public void setRefer(String refer) {
        this.refer = refer;
    }

     /**
     * 设置来路
     * 1、如果refer已经有值，则不变
     * 2、如果http requeset header中有Referer属性，则拿来过
     * 3、否则使用参数的传入值
     */
    public void initRefer(String refer) {
        if (StringUtils.isBlank(this.refer)) {
            this.refer = request.getHeader("Referer");
            if (StringUtils.isBlank(this.refer)) {
                this.refer = refer;
            }
        }
    }

    /**
     * 设置来路
     * 1、如果refer已经有值，则不变
     * 2、如果http requeset header中有Referer属性，则拿来过
     * 3、否则使用默认值”list.action“
     */
    public void initRefer() {
        initRefer("list.action");
    }

    /**
     * 判断是不是转发过来。
     * struts2中result可以设置为chain。这里判断是不是通过chain发过来
     * @return true 是通过chain转发过来的 false 不是
     */
    @SuppressWarnings({"unchecked"})
    public boolean isChain() {
        return !isNotChain();
    }
  /**
     * 判断是不是转发过来。
     * struts2中result可以设置为chain。这里判断是不是通过chain发过来
     * @return true 不是通过chain转发过来的 false 是
     */
    @SuppressWarnings({"unchecked"})
    public boolean isNotChain() {
        List<String> chainHistory = (List<String>) ActionContext.getContext().get("CHAIN_HISTORY");
        return chainHistory == null || chainHistory.isEmpty();
    }

    public boolean getChain() {
        return isChain();
    }
    /**
     * 当前页
     */
    protected int page;

    public void setPage(int page) {
        if (page <= 0) {
            page = 1;
        }
        this.page = page;
    }

    public int getPage() {
        return page;
    }

    /**
     * 将result中的值写入值栈
     * 会写入result变量，同时会把reuslt里面map的内容写入。
     * 对于消息。如果result返回成功，则写入message，否则写入error
     *
     * @param result 结果
     */
//    protected void toVm(Result result) {
//
//        ValueStack context = ActionContext.getContext().getValueStack();
//        context.set("result", result);
//        Set<String> set = result.keySet();
//        for (String key : set) {
//            context.set(key, result.get(key));
//        }
//        String resultCode = result.getResultCode();
//        if (StringUtils.isNotBlank(resultCode)) {
//            String text;
//            String[] params = result.getResultCodeParams();
//            if (params != null && params.length > 0) {
//                text = getText(resultCode, params);
//            } else {
//                text = getText(resultCode);
//            }
//            if (result.getSuccess()) {
//                addActionMessage(text);
//            } else {
//                addActionError(text);
//            }
//        }
//    }

    public void setCookieUtils(CookieUtils cookieUtils) {
        this.cookieUtils = cookieUtils;
    }


    /**
     * 由于 struts2 的 result 的 type 为 chain的时候，action链不能传递actionErrors、actionMessages和fieldErrors。所以借值栈来实现
     * 这是将以上三个从值栈中取出的方法
     * 本来要称除的
     */
    @SuppressWarnings({"unchecked"})
    protected void fromChain() {
        ValueStack stack = ActionContext.getContext().getValueStack();

        setActionErrors((Collection<String>) stack.findValue("getActionErrors"));
        setActionMessages((Collection<String>) stack.findValue("getActionMessages"));
        setFieldErrors((Map<String, List<String>>) stack.findValue("getFieldErrors"));
    }

    /**
     * 由于 struts2 的 result 的 type 为 chain的时候，action链不能传递actionErrors、actionMessages和fieldErrors。所以借值栈来实现
     * 这是将以上三个放入值栈的方法
     */
    protected void toChain() {
        ValueStack stack = ActionContext.getContext().getValueStack();
        stack.set("getActionErrors", getActionErrors());
        stack.set("getActionMessages", getActionMessages());
        stack.set("getFieldErrors", getFieldErrors());
    }
}
