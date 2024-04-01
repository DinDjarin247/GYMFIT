package com.example.GYMFIT.service;

import com.example.GYMFIT.dto.UserFormDto;
import com.example.GYMFIT.entity.User;
import com.example.GYMFIT.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public User create(UserFormDto dto) {
        User user = dto.toEntity(); //dto->엔티티로 변환한 후 User에 저장
        if(user.getId() != null ){   // user 객체에 id가 존재한다면(null이 아니라면) null을 반환하는 코드 추가
            return null;
        }
        return userRepository.save(user);  //user을 DB에 저장
    }


}
