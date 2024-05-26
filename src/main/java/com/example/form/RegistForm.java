package com.example.form;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class RegistForm {

	@NotBlank(message = "社員番号が入力されていません")
	private String employeeId;

	private String employeePass;
	
	@NotBlank(message = "ユーザー名が入力されていません")
	private  String employeeName;


	private String mail;
	
	private String phone;

	@NotNull(message = "入社日が入力されていません")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date anniversary;
}
