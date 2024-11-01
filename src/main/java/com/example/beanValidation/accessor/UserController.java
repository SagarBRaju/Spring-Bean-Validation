package com.example.beanValidation.accessor;

import com.example.beanValidation.core.UserService;
import com.example.beanValidation.entity.User;
import com.example.beanValidation.exception.UserNotFoundException;
import com.example.beanValidation.model.UserModel;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/v1")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping(value = "/signUp")
    public ResponseEntity<User> saveUser(@RequestBody @Valid UserModel userModel) {
        return new ResponseEntity<>(userService.saveUser(userModel), HttpStatus.CREATED);
    }

    @GetMapping("/fetchAll")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getALlUsers());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable String userId) throws UserNotFoundException {
        return ResponseEntity.ok(userService.getUser(userId));
    }
}
