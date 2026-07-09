package com.example.schedulele_develop.config;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
//bean 싱글톤 객체로 생성해서 관리 /나중에 서비스클래스에서 이 부품을 주입(@RequiredArgsConstructor)받아서 쓸 수 있다.
public class PasswordEncoder {
//비밀번호를 암호화(해싱)하는 메서드
    public String encode(String rawPassword) {
        //rawPassword.toCharArray() -> String 문자열을 자바의 기본 자료형인 char[](문자 배열)로 변환한다.
        //String 객체는 메모리에 오래 남을 수 있어서 ,사용 즉시 비울 수 있는 char[]를 선언하는 것
        return BCrypt.withDefaults().hashToString(BCrypt.MIN_COST, rawPassword.toCharArray());
    }
//로그인할 때 입력한 비번과 DB에 저장된 암호문이 맞는지 비교하는 메서드
    public boolean matches(String rawPassword, String encodedPassword) {
        BCrypt.Result result = BCrypt.verifyer().verify(rawPassword.toCharArray(), encodedPassword);
        //입력받은 비밀번호 char[] 와 과거에 암호화되어 db에 있는 암호문 encodeedPassword을 대조해 줌 -> verifyer
        return result.verified;
        //검증 결과 내부의 verified라는 boolean 필드를 꺼냄 비밀번호가 일치하면 트루
    }
}
