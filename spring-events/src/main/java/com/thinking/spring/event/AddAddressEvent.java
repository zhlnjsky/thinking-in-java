package com.thinking.spring.event;

import com.thinking.spring.pojo.Address;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.util.List;
@Getter
public class AddAddressEvent extends ApplicationEvent {

    private final List<Address> addressList;

    public AddAddressEvent(Object source, List<Address> addressList) {
        super(source);
        this.addressList = addressList;
    }
}
