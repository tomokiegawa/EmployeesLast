package com.example.domain.user.model;

import java.util.Date;

import lombok.Data;

@Data
public class MUser {
    private String employeeId;
    private String employeePass;
    private String employeeName;
    private String mail;
    private String phone;
    private Date anniversary;
}

