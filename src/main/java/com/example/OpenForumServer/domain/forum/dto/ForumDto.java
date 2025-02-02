package com.example.OpenForumServer.domain.forum.dto;

import com.example.OpenForumServer.domain.forum.entity.Forum;
import com.example.OpenForumServer.domain.user.entity.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ForumDto {
    private final String title;
    private final String content;

    public Forum toEntity(User user) {
        return Forum.builder()
                .content(this.content)
                .title(this.title)
                .user(user)
                .build();
    }
}