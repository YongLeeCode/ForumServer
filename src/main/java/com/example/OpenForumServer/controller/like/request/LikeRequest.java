package com.example.OpenForumServer.controller.like.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class LikeRequest {
    private final Long user;
    private final Long forum;
}
