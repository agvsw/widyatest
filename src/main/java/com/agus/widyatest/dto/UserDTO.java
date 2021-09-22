package com.agus.widyatest.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class UserDTO {
    private String userName;

    private String password;

    private String email;

    private String mobile;

}
