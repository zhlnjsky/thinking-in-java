package com.thinking.spring.convertion;

import com.thinking.spring.enumerate.CommonEnum;
import com.thinking.spring.util.EnumerateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

import java.util.Objects;

/**
 * <h1>CommonEnum子类枚举类型转换</h1>
 * @see CommonEnum
 * 1->n 一对多映射转换
 */
@Slf4j
//@Component
public class CommonEnumConverter implements ConverterFactory<String, CommonEnum> {
    @Override
    public <T extends CommonEnum> Converter<String, T> getConverter(Class<T> targetType) {
        log.info("获取转换器:[{}]", targetType);
        return new StringToCommonEnum<>(targetType);
    }

    private static class StringToCommonEnum<T extends CommonEnum> implements Converter<String, T> {

        private final Class<T> targetType;

        private StringToCommonEnum(Class<T> targetType) {
            this.targetType = targetType;
        }

        @Override
        public T convert(String source) {
            if (Objects.isNull(source) || source.trim().equals("")) {
                return null;
            }
            return EnumerateUtil.getByCode(Integer.valueOf(source), targetType);
        }
    }

}
