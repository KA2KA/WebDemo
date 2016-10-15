package com.Vo;

/**
 * Created by wuwan on 2016/10/1.
 */
public enum StateEnum {

    SUCCESS(1, "状态正常"),
    LAYOUT(0, "注销状态");
    private int state;
    private String stateInfo;

    StateEnum(int state, String stateinfo) {
        this.state = state;
        this.stateInfo = stateinfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static StateEnum stateOf(int index) {
        for (StateEnum state : values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }


}
