package com.example.OpenForumServer.domain.comment.repository.custom;

import com.example.OpenForumServer.domain.comment.entity.Comment;
import java.util.List;

public interface CommentRepositoryCustom {
    List<Comment> findAllByForumId(Long forumId);
}
