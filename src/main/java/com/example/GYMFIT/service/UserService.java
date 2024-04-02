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
        // 사용자 이메일이 이미 존재하는지 확인
        if(!userRepository.existsByUserEmail(dto.getUserEmail())){
            User user = dto.toEntity(); //dto->엔티티로 변환한 후 User에 저장
            return userRepository.save(user);  // 사용자 저장 후 반환
        }
        return null;  // 이미 존재하는 사용자 이메일이라면 null반환.
    }
}
