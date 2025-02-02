package com.example.OpenForumServer.domain.user.dto;

import com.example.OpenForumServer.domain.user.entity.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RequiredArgsConstructor
@Getter
public class UserDto {
    private final String email;
    private final String name;
    private final String password;

    public User toEntity(String encodedPassword) {
        return User.builder()
                .name(this.name)
                .email(this.email)
                .password(encodedPassword)
                .build();
    }
}
