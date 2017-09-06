package com.wusiq.entity;

import java.io.Serializable;

/**
 * 用户实体
 */
public class UserEntity implements Serializable{
    private Long id;
    private String userName;
    private Integer age;

    public UserEntity(){}
    public UserEntity(Long id,String userName,Integer age){
        this.id = id;
        this.userName = userName;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
