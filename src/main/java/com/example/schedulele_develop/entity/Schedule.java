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
    @ManyToOne(fetch = FetchType.LAZY) //다대일 / 자연 로딩
    @JoinColumn(name = "user_id") //스케줄 테이블에 user_id 외래키 컴럼을 만들어서 유저의 id와 조인하겠다
    private  User user; //유저 객체 자제가 매핑
//생성자 -> 일정을 등록할 때 제목과 내용이랑 함께 연관관계를 맺을 유저 객체를 생성
    public Schedule(String title , String contents , User user) {
        this.title = title;
        this.contents = contents;
        this.user = user;
    }
    //일정을 수정할 때 호출하는 수정 메서드
    public void update(String title , String contents) {
        if (title != null) this.title =title;
        if(contents !=null) this.contents = contents;

//public Schedule(CreateScheduleRequest request) {
//    this.title =request.getTitle();
//    this.contents = request.getContents();
//    this.userName = request.getUserName();
    //서비스에서 new Schedule(request)를 쓸 수 있게 해주는 생성드
}
}
