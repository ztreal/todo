package com.easy.todo.web.action.user;

import com.easy.todo.domain.constants.TodoConstantsUtil;
import com.easy.todo.util.other.MkDirUtil;
import com.easy.todo.util.spring.BaseAction;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;

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

    @ModelAttribute
    public void setRequestAndResponse(HttpServletRequest request, HttpServletResponse response) {
        this.response = response;
        this.request = request;
    }


    @RequestMapping(value = "/my/upImg", method = {RequestMethod.GET,
            RequestMethod.POST})
    public String upImg(MultipartHttpServletRequest request) throws IOException {
        // 获得第1张图片（根据前台的name名称得到上传的文件）
        MultipartFile file = request.getFile("fine-uploader");
        // 获得文件名：
        String filename = file.getOriginalFilename();
        String imgtype = filename.substring(filename.lastIndexOf("."));
        // 一级路径
        String ctxPath = TodoConstantsUtil.IMG_PATH;
        // 组件完整路径
        String uid = request.getAttribute("uid").toString();
        StringBuilder sb = new StringBuilder();
        sb.append(ctxPath);
        sb.append(File.separator);
        sb.append(uid);
        sb.append(File.separator);
        String path = sb.toString();
        MkDirUtil.makeDir(path);

        File uploadFile = new File(path + Calendar.getInstance().getTimeInMillis() +"_" + Math.random() + imgtype);
        FileCopyUtils.copy(file.getBytes(), uploadFile);

        System.out.println("********************imgFile1******");

        return "/index";
    }


    @RequestMapping(value = "/my/to-userinfo-manager", method = {RequestMethod.GET,
            RequestMethod.POST})
    public String toUserinfoManage() {
        return "user-data-modification";
    }

}
