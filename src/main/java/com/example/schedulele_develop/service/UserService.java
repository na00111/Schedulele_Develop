package com.example.schedulele_develop.service;

import com.example.schedulele_develop.config.PasswordEncoder;
import com.example.schedulele_develop.dto.UserRequest;
import com.example.schedulele_develop.dto.UserResponse;
import com.example.schedulele_develop.entity.User;
import com.example.schedulele_develop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder; //암호화 부품을 주입


    @Transactional
    public UserResponse signUp (UserRequest request) {
        String encodedPassword = passwordEncoder.encode(request.getPassword());
        //사용자가 가입할 때 쓴  비밀번호를 암호화 부품에 넣어서 해시문으로 변경

        //암호화된 비밀번호를 엔티티에 넣어서 db에 저장
        User user = new User(request.getUsername(),request.getEmail(),encodedPassword);
        User savedUser = userRepository.save(user);

        return new UserResponse(savedUser);

    }

    //생성자 주입
    @Transactional
    public UserResponse createUser(UserRequest request) {
        //데이터베이스 작업의 최소 단위를 설정한다.에러 없으면 커밋,에러 -> 롤백 전부 없던 일로
        User user = new User(request.getUsername(), request.getEmail());
        //요청 가방(리퀘스트 dto)에서 꺼낸  데이터로 유저 엔티티 객체를 생성
        User saveUser = userRepository.save(user);
        //리포지토리를 통해 db에 저장하고, 영속화된 결과 객체를 다시 받는다.
        return  new UserResponse(saveUser);
        //엔티티 객체를  response dto에 싸서 반환.
    }
@Transactional(readOnly = true) //조회 전용
    //스프링이 스냅샷 저장이나 더티 체킹 과정을 생략하여 메모리를 아끼고 조회 속도를 상승시킴.
    public List<UserResponse> findAllUsers() {
        return userRepository.findAll() //db에서 모든 유저 리스트를 가져온다.
                .stream() //연속된 데이터 흐름을 변환
                .map(UserResponse::new) //반복문 / .map(user -> new UserResponse(user))
                .collect(Collectors.toList());
}
@Transactional(readOnly = true)
    public UserResponse findUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("유저 없음 id = " + id));
        return new UserResponse(user);
}
@Transactional
    public UserResponse updateUser(Long id, UserRequest request) {
        //수정할 대상 유저가 데이터베이스에 있는지 먼저 조회
    User user = userRepository.findById(id)
            .orElseThrow(()-> new IllegalArgumentException("유저 없음 id = " + id));
    user.update(request.getUsername(), request.getEmail());
    return  new UserResponse(user);
}
@Transactional
    public void deleteUser(Long id) {
        User user =userRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("유저 없음 id = " + id));
        userRepository.delete(user);
}
}
