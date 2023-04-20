package com.thinking.spring.container;


import com.thinking.spring.enumerate.CommonEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <h1>ConvertiblePair容器</h1>
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class ConvertiblePairContainer {
    private final String basePackage = "com.thinking.spring.enumerate";

    private final ResourceLoader resourceLoader;
    private static final String DEFAULT_RESOURCE_PATTERN = "**/*.class";
    private static final String BASE__ENUM_CLASS_NAME = CommonEnum.class.getName();
    private Set<GenericConverter.ConvertiblePair> convertiblePairSet = new HashSet<>();
    private Map<Class<?>,Map<Integer, CommonEnum>> map = new HashMap();


    public Set<GenericConverter.ConvertiblePair> getConvertiblePair() {
        return convertiblePairSet;
    }
    public Map<Class<?>,Map<Integer, CommonEnum>> getCommonEnumMap() {
        return map;
    }

    @PostConstruct
    public void initContainer() {
        if (StringUtils.isEmpty(basePackage)) {
            return;
        }
        ResourcePatternResolver resourcePatternResolver = ResourcePatternUtils.getResourcePatternResolver(this.resourceLoader);
        MetadataReaderFactory metadataReaderFactory = new SimpleMetadataReaderFactory();
        try {
            String pkg = toPackage(this.basePackage);
            // 对 basePackage 包进行扫描
            String packageSearchPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX +
                    pkg + DEFAULT_RESOURCE_PATTERN;
            Resource[] resources = resourcePatternResolver.getResources(packageSearchPath);
            for (Resource resource : resources) {
                if (resource.isReadable()) {
                    try {
                        MetadataReader metadataReader = metadataReaderFactory.getMetadataReader(resource);
                        ClassMetadata classMetadata = metadataReader.getClassMetadata();

                        String[] interfaceNames = classMetadata.getInterfaceNames();
                        // 实现 BASE_ENUM_CLASS_NAME 接口
                        if (Arrays.asList(interfaceNames).contains(BASE__ENUM_CLASS_NAME)) {
                            String className = classMetadata.getClassName();

                            // 加载 cls
                            Class cls = Class.forName(className);

                            if (cls.isEnum() && CommonEnum.class.isAssignableFrom(cls)) {
                                GenericConverter.ConvertiblePair pair = new GenericConverter.ConvertiblePair(String.class, cls);
                                convertiblePairSet.add(pair);
                                Object[] enumConstants = cls.getEnumConstants();
                                Map<Integer, CommonEnum> collect = Arrays.stream(enumConstants).filter(c -> c instanceof CommonEnum).map(c -> (CommonEnum) c).collect(Collectors.toMap(c -> c.getCode(), Function.identity()));
                                map.put(cls, collect);
                            }
                        }
                    } catch (ClassNotFoundException ex) {
                        // ignore  类不存在
                    }
                }
            }
        } catch (IOException e) {
            log.error("failed to load dict by auto register", e);//获取资源异常
        }
    }

    private String toPackage(String basePackage) {
        String result = basePackage.replace(".", "/");
        return result + "/";
    }

//    private String convertKeyFromClassName(String className) {
//        return Character.toLowerCase(className.charAt(0)) + className.substring(1);
//    }

}
