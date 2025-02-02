package com.example.OpenForumServer.domain.like.service;

import com.example.OpenForumServer.domain.like.dto.LikeDto;

public interface LikeService {

    String actLikeButton(LikeDto likeDto);

    String deleteLike(LikeDto likeDto);
}
