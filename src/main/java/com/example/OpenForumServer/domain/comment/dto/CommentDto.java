package com.example.OpenForumServer.domain.comment.dto;

import com.example.OpenForumServer.controller.forum.request.CommentCreatorRequest;
import com.example.OpenForumServer.controller.forum.response.GetCommentResponseItem;
import com.example.OpenForumServer.domain.comment.entity.Comment;
import com.example.OpenForumServer.domain.forum.entity.Forum;
import com.example.OpenForumServer.domain.user.entity.User;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CommentDto {

    private final String content;
    private final LocalDateTime updatedAt;
    private final String userName;

    public static CommentDto fromRequest(CommentCreatorRequest req) {
        return new CommentDto(
                req.getContent(),
                req.getUpdatedAt(),
                req.getUserName()
        );
    }

    public GetCommentResponseItem toResponse() {
        return GetCommentResponseItem.builder()
                .content(this.content)
                .updatedAt(this.updatedAt)
                .userName(this.userName)
                .build();
    }

    public Comment toEntity(Forum forum, User user) {
        return Comment.builder()
                .content(this.content)
                .forum(forum)
                .user(user)
                .build();
    }

    public static CommentDto fromEntity(Comment comment) {
        return new CommentDto(
                comment.getContent(),
                comment.getUpdatedAt(),
                comment.getUser().getName()
        );
    }
}
