package com.example.OpenForumServer.controller.forum.response;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class GetCommentResponseItem {
    private final String content;
    private final LocalDateTime updatedAt;
    private final String userName;
    private final Integer depth;
    private final String parentCommentUser;
}
