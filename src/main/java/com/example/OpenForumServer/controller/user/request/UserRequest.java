package com.example.OpenForumServer.controller.user.request;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class UserRequest {
    private String name;
    private String email;
    private String password = "";
    private final LocalDateTime createdAt = null;

    public UserRequest(String name, String email, String password){
        this.name = name;
        this.email = (email != null) ? email : "";
        this.password = (password != null) ? password : "";
    }
}
