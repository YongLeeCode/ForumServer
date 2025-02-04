package com.example.OpenForumServer.domain.comment.repository.custom;

import com.example.OpenForumServer.domain.comment.entity.Comment;
import com.example.OpenForumServer.domain.comment.entity.QComment;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CommentRepositoryImpl implements CommentRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private final QComment qComment = QComment.comment;

    @Override
    public List<Comment> findAllByForumId(Long forumId) {
        return jpaQueryFactory
                .selectFrom(qComment)
                .where(qComment.forum.id.eq(forumId))
                .orderBy(qComment.parentComment.id.desc(), qComment.createdAt.asc())
                .fetch();
    }
}
