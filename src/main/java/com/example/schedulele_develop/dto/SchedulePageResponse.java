package com.example.schedulele_develop.dto;

import com.example.schedulele_develop.entity.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;

//요구사항 -> 유저이름/ 이메일을 제외하기
@Getter
public class SchedulePageResponse {
    private final Long id;
    private final String title;
    private final String contents;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public SchedulePageResponse(Schedule schedule) {
        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.contents = schedule.getContents();
        this.createdAt = schedule.getCreatedAt();
        this.modifiedAt = schedule.getModifiedAt();
    }
}
