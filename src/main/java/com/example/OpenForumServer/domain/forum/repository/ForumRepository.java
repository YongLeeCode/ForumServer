package com.example.OpenForumServer.domain.forum.repository;
import com.example.OpenForumServer.domain.forum.entity.Forum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForumRepository extends JpaRepository<Forum, Long> {

}
