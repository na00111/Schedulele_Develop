package com.example.schedulele_develop.controller;

import com.example.schedulele_develop.dto.UserRequest;
import com.example.schedulele_develop.dto.UserResponse;
import com.example.schedulele_develop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //json 순수 데이터를 리턴
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private  final UserService userService;
    //서비스를 의존성 주입
    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest request) {
        //@RequestBody -> 클라이언트가 보낸 json 데이터 바디를 자바의 가방 객체 (UesrRequest)로 가공해서 집어넣는다.
        //ResponseEntity -> 스프링에서 제공하는 응답 캡슐
        return  new ResponseEntity<>(userService.createUser(request), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return ResponseEntity.ok(userService.findAllUsers());
    }
    @GetMapping("/{id}") //주소창 뒤에 가변적인 변수값
    public ResponseEntity<UserResponse>  getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findUserById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long id,@RequestBody UserRequest request) {
        return ResponseEntity.ok(userService.updateUser(id, request));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("유저 삭제 완료 id=" +id);
    }
}
