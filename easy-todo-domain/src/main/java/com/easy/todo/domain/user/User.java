package com.easy.todo.domain.user;

import org.springframework.data.annotation.Id;

/**
 * User: zhangtan
 * Date: 12-9-4
 * Time: 下午6:37
 */
public class User{

    @Id
    public String userId;
    public String email;
    public Integer sex;
    public Integer  userType;
    public String pwd;
    public String headPic;



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

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String toString(){
        return "userId="+userId+" pwd = " + pwd +  " email=" + email;
    }
}
