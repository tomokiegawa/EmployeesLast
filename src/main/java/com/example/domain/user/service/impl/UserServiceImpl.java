package com.example.domain.user.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.user.model.MUser;
import com.example.repository.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper mapper;

	@Override
	public void signup(MUser user) {
		mapper.insertOne(user);
	}
	public List<MUser> getUsers(MUser user) {
		return mapper.findMany(user);
	}
	/**ユーザー取得(１件)*/ 
	public MUser getUserOne(String employeeId)  {
		return mapper.findOne(employeeId);
	}
	/**ユーザー更新(１件)*/
	public void updateUserOne(String employeeId,
			 	String employeePass,
			 	String employeeName,
			 	String mail,
			 	String phone,
			 	Date anniversary) {
		 mapper.updateOne(employeeId, employeePass, employeeName, mail, phone, anniversary);
	 }
	/**ユーザー削除(１件)*/
	 public void deleteUserOne(String employeeId) {
		mapper.deleteOne(employeeId);
	}
}
