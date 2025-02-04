package com.example.OpenForumServer.domain.comment.service;

import com.example.OpenForumServer.controller.forum.response.GetCommentResponseItem;
import com.example.OpenForumServer.domain.comment.dto.CommentDto;
import java.util.List;

public interface CommentService {
    void createComment(Long forumId, Long userId, CommentDto commentDto);

    void createNestedComment(Long forumId, Long userId, Long parentCommentId, CommentDto dto);

    String updateComment(Long forumId, Long commentId, Long userId, CommentDto req);

    List<CommentDto> findAllByForum(Long forumId);

    String deleteComment(Long forumId, Long commentId, Long userId);
}
