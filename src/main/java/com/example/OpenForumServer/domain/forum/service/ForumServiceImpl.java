package com.example.OpenForumServer.domain.forum.service;

import com.example.OpenForumServer.domain.forum.dto.ForumDto;
import com.example.OpenForumServer.domain.forum.repository.ForumRepository;
import com.example.OpenForumServer.domain.user.entity.User;
import com.example.OpenForumServer.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ForumServiceImpl implements ForumService {

    private final ForumRepository forumRepository;
    private final UserRepository userRepository;

    @Transactional
    public String createForum(Long userId, ForumDto dto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Not found user"));
        forumRepository.save(dto.toEntity(user));
        return "success";
    }
}
