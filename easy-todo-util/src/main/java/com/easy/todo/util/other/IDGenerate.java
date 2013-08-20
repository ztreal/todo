package com.easy.todo.util.other;

/**
 * 主键生成工具类.
 * User: zhangtan
 * Date: 13-8-19
 * Time: 下午3:22
 */
public class IDGenerate {




    public static String generateSessionID() {
        StringBuilder sb = new StringBuilder();
        sb.append("SID_"); //用户id标识
        sb.append(GuId.get());
        return sb.toString();
    }

    private static void main(String[] args) {
        for (int a = 1; a < 100; a++) {
            GuId createGuId = GuId.get();
            System.out.println("机器标志为"+createGuId.getMachineID());
            System.out.println(createGuId.toString());
        }
    }
}
