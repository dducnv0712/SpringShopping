package com.example.spring_shoppingbackend.entity.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserInfoDto {
    private String name;
    private String email;
    private String role;
}
