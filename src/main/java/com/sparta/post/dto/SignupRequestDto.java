package com.sparta.post.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignupRequestDto {

    @NotBlank
    @Size(min=4,max=10)
    @Pattern(regexp="^([a-z]+[0-9]*)$")
    // 영소문자반드시 포함, 숫자가 있어도 됨
    private String username;

    @NotBlank
    @Size(min=8,max=15)
    @Pattern(regexp="^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]$")
    // 숫자, 영문자, 특수문자 각 1개 이상 포함
    private String password;

    private boolean admin = false;
    private String adminToken = "";
}