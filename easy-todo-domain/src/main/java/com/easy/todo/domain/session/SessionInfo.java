package com.easy.todo.domain.session;

import java.util.Date;

/**
 * session的信息内容.
 * User: zhangtan
 * Date: 13-8-20
 * Time: 下午1:53
 */
public class SessionInfo {

    /**
     * 终端类型
     * @see com.easy.todo.domain.enumerate.TerminalEnum
     */
    public Integer tId;

    public String sessionId;

    public Date createDate;

    public Date updateTime;

    /**
     * 是否
     */
    public boolean Valid;

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public boolean isValid() {
        return Valid;
    }

    public void setValid(boolean valid) {
        Valid = valid;
    }
}
