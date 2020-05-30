package com.jl.graduatedesign.vo;

public class CommonResponse<T> {
    private String code;
    private String msg;
    private T data;

    public CommonResponse(){
    }

    public CommonResponse(String code, String message, T data) {
        this.code = code;
        this.msg = message;
        this.data = data;
    }

    @Override
    public String toString() {
        return "CommonResponse{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
