package com.example.OpenForumServer.domain.comment.service;

import com.example.OpenForumServer.domain.comment.dto.CommentDto;
import com.example.OpenForumServer.domain.comment.entity.Comment;
import com.example.OpenForumServer.domain.comment.repository.CommentRepository;
import com.example.OpenForumServer.domain.forum.entity.Forum;
import com.example.OpenForumServer.domain.forum.repository.ForumRepository;
import com.example.OpenForumServer.domain.user.entity.User;
import com.example.OpenForumServer.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final ForumRepository forumRepository;

    @Transactional
    public void createComment(Long forumId, Long userId, CommentDto dto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Not found user"));
        Forum forum = forumRepository.findById(forumId)
                .orElseThrow(() -> new IllegalArgumentException("Not found user"));
        commentRepository.save(dto.toEntity(forum, user));
    }
}
