package com.sparta.post.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sparta.post.dto.PostRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class Post extends Timestamped {
    //생성, 수정 시간을 자동으로 생성하도록 Timestamped 상속 받음

    @Id  //Id 값, PK로 사용
    @GeneratedValue(strategy = GenerationType.AUTO)  //Id 생성 시 자동으로 증가
    private Long postId;

    @Column(nullable = false)  //컬럼 값이 null 반환X -> 반드시 값 존재O
    private String username;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    @ManyToOne
    private User user;

    @OneToMany
    @OrderBy
    private List<Comment> comments;


    public Post(String username, String title, String contents){
        this.username = username;
        this.title = title;
        this.contents = contents;
    }

    public Post(PostRequestDto requestDto, Long id){
        this.title = requestDto.getTitle();
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }

    public void update(PostRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }
}
