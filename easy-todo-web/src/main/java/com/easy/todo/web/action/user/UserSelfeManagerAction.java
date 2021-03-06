package com.easy.todo.web.action.user;

import com.easy.todo.domain.user.User;
import com.easy.todo.service.UserService;
import com.easy.todo.util.spring.BaseAction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户自己管理自己信息设置的action.
 * User: zhangtan
 * Date: 13-9-2
 * Time: 上午10:11
 */
@Controller
public class UserSelfeManagerAction extends BaseAction {

    private HttpServletRequest request;

    private HttpServletResponse response;

    @Resource
    private UserService userService;

    @ModelAttribute
    public void setRequestAndResponse(HttpServletRequest request, HttpServletResponse response) {
        this.response = response;
        this.request = request;
    }


    @RequestMapping(value = "/my/upImg", method = {RequestMethod.GET,
            RequestMethod.POST})
    @ResponseBody
    public String upImg(MultipartHttpServletRequest request) throws IOException {
        return userService.uploadUserImg(request);
    }


    @RequestMapping(value = "/my/to-userinfo-manager", method = {RequestMethod.GET,
            RequestMethod.POST})
    public String toUserinfoManage(Model model) {
        String uid = request.getAttribute("uid").toString();
        model.addAttribute("userInfo", userService.getUserInfo(uid));
        return "user-data-modification";
    }


    @RequestMapping(value = "/my/modify-userinfo", method = {RequestMethod.GET,
            RequestMethod.POST})
    @ResponseBody
    public String modifyUserInfo(@RequestParam(value = "usrId") String usrId,
                                 @RequestParam(value = "nickName", required = false) String nickName,
                                 @RequestParam(value = "pwd", required = false) String pwd) {
        String uid = request.getAttribute("uid").toString();
        User user = new User();
        user.setUserId(usrId);
        user.setNickName(nickName);
        userService.modifyUserInfo(user);
        return "OK";
    }

}
