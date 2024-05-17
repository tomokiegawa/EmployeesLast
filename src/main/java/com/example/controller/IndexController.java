package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.domain.user.model.MUser;
import com.example.domain.user.service.impl.UserService;

@Controller
public class IndexController {
	@Autowired
	private UserService userService;

	/** ユーザー⼀覧画⾯を表⽰ */
	@GetMapping("/index")
	public String getUserList(Model model) {
		// ユーザー⼀覧取得
		List<MUser> userList = userService.getUsers();
		// Modelに登録
		model.addAttribute("userList", userList);
		// ユーザー⼀覧画⾯を表⽰
		return "index";
	}
}
