package com.agus.widyatest.service.impl;

import com.agus.widyatest.dto.UserDTO;
import com.agus.widyatest.entity.User;
import com.agus.widyatest.repository.RoleRepository;
import com.agus.widyatest.repository.UserRepository;
import com.agus.widyatest.service.UserService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class UserServiceImplement implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User register(UserDTO userDTO, String role) {
        User user = new ObjectMapper().convertValue(userDTO, User.class);
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setRoles(Collections.singletonList(roleRepository.findByRoleNameContaining(role)));
        Optional<User> optUser = userRepository.findByUserNameOrEmail(userDTO.getUserName(), userDTO.getEmail());
        if (!optUser.isPresent()) {
            return userRepository.save(user);
        }
        throw new RuntimeException("User already exist");
    }

}
