package com.f_lab.Stargram.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDto {
    private String userName;
    private String password;
}