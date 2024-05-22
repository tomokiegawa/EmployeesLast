package com.example.form;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class UserListForm {
	private int employeeId;
	private String  employeeName;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date anniversary;
}
