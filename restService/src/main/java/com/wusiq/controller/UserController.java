package com.wusiq.controller;

import com.alibaba.fastjson.JSON;
import com.wusiq.entity.UserEntity;
import com.wusiq.base.BaseController;
import com.wusiq.base.BaseRspEntity;
import com.wusiq.utils.ConstantCode;
import com.wusiq.utils.RestServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

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

    @ResponseBody
    @RequestMapping(value = "/addUser",method = RequestMethod.POST,consumes = "application/json")
    public ResponseEntity<UserEntity> addUser(@RequestBody UserEntity userEntity, UriComponentsBuilder ucb){
        LOGGER.info("getUrl...");

        UriComponents uriComponents = ucb.path("/").path("test").path("/").path("newPath").build();
        String uriStr = uriComponents.toString();
        LOGGER.info("uri:"+uriStr);

       // URI locationUri = uriComponents.toUri();
        HttpHeaders headers = new HttpHeaders();
        headers.set("uriStr:",uriStr);

        UserEntity user = new UserEntity();
        user.setId(userEntity.getId());
        user.setAge(16);
        user.setUserName("wicker");

        ResponseEntity<UserEntity> responseEntity = new ResponseEntity<UserEntity>(user,headers, HttpStatus.OK);

        LOGGER.info("response:{}", JSON.toJSONString(responseEntity));
        return responseEntity;
    }
}
