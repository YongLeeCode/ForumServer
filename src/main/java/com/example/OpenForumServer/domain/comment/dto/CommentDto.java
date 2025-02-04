package com.example.OpenForumServer.domain.comment.dto;

import com.example.OpenForumServer.controller.forum.request.CommentRequest;
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
    private final Integer depth;
    private final String parentCommentUser;

    public static CommentDto fromRequest(CommentRequest req) {
        return new CommentDto(
                req.getContent(),
                req.getUpdatedAt(),
                req.getUserName(),
                req.getDepth(),
                req.getParentCommentUser()
        );
    }

    public GetCommentResponseItem toResponse() {
        return GetCommentResponseItem.builder()
                .content(this.content)
                .updatedAt(this.updatedAt)
                .userName(this.userName)
                .depth(this.depth)
                .parentCommentUser(this.parentCommentUser)
                .build();
    }

    public Comment toEntity(Forum forum, User user, Integer depth, Comment parentComment) {
        return Comment.builder()
                .content(this.content)
                .forum(forum)
                .user(user)
                .depth(depth)
                .parentComment(parentComment)
                .build();
    }

    public static CommentDto fromEntity(Comment comment) {
        String parentUserName = comment.getParentComment() != null
                ? comment.getParentComment().getUser().getName()
                : null;
        return new CommentDto(
                comment.getContent(),
                comment.getUpdatedAt(),
                comment.getUser().getName(),
                comment.getDepth(),
                parentUserName
        );
    }
}
