package com.example.OpenForumServer.controller.forum.response;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@Builder
public class GetCommentResponseItem {
    private final String content;
    private final LocalDateTime updatedAt;
    private final String userName;
}
