package com.example.OpenForumServer.domain.forum.repository.custom;

import com.example.OpenForumServer.domain.forum.entity.QForum;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ForumRepositoryImpl implements ForumRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QForum qForum = QForum.forum;

    public void increaseCommentCount(Long id) {
        jpaQueryFactory
            .update(qForum)
            .set(qForum.commentCount, qForum.commentCount.add(1))
            .where(qForum.id.eq(id))
            .execute();
    }

    public void decreaseCommentCount(Long id) {
        jpaQueryFactory
                .update(qForum)
                .set(qForum.commentCount, qForum.commentCount.subtract(1))
                .where(qForum.id.eq(id))
                .execute();
    }
}
