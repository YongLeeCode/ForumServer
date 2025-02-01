package com.example.OpenForumServer.controller.response;

public class StandardResponse<T> {
    T data;
    String message;

    public StandardResponse(T data, String message) {
        this.data = data;
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }
}
