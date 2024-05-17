package com.example.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.user.model.MUser;
import com.example.domain.user.service.impl.UserService;
import com.example.form.RegistForm;

@Controller
@RequestMapping("/regist")
public class RegistController {
	
	//エラーメッセージの国際化対応
	//@Autowired
	//private MessageSource messageSource;
	//p203@Autowired
	//private UserApplicationService userApplicationService;
//性別MAPなので今回は未作成
	
	@Autowired
	private UserService userService;
	@Autowired
	private ModelMapper modelMapper;

	@GetMapping
    public String getRegist(Model model, @ModelAttribute RegistForm form) {
        return "regist"; // スラッシュいらない
    }

    @PostMapping
    public String postRegist(Model model, @ModelAttribute @Validated RegistForm form, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return getRegist(model, form); // getRegist()を呼び出してエラーメッセージを表示
        }
        try {
        MUser user = modelMapper.map(form, MUser.class);
        userService.signup(user);
        } catch (DuplicateKeyException e) {
            model.addAttribute("errorMessage", "重複した社員番号が存在します。別の社員番号を使用してください。");
            return getRegist(model, form);
        } catch (Exception e) {
            model.addAttribute("errorMessage", "登録中にエラーが発生しました。再度お試しください。");
            return getRegist(model, form);
        }
        return "redirect:/index";
    }

}



//model.addAttribute("errors", bindingResult.getAllErrors());

