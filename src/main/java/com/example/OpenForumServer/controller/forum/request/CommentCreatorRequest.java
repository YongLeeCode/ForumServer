package com.example.OpenForumServer.controller.forum.request;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CommentCreatorRequest {
    private final String content;
    private final LocalDateTime updatedAt = null;
    private final String userName = "";
}
