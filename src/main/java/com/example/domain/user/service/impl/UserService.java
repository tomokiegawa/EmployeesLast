package com.example.domain.user.service.impl;

import java.util.Date;
import java.util.List;

import com.example.domain.user.model.MUser;

public interface UserService {

	/**ユーザー登録*/
	public void signup(MUser user);
	
	/**ユーザー取得*/
	public List<MUser> getUsers(MUser user);
	
	/**ユーザー取得(１件)*/
 public MUser getUserOne(String employeeId);
 
 /**ユーザー更新(１件)*/
 public void updateUserOne(String employeeId,
		 	String employeePass,
		 	String employeeName,
		 	String mail,
		 	String phone,
		 	Date anniversary);
 
 /**ユーザー削除(１件)*/
 public void deleteUserOne(String employeeId);
}
