package com.sparta.post.controller;

import com.sparta.post.dto.CommentRequestDto;
import com.sparta.post.dto.PostRequestDto;
import com.sparta.post.entity.Comment;
import com.sparta.post.repository.CommentRepository;
import com.sparta.post.service.CommentService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class CommentController {


    private final CommentService commentService;
    private final CommentRepository commentRepository;


    // 댓글 등록하기
    @PostMapping("/api/posts")
    public Long createComment(String username, Long id,
                              @RequestBody CommentRequestDto requestDto,
                              HttpServletRequest request) {
        return commentService.createComment(username,id,requestDto);
    }


    // 댓글 전체 조회하기
    @GetMapping("/api/posts")
    public List<Comment> getComment() {
        return commentRepository.findAllByOrderByCreatedAtDesc();
    }


    // 댓글 수정하기
    @PutMapping("/api/posts/{id}")
    @ResponseBody
    public Long updateComment(@PathVariable Long id,
                              @RequestBody CommentRequestDto requestDto) {
        commentService.updateComment(id, requestDto);
        return id;
    }


    //댓글 삭제하기
    @DeleteMapping("/api/posts/{id}")
    @ResponseBody
    public Long deleteComment(@PathVariable Long id){
        commentService.deleteComment(id);
        return id;
    }



}