package com.wusiq.service.impl;

import com.wusiq.base.RestServiceRspEntity;
import com.wusiq.entity.UserEntity;
import com.wusiq.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 用户管理的service实现类
 */
@Service
public class UserServiceImpl implements UserService {

    /**
     *根据id获取用户信息
     */
    @Override
    public RestServiceRspEntity queryById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://127.0.0.1:8888/restService/userManage/{id}",RestServiceRspEntity.class,id);
    }

  /**
   *添加用户
   */
    @Override
    public ResponseEntity<UserEntity> addUser(UserEntity user) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity("http://127.0.0.1:8888/restService/userManage/addUser",user,UserEntity.class);
    }
}
