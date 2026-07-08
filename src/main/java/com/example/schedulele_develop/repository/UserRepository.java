package com.example.schedulele_develop.repository;

import com.example.schedulele_develop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
