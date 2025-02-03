package com.example.OpenForumServer.domain.comment.repository;

import com.example.OpenForumServer.domain.comment.entity.Comment;
import com.example.OpenForumServer.domain.comment.repository.custom.CommentRepositoryCustom;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long>, CommentRepositoryCustom {
    List<Comment> findAllByForumId(Long forumId);
}
