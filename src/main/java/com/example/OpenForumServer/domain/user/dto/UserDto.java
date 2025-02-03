package com.example.OpenForumServer.domain.user.dto;

import com.example.OpenForumServer.controller.user.request.UpdateUserRequest;
import com.example.OpenForumServer.domain.user.entity.User;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RequiredArgsConstructor
@Getter
@Builder
@Setter
public class UserDto {
    private final String name;
    private final String email;
    private final String password;
    private final LocalDateTime createdAt;

    public static UserDto fromRequest(UpdateUserRequest req) {
        return new UserDto(
                req.getName(),
                req.getEmail(),
                req.getPassword(),
                req.getCreatedAt()
        );
    }

    public User toEntity(String encodedPassword) {
        return User.builder()
                .name(this.name)
                .email(this.email)
                .password(encodedPassword)
                .build();
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
