package com.example.OpenForumServer.domain.like.repository;

import com.example.OpenForumServer.domain.forum.entity.Forum;
import com.example.OpenForumServer.domain.like.entity.Like;
import com.example.OpenForumServer.domain.user.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
    Optional<Like> findByUserAndForum(User user, Forum forum);
}
