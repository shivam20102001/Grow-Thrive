package com.example.growthrive.domain;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String username;
    private String email;
    private String password;
    private String profileImage;
    private String firstName;
    private String middleName;
    private String lastName;
    private Boolean isActive;
}
