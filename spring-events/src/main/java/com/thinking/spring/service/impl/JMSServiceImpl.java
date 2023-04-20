package com.thinking.spring.service.impl;

import com.thinking.spring.service.IJMSService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class JMSServiceImpl implements IJMSService {
    @Override
    public void sendEmail(Integer userId) {
        log.info("用户[{}]发送注册确认邮件", userId);
    }
}
