package com.sparta.post.controller;

import com.sparta.post.dto.PostRequestDto;
import com.sparta.post.entity.Post;
import com.sparta.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;


    @PostMapping("/api/posts")
    public Post createPost(@RequestBody PostRequestDto requestDto) {
        //객체 형식으로 넘어오기 때문에 post 방식이라 body 존재.
        //그 안에 우리가 필요한 값이 넘어옴
        return postService.createPost(requestDto);
    }

    @GetMapping("/api/posts")
    @ResponseBody
    public List<Post> getPost() {
        return postService.getPost();
    }

    @GetMapping("/api/posts/{id}/{pw}")
    @ResponseBody
    public List<Post> getSomePost(@PathVariable Long id) {
        return postService.getSomePost(id);
    }

    @PutMapping("/api/posts/{id}")
    @ResponseBody
    public Long updatePost(@PathVariable Long id,
                           @RequestBody PostRequestDto requestDto) {
        return postService.update(id, requestDto);
    }

    @DeleteMapping("/api/posts/{id}")
    @ResponseBody
    public Long deletePost(@PathVariable Long id,
                           @RequestBody PostRequestDto requestDto){
        return postService.deletePost(id, requestDto);
    }





}
