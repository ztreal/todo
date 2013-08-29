package com.easy.todo.domain.todo;

import java.util.Date;

/**
 * 基础任务信息.
 * User: zhangtan
 * Date: 13-7-14
 * Time: 下午10:32
 */
public class Todo {


    public String todoId;

    public String usrId;
    /**
     * 待办事项内容
     */
    public String content;
    /**
     * 记录的时候的地址
     */
    public String adress;

    public String ip;
    /**
     * 经度*10W保存
     */
    public long  lng;
    /**
     * 维度*10W保存
     */
    public long  lon;

    /**
     * 所属上线文
     */
    public String contextId;

    public Date createDate;

    public Date updateDate;


    public String getTodoId() {
        return todoId;
    }

    public void setTodoId(String todoId) {
        this.todoId = todoId;
    }

    public String getUsrId() {
        return usrId;
    }

    public void setUsrId(String usrId) {
        this.usrId = usrId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public long getLng() {
        return lng;
    }

    public void setLng(long lng) {
        this.lng = lng;
    }

    public long getLon() {
        return lon;
    }

    public void setLon(long lon) {
        this.lon = lon;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getContextId() {
        return contextId;
    }

    public void setContextId(String contextId) {
        this.contextId = contextId;
    }
}
