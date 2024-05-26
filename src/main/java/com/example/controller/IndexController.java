package com.example.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.user.model.MUser;
import com.example.domain.user.service.impl.UserService;
import com.example.form.UserListForm;

@Controller
@RequestMapping("/index")
public class IndexController {
	@Autowired
	private UserService userService;

	@Autowired
	private ModelMapper modelMapper;

	/** ユーザー⼀覧画⾯を表⽰ */
	@GetMapping
	public String getUserList(@ModelAttribute UserListForm form, Model model, BindingResult bindingResult) {
		
		MUser user = modelMapper.map(form, MUser.class);
		List<MUser> userList = userService.getUsers(user);
		// Modelに登録
		model.addAttribute("userList", userList);
		return "index";
	}
	/** ユーザー検索処理 */
	@PostMapping
	public String postUserList(@ModelAttribute UserListForm form, Model model) {
		// ログを追加
	    System.out.println("Form submitted: " + form);
		
		// formをMUserクラスに変換
		MUser user = modelMapper.map(form, MUser.class);
		// ユーザー検索
		List<MUser> userList = userService.getUsers(user);
		// Modelに登録 
		model.addAttribute("userList", userList);
		// ユーザー⼀覧画⾯を表⽰
		return "index";
	}
	
	
}
