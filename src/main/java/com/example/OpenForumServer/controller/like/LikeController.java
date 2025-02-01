package com.example.OpenForumServer.controller.like;

import com.example.OpenForumServer.domain.like.dto.LikeDto;
import com.example.OpenForumServer.domain.like.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;

    @RequestMapping(value = "/like" , method = RequestMethod.POST)
    public String selectLikeButton(@RequestBody LikeDto req) {
        return likeService.actLikeButton(req);
    }

    @RequestMapping(value = "/like" , method = RequestMethod.DELETE)
    public String deleteLike(@RequestBody LikeDto req) {
        return likeService.deleteLike(req);
    }
}
