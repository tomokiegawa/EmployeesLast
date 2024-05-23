package com.example.form;

import java.util.Date;

import lombok.Data;

@Data
public class UserDetailForm {
		private String employeeId;
		private String employeePass;
		private String employeeName;
		private String mail;
		private String phone;
		private Date anniversary;	
}
