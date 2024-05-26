package com.example.form;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UserDetailForm {
		private String employeeId;
	    
		private String employeePass;
		
		@NotBlank(message = "ユーザー名が入力されていません")
		private String employeeName;
		
		private String mail;
		private String phone;
		@NotNull(message = "入社日が入力されていません")
		private Date anniversary;	
}
