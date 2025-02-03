package com.example.OpenForumServer.domain.like.dto;

import com.example.OpenForumServer.controller.like.request.LikeRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class LikeDto {
    private final Long user;
    private final Long forum;

    public static LikeDto fromReq (LikeRequest req) {
        return new LikeDto(req.getUser(), req.getForum());
    }
}
