package com.easy.todo.util.cookie;

import com.easy.todo.util.cookie.encryption.PBECoder;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.Cookie;
import java.net.URLEncoder;

/**
 * Created with IntelliJ IDEA.
 * User: zhangtan
 * Date: 12-9-5
 * Time: 下午6:36
 */
public class EasyCookie {


    /**
     * cookie的名字
     */
    private String name;
    /**
     * cookie的domain
     */
    private String domain;
    /**
     * cookie的路径
     */
    private String path;
    /**
     * cookie的过期时间
     * 单位：秒
     */
    private int expiry;

    /**
     * 是否加密cookie
     *
     * @see #key
     **/
    private boolean encrypt;

    /**
     * cookie的key
     *
     */
    private String key ;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getExpiry() {
        return expiry;
    }

    public void setExpiry(int expiry) {
        this.expiry = expiry;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public boolean isEncrypt() {
        return encrypt;
    }

    public void setEncrypt(boolean encrypt) {
        this.encrypt = encrypt;
    }

    public EasyCookie() {
    }

    public EasyCookie(String name, String domain, int expiry, String key) {
        this.name = name;
        this.domain = domain;
        this.expiry = expiry;
        this.key = key;
    }

    public Cookie newCookie(String value) {
        String newValue = "";
        String tempValue = "";
        if (!StringUtils.isEmpty(value)) {
            try {
                tempValue = isEncrypt() ? PBECoder.encrypt(value,key) : value;
                newValue = URLEncoder.encode(tempValue, "UTF-8");
            } catch (Exception e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        } else {
            newValue = tempValue;
        }
        Cookie cookie = new Cookie(name, tempValue);
        if (!StringUtils.isBlank(domain)) {
            cookie.setDomain(domain);
        }
        if (!StringUtils.isBlank(path)) {
            cookie.setPath(path);
        }
        if (expiry > 0) {
            cookie.setMaxAge(expiry);
        }
        return cookie;
    }

    public String getValue(String value)  {
        if (!StringUtils.isEmpty(value)) {
            try {
                return isEncrypt() ? PBECoder.decrypt(value,key) : value;
            } catch (Exception e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            return null;
        } else {
            return value;
        }
    }


}
