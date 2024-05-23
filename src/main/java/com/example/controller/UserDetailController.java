package com.example.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.user.model.MUser;
import com.example.domain.user.service.impl.UserService;
import com.example.form.RegistForm;
import com.example.form.UserDetailForm;

@Controller
@RequestMapping("/templates")
public class UserDetailController {
			@Autowired
			private UserService userService;
			@Autowired
			private ModelMapper modelMapper;
		
			/**日付入力のバリデーション*/
			@InitBinder
		    public void initBinder(WebDataBinder binder) {
		        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		        dateFormat.setLenient(false);
		        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		    }
		
			/** ユーザー編集画⾯を表⽰ */
			@GetMapping("/edit/{employeeId:.+}")
			public String getUser(UserDetailForm form, Model model,
			@PathVariable("employeeId") String employeeId)  {
			// ユーザーを1件取得
			MUser user = userService.getUserOne(employeeId);
			user.setEmployeePass(null);
			// MUserをformに変換
			form = modelMapper.map(user, UserDetailForm.class);
			// Modelに登録
			model.addAttribute("userDetailForm", form);
			// ユーザー詳細画⾯を表⽰
			return "edit";
			}
			/** ユーザー更新処理 */
			@PostMapping(value = "/edit", params = "update")
			public String updateUser(UserDetailForm form, Model model) {
			// ユーザーを更新
			userService.updateUserOne(form.getEmployeeId(),
					form.getEmployeePass(),
					form.getEmployeeName(),
					form.getMail(),
					form.getPhone(),
					form.getAnniversary());
		// ユーザー⼀覧画⾯にリダイレクト
					return "redirect:/index";
					}
			/** ユーザー削除処理 */
			@PostMapping("/delete")
			public String deleteUser(RegistForm form, Model model) {
			    userService.deleteUserOne(form.getEmployeeId());
			    return "redirect:/index";
			}
			
}
