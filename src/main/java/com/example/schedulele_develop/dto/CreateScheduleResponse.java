package com.example.schedulele_develop.dto;

import com.example.schedulele_develop.entity.Schedule;
import lombok.Getter;

@Getter
public class CreateScheduleResponse {
    private final Long id;
    private final String title;
    private final String contents;
    private final String userName;

    public  CreateScheduleResponse(Long id, String name, String email, String address, String title, String contents, String userName) {
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
            this.userName = schedule.getUserName();
    }
}
