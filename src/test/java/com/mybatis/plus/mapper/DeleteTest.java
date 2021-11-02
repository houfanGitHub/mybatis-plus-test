package com.mybatis.plus.mapper;

import com.mybatis.plus.entity.User;
import com.mybatis.plus.entity.enums.GenderEnum;
import com.mybatis.plus.service.IUserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Classname DeleteTest
 * @Description TODO
 * @Date 2021/11/2 17:23
 * @Created by 侯凡
 */
@SpringBootTest
public class DeleteTest {

    @Autowired
    private IUserService userService;

    @AfterEach
    public void select(){
        System.out.println("***********根据id查询数据时会自动添加删除状态(正常)查询***************");
        System.out.println(userService.getById(2));
    }

    @Test
    public void testDelete(){
        userService.removeById(1);
    }

    @Test
    public void testUpdate(){
//        userService.updateById(
//                new User(1L, "Jone", 22, "test@test.com"));
        userService.updateById(
                new User(2L, "JackTest", 12, "test22@test.com"));
    }
}
