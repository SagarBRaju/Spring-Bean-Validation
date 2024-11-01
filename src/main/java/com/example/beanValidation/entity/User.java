package com.example.beanValidation.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user_details")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String userId;

    private String email;

    private String mobile;

    private String name;

    private String gender;

    private int age;

    private String nationality;
}
