package com.wusiq.test;

import com.alibaba.fastjson.JSON;
import com.wusiq.base.RestServiceRspEntity;
import com.wusiq.entity.UserEntity;
import com.wusiq.service.UserService;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.ReflectUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;
import java.util.Map;

/**
 * 用户管理测试类
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src.main.webapp")
@ContextHierarchy({
        @ContextConfiguration(name = "parent", locations = "classpath*:spring/spring-config.xml"),
        @ContextConfiguration(name = "child", locations = "classpath*:spring/spring-mvc.xml")
})
public class UserTest {
    private static Logger LOGGER =  LoggerFactory.getLogger(UserTest.class);
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;
    @Autowired
    private UserService userServiceImpl;

    /**
     * 测试查询方法
     */
    @Test
    public void testQueryUserById() throws Exception {
        RestServiceRspEntity result = userServiceImpl.queryById(1L);
        LOGGER.info("result:{}",JSON.toJSONString(result));

        //下面是自定义的结果判断
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getStatus(),0);
        Assert.assertNotNull(result.getData());
        UserEntity user = new UserEntity();
        Map<String,Object> map = (Map<String, Object>) result.getData();
        BeanUtils.populate(user,map);
        LOGGER.info("user id:{},name:{},age:{}",user.getId(),user.getUserName(),user.getAge());
        Assert.assertTrue(user.getId()==1);
        Assert.assertEquals(user.getUserName(),"wusiq");
        Assert.assertTrue(user.getAge()==12);
    }

    /**
     * 测试添加方法
     */
    @Test
    public void testAddUser() throws Exception {
        UserEntity user = new UserEntity();
        user.setId(14L);


        ResponseEntity<UserEntity> result = userServiceImpl.addUser(user);
        LOGGER.info("result:{}",JSON.toJSONString(result));

        //下面是自定义的结果判断
        Assert.assertNotNull(result);
      //  List<String> uri = result.getHeaders().get("uriStr");

        UserEntity userB = result.getBody();
        LOGGER.info("user id:{},name:{},age:{}",userB.getId(),userB.getUserName(),userB.getAge());
        Assert.assertTrue(userB.getId()==14L);
        Assert.assertEquals(userB.getUserName(),"wicker");
        Assert.assertTrue(userB.getAge()==16);
    }

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }
}
