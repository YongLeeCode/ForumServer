package com.example.OpenForumServer.controller.forum;

import com.example.OpenForumServer.controller.forum.request.CommentCreatorRequest;
import com.example.OpenForumServer.controller.forum.request.ForumCreatorRequest;
import com.example.OpenForumServer.controller.forum.request.UpdateForumRequest;
import com.example.OpenForumServer.controller.forum.response.GetCommentResponse;
import com.example.OpenForumServer.controller.forum.response.GetCommentResponseItem;
import com.example.OpenForumServer.controller.forum.response.GetForumResponse;
import com.example.OpenForumServer.controller.forum.response.GetForumResponseItem;
import com.example.OpenForumServer.controller.response.StandardResponse;
import com.example.OpenForumServer.domain.comment.dto.CommentDto;
import com.example.OpenForumServer.domain.comment.service.CommentService;
import com.example.OpenForumServer.domain.forum.dto.ForumDto;
import com.example.OpenForumServer.domain.forum.service.ForumService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public String createForum(@RequestParam Long userId, @RequestBody ForumCreatorRequest req) {
        ForumDto dto = ForumDto.fromRequest(req);
        return forumService.createForum(userId, dto);
    }

    @RequestMapping(value = "/forum", method = RequestMethod.GET)
    public ResponseEntity<StandardResponse<GetForumResponse>> getForum(
            @RequestParam(required = false) Long id) {
        List<ForumDto> dtos = (id != null)
                ? List.of(forumService.getForumById(id))
                : forumService.getAllForum();

        List<GetForumResponseItem> items = dtos.stream()
                .map(ForumDto::toResponse)
                .collect(Collectors.toList());

        GetForumResponse res = new GetForumResponse(items, items.size());
        return ResponseEntity.status(HttpStatus.OK).body(new StandardResponse<>(res, "성공"));
    }

    @RequestMapping(value = "/forum/{id}", method = RequestMethod.PUT)
    public ResponseEntity<StandardResponse<String>> updateForum(
            @PathVariable(value = "id") Long forumId,
            @RequestParam Long userId,
            @RequestBody UpdateForumRequest req
    ) {
        String result = forumService.updateForumById(forumId, userId, req);
        return ResponseEntity.status(HttpStatus.OK).body(new StandardResponse<>(result, "성공"));
    }

    @RequestMapping(value = "/forum/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<StandardResponse<String>> deleteForum(
            @PathVariable(value = "id") Long forumId,
            @RequestParam Long userId
    ) {
        String result = forumService.deleteForumById(forumId, userId);
        return ResponseEntity.status(HttpStatus.OK).body(new StandardResponse<>(result, "성공"));
    }

    // comments APIs
    @RequestMapping(value = "/forum/{forumId}/comment", method = RequestMethod.POST)
    public String createComment(@PathVariable Long forumId, @RequestParam Long userId, @RequestBody CommentCreatorRequest req) {
        CommentDto dto = CommentDto.fromRequest(req);
        commentService.createComment(forumId, userId, dto);
        return "Success";
    }

    @RequestMapping(value = "/forum/{forumId}/comment/{commentId}", method = RequestMethod.PUT)
    public StandardResponse<String> updateComment(@PathVariable Long forumId, @PathVariable Long commentId,
            @RequestParam Long userId, @RequestBody CommentDto req) {
        String result = commentService.updateComment(forumId, commentId, userId, req);
        return new StandardResponse<>(result, "성공");
    }

    @RequestMapping(value = "/forum/{forumId}/comment", method = RequestMethod.GET)
    public StandardResponse<GetCommentResponse> getComments(@PathVariable Long forumId) {
        List<CommentDto> dtos = commentService.findAllByForum(forumId);
        List<GetCommentResponseItem> comments = dtos.stream().map(CommentDto::toResponse).toList();
        GetCommentResponse res = new GetCommentResponse(comments, comments.size());
        return new StandardResponse<>(res, "성공");
    }

    @RequestMapping(value = "/forum/{forumId}/comment/{commentId}", method = RequestMethod.DELETE)
    public StandardResponse<String> deleteComment(@PathVariable Long forumId, @PathVariable Long commentId,
            @RequestParam Long userId) {
        String result = commentService.deleteComment(forumId, commentId, userId);
        return new StandardResponse<>(result, "결과는?");
    }
}
