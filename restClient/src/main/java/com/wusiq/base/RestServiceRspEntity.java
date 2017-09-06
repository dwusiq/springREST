package com.wusiq.base;

/**
 * 请求restService服务类返回的返回类
 */
public class RestServiceRspEntity {
    private int status;//错误码
    private String msg;//错误信息
    private Object data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
