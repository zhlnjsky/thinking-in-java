package com.thinking.spring.pojo;

import lombok.Data;

/**
 * <h1>地址信息</h1>
 */
@Data
public class Address {
    /**
     * <h2>省</h2>
     */
    private String province;
    /**
     * <h2>市</h2>
     */
    private String city;
    /**
     * <h2>区</h2>
     */
    private String region;
}
