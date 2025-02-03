package com.example.OpenForumServer.controller.like;

import com.example.OpenForumServer.controller.like.request.LikeRequest;
import com.example.OpenForumServer.controller.like.response.LikeResponse;
import com.example.OpenForumServer.controller.response.StandardResponse;
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
    public StandardResponse<String> selectLikeButton(@RequestBody LikeRequest req) {
        LikeDto dto = LikeDto.fromReq(req);
        String result = likeService.addLike(dto);
        return new StandardResponse<>(result, "성공");
    }

    @RequestMapping(value = "/like" , method = RequestMethod.DELETE)
    public StandardResponse<String> deleteLike(@RequestBody LikeRequest req) {
        LikeDto dto = LikeDto.fromReq(req);
        String result = likeService.deleteLike(dto);
        return new StandardResponse<>(result, "성공");
    }

    @RequestMapping(value = "/like", method = RequestMethod.GET)
    public StandardResponse<LikeResponse> getLikeResult(@RequestBody LikeRequest req) {
        LikeDto dto = LikeDto.fromReq(req);
        boolean result = likeService.getLikeResult(dto);
        LikeResponse res = new LikeResponse(result);
        return new StandardResponse<>(res, "성공");
    }
}
