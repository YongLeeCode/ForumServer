package com.example.OpenForumServer.domain.user.service;

import com.example.OpenForumServer.domain.user.dto.UserDto;

public interface UserService {
    void createUser(UserDto userDto);

    UserDto getUserById(Long id);

    String updateUser(Long id, UserDto req);

    String deleteUser(Long id);
}
