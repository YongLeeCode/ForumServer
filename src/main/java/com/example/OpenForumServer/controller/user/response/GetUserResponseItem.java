package com.example.OpenForumServer.controller.user.response;

import java.util.Date;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserResponseItem {
    private final String name;
    private final String email;
    private final Date createdAt;
}
