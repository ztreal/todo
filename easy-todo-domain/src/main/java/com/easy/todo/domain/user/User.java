package com.easy.todo.domain.user;

import org.springframework.data.annotation.Id;

/**
 * User: zhangtan
 * Date: 12-9-4
 * Time: 下午6:37
 */
public class User{

    @Id
    public String userId; //用户id
    public String email;//用户邮箱
    public Integer sex;//用户性别
    public Integer  userType;//用户类型
    public String pwd;//用户密码

    public User() {
    }

    public User(String userId, String email, Integer sex, Integer userType) {
        this.userId = userId;
        this.email = email;
        this.sex = sex;
        this.userType = userType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String toString(){
        return "userId="+userId+" pwd = " + pwd +  " email=" + email;
    }
}
