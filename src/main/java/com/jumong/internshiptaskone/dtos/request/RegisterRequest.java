package com.jumong.internshiptaskone.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterRequest {
    private String email;
    private String password;
}
