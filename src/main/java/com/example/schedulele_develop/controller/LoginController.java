package com.example.schedulele_develop.controller;

import com.example.schedulele_develop.dto.LoginRequest;
import com.example.schedulele_develop.entity.User;
import com.example.schedulele_develop.service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class LoginController {
    private final LoginService loginService;
    @PostMapping("/login")
    public ResponseEntity<String> login(
            @RequestBody LoginRequest request,
            HttpServletRequest httpServletRequest
            //자바 서블릿이 제공하는 원초적인 요청 객체 (세션을 꺼낼 수 있다)
            ) {
        //서비스에서 로그인 아이디/ 비번 검증
        User loginUser = loginService.login(request.getEmail(), request.getPassword());
        //세션 주머니 가져오기 (true를 넣으면 세션이 없을 때 새로 만들어 준다.)
        HttpSession seesion = httpServletRequest.getSession(true);
        //세션 주머니에 로그인한 유저의 정보를 보관해두기
        seesion.setAttribute("LOGIN_USER" , loginUser.getId());
        return ResponseEntity.ok("로그인 성공");
    }
}
