package com.easy.todo.domain.enumerate;

/**
 * 终端类型枚举.
 * User: zhangtan
 * Date: 13-8-20
 * Time: 下午2:56
 */
public enum PrefixEnum {

    SESSION_MAP("SESSION_MAP:", "session的map集合"),
    SESSION_ID("SESSION_ID:", "手机端");

    private final String value;
    private final String name;

    PrefixEnum(String intValue, String valueName) {
        this.value = intValue;
        this.name = valueName;
    }

    public String getIntValue(String ValueName) {
        for (PrefixEnum t : PrefixEnum.values()) {
            if (ValueName.equals(t.getName())) {
                return t.getValue();
            }
        }
        return null;
    }

    public static String getValueName(String intValue) {
        for (PrefixEnum t : PrefixEnum.values()) {
            if (intValue.equals(t.getValue())) {
                return t.getName();
            }
        }
        return null;
    }

    public String getValue() {
        return value;
    }

    public String getName() {
        return name;
    }


}
