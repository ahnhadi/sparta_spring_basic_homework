package com.sparta.post.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sparta.post.dto.PostRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Post extends Timestamped {
    //생성, 수정 시간을 자동으로 생성하도록 Timestamped 상속 받음

    @Id  //Id 값, PK로 사용
    @GeneratedValue(strategy = GenerationType.AUTO)  //Id 생성 시 자동으로 증가
    private Long id;

    @Column(nullable = false)  //컬럼 값이 null 반환X -> 반드시 값 존재O
    private String name;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    @JsonIgnore
    private String pw;



    public Post(PostRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.name = requestDto.getName();
        this.contents = requestDto.getContents();
        this.pw = requestDto.getPw();
    }

    public void update(PostRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.name = requestDto.getName();
        this.contents = requestDto.getContents();
    }
}
