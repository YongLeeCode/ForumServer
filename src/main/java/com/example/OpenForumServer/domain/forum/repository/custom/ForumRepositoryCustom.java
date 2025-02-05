package com.example.OpenForumServer.domain.forum.repository.custom;

public interface ForumRepositoryCustom {
    void increaseCommentCount(Long id);

    void decreaseCommentCount(Long id);
}
