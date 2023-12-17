package com.sethondrunninggroop.web.service;

import com.sethondrunninggroop.web.dto.UserDto;
import com.sethondrunninggroop.web.models.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}
