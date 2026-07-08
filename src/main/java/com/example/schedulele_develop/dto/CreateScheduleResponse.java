package com.example.schedulele_develop.dto;

import com.example.schedulele_develop.entity.Schedule;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class CreateScheduleResponse {
    private  Long id;
    private  String title;
    private  String contents;
    private  String userName;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public CreateScheduleResponse(Long id, String name, String email, String address, String title, String contents, String userName) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.userName = userName;
        //낱개로 받는 생성자
    }
//overloading
        //스캐쥴 객체를 통째로 받는 생성자
        public CreateScheduleResponse(Schedule schedule) {
            this.id = schedule.getId();
            this.title = schedule.getTitle();
            this.contents = schedule.getContents();
//            this.userName = schedule.getUserName();
            this.userName = schedule.getUser().getUsername();
            this.createdAt = schedule.getCreatedAt();
            this.modifiedAt = schedule.getModifiedAt();
    }
}
