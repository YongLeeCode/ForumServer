package com.example.OpenForumServer.controller.user.response;

import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserResponse {
    private final List<UserResponseItem> items;
    private final Integer totalCount;
}
