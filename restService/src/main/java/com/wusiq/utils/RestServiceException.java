package com.wusiq.utils;

/**
 * rest服务端的异常类
 */
public class RestServiceException extends RuntimeException{
   private RetCode rsc;//错误码类
    public RestServiceException(RetCode retCode){
        this.rsc = retCode;
    }

    public RetCode getRsc() {
        return rsc;
    }

    public void setRsc(RetCode rsc) {
        this.rsc = rsc;
    }
}
