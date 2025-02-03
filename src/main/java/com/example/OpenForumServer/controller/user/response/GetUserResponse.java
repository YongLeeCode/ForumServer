package com.example.OpenForumServer.controller.user.response;

import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class GetUserResponse {
    private final GetUserResponseItem item;
    private final Integer totalCount;
}
