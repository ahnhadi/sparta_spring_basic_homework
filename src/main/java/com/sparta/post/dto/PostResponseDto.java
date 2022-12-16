package com.sparta.post.dto;

import com.sparta.post.entity.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostResponseDto {
    private Long id;
    private String username;
    private String title;
    private String pw;
    private String contents;

    public PostResponseDto(Post post){
        this.id = post.getId();
        this.username = post.getUsername();
        this.title = post.getTitle();
        this.pw = post.getPw();
        this.contents = post.getContents();
    }
}
