package com.example.schedulele_develop.dto;

import com.example.schedulele_develop.entity.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserResponse {
    private  final Long id;
    private final String username;
    private final String email;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;


    public UserResponse(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.createdAt = user.getCreatedAt();
        this.modifiedAt = user.getModifiedAt();
    }
}
