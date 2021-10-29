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
 * @Classname SaveTest
 * @Description TODO
 * @Date 2021/10/29 11:02
 * @Created by 侯凡
 */
@SpringBootTest
public class SaveTest {

    @Autowired
    private IUserService userService;

    @AfterEach
    public void selectAll(){
        userService.list().forEach(System.out::println);
    }

    @Test
    public void testSave(){
        userService.save(new User("Test", 24, "test@test.com"));
    }

    /**
     * 设置开启数据库批量提交&rewriteBatchedStatements=true，可以解决批量插入慢的问题
     * batchSize 插入批次数量(每次插入多少条)
     */
    @Test
    public void testSaveBatch(){
        List<User> userList = Arrays.asList(
                new User("TestList011", 21, "list011@test.com"),
                new User("TestList021", 21, "list021@test.com"),
                new User("TestList031", 21, "list031@test.com")
        );
        userService.saveBatch(userList, 2);
    }
}
