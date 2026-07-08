package com.example.schedulele_develop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.Temporal;
import org.hibernate.temporal.TemporalTableStrategy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.sound.sampled.spi.AudioFileReader;
import java.time.LocalDateTime;

//생성일, 수정일 관리할 수 있다
@Getter
@MappedSuperclass //상속받는 클래스에 필드만 복사해라
//부모 클래스의 필드를 자식 엔티티의 컬럽으로 포함시키고, 부모 자체의 테이블은 만들지 않는다.
@EntityListeners(AuditingEntityListener.class) //엔티티가 저장되거나 수정될 때 자동으로 특정 작업을 수행해라.
//리스터 -> 어떤 일이 발생했을 때 자동으로 호출되는 객체
public abstract class BaseEntity {
   @CreatedDate //처음 저장될 떄 현재 시간을 넣기 ,스프링이 자동으로
    @Column(updatable = false ) //업데이트 안하기 ,생성일은 처음 한 번만 기록해야됨.

    private LocalDateTime createdAt;

   @LastModifiedDate //수정될 때마다 현재 시간을 넣기

    private LocalDateTime modifiedAt;
//가장 마지막 수정 시간이 들어간다.
}
