package com.sparta.post.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@Getter
@Entity(name = "comments")
@NoArgsConstructor
public class Comment extends Timestamped {

    @Id  //Id 값, PK로 사용
    @GeneratedValue(strategy = GenerationType.AUTO)  //Id 생성 시 자동으로 증가
    private Long id;

    @ManyToOne
    private User user;

    @Column(nullable = false)
    private String comments;

    @ManyToOne
    @JoinColumn(name = "posts_id")
    private Post post;


    // 댓글 수정
    public void updateComment(String comments){
        this.comments = comments;
    }
}
