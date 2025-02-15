package com.example.OpenForumServer.controller.forum.response;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Setter
@Getter
public class GetForumResponseItem {
    private final String title;
    private final String content;
    private final String userName;
    private final Integer view;
    private final LocalDateTime createdAt;
}
