package com.example.OpenForumServer.controller.forum.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UpdateForumRequest {
    private final String title;
    private final String content;
}
