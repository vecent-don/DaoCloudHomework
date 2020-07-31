package com.example.springhomework.VO;

public class ResponceVO {
    String msg;
    int err;

    public static ResponceVO build(int i, String message) {
        return new ResponceVO(i,message);
    }

    public static ResponceVO ok(String message) {
        return new ResponceVO("hello");
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResponceVO(int i,String message){
        this.err = i;
        this.msg = message;
    }

    public  ResponceVO(String message){
        this.msg = message;
    }
}
