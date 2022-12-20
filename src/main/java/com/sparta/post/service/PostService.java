package com.sparta.post.service;

import com.sparta.post.dto.PostRequestDto;
import com.sparta.post.dto.PostResponseDto;
import com.sparta.post.entity.Post;
import com.sparta.post.entity.User;
import com.sparta.post.jwt.JwtUtil;
import com.sparta.post.repository.PostRepository;
import com.sparta.post.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;


    //게시글 등록
    @Transactional
    public PostResponseDto createPost(PostRequestDto requestDto,
                                      HttpServletRequest request){
        String token = jwtUtil.resolveToken(request);
        Claims claims;

        //토큰이 있는 경우에만 게시글 생성 가능
        if(token != null){
            if(jwtUtil.validateToken(token)){
                claims = jwtUtil.getUserInfoFromToken(token);
            } else {
                throw new IllegalArgumentException("Token Error");
            }
        // 토큰에서 가져온 사용자 정보를 사용하여 DB 조회
        User user = userRepository.findByUsername(claims.getSubject()).orElseThrow(
                () -> new IllegalArgumentException("사용자가 존재하지 않습니다.")
        );

        // 요청받은 DTO로 DB에 저장할 객체 만들기
        Post post = postRepository.saveAndFlush(new Post(requestDto, user.getId()));

        return new PostResponseDto(post);
        } else {
            return null;
        }
    }


    @Transactional  //게시글 수정
    public Long update(Long id, PostRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 id의 게시글이 존재하지 않습니다.")
        );
        String pw = requestDto.getPw();  //입력받은 비밀번호
        String correctPw = post.getPw();  //저장된 비밀번호

        if (pw.equals(correctPw)) {
            return post.getId();
        } else {
            throw new RuntimeException("비밀번호가 맞지 않습니다.");
        }
    }


}