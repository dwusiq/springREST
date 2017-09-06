package com.wusiq.base;

import com.alibaba.fastjson.JSON;
import com.wusiq.utils.RestServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * 控制器的基类
 */
public abstract class BaseController {
    private static Logger LOGGER =  LoggerFactory.getLogger(BaseController.class);
    /**
     * 捕获处理异常：RestServiceException
     */
    @ResponseBody
    @ExceptionHandler(value = RestServiceException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected BaseRspEntity restExceptionHandler(RestServiceException rse){
        LOGGER.warn("exception",rse);
        BaseRspEntity bre = new BaseRspEntity(rse.getRsc());
        LOGGER.warn("response:{}", JSON.toJSONString(bre));
        return bre;
    }
}
