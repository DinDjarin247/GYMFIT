package com.example.GYMFIT.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.*;
//import org.springframework.context.annotation.Role;


@Getter
@Setter
@Entity
@Table(name = "user")
@ToString
public class User {


    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String userEmail;  //사용자 이메일

    @Column
    private String userPassword;   // 사용자 패스워드

    @Column
    private String userAdr;         // 사용자 주소

    @Column
    private String userCno;     // 사용자 연락처

    @Column
    private String userNm;      // 사용자 이름

    @Column
    private String userBirthDt;     // 사용자 생년월일


    //User생성자 추가
    public User(Long id,String userEmail,String userPassword,String userAdr,String userCno, String userNm,String userBirthDt){
        this.id = id;
        this.userEmail= userEmail;
        this.userPassword = userPassword;
        this.userAdr = userAdr;
        this.userCno = userCno;
        this.userNm = userNm;
        this.userBirthDt = userBirthDt;
    }
}

