package com.agus.widyatest.controller;

import com.agus.widyatest.dto.CommonResponse;
import com.agus.widyatest.dto.UserDTO;
import com.agus.widyatest.entity.User;
import com.agus.widyatest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping(path = "/register/admin")
    public CommonResponse<User> registerAdmin(@RequestBody UserDTO userDto) {
        CommonResponse<User> response = new CommonResponse<>();
        response.setData(userService.register(userDto, "ADMIN"));
        return response;
    }

    @PostMapping(path = "/register/user")
    public CommonResponse<User> registerUser(@RequestBody UserDTO userDto) {
        CommonResponse<User> response = new CommonResponse<>();
        response.setData(userService.register(userDto, "USER"));
        return response;
    }
}
