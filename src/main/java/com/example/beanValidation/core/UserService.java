package com.example.beanValidation.core;

import com.example.beanValidation.database.UserRepository;
import com.example.beanValidation.entity.User;
import com.example.beanValidation.exception.UserNotFoundException;
import com.example.beanValidation.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User saveUser(UserModel userModel) {
        User user = User.build(0, generateUserId(), userModel.getEmail(), userModel.getMobile(), userModel.getName(), userModel.getGender(), userModel.getAge(), userModel.getNationality());
        return userRepository.save(user);
    }

    public String generateUserId() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replaceAll("-", "");
    }

    public List<User> getALlUsers() {
        return userRepository.findAll();
    }


    public User getUser(String userId) throws UserNotFoundException {
        User user = userRepository.findByUserId(userId);
        if (user != null) {
            return user;
        } else {
            throw new UserNotFoundException("user not found with userId : " + userId);
        }
    }
}
