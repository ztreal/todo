package com.easy.todo.domain.context;

import java.util.Date;

/**
 * 任务的分类.
 * User: zhangtan
 * Date: 13-7-14
 * Time: 下午10:37
 */
public class Context {

    /**
     * 用户id
     */
    public String userId;

    public String id;
    /**
     * 上级分类的id
     */
    public String paraentId;
    /**
     * 分类名称
     */
    public String name;
    /**
     * 分类创建时间
     */
    public Date createDate;

    public Date updateDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParaentId() {
        return paraentId;
    }

    public void setParaentId(String paraentId) {
        this.paraentId = paraentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getUsrId() {
        return userId;
    }

    public void setUsrId(String usrId) {
        this.userId = usrId;
    }
}
