package com.thinking.spring.pojo;

;
import com.thinking.spring.enumerate.Gender;
import com.thinking.spring.enumerate.UserState;
import lombok.Data;

@Data
public class User {
    private Integer id;
    private String name;
    private Gender gender;
    private UserState userState;
}
