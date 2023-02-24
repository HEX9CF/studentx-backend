package com.example.domain;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String name;
    private String passwd;
    private String email;
    private String phone;
    private String sex;
    private Integer birthyear;
    private Integer birthmonth;
    private Integer birthday;
    private String school;
    private String major;
    private String location;
    private String hometown;
    private String signature;
}
