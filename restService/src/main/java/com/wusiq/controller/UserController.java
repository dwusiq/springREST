package com.wusiq.controller;

import com.alibaba.fastjson.JSON;
import com.wusiq.entity.UserEntity;
import com.wusiq.base.BaseController;
import com.wusiq.base.BaseRspEntity;
import com.wusiq.utils.ConstantCode;
import com.wusiq.utils.RestServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户管理控制器
 */
@Controller
@RequestMapping(value = "userManage")
public class UserController extends BaseController {
    private static Logger LOGGER =  LoggerFactory.getLogger(UserController.class);

    @ResponseBody
    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public BaseRspEntity getUserById(@PathVariable long id){
        LOGGER.info("getUserById userId:"+id);
        if(id!=1){
            throw new RestServiceException(ConstantCode.QUERY_NO_DATA);
        }

        //返回结果
        BaseRspEntity bre = new BaseRspEntity(0);
        UserEntity ue = new UserEntity(id,"wusiq",12);
        bre.setData(ue);
        LOGGER.info("response:{}", JSON.toJSONString(bre));
        return bre;
    }
}
