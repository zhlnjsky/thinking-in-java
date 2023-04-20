package com.thinking.spring.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
@Getter
public class SendEmailEvent extends ApplicationEvent {

    private final Integer userId;

    public SendEmailEvent(Object source, Integer userId) {
        super(source);
        this.userId = userId;
    }
}
