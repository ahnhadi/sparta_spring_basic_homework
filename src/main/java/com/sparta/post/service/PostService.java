package com.sparta.post.service;

import com.sparta.post.dto.PostRequestDto;
import com.sparta.post.entity.Post;
import com.sparta.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;



    @Transactional  //새 게시글 생성
    public Post createPost(PostRequestDto requestDto) {
        Post post = new Post(requestDto);
        postRepository.save(post);
        return post;
    }

    @Transactional(readOnly = true) //모든 게시글 조회
    public List<Post> getPost(){
        return postRepository.findAllByOrderByCreatedAtDesc();
    }

    @Transactional(readOnly = true) //특정 게시글 조회
    public List<Post> getSomePost(Long id) {
        return postRepository.findByIdByOrderByCreatedAtDesc(id);
    }


    @Transactional  //게시글 수정
    public Long update(Long id, PostRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 id의 게시글이 존재하지 않습니다.")
        );
        String pw = requestDto.getPw();
        String correctPw = post.getPw();

        if(pw.equals(correctPw)){
            return post.getId();
        } else {
            throw new RuntimeException("비밀번호가 맞지 않습니다.");
        }
    }

    @Transactional  //게시글 삭제
    public Long deletePost(Long id, PostRequestDto requestDto){
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 id의 게시글이 존재하지 않습니다.")
        );
        String pw = requestDto.getPw();  //입력받은 비밀번호
        String correctPw = post.getPw();  //저장된 비밀번호

        if(pw.equals(correctPw)){
            postRepository.deleteById(id);
        } else {
            throw new RuntimeException("비밀번호가 맞지 않습니다.");
        }
        return id;
    }


}
