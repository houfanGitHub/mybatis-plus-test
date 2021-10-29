package com.mybatis.plus.mapper;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mybatis.plus.entity.User;
import com.mybatis.plus.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.converter.ObjectToStringHttpMessageConverter;

import java.util.Objects;

/**
 * @Classname PageTest
 * @Description
 * // 无条件分页查询
 * IPage<T> page(IPage<T> page);
 * // 条件分页查询
 * IPage<T> page(IPage<T> page, Wrapper<T> queryWrapper);
 * // 无条件分页查询
 * IPage<Map<String, Object>> pageMaps(IPage<T> page);
 * // 条件分页查询
 * IPage<Map<String, Object>> pageMaps(IPage<T> page, Wrapper<T> queryWrapper);
 * @Date 2021/10/29 14:11
 * @Created by 侯凡
 */
@SpringBootTest
public class PageTest {

    @Autowired
    private IUserService userService;

    @Test
    public void testPage(){
        userService.page(new Page<User>()).getRecords().forEach(System.out::println);
    }

    /**
     * 排序分页 （@OrderBy 注解没有找到）
     */
    @Test
    public void testPageAndOrderBy(){
        Page<User> userPage =
                userService.lambdaQuery().
                        orderByDesc(User::getId).page(new Page<User>());

        System.out.println(JSONObject.toJSONString(userPage.getRecords()));
    }
}
