package com.example.OpenForumServer.domain.comment.service;

import com.example.OpenForumServer.domain.comment.dto.CommentDto;

public interface CommentService {
    void createComment(Long forumId, Long userId, CommentDto commentDto);
}
