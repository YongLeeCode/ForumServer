package com.example.OpenForumServer.controller.forum.response;

import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class GetCommentResponse {
    private final List<GetCommentResponseItem> items;
    private final Integer totalCount;
}
