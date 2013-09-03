package com.easy.todo.service;

import com.easy.todo.domain.user.User;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * User: zhangtan
 * Date: 12-9-7
 * Time: 上午9:47
 */
public interface UserService {

    /**
     * 用户注册
     * @param user
     */
    public void insertUser(User user);

    /**
     * 用户登陆
     * @param user
     */
    public String login(User user,boolean remberCookie) throws Exception;

    /**
     * 退出登录
      * @param response
     */
    public void quit(HttpServletResponse response,HttpServletRequest request);

    /**
     * 上传文件方法
     * @param request
     * @return
     */
    public String uploadUserImg(MultipartHttpServletRequest request);

    /**
     * 获取用户基本信息，先查缓存再查数据库，然后缓存
     * @param uid
     * @return
     */
    public User getUserInfo(String uid);
}
