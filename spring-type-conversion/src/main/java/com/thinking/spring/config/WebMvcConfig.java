package com.thinking.spring.config;


import com.thinking.spring.convertion.CommonEnumConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@RequiredArgsConstructor
//@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    private final CommonEnumConverter commonEnumConverter;

    @Override
    protected void addFormatters(FormatterRegistry registry) {
        registry.addConverterFactory(commonEnumConverter);
    }
}
