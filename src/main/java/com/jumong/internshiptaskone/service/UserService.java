package com.jumong.internshiptaskone.service;

import com.jumong.internshiptaskone.dtos.request.RegisterRequest;
import com.jumong.internshiptaskone.dtos.response.RegisterResponse;

public interface UserService {

    RegisterResponse register(RegisterRequest registerRequest);

}