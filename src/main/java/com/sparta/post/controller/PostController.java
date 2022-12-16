package com.sparta.post.controller;

import com.sparta.post.dto.PostRequestDto;
import com.sparta.post.dto.PostResponseDto;
import com.sparta.post.entity.Post;
import com.sparta.post.repository.PostRepository;
import com.sparta.post.service.PostService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final PostRepository postRepository;


    // 게시글 등록하기
    @PostMapping("/api/posts")
    public PostResponseDto createPost(@RequestBody PostRequestDto requestDto,
                                      HttpServletRequest request) {
        return postService.createPost(requestDto,request);
    }


    // 게시글 전체 조회하기
    @GetMapping("/api/posts")
    public List<Post> getPost() {
        return postRepository.findAllByOrderByCreatedAtDesc();
    }


    // 특정 게시글 조회하기
    @GetMapping("/api/posts/{id}")
    @ResponseBody
    public List<Post> getSomePost(@PathVariable Long id) {
        return postRepository.findByIdByOrderBOrderByModifiedAtDesc(id);
    }


    @PutMapping("/api/posts/{id}")
    @ResponseBody
    public Long updatePost(@PathVariable Long id,
                           @RequestBody PostRequestDto requestDto) {
        postService.update(id, requestDto);
        return id;
    }

    @DeleteMapping("/api/posts/{id}")
    @ResponseBody
    public Long deletePost(@PathVariable Long id,
                           @RequestBody PostRequestDto requestDto){
        postRepository.deleteById(id);
        return id;
    }



}
