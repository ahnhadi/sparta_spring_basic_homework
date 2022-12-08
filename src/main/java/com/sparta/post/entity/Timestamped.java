package com.sparta.post.entity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass  //상속 시, Column으로 인식
@EntityListeners(AuditingEntityListener.class)  //생성/수정 시간 자동 업데이트
public class Timestamped {

    @CreatedDate  //생성 시간
    private LocalDateTime createdAt;

    @LastModifiedDate // 수정 시간
    private LocalDateTime modifiedAt;

    public Timestamped() {
    }
}
