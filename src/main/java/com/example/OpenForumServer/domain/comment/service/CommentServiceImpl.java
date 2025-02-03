package com.example.OpenForumServer.domain.comment.service;

import com.example.OpenForumServer.domain.comment.dto.CommentDto;
import com.example.OpenForumServer.domain.comment.entity.Comment;
import com.example.OpenForumServer.domain.comment.repository.CommentRepository;
import com.example.OpenForumServer.domain.forum.entity.Forum;
import com.example.OpenForumServer.domain.forum.repository.ForumRepository;
import com.example.OpenForumServer.domain.user.entity.User;
import com.example.OpenForumServer.domain.user.repository.UserRepository;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final ForumRepository forumRepository;


    public void createComment(Long forumId, Long userId, CommentDto dto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Not found user"));
        Forum forum = forumRepository.findById(forumId)
                .orElseThrow(() -> new IllegalArgumentException("Not found user"));
        commentRepository.save(dto.toEntity(forum, user));
    }

    public String updateComment(Long forumId, Long commentId, Long userId, CommentDto req) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("Not found user"));
        if (!Objects.equals(comment.getUser().getId(), userId)) {
            return "커멘트를 작성한 유저가 아닙니다.";
        }
        if (!Objects.equals(comment.getForum().getId(), forumId)) {
            return "잘못된 포럼에 댓글이 달렸나?";
        }
        comment.setContent(req.getContent());
        return "성공적으로 컨텐츠가 업데이트 되었다.";
    }

    public List<CommentDto> findAllByForum(Long forumId) {
        return commentRepository.findAllByForumId(forumId)
                .stream()
                .map(CommentDto::fromEntity)
                .toList();
    }

    public String deleteComment(Long forumId, Long commentId, Long userId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("not found comment id"));
        if(!Objects.equals(comment.getUser().getId(), userId)) {
            return "이 댓글을 작성한 유저가 아니기 때문에 삭제를 실패했습니다.";
        }
        if(!Objects.equals(comment.getForum().getId(), forumId)) {
            return "이 댓글과 포럼이 매칭에 실패했습니다.";
        }
        commentRepository.deleteById(comment.getId());
        return "삭제 성공";
    }
}
