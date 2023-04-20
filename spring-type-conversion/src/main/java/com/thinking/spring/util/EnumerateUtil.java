package com.thinking.spring.util;



import com.thinking.spring.enumerate.CommonEnum;

import java.util.Objects;

/**
 * <h1>枚举工具类</h1>
 */
public final class EnumerateUtil {

    private EnumerateUtil(){}

    public static <T extends CommonEnum> T getByCode(Integer code, Class<T> targetType){
        if(Objects.isNull(code)){
            return null;
        }
        T[] enumConstants = targetType.getEnumConstants();
        for (T enumConstant : enumConstants) {
            if(enumConstant.getCode().equals(code)){
                return enumConstant;
            }
        }
        return null;
    }

}
