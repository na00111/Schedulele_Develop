package com.example.schedulele_develop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.schedulele_develop.dto.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//IllegalArgumentException을 한 곳으로 모아서 처리하는 문지기 클래스
//이 클래스가 프로젝트 전체의 에러를 감시하는 것을 스프링에서 알린다 -> @ReatControllerAdvice
//IllegalArgumentException 이 터지면 이 메서드가 가로채게 매핑 -> @ExceptionHandler
@RestControllerAdvice
public class GlobalExceptionHandler {
    //서비스에 던진 IllegalArgumentException이 터지면 무조건 이 메서드가 실행된다.
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException ex) {
        //ErrorResponse에 400 숫자와 에러 메시지 ex.getMessage()를 담는다.
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(), //400이라는 숫자를 의미
                ex.getMessage()//서비스에 던진 " 존재하지 않는 유저입니다 " 문구가 그대로 들어옴
        );
        return  new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        //ResponseEntity에 클라이언트에게에러 가방을 실어사 400 BAD_REQUEST 코드로 리턴
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public  ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException ex) {
        String errorMessage = ex.getBindingResult().getFieldError().getDefaultMessage();
        //ex.getBindingResult(): 검증 오류 결과들
        //.getFieldError(): 필드 때문에 발생한 첫 번째 에러 정보
        //.getDefaultMessage(): DTO에 적어둔 문자열 출력.
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(), //400
                errorMessage  // 적어둔 문자열 출력
        );
        return  new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
