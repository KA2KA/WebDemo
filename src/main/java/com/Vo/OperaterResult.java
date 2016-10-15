package com.Vo;

/**
 * 此类是用来封装数据传递的
 * Created by wuwan on 2016/10/2.
 */
public class OperaterResult<T> {
    public static final boolean SUCCESS=true;
    public static final boolean FAILURE=false;
    private boolean state;

    private T data;

    private  String errorMessage;


    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
