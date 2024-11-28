package com.jumong.internshiptaskone;

import com.jumong.internshiptaskone.dtos.request.RegisterRequest;
import com.jumong.internshiptaskone.dtos.response.RegisterResponse;
import com.jumong.internshiptaskone.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testRegisterUser(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setEmail("Email");
        registerRequest.setPassword("Password");
        RegisterResponse registerResponse = userService.register(registerRequest);
        assertThat(registerResponse).isNotNull();
        assertThat(registerResponse.getMessage()).isEqualTo("Registration successful");
    }


}
