package com.example.OpenForumServer.controller.user;

import com.example.OpenForumServer.controller.response.StandardResponse;
import com.example.OpenForumServer.controller.user.request.UserRequest;
import com.example.OpenForumServer.controller.user.response.GetUserResponse;
import com.example.OpenForumServer.controller.user.response.GetUserResponseItem;
import com.example.OpenForumServer.domain.user.dto.UserDto;
import com.example.OpenForumServer.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<StandardResponse<String>> createUser(@RequestBody UserRequest req) {
        UserDto dto = UserDto.fromRequest(req);
        userService.createUser(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new StandardResponse<>("새로운 유저가 등록되었습니다.", "성공"));
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<StandardResponse<GetUserResponse>> getUserById(@RequestParam Long id) {
        UserDto dto = userService.getUserById(id);
        GetUserResponseItem item = new GetUserResponseItem(dto.getName(), dto.getEmail(), dto.getCreatedAt());
        GetUserResponse user = new GetUserResponse(item, 1);
        return ResponseEntity.status(HttpStatus.OK).body(new StandardResponse<>(user, "성공"));
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public ResponseEntity<StandardResponse<String>> updateUser(@RequestParam Long id,
            @RequestBody UserRequest req) {
        UserDto dto = UserDto.fromRequest(req);
        String result = userService.updateUser(id, dto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new StandardResponse<>(result, "성공"));
    }

    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public ResponseEntity<StandardResponse<String>> deleteUser(@RequestParam Long id) {
        String result = userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).body(new StandardResponse<>(result, "성공"));
    }
}
