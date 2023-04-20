package com.thinking.spring.convertion;


import com.thinking.spring.container.ConvertiblePairContainer;
import com.thinking.spring.enumerate.CommonEnum;
import com.thinking.spring.enumerate.Gender;
import com.thinking.spring.enumerate.UserState;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.ConditionalGenericConverter;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;

/**
 *
 */
@RequiredArgsConstructor
@Component
public class CommonEnumConditionalGenericConverter implements ConditionalGenericConverter {
    private final ConvertiblePairContainer container;
    @Override
    public boolean matches(TypeDescriptor sourceType, TypeDescriptor targetType) {
        return sourceType.getObjectType().equals(String.class) && (targetType.getObjectType().equals(Gender.class) || targetType.getObjectType().equals(UserState.class));
    }

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        return container.getConvertiblePair();
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        String s = (String) source;

        Map<Class<?>, Map<Integer, CommonEnum>> commonEnumMap = container.getCommonEnumMap();
        Map<Integer, CommonEnum> integerCommonEnumMap = commonEnumMap.get(targetType.getType());
        CommonEnum commonEnum = integerCommonEnumMap.get(Integer.valueOf(s));
        return commonEnum;
    }
}
