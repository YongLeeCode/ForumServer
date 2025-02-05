package com.example.OpenForumServer.domain.user.dto;

import com.example.OpenForumServer.controller.user.request.UserRequest;
import com.example.OpenForumServer.domain.user.entity.User;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class UserDto {
    private final String name;
    private final String email;
    private final String password;
    private final LocalDateTime createdAt;

    public static UserDto fromRequest(UserRequest req) {
        return new UserDto(
                req.getName(),
                req.getEmail(),
                req.getPassword(),
                req.getCreatedAt()
        );
    }

    public User toEntity(String encodedPassword) {
        return new User(
                this.name,
                this.email,
                encodedPassword
        );
    }

    public static UserDto fromEntity(User user) {
        return new UserDto(
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getCreatedAt()
        );
    }
}
