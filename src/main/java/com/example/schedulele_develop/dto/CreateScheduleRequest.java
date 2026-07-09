package com.example.schedulele_develop.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

//사용자가 보낸 요청을 담는 그릉
//CreateScheduleRequest 객체로 만들어 준자
@Getter
@NoArgsConstructor
public class CreateScheduleRequest {
    private Long userId; //유저 식별자


    @NotBlank(message = "할 일 제목 필수로 입력") //널, 공백 ,띄어쓰기 다 안됨
    @Size(max = 10, message = "10글자 이내로 작성하기")
    private String title; //할일 제목


    @NotBlank(message = "내용 필수 입력")
    private String contents; //할일 내용


    @NotBlank(message = "유저명은 필수로 입력해야함")
    @Size(max = 4, message = "4글자 이내여야 함")
    private String userName; //작성 유저기

}
