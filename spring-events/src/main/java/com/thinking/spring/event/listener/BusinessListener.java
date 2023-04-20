package com.thinking.spring.event.listener;

import com.thinking.spring.event.SendEmailEvent;
import com.thinking.spring.service.IJMSService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class BusinessListener {

    private final IJMSService jmsService;
    @EventListener
    public void sendEmail(SendEmailEvent event){
        Integer userId = event.getUserId();
        log.info("处理用户[{}]发送确认邮件事件", userId);
        jmsService.sendEmail(userId);
    }

}
