package com.example.schedulele_develop.service;

import com.example.schedulele_develop.config.PasswordEncoder;
import com.example.schedulele_develop.entity.User;
import com.example.schedulele_develop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    public User login(String email, String password) {
        User user =userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("이메일 또는 비밀번호가 올바르지 않습니다"));
//        if(!user.getPassword().equals(password))
        //파라미터 순서 중요 : matches(패스워드 , db에 들어있는 암호문 패스워드)
            if(!passwordEncoder.matches(password, user.getPassword())){
            throw new IllegalArgumentException("이메일 또는 비밀번호가 올바르지 않습니다");
        }
          return user;
    }
}
