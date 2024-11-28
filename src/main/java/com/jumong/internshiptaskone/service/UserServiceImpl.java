package com.jumong.internshiptaskone.service;

import com.jumong.internshiptaskone.data.model.User;
import com.jumong.internshiptaskone.data.repositories.UserRepository;
import com.jumong.internshiptaskone.dtos.request.RegisterRequest;
import com.jumong.internshiptaskone.dtos.response.RegisterResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    @Override
    public RegisterResponse register(RegisterRequest registerRequest) {
        User newUser = new User();
        newUser.setEmail(registerRequest.getEmail());
        newUser.setPassword(registerRequest.getPassword());
        userRepository.save(newUser);
        RegisterResponse registerResponse = new RegisterResponse();
        registerResponse.setMessage("Registration successful");
        return registerResponse;
    }
}
