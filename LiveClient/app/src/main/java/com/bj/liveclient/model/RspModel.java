package com.bj.liveclient.model;

/**
 * RspModel
 * Date: 2018/10/23
 * Author: NHL
 */
public class RspModel<T> {
    /**
     * err_no : 0
     * err_msg :
     * data :
     */
    private int err_no;
    private String err_msg;
    private T data;

    public int getErr_no() {
        return err_no;
    }

    public void setErr_no(int err_no) {
        this.err_no = err_no;
    }

    public String getErr_msg() {
        return err_msg;
    }

    public void setErr_msg(String err_msg) {
        this.err_msg = err_msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "RspModel{" +
                "err_no=" + err_no +
                ", err_msg='" + err_msg + '\'' +
                ", data=" + data +
                '}';
    }
}
