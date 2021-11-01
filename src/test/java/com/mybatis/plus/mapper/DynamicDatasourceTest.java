package com.mybatis.plus.mapper;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.mybatis.plus.entity.User;
import com.mybatis.plus.entity.enums.GenderEnum;
import com.mybatis.plus.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @Classname DynamicDatasourceTest
 * @Description TODO
 * @Date 2021/10/29 17:47
 * @Created by 侯凡
 */
@SpringBootTest
public class DynamicDatasourceTest {

    @Resource(name = "userService")
    private IUserService userService;

    @Resource(name = "userSlaveService")
    private IUserService userSlaveService;

    /**
     * 使用动态数据源注意事项
     * 1.为不同数据源添加变动数据时，需要在不同的事务下.
     *  共用一个事务就达不到切换数据源的效果，需要设置事务的传播机制
     * 2.同一事务下查询时，不可以使用lambdaQuery() query()
     * 3.必须master库方法先执行，才能回滚，达到事务效果
     */
    @Test
    public void testDynamicDatasource(){
        //分别向数据库中添加数据
        userService.save(new User("testUser26", 22, "testUser26@test.com", GenderEnum.MAN));

        userSlaveService.save(
                new User("testSlaveUser26", 22, "testSlaveUser26@test.com", GenderEnum.WUMAN));

        System.out.println("*****************************************");
        //分别查询“testUser”信息
        User user = userService.getOne(new QueryWrapper<User>().lambda().eq(User::getName,"testUser26"));
//        User user = userService.lambdaQuery().eq(User::getName, "testUser26").one();
//        User user = userService.query().eq("name", "testUser26").one();
        System.out.println(JSONObject.toJSONString(user));

        User slaveUser = userSlaveService.getOne(new QueryWrapper<User>().lambda().eq(User::getName, "testUser26"));
//        User slaveUser = userSlaveService.lambdaQuery().eq(User::getName, "testUser26").one();
//        User slaveUser = userService.query().eq("name", "testUser26").one();
        System.out.println(JSONObject.toJSONString(slaveUser));

        System.out.println("*****************************************");

    }

    @Test
    public void testUserSlave(){
        User slaveUser = new User("testSlaveUser", 22, "testSlaveUser@test.com", GenderEnum.WUMAN);
        boolean testSlaveUser = userSlaveService.save(slaveUser);
        System.out.println(JSONObject.toJSONString(slaveUser));
    }
}
