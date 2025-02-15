package com.example.OpenForumServer.domain.like.service;

import com.example.OpenForumServer.domain.forum.entity.Forum;
import com.example.OpenForumServer.domain.forum.repository.ForumRepository;
import com.example.OpenForumServer.domain.like.dto.LikeDto;
import com.example.OpenForumServer.domain.like.entity.Like;
import com.example.OpenForumServer.domain.like.repository.LikeRepository;
import com.example.OpenForumServer.domain.user.entity.User;
import com.example.OpenForumServer.domain.user.repository.UserRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class LikeServiceImpl implements LikeService {

    private final LikeRepository likeRepository;
    private final UserRepository userRepository;
    private final ForumRepository forumRepository;

    public String addLike(LikeDto likeDto) {
        User user = userRepository.findById(likeDto.getUser())
                .orElseThrow(() -> new IllegalArgumentException("Could not found user"));
        Forum forum = forumRepository.findById(likeDto.getForum())
                .orElseThrow(() -> new IllegalArgumentException("Could not found forum"));;
        Optional<Like> likeOptional = likeRepository.findByUserAndForum(user, forum);
        if (likeOptional.isEmpty()) {
            likeRepository.save(new Like(user, forum));
            return "생성";
        }
        return "이미 완료된 좋아요 post 요청";
    }

    public String deleteLike(LikeDto likeDto) {
        User user = userRepository.findById(likeDto.getUser())
                .orElseThrow(() -> new IllegalArgumentException("Could not found user"));
        Forum forum = forumRepository.findById(likeDto.getForum())
                .orElseThrow(() -> new IllegalArgumentException("Could not found forum"));;
        Optional<Like> likeOptional = likeRepository.findByUserAndForum(user, forum);
        if (likeOptional.isPresent()) {
            likeRepository.deleteById(likeOptional.get().getId());
            return "삭제 성공";
        }
        return "이미 완료된 삭제 요청";
    }

    public boolean getLikeResult(LikeDto likeDto) {
        User user = userRepository.findById(likeDto.getUser())
                .orElseThrow(() -> new IllegalArgumentException("Could not found user"));
        Forum forum = forumRepository.findById(likeDto.getForum())
                .orElseThrow(() -> new IllegalArgumentException("Could not found forum"));
        Optional<Like> likeOptional = likeRepository.findByUserAndForum(user, forum);
        return likeOptional.isPresent();
    }
}
