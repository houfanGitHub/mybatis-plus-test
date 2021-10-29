package com.mybatis.plus.mapper;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.mybatis.plus.entity.User;
import com.mybatis.plus.entity.enums.GenderEnum;
import com.mybatis.plus.service.IUserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Classname VersionTest
 * @Description TODO
 * @Date 2021/10/29 16:04
 * @Created by 侯凡
 */
@SpringBootTest
public class VersionTest {

    @Autowired
    private IUserService userService;

    @AfterEach
    public void select(){
        User user = userService.lambdaQuery().eq(User::getName, "versionUpdate").one();
        System.out.println(JSONObject.toJSONString(user));
    }

    @Test
    public void testInsert(){
        User user = new User("TestVersion5", 22, "version@test.com", GenderEnum.MAN);
        userService.save(user);
        System.out.println(JSONObject.toJSONString(user));
    }

    @Test
    public void testUpdate(){
        User updateUser = new User(1454006019767193602L,
                "versionUpdate",
                12,
                "version@test.com",
                GenderEnum.WUMAN,
                1);
        boolean update = userService.updateById(updateUser);
        System.out.println(JSONObject.toJSONString(updateUser));
    }
}
