package com.example.GYMFIT.repository;


import com.example.GYMFIT.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}

