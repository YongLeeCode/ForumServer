package com.example.OpenForumServer.controller.forum.response;

import com.example.OpenForumServer.controller.user.response.GetUserResponseItem;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class GetForumResponse {
    private final List<GetForumResponseItem> items;
    private final Integer totalCount;
}
