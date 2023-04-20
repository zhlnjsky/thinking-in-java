package com.thinking.spring.enumerate;

import lombok.Getter;

/**
 * <h1>用户状态枚举</h1>
 */
@Getter
public enum UserState implements CommonEnum{
    ENABLE(1,"启用"),DISABLE(2, "禁用")
    ;

    UserState(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    private final Integer code;
    private final String description;
}
