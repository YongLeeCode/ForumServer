package com.example.OpenForumServer.controller.response;

import lombok.Getter;

@Getter
public class StandardResponse<T> {
    T data;
    String message;

    public StandardResponse(T data, String message) {
        this.data = data;
        this.message = message;
    }
}
