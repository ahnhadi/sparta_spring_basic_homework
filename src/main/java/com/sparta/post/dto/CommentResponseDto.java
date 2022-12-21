package com.sparta.post.dto;

import com.sparta.post.entity.Comment;

public class CommentResponseDto {
    private Long commentId;
    private String comment;
    private String username;
    private Long postId;

    // Entity -> Dto
    public CommentResponseDto(Comment comment){
        this.commentId = comment.getId();
        this.comment = comment.getComments();
        this.username = comment.getUser().getUsername();
        this.postId = comment.getPost().getPostId();
    }
}
