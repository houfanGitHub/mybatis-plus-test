package com.mybatis.plus.entity.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * @Classname GenderEnum
 * @Description TODO
 * @Date 2021/10/29 15:33
 * @Created by 侯凡
 */
public enum GenderEnum {

    MAN("M", "男"),
    WUMAN("F", "女");

    GenderEnum(String genderCode, String genderDesc) {
        this.genderCode = genderCode;
        this.genderDesc = genderDesc;
    }

    @EnumValue
    private final String genderCode;

    private final String genderDesc;

}
