package com.example.OpenForumServer.domain.comment.repository;

import com.example.OpenForumServer.domain.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
