package com.thinking.spring.pojo;

import lombok.Data;

import java.util.List;

/**
 *  <h1>用户信息</h1>
 */
@Data
public class User {
    /**
     * <h2>用户id</h2>
     */
    private Integer id;
    /**
     * <h2>用户名称</h2>
     */
    private String name;
    /**
     * <h2>用户地址</h2>
     */
    private List<Address> addressList;
}
