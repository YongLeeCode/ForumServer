package com.example.OpenForumServer.domain.user.service;

import com.example.OpenForumServer.domain.user.dto.UserDto;
import com.example.OpenForumServer.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public void createUser(UserDto dto) {
        String encodedPw = bCryptPasswordEncoder.encode(dto.getPassword());
        userRepository.save(dto.toEntity(encodedPw));
    }
}
