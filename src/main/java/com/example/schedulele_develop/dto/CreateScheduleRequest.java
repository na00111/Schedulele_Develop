package com.example.schedulele_develop.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

//사용자가 보낸 요청을 담는 그릉
//CreateScheduleRequest 객체로 만들어 준자
@Getter
@NoArgsConstructor
public class CreateScheduleRequest {
    private String title; //할일 제목
    private String contents; //할일 내용
    private String userName; //작성 유저명
}
