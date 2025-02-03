package com.example.OpenForumServer.domain.forum.dto;

import com.example.OpenForumServer.controller.forum.request.ForumCreatorRequest;
import com.example.OpenForumServer.controller.forum.response.GetForumResponseItem;
import com.example.OpenForumServer.domain.forum.entity.Forum;
import com.example.OpenForumServer.domain.user.entity.User;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ForumDto {
    private final String title;
    private final String content;
    private final Integer view;
    private final LocalDateTime createdAt;
    private final String userName;

    public static ForumDto fromRequest(ForumCreatorRequest req) {
        return new ForumDto(
                req.getTitle(),
                req.getContent(),
                req.getView(),
                req.getCreatedAt(),
                req.getUserName()
        );
    }
    public GetForumResponseItem toResponse() {
        return GetForumResponseItem
                .builder()
                .title(this.title)
                .content(this.content)
                .view(this.view)
                .createdAt(this.createdAt)
                .userName(this.userName)
                .build();
    }
    public Forum toEntity(User user) {
        return Forum.builder()
                .content(this.content)
                .title(this.title)
                .user(user)
                .build();
    }

    public static ForumDto fromEntity(Forum forum) {
        return new ForumDto(
                forum.getTitle(),
                forum.getContent(),
                forum.getView(),
                forum.getCreatedAt(),
                forum.getUser().getName()
        );
    }
}