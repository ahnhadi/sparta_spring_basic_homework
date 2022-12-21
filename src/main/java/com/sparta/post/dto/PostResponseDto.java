package com.sparta.post.dto;

import com.sparta.post.entity.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 게시글 정보를 리턴할 응답(Response)클래스
 * Entity 클래스를 생성자 파라미터로 받아 데이터를 Dto로 변환하여 응답
 * 별도의 전달 객체를 활용해 연관관례를 맺은 엔티티 간의 무한참조를 방지
 */

@Getter
@NoArgsConstructor
public class PostResponseDto {
    private Long postId;
    private String username;
    private String title;
    private String contents;
    private Long userId;
    private List<CommentResponseDto> comments;


    // Entity -> Dto
    public PostResponseDto(Post post){
        this.postId = post.getPostId();
        this.username = post.getUsername();
        this.title = post.getTitle();
        this.contents = post.getContents();
        this.userId = post.getUser().getUserId();
        this.comments = post.getComments().stream().map(CommentResponseDto::new).collect(Collectors.toList());

    }
}
