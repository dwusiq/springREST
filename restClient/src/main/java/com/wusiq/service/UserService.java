package com.wusiq.service;

import com.wusiq.base.RestServiceRspEntity;


/**
 * 用户管理的service
 */
public interface UserService {
    RestServiceRspEntity queryById(Long id);
}
