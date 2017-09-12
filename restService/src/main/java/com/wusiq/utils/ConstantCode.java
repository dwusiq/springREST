package com.wusiq.utils;

/**
 * REST服务端的错误类常量
 * 0成功   1000~1999系统错误  2000~2999用户错误   3000~3999一般异常
 */
public class ConstantCode {
    /**
     * 1000~1999
     */
    /*返回成功*/
    public static final RetCode SUCCESS = new RetCode(0,"成功");

    /**
     * 3000~3999
     */
    /*该用户信息不存在*/
    public static final RetCode QUERY_NO_DATA = new RetCode(3000,"查无数据");
}
