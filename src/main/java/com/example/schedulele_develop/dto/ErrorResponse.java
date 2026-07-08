package com.example.schedulele_develop.dto;

import lombok.Getter;

@Getter
//에러가 났을 때 클라이언트에세  에러 메시지와 http 상태 코드를 담아 보낼줄 가방
public class ErrorResponse {
    private final int statusCode; //숫자 코드
    private final String message; //" 해당 유저를 찾을 수 없다"


    public ErrorResponse(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
