package com.example.domain.user.model;

import java.util.Date;

import lombok.Data;

@Data
public class MUser {
    private Integer employeeId;
    private String employeePass;
    private String employeeName;
    private String mail;
    private String phone;
    private Date anniversary;
    
    public Integer getEmployeeId() {
        return this.employeeId;
    }
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }
    
    public  String getEmployeePass() {
        return this.employeePass;
    }
    
    public void setEmployeePass(String employeePass) {
        this.employeePass = employeePass;
    }
    
    public  String getEmployeeName() {
        return this.employeeName;
    }
    
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
}

