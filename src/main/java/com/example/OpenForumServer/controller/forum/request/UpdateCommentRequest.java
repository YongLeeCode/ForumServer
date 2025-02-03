package com.example.OpenForumServer.controller.forum.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class UpdateCommentRequest {
    private final String content;
}
