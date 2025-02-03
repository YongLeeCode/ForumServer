package com.example.OpenForumServer.controller.forum.request;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ForumCreatorRequest {
    private final String title;
    private final String content;
    private final Integer view = null;
    private final LocalDateTime createdAt = null;
    private final String userName = "";
}
