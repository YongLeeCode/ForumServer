package com.example.OpenForumServer.domain.forum.service;

import com.example.OpenForumServer.controller.forum.request.UpdateForumRequest;
import com.example.OpenForumServer.controller.forum.response.GetForumResponse;
import com.example.OpenForumServer.controller.forum.response.GetForumResponseItem;
import com.example.OpenForumServer.domain.forum.dto.ForumDto;
import com.example.OpenForumServer.domain.forum.entity.Forum;
import com.example.OpenForumServer.domain.forum.repository.ForumRepository;
import com.example.OpenForumServer.domain.user.entity.User;
import com.example.OpenForumServer.domain.user.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ForumServiceImpl implements ForumService {

    private final ForumRepository forumRepository;
    private final UserRepository userRepository;

    public List<ForumDto> getAllForum() {
        List<Forum> forums = forumRepository.findAll();
        List<ForumDto> forumDtos = new ArrayList<>();
        for(Forum forum : forums) {
            forumDtos.add(ForumDto.fromEntity(forum));
        }
        return forumDtos;
    }

    public ForumDto getForumById(Long id) {
        Forum forum = forumRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("no forum"));
        return ForumDto.fromEntity(forum);
    }

    public String createForum(Long userId, ForumDto dto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Not found user"));
        forumRepository.save(dto.toEntity(user));
        return "success";
    }

    public String updateForumById(Long forumId, Long userId, UpdateForumRequest req) {
        Forum forum = forumRepository.findById(forumId).orElseThrow(() -> new IllegalArgumentException("there is no forum id"));
        if(userId != forum.getUser().getId()) {
            return "유저 정보가 잘 못 된거 같아요.";
        }
        forum.setTitle(req.getTitle());
        forum.setContent(req.getContent());
        return "Success";
    }

    public String deleteForumById(Long forumId, Long userId) {
        Forum forum = forumRepository.findById(forumId)
                .orElseThrow(() -> new IllegalArgumentException("Not found user"));
        if (forum.getUser().getId() != userId) {
            return "게시물을 만든 본인이 아니네요.";
        }

        forumRepository.deleteById(forum.getId());
        return "삭제 성공";
    }
}
