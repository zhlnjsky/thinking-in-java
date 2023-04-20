package com.thinking.spring.enumerate;

import lombok.Getter;

/**
 * <h1>性别枚举</h1>
 */
@Getter
public enum Gender implements CommonEnum{
    MALE(1, "男性"),FEMALE(2,"女性")
    ;

    Gender(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    private final Integer code;
    private final String description;
}
