package com.mybatis.plus.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @Classname BaseEntity
 * @Description TODO
 * @Date 2021/10/28 16:25
 * @Created by 侯凡
 */
@Data
public class BaseEntity {

    @TableField(exist = false)
    private Page page;

}
