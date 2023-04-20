package com.thinking.spring.convertion;

import com.thinking.spring.enumerate.Gender;
import com.thinking.spring.enumerate.UserState;
import com.thinking.spring.util.EnumerateUtil;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

import java.util.HashSet;
import java.util.Set;

/**
 * <h1>CommonEnum子类枚举类型转换</h1>
 * @see com.thinking.spring.enumerate.CommonEnum
 * n->n 多对多映射转换
 */
//@Component
public class CommonEnumGenericConverter implements GenericConverter {
    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        ConvertiblePair genderConvertiblePair = new ConvertiblePair(String.class, Gender.class);
        ConvertiblePair userStateConvertiblePair = new ConvertiblePair(String.class, UserState.class);
        Set<ConvertiblePair> convertiblePairSet = new HashSet<>();
        convertiblePairSet.add(genderConvertiblePair);
        convertiblePairSet.add(userStateConvertiblePair);
        return convertiblePairSet;
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        String s = (String) source;
        if (targetType.getType().equals(Gender.class)) {
            return EnumerateUtil.getByCode(Integer.valueOf(s), Gender.class);
        } else if(targetType.getType().equals(UserState.class)){
            return EnumerateUtil.getByCode(Integer.valueOf(s), UserState.class);
        } else {
            return null;
        }
    }
}
