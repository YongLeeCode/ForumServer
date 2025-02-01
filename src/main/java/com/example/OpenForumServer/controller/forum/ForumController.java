package com.example.OpenForumServer.controller.forum;

import com.example.OpenForumServer.domain.comment.dto.CommentDto;
import com.example.OpenForumServer.domain.comment.service.CommentService;
import com.example.OpenForumServer.domain.forum.dto.ForumDto;
import com.example.OpenForumServer.domain.forum.service.ForumService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ForumController {

    private final ForumService forumService;
    private final CommentService commentService;

    // forums APIs
    @RequestMapping(value = "/forum", method = RequestMethod.POST)
    public String createForum(@RequestParam Long userId, @RequestBody ForumDto req) {
        return forumService.createForum(userId, req);
    }

    // comments APIs
    @RequestMapping(value = "/forum/{forumId}/comment", method = RequestMethod.POST)
    public String createComment(@PathVariable Long forumId, @RequestParam Long userId, @RequestBody CommentDto req) {
        System.out.println("forumId: " + forumId);  // 로그로 값 확인
        System.out.println("CommentDto: " + req);
        commentService.createComment(forumId, userId, req);
        return "Success";
    }
}
