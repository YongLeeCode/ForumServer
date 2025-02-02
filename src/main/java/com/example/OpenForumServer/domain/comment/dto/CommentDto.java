package com.example.OpenForumServer.domain.comment.dto;

import com.example.OpenForumServer.domain.comment.entity.Comment;
import com.example.OpenForumServer.domain.forum.entity.Forum;
import com.example.OpenForumServer.domain.user.entity.User;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CommentDto {
    private final String content;

    public Comment toEntity(Forum forum, User user) {
        return Comment.builder()
                .content(this.content)
                .forum(forum)
                .user(user)
                .build();
    }
}
