package com.example.schedulele_develop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Entity
@Getter
@NoArgsConstructor //파라미터 없는 기본 생성자
@Table(name ="users") //매핑할 데이터베이스 이름 명시
public class User extends BaseEntity{
    @Id //테이블의 pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //pk 생성 전략
    private Long id; //대용량 데이터를 고려하여 참조형 Long(객체)를 쓴다.
    @Column(nullable = false) //값이 비어있으면 저장 안됨.
    private String username; //유저명
@Column(nullable = false, unique = true)
    private String email; //이메일
    @Column(nullable = false)
    private String password;
// 유저를 처음 회원가입 할 때 사용할 생성자.
    //id는 db가 자동으로 생성
    public User(String username, String email,String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
    //유저 정보를 수정할  때 사용하는 메서드
    public void update(String username ,String email) {
        if (username !=null) this.username = username;
        if (email != null) this.email = email;

    }

}
