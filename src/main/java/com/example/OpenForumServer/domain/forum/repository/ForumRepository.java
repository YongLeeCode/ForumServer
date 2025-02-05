package com.example.OpenForumServer.domain.forum.repository;
import com.example.OpenForumServer.domain.forum.entity.Forum;
import com.example.OpenForumServer.domain.forum.repository.custom.ForumRepositoryCustom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForumRepository extends JpaRepository<Forum, Long>, ForumRepositoryCustom {
    Page<Forum> findAll(Pageable pageable);
}
