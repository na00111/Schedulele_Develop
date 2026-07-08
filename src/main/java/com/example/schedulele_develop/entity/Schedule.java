package com.example.schedulele_develop.entity;

import com.example.schedulele_develop.dto.CreateScheduleRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "Schedules")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Schedule extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String title;
    @Column(columnDefinition = "TEXT")
    private String contents;
    private String userName; //연간관계 맺기 전 임시 필드

public Schedule(CreateScheduleRequest request) {
    this.title =request.getTitle();
    this.contents = request.getContents();
    this.userName = request.getUserName();
    //서비스에서 new Schedule(request)를 쓸 수 있게 해주는 생성자
}
}
