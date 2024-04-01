package com.example.GYMFIT.controller;

import com.example.GYMFIT.dto.UserFormDto;
import com.example.GYMFIT.entity.User;
import com.example.GYMFIT.repository.UserRepository;
import com.example.GYMFIT.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController  //컨트롤러선언.
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users/new")  // 회원생성
    public ResponseEntity<User> newUser(@RequestBody UserFormDto dto) {   //RequestBody는 Json데이터로 받아와야함
        User created =  userService.create(dto); //서비스로 생성
        return (created != null) ?   //생성하면 정상, 실패하면 오류 응답
                ResponseEntity.status(HttpStatus.OK).body(created):  //상태는 OK, 본문에는 created
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();  // 실패시 상태는 BAD_REQUEST , 본문은 없으므로 build로
    }

}

//      서비스를 사용하지 않았을 때
//    @Autowired
//    private UserRepository userRepository;
//
//    @PostMapping("/users/new")
//    public String newUser(@RequestBody UserFormDto dto) {   //RequestBody는 Json데이터로 받아와야함
//        User user = dto.toEntity();
//        log.info(user.toString());
//        User saved = userRepository.save(user);
//        log.info(saved.toString());
//        return "";
//    }
//
//}



