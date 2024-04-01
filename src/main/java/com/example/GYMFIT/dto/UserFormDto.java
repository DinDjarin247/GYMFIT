package com.example.GYMFIT.dto;

import com.example.GYMFIT.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor  //생성자들을 저장하는 메서드
@RequiredArgsConstructor
@Getter
@Setter
@ToString // 데이터를 잘 받았는지 확인하는 메서드 대신 사용 어노테이션
public class UserFormDto {


    @NotEmpty(message = "이메일은 필수 입력 값입니다.")
    @Email(message = "이메일 형식으로 입력해주세요.")
    private String userEmail;   // 사용자 이메일

    @NotEmpty(message = "비밀번호는 필수 입력 값입니다.")
    @Length(min=8, max=16, message = "비밀번호는 8자 이상, 16자 이하로 입력해주세요")
    private String userPassword;   // 사용자 패스워드

    @NotEmpty(message = "주소는 필수 입력 값입니다.")
    private String userAdr;         // 사용자 주소

    @NotEmpty(message = "연락처는 필수 입력 값입니다.")
    private String userCno;     // 사용자 연락처

    @NotEmpty(message = "연락처는 필수 입력 값입니다.")
    private String userNm;      // 사용자 이름

    private String userBirthDt;     // 사용자 생년월일

    public User toEntity() {
        return new User (null,userEmail,userPassword,userAdr,userCno,userNm,userBirthDt);
    }
}

