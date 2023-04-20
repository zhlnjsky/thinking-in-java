package com.thinking.spring.convertion;


import com.thinking.spring.enumerate.Gender;
import org.springframework.core.convert.converter.Converter;

/**
 * 使用Converter接口处理枚举转换
 */
//@Component
public class GenderConverter implements Converter<String, Gender> {
    @Override
    public Gender convert(String source) {
        Gender[] enumConstants = Gender.class.getEnumConstants();
        for (Gender enumConstant : enumConstants) {
            if (source.equals(String.valueOf(enumConstant.getCode()))) {
                return enumConstant;
            }
        }
        return null;
    }
}
