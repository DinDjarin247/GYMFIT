package com.example.GYMFIT.controller;

import com.example.GYMFIT.dto.UserFormDto;
import com.example.GYMFIT.entity.User;
import com.example.GYMFIT.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

public class UserScrnController {

    @Autowired
    private UserService userService;

    @GetMapping("/users/new-page")  // 페이지 보여주기
    public String newUser(Model model) {
        model.addAttribute("userFormDto", new UserFormDto());
        return "user/userForm";  //회원가입 페이지를 보여줌
    }

    @PostMapping("/users/new-page")   // 사용자 등록 페이지에서 사용자 정보 제출
    public String createUserAndShowPage(@ModelAttribute("userFormDto") UserFormDto userFormDto, Model model){//form에서 넘어온 데이터 처리
        User createdUser = userService.create(userFormDto);
        if(createdUser != null){
            return "user/userLoginForm";   // 경로를 변경하면 된다.<임의경로>    // 회원가입이 성공하면 여기로 온다.
        }else{
            model.addAttribute("errorMessage", "실패, 다시 ㄱㄱㄱ");    // ㅇ
            return "redirect:/user/userForm";   // 같은 이메일이면 여기로 돌아옴(가입안됨)
        }
    }
}
