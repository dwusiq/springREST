package com.wusiq.service;

import com.wusiq.base.RestServiceRspEntity;
import com.wusiq.entity.UserEntity;
import org.springframework.http.ResponseEntity;


/**
 * 用户管理的service
 */
public interface UserService {
    RestServiceRspEntity queryById(Long id);
    ResponseEntity<UserEntity> addUser(UserEntity user);
}
