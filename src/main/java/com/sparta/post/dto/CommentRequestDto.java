package com.sparta.post.dto;

import com.sparta.post.entity.Comment;
import com.sparta.post.entity.Post;
import com.sparta.post.entity.User;
import lombok.NoArgsConstructor;


@NoArgsConstructor
public class CommentRequestDto{
    private Long commentId;
    private String comment;
    private User user;
    private Post post;

    // Dto -> Entity
    public Comment toEntity(){
        Comment comments = Comment.builder()
                .id(commentId)
                .comments(comment)
                .user(user)
                .post(post)
                .build();

        return comments;
    }
}
