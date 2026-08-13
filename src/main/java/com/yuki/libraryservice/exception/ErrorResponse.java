package com.yuki.libraryservice.exception;

import java.util.Map;

public record ErrorResponse(
        String timestamp,
        int status,
        String error,
        String path,
        String message,
        Map<String, String> errors
) {
}