package com.thinking.spring.util;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationEventPublisherHolder implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher applicationEventPublisher;

    public void publishEvent(ApplicationEvent event){
        applicationEventPublisher.publishEvent(event);
    }

    private void publishEvent(Object event){
        applicationEventPublisher.publishEvent(event);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
