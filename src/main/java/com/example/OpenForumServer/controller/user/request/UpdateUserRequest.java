package com.example.OpenForumServer.controller.user.request;

import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class UpdateUserRequest {
    private String name;
    private final String email = "";
    private final String password = "";
    private final LocalDateTime createdAt = null;
}
