package com.sparta.post.dto;

import lombok.Getter;


//Dto : 데이터 전송객체. View에서 Controller로 넘어오는 데이터나,
//Controller에서 Service로 넘기는 데이터를 담음
//로직X, 데이터 객체에 대한 정보만 담음
@Getter
public class PostRequestDto {
    private String title;
    private String name;
    private String contents;
    private String pw;
}
