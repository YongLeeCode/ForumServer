package com.example.OpenForumServer.domain.forum.service;

import com.example.OpenForumServer.controller.forum.request.UpdateForumRequest;
import com.example.OpenForumServer.controller.forum.response.GetForumResponseItem;
import com.example.OpenForumServer.domain.forum.dto.ForumDto;
import java.util.List;

public interface ForumService {
    String createForum(Long userId, ForumDto forumDto);

    List<ForumDto> getAllForum();

    ForumDto getForumById(Long id);

    String updateForumById(Long forumId, Long userId, UpdateForumRequest req);

    String deleteForumById(Long forumId, Long userId);
}
