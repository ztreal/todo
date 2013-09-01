package com.easy.todo.domain.enumerate;

/**
 * 终端类型枚举.
 * User: zhangtan
 * Date: 13-8-30
 * Time: 下午11:31
 */
public enum TodoStatusEnum {

    TODO_STATUS_AGENCY(1, "待开始"),
    TODO_STATUS_COMPLETED(2, "已完成"),
    TODO_STATUS_DELAY(1, "未完成");

    private final int value;
    private final String name;

    TodoStatusEnum(int intValue, String valueName) {
        this.value = intValue;
        this.name = valueName;
    }

    public int  getIntValue(String ValueName) {
        for (TodoStatusEnum t : TodoStatusEnum.values()) {
            if (ValueName.equals(t.getName())) {
                return t.getValue();
            }
        }
        return -1;
    }

    public static String getValueName(int intValue) {
        for (TodoStatusEnum t : TodoStatusEnum.values()) {
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
