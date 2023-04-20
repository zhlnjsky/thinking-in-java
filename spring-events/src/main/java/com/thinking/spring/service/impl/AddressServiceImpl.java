package com.thinking.spring.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thinking.spring.pojo.Address;
import com.thinking.spring.service.IAddressService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Slf4j
@RequiredArgsConstructor
@Service
public class AddressServiceImpl implements IAddressService {

    private final ObjectMapper objectMapper;

    @Override
    public Address addAddress(Address address) {
        try {
            log.info("添加地址:[{}]", objectMapper.writeValueAsString(address));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return address;
    }
}
