package com.example.schedulele_develop.dto;

import lombok.Getter;
//사용자가 보낸 요청을 담는 그릉
//CreateScheduleRequest 객체로 만들어 준다
@Getter
public class CreateScheduleRequest {
    private String name;
    private String email;
    private String address;
}
