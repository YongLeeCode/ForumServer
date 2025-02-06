package com.example.OpenForumServer.domain.forum.service;

import com.example.OpenForumServer.controller.forum.request.UpdateForumRequest;
import com.example.OpenForumServer.domain.forum.dto.ForumDto;
import com.example.OpenForumServer.domain.forum.entity.Forum;
import com.example.OpenForumServer.domain.forum.repository.ForumRepository;
import com.example.OpenForumServer.domain.user.entity.User;
import com.example.OpenForumServer.domain.user.exception.UserNotFoundException;
import com.example.OpenForumServer.domain.user.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ForumServiceImpl implements ForumService {

    private final ForumRepository forumRepository;
    private final UserRepository userRepository;

    public List<ForumDto> getAllForum() {
        List<ForumDto> forumDtos = new ArrayList<>();

        Pageable pageable = PageRequest.of(0, 10, Sort.by("createdAt").descending());
        Page<Forum> pageResponse = forumRepository.findAll(pageable);

        for(int i = 0; i < pageResponse.getTotalPages(); i++) {
            forumDtos.add(ForumDto.fromEntity(pageResponse.getContent().get(i)));
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
                .orElseThrow(() -> new UserNotFoundException("Not found user"));
        forumRepository.save(dto.toEntity(user));
        return "success";
    }

    public String updateForumById(Long forumId, Long userId, UpdateForumRequest req) {
        Forum forum = forumRepository.findById(forumId).orElseThrow(() -> new IllegalArgumentException("there is no forum id"));
        if(userId.equals(forum.getUser().getId())) {
            return "유저 정보가 잘 못 된거 같아요.";
        }
        forum.setTitle(req.getTitle());
        forum.setContent(req.getContent());
        return "Success";
    }

    public String deleteForumById(Long forumId, Long userId) {
        Forum forum = forumRepository.findById(forumId)
                .orElseThrow(() -> new IllegalArgumentException("Not found user"));
        if (userId.equals(forum.getUser().getId())) {
            return "게시물을 만든 본인이 아니네요.";
        }

        forumRepository.deleteById(forum.getId());
        return "삭제 성공";
    }
}
