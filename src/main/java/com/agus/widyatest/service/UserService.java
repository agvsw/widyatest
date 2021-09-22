package com.agus.widyatest.service;

import com.agus.widyatest.dto.UserDTO;
import com.agus.widyatest.entity.User;

public interface UserService {
    User register(UserDTO userDTO, String role);
}
