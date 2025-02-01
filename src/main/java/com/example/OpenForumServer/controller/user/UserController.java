package com.example.OpenForumServer.controller.user;

//import com.example.OpenForum.domain.user.service.UserService;
//import com.example.OpenForum.domain.user.userDto.UserDto;
import com.example.OpenForumServer.domain.user.dto.UserDto;
import com.example.OpenForumServer.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String createUser(@RequestBody UserDto req) {
        userService.createUser(req);
        return "success";
    }
}
