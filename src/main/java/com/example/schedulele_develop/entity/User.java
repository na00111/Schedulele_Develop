package com.example.schedulele_develop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
@Entity

public class User extends BaseEntity{
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String emil;

}
