package com.mybatis.plus.mapper;

import com.mybatis.plus.entity.User;
import com.mybatis.plus.service.IUserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

/**
 * @Classname SaveOrUpdate
 * @Description TODO
 * @Date 2021/10/29 13:50
 * @Created by 侯凡
 */
@SpringBootTest
public class SaveOrUpdate {

    @Autowired
    private IUserService userService;

    @AfterEach
    public void selectAll(){
        userService.list().forEach(System.out::println);
    }

    @Test
    public void testSaveOrUpdate(){
        userService.saveOrUpdate(new User(1L, "Jone111", 28, "test@test.com"));
    }

    @Test
    public void testSaveOrUpdateBatch(){
        List<User> userList = Arrays.asList(
                new User(2L, "Jack", 22, "test2@test.com"),
                new User("JackCopy", 23, "test2@test.com"),
                new User("Sandy", 23, "test3@test.com")
        );
        boolean updateBatch = userService.saveOrUpdateBatch(userList);
        System.out.println(updateBatch);
    }
}
