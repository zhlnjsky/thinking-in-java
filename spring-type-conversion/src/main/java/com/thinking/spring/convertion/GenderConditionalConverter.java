package com.thinking.spring.convertion;


import com.thinking.spring.enumerate.Gender;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.ConditionalConverter;
import org.springframework.core.convert.converter.Converter;

//@Component
public class GenderConditionalConverter implements ConditionalConverter, Converter<String, Gender> {
    @Override
    public boolean matches(TypeDescriptor sourceType, TypeDescriptor targetType) {
        return sourceType.getObjectType().equals(String.class) && targetType.getObjectType().equals(Gender.class);
    }

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
