# Schedulele_Develop
erDiagram
    users ||--o{ schedules : "작성한다 (1:N)"
    
    users {
        Long id PK "자동 증가 고유 식별자"
        String username "유저명 (최대 4자)"
        String email UK "이메일 (중복 불가)"
        String password "암호화된 비밀번호"
        LocalDateTime created_at "생성일"
        LocalDateTime updated_at "수정일"
    }

    schedules {
        Long id PK "자동 증가 고유 식별자"
        Long user_id FK "작성자 식별자"
        String title "할 일 제목 (최대 10자)"
        String contents "할 일 내용"
        LocalDateTime created_at "생성일"
        LocalDateTime updated_at "수정일"
    }

    기능,Method,URL,Request Body,Response Body,상태 코드,비고
회원가입,POST,/api/users/signup,"JSON (이름, 이메일, 비번)",회원 정보 (비번 제외),201 Created,비밀번호 BCrypt 암호화 적용
로그인,POST,/api/login,"JSON (이메일, 비번)","""로그인 성공!""",200 OK,세션(JSESSIONID) 발급

기능,Method,URL,Request Body,Response Body,상태 코드,비고
유저 전체 조회,GET,/api/users,None,유저 리스트 단건/전체,200 OK,
유저 단건 조회,GET,/api/users/{id},None,해당 유저 상세 정보,200 OK,존재하지 않을 시 404/400 예외
유저 정보 수정,PUT,/api/users/{id},"JSON (이름, 이메일)",수정된 유저 정보,200 OK,더티 체킹 활용 수정
유저 삭제,DELETE,/api/users/{id},None,None,200 OK,


기능,Method,URL,Request Body,Response Body,상태 코드,비고
일정 생성,POST,/api/schedules,"JSON (유저ID, 제목, 내용 등)",생성된 일정 정보,201 Created,Lv 5 Validation 적용- 제목: 최대 10자- 유저명: 최대 4자
일정 전체 조회,GET,/api/schedules,None,일정 전체 리스트,200 OK,
일정 단건 조회,GET,/api/schedules/{id},None,해당 일정 상세 정보,200 OK,
일정 수정,PUT,/api/schedules/{id},"JSON (제목, 내용)",수정된 일정 정보,200 OK,
일정 삭제,DELETE,/api/schedules/{id},None,None,200 OK,


예외 처리

{
    "statusCode": 400,
    "message": "제목은 10글자 이내"
}

{
    "statusCode": 400,
    "message": "이메일 또는 비밀번호가 올바르지 않습니다."
}


<img width="445" height="437" alt="스크린샷 2026-07-09 오후 1 00 52" src="https://github.com/user-attachments/assets/2b4b2a7c-b6eb-4aac-a31b-927f5c17e008" />
