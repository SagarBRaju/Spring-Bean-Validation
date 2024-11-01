package com.example.beanValidation.database;

import com.example.beanValidation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

    User findByUserId(String userId);
}
