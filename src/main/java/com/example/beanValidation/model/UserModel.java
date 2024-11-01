package com.example.beanValidation.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class UserModel {

    private String userId;

    @Email(message = "Invalid Email")
    private String email;

    @Pattern(regexp = "^\\d{10}$", message = "Invalid mobile number")
    private String mobile;

    @NotNull(message = "User name should not be null")
    private String name;

    private String gender;

    @Min(18)
    @Max(60)
    private int age;

    @NotBlank
    private String nationality;
}
