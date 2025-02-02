package com.example.OpenForumServer.domain.like.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class LikeDto {
    private final Long user;
    private final Long forum;
}
