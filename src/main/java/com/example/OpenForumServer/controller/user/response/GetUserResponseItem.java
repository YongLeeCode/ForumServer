package com.example.OpenForumServer.controller.user.response;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class GetUserResponseItem {
    private final String name;
    private final String email;
    private final LocalDateTime createdAt;
}
