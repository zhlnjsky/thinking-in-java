package com.thinking.spring.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thinking.spring.event.AddAddressEvent;
import com.thinking.spring.event.SendEmailEvent;
import com.thinking.spring.pojo.User;
import com.thinking.spring.service.IUserService;
import com.thinking.spring.util.ApplicationEventPublisherHolder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements IUserService {

    private final  ObjectMapper objectMapper;
    private final ApplicationEventPublisherHolder applicationEventPublisherHolder;
    @Override
    public User addUser(User user) {
        try {
            log.info("add User:[{}]", objectMapper.writeValueAsString(user));
            user.setId(1);
            // 发送添加地址事件
            applicationEventPublisherHolder.publishEvent(new AddAddressEvent(this,user.getAddressList()));
            // 发送邮件事件
            applicationEventPublisherHolder.publishEvent(new SendEmailEvent(this, user.getId()));
        } catch (JsonProcessingException e) {
            throw new RuntimeException("类型转换异常");
        }
        return user;
    }
}
