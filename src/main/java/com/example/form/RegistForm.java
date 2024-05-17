package com.example.form;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class RegistForm {

	@NotNull(message = "{社員番号が入力されていません}")
	@Min(value = 1, message = "{社員番号は1以上の値である必要があります}")
	private Integer employeeId;

	private String employeePass;
	@NotBlank(message = "{ユーザー名が入力されていません}")
	private String employeeName;

	@Email(message = "{社員番号が入力されていません}")
	private String mail;
	
	private String phone;

	@NotNull(message = "{入社日が入力されていません}")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date anniversary;
	
	 public Integer getEmployeeId() {
	        return employeeId;
	    }

	    public void setEmployeeId(Integer employeeId) {
	        this.employeeId = employeeId;
	    }

	    public String getEmployeePass() {
	        return employeePass;
	    }

	    public void setEmployeePass(String employeePass) {
	        this.employeePass = employeePass;
	    }

	    public String getEmployeeName() {
	        return employeeName;
	    }

	    public void setEmployeeName(String employeeName) {
	        this.employeeName = employeeName;
	    }
	
	
}
