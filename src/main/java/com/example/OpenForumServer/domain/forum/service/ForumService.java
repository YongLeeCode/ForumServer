package com.example.OpenForumServer.domain.forum.service;

import com.example.OpenForumServer.domain.forum.dto.ForumDto;

public interface ForumService {
    String createForum(Long userId, ForumDto forumDto);
}
