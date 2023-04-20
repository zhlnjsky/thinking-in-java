package com.thinking.spring.event.listener;

import com.thinking.spring.event.AddAddressEvent;
import com.thinking.spring.pojo.Address;
import com.thinking.spring.service.IAddressService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.List;
@Slf4j
@RequiredArgsConstructor
@Component
public class AddAddressEventListener implements ApplicationListener<AddAddressEvent> {

    private final IAddressService addressService;

    @Override
    public void onApplicationEvent(AddAddressEvent event) {
        log.info("处理添加地址事件");
        List<Address> addressList = event.getAddressList();
        addressList.stream().forEach(addressService::addAddress);
    }
}
