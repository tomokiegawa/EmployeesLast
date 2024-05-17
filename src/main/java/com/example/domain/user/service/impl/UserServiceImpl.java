package com.example.domain.user.service.impl;

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
	
	@Override
	public List<MUser> getUsers() {
		return mapper.findMany();
	}
	
//
//	public List<MUser> getAllEmployees() {
//		return mapper.findMany();
//	}


}
