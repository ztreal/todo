package com.easy.todo.util.other;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: zhangtan
 * Date: 13-9-2
 * Time: 下午4:49
 */
public class MkDirUtil {
    protected static transient Log log = LogFactory.getLog(MkDirUtil.class);

    /**
     * 创建绝对路径(包含多级)
     *
     * @param header 绝对路径
     * @return 新创建的绝对路径
     */
    public static boolean makeDir(String header) {
        boolean flag = false;
        String[] sub = header.replaceAll("\\\\","/").split("/");
        File dir = null;
        for (String aSub : sub) {
            if(dir!=null){
                dir = new File(dir + File.separator + aSub);
            }else{
                dir = new File(aSub);
            }
            if (!dir.exists()) {
                if (dir.mkdir()) {
                    flag = true;
                } else {
                    log.error("  create " + aSub + "folder error ");
                }
            }


        }
        return flag;
    }

}
