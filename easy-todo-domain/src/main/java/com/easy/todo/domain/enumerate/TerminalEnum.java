package com.easy.todo.domain.enumerate;

/**
 * 终端类型枚举.
 * User: zhangtan
 * Date: 13-8-20
 * Time: 下午2:56
 */
public enum TerminalEnum {

    Terminal_WEB(1, "网页端"),
    Terminal_MOBILE(2, "手机端");

    private final int value;
    private final String name;

    TerminalEnum(int intValue, String valueName) {
        this.value = intValue;
        this.name = valueName;
    }

    public int  getIntValue(String ValueName) {
        for (TerminalEnum t : TerminalEnum.values()) {
            if (ValueName.equals(t.getName())) {
                return t.getValue();
            }
        }
        return -1;
    }

    public static String getValueName(int intValue) {
        for (TerminalEnum t : TerminalEnum.values()) {
            if (intValue == t.getValue()) {
                return t.getName();
            }
        }
        return null;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }


}
