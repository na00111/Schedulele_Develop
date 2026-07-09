package com.example.schedulele_develop.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserRequest {
    private String username;
    private String email;
    private String password;
}
