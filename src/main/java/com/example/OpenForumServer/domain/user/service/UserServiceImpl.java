package com.example.OpenForumServer.domain.user.service;

import com.example.OpenForumServer.controller.user.request.UpdateUserRequest;
import com.example.OpenForumServer.controller.user.response.GetUserResponseItem;
import com.example.OpenForumServer.domain.user.dto.UserDto;
import com.example.OpenForumServer.domain.user.entity.User;
import com.example.OpenForumServer.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void createUser(UserDto dto) {
        String encodedPw = bCryptPasswordEncoder.encode(dto.getPassword());
        userRepository.save(dto.toEntity(encodedPw));
    }

    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not found user id"));
        return UserDto.fromEntity(user);
    }

    public String updateUser(Long id, UserDto dto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found user id"));
        user.setName(dto.getName());
        userRepository.save(user);
        return "변경 성공?";
    }

    public String deleteUser(Long id) {
        userRepository.deleteById(id);
        return "삭제 성공?";
    }
}
